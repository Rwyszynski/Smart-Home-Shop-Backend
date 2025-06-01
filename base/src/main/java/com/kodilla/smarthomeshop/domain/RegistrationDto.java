package com.kodilla.smarthomeshop.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDto {

    private Long id;
    @NotEmpty(message = "Pole Imię nie może być puste")
    private String userName;
    @NotEmpty(message = "Pole Nazwisko nie może być puste")
    private String userSurname;
    @NotEmpty(message = "Pole Email nie może być puste")
    private String email;
    @NotEmpty(message = "Pole Adres nie może być puste")
    private String address;
    @NotEmpty(message = "Pole Hasło nie może być puste")
    private String password;
}

