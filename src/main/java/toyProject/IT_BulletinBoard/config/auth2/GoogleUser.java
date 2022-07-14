package toyProject.IT_BulletinBoard.config.auth2;

import lombok.Getter;
import lombok.Setter;
import toyProject.IT_BulletinBoard.domain.user.User;

@Getter
// access token으로 구글 사용자 정보를 얻는데, 그 사용자 정보에 대한 클래스
public class GoogleUser {

    public String id;
    public String email;
    public Boolean verifiedEmail;
    public String name;
    public String givenName;
    public String familyName;
    public String picture;
    public String locale;
    public String password;

    public User toUser(String accessToken) {
        return new User(id,email, name, accessToken);
    }
}
