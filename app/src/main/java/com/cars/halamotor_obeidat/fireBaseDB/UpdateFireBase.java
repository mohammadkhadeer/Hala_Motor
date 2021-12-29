package com.cars.halamotor_obeidat.fireBaseDB;

import android.content.Context;

import com.cars.halamotor_obeidat.model.FavouriteCallSearch;

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;

public class UpdateFireBase {

    public static void updateCityNeighborhood(final Context context,String city,String neighborhood) {
        String userID = getUserIdInServerFromSP(context);
        insertNewUser().child(userID).child("cityStr").setValue(city);
        insertNewUser().child(userID).child("neighbourhoodStr").setValue(neighborhood);
    }

    public static void setFavouriteCallSearchOnServer(final Context context, final String itemID
                            , String category, String fscType) {
        FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(itemID,category,fscType);
        String userID = getUserIdInServerFromSP(context);
        insertNewUser().child(userID).child("FavouriteCallSearch").push().setValue(favouriteCallSearch);
    }
}
