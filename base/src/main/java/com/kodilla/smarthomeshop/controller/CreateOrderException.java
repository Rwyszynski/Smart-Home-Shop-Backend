package com.kodilla.smarthomeshop.controller;

public class CreateOrderException extends IllegalStateException {
    public CreateOrderException(String message) {
        super(message);
    }
}
