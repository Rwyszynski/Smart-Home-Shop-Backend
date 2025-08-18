package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.domain.AllOrderDto;
import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.domain.OrderDto;
import com.kodilla.smarthomeshop.domain.OrderSuccessfullyDeleted;
import com.kodilla.smarthomeshop.mapper.OrderMapper;
import com.kodilla.smarthomeshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/v1/orders")
@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<AllOrderDto> getAllOrders(@PageableDefault(page = 0, size = 10)
                                                        @RequestParam(required = false) Pageable pageable) {
        List<Order> orders = orderService.getAllOrders(pageable);
        return ResponseEntity.ok(new AllOrderDto(orderMapper.mapToOrderDtoList(orders)));
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.getOrder(orderId)));
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderService.save(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<OrderSuccessfullyDeleted> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteProduct(orderId);
        return ResponseEntity.ok(new OrderSuccessfullyDeleted("Usunięto zamówienie z id: " + orderId));
    }

    @PostMapping("/fromCheckout/{userId}")
    public ResponseEntity<OrderDto> createOrderFromCheckout(@PathVariable Long userId) throws UserNotFoundException {
        Order createdOrder = orderService.createOrderFromCheckout(userId);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(createdOrder));
    }
}
