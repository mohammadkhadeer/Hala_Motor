package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AddressSharedPreferences {
    private static final String REGISTER = "REGISTER";
    static SharedPreferences SharedPreferences;
    static SharedPreferences.Editor Editor;

    public static void saveUserInfoInSP(Context context,  String city_en, String city_ar
            ,String city_code,String city_id,String area_id,String area_name_en,String area_name_ar) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        Editor = SharedPreferences.edit();
        Editor.putString("city_en",city_en);
        Editor.putString("city_ar",city_ar);
        Editor.putString("city_code",city_code);
        Editor.putString("city_id",city_id);

        Editor.putString("area_id",area_id);
        Editor.putString("area_name_en",area_name_en);
        Editor.putString("area_name_ar",area_name_ar);

        Editor.commit();
    }

    public static String getUserAddressFromSP(Context context) {
        String userCity,userNeighborhood,userAddress;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        userCity = (shared.getString("city_en", ""));
        userNeighborhood = (shared.getString("area_name_en", ""));
        userAddress = userCity + userNeighborhood ;
        if (userAddress.equals("") || userAddress == null) {
            return  null;
        }
        else {
            return  userAddress;
        }
    }

    public static String getUserNeighborhoodFromSP(Context context) {
        String userNeighborhood;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        userNeighborhood = (shared.getString("area_name_en", ""));
        if (userNeighborhood.equals("") || userNeighborhood == null) {
            return  null;
        }
        else {
            return  userNeighborhood;
        }
    }

    public static String getAreaID(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("areaID", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

}
