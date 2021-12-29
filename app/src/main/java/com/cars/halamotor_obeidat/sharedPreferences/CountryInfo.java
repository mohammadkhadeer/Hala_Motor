package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class CountryInfo {
    static SharedPreferences SharedPreferences;
    static SharedPreferences.Editor editor;

    private static final String COUNTRY_INFO = "COUNTRY_INFO";

    public static void saveUserInfoSP(Context context, String id, String code,String name,String name_en,String name_ar) {
        SharedPreferences = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("id",id);
        editor.putString("code",code);
        editor.putString("name",name);
        editor.putString("name_en",name_en);
        editor.putString("name_ar",name_ar);
        editor.commit();
    }


    public static String getCountryId(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("id", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getCountryCode(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("code", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getCountryName(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getCountryNameEn(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name_en", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getCountryNameAr(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY_INFO, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name_ar", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

}
