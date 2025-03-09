package com.example.weatherapi.model.dto;

import lombok.Getter;

@Getter
public class WeatherApiResponse {

    private WeatherData current_weather;

    public WeatherResponse toWeatherResponse() {
        return new WeatherResponse(current_weather.temperature, current_weather.windspeed);
    }

    @Getter
    public static class WeatherData {
        private double temperature;
        private double windspeed;
    }
}
