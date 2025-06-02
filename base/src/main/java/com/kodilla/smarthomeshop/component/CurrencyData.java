package com.kodilla.smarthomeshop.component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyData {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
