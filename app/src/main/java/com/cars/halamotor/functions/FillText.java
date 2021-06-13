package com.cars.halamotor.functions;

import android.content.Context;
import android.util.Log;

import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class FillText {
    public static String getTextEngOrLocal(Context context, String eng, String local) {
//        if (Locale.getDefault().getLanguage().equals("en"))
        if (getUserLanguage(context).equals("en"))
            return eng;
        else
            return local;
    }
}
