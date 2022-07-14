package toyProject.IT_BulletinBoard.config.auth2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
// 일회성 코드로 받아온 oauth token
public class OAuthToken {

    private String accessToken;
    private String expiresIn;
    private String idToken;
    private String refreshToken;
    private String scope;
    private String tokenType;
}
