package com.wzq.coolweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wzq on 18-4-11.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
