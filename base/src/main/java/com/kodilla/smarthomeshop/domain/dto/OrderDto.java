package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.Checkout;

import java.util.List;

public record OrderDto(Long OrderId, Long userId, String orderStatus, String orderDate, List<Checkout> orderedItems) {

}
