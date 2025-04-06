package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.Checkout;
import com.kodilla.smarthomeshop.domain.CheckoutDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckoutMapper {

    public List<CheckoutDto> mapToCheckoutDtoList(final List<Checkout> checkout) {
        return checkout.stream()
                .map(this::mapToCheckoutDto)
                .toList();
    }

    public Checkout mapToCheckout(CheckoutDto checkoutDto) {
        return new Checkout(
                checkoutDto.getCheckoutId(),
                checkoutDto.getQuantity(),
                checkoutDto.getProduct(),
                checkoutDto.getProductList()
        );
    }

    public CheckoutDto mapToCheckoutDto(Checkout checkout) {
        return new CheckoutDto(
                checkout.getCheckoutId(),
                checkout.getQuantity(),
                checkout.getProduct(),
                checkout.getProductList()
        );
    }
}
