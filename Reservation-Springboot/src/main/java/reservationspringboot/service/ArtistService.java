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

    public Artist getArtist(long id) {
        int indice = Integer.parseInt(String.valueOf(id));

        return artistRepository.findById(indice);
    }

    public void addArtist(Artist artist) {
        artistRepository.save(artist);
    }

    public void updateArtist(String id, Artist artist) {
        artistRepository.save(artist);
    }

    public void deleteArtist(long id) {
        Long indice = (long) Integer.parseInt(String.valueOf(id));

        artistRepository.deleteById(indice);
    }
}



