package com.kodilla.smarthomeshop.domain.dto;


public record CreateUserDto(String userName, String userSurname, String email, String address, String password, String role) {
}
