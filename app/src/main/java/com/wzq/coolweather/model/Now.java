package com.wzq.coolweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wzq on 18-4-11.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }

}
