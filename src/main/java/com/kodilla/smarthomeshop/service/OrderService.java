package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.OrderNotFoundException;
import com.kodilla.smarthomeshop.controller.UserNotFoundException;
import com.kodilla.smarthomeshop.domain.*;
import com.kodilla.smarthomeshop.repository.CheckoutRepository;
import com.kodilla.smarthomeshop.repository.OrderRepository;
import com.kodilla.smarthomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CheckoutRepository checkoutRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteProduct(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public Order createOrderFromCheckout(Long checkoutId) throws UserNotFoundException {
        Checkout checkout = checkoutRepository.findById(checkoutId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono checkoutu: " + checkoutId));

        Integer userId = checkout.getProductList().getUserId();
        User user = userService.getUser(checkoutId);
        ProductList productList = new ProductList();
        productList.setUserId(userId);

        Order order = new Order();
        order.setUserId(user);
        order.setProductList(productList);
        order.setOrderStatus("Zamówione");
        order.setOrderDate(LocalDate.now().toString());

        return orderRepository.save(order);
    }
}


