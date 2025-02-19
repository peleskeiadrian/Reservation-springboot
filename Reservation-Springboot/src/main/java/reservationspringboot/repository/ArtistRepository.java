package reservationspringboot.repository;
import reservationspringboot.model.Artist;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findByLastname(String lastname);

    Artist findById(long id);
}



