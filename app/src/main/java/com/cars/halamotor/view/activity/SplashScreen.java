package com.cars.halamotor.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.WheelsRimModel;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertAccAndJunkTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCCEMTItemTable;
import static com.cars.halamotor.dataBase.InsertFunctions.insertCarPlatesItemTable;
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
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        myDB = getDataBaseInstance(getApplicationContext());
        getJunkCar();
        getAccessories();
        getWheelsRim();
        getCarPlates();
        getTrucks();
        getMotorcycle();
        getCarForRent();
        getCarForSale();
        getCarExchange();
        transportToMainActivity();

    }

    private void getJunkCar() {
        junkArrayL = getJunkCarItems(junkArrayL);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertJunkRimToDataBase();
            }
        }, 2700);
    }

    private void getAccessories() {
        accessoriesArrayL = getAccessoriesItems(accessoriesArrayL);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertAccessoriesRimToDataBase();
            }
        }, 2700);
    }

    private void getWheelsRim() {

        wheelsRimList = getWheelsRimItems(wheelsRimList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertWheelsRimToDataBase();
            }
        }, 2700);
    }

    private void getCarPlates() {
        carPlatesList = getPlatesItems(carPlatesList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarPlatesToDataBase();
            }
        }, 2700);
    }

    private void getTrucks() {
        truckList = getTruckItems(truckList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertTruckToDataBase();
            }
        }, 2700);
    }

    private void getMotorcycle() {
        motorcycleList = getMotorcycleItems(motorcycleList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertMotorcycleToDataBase();
            }
        }, 2700);
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

    private void getCarExchange() {
        carForExchangeList = getCarForExchangeItems(carForExchangeList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForExchangeToDataBase();
            }
        }, 2700);
    }

    private void getCarForSale() {
        carForSaleList = getCarForSaleItems(carForSaleList);
        //set Handler to get items
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

    private void getCarForRent() {
        carForRentList = getCarForRentItems(carForRentList);
        //set Handler to get items
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForRentToDataBase();
            }
        }, 2700);
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

}
