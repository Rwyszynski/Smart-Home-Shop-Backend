package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.*;
import com.kodilla.smarthomeshop.mapper.CheckoutMapper;
import com.kodilla.smarthomeshop.service.CheckoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<AllCheckoutDto> getAllCheckouts(@PageableDefault(page = 0, size = 10)
                                                              @RequestParam(required = false) Pageable pageable) {
        List<Checkout> checkouts = checkoutService.getAllCheckouts(pageable);
        return ResponseEntity.ok(new AllCheckoutDto(checkoutMapper.mapToCheckoutDtoList(checkouts)));
    }

    @GetMapping(value = "/{checkoutId}")
    public ResponseEntity<CheckoutDto> getCheckout(@PathVariable Long checkoutId) throws CheckoutNotFoundException {
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(checkoutService.getProduct(checkoutId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCheckoutDto> createCheckout(@RequestBody @Valid CreateCheckoutDto checkoutDto) {
        Checkout checkout = checkoutMapper.mapToCheckout(checkoutDto);
        checkoutService.saveCheckout(checkout);
        return ResponseEntity.ok(checkoutDto);
    }

    @PutMapping
    public ResponseEntity<CheckoutDto> updateCheckout(@RequestBody @Valid CreateCheckoutDto checkoutDto) {
        Checkout checkout = checkoutMapper.mapToCheckout(checkoutDto);
        Checkout savedCheckout = checkoutService.saveCheckout(checkout);
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(savedCheckout));
    }

    @DeleteMapping(value = "/{checkoutId}")
    public ResponseEntity<CheckoutSuccessfullyDeleted> deleteCheckout(@PathVariable Long checkoutId) throws CheckoutNotFoundException {
        checkoutService.deleteProduct(checkoutId);
        return ResponseEntity.ok(new CheckoutSuccessfullyDeleted("Usunięto Koszyk z id: " + checkoutId));
    }

    @PostMapping("/fromProduct/{productId}")
    public ResponseEntity<CheckoutDto> createCheckoutFromProduct(@PathVariable Long productId) {
        Checkout createdCheckout = checkoutService.createCheckoutFromProduct(productId);
        return ResponseEntity.ok(checkoutMapper.mapToCheckoutDto(createdCheckout));
    }

    @GetMapping("/ordered")
    public ResponseEntity<AllCheckoutDto> getOrderedCheckouts(
            @RequestParam(required = false) Boolean ordered) {
        List<Checkout> checkouts = checkoutService.getOrderedCheckouts(ordered);
        return ResponseEntity.ok(
                new AllCheckoutDto(checkoutMapper.mapToCheckoutDtoList(checkouts))
        );
    }
}
