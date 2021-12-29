package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class CarsAndModels {
    static SharedPreferences SharedPreferences;
    static SharedPreferences.Editor editor;

    //will use this SP to re take cars and models every 10 times
    //when user use the app every 10 times
    private static final String CARS_AND_MODELS = "CARS_AND_MODELS";

    public static void saveUserInfoSP(Context context, String numberOfUse) {
        SharedPreferences = context.getSharedPreferences(CARS_AND_MODELS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("numberOfUse",numberOfUse);
        editor.commit();
    }


    public static String getNumberOfUse(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(CARS_AND_MODELS, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("numberOfUse", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static void cleanNumberOfUse(Context context) {
        SharedPreferences = context.getSharedPreferences(CARS_AND_MODELS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("numberOfUse","");
        editor.commit();
    }

}
