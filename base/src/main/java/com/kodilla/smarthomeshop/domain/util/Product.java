package com.kodilla.smarthomeshop.domain.util;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity(name = "component")
class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_seq")
    @SequenceGenerator(name = "component_seq", sequenceName = "component_seq", allocationSize = 1)
    private Long component_id;
    private String brand;
    private String model;
    private int voltage;
    private int power;
    private String protocol;
    private int current;
    private double price;
    private String url;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Product(String brand, String model, int voltage, int power, String protocol, int current, double price, String url, Type type) {
        this.brand = brand;
        this.model = model;
        this.voltage = voltage;
        this.power = power;
        this.protocol = protocol;
        this.current = current;
        this.price = price;
        this.url = url;
        this.type = type;
    }
}


