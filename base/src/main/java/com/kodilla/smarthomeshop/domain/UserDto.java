package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserDto {

    private Long userId;
    private String userName;
    private String userSurname;
    private String email;
    private String address;
    private String password;
}
