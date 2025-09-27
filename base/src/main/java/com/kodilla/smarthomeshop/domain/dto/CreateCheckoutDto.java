package com.kodilla.smarthomeshop.domain.dto;

import com.kodilla.smarthomeshop.domain.util.Order;
import com.kodilla.smarthomeshop.domain.util.Product;
import com.kodilla.smarthomeshop.domain.util.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateCheckoutDto(
        @NotNull
                                @NotEmpty
        User user,
        Product product, int quantity, boolean isOrdered, Order order) {
}
