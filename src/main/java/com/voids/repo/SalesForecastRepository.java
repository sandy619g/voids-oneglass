package com.voids.repo;

import com.voids.model.SalesForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalesForecastRepository extends JpaRepository<SalesForecast, Long> {
    List<SalesForecast> findByLocationAndDateBetween(String location, String startDate, String endDate);
}


