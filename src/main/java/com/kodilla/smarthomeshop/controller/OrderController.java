package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.domain.OrderDto;
import com.kodilla.smarthomeshop.mapper.OrderMapper;
import com.kodilla.smarthomeshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/v1/orders")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orderMapper.mapToOrderDtoList(orders));
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.getOrder(orderId)));
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody Map<String, Long> payload) throws UserNotFoundException {
        Long checkoutId = payload.get("checkoutId");
        Order order = orderService.createOrderFromCheckout(checkoutId);
        OrderDto orderDto = orderMapper.mapToOrderDto(order);
        return ResponseEntity.ok(orderDto);
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderService.save(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteProduct(orderId);
        return ResponseEntity.ok("Usunięto zamówienie z id  " + orderId);
    }

    @PostMapping("/fromCheckout/{checkoutId}")
    public ResponseEntity<OrderDto> createOrdertFromCheckout(@PathVariable Long checkoutId) throws UserNotFoundException {
        Order createdOrder = orderService.createOrderFromCheckout(checkoutId);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(createdOrder));
    }
}
