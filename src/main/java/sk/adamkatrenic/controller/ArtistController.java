package sk.adamkatrenic.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.adamkatrenic.model.Artist;
import sk.adamkatrenic.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService service) {
        this.artistService = service;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAll() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Artist> create(@Valid @RequestBody Artist artist) {
        return ResponseEntity.status(201).body(artistService.save(artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok().build();
    }
}
