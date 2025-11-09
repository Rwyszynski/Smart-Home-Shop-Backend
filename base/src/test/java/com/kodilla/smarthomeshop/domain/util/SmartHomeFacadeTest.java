package com.kodilla.smarthomeshop.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("Should get all checkouts")
    void shouldGetAllCheckouts() {
        //Given
        Pageable pageable = mock(Pageable.class);
        List<Checkout> expected = List.of(new Checkout());
        when(checkoutService.getAllCheckouts(pageable)).thenReturn(expected);

        //When
        List<Checkout> result = smartHomeFacade.getAllCheckouts(pageable);

        //Then
        assertEquals(expected, result);
        verify(checkoutService, times(1)).getAllCheckouts(pageable);
    }

    @Test
    @DisplayName("Should get checkout by id")
    void shouldGetProduct() {
        //Given
        Long id = 1L;
        Checkout checkout = new Checkout();
        when(checkoutService.getProduct(id)).thenReturn(checkout);

        //When
        Checkout result = smartHomeFacade.getProduct(id);

        //Then
        assertEquals(checkout, result);
        verify(checkoutService, times(1)).getProduct(id);
    }

    @Test
    @DisplayName("Should save checkout")
    void shouldSaveCheckout() {
        //Given
        Checkout checkout = new Checkout();

        //When
        Checkout result = smartHomeFacade.saveCheckout(checkout);

        //Then
        assertEquals(checkout, result);
        verify(checkoutService, times(1)).saveCheckout(checkout);
    }

    @Test
    @DisplayName("Should delete checkout product by id")
    void shouldDeleteCheckoutProduct() {
        //Given
        Long id = 1L;

        //When
        smartHomeFacade.deleteProduct(id);

        //Then
        verify(checkoutService, times(1)).deleteProduct(id);
    }

    @Test
    @DisplayName("Should create checkout from product")
    void shouldCreateCheckoutFromProduct() {
        //Given
        Long productId = 2L;
        Checkout checkout = new Checkout();
        when(checkoutService.createCheckoutFromProduct(productId)).thenReturn(checkout);

        //When
        Checkout result = smartHomeFacade.createCheckoutFromProduct(productId);

        //Then
        assertEquals(checkout, result);
        verify(checkoutService, times(1)).createCheckoutFromProduct(productId);
    }

    @Test
    @DisplayName("Should get ordered checkouts")
    void shouldGetOrderedCheckouts() {
        //Given
        List<Checkout> list = List.of(new Checkout());
        when(checkoutService.getOrderedCheckouts(true)).thenReturn(list);

        //When
        List<Checkout> result = smartHomeFacade.getOrderedCheckouts(true);

        //Then
        assertEquals(list, result);
        verify(checkoutService, times(1)).getOrderedCheckouts(true);
    }

    @Test
    @DisplayName("Should get all orders")
    void shouldGetAllOrders() {
        //Given
        Pageable pageable = mock(Pageable.class);
        List<Order> orders = List.of(new Order());
        when(orderService.getAllOrders(pageable)).thenReturn(orders);

        //When
        List<Order> result = smartHomeFacade.getAllOrders(pageable);

        //Then
        assertEquals(orders, result);
        verify(orderService, times(1)).getAllOrders(pageable);
    }

    @Test
    @DisplayName("Should get order by id")
    void shouldGetOrderById() {
        //Given
        Long orderId = 1L;
        Order order = new Order();
        when(orderService.getOrder(orderId)).thenReturn(order);

        //When
        Order result = smartHomeFacade.getOrder(orderId);

        //Then
        assertEquals(order, result);
        verify(orderService, times(1)).getOrder(orderId);
    }

    @Test
    @DisplayName("Should save order")
    void shouldSaveOrder() {
        //Given
        Order order = new Order();
        when(orderService.save(order)).thenReturn(order);

        //When
        Order result = smartHomeFacade.save(order);

        //Then
        assertEquals(order, result);
        verify(orderService, times(1)).save(order);
    }

    @Test
    @DisplayName("Should create order from checkout")
    void shouldCreateOrderFromCheckout() {
        //Given
        Long userId = 5L;
        Order order = new Order();
        when(orderService.createOrderFromCheckout(userId)).thenReturn(order);

        //When
        Order result = smartHomeFacade.createOrderFromCheckout(userId);

        //Then
        assertEquals(order, result);
        verify(orderService, times(1)).createOrderFromCheckout(userId);
    }

    @Test
    @DisplayName("Should get all orders by user id")
    void shouldGetAllOrdersByUserId() {
        //Given
        Long userId = 3L;
        List<Order> orders = List.of(new Order());
        when(orderService.getAllOrdersByUserId(userId)).thenReturn(orders);

        //When
        List<Order> result = smartHomeFacade.getAllOrdersByUserId(userId);

        //Then
        assertEquals(orders, result);
        verify(orderService, times(1)).getAllOrdersByUserId(userId);
    }

    @Test
    @DisplayName("Should get all products")
    void shouldGetAllProducts() {
        Pageable pageable = mock(Pageable.class);
        List<Product> products = List.of(new Product());
        when(productService.getAllProducts(pageable)).thenReturn(products);

        List<Product> result = smartHomeFacade.getAllProducts(pageable);

        assertEquals(products, result);
        verify(productService, times(1)).getAllProducts(pageable);
    }

    @Test
    @DisplayName("Should get product by id")
    void shouldGetProductById() {
        Long productId = 2L;
        Product product = new Product();
        when(productService.getProduct(productId)).thenReturn(product);

        Product result = smartHomeFacade.getProducts(productId);

        assertEquals(product, result);
        verify(productService, times(1)).getProduct(productId);
    }

    @Test
    @DisplayName("Should save product")
    void shouldSaveProduct() {
        Product product = new Product();
        when(productService.save(product)).thenReturn(product);

        Product result = smartHomeFacade.saveProduct(product);

        assertEquals(product, result);
        verify(productService, times(1)).save(product);
    }

    @Test
    @DisplayName("Should find products by type")
    void shouldFindProductsByType() {
        List<Product> products = List.of(new Product());
        when(productService.getProductsByType("light")).thenReturn(products);

        List<Product> result = smartHomeFacade.getProductsByType("light");

        assertEquals(products, result);
        verify(productService, times(1)).getProductsByType("light");
    }

    @Test
    @DisplayName("Should find products by name")
    void shouldFindProductsByName() {
        List<Product> products = List.of(new Product());
        when(productService.getProductsByName("Sensor")).thenReturn(products);

        List<Product> result = smartHomeFacade.getProductsByName("Sensor");

        assertEquals(products, result);
        verify(productService, times(1)).getProductsByName("Sensor");
    }

    @Test
    @DisplayName("Should get all users")
    void shouldGetAllUsers() {
        List<User> users = List.of(new User());
        when(userService.getAllUsers()).thenReturn(users);

        List<User> result = smartHomeFacade.getAllUsers();

        assertEquals(users, result);
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    @DisplayName("Should get user by id")
    void shouldGetUserById() {
        Long userId = 10L;
        User user = new User();
        when(userService.getUser(userId)).thenReturn(user);

        User result = smartHomeFacade.getUser(userId);

        assertEquals(user, result);
        verify(userService, times(1)).getUser(userId);
    }

    @Test
    @DisplayName("Should save user")
    void shouldSaveUser() {
        User user = new User();
        when(userService.save(user)).thenReturn(user);

        User result = smartHomeFacade.saveUser(user);

        assertEquals(user, result);
        verify(userService, times(1)).save(user);
    }

    @Test
    @DisplayName("Should delete user")
    void shouldDeleteUser() {
        Long userId = 7L;

        smartHomeFacade.deleteUser(userId);

        verify(userService, times(1)).deleteUser(userId);
    }

    @Test
    @DisplayName("Should find user by email")
    void shouldFindUserByEmail() {
        User user = new User();
        when(userService.findByEmail("test@home.com")).thenReturn(user);

        User result = smartHomeFacade.findByEmail("test@home.com");

        assertEquals(user, result);
        verify(userService, times(1)).findByEmail("test@home.com");
    }

    @Test
    @DisplayName("Should get users with no permission")
    void shouldGetUsersWithNoPermission() {
        List<User> users = List.of(new User());
        when(userService.getAllUsersWithNoPermission()).thenReturn(users);

        List<User> result = smartHomeFacade.getAllUsersWithNoPermission();

        assertEquals(users, result);
        verify(userService, times(1)).getAllUsersWithNoPermission();
    }
}

