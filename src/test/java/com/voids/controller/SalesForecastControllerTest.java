package com.voids.controller;

import com.voids.exception.ResourceNotFoundException;
import com.voids.model.ForecastComparison;
import com.voids.model.SalesForecast;
import com.voids.model.WeatherForecast;
import com.voids.service.SalesForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalesForecastControllerTest {

    @Mock
    private SalesForecastService salesForecastService;

    @InjectMocks
    private SalesForecastController salesForecastController;

    private String location;
    private String startDate;
    private String endDate;

    @BeforeEach
    void setUp() {
        location = "TestLocation";
        startDate = "2024-02-15";
        endDate = "2024-02-20";
    }

    @Test
    void getSalesForecastForDateRange_ReturnsSalesForecasts_WhenServiceReturnsForecasts() {
        List<SalesForecast> expectedForecasts = new ArrayList<>();
        expectedForecasts.add(new SalesForecast());
        when(salesForecastService.getSalesForecastForDateRange(location, startDate, endDate))
                .thenReturn(expectedForecasts);

        ResponseEntity<List<SalesForecast>> responseEntity =
                salesForecastController.getSalesForecastForDateRange(location, startDate, endDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expectedForecasts, responseEntity.getBody());
    }

    @Test
    void getSalesForecastForDateRange_ThrowsResourceNotFoundException_WhenServiceThrowsException() {
        when(salesForecastService.getSalesForecastForDateRange(location, startDate, endDate))
                .thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class,
                () -> salesForecastController.getSalesForecastForDateRange(location, startDate, endDate));
    }

    @Test
    void compareForecasts_ReturnsComparison_WhenServiceReturnsForecasts() {
        List<SalesForecast> expectedForecasts = new ArrayList<>();
        expectedForecasts.add(new SalesForecast());
        WeatherForecast expectedWeatherForecast = new WeatherForecast();
        when(salesForecastService.getSalesForecastForDateRange(location, startDate, endDate))
                .thenReturn(expectedForecasts);
        when(salesForecastService.getWeatherForecastForDateRange(location, startDate, endDate))
                .thenReturn(expectedWeatherForecast);

        ResponseEntity<ForecastComparison> responseEntity =
                salesForecastController.compareForecasts(location, startDate, endDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(expectedForecasts, responseEntity.getBody().getSalesForecasts());
        assertEquals(expectedWeatherForecast, responseEntity.getBody().getWeatherForecast());
    }

    @Test
    void compareForecasts_ThrowsResourceNotFoundException_WhenServiceThrowsException() {
        when(salesForecastService.getSalesForecastForDateRange(location, startDate, endDate))
                .thenThrow(ResourceNotFoundException.class);

        assertThrows(ResourceNotFoundException.class,
                () -> salesForecastController.compareForecasts(location, startDate, endDate));
    }
}

