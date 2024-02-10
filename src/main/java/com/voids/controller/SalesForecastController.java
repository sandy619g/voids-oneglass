package com.voids.controller;

import com.voids.exception.ResourceNotFoundException;
import com.voids.model.ForecastComparison;
import com.voids.model.SalesForecast;
import com.voids.model.WeatherForecast;
import com.voids.service.SalesForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesForecastController {

    @Autowired
    private SalesForecastService salesForecastService;

    @GetMapping("/{location}/forecast")
    public ResponseEntity<List<SalesForecast>> getSalesForecastForDateRange(
            @PathVariable String location,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        try {
            List<SalesForecast> salesForecasts = salesForecastService.getSalesForecastForDateRange(location, startDate, endDate);
            return ResponseEntity.ok(salesForecasts);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Sales forecast not found for the specified date range");
        }
    }

    @GetMapping("/{location}/compare-forecasts")
    public ResponseEntity<ForecastComparison> compareForecasts(
            @PathVariable String location,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        try {
            List<SalesForecast> salesForecasts = salesForecastService.getSalesForecastForDateRange(location, startDate, endDate);
            WeatherForecast weatherForecast = salesForecastService.getWeatherForecastForDateRange(location, startDate, endDate);

            ForecastComparison comparison = new ForecastComparison(salesForecasts, weatherForecast);
            return ResponseEntity.ok(comparison);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Failed to compare forecasts");
        }
    }
}
