package com.example.weatherapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.weatherapi.client.CityCoordinatesProvider;
import com.example.weatherapi.model.dto.WeatherApiResponse;
import com.example.weatherapi.model.dto.WeatherResponse;
import com.example.weatherapi.model.entity.Coordinates;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final String OPEN_METEO_URL = "https://api.open-meteo.com/v1/forecast";

    private final RestTemplate restTemplate;
    private final CityCoordinatesProvider coordinatesProvider;

    public WeatherResponse getWeather(String city) {
        Coordinates coordinates = coordinatesProvider.getCoordinates(city);

        String url = UriComponentsBuilder.fromUriString(OPEN_METEO_URL)
                .queryParam("latitude", coordinates.getLatitude())
                .queryParam("longitude", coordinates.getLongitude())
                .queryParam("current_weather", true).toUriString();

        ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);
        return response.getBody().toWeatherResponse();
    }
}
