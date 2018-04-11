package com.wzq.coolweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wzq on 18-4-11.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
