package com.cars.halamotor_obeidat.presnter;

import android.util.Log;

import com.cars.halamotor_obeidat.dataBase.DBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;

public class CarsBrandsAndModels {
    public static ArrayList<JSONObject> carsBrandsArrayL  = new ArrayList<JSONObject>();
    public static ArrayList<JSONObject> areasArrayL  = new ArrayList<JSONObject>();

    public static void getCarsBrandsAndModel(final DBHelper myDB)
    {
        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/brands")
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "ar")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllCarsBrands = obj.getJSONArray("DATA");

                    getCarsBrands(jsonArrayAllCarsBrands,myDB);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getCarsBrands(JSONArray jsonArrayAllCarsBrands, DBHelper myDB) {
        JSONObject jObjectSingleBrand, jObjectSingleModel;
        int flag=0;
        try {
            for (int i =0;i<jsonArrayAllCarsBrands.length();i++)
            {
                jObjectSingleBrand = jsonArrayAllCarsBrands.getJSONObject(i);
                //carsBrandsArrayL.add(jObjectSingleBrand);
                //insert car brand to database
                JSONArray jsonArrayAllModels = jObjectSingleBrand.getJSONArray("models");
//                carsBrandsArrayL.add(jObjectSingleBrand);
                myDB.insertCarsBrand(jObjectSingleBrand.getString("id"),jObjectSingleBrand.getString("name")
                ,jObjectSingleBrand.getString("name_en"),jObjectSingleBrand.getString("name_ar"));

                for (int j =0;j<jsonArrayAllModels.length();j++)
                {
                    //insert models to data base
                    jObjectSingleModel = jsonArrayAllModels.getJSONObject(j);
                    areasArrayL.add(jObjectSingleModel);

                    myDB.insertCarsModel(jObjectSingleModel.getString("id"),jObjectSingleModel.getString("name")
                    ,jObjectSingleModel.getString("name_en"),jObjectSingleModel.getString("name_ar")
                    ,jObjectSingleBrand.getString("id"),jObjectSingleBrand.getString("name")
                            ,jObjectSingleBrand.getString("name_en"),jObjectSingleBrand.getString("name_ar"));
                }

                if (i == (jsonArrayAllCarsBrands.length()-1))
                {
                    flag =1;
                }

            }

            if (flag==1)
            {
                Log.w("TAG","Cars done");
//                Log.w("TAG","carsBrandsArrayL: "+String.valueOf(carsBrandsArrayL.size()));
//                Log.w("TAG","areasArrayL: "+String.valueOf(areasArrayL.size()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
