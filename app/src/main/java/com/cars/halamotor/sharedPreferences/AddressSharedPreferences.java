package com.cars.halamotor.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AddressSharedPreferences {
    private static final String REGISTER = "REGISTER";


    public static void saveUserInfoInSP(Context context, SharedPreferences SharedPreferences
            , SharedPreferences.Editor Editor, String city, String neighborhood) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        Editor = SharedPreferences.edit();
        Editor.putString("userCity",city);
        Editor.putString("userNeighborhood",neighborhood);

        Editor.commit();
    }

    public static String getUserAddressFromSP(Context context) {
        String userCity,userNeighborhood,userAddress;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        userCity = (shared.getString("userCity", ""));
        userNeighborhood = (shared.getString("userNeighborhood", ""));
        userAddress = userCity + userNeighborhood ;
        if (userAddress.equals("") || userAddress == null) {
            return  null;
        }
        else {
            return  userAddress;
        }
    }

}