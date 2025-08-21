package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.*;
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
    public ResponseEntity<AllUsersDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new AllUsersDto(userMapper.mapToUserDtoList(users)));
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long orderId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUser(orderId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<UserSuccessfullyAdded> createUser(@RequestBody CreateUserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.save(user);
        Long id = savedUser.getUserId();
        return ResponseEntity.ok(new UserSuccessfullyAdded("Zarejestrowano użytkownika z ID " + id));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody CreateUserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(savedUser));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<UserSuccessfullyDeleted> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(new UserSuccessfullyDeleted( "Usunięto użytkownika z id " + userId));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
        User user = userService.findByEmail(userDto.email());
        if (user == null) {
            return ResponseEntity.status(401).body(null);
        }
        if (!user.getPassword().equals(userDto.password())) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok(userMapper.mapToUserDto(user));
    }
}
