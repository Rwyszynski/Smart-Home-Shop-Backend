package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.UserDto;

import java.util.List;

public record AllUsersDto(List<UserDto> users) {
}
