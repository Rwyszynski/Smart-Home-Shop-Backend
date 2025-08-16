package com.kodilla.smarthomeshop.component;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
@Component
@RequiredArgsConstructor
public class WeatherApi {

    private final RestTemplate restTemplate;

    @Value("${weather.api.endpoint}")
    private String weatherApiEndpoint;

    @Value("${weather.app.key}")
    private String weatherAppKey;

    public double getTemperature() {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherApiEndpoint)
                .queryParam("access_key", weatherAppKey)
                .queryParam("query", "Warsaw")
                .build()
                .encode()
                .toUri();

        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        return response.getCurrent().getTemperature();
    }
}
