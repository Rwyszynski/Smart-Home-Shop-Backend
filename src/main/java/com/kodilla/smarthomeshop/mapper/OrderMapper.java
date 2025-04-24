package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.domain.OrderDto;
import com.kodilla.smarthomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderMapper {

    private final UserRepository userRepository;

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .toList();
    }

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUserId(),
                orderDto.getOrderStatus(),
                orderDto.getOrderDate(),
                orderDto.getOrderedItems()
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
