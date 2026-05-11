package sk.adamkatrenic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.adamkatrenic.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {


}