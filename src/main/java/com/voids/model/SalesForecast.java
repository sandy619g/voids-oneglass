package com.voids.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(setterPrefix = "with")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forecasts")
public class SalesForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String location;

    private Long forecastedSalesQuantity;

}

