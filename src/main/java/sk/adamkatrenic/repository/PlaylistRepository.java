package sk.adamkatrenic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.adamkatrenic.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}
