package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.OrderDto;

import java.util.List;

public record AllOrderDto(List<OrderDto> orders) {
}
