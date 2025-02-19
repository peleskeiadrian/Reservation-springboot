package reservationspringboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import reservationspringboot.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);
    Optional<Location> findById(Long id);
}


