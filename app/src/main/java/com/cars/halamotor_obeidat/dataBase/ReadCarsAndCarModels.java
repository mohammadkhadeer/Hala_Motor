package com.cars.halamotor_obeidat.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cars.halamotor_obeidat.model.CarMake;
import com.cars.halamotor_obeidat.model.CarModel;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class ReadCarsAndCarModels {

    public static ArrayList<CarMake> getBrands(Context context) {

        ArrayList<CarMake> carBrandArrayList = new ArrayList<CarMake>();

        Cursor res = getDataBaseInstance(context).descendingBrands();

        while (res.moveToNext()) {
            CarMake carMake = new CarMake(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
            );

            carBrandArrayList.add(carMake);
        }

        return carBrandArrayList;
    }

    public static void getModels(Context context) {
        Cursor res = getDataBaseInstance(context).descendingBrandsModel();

        while (res.moveToNext()) {
            Log.w("TAG","Car Brand: "+res.getString(2).replace("\n", ""));
            Log.w("TAG","Car model: "+res.getString(7).replace("\n", ""));

        }
    }

    public static ArrayList<CarModel> getModelsToSpecificBrand(Context context,String carBrandName) {

        ArrayList<CarModel> modelsArrayList = new ArrayList<CarModel>();

        Cursor res = getDataBaseInstance(context).descendingBrandsModel();

        while (res.moveToNext()) {
            //note brand id in model id
            if (carBrandName.equals(res.getString(5).replace("\n", "")))
            {
                CarModel carModel= new CarModel(
                        res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                );
                modelsArrayList.add(carModel);
            }
        }

        return modelsArrayList;
    }

    public static ArrayList<CarModel> getAllModels(Context context) {

        ArrayList<CarModel> modelsArrayList = new ArrayList<CarModel>();

        Cursor res = getDataBaseInstance(context).descendingBrandsModel();

        while (res.moveToNext()) {
            CarModel carModel= new CarModel(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")
                    ,res.getString(6).replace("\n", "")
                    ,res.getString(7).replace("\n", "")
                    ,res.getString(8).replace("\n", "")
            );
            modelsArrayList.add(carModel);
        }

        return modelsArrayList;
    }
}
