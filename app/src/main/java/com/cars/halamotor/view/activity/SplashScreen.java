package com.cars.halamotor.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.model.WheelsRimModel;
import com.cars.halamotor.view.activity.selectAddress.SelectCityAndNeighborhood;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getCarForSaleItemsStore;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addAccessories;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addCarForExchangeStore;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addCarForRentStore;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addCarForSaleStore;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addItemPlates;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addJunkCar;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addMotorcycle;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addTrucks;
import static com.cars.halamotor.fireBaseDB.InsertToFireBase.addWheelsRim;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getAccessoriesItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForExchangeItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForRentItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getCarForSaleItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getJunkCarItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getMotorcycleItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getPlatesItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getTruckItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireBase.getWheelsRimItems;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getAccessoriesFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getCarForSaleExchangeFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getCarForSaleItemsFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getCarForSaleRentFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getJunkCarPath;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getMotorcycleFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getPlatesFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getTrucksFireStore;
import static com.cars.halamotor.fireBaseDB.ReadFromFireStore.getWheelsRimFireStore;
import static com.cars.halamotor.functions.Functions.getNotification;
import static com.cars.halamotor.sharedPreferences.AddressSharedPreferences.getUserAddressFromSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getUnreadNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getWelcomeNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.updateNumberUnreadNotifications;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.welcomeNotifications;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;

public class SplashScreen extends AppCompatActivity {

    List<ItemCCEMT> carForExchangeListFireStore = new ArrayList<>();
    List<ItemCCEMT> carForSaleListFireStore = new ArrayList<>();
    List<ItemCCEMT> carForRentListFireStore = new ArrayList<>();
    List<ItemCCEMT> motorcycleListFireStore = new ArrayList<>();
    List<ItemCCEMT> truckListFireStore = new ArrayList<>();

    List<ItemPlates> carPlatesListFireStore = new ArrayList<>();
    List<ItemWheelsRim> wheelsRimListFireStore = new ArrayList<>();
    List<ItemAccAndJunk> accessoriesArrayLFireStore = new ArrayList<>();
    List<ItemAccAndJunk> junkArrayLFireStore = new ArrayList<>();

    List<ItemCCEMT> carForRentList = new ArrayList<>();
    List<ItemCCEMT> carForSaleList = new ArrayList<>();
    List<ItemCCEMT> carForExchangeList = new ArrayList<>();
    List<ItemCCEMT> motorcycleList = new ArrayList<>();
    List<ItemCCEMT> truckList = new ArrayList<>();
    List<ItemPlates> carPlatesList = new ArrayList<>();
    List<ItemWheelsRim> wheelsRimList = new ArrayList<>();
    List<ItemAccAndJunk> accessoriesArrayL = new ArrayList<>();
    List<ItemAccAndJunk> junkArrayL = new ArrayList<>();

    DBHelper myDB;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    int suggested=3800,normal=3700,move=4000,normal2=3799;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        statusBarColor();

        myDB = getDataBaseInstance(getApplicationContext());
        addWelcomeNotifications();

        if (checkIfUserRegisterOrNotFromSP(this) == false)
        {
            transportToLoginScreen();
        }
        else{
            if (getUserAddressFromSP(this) == null)
            {
                selectAddress();
            }else {
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
                //first fill suggested to you list
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
                //test();
            }
        }

    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    private void selectAddress() {
        Bundle bundle = new Bundle();
        bundle.putString("whereComeFrom", "activity");

        Intent intent = new Intent(SplashScreen.this, SelectCityAndNeighborhood.class);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        finish();
    }

    private void transportToLoginScreen() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("address", "splash");

