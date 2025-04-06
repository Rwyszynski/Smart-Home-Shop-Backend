package com.kodilla.smarthomeshop.service;

import com.kodilla.smarthomeshop.controller.OrderNotFoundException;
import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

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
