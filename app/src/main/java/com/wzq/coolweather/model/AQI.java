package com.wzq.coolweather.model;

/**
 * Created by wzq on 18-4-11.
 */

public class AQI {
    public AQICity city;
    public class AQICity {
        public String api;
        public String pm25;
    }
}
