package com.cars.halamotor.functions;

import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

import android.content.Context;

import com.cars.halamotor.model.CategoryComp;

import java.util.ArrayList;

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
