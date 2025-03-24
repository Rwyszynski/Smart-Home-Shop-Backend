package com.kodilla.smarthomeshop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class ProductDto {

    private Long componentlist_id;
    private String brand;
    private String model;
    private int voltege;
    private int power;
    private String protocol;
    private double price;
    private int current;
}
