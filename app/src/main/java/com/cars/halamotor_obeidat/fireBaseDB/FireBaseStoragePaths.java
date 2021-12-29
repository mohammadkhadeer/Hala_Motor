package com.cars.halamotor_obeidat.fireBaseDB;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FireBaseStoragePaths {
    public static StorageReference getStorageInstance() {
        StorageReference mStorageRef;
        mStorageRef = FirebaseStorage.getInstance().getReference();
        return  mStorageRef;
    }

    public static StorageReference carForSalePath() {
        return  getStorageInstance().child("images");
    }

}
