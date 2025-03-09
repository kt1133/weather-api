package com.example.weatherapi.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.weatherapi.model.dto.NominatimResponse;
import com.example.weatherapi.model.entity.Coordinates;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CityCoordinatesProvider {

    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search";

    private final RestTemplate restTemplate;

    public Coordinates getCoordinates(String city) {
        String url = UriComponentsBuilder.fromUriString(NOMINATIM_URL)
                .queryParam("format", "json")
                .queryParam("q", city)
                .toUriString();

        NominatimResponse[] response = restTemplate.getForObject(url, NominatimResponse[].class);
        if (response != null && response.length > 0) {
            return new Coordinates(Double.parseDouble(response[0].getLat()), Double.parseDouble(response[0].getLon()));
        }

        throw new RuntimeException("Location not found");
    }
}
