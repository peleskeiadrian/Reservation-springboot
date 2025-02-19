package reservationspringboot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import reservationspringboot.model.Location;
import reservationspringboot.model.Show;

public interface ShowRepository extends CrudRepository<Show, Long> {
    Show findBySlug(String slug);
    Show findByTitle(String title);
    List<Show> findByLocation(Location location);
}


