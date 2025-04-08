package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.UserDto;
import com.kodilla.smarthomeshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class AuthorisationController {

    private final UserService userService;

    public AuthorisationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserDto userDto) {
        try {
            userService.registerUser(userDto);  // Rejestracja użytkownika w bazie
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

