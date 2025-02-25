package reservationspringboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import reservationspringboot.model.Artist;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByLastname(String lastname);

    Artist findById(long id);
}



