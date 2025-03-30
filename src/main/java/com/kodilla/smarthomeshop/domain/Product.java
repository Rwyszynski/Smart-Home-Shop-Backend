package com.kodilla.smarthomeshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity(name = "component")
public class Product {

    @Id
    @GeneratedValue
    private Long componentlist_id;
    private String brand;
    private String model;
    private int voltage;
    private int power;
    private String protocol;
    private int current;
    private double price;
}


