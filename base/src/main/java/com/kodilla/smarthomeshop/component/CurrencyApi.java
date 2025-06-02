package com.kodilla.smarthomeshop.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class CurrencyApi {

    private final RestTemplate restTemplate;

    public double getEuroExchangeRate() throws Exception {
        double exchangeRate = restTemplate.getForObject(
            "https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json", Double.class
        );
        return exchangeRate;
    }
}
