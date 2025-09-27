package com.kodilla.smarthomeshop.domain.util;

public class CheckoutNotFoundException extends RuntimeException {
    public CheckoutNotFoundException(String repoNotFound){
        super(repoNotFound);
    }

}
