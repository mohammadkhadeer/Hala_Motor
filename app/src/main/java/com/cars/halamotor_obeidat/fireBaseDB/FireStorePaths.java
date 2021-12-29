package com.cars.halamotor_obeidat.fireBaseDB;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cars.halamotor_obeidat.model.CCEMT;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FireStorePaths {

    public static FirebaseFirestore getDataStoreInstance() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        return  database;
    }

    public static DocumentReference getObjectPathInServerFireStore(String categoryName,String itemID) {
        DocumentReference documentReference = getDataStoreInstance()
                .collection(categoryName).document(itemID);
        return  documentReference;
    }

    public static DocumentReference insertItems() {
        DocumentReference usersPath = getDataStoreInstance().collection("Car_For_Sale")
                .document();
        return  usersPath;
    }

    public static CollectionReference carForSale() {
        CollectionReference usersPath = getDataStoreInstance().collection("Car_For_Sale");
        return  usersPath;
    }

    public static CollectionReference carForRent() {
        CollectionReference usersPath = getDataStoreInstance().collection("Car_For_Rent");
        return  usersPath;
    }

    public static CollectionReference carForExchange() {
        CollectionReference usersPath = getDataStoreInstance().collection("Car_For_Exchange");
        return  usersPath;
    }

    public static CollectionReference motorcycle() {
        CollectionReference usersPath = getDataStoreInstance().collection("Motorcycle");
        return  usersPath;
    }

    public static CollectionReference trucks() {
        CollectionReference usersPath = getDataStoreInstance().collection("Trucks");
        return  usersPath;
    }

    public static CollectionReference wheelsRimPath() {
        CollectionReference usersPath = getDataStoreInstance().collection("Wheels_Rim");
        return  usersPath;
    }

    public static CollectionReference platesPath() {
        CollectionReference usersPath = getDataStoreInstance().collection("Plates");
        return  usersPath;
    }

    public static CollectionReference accessoriesPath() {
        CollectionReference usersPath = getDataStoreInstance().collection("Accessories");
        return  usersPath;
    }

    public static CollectionReference junkCarPath() {
        CollectionReference usersPath = getDataStoreInstance().collection("JunkCar");
        return  usersPath;
    }



    public static List<CCEMT> getCarForSaleItemsStore(final List<CCEMT> carForSaleL, int numberOfCarFromServer) {
        CollectionReference mRef = getDataStoreInstance().collection("Car_For_Sale");
        //7
        //3
        //2
        mRef.whereEqualTo("categoryName","Car for sale")
                .whereEqualTo("carMake",null)
                .whereEqualTo("carModel",null)
                .limit(3)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshots: queryDocumentSnapshots) {
                    Log.i("TAG","Object "+documentSnapshots);

                    CCEMT ccemt = documentSnapshots.toObject(CCEMT.class);
                    carForSaleL.add(ccemt);
                }
            }
        }
        ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore",e.toString());
            }
        });

        return carForSaleL;
    }
}
