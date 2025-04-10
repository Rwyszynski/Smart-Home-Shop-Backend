package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "productList", nullable = false, unique = true)
    private ProductList productList;
    private String orderStatus;
    private String orderDate;
}
