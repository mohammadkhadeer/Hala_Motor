package com.cars.halamotor_obeidat.presnter;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class FCSFromServer {

    public static void getFCS(Context context,String FCSType,FCSItemsList fcsItemsList,int pageNumber)
    {
        Log.i("TAG Bearer Token",getUserTokenFromServer(context));
        Log.i("TAG device Token",getUserTokenInFromSP(context));
        //Log.i("TAG API",BASE_API+"/ads?is_active=1&is_hot_price=0&category_id="+categoryComp.getId());

        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/logs?type="+FCSType+"&page="+pageNumber)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                    .addHeader("Accept-Language", getUserLanguage(context))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllAds = obj.getJSONArray("DATA");

                    getAdsList(jsonArrayAllAds,fcsItemsList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsList(JSONArray jsonArrayAllAds,FCSItemsList fcsItemsList) {
        //create suggested to you as object
        Log.i("TAG","jsonArrayAllAds: ");
        CategoryComp categoryCompModel =null;
        JSONObject adsDetails=null,attributes=null,creator_json_info=null,categoryComp=null;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        CreatorInfo creatorInfo =null;
        try {
            for (int i =0;i<jsonArrayAllAds.length();i++)
            {
                adsDetails = jsonArrayAllAds.getJSONObject(i).getJSONObject("ad");
                //Log.i("TAG","adsDetails: "+adsDetails.toString());

                JSONArray jsonArrayPhotos = adsDetails.getJSONArray("photos");
                JSONArray jsonArrayAttributes = adsDetails.getJSONArray("attributes");
                creator_json_info = adsDetails.getJSONObject("creator");
                creatorInfo = new CreatorInfo(
                        creator_json_info.getString("id")
                        ,creator_json_info.getString("name")
                        ,creator_json_info.getString("ads_count")
                        ,creator_json_info.getString("followers_count")
                        ,creator_json_info.getString("following_count")
                        ,creator_json_info.getString("type")
                        ,creator_json_info.getString("photo")
                );
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

                categoryComp = adsDetails.getJSONObject("category");

                categoryCompModel = new CategoryComp(
                        0
                        ,categoryComp.getString("id")
                        ,categoryComp.getString("code")
                        ,categoryComp.getString("name")
                        ,categoryComp.getString("name_en")
                        ,categoryComp.getString("name_ar")
                );

                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryCompModel,photosArrayList,attributesArrayList,creatorInfo);

                adsArrayList.add(ccemtModel);
            }
            fcsItemsList.passArrayList(adsArrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
