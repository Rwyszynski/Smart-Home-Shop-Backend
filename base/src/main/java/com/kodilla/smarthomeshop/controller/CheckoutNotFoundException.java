package com.kodilla.smarthomeshop.controller;

public class CheckoutNotFoundException extends RuntimeException {
    public CheckoutNotFoundException(String repoNotFound){
        super(repoNotFound);
    }

}
