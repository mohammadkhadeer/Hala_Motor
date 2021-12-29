package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class InsuranceSP {

    private static final String INSURANCE = "INSURANCE";

    public static void saveInsuranceSP(Context context,SharedPreferences SharedPreferences,
                                             SharedPreferences.Editor editor,String dontShowAgain) {
        SharedPreferences = context.getSharedPreferences(INSURANCE, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("dontShowAgain",dontShowAgain);
        editor.commit();
    }

    public static String getInsuranceStatusSP(Context context) {
        String dontShowAgain;
        SharedPreferences shared = context.getSharedPreferences(INSURANCE, MODE_PRIVATE);
        //can use any comp from user info to check
        dontShowAgain = (shared.getString("dontShowAgain", ""));
        if (dontShowAgain.equals("") || dontShowAgain == null)
            return  "empty";
        else
            return  dontShowAgain;
    }

    public static void cleanInsuranceStatus(Context context,SharedPreferences SharedPreferences,
                                  SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(INSURANCE, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("dontShowAgain","");
        editor.commit();
    }

}
