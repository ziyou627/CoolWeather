package com.wzq.coolweather;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wzq on 18-4-11.
 */

public class MyApplication extends Application {
    private static Context context;
    private static MyDatabaseHelper dbHelper;
    private static SQLiteDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        dbHelper = new MyDatabaseHelper(context,"mydb.db",null,1);
        db = dbHelper.getWritableDatabase();
    }
    public static SQLiteDatabase getDb(){
        return db;
    }
    public static Context getContext(){
        return context;
    }
}
