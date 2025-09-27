package com.kodilla.smarthomeshop.domain.util;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "checkout")
public class Checkout extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkout_seq")
    @SequenceGenerator(name = "checkout_seq", sequenceName = "checkout_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

    private boolean isOrdered;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public boolean getIsOrdered() {
        return isOrdered;
    }

    public Checkout(User user, Product product, int quantity, boolean isOrdered, Order order) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.isOrdered = isOrdered;
        this.order = order;
    }
}


