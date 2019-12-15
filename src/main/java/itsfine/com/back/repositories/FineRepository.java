package itsfine.com.back.repositories;

import itsfine.com.back.entities.FineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<FineEntity, Long> {
}
