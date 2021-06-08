package com.cars.halamotor.dataBase;

import android.content.Context;
import android.database.Cursor;

import com.cars.halamotor.model.Area;
import com.cars.halamotor.model.City;
import com.cars.halamotor.model.DriverInformation;
import com.cars.halamotor.model.DriverProcess;
import com.cars.halamotor.model.ProcessContent;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;

public class ReadCitesAndAreas {

    public static ArrayList<City> getCitesFromDataBase(Context context) {

        ArrayList<City> citiesArrayList = new ArrayList<City>();

        Cursor res = getDataBaseInstance(context).descendingCities();

        while (res.moveToNext()) {

            City city= new City(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")
            );

            citiesArrayList.add(city);
        }

        return citiesArrayList;
    }

    public static ArrayList<Area> getAreasFromDataBase(Context context) {

        ArrayList<Area> areasArrayList = new ArrayList<Area>();

        Cursor res = getDataBaseInstance(context).descendingAreas();

        while (res.moveToNext()) {

            City city= new City(
                    res.getString(5).replace("\n", "")
                    ,res.getString(6).replace("\n", "")
                    ,res.getString(7).replace("\n", "")
                    ,res.getString(8).replace("\n", "")
                    ,res.getString(9).replace("\n", "")
            );

            Area area= new Area(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,city
            );

            areasArrayList.add(area);
        }

        return areasArrayList;
    }
}
