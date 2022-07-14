package toyProject.IT_BulletinBoard.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toyProject.IT_BulletinBoard.domain.user.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class MemberRepository {

    private final EntityManager em;

    public void save(User user){ em.persist(user);}

    public List<User> findByEmail(String email){
        return em.createQuery("select u from User u where u.email=:email",User.class)
                .setParameter("email",email)
                .getResultList();
    }

}
