package toyProject.IT_BulletinBoard.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="test")
@Getter @Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue
    @Column(name="articleId")
    private Long id;

    private String articleTitle;
}
