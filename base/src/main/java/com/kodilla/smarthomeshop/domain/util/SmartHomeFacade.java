package com.kodilla.smarthomeshop.domain.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@AllArgsConstructor(access = lombok.AccessLevel.PACKAGE)
public class SmartHomeFacade {

    private final CheckoutService checkoutService;
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    public void deleteProducts(Long orderId) {
        orderService.deleteProduct(orderId);
    }

    public List<Checkout> getAllCheckouts(Pageable pageable) {
        return checkoutService.getAllCheckouts(pageable);
    }

    public Checkout getProduct(Long checkoutId) {
        return checkoutService.getProduct(checkoutId);
    }

    public Checkout saveCheckout(Checkout checkout) {
        checkoutService.saveCheckout(checkout);
        return checkout;
    }

    public void deleteProduct(Long checkoutId) {
        checkoutService.deleteProduct(checkoutId);
    }

    public Checkout createCheckoutFromProduct(Long productId) {
        return checkoutService.createCheckoutFromProduct(productId);
    }

    public List<Checkout> getOrderedCheckouts(Boolean ordered) {
        return checkoutService.getOrderedCheckouts(ordered);
    }

    public List<Order> getAllOrders(Pageable pageable) {
        return orderService.getAllOrders(pageable);
    }

    public Order getOrder(Long orderId) {
        return orderService.getOrder(orderId);
    }

    public Order save(Order order) {
        return orderService.save(order);
    }

    public Order createOrderFromCheckout(Long userId) {
        return orderService.createOrderFromCheckout(userId);
    }

    public List<Order> getAllOrdersByUserId(Long id) {
        return orderService.getAllOrdersByUserId(id);
    }

    public List<Product> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    public Product getProducts(Long productId) {
        return productService.getProduct(productId);
    }

    public Product saveProduct(Product product) {
        return productService.save(product);
    }

    public List<Product> getProductsByType(String type) {
        return productService.getProductsByType(type);
    }

    public List<Product> getProductsByName(String name) {
        return productService.getProductsByName(name);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User getUser(Long orderId) {
        return userService.getUser(orderId);
    }

    public User saveUser(User user) {
        return userService.save(user);
    }

    public void deleteUser(Long userId) {
        userService.deleteUser(userId);
    }

    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }

    public List<User> getAllUsersWithNoPermission() {
        return userService.getAllUsersWithNoPermission();
    }
}
