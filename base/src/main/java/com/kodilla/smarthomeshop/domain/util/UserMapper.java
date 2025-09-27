package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.CreateUserDto;
import com.kodilla.smarthomeshop.domain.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class UserMapper {

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .toList();
    }

    public User mapToUser(CreateUserDto userDto) {
        return new User(
            userDto.userName(),
            userDto.userSurname(),
            userDto.email(),
            userDto.address(),
            userDto.password(),
            userDto.role()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getUserId(),
            user.getUserName(),
            user.getUserSurname(),
            user.getEmail(),
            user.getAddress(),
            user.getPassword(),
            user.getRole()
        );
    }
}
