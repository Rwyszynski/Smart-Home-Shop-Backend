package com.kodilla.smarthomeshop.domain.util;

import com.kodilla.smarthomeshop.domain.dto.CheckoutNotFoundResponseDto;
import com.kodilla.smarthomeshop.domain.dto.OrderNotFoundResponseDto;
import com.kodilla.smarthomeshop.domain.dto.ProductNotFoundResponseDto;
import com.kodilla.smarthomeshop.domain.dto.UserNotFoundResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CheckoutValidationErrorHandler {

    @ExceptionHandler(CheckoutNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CheckoutNotFoundResponseDto handleCheckoutException(CheckoutNotFoundException exception) {
        String message = exception.getMessage();
        return new CheckoutNotFoundResponseDto(message);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public OrderNotFoundResponseDto handleOrderException(OrderNotFoundException exception) {
        String message = exception.getMessage();
        return new OrderNotFoundResponseDto(message);
    }

    @ExceptionHandler(CreateOrderException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserNotFoundResponseDto handleOrderException(CreateOrderException exception) {
        String message = exception.getMessage();
        return new UserNotFoundResponseDto(message);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProductNotFoundResponseDto handleProductException(ProductNotFoundException exception) {
        String message = exception.getMessage();
        return new ProductNotFoundResponseDto(message);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UserNotFoundResponseDto handleUserException(UserNotFoundException exception) {
        String message = exception.getMessage();
        return new UserNotFoundResponseDto(message);
    }
}
