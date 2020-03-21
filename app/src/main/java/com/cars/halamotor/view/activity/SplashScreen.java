package com.cars.halamotor.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.model.WheelsRimModel;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertAccAndJunkItemInAccAndJunkTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertAccAndJunkTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCCEMTItemInCCEMTTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCCEMTItemTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCarPlatesItemInCarPlatesTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCarPlatesItemTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertWheelsRimInWheelsRimTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertWheelsRimItemTable;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getAccessoriesItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForExchangeItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForRentItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForSaleItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getJunkCarItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getMotorcycleItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getPlatesItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getTruckItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getWheelsRimItems;
import static com.cars.halamotor.functions.Functions.getNotification;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getUnreadNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getWelcomeNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.welcomeNotifications;

public class SplashScreen extends AppCompatActivity {

    List<CCEMT> carForRentList = new ArrayList<>();
    List<CCEMT> carForSaleList = new ArrayList<>();
    List<CCEMT> carForExchangeList = new ArrayList<>();
    List<CCEMT> motorcycleList = new ArrayList<>();
    List<CCEMT> truckList = new ArrayList<>();
    List<CarPlatesModel> carPlatesList = new ArrayList<>();
    List<WheelsRimModel> wheelsRimList = new ArrayList<>();
    List<AccAndJunk> accessoriesArrayL = new ArrayList<>();
    List<AccAndJunk> junkArrayL = new ArrayList<>();

    List<CCEMT> carForRentListIndependent = new ArrayList<>();
    List<CCEMT> carForSaleListIndependent = new ArrayList<>();
    List<CCEMT> carForExchangeListIndependent = new ArrayList<>();
    List<CCEMT> motorcycleListIndependent = new ArrayList<>();
    List<CCEMT> truckListIndependent = new ArrayList<>();
    List<CarPlatesModel> carPlatesListIndependent = new ArrayList<>();
    List<WheelsRimModel> wheelsRimListIndependent = new ArrayList<>();
    List<AccAndJunk> accessoriesArrayLIndependent = new ArrayList<>();
    List<AccAndJunk> junkArrayLIndependent = new ArrayList<>();

    DBHelper myDB;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        myDB = getDataBaseInstance(getApplicationContext());
        addWelcomeNotifications();
        getJunkCar();
        getAccessories();
        getWheelsRim();
        getCarPlates();
        getTrucks();
        getMotorcycle();
        getCarForRent();
        getCarForSale();
        getCarExchange();
        //////////////Independent list in main screen 9 item in every list
        getCarExchangeIndependent();
        getCarForSaleIndependent();
        getCarForRentIndependent();
        getMotorcycleIndependent();
        getTrucksIndependent();
        getWheelsRimIndependent();
        getCarPlatesIndependent();
        getAccessoriesIndependent();
        getJunkCarIndependent();

        transportToMainActivity();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addWelcomeNotifications() {
        if (getWelcomeNotificationsInSP(this) ==null)
        {
            NotificationComp welcomeNotification = getNotification(
                    "welcome", "Hala Motor" ,this,"welcome","welcome","welcome"
                    ,"R.drawable.logo"
            );
            insertNotificationTable(welcomeNotification,getDataBaseInstance(this));
            welcomeNotifications(this,sharedPreferences,editor,"created");
        }
    }

