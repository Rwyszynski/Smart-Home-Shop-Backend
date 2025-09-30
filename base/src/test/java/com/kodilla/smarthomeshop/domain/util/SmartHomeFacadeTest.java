package com.kodilla.smarthomeshop.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SmartHomeFacadeTest {

    CheckoutService checkoutService = mock(CheckoutService.class);
    OrderService orderService = mock(OrderService.class);
    ProductService productService = mock(ProductService.class);
    UserService userService = mock(UserService.class);

    SmartHomeFacade smartHomeFacade = new SmartHomeFacade(checkoutService, orderService, productService, userService);

    @Test
    @DisplayName("Should delete products")
    void shouldDeleteProducts() {
        //Given
        Long orderId = 1L;

        //When
        smartHomeFacade.deleteProductByOrderId(orderId);

        //Then
        verify(orderService, times(1)).deleteProduct(orderId);
    }


}