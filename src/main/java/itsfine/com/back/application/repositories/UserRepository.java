package itsfine.com.back.application.repositories;

import itsfine.com.back.application.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
