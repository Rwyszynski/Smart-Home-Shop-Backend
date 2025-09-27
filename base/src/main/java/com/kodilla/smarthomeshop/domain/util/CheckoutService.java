package com.kodilla.smarthomeshop.domain.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
class CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Checkout> getAllCheckouts(Pageable pageable) {
        return checkoutRepository.findAll(pageable);
    }

    public Checkout getProduct(Long id) throws CheckoutNotFoundException {
        return checkoutRepository.findById(id).orElseThrow(() ->
                new CheckoutNotFoundException("Koszyk z id " + id + " nie znaleziono"));
    }

    public void deleteProduct(Long id) throws CheckoutNotFoundException {
        checkoutRepository.deleteById(id);
    }

    public Checkout saveCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public Checkout createCheckoutFromProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono produktu: " + productId));

        User user = userRepository.findAll().get(0);
        Optional<Checkout> existing = checkoutRepository
                .findByUserAndProductAndIsOrderedFalse(user, product);

        if (existing.isPresent()) {
            Checkout checkout = existing.get();
            checkout.setQuantity(checkout.getQuantity() + 1);
            return checkoutRepository.save(checkout);
        }

        Checkout checkout = new Checkout();
        checkout.setUser(user);
        checkout.setProduct(product);
        checkout.setQuantity(1);
        checkout.setOrdered(false);
        return checkoutRepository.save(checkout);
    }

    public List<Checkout> getOrderedCheckouts(Boolean ordered) {
        if (ordered == null) {
            return checkoutRepository.findAll();
        }
        return checkoutRepository.findByIsOrdered(ordered);
    }

}
