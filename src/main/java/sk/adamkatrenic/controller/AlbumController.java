package sk.adamkatrenic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.adamkatrenic.model.Album;
import sk.adamkatrenic.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        return ResponseEntity.ok(albumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.findById(id));
    }

    @PostMapping
    public ResponseEntity <Album> create(@RequestBody Album album) {
        return ResponseEntity.status(201).body(albumService.save(album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.ok().build();
    }
}
