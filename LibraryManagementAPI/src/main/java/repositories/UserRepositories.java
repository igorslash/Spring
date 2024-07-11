package repositories;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {

    List<User> findByRole(String role);

    User findByUsername(String username);
}
