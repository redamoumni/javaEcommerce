package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setEmail("user1@example.com");
        user.setFullName("User One");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> found = userService.getUserById(1L);
        assertEquals("user1@example.com", found.get().getEmail());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(5L)).thenReturn(Optional.empty());

        Optional<User> found = userService.getUserById(5L);
        assertFalse(found.isPresent());
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> fetchedUsers = userService.getAllUsers();
        assertEquals(2, fetchedUsers.size());
    }

    @Test
    public void testCreateUser() {
        User newUser = new User();
        newUser.setEmail("newuser@example.com");
        newUser.setFullName("New User");

        // Simuler la sauvegarde de l'utilisateur avec un identifiant généré
        // automatiquement
        when(userRepository.save(newUser)).thenAnswer(invocation -> {
            User userToSave = invocation.getArgument(0);
            userToSave.setId(1L); // Simuler un identifiant généré automatiquement
            return userToSave;
        });

        // Appeler la méthode createUser
        User savedUser = userService.createUser(newUser);

        // Vérifier si l'utilisateur a été sauvegardé correctement
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId()); // Vérifier si l'identifiant a été défini
        assertEquals("newuser@example.com", savedUser.getEmail());
    }

    @Test
    public void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(3L);
        existingUser.setEmail("existinguser@example.com");
        existingUser.setFullName("Existing User");

        User updatedInfo = new User();
        updatedInfo.setEmail("updated@example.com");
        updatedInfo.setFullName("Updated User");

        when(userRepository.findById(3L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(updatedInfo); // Fix: return updated user

        userService.updateUser(3L, updatedInfo);

        assertEquals("updated@example.com", existingUser.getEmail());
        assertEquals("Updated User", existingUser.getFullName());
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    public void testDeleteUser() {
        User userToDelete = new User();
        userToDelete.setId(3L);

        doNothing().when(userRepository).deleteById(3L);
        userService.deleteUser(3L);

        verify(userRepository, times(1)).deleteById(3L);
    }
}
