package com.kodilla.smarthomeshop.domain.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    private Long OrderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String orderStatus;
    private String orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Checkout> orderedItems = new ArrayList<>();

    public Order(Long userId, String orderStatus, String orderDate, List<Checkout> orderedItems) {
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderedItems = orderedItems;
    }
}
