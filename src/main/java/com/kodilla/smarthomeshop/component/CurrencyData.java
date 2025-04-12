package com.kodilla.smarthomeshop.component;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class CurrencyData {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
