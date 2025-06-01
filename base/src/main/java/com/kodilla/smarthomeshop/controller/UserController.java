package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.domain.UserDto;
import com.kodilla.smarthomeshop.mapper.UserMapper;
import com.kodilla.smarthomeshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/v1/users")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long orderId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUser(orderId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.save(user);
        Long id = savedUser.getUserId();
        return ResponseEntity.ok("Zarejestrowano użytkownika z ID " + id);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Usunięto użytkownika z id " + userId);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        User user = userService.findByEmail(userDto.getEmail());

        if (user == null) {
            return ResponseEntity.status(401).body(null);
        }
        if (!user.getPassword().equals(userDto.getPassword())) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }
}
