package com.cars.halamotor.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cars.halamotor.model.Area;
import com.cars.halamotor.model.City;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;

public class ReadCarsAndCarModels {

    public static ArrayList<City> getBrands(Context context) {

        ArrayList<City> citiesArrayList = new ArrayList<City>();

        Cursor res = getDataBaseInstance(context).descendingBrands();

        while (res.moveToNext()) {



            //citiesArrayList.add(city);
        }

        return citiesArrayList;
    }

//    public static ArrayList<City> getBrands(Context context) {
//
//        ArrayList<City> citiesArrayList = new ArrayList<City>();
//
//        Cursor res = getDataBaseInstance(context).descendingCities();
//
//        while (res.moveToNext()) {
//
//            City city= new City(
//                    res.getString(1).replace("\n", "")
//                    ,res.getString(2).replace("\n", "")
//                    ,res.getString(3).replace("\n", "")
//                    ,res.getString(4).replace("\n", "")
//                    ,res.getString(5).replace("\n", "")
//            );
//
//            //citiesArrayList.add(city);
//        }
//
//        return citiesArrayList;
//    }

    public static void getModels(Context context) {
        Cursor res = getDataBaseInstance(context).descendingBrandsModel();

        while (res.moveToNext()) {
            Log.w("TAG","Car Brand: "+res.getString(2).replace("\n", ""));
            Log.w("TAG","Car model: "+res.getString(7).replace("\n", ""));

        }
    }

//    public static ArrayList<Area> getModels(Context context) {
//
//        ArrayList<Area> areasArrayList = new ArrayList<Area>();
//
//        Cursor res = getDataBaseInstance(context).descendingAreas();
//
//        while (res.moveToNext()) {
//
//            City city= new City(
//                    res.getString(5).replace("\n", "")
//                    ,res.getString(6).replace("\n", "")
//                    ,res.getString(7).replace("\n", "")
//                    ,res.getString(8).replace("\n", "")
//                    ,res.getString(9).replace("\n", "")
//            );
//
//            Area area= new Area(
//                    res.getString(1).replace("\n", "")
//                    ,res.getString(2).replace("\n", "")
//                    ,res.getString(3).replace("\n", "")
//                    ,res.getString(4).replace("\n", "")
//                    ,city
//            );
//
//            areasArrayList.add(area);
//        }
//
//        return areasArrayList;
//    }
}
