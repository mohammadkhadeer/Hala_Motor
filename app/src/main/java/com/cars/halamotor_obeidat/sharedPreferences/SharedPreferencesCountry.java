package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesCountry {

    private static final String COUNTRY = "COUNTRY";
    static SharedPreferences SharedPreferences;
    static SharedPreferences.Editor Editor;

    public static void saveUserInfoInSP(Context context, String id, String code
            , String name, String name_en, String name_ar) {
        SharedPreferences = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        Editor = SharedPreferences.edit();
        Editor.putString("id",id);
        Editor.putString("code",code);
        Editor.putString("name",name);
        Editor.putString("name_en",name_en);
        Editor.putString("name_ar",name_ar);

        Editor.commit();
    }

    public static String getCountryID(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("id", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

    public static String getCountryCode(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("code", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

    public static String getCountryName(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

    public static String getCountryNameEng(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name_en", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

    public static String getCountryNameArabic(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(COUNTRY, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name_ar", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

}
