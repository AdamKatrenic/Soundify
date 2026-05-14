package sk.adamkatrenic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username nesmie byť prázdne!")
    @Size(min = 3, max = 50, message = "Username musí mať 3-50 znakov!")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Heslo nemôže byť prázdne!")
    @Size(min = 6, message = "Heslo musí mať aspoň 6 znakov!")
    @Column(nullable = false)
    private String password;

    @Email(message = "Neplatný email formát!")
    @NotBlank(message = "Email nemôže byť prázdny!")
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public List<Playlist> getPlaylists() { return playlists; }
}