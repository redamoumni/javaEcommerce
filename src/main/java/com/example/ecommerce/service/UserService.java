package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Retrieves all users from the database.
     * 
     * @return a list of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by their ID.
     * 
     * @param id the ID of the user to retrieve.
     * @return an Optional containing the user if found, or an empty Optional if not
     *         found.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Creates a new user in the database.
     * 
     * @param user the user to create.
     * @return the saved user.
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates the details of an existing user.
     * 
     * @param id   the ID of the user to update.
     * @param user the updated user information.
     * @return the updated user.
     */
    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setEmail(user.getEmail());
                    existingUser.setFullName(user.getFullName());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    /**
     * Deletes a user from the database by their ID.
     * 
     * @param id the ID of the user to delete.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Finds a user by their email.
     * 
     * @param email the email of the user to find.
     * @return the user, or null if no user is found with that email.
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
