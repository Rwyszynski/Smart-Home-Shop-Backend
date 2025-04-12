package com.kodilla.smarthomeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "productList")
public class ProductList {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    private Integer userId;

    @OneToMany(mappedBy = "productList", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIgnore
    private List<Checkout> checkoutIds = new ArrayList<>();
}
