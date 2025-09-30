package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.ProductDto;

import java.util.List;

public record AllProductDto(List<ProductDto> products) {
}
