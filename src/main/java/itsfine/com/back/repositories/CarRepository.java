package itsfine.com.back.repositories;

import itsfine.com.back.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    CarEntity findByCarNumber(String carNumber);
}

