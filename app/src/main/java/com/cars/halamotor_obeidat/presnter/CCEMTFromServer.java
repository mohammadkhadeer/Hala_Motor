package com.cars.halamotor_obeidat.presnter;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.model.Attributes;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.CreatorInfo;

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
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

public class CCEMTFromServer {

    public static void getCCEMT(Context context,CategoryComp categoryComp)
    {
        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/ads?is_active=1&is_hot_price=0&category_id="+categoryComp.getId())
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                    .addHeader("Accept-Language", getUserLanguage(context))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllAds = obj.getJSONArray("DATA");

                    getAdsList(jsonArrayAllAds,categoryComp);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsList(JSONArray jsonArrayAllAds,CategoryComp categoryComp) {
        //create suggested to you as object
        JSONObject adsDetails,attributes;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        CreatorInfo creatorInfo;
        int flag=0;
        try {
            for (int i =0;i<jsonArrayAllAds.length();i++)
            {
                adsDetails = jsonArrayAllAds.getJSONObject(i);
                creatorInfo = new CreatorInfo(
                        adsDetails.getString("id")
                        ,adsDetails.getString("name")
                        ,adsDetails.getString("ads_count")
                        ,adsDetails.getString("followers_count")
                        ,adsDetails.getString("following_count")
                        ,adsDetails.getString("type")
                        ,adsDetails.getString("photo")
                );
                JSONArray jsonArrayPhotos = adsDetails.getJSONArray("photos");
                JSONArray jsonArrayAttributes = adsDetails.getJSONArray("attributes");

                photosArrayList =new ArrayList<>();
                if (jsonArrayPhotos !=null && jsonArrayPhotos.length()>0)
                {
                    for (int x=0;x<jsonArrayPhotos.length();x++)
                    {
                        photosArrayList.add(jsonArrayPhotos.getString(x));
                    }
                }

                attributesArrayList =new ArrayList<>();
                for (int j=0;j<jsonArrayAttributes.length();j++)
                {
                    attributes =  jsonArrayAttributes.getJSONObject(j);
                    Attributes attributesObj = new Attributes(attributes.getString("type"),attributes.getString("value"),attributes.getString("title"));
                    attributesArrayList.add(attributesObj);
                }

                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryComp,photosArrayList,attributesArrayList,creatorInfo);

                adsArrayList.add(ccemtModel);

                if (i == (adsDetails.length()-1))
                { flag =1; }
            }

            if (flag==1)
            {
                Log.w("TAG","CCEMT done");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
