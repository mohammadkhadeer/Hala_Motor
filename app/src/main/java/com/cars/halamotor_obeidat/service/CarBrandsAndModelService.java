package com.cars.halamotor_obeidat.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.cars.halamotor_obeidat.dataBase.DBHelper;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.presnter.CarsBrandsAndModels.getCarsBrandsAndModel;


public class CarBrandsAndModelService extends Service {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        if(intent != null){
            Log.i("TAG", "getCarsBrandsAndModel service: ");
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    DBHelper myDB= getDataBaseInstance(getApplicationContext());
                    getCarsBrandsAndModel(myDB);
                }
            });
            thread.start();

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