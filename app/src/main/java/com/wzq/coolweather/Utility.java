package com.wzq.coolweather;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.wzq.coolweather.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wzq on 18-4-11.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        SQLiteDatabase db = MyApplication.getDb();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int provinceCode = jsonObject.getInt("id");
                String provinceName = jsonObject.getString("name");
                ContentValues values = new ContentValues();
                values.put("provinceCode",provinceCode);
                values.put("provinceName",provinceName);
                db.insert("province",null,values);
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        SQLiteDatabase db = MyApplication.getDb();
        try{
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ContentValues values = new ContentValues();
                values.put("cityName",jsonObject.getString("name"));
                values.put("cityCode",jsonObject.getString("id"));
                values.put("provinceId",provinceId);
                db.insert("city",null,values);
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean handleCountyResponse(String response, int cityId){
        SQLiteDatabase db = MyApplication.getDb();
        try{
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i < jsonArray.length(); i++){
                Log.d("CoolWeather",jsonArray.length()+ "");
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ContentValues values = new ContentValues();
                values.put("countyName",jsonObject.getString("name"));
                values.put("countyCode",jsonObject.getInt("id"));
                values.put("weatherId",jsonObject.getString("weather_id"));
                values.put("cityId",cityId);
                db.insert("county",null,values);
            }
            return true;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return false;
    }
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
