package reservationspringboot.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import reservationspringboot.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastname(String lastname);

    User findById(long id);
    User findByLogin(String login);
    User findByEmail(String email);
}


