package toyProject.IT_BulletinBoard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toyProject.IT_BulletinBoard.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    //User findByEmail(String email);
}
