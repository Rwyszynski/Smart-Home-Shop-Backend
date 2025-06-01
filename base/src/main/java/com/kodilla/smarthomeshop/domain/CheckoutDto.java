package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class CheckoutDto {

    private Long id;
    private User user;
    private Product product;
    private int quantity;
    private boolean isOrdered;
    private Order order;

    public boolean getIsOrdered() {
        return isOrdered;
    }
}
