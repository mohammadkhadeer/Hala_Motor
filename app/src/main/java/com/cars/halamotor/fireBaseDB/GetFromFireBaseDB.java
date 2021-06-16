package com.cars.halamotor.fireBaseDB;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.UserProfileInfo;
import com.cars.halamotor.model.WheelsRimModel;
import com.cars.halamotor.presnter.ItemModel;
import com.cars.halamotor.presnter.NumberOfAllowedAds;
import com.cars.halamotor.presnter.UserInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.getObjectPathInServer;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getObjectPathInServerFireStore;
import static com.cars.halamotor.functions.Functions.replace;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;

public class GetFromFireBaseDB {

    public static void getNumberOfAllowedAdsFromServer(Context context, final NumberOfAllowedAds numberOfAllowedAds) {
        getUserPathInServer(getUserIdInServerFromSP(context)).child("numberOfAllowedAds")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            numberOfAllowedAds.numberOfAllowedAds(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });

    }

    public static void getNumberOfOldAds(Context context, final NumberOfAllowedAds numberOfAllowedAds) {
        getUserPathInServer(getUserIdInServerFromSP(context)).child("numberOfAds")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            numberOfAllowedAds.numberOfAds(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });

    }

    public static void checkUserCanInsertAddOrNot(Context context, final NumberOfAllowedAds numberOfAllowedAds) {
        getUserPathInServer(getUserIdInServerFromSP(context)).child("activeToSetAdv")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            numberOfAllowedAds.canInsertAds(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });

    }

    public static void checkUserCanInsertBurnedPrice(Context context, final NumberOfAllowedAds numberOfAllowedAds) {
        getUserPathInServer(getUserIdInServerFromSP(context)).child("activeToAddBurnedPrice")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            numberOfAllowedAds.canInsertBurnedPrice(dataSnapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });

    }

    public static void getCCEMTObject(String category, String itemID, final ItemModel itemModel) {
        category = replace(category);

        DocumentReference mRef = null;
        mRef = getObjectPathInServerFireStore(category,itemID);

        mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ItemCCEMT ccemt = document.toObject(ItemCCEMT.class);
                    }
                }
            }
        });
    }

    public static void getCarPlatesObject(String category, String itemID, final ItemModel itemModel) {
        category = replace(category);

        DocumentReference mRef = null;
        mRef = getObjectPathInServerFireStore(category,itemID);

        mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ItemPlates carPlatesModel = document.toObject(ItemPlates.class);
                        itemModel.onReceiveCarPlatesObject(carPlatesModel);
                    }
                }
            }
        });

    }

    public static void getWheelsSizeObject(String category, String itemID, final ItemModel itemModel) {
        category = replace(category);

        DocumentReference mRef = null;
        mRef = getObjectPathInServerFireStore(category,itemID);

        mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ItemWheelsRim wheelsRimModel = document.toObject(ItemWheelsRim.class);
                        itemModel.onReceiveWheelsRimObject(wheelsRimModel);
                    }
                }
            }
        });

    }

    public static void getAccAndJunkObject(String category, String itemID, final ItemModel itemModel) {
        category = replace(category);

        DocumentReference mRef = null;
        mRef = getObjectPathInServerFireStore(category,itemID);

        mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ItemAccAndJunk accAndJunk = document.toObject(ItemAccAndJunk.class);
                        itemModel.onReceiveAccAndJunkObject(accAndJunk);
                    }
                }
            }
        });

    }

    public static void getProfileUserInfo(final String userID, final UserInfo userInfo) {
        getUserPathInServer(userID)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            Log.i("TAG",dataSnapshot.toString());
                            UserProfileInfo userProfileInfo = new UserProfileInfo
                                    (
                                            userID
                                            ,dataSnapshot.child("nameStr").getValue().toString()
                                            ,dataSnapshot.child("userImageStr").getValue().toString()
                                            ,dataSnapshot.child("surNameStr").getValue().toString()
                                            ,dataSnapshot.child("emailStr").getValue().toString()
                                            ,dataSnapshot.child("cityStr").getValue().toString()
                                            ,dataSnapshot.child("neighbourhoodStr").getValue().toString()
                                            ,dataSnapshot.child("numberOfAds").getValue().toString()
                                            ,dataSnapshot.child("userTokensStr").getValue().toString()
                                    );
                            userInfo.userInfo(userProfileInfo);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });
    }
}
