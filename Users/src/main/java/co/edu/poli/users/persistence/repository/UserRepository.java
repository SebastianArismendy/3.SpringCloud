package co.edu.poli.users.persistence.repository;

import co.edu.poli.users.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
