package com.cars.halamotor_obeidat.presnter;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.model.Attributes;
import com.cars.halamotor_obeidat.model.CCEMTSmallObject;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.SuggestedItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RelatedAdToSameCreator {
    List<SuggestedItem> relatedAdsToSameUserList = new ArrayList<>();

    public static void getRelatedAds(Context context, String user_id, String user_type,RelatedAds relatedAds)
    {

        if (checkIfAndroidVBiggerThan9()) {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/ads?creator_id="+user_id+"&creator_type="+user_type)
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                    .addHeader("Accept-Language", getUserLanguage(context))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject obj,adObj;
                JSONArray jsonArray;

                try {
                    obj = new JSONObject(response.body().string());
                    jsonArray = obj.getJSONArray("DATA");
                    Log.w("TAG",jsonArray.toString());

                    getAdsDetails(jsonArray,relatedAds);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsDetails(JSONArray arrayOfObjects,RelatedAds relatedAds) {
        //create suggested to you as object
        JSONObject creatorInfo,attributes;
        CreatorInfo creatorInfo1;
        ArrayList <String> optionsArrayList = null;
        ArrayList <Attributes> attributesArrayList ;
        //Log.w("TAG",adObj.toString());

        for (int i=0;i<arrayOfObjects.length();i++)
        {
            try {
                JSONObject addObject = arrayOfObjects.getJSONObject(i);
                creatorInfo = addObject.getJSONObject("creator");
                creatorInfo1 = new CreatorInfo(
                        creatorInfo.getString("id")
                        ,creatorInfo.getString("name")
                        ,creatorInfo.getString("ads_count")
                        ,creatorInfo.getString("followers_count")
                        ,creatorInfo.getString("following_count")
                        ,creatorInfo.getString("type")
                        ,creatorInfo.getString("photo")
                );

                CCEMTSmallObject ccemtSmallObject = new CCEMTSmallObject(
                        addObject.getString("id")

                        ,addObject.getString("title")
                        ,addObject.getString("description")
                        ,addObject.getString("price")
                        ,addObject.getString("phone")

                        ,addObject.getString("created_at")

                        ,addObject.getString("year")
                        ,addObject.getString("kilometers_from")
                        ,addObject.getString("kilometers_to")
                        ,addObject.getString("car_insurance_type")
                        ,addObject.getString("car_license_type")
                        ,addObject.getString("car_fuel_type")
                        ,addObject.getString("car_transmission_type")
                        ,addObject.getString("car_condition_type")
                        ,addObject.getString("payment_method")
                        ,addObject.getString("color")
                        ,addObject.getString("area")
                        ,addObject.getString("model")

                        ,optionsArrayList
                        ,creatorInfo1
                );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        //relatedAds.relatedAdsToSameUser();


    }
}
