package com.cars.halamotor_obeidat.fireBaseDB;


import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;

public class FireBaseDBPaths {



    public static FirebaseDatabase getDataBaseInstance() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        return  database;
    }

    public static DatabaseReference insertNewUser() {
        DatabaseReference usersPath = getDataBaseInstance().getReference("users");
        return  usersPath;
    }

    public static DatabaseReference insertFollowing(Context context) {
        DatabaseReference usersPath = getDataBaseInstance().getReference("users")
                .child(getUserIdInServerFromSP(context)).child("following");
        return  usersPath;
    }

    public static DatabaseReference insertFollower(Context context,String userID) {
        DatabaseReference usersPath = getDataBaseInstance().getReference("users")
                .child(userID).child("follower");
        return  usersPath;
    }


    public static DatabaseReference insertCarForSale() {
        DatabaseReference carForSalePath = getDataBaseInstance()
                .getReference("category");
        return  carForSalePath;
    }

    public static DatabaseReference getUserPathInServer(String userIDInServer) {
        DatabaseReference usersPath = getDataBaseInstance()
                .getReference("users").child(userIDInServer);
        return  usersPath;
    }

    public static DatabaseReference getObjectPathInServer(String categoryName,String itemID) {
        DatabaseReference usersPath = getDataBaseInstance()
                .getReference("category").child(categoryName).child(itemID);
        return  usersPath;
    }

    public static DatabaseReference getObjectCommentPathInServer(String categoryName,String itemID) {
        DatabaseReference usersPath = getDataBaseInstance()
                .getReference("category").child(categoryName).child(itemID).child("commentsArrayL");
        return  usersPath;
    }

    public static DatabaseReference getUserPathInServerFB(String userID) {
        DatabaseReference usersPath = getDataBaseInstance().getReference("users")
                .child(userID);
        return  usersPath;
    }

    public static Query getDataBase() {
        Query mRef = FirebaseDatabase.getInstance().getReference();
        return mRef;
    }
}
