package sk.adamkatrenic.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.adamkatrenic.model.Playlist;
import sk.adamkatrenic.model.Song;
import sk.adamkatrenic.service.PlaylistService;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAll() {
        return ResponseEntity.ok(playlistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getById(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Playlist> create(@Valid @RequestBody Playlist playlist) {
        return ResponseEntity.status(201).body(playlistService.save(playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playlistService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/songs")
    public ResponseEntity<Playlist> addSong(@PathVariable Long id,
                                            @RequestBody Song song) {
        return ResponseEntity.ok(playlistService.addSong(id, song));
    }
}
