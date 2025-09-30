package com.kodilla.smarthomeshop.domain.util;

public record UserDto(Long userId, String userName, String userSurname, String email, String address, String password, String role) {

}