                Intent intent = new Intent(SplashScreen.this, LoginWithSocialMedia.class);
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                finish();
            }
        }, 1000);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addWelcomeNotifications() {
        if (getWelcomeNotificationsInSP(this) ==null)
        {
            NotificationComp welcomeNotification = getNotification(
                    "welcome", "Hala Motor" ,this,"welcome","welcome","welcome"
                    ,"R.dra  wable.logo"
            );
            if (insertNotificationTable(welcomeNotification,getDataBaseInstance(this)) == true)
            {
                welcomeNotifications(this,sharedPreferences,editor,"created");
                updateNumberUnreadNotifications(this,sharedPreferences,editor,String.valueOf(1));
            }
        }
    }

    private void getJunkCarIndependent() {
        junkArrayLFireStore = getJunkCarPath(9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertAccAndJunkItemInAccAndJunk(junkArrayLFireStore);
            }
        }, normal2);
    }

    private void getAccessoriesIndependent() {
        accessoriesArrayLFireStore = getAccessoriesFireStore(9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { insertAccAndJunkItemInAccAndJunk(accessoriesArrayLFireStore);
            }
        }, normal);
    }

    private void insertAccAndJunkItemInAccAndJunk(List<ItemAccAndJunk> accAndJunksArrayLIndependent) {
        for (int i=0;i<accAndJunksArrayLIndependent.size();i++)
        {
            insertAccAndJunkItemInAccAndJunkTable(accAndJunksArrayLIndependent.get(i),myDB);
        }
    }

    private void getCarPlatesIndependent() {
        carPlatesListFireStore = getPlatesFireStore(9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertCarPlatesToCarPlatesTable(carPlatesListFireStore);
            }
        }, normal);
    }

    private void insertCarPlatesToCarPlatesTable(List<ItemPlates> carPlatesListIndependent) {
        for (int i=0;i<carPlatesListIndependent.size();i++)
        {
            insertCarPlatesItemInCarPlatesTable(carPlatesListIndependent.get(i),myDB);
        }
    }

    private void getWheelsRimIndependent() {
        wheelsRimListFireStore = getWheelsRimFireStore(9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertWheelsRimToWheelsRimTable(wheelsRimListFireStore);
            }
        }, normal);
    }

    private void insertWheelsRimToWheelsRimTable(List<ItemWheelsRim> wheelsRimListIndependent) {
        for (int i=0;i<wheelsRimListIndependent.size();i++)
        {
            insertWheelsRimInWheelsRimTable(wheelsRimListIndependent.get(i),myDB);
        }
    }

    private void getTrucksIndependent() {
        truckListFireStore = getTrucksFireStore(9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(truckListFireStore);
            }
        }, normal);
    }

    private void getMotorcycleIndependent() {
        motorcycleListFireStore = getMotorcycleFireStore(9);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                insertCarForSaleToCCMETTable(motorcycleListFireStore);
            }
        }, normal);
    }

    private void getCarForRentIndependent() {
        carForRentListFireStore = getCarForSaleRentFireStore(9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(carForRentListFireStore);
            }
        }, normal);
    }

    private void getCarExchangeIndependent() {
        carForExchangeListFireStore = getCarForSaleExchangeFireStore(9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() { insertCarForSaleToCCMETTable(carForExchangeListFireStore);
            }
        }, normal);
    }

    private void getCarForSaleIndependent() {
        carForSaleListFireStore = getCarForSaleItemsFireStore(9);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                insertCarForSaleToCCMETTable(carForSaleListFireStore);
            }
        }, normal);
    }

    private void insertCarForSaleToCCMETTable(List<ItemCCEMT> ccemtList) {
        for (int i = 0; i< ccemtList.size(); i++)
        {
            insertCCEMTItemInCCEMTTable(ccemtList.get(i),myDB);
        }
    }

    private void getJunkCar() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                junkArrayL = new ArrayList<>();
                junkArrayL.add(junkArrayLFireStore.get(0));
                insertJunkRimToDataBase();
            }
        }, suggested);
    }

    private void getAccessories() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                accessoriesArrayL = new ArrayList<>();
                accessoriesArrayL.add(accessoriesArrayLFireStore.get(0));
                insertAccessoriesRimToDataBase();
            }
        }, suggested);
    }

    private void getWheelsRim() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wheelsRimList = new ArrayList<>();
                wheelsRimList.add(wheelsRimListFireStore.get(0));
                insertWheelsRimToDataBase();
            }
        }, suggested);
    }

    private void getCarPlates() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                carPlatesList = new ArrayList<>();
                carPlatesList.add(carPlatesListFireStore.get(0));
                insertCarPlatesToDataBase();
            }
        }, suggested);
    }

    private void getTrucks() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                truckList = new ArrayList<>();
                truckList.add(truckListFireStore.get(0));
                insertTruckToDataBase();
            }
        }, suggested);
    }

    private void getMotorcycle() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                motorcycleList = new ArrayList<>();
                motorcycleList.add(motorcycleListFireStore.get(0));
                insertMotorcycleToDataBase();
            }
        }, suggested);
    }

    private void getCarExchange() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                carForExchangeList = new ArrayList<>();
                carForExchangeList.add(carForExchangeListFireStore.get(0));
                carForExchangeList.add(carForExchangeListFireStore.get(1));
                insertCarForExchangeToDataBase();
            }
        }, suggested);
    }

    private void getCarForRent() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                carForRentList = new ArrayList<>();
                carForRentList.add(carForRentListFireStore.get(0));
                carForRentList.add(carForRentListFireStore.get(1));
                insertCarForRentToDataBase();
            }
        }, suggested);
    }

    private void getCarForSale() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                carForSaleList = new ArrayList<>();
                carForSaleList.add(carForSaleListFireStore.get(0));
                carForSaleList.add(carForSaleListFireStore.get(1));
                insertCarForSaleToDataBase();
            }
        }, suggested);
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
        }, move);
    }


    CollectionReference mRef;

    public void getdata(){
        mRef = getDataStoreInstance().collection("Car_For_Exchange");

        mRef.whereEqualTo("categoryName", "Exchange car")
                .whereEqualTo("cityS", "Abu Dhabi")
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             Log.i("TAG", "Object " + documentSnapshots);

                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carForExchangeListFireStore.add(ccemt);
                         }
