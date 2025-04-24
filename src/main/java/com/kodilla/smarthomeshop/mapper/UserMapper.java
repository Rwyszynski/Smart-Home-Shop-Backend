package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.domain.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserMapper {

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .toList();
    }

    public User mapToUser(UserDto userDto) {
        return new User(
            userDto.getUserId(),
            userDto.getUserName(),
            userDto.getUserSurname(),
            userDto.getEmail(),
            userDto.getAddress(),
            userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getUserId(),
            user.getUserName(),
            user.getUserSurname(),
            user.getEmail(),
            user.getAddress(),
            user.getPassword()
        );
    }
}
