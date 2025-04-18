package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.*;
import lombok.*;

@Setter
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
    private User userId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_list_id", nullable = false)
    private ProductList productList;
    private String orderStatus;
    private String orderDate;
}
