package reservationspringboot.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="artists")
public class Artist {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String firstname;
  private String lastname;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
          name = "artist_type",
          joinColumns = @JoinColumn(name = "artist_id"),
          inverseJoinColumns = @JoinColumn(name = "type_id")
  )
  private Set<Type> types = new HashSet<>();

  protected Artist() {}

  public Artist(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }



  public Set<Type> getTypes() {
    return types;
  }

  public void addType(Type type) {
    this.types.add(type);
  }

  @Override
  public String toString() {
    return firstname + " " + lastname;
  }

}
