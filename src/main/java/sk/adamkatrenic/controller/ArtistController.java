package sk.adamkatrenic.controller;

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
        return artistService.findById(id)
                .map(ResponseEntity::ok)                    // 200 OK ak existuje
                .orElse(ResponseEntity.notFound().build()); // 404 ak neexistuje
    }

    @PostMapping
    public ResponseEntity<Artist> create(@RequestBody Artist artist) {
        return ResponseEntity.status(201).body(artistService.save(artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok().build();
    }
}
