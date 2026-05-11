package sk.adamkatrenic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.adamkatrenic.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

}
