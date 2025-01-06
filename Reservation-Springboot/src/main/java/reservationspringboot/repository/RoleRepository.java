package reservationspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import reservationspringboot.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}

