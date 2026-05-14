package sk.adamkatrenic.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.adamkatrenic.model.Song;
import sk.adamkatrenic.service.SongService;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAll() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.findById(id));
    }

    @PostMapping
    public ResponseEntity <Song> create(@Valid @RequestBody Song song) {
        return ResponseEntity.status(201).body(songService.save(song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.ok().build();
    }

}
