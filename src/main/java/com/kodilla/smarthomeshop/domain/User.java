package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String userSurname;
    private String email;
    private String address;
    private String password;

    @Transient
    private List<ProductList> productLists = new ArrayList<>();
}
