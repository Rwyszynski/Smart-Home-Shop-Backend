package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.List;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class OrderDto {

    private Long OrderId;
    private Long userId;
    private String orderStatus;
    private String orderDate;
    private List<Checkout> orderedItems;
}
