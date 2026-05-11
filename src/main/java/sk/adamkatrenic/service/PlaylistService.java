package sk.adamkatrenic.service;

import org.springframework.stereotype.Service;
import sk.adamkatrenic.model.Playlist;
import sk.adamkatrenic.model.Song;
import sk.adamkatrenic.repository.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository repository;


    public PlaylistService(PlaylistRepository repository) {
        this.repository = repository;
    }

    public List<Playlist> findAll() {
        return repository.findAll();
    }

    public Optional<Playlist> findById(Long id) {
        return repository.findById(id);
    }

    public Playlist save(Playlist playlist) {
        return repository.save(playlist);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Playlist addSong(Long playlistId, Song song) {
        Playlist playlist = repository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found!"));
        playlist.getSongs().add(song);
        return repository.save(playlist);
    }
}
