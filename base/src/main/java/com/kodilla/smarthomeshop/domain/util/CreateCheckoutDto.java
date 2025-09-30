package com.kodilla.smarthomeshop.domain.util;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateCheckoutDto(
        @NotNull
                                @NotEmpty
        User user,
        Product product, int quantity, boolean isOrdered, Order order) {
}
