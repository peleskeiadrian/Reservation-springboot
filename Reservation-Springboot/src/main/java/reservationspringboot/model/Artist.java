package reservationspringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@ToString
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The firstname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String firstname;

    @NotEmpty(message = "The lastname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String lastname;

    @ManyToMany(mappedBy = "artists")
    private List<ArtistType> types = new ArrayList<>();


    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Artist(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Artist() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Artist removeType(Type type) {
        if (this.types.contains(type)) {
            this.types.remove(type);
            type.getArtists().remove(this);
        }

        return this;
    }


    public List<ArtistType> getTypes() {
        return types;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Artist artist = (Artist) o;
        return getId() != null && Objects.equals(getId(), artist.getId());
    }

    public Object getId() {
        return id;
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
