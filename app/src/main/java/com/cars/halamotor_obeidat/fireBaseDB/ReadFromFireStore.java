package com.cars.halamotor_obeidat.fireBaseDB;

import android.support.annotation.NonNull;
import android.util.Log;

import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemCCEMT;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;

public class ReadFromFireStore {

    public static List<ItemCCEMT> getCarForSaleExchangeFireStore(int numberOfCarFromServer) {
        final List<ItemCCEMT> carForSaleListFireStore = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Car_For_Exchange");

        mRef.whereEqualTo("categoryNameS", "Exchange car")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carForSaleListFireStore.add(ccemt);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return carForSaleListFireStore;
    }

    public static List<ItemCCEMT> getCarForSaleItemsFireStore(int numberOfCarFromServer) {
        final List<ItemCCEMT> carForSaleListFireStore = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Car_For_Sale");

        mRef.whereEqualTo("categoryNameS", "Car for sale")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carForSaleListFireStore.add(ccemt);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return carForSaleListFireStore;
    }

    public static List<ItemCCEMT> getCarForSaleRentFireStore(int numberOfCarFromServer) {
        final List<ItemCCEMT> carItems = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Car_For_Rent");

        mRef.whereEqualTo("categoryNameS", "Car for rent")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carItems.add(ccemt);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return carItems;
    }

    public static List<ItemCCEMT> getMotorcycleFireStore(int numberOfCarFromServer) {
        final List<ItemCCEMT> carItems = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Motorcycle");

        mRef.whereEqualTo("categoryNameS", "Motorcycle")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carItems.add(ccemt);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return carItems;
    }

    public static List<ItemCCEMT> getTrucksFireStore(int numberOfCarFromServer) {
        final List<ItemCCEMT> carItems = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Trucks");

        mRef.whereEqualTo("categoryNameS", "Trucks")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemCCEMT ccemt = documentSnapshots.toObject(ItemCCEMT.class);
                             carItems.add(ccemt);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return carItems;
    }

    public static List<ItemWheelsRim> getWheelsRimFireStore(int numberOfCarFromServer) {
        final List<ItemWheelsRim> wheelsRims = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Wheels_Rim");

        mRef.whereEqualTo("categoryNameS", "Wheels rim")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemWheelsRim itemWheelsRim = documentSnapshots.toObject(ItemWheelsRim.class);
                             wheelsRims.add(itemWheelsRim);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return wheelsRims;
    }

    public static List<ItemPlates> getPlatesFireStore(int numberOfCarFromServer) {
        final List<ItemPlates> itemPlates = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Plates");

        mRef.whereEqualTo("categoryNameS", "Car plates")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemPlates itemPlates1 = documentSnapshots.toObject(ItemPlates.class);
                             itemPlates.add(itemPlates1);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return itemPlates;
    }

    public static List<ItemAccAndJunk> getAccessoriesFireStore(int numberOfCarFromServer) {
        final List<ItemAccAndJunk> itemAccAndJunks = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("Accessories");

        mRef.whereEqualTo("categoryNameS", "Accessories")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemAccAndJunk itemAccAndJunk = documentSnapshots.toObject(ItemAccAndJunk.class);
                             itemAccAndJunks.add(itemAccAndJunk);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return itemAccAndJunks;
    }

    public static List<ItemAccAndJunk> getJunkCarPath(int numberOfCarFromServer) {
        final List<ItemAccAndJunk> itemAccAndJunks = new ArrayList<>();
        CollectionReference mRef = getDataStoreInstance().collection("JunkCar");

        mRef.whereEqualTo("categoryNameS", "Junk car")
                .limit(numberOfCarFromServer)
                .get().addOnSuccessListener
                (new OnSuccessListener<QuerySnapshot>() {
                     @Override
                     public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                         for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                             ItemAccAndJunk itemAccAndJunk = documentSnapshots.toObject(ItemAccAndJunk.class);
                             itemAccAndJunks.add(itemAccAndJunk);
                         }
                     }
                 }
                ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR fireStore", e.toString());
            }
        });
        return itemAccAndJunks;
    }

}
