package com.cars.halamotor_obeidat.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="cars.db";

    public static final String TABLE_C_INFORMATION="Cars";
    public static final String COL_C_MA_ID="ID";
    public static final String COL_C_MA_EN="CAR_MAKE_EN";
    public static final String COL_C_MA_AR="CAR_MAKE_AR";
    public static final String COL_C_MA_S="CAR_MAKE_S";
    public static final String COL_C_MO_EN="CAR_MODEL_EN";
    public static final String COL_C_MO_AR="CAR_MODEL_AR";
    public static final String COL_C_MO_S="CAR_MODEL_S";


    public DBHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_C_INFORMATION +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CAR_MAKE_EN TEXT" + ",CAR_MAKE_AR TEXT" + ",CAR_MAKE_S TEXT" + ",CAR_MODEL_EN TEXT" + ",CAR_MODEL_AR TEXT" + ",CAR_MODEL_S TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_C_INFORMATION);

        onCreate(db);
    }

    ///////////////////////insert data//////////////////////////////////////////

    public boolean insertCars(String carMakeEn,String carMakeAr
            ,String carMakeS,String carModelEn,String carModelAr,String carModelS)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_C_MA_EN,carMakeEn);
        contentValues.put(COL_C_MA_AR,carMakeAr);
        contentValues.put(COL_C_MA_S,carMakeS);
        contentValues.put(COL_C_MO_EN,carModelEn);
        contentValues.put(COL_C_MO_AR,carModelAr);
        contentValues.put(COL_C_MO_S,carModelS);

        long result= db.insert(TABLE_C_INFORMATION,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

}
