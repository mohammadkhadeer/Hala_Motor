package com.cars.halamotor.new_presenter;

import static com.cars.halamotor.API.APIS.BASE_API;
import static com.cars.halamotor.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor.model.Attributes;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CCEMTSmallObject;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CreatorInfo;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.presnter.RelatedAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RelatedAdToSameAd {
    List<SuggestedItem> relatedAdsToSameUserList = new ArrayList<>();

    public static void getRelatedAds(Context context, String Ad_id,RelativeResult relativeResult)
    {

        if (checkIfAndroidVBiggerThan9()) {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/ads/"+Ad_id+"/relevant")
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

                    getAdsDetails(jsonArray,relativeResult);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsDetails(JSONArray arrayOfObjects,RelativeResult relativeResult) {
        JSONObject adsDetails=null,attributes=null,creator_json_info=null;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        CreatorInfo creatorInfo =null;
        try {
            for (int i =0;i<arrayOfObjects.length();i++)
            {
                adsDetails = arrayOfObjects.getJSONObject(i);
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

                CategoryComp categoryComp = new CategoryComp(1,"1","car for sale","car for sale","car for sale","car for sale");
                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryComp,photosArrayList,attributesArrayList,creatorInfo);


                adsArrayList.add(ccemtModel);

            }

            relativeResult.whenGetCCEMTListSearchSuccess(adsArrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //relatedAds.relatedAdsToSameUser();


    }
}
