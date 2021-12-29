package com.cars.halamotor_obeidat.fireBaseDB;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import com.cars.halamotor_obeidat.functions.FCSFunctions;
import com.cars.halamotor_obeidat.model.AccAndJunk;
import com.cars.halamotor_obeidat.model.CCEMT;
import com.cars.halamotor_obeidat.model.CarPlatesModel;
import com.cars.halamotor_obeidat.model.FavouriteCallSearch;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.WheelsRimModel;
import com.cars.halamotor_obeidat.presnter.FCSItems;
import com.cars.halamotor_obeidat.view.activity.LoginWithSocialMedia;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOrNotFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveServerIDInfoInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveUserInfoInSP;
import static com.facebook.FacebookSdk.getApplicationContext;

public class ReadFromFireBase {

    public static void getFCSItems(final List<FavouriteCallSearch> favouriteCallSearches
            ,final FCSItems fcsItemsPresenter
            ,int numberOfObject) {
        final List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();

        for (int i =0;i<numberOfObject;i++)
        {
            final String category = convertCat(favouriteCallSearches.get(i).getItemType());
            final String categoryBefore = favouriteCallSearches.get(i).getItemType();
            Log.i("TAG","Cat "+categoryBefore);

            DocumentReference mRef = null;
            mRef = getDataStoreInstance().collection(category)
                    .document(favouriteCallSearches.get(i).getIdInDatabase());
            mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(document,categoryBefore));
                        }
                    }
                }
            });
        }
        new Handler().postDelayed(new Runnable() {
            @Override public void run() { fcsItemsPresenter.getItemsObject(fcsItemsArrayList); }}, 3000);
    }

    public static void getUserInfo(String email, final SharedPreferences rgSharedPreferences, final SharedPreferences.Editor rgEditor
            , final SharedPreferences fbSharedPreferences, final SharedPreferences.Editor fbEditor, final Context context, final String googleID) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("users").orderByChild("emailStr").equalTo(email);
//        .limitToLast(numberOfCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    //userID,
                    String nameStr = (String) ds.child("nameStr").getValue(String.class);
                    String surNameStr = (String) ds.child("surNameStr").getValue(String.class);
                    String userImageStr = (String) ds.child("userImageStr").getValue(String.class);
                    String authenticationIDStr = (String) ds.child("authenticationIDStr").getValue(String.class);
                    String emailStr = (String) ds.child("emailStr").getValue(String.class);
                    String cityStr = (String) ds.child("cityStr").getValue(String.class);
                    String neighbourhoodStr = (String) ds.child("neighbourhoodStr").getValue(String.class);

                    checkIfUserRegisterOrNotFromSP(getApplicationContext(), rgSharedPreferences, rgEditor, "1");

                    saveServerIDInfoInSP(context,rgSharedPreferences,rgEditor,authenticationIDStr);

                    //update user token
                    insertNewUser().child(authenticationIDStr).child("userTokensStr").setValue(getUserTokenInFromSP(getApplicationContext()));

                    saveUserInfoInSP(getApplicationContext(), fbSharedPreferences, fbEditor, nameStr
                            , surNameStr, emailStr
                            , googleID, "1/1/2020"
                            , userImageStr);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            LoginWithSocialMedia loginWithSocialMedia = (LoginWithSocialMedia) context;
                            loginWithSocialMedia.moveBack();
                        }
                    }, 1000);

                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
    }

    public static List<CCEMT> getCarForSaleItems(final List<CCEMT> carForSaleL,int numberOfCarFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Car_For_Sale");
//        .limitToLast(numberOfCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carForSaleList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = carForSaleList.getValue(CCEMT.class);
                    carForSaleL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return carForSaleL;
    }

    public static List<CCEMT> getCarForRentItems(final List<CCEMT> carForRentL,int numberOfCarFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Car_For_Rent").limitToLast(numberOfCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carForRentList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = carForRentList.getValue(CCEMT.class);
                    carForRentL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return carForRentL;
    }

    public static List<CCEMT> getCarForExchangeItems(final List<CCEMT> carForExchangeL
            , int numberOfCarFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Car_For_Exchange").limitToLast(numberOfCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carForExchangeList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = carForExchangeList.getValue(CCEMT.class);
                    carForExchangeL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return carForExchangeL;
    }

    public static List<CCEMT> getCarForExchangeItemsSearch(final List<CCEMT> carForExchangeL
            , int numberOfCarFromServer,String category,String carMake,String carModel,String year
            ,String carCondition,String carKilometers,String carTransmission
            ,String carFuel,String carColor) {
        Query mRef = null;
         mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child(category);

        mRef.limitToFirst(numberOfCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carForExchangeList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = carForExchangeList.getValue(CCEMT.class);
                    carForExchangeL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return carForExchangeL;
    }

    public static List<CCEMT> getMotorcycleItems(final List<CCEMT> motorcycleArrayL,int numberOfMotorFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Motorcycle").limitToLast(numberOfMotorFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot motorcycleList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = motorcycleList.getValue(CCEMT.class);
                    motorcycleArrayL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return motorcycleArrayL;
    }

    public static List<CCEMT> getTruckItems(final List<CCEMT> trucksArrayL,int numberOfTruckFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Trucks").limitToLast(numberOfTruckFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot trucksList: dataSnapshot.getChildren()) {
                    CCEMT ccemt = trucksList.getValue(CCEMT.class);
                    trucksArrayL.add(ccemt);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return trucksArrayL;
    }

    public static List<CarPlatesModel> getPlatesItems(final List<CarPlatesModel> platesArrayL,int numberOfCarPlatesFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Plates").limitToLast(numberOfCarPlatesFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot carPlatesList: dataSnapshot.getChildren()) {
                    CarPlatesModel carPlatesModel = carPlatesList.getValue(CarPlatesModel.class);
                    platesArrayL.add(carPlatesModel);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return platesArrayL;
    }

    public static List<WheelsRimModel> getWheelsRimItems(final List<WheelsRimModel> wheelsRimArrayL,int numberOfWheelsFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Wheels_Rim").limitToLast(numberOfWheelsFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot wheelsRimList: dataSnapshot.getChildren()) {
                    WheelsRimModel wheelsRim = wheelsRimList.getValue(WheelsRimModel.class);
                    wheelsRimArrayL.add(wheelsRim);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return wheelsRimArrayL;
    }

    public static List<AccAndJunk> getAccessoriesItems(final List<AccAndJunk> accessoriesArrayL,int numberOfAccessoriesFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("Accessories").limitToLast(numberOfAccessoriesFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot accessoriesList: dataSnapshot.getChildren()) {
                    AccAndJunk accAndJunk = accessoriesList.getValue(AccAndJunk.class);
                    accessoriesArrayL.add(accAndJunk);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return accessoriesArrayL;
    }

    public static List<AccAndJunk> getJunkCarItems(final List<AccAndJunk> junkArrayL,int numberOfJunkCarFromServer) {
        Query mRef = FirebaseDatabase.getInstance().getReference()
                .child("category").child("JunkCar").limitToLast(numberOfJunkCarFromServer);
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot junkList: dataSnapshot.getChildren()) {
                    AccAndJunk accAndJunk = junkList.getValue(AccAndJunk.class);
                    junkArrayL.add(accAndJunk);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("TAG ERROR", databaseError.toString());

            }

        });
        return junkArrayL;
    }
}
