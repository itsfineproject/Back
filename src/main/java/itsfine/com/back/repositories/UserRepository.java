package itsfine.com.back.repositories;

import itsfine.com.back.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<UserEntity, Long> {
=======
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByTeudatZeut(long teudatZeut);
>>>>>>> models
}
