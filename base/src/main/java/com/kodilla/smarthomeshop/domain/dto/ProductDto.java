package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.Type;

public record ProductDto(Long component_id, String brand, String model, int voltage, int power, String protocol, int current, double price, String url, Type type) {
}
