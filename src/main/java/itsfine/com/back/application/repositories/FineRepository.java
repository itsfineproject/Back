package itsfine.com.back.application.repositories;

import itsfine.com.back.application.entities.FineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<FineEntity, Long> {
}
