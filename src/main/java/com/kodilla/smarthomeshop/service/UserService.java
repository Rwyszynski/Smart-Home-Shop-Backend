package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.UserNotFoundException;
import com.kodilla.smarthomeshop.domain.RegistrationDto;
import com.kodilla.smarthomeshop.domain.Role;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.repository.RoleRepository;
import com.kodilla.smarthomeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setUserSurname(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setAddress(registrationDto.getAddress());
        user.setPassword(registrationDto.getPassword());

        Role role = roleRepository.findByName("USER");

        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long orderId) throws UserNotFoundException {
        return userRepository.findById(orderId).orElseThrow();
    }

    public User save(User user) {
        User savedUser = userRepository.save(user);
        return user;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}


