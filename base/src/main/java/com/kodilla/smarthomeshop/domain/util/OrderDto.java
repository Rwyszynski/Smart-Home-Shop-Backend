package com.kodilla.smarthomeshop.domain.util;

import java.util.List;

public record OrderDto(Long OrderId, Long userId, String orderStatus, String orderDate, List<Checkout> orderedItems) {

}
