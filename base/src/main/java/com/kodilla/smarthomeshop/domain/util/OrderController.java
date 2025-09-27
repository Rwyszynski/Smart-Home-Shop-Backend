package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.AllOrderDto;
import com.kodilla.smarthomeshop.domain.dto.CreateOrderDto;
import com.kodilla.smarthomeshop.domain.dto.OrderDto;
import com.kodilla.smarthomeshop.domain.dto.OrderSuccessfullyDeleted;
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
class OrderController {

    private final SmartHomeFacade smartHomeFacade;
    private final OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<AllOrderDto> getAllOrders(@PageableDefault(page = 0, size = 10)
                                                        @RequestParam(required = false) Pageable pageable) {
        List<Order> orders = smartHomeFacade.getAllOrders(pageable);
        return ResponseEntity.ok(new AllOrderDto(orderMapper.mapToOrderDtoList(orders)));
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(smartHomeFacade.getOrder(orderId)));
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody CreateOrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = smartHomeFacade.save(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<OrderSuccessfullyDeleted> deleteOrder(@PathVariable Long orderId) {
        smartHomeFacade.deleteProducts(orderId);
        return ResponseEntity.ok(new OrderSuccessfullyDeleted("Usunięto zamówienie z id: " + orderId));
    }

    @PostMapping("/fromCheckout/{userId}")
    public ResponseEntity<OrderDto> createOrderFromCheckout(@PathVariable Long userId) throws UserNotFoundException {
        Order createdOrder = smartHomeFacade.createOrderFromCheckout(userId);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(createdOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllOrderDto> getOrdersByUserId(@PathVariable Long id) throws OrderNotFoundException {
        List<Order> ordersByUser = smartHomeFacade.getAllOrdersByUserId(id);
        return ResponseEntity.ok(new AllOrderDto(orderMapper.mapToOrderDtoList(ordersByUser)));
    }
}
