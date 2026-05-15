package sk.adamkatrenic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private int duration;

    @Column
    private String audioUrl;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {}

    public Song(String title, int duration, String audioUrl, Album album) {
        this.title = title;
        this.duration = duration;
        this.audioUrl = audioUrl;
        this.album = album;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public String getAudioUrl() { return audioUrl; }
    public Album getAlbum() { return album; }
}