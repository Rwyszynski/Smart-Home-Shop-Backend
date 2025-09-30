package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.CheckoutDto;

import java.util.List;

public record AllCheckoutDto(List<CheckoutDto> checkoutDto) {
}
