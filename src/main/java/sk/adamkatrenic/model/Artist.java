package sk.adamkatrenic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Meno umelca nemôže byť prázdne!")
    @Size(min = 2, max = 100, message = "Meno musí mať 2-100 znakov!")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Žáner nemôže byť prázdny!")
    @Column
    private String genre;

    @JsonManagedReference
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