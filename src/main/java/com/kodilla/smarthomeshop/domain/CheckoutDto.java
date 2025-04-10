package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class CheckoutDto {

    private int checkoutId;
    private int quantity;
    private Product product;
    private ProductList productList;
}
