package com.wzq.coolweather;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wzq on 18-4-11.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_PROVINCE_TABLE = "create table province(" +
            "id integer primary key autoincrement," +
            "provinceName text," +
            "provinceCode integer unique)";
    private static final String CREATE_CITY_TABLE = "create table city(" +
            "id integer primary key autoincrement," +
            "cityName text," +
            "cityCode integer unique," +
            "provinceId integer," +
            "foreign key (provinceId) references province(id))";
    private static final String CREATE_COUNTY_TABLE = "create table county(" +
            "id integer primary key autoincrement," +
            "countyName text," +
            "countyCode integer unique," +
            "weatherId text unique," +
            "cityId integer," +
            "foreign key (cityId) references city(id))";
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PROVINCE_TABLE);
        sqLiteDatabase.execSQL(CREATE_CITY_TABLE);
        sqLiteDatabase.execSQL(CREATE_COUNTY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
