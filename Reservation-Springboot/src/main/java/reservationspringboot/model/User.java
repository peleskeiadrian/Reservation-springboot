package reservationspringboot.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    private String login;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String firstname;
    @Setter
    @Getter
    private String lastname;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String langue;
    @Setter
    private String role;
    private LocalDateTime created_at;

    protected User() {}

    public User(String login, String firstname, String lastname, String role) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.created_at = LocalDateTime.now();
    }

    public String getRole() {
        return langue;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    @Override
    public String toString() {
        return login + "(" + firstname + " " + lastname + " - " + role + ")";
    }
}
