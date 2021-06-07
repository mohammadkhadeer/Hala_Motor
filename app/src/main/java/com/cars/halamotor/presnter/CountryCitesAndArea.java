package com.cars.halamotor.presnter;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cars.halamotor.API.APIS.BASE_API;

public class CountryCitesAndArea {
    //to get country and cities and area from server must call this method in splash screen
    //coz the areas will not update in short time
    //we use this to save it in data base and will call it just one time first time
    //will save country info in sharedPrefancec and cities,areas in database

    public static void getCountryCitesAndAreas(CountryCitesAndAreas countryCitesAndAreas)
    {
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
            Log.w("TAG response",response.toString());
            JSONObject  objData ,objUser;
            try {
                obj = new JSONObject(response.body().string());
                Log.w("TAG",obj.toString());
                Log.w("TAG",obj.getString("STATUS"));
                Log.w("TAG",obj.getString("MESSAGE"));
                objData =obj.getJSONObject("DATA");
                Log.w("TAG",obj.getString("id"));
                Log.w("TAG",obj.getString("code"));
                Log.w("TAG",obj.getString("name"));
                Log.w("TAG",obj.getString("name_en"));
                Log.w("TAG",obj.getString("name_ar"));

                JSONArray jsonArray = new JSONArray(objData.getJSONArray("cities"));
                //JSONObject jsonObject = new JSONObject(jsonArray.getJSONObject(0));
                //JSONObject jsonObject = new JSONObject(jsonArray.getJSONObject(0).getString("id"));
                Log.w("TAG",objData.toString());
                countryCitesAndAreas.countryCitesAreasInfo(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