    private void getJunkCarIndependent() {
        junkArrayLIndependent = getJunkCarItems(junkArrayLIndependent,9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertAccAndJunkItemInAccAndJunk(junkArrayLIndependent);
            }
        }, 3700);
    }

    private void getAccessoriesIndependent() {
        accessoriesArrayLIndependent = getAccessoriesItems(accessoriesArrayLIndependent,9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { insertAccAndJunkItemInAccAndJunk(accessoriesArrayLIndependent);
            }
        }, 3700);
    }

    private void insertAccAndJunkItemInAccAndJunk(List<AccAndJunk> accAndJunksArrayLIndependent) {
        for (int i=0;i<accAndJunksArrayLIndependent.size();i++)
        {
            insertAccAndJunkItemInAccAndJunkTable(accAndJunksArrayLIndependent.get(i),myDB);
        }
    }

    private void getCarPlatesIndependent() {
        carPlatesListIndependent = getPlatesItems(carPlatesListIndependent,9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertCarPlatesToCarPlatesTable(carPlatesListIndependent);
            }
        }, 3700);
    }

    private void insertCarPlatesToCarPlatesTable(List<CarPlatesModel> carPlatesListIndependent) {
        for (int i=0;i<carPlatesListIndependent.size();i++)
        {
            insertCarPlatesItemInCarPlatesTable(carPlatesListIndependent.get(i),myDB);
        }
    }

    private void getWheelsRimIndependent() {
        wheelsRimListIndependent = getWheelsRimItems(wheelsRimListIndependent,9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertWheelsRimToWheelsRimTable(wheelsRimListIndependent);
            }
        }, 3700);
    }

    private void insertWheelsRimToWheelsRimTable(List<WheelsRimModel> wheelsRimListIndependent) {
        for (int i=0;i<wheelsRimListIndependent.size();i++)
        {
            insertWheelsRimInWheelsRimTable(wheelsRimListIndependent.get(i),myDB);
        }
    }

    private void getTrucksIndependent() {
        truckListIndependent = getTruckItems(truckListIndependent,9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(truckListIndependent);
            }
        }, 3700);
    }

    private void getMotorcycleIndependent() {
        motorcycleListIndependent = getMotorcycleItems(motorcycleListIndependent,9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertCarForSaleToCCMETTable(motorcycleListIndependent);
            }
        }, 3700);
    }

    private void getCarForRentIndependent() {
        carForRentListIndependent = getCarForRentItems(carForRentListIndependent,9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(carForRentListIndependent);
            }
        }, 3700);
    }

    private void getCarExchangeIndependent() {
        carForExchangeListIndependent = getCarForExchangeItems(carForExchangeListIndependent,9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() { insertCarForSaleToCCMETTable(carForExchangeListIndependent);
            }
        }, 3700);
    }

    private void getCarForSaleIndependent() {
        carForSaleListIndependent = getCarForSaleItems(carForSaleListIndependent,9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(carForSaleListIndependent);
            }
        }, 3700);
    }

    private void insertCarForSaleToCCMETTable(List<CCEMT> ccemtList) {
        for (int i = 0; i< ccemtList.size(); i++)
        {
            insertCCEMTItemInCCEMTTable(ccemtList.get(i),myDB);
        }
    }

    private void getJunkCar() {
        junkArrayL = getJunkCarItems(junkArrayL,1);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertJunkRimToDataBase();
            }
        }, 2700);
    }

    private void getAccessories() {
        accessoriesArrayL = getAccessoriesItems(accessoriesArrayL,1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { insertAccessoriesRimToDataBase();
            }
        }, 2700);
    }

    private void getWheelsRim() {
        wheelsRimList = getWheelsRimItems(wheelsRimList,1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertWheelsRimToDataBase();
            }
        }, 2700);
    }

    private void getCarPlates() {
        carPlatesList = getPlatesItems(carPlatesList,1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertCarPlatesToDataBase();
            }
        }, 2700);
    }

    private void getTrucks() {
        truckList = getTruckItems(truckList,1);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertTruckToDataBase();
            }
        }, 2700);
    }

    private void getMotorcycle() {
        motorcycleList = getMotorcycleItems(motorcycleList,1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertMotorcycleToDataBase();
            }
        }, 2700);
    }

    private void getCarExchange() {
        carForExchangeList = getCarForExchangeItems(carForExchangeList,2);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() { insertCarForExchangeToDataBase();
            }
        }, 2700);
    }

    private void getCarForRent() {
        carForRentList = getCarForRentItems(carForRentList,2);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForRentToDataBase();
            }
        }, 2700);
    }

    private void getCarForSale() {
        carForSaleList = getCarForSaleItems(carForSaleList,2);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToDataBase();
            }
        }, 2700);
    }

    private void insertCarForSaleToDataBase() {
        for (int i=0;i<carForRentList.size();i++)
        {
            insertCCEMTItemTable(carForSaleList.get(i),myDB);
        }
    }

    private void insertCarForRentToDataBase() {
        for (int i=0;i<carForRentList.size();i++)
        {
            insertCCEMTItemTable(carForRentList.get(i),myDB);
        }
    }

    private void insertCarForExchangeToDataBase() {
        for (int i=0;i<carForExchangeList.size();i++)
        {
            insertCCEMTItemTable(carForExchangeList.get(i),myDB);
        }
    }

    private void insertMotorcycleToDataBase() {
        for (int i=0;i<motorcycleList.size();i++)
        {
            insertCCEMTItemTable(motorcycleList.get(i),myDB);
        }
    }

    private void insertTruckToDataBase() {
        for (int i=0;i<truckList.size();i++)
        {
            insertCCEMTItemTable(truckList.get(i),myDB);
        }
    }

    private void insertCarPlatesToDataBase() {
        for (int i=0;i<carPlatesList.size();i++)
        {
            insertCarPlatesItemTable(carPlatesList.get(i),myDB);
        }
    }

    private void insertWheelsRimToDataBase() {
        for (int i=0;i<wheelsRimList.size();i++)
        {
            insertWheelsRimItemTable(wheelsRimList.get(i),myDB);
        }
    }

    private void insertAccessoriesRimToDataBase() {
        for (int i=0;i<accessoriesArrayL.size();i++)
        {
            insertAccAndJunkTable(accessoriesArrayL.get(i),myDB);
        }
    }

    private void insertJunkRimToDataBase() {
        for (int i=0;i<junkArrayL.size();i++)
        {
            insertAccAndJunkTable(junkArrayL.get(i),myDB);
        }
    }

    private void transportToMainActivity() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                finish();
            }
        }, 4000);
    }

}
