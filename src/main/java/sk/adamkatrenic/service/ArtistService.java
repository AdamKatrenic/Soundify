package sk.adamkatrenic.service;

import org.springframework.stereotype.Service;
import sk.adamkatrenic.exception.ResourceNotFoundException;
import sk.adamkatrenic.model.Artist;
import sk.adamkatrenic.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository repository;

    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    public List<Artist> findAll() {
        return repository.findAll();      // ← return!
    }

    public Artist findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found with id: " + id));
    }

    public Artist save(Artist artist) {
        return repository.save(artist);   // ← vráť uloženého umelca s id
    }

    public void delete(Long id) {
        repository.deleteById(id);        // ← deleteById nie delete!
    }
}