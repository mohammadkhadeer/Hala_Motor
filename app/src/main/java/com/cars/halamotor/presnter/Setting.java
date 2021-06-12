package com.cars.halamotor.presnter;

import android.util.Log;

import com.cars.halamotor.dataBase.DBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.cars.halamotor.API.APIS.BASE_API;
import static com.cars.halamotor.functions.Functions.checkIfAndroidVBiggerThan9;

public class Setting {
    public static ArrayList<JSONObject> settingArrayL  = new ArrayList<JSONObject>();

    public static void getSetting(final DBHelper myDB)
    {
        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/settings")
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "ar")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllSetting= obj.getJSONArray("DATA");

                    getSetting(jsonArrayAllSetting,myDB);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getSetting(JSONArray jsonArrayAllSetting, DBHelper myDB) {
        JSONObject jObjectSingleSetting, jObjectSingleSettingComp;
        int flag=0;
        try {
            for (int i =0;i<jsonArrayAllSetting.length();i++)
            {
                jObjectSingleSetting = jsonArrayAllSetting.getJSONObject(i);
                //carsBrandsArrayL.add(jObjectSingleBrand);
                //insert car brand to database
                JSONArray jsonArrayAllModels = jObjectSingleSetting.getJSONArray("options");


                for (int j =0;j<jsonArrayAllModels.length();j++)
                {
                    //insert models to data base
                    jObjectSingleSettingComp = jsonArrayAllModels.getJSONObject(j);
                    //settingArrayL.add(jObjectSingleSettingComp);

                    myDB.insertSetting(jObjectSingleSetting.getString("id"),jObjectSingleSetting.getString("code")
                    ,jObjectSingleSetting.getString("name"),jObjectSingleSetting.getString("name_en")
                    ,jObjectSingleSetting.getString("name_ar")
                    ,jObjectSingleSettingComp.getString("id"),jObjectSingleSettingComp.getString("code")
                    ,jObjectSingleSettingComp.getString("name"),jObjectSingleSettingComp.getString("name_en")
                    ,jObjectSingleSettingComp.getString("name_ar"));
                }

                if (i == (jsonArrayAllModels.length()-1))
                {
                    flag =1;
                }

            }

            if (flag==1)
            {
                Log.w("TAG","Setting done");
//                Log.w("TAG","carsBrandsArrayL: "+String.valueOf(carsBrandsArrayL.size()));
//                Log.w("TAG","areasArrayL: "+String.valueOf(areasArrayL.size()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
