package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.OrderNotFoundException;
import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

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
}
