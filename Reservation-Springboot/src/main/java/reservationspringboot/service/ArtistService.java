package reservationspringboot.service;

import java.util.ArrayList;
import java.util.List;

import reservationspringboot.model.Artist;
import reservationspringboot.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();

        artistRepository.findAll().forEach(artists::add);

        return artists;
    }

    public List<Artist> findAll() {
        return (List<Artist>) artistRepository.findAll();
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }



public Artist getArtist(long id) {
        return artistRepository.findById(id);
    }

    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    public void updateArtist(String id, Artist artist) {
        artistRepository.save(artist);
    }

    public void deleteArtist(long id) {
        artistRepository.deleteById(id);
    }
}



