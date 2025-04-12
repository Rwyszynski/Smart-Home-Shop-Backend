package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ProductListDto {

    private Long id;
    private User user;
    private List<Checkout> checkoutIds;
}
