package com.example.weatherapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapi.model.dto.WeatherResponse;
import com.example.weatherapi.service.WeatherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    
    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) {
        // 指定都市の天気情報を取得する
        WeatherResponse weather = weatherService.getWeather(city);
        // レスポンス情報に載せて返却
        return ResponseEntity.ok(weather);
    }
}
