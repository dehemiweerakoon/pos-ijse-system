package lk.ijse.pos.Repository;

import lk.ijse.pos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // custom queries
    Optional<User> findByusername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
