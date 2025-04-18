package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "productList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductList {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "productList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Checkout> checkoutList = new ArrayList<>();
}