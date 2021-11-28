package com.cars.halamotor.staticFiles;

import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.SuggestedItem;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class StaticFiles {
    public static ArrayList<CategoryComp> categoriesArrayList = new ArrayList();

    public static void setCategoriesArrayL (ArrayList<CategoryComp> categoriesFromServer) {
        categoriesArrayList = categoriesFromServer;
    }

    public static ArrayList<CategoryComp> getCategoriesArrayL () {
        return categoriesArrayList ;
    }
}
