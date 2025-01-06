package reservationspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reservationspringboot.model.Role;
import reservationspringboot.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;


    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();

        repository.findAll().forEach(roles::add);

        return roles;
    }

    public Role get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Role> role = repository.findById(indice);

        return role.isPresent() ? role.get() : null;
    }

    public void add(Role role) {
        repository.save(role);
    }

    public void update(String id, Role role) {
        repository.save(role);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);

        repository.deleteById(indice);
    }
}

