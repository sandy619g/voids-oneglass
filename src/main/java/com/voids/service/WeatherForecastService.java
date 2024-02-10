package com.voids.service;

import com.voids.exception.ResourceNotFoundException;
import com.voids.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherForecastService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherForecast getWeatherForecast(String city, String startDate, String endDate) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/" + city + "/" + startDate + "/" + endDate + "?key=" + apiKey;
        WeatherForecast weatherForecast = restTemplate.getForObject(url, WeatherForecast.class);
        if (weatherForecast == null || weatherForecast.getDays() == null || weatherForecast.getDays().isEmpty()) {
            throw new ResourceNotFoundException("Weather forecast not found for the specified date range");
        }
        return weatherForecast;
    }
}


