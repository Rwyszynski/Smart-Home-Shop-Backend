package com.kodilla.smarthomeshop.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CheckoutDto(Long id,
                          @NotNull
                          @NotEmpty
                          User user,
                          Product product, int quantity, boolean isOrdered, Order order){

}
