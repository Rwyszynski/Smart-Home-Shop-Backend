package com.kodilla.smarthomeshop.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class CurrencyApi {

    private final RestTemplate restTemplate;

    public double getEuroExchangeRate() throws Exception {
        CurrencyData data = restTemplate.getForObject(
                "https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json",
                CurrencyData.class
        );

        if (data != null && data.getRates() != null && !data.getRates().isEmpty()) {
            return data.getRates().get(0).getMid();
        } else {
            throw new Exception("Brak danych o kursie euro");
        }
    }
}