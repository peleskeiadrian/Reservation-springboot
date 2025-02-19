package reservationspringboot.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reservationspringboot.enums.UserRole;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String langue;

    @Getter
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDateTime created_at;

    @ManyToMany(mappedBy = "users")
    private List<Representation> representations = new ArrayList<>();

    // Ajout de la relation avec Review
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservation;

    public User addRepresentation(Representation representation) {
        if(!this.representations.contains(representation)) {
            this.representations.add(representation);
            representation.addUser(this);
        }

        return this;
    }

    public User removeRepresentation(Representation representation) {
        if(this.representations.contains(representation)) {
            this.representations.remove(representation);
            representation.getUsers().remove(this);
        }

        return this;
    }

    public User addReview(Review review) {
        if (!this.reviews.contains(review)) {
            this.reviews.add(review);
            review.setUser(this);
        }
        return this;
    }

    public User removeReview(Review review) {
        if (this.reviews.contains(review)) {
            this.reviews.remove(review);
            review.setUser(null);
        }
        return this;
    }

    @Override
    public String toString() {
        return login + "(" + firstname + " " + lastname + " - " + role + ")";
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getLangue() {
        return langue;
    }

    public UserRole getRole() {
        return role;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }
}