//                                                     lastVisible = queryDocumentSnapshots.getDocuments()
//                                                            .get(queryDocumentSnapshots.size() -1);
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
    }

    private void test() {
        getdata();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Log.i("TAG","Size "+String.valueOf(carForExchangeListFireStore.size()));
                for (int i =0 ;i<carForExchangeListFireStore.size();i++)
                {
                    Log.i("TAG","************************ "+
                            String.valueOf(i+1));
                    Log.i("TAG","carMake "+
                            carForExchangeListFireStore.get(i).getCarMake());
                    Log.i("TAG","carModel "+
                            carForExchangeListFireStore.get(i).getCarModel());
                    Log.i("TAG","carColor "+
                            carForExchangeListFireStore.get(i).getColor());
                    Log.i("TAG","carCity "+
                            carForExchangeListFireStore.get(i).getCity());
                    Log.i("TAG","Price "+
                            carForExchangeListFireStore.get(i).getPrice());
                }
            }
        }, 9000);

//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.i("TAG","get data 2 ");
//                getdata2();
//
//            }
//        }, 20000);
//
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.i("TAG","Size "+String.valueOf(carForSaleList.size()));
//                for (int i =0 ;i<carForSaleList.size();i++)
//                {
//                    Log.i("TAG","************************ "+
//                            String.valueOf(i+1));
//                    Log.i("TAG","carMake "+
//                            carForSaleList.get(i).getCarMake());
//                    Log.i("TAG","carModel "+
//                            carForSaleList.get(i).getCarModel());
//                    Log.i("TAG","carColor "+
//                            carForSaleList.get(i).getColor());
//                    Log.i("TAG","carCity "+
//                            carForSaleList.get(i).getCity());
//                    Log.i("TAG","Price "+
//                            carForSaleList.get(i).getPrice());
//                }
//            }
//        }, 25000);
    }


    DocumentSnapshot lastVisible;

//    public void getdata2(){
//        mRef = getDataStoreInstance().collection("Car_For_Sale");
//
//        mRef.whereEqualTo("categoryName","Car for sale")
//                .limit(3)
//                .startAfter(lastVisible)
//                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                                                @Override
//                                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                                    for (QueryDocumentSnapshot documentSnapshots: queryDocumentSnapshots) {
//                                                        Log.i("TAG","Object "+documentSnapshots);
//
//                                                        CCEMT ccemt = documentSnapshots.toObject(CCEMT.class);
//                                                        carForSaleList.add(ccemt);
//                                                    }
//                                                }
//                                            }
//        ).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d("ERROR fireStore",e.toString());
//            }
//        });
//    }


}
