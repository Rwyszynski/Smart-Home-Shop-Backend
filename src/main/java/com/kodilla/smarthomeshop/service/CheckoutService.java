package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.CheckoutNotFoundException;
import com.kodilla.smarthomeshop.domain.Checkout;
import com.kodilla.smarthomeshop.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Checkout getProduct(Long id) throws CheckoutNotFoundException {
        return checkoutRepository.findById(id).orElseThrow(CheckoutNotFoundException::new);
    }

    public Checkout save(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public void deleteProduct(Long id) throws CheckoutNotFoundException {
        checkoutRepository.deleteById(id);
    }
}
