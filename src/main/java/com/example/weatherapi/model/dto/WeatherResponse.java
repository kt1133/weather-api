package com.example.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherResponse {

    private double temperature;
    private double windSpeed;
}
