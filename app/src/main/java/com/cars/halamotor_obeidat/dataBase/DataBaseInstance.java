package com.cars.halamotor_obeidat.dataBase;

import android.content.Context;

public class DataBaseInstance {

    public static DBHelper getDataBaseInstance(Context context) {
        DBHelper database = new DBHelper(context);
        return  database;
    }

    public static DBHelper2 getDataBaseInstance2(Context context) {
        DBHelper2 database = new DBHelper2(context);
        return  database;
    }

    public static DBHelper3 getDataBaseInstance3(Context context) {
        DBHelper3 database = new DBHelper3(context);
        return  database;
    }
}
