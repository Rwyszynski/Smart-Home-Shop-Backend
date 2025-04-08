package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.domain.Role;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.domain.UserDto;
import com.kodilla.smarthomeshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));  // haszowanie hasła

        // Przypisanie roli, np. rola USER
        Role userRole = new Role();
        userRole.setName("USER");
        user.setRoles(Collections.singletonList(userRole));

        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}