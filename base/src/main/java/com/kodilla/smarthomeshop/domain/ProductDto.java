package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class ProductDto {

    private Long component_id;
    private String brand;
    private String model;
    private int voltage;
    private int power;
    private String protocol;
    private int current;
    private double price;
    private String url;
}
