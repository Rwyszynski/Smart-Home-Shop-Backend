package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.CreateCheckoutDto;
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

    public Checkout mapToCheckout(CreateCheckoutDto checkoutDto) {
        return new Checkout(
                checkoutDto.user(),
                checkoutDto.product(),
                checkoutDto.quantity(),
                checkoutDto.isOrdered(),
                checkoutDto.order()
        );
    }

    public CheckoutDto mapToCheckoutDto(Checkout checkout) {
        return new CheckoutDto(
                checkout.getId(),
                checkout.getUser(),
                checkout.getProduct(),
                checkout.getQuantity(),
                checkout.getIsOrdered(),
                checkout.getOrder()
        );
    }
}
