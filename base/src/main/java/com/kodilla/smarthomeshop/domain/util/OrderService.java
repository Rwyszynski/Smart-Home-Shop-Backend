package com.kodilla.smarthomeshop.domain.util;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
class OrderService {

    private final OrderRepository orderRepository;
    private final CheckoutRepository checkoutRepository;
    private final UserService userService;

    public List<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order getOrder(Long orderId) throws OrderNotFoundException {
        return orderRepository.findById(orderId).orElseThrow(() ->
                new OrderNotFoundException("Nie znaleziono zamówienia "+ orderId));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteProduct(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Transactional
    public Order createOrderFromCheckout(Long userId) throws UserNotFoundException {
        User user = userService.getUser(userId);
        List<Checkout> checkoutList = checkoutRepository.findByUser(user);

        if (checkoutList.isEmpty()) {
            throw new IllegalStateException("Koszyk jest pusty. Nie można utworzyć zamówienia.");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus("Zamówione");
        order.setOrderDate(LocalDate.now().toString());
        order.setOrderedItems(new ArrayList<>());

        for (Checkout checkout : checkoutList) {
            checkout.setOrder(order);
            checkout.setOrdered(true);
            order.getOrderedItems().add(checkout);
        }
        return orderRepository.save(order);
    }

    public List<Order> getAllOrdersByUserId(Long id) {
        List<Order> userOrders = orderRepository.findByCustomerId(id);
        return userOrders;
    }
}


