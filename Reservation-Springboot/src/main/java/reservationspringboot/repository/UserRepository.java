package reservationspringboot.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import reservationspringboot.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByLogin(String login);
    List<User> findByLastname(String lastname);

    User findById(long id);
}

