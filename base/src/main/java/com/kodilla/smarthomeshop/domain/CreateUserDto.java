package com.kodilla.smarthomeshop.domain;


public record CreateUserDto(String userName, String userSurname, String email, String address, String password, String role) {
}
