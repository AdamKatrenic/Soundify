package sk.adamkatrenic.service;

import org.springframework.stereotype.Service;
import sk.adamkatrenic.model.Artist;
import sk.adamkatrenic.model.Song;
import sk.adamkatrenic.repository.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public List<Song> findAll() {
        return repository.findAll();
    }

    public Optional<Song> findById(Long id) {
        return repository.findById(id);
    }

    public Song save(Song song) {
        return repository.save(song);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
