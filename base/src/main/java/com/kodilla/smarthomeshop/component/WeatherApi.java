package com.kodilla.smarthomeshop.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Component
@Data
public class WeatherApi {

    private final RestTemplate restTemplate;

    @Value("${weather.api.endpoint.prod}")
    private String weatherApiEndpoint;
    @Value("${weather.app.key}")
    private String weatherAppKey;

    public String getTemperature() {
        URI url = UriComponentsBuilder.fromHttpUrl(weatherApiEndpoint + "?access_key=")
                .queryParam("key", weatherAppKey)
                .build()
                .encode()
                .toUri();
        String temperature = restTemplate.getForObject(url, String.class);

        return temperature;
    }
}

