package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.UserNotFoundException;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.domain.UserDto;
import com.kodilla.smarthomeshop.repository.RoleRepository;
import com.kodilla.smarthomeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserSurname(userDto.getUserSurname());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
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

    public Integer getUserById(Long userId) {
        return userId.intValue();
    }
}


