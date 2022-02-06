package com.cars.halamotor_obeidat.fireBaseDB;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.ContactUsMessage;
import com.cars.halamotor_obeidat.model.FCWSU;
import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemCCEMT;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.cars.halamotor_obeidat.model.ReportDetails;
import com.cars.halamotor_obeidat.model.UserInfo;
import com.cars.halamotor_obeidat.model.UserItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServerFB;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.accessoriesPath;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.carForExchange;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.carForRent;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.carForSale;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.junkCarPath;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.motorcycle;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.platesPath;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.trucks;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.wheelsRimPath;
import static com.cars.halamotor_obeidat.functions.Functions.getNotification;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveServerIDInfoInSP;

public class InsertToFireBase {

    public static void addNewUser(UserInfo newUser, final SharedPreferences rgSharedPreferences,
                                  final SharedPreferences.Editor rgEditor, final Context context) {

        insertNewUser().push().setValue(newUser, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError,
                                   DatabaseReference databaseReference) {
                String uniqueKey = databaseReference.getKey();
                insertNewUser().child(uniqueKey).child("authenticationIDStr").setValue(uniqueKey);
                saveServerIDInfoInSP(context,rgSharedPreferences,rgEditor,uniqueKey);
            }
        });
        //String key = insertNewUser().push().getKey();
    }

    public static void addNewItemToFireStore(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final int numberOfAdsToUser, final Context context) {
        getDataStoreInstance().collection(category).add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        Log.i("TAG","itemID: "+uniqueKey);
                        getDataStoreInstance().collection(category).document(uniqueKey)
                                .update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("TAG","Error: " + "Onfailure listner"+e.toString());

            }
        });

    }


    public static void addItemPlates(final ItemPlates itemPlates, final String userID
            , final int numberOfAdsToUser, final Context context) {
        platesPath().add(itemPlates).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        platesPath().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemPlates.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }

    public static void addWheelsRim(final ItemWheelsRim itemWheelsRim, final String userID
           , final int numberOfAdsToUser , final Context context) {
        wheelsRimPath().add(itemWheelsRim).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        wheelsRimPath().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemWheelsRim.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }


    public static void addAccessories(final ItemAccAndJunk itemAccAndJunk
            , final String userID, final int numberOfAdsToUser, final Context context) {
        accessoriesPath().add(itemAccAndJunk).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        accessoriesPath().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemAccAndJunk.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser + 1);
                        //insert notification

                    }
                }
            }
        });
    }

    public static void addCarForExchangeStore(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final Context context, final int numberOfAdsToUser) {

        carForExchange().add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        Log.i("TAG","itemID: "+uniqueKey);
                        carForExchange().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }



    public static void addCarForSaleStore(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final Context context, final int numberOfAdsToUser) {
        carForSale().add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    Log.i("TAG","******************"+"isSuccessful");
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        carForSale().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }



    public static void addCarForRentStore(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final Context context, final int numberOfAdsToUser) {
                carForRent().add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        carForRent().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }



    public static void addMotorcycle(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final Context context, final int numberOfAdsToUser) {
                motorcycle().add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        motorcycle().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }



    public static void addTrucks(final ItemCCEMT itemCCEMT, final String category
            , final String userID, final Context context, final int numberOfAdsToUser) {
                trucks().add(itemCCEMT).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        trucks().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemCCEMT.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser+1);
                        //insert notification here to can get item id in server

                    }
                }
            }
        });
    }



    public static void addJunkCar(final ItemAccAndJunk itemAccAndJunk
            , final String userID, final int numberOfAdsToUser, final Context context) {
        junkCarPath().add(itemAccAndJunk).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        junkCarPath().document(uniqueKey).update("itemID",uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        UserItem userItem = new UserItem(itemAccAndJunk.getCategoryNameS(),uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(userItem);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser + 1);
                        //insert notification

                    }
                }
            }
        });
    }

    public static void addContactUsToFireStore(final ContactUsMessage contactUsMessage, final String category
            , final Context context) {
        getDataStoreInstance().collection(category).add(contactUsMessage).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        Log.i("TAG","messageID: "+uniqueKey);
                        getDataStoreInstance().collection(category).document(uniqueKey)
                                .update("messageIdOnServer",uniqueKey);
                        //insert notification here to can get item id in server
//                        String imageStr = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/images%2Flogo_2.png?alt=media&token=f9e74a0c-f0af-4998-94f9-02d853457a79";
//                        insertNotificationTable(getNotification(category,contactUsMessage.getTitle() + " " +contactUsMessage.getTitleS(),context, uniqueKey,"out","contactUs",imageStr)
//                                ,getDataBaseInstance(context));
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("TAG","Error: " + "Onfailure listner"+e.toString());

            }
        });

    }

    public static void addReportToFireStore(final ReportDetails reportDetails, final Context context) {
        getDataStoreInstance().collection("Reports").add(reportDetails).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if (task.isSuccessful()) {
                    DocumentReference document = task.getResult();
                    if (document != null) {
                        String uniqueKey = document.getId(); //Do what you need to do with the document id
                        Log.i("TAG","messageID: "+uniqueKey);
                        getDataStoreInstance().collection("Reports").document(uniqueKey)
                                .update("reportIDOnServer",uniqueKey);
                        //insert notification here to can get item id in server
//                        String imageStr = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/images%2Flogo_2.png?alt=media&token=f9e74a0c-f0af-4998-94f9-02d853457a79";
//                        insertNotificationTable(getNotification(category,contactUsMessage.getTitle() + " " +contactUsMessage.getTitleS(),context, uniqueKey,"out","contactUs",imageStr)
//                                ,getDataBaseInstance(context));
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {

            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("TAG","Error: " + "Onfailure listner"+e.toString());

            }
        });

    }
}
