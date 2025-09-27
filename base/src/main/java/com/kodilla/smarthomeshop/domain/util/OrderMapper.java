package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.CreateOrderDto;
import com.kodilla.smarthomeshop.domain.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
class OrderMapper {

    private final UserRepository userRepository;

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .toList();
    }

    public Order mapToOrder(CreateOrderDto orderDto) {
        return new Order(
                orderDto.userId(),
                orderDto.orderStatus(),
                orderDto.orderDate(),
                orderDto.orderedItems()
        );
    }

    public OrderDto mapToOrderDto(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null in mapToOrderDto");
        }

        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getOrderStatus(),
                order.getOrderDate(),
                order.getOrderedItems()
        );
    }
}
