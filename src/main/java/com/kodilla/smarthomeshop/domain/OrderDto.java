package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private User user;
    private ProductList productList;
    private String orderStatus;
    private String orderDate;
}
