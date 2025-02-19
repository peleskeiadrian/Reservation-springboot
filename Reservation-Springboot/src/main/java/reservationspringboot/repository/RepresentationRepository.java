package reservationspringboot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import reservationspringboot.model.Location;
import reservationspringboot.model.Representation;
import reservationspringboot.model.Show;

public interface RepresentationRepository extends CrudRepository<Representation, Long> {
    List<Representation> findByShow(Show show);
    List<Representation> findByLocation(Location location);
    List<Representation> findByWhen(LocalDateTime when);
}


