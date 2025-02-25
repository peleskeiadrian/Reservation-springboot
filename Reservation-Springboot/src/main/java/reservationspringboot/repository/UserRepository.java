package reservationspringboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import reservationspringboot.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findByLastname(String lastname);

    User findById(long id);
    User findByLogin(String login);
    User findByEmail(String email);
}




