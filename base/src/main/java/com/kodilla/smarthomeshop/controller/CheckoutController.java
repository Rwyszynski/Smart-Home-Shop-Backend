package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.Checkout;
import com.kodilla.smarthomeshop.domain.CheckoutDto;
import com.kodilla.smarthomeshop.mapper.CheckoutMapper;
import com.kodilla.smarthomeshop.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/v1/checkouts")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final CheckoutMapper checkoutMapper;

    @GetMapping
    public ResponseEntity<List<CheckoutDto>> getAllCheckouts() {
        List<Checkout> checkouts = checkoutService.getAllCheckouts();
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDtoList(checkouts));
    }

    @GetMapping(value = "/{checkoutId}")
    public ResponseEntity<CheckoutDto> getCheckout(@PathVariable Long checkoutId) throws CheckoutNotFoundException {
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(checkoutService.getProduct(checkoutId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCheckout(@RequestBody CheckoutDto checkoutDto) {
        Checkout checkout = checkoutMapper.mapToCheckout(checkoutDto);
        checkoutService.saveCheckout(checkout);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CheckoutDto> updateCheckout(@RequestBody CheckoutDto checkoutDto) {
        Checkout checkout = checkoutMapper.mapToCheckout(checkoutDto);
        Checkout savedCheckout = checkoutService.saveCheckout(checkout);
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(savedCheckout));
    }

    @DeleteMapping(value = "/{checkoutId}")
    public ResponseEntity<String> deleteCheckout(@PathVariable Long checkoutId) throws CheckoutNotFoundException {
        checkoutService.deleteProduct(checkoutId);
        return ResponseEntity.ok("Usunięto checkout z id  " + checkoutId);
    }

    @PostMapping("/fromProduct/{productId}")
    public ResponseEntity<CheckoutDto> createCheckoutFromProduct(@PathVariable Long productId) {
        Checkout createdCheckout = checkoutService.createCheckoutFromProduct(productId);
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(createdCheckout));
    }
}
