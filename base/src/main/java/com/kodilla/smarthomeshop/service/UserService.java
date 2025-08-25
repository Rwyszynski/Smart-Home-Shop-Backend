package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.UserNotFoundException;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserService {

    private final UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long orderId) throws UserNotFoundException {
        return userRepository.findById(orderId).orElseThrow(() -> new UserNotFoundException("Nie znaleziono użytkownika"));
    }

    public User save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Integer getUserById(Long userId) {
        return userId.intValue();
    }

    public List<User> getAllUsersWithNoPermission() {
        return userRepository.findAll().stream()
                .filter(user -> "normal".equals(user.getRole()))
                .collect(Collectors.toList());
    }
}


