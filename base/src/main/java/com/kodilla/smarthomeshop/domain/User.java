package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String userName;
    private String userSurname;
    private String email;
    private String address;
    private String password;
}
