package sk.adamkatrenic.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String genre;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;

    public Artist() {}

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }
    public List<Album> getAlbums() { return albums; }
}