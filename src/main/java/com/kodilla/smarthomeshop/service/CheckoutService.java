package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.CheckoutNotFoundException;
import com.kodilla.smarthomeshop.domain.Checkout;
import com.kodilla.smarthomeshop.domain.Product;
import com.kodilla.smarthomeshop.domain.ProductList;
import com.kodilla.smarthomeshop.domain.User;
import com.kodilla.smarthomeshop.repository.CheckoutRepository;
import com.kodilla.smarthomeshop.repository.ProductListRepository;
import com.kodilla.smarthomeshop.repository.ProductRepository;
import com.kodilla.smarthomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final ProductListRepository productListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Checkout getProduct(Long id) throws CheckoutNotFoundException {
        return checkoutRepository.findById(id).orElseThrow(CheckoutNotFoundException::new);
    }

    public void deleteProduct(Long id) throws CheckoutNotFoundException {
        checkoutRepository.deleteById(id);
    }

    public Checkout createCheckoutFromProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono produktu: " + productId));

        User user = userRepository.findAll().get(0);
        ProductList productList = new ProductList();
        productList.setUserId(userService.getUserById(user.getUserId()));

        Checkout checkout = new Checkout();
        checkout.setProductList(productList);
        checkout.setProduct(product);
        checkout.setQuantity(1);

        productList.getCheckoutIds().add(checkout);
        productListRepository.save(productList);
        return checkoutRepository.save(checkout);
    }

    public Checkout saveCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }
}
