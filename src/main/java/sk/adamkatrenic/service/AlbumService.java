package sk.adamkatrenic.service;

import org.springframework.stereotype.Service;
import sk.adamkatrenic.exception.ResourceNotFoundException;
import sk.adamkatrenic.model.Album;
import sk.adamkatrenic.repository.AlbumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository repository;


    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    public List<Album> findAll() {
        return repository.findAll();
    }

    public Album findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found with id: " + id));
    }

    public Album save(Album album) {
        return repository.save(album);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
