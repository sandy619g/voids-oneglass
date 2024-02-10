package com.voids.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ForecastComparison {

    private List<SalesForecast> salesForecasts;
    private WeatherForecast weatherForecast;

}

