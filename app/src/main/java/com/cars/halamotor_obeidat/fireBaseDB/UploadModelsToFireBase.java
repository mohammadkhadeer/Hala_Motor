package com.cars.halamotor_obeidat.fireBaseDB;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.AccAndJunk;
import com.cars.halamotor_obeidat.model.CarPlatesModel;
import com.cars.halamotor_obeidat.model.CommentsComp;
import com.cars.halamotor_obeidat.model.FCWSU;
import com.cars.halamotor_obeidat.model.WheelsRimModel;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getObjectCommentPathInServer;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServerFB;
import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertCarForSale;
import static com.cars.halamotor_obeidat.functions.Functions.getNotification;

public class UploadModelsToFireBase {

    // new item type carPlates
    public static void addNewCarPlates(final CarPlatesModel carPlatesModel, final String category
            , final String userID, final int numberOfAdsToUser, final Context context) {
        insertCarForSale().child(category).push().setValue(carPlatesModel
                , new DatabaseReference.CompletionListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onComplete(DatabaseError databaseError,
                                   DatabaseReference databaseReference) {
                String uniqueKey = databaseReference.getKey();
                //update id item on server
                insertCarForSale().child(category).child(uniqueKey).child("itemID").setValue(uniqueKey);
                //insert item to userAds in user table
                FCWSU fcwsu = new FCWSU(uniqueKey);
                getUserPathInServerFB(userID).child("usersAds").push().setValue(fcwsu);
                //update number of ads to this user
                getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser + 1);
                //insert notification
                insertNotificationTable(getNotification("Plates",carPlatesModel.getCarPlatesCity() + " " +carPlatesModel.getCarPlatesNum(),context, uniqueKey,"out","item",carPlatesModel.getImagePathArrayL().get(0))
                        ,getDataBaseInstance(context));
            }
        });
    }

    // new item type wheelsRim
    public static void addNewWheelsRim(final WheelsRimModel wheelsRimModel, final String category
            , final String userID, final int numberOfAdsToUser, final Context context) {
        insertCarForSale().child(category).push().setValue(wheelsRimModel
                , new DatabaseReference.CompletionListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        //update id item on server
                        insertCarForSale().child(category).child(uniqueKey).child("itemID").setValue(uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(fcwsu);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser + 1);
                        //insert notification
                        insertNotificationTable(getNotification("Wheels_Rim",wheelsRimModel.getWheelSize()+" "+ context.getResources().getString(R.string.wheels_inch),context, uniqueKey,"out","item",wheelsRimModel.getImagePathArrayL().get(0))
                                ,getDataBaseInstance(context));
                    }
                });
    }

    // new item type wheelsRim
    public static void addNewAccessories(final AccAndJunk accAndJunk, final String category
            , final String userID, final int numberOfAdsToUser, final Context context) {
        insertCarForSale().child(category).push().setValue(accAndJunk
                , new DatabaseReference.CompletionListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        String uniqueKey = databaseReference.getKey();
                        //update id item on server
                        insertCarForSale().child(category).child(uniqueKey).child("itemID").setValue(uniqueKey);
                        //insert item to userAds in user table
                        FCWSU fcwsu = new FCWSU(uniqueKey);
                        getUserPathInServerFB(userID).child("usersAds").push().setValue(fcwsu);
                        //update number of ads to this user
                        getUserPathInServerFB(userID).child("numberOfAds").setValue(numberOfAdsToUser + 1);
                        //insert notification
                        insertNotificationTable(getNotification("Accessories",accAndJunk.getItemName(),context, uniqueKey,"out","item",accAndJunk.getImagePathArrayL().get(0))
                                ,getDataBaseInstance(context));
                    }
                });
    }

    //write comment
    public static void writeComment(final CommentsComp commentsComp,String categoryName
            , final String itemID) {
        getObjectCommentPathInServer(categoryName,itemID).push().setValue(commentsComp);
    }

}
