package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.Checkout;

import java.util.List;

public record CreateOrderDto(Long userId, String orderStatus, String orderDate, List<Checkout> orderedItems) {
}
