package com.kodilla.smarthomeshop.domain.util;

import java.util.List;

public record CreateOrderDto(Long userId, String orderStatus, String orderDate, List<Checkout> orderedItems) {
}
