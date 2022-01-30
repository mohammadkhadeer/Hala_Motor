package com.cars.halamotor_obeidat.service;


import static com.cars.halamotor_obeidat.presnter.LoginAndUpdateProfile.updateDeviceToken;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SaveFCMTokenService extends Service {
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        if(intent != null){

            Bundle b = intent.getExtras();

            if(b != null) {
                String token = b.getString("TOKEN");

                updateDeviceToken(getUserTokenFromServer(getApplicationContext()),token);

            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }


}