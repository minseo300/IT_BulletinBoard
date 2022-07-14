package toyProject.IT_BulletinBoard.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name="userIdx")
    private Long idx;

    private String id;
    private String picture;
    private String email;
    // private String password;
    private String accessToken;
    private String refreshToken;
    private String name;
    private String provider;
    private String provider_id;
    private Role role;

    public User(String id, String email,String name,String accessToken){
        this.id=id;
       // this.password=password;
        this.email=email;
        this.name=name;
        this.accessToken=accessToken;
    }


}
