package com.kodilla.smarthomeshop.domain.util;

public class CreateOrderException extends IllegalStateException {
    public CreateOrderException(String message) {
        super(message);
    }
}
