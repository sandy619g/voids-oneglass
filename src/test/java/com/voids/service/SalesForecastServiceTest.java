package com.voids.service;

import com.voids.model.SalesForecast;
import com.voids.model.WeatherForecast;
import com.voids.repo.SalesForecastRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalesForecastServiceTest {

    public static final String DATE = "2024-02-10";
    public static final String HAMBURG = "HAMBURG";
    @Mock
    private SalesForecastRepository salesForecastRepository;

    @Mock
    private WeatherForecastService weatherForecastService;

    @InjectMocks
    private SalesForecastService salesForecastService;

    private List<SalesForecast> salesForecasts;
    private WeatherForecast weatherForecast;

    @BeforeEach
    public void setUp() {
        salesForecasts = new ArrayList<>();
        salesForecasts.add(new SalesForecast(1L, DATE, HAMBURG, 100L));
        salesForecasts.add(new SalesForecast(2L,"2024-02-11", HAMBURG, 200L));

        weatherForecast = new WeatherForecast();
    }

    @Test
    public void testGetSalesForecastForDateRange() {
        when(salesForecastRepository.findByLocationAndDateBetween(HAMBURG, DATE, "2024-02-12"))
                .thenReturn(salesForecasts);

        List<SalesForecast> result = salesForecastService.getSalesForecastForDateRange(HAMBURG, DATE, "2024-02-12");

        assertEquals(salesForecasts, result);
    }
}

