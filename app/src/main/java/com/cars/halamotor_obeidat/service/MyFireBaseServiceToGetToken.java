package com.cars.halamotor_obeidat.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;


public class MyFireBaseServiceToGetToken extends FirebaseMessagingService {

    SharedPreferences.Editor  editor;
    SharedPreferences sharedPreferences;

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.e("TAG newToken", "here service");
        Log.e("TAG newToken", token);
        getSharedPreferences("REGISTER", MODE_PRIVATE).edit().putString("userToken", token).apply();

    }

    public static String getToken(Context context) {
        return context.getSharedPreferences("REGISTER", MODE_PRIVATE).getString("userToken", "");
    }

}
