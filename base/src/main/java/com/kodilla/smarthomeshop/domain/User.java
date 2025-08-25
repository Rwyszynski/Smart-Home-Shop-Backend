package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    private String userName;
    private String userSurname;
    private String email;
    private String address;
    private String password;
    private String role;

    public User(String userName, String userSurname, String email, String address, String password, String role) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }
}
