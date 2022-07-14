package toyProject.IT_BulletinBoard.config.auth2;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import toyProject.IT_BulletinBoard.domain.user.User;
import toyProject.IT_BulletinBoard.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private Logger logger= LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final GoogleOauth oauthService;
    private final JwtTokenProvider jwtTokenProvider;

    public String oauthLogin(String code)  {
        ResponseEntity<String> accessTokenResponse = oauthService.requestAccessToken(code);
        OAuthToken oAuthToken = oauthService.getAccessToken(accessTokenResponse);
        logger.info("Access Token: {}", oAuthToken.getAccessToken());

        ResponseEntity<String> userInfoResponse = oauthService.createGetRequest(oAuthToken);
        logger.info("userInfoResponse: {}",userInfoResponse);
        GoogleUser googleUser = oauthService.getUserInfo(userInfoResponse);
        logger.info("Google User Name: {}", googleUser.getName());
        logger.info("Google User Email: {}", googleUser.getEmail());


        if (!isJoinedUser(googleUser)) {
            signUp(googleUser, oAuthToken);
        }
        User user = userRepository.findByEmail(googleUser.getEmail()).orElseThrow(IllegalArgumentException::new);
        String jwtToken=jwtTokenProvider.createToken(user.getIdx());
        logger.info("jwtToken:{}",jwtToken);
        return jwtToken;
    }

    private boolean isJoinedUser(GoogleUser googleUser) {
        Optional<User> users = userRepository.findByEmail(googleUser.getEmail());
        logger.info("Joined User: {}", users);
        return users.isPresent();
    }

    private void signUp(GoogleUser googleUser, OAuthToken oAuthToken) {
        User user = googleUser.toUser(oAuthToken.getAccessToken());
        userRepository.save(user);
    }

}
