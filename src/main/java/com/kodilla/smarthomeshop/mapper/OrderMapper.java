package com.kodilla.smarthomeshop.mapper;

import com.kodilla.smarthomeshop.domain.Order;
import com.kodilla.smarthomeshop.domain.OrderDto;
import com.kodilla.smarthomeshop.repository.ProductListRepository;
import com.kodilla.smarthomeshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderMapper {

    private final UserRepository userRepository;
    private final ProductListRepository productListRepository;

    public List<OrderDto> mapToOrderDtoList(final List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .toList();
    }

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUserId(),
                orderDto.getProductList(),
                orderDto.getOrderStatus(),
                orderDto.getOrderDate()
        );
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getProductList(),
                order.getOrderStatus(),
                order.getOrderDate()
        );
    }
/*
    public Order mapToOrder(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ProductList productList = productListRepository.findById(orderDto.getProductListId())
                .orElseThrow(() -> new RuntimeException("Product list not found"));

        return new Order(null, user, productList, orderDto.getOrderStatus(), orderDto.getOrderDate());
    }
    */
}
