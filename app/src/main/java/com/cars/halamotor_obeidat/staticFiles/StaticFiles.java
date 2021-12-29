package com.cars.halamotor_obeidat.staticFiles;

import com.cars.halamotor_obeidat.model.CategoryComp;

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
