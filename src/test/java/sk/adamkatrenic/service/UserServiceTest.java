package sk.adamkatrenic.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import sk.adamkatrenic.model.User;
import sk.adamkatrenic.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void register_shouldSaveUser_whenUsernameNotExists() {
        String username = "newuser";
        User user = new User(username, "password","user@email.com");

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        userService.register(username, "password123", "user@email.com");

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void register_shouldThrowException_whenUsernameExists() {
        String username = "newuser";
        User user = new User(username, "password", "user@email.com");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        assertThrows(RuntimeException.class, () -> {
            userService.register(username, "password", "user@email.com");
        });

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void findByUsername_shouldReturnUser_whenExists() {
        String username = "newuser";
        User user = new User(username, "password", "user@email.com");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByUsername(username);

        assertNotNull(result);
        assertEquals("newuser", result.get().getUsername());
    }

    @Test
    void checkPassword_shouldReturnTrue_whenPasswordMatches() {
        // ARRANGE
        String rawPassword = "password123";
        String hashedPassword = "hashedPassword";
        when(passwordEncoder.matches(rawPassword, hashedPassword)).thenReturn(true);

        // ACT
        boolean result = userService.checkPassword(rawPassword, hashedPassword);

        // ASSERT
        assertTrue(result);
        verify(passwordEncoder, times(1)).matches(rawPassword, hashedPassword);
    }
}



















