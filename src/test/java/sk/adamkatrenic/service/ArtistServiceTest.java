package sk.adamkatrenic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sk.adamkatrenic.exception.ResourceNotFoundException;
import sk.adamkatrenic.model.Artist;
import sk.adamkatrenic.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository repository;

    @InjectMocks
    private ArtistService artistService;

    @Test
    void findAll_shouldReturnAllArtists() {
        List<Artist> artists = List.of(
                new Artist("The Weeknd", "RnB"),
                new Artist("Drake", "Hip-Hop")
        );
        when(repository.findAll()).thenReturn(artists);

        List<Artist> result = artistService.findAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findById_shouldReturnArtist_whenExists() {
        Artist artist = new Artist("The Weeknd", "RnB");
        when(repository.findById(1L)).thenReturn(Optional.of(artist));

        Artist result = artistService.findById(1L);

        assertNotNull(result);
        assertEquals("The Weeknd", result.getName());
    }

    @Test
    void findById_shouldThrowException_whenNotExists() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            artistService.findById(99L);
        });
    }

    @Test
    void save_shouldReturnSavedArtist() {
        Artist artist = new Artist("The Weeknd", "RnB");
        when(repository.save(artist)).thenReturn(artist);

        Artist result = artistService.save(artist);

        assertNotNull(result);
        assertEquals("The Weeknd", result.getName());
        verify(repository, times(1)).save(artist);
    }
}