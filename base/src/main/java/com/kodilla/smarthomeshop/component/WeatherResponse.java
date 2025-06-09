package com.kodilla.smarthomeshop.component;

import lombok.Data;

@Data
public class WeatherResponse {
    private Current current;

    @Data
    public static class Current {
        private double temperature;
    }
}
