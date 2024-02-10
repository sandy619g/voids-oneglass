package com.voids.model;
import lombok.Data;

import java.util.List;

@Data
public class WeatherForecast {

    private List<WeatherDay> days;

}

@Data
class WeatherDay {

    private String datetime;
    private long datetimeEpoch;
    private double tempmax;
    private double tempmin;
    private double temp;
    private String conditions;

}


