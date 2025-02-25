package reservationspringboot.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reservationspringboot.model.Artist;
import reservationspringboot.repository.ArtistRepository;

@RestController
@RequestMapping("/api")
public class ArtistApiController {

    private final ArtistRepository repository;

    public ArtistApiController(ArtistRepository repository) {
        this.repository = repository;
    }

    // GET all artists
    @GetMapping("/artists")
    public List<Artist> all() {
        return (List<Artist>) repository.findAll();
    }

    // GET a single artist
    @GetMapping("/artists/{id}")
    public Artist one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }


    // POST a new artist
    @PostMapping("/admin/artists")
    public Artist newArtist(@RequestBody Artist newArtist) {
        return repository.save(newArtist);
    }

    // PUT (update) an artist
    @PutMapping("/admin/artists/{id}")
    public Artist replaceArtist(@RequestBody Artist newArtist,
                                @PathVariable Long id) {
        return repository.findById(id)
                .map(artist -> {
                    artist.setFirstname(newArtist.getFirstname());
                    artist.setLastname(newArtist.getLastname());
                    return repository.save(artist);
                })
                .orElseGet(() -> {
                    newArtist.setId(id);
                    return repository.save(newArtist);
                });
    }

    // DELETE an artist
    @DeleteMapping("/admin/artists/{id}")
    public void deleteArtist(@PathVariable Long id) {
        repository.deleteById(id);
    }
}