package com.cars.halamotor_obeidat.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper3 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="cites.db";

    public static final String TABLE_CITY_INFORMATION="cites";
    public static final String COL_CITY_ID="ID";
    public static final String COL_CITY_EN="CITY_EN";
    public static final String COL_CITY_AR="CITY_AR";
    public static final String COL_CITY_S="CITY_S";
    public static final String COL_NEIGHBORHOOD_EN="NEIGHBORHOOD_EN";
    public static final String COL_NEIGHBORHOOD_AR="NEIGHBORHOOD_AR";
    public static final String COL_NEIGHBORHOOD_S="NEIGHBORHOOD_S";


    public DBHelper3(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_CITY_INFORMATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CITY_EN TEXT" + ",CITY_AR TEXT" + ",CITY_S TEXT" + ",NEIGHBORHOOD_EN TEXT" + ",NEIGHBORHOOD_AR TEXT" + ",NEIGHBORHOOD_S TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CITY_INFORMATION);

        onCreate(db);
    }

    ///////////////////////insert data//////////////////////////////////////////

    public boolean insertCites(String cityEn,String cityAr
            ,String cityS,String neighborhoodEn,String neighborhoodAr,String neighborhoodS)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CITY_EN,cityEn);
        contentValues.put(COL_CITY_AR,cityAr);
        contentValues.put(COL_CITY_S,cityS);
        contentValues.put(COL_NEIGHBORHOOD_EN,neighborhoodEn);
        contentValues.put(COL_NEIGHBORHOOD_AR,neighborhoodAr);
        contentValues.put(COL_NEIGHBORHOOD_S,neighborhoodS);

        long result= db.insert(TABLE_CITY_INFORMATION,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}
