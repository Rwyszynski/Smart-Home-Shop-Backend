package com.kodilla.smarthomeshop.controller;

import com.kodilla.smarthomeshop.component.WeatherApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@CrossOrigin
public class WeatherController {

    private final WeatherApi weatherApi;

    @GetMapping("/temperature")
    public String getCurrentTemperature() {
        return weatherApi.getTemperature();
    }
}
