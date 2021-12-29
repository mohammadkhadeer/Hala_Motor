package com.cars.halamotor_obeidat.presnter;

import android.content.Context;
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
import static com.cars.halamotor_obeidat.sharedPreferences.CountryInfo.saveUserInfoSP;

public class CountryCitesAndArea {
    public static ArrayList<JSONObject> citiesArrayL  = new ArrayList<JSONObject>();
    public static ArrayList<JSONObject> areasArrayL  = new ArrayList<JSONObject>();

    public static void getCountryCitesAndAreas(final CountryCitesAndAreas countryCitesAndAreas, final DBHelper myDB, final Context context)
    {
        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/countries?language=en")
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "ar")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());

//                        Log.w("TAG","Response "+ response);
//                        Log.w("TAG","Obj "+  obj.getString("STATUS"));
//                        Log.w("TAG","Obj "+  obj.getString("MESSAGE"));
                    JSONArray jsonArrayCountry = obj.getJSONArray("DATA");
                    JSONObject jObjectCountryInfo = new JSONObject();
                    jObjectCountryInfo = jsonArrayCountry.getJSONObject(0);

                    getCountryInfo(jObjectCountryInfo,myDB,countryCitesAndAreas,context);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getCountryInfo(JSONObject jObjectCountryInfo, DBHelper myDB, CountryCitesAndAreas countryCitesAndAreas,Context context) {
        try {
            //save country info in SP
            saveUserInfoSP(context,jObjectCountryInfo.getString("id"),jObjectCountryInfo.getString("code")
            ,jObjectCountryInfo.getString("name"),jObjectCountryInfo.getString("name_en")
            ,jObjectCountryInfo.getString("name_ar"));

            Log.w("TAG","Saved in SP ");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        getCitesInfo(jObjectCountryInfo,myDB,countryCitesAndAreas);
    }

    private static void getCitesInfo(JSONObject jObjectCountryInfo, DBHelper myDB, CountryCitesAndAreas countryCitesAndAreas) {
        try {
            JSONArray jsonArrayCites = jObjectCountryInfo.getJSONArray("cities");
            JSONObject jObjectCityInfo = new JSONObject();

             int citiesNumberFlag = 0;
            for (int i=0;i<jsonArrayCites.length();i++)
            {
                jObjectCityInfo = jsonArrayCites.getJSONObject(i);
                citiesArrayL.add(jObjectCityInfo);
                //save cites info in cites database
                myDB.insertCites(jObjectCityInfo.getString("id"),jObjectCityInfo.getString("code")
                        ,jObjectCityInfo.getString("name"),jObjectCityInfo.getString("name_en"),jObjectCityInfo.getString("name_ar"));

                if (i == 7)
                {
                    citiesNumberFlag =1;
                }

            }
            if (citiesNumberFlag ==1)
            {
                Log.w("TAG","Saved cities in Database ");
                getAreasInfo(myDB,countryCitesAndAreas);
            }

        } catch (Exception e) {
            Log.w("TAG error", e.toString());
        }
    }

    private static void getAreasInfo(DBHelper myDB, CountryCitesAndAreas countryCitesAndAreas) {
        int flage = 0;
        for (int j=0;j < citiesArrayL.size();j++)
        {
            try {
                JSONArray jsonArrayAreas = citiesArrayL.get(j).getJSONArray("areas");
                JSONObject areaInfo = new JSONObject();

                for (int i=0;i<jsonArrayAreas.length();i++)
                {
                    areaInfo = jsonArrayAreas.getJSONObject(i);
                   // Log.w("TAG","space "+  "  ");
                    areasArrayL.add(areaInfo);
                    myDB.insertAreas(areaInfo.getString("id"),areaInfo.getString("name"),areaInfo.getString("name_en")
                    ,areaInfo.getString("name_ar")
                    ,citiesArrayL.get(j).getString("id"),citiesArrayL.get(j).getString("code")
                    ,citiesArrayL.get(j).getString("name"),citiesArrayL.get(j).getString("name_en")
                    ,citiesArrayL.get(j).getString("name_ar"));
                }

            } catch (Exception e) {
                Log.w("TAG error", e.toString());
            }
            if (j==7)
            {
                flage =1;
            }
        }

        if (flage ==1)
        {
            Log.w("TAG","Saved areas in Database ");
            Log.w("TAG number of areas", String.valueOf(areasArrayL.size()));
            countryCitesAndAreas.countryCitesAreasInfo();
        }

    }
}
