package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.domain.OrderDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderMapper {

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .toList();
    }

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUser(),
                orderDto.getProductList(),
                orderDto.getOrderStatus(),
                orderDto.getOrderDate()
        );
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUser(),
                order.getProductList(),
                order.getOrderStatus(),
                order.getOrderDate()
        );
    }
}
