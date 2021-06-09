package com.cars.halamotor.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.cars.halamotor.dataBase.DBHelper;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.presnter.CarsBrandsAndModels.getCarsBrandsAndModel;


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
            DBHelper myDB= getDataBaseInstance(getApplicationContext());
            getCarsBrandsAndModel(myDB);
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