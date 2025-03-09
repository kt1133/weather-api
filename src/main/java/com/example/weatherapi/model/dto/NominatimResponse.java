package com.example.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NominatimResponse {

    private String lat;
    private String lon;
}
