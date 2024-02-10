package com.voids.service;

import com.voids.model.SalesForecast;
import com.voids.model.WeatherForecast;
import com.voids.repo.SalesForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesForecastService {

    @Autowired
    private SalesForecastRepository salesForecastRepository;

    @Autowired
    private WeatherForecastService weatherForecastService;

    private static final int ALERT_THRESHOLD = 1000;
    private static final int SUBSEQUENT_DAYS = 3;

    public List<SalesForecast> getSalesForecastForDateRange(String location, String startDate, String endDate) {
        return salesForecastRepository.findByLocationAndDateBetween(location,
                startDate, endDate);
    }

    public WeatherForecast getWeatherForecastForDateRange(String city, String startDate, String endDate) {
        return weatherForecastService.getWeatherForecast(city, startDate, endDate);
    }

    /*@Scheduled(fixedRate = 86400000)
    public void checkSalesForecastAndGenerateAlert() {
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < SUBSEQUENT_DAYS; i++) {
            LocalDate dateToCheck = currentDate.plusDays(i);
            List<SalesForecast> salesForecasts = salesForecastRepository.findByLocationAndDateBetween(location,currentDate.toString(),dateToCheck.toString());
            for (SalesForecast forecast : salesForecasts) {
                if (forecast.getForecastedSalesQuantity() < ALERT_THRESHOLD) {
                    generateClosureAlert();
                }
            }
        }
    }*/

    private void generateClosureAlert() {
        System.out.println("Alert: Forecasted sales quantities are below 1000 units in three subsequent days. Close the store!");
    }
}
