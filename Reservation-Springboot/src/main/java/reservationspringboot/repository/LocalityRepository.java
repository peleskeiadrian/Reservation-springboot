package reservationspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import reservationspringboot.model.Locality;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
    Locality findByPostalCode(String postalCode);
    Locality findByLocality(String locality);
}

