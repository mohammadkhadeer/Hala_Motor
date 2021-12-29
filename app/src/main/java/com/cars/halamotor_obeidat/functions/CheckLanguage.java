package com.cars.halamotor_obeidat.functions;

import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;

import android.content.Context;

public class CheckLanguage {
    public static String checkLanguage (String en, String ar, Context context) {
        String text;
        if (getUserLanguage(context).equals("en"))
            text = en;
        else
            text =ar;

        return  text;
    }
}
