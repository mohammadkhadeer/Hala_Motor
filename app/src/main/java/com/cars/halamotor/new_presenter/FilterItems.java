package com.cars.halamotor.new_presenter;

import static com.cars.halamotor.API.APIS.BASE_API;
import static com.cars.halamotor.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor.model.Attributes;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CreatorInfo;
import com.cars.halamotor.model.ItemSelectedFilterModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FilterItems {

    public static void FilterItemsFun(ArrayList<ItemSelectedFilterModel> itemFilterArrayList
            , Context context, String city, String neighborhood,SearchResult searchResult){

        int category_id= Integer.parseInt(itemFilterArrayList.get(0).getFilterS());

        if (itemFilterArrayList.size() ==1)
        {
            if (city.equals("empty")){
                getItems(category_id,0.0,100000000.0,context,itemFilterArrayList.get(0),searchResult);
            }else{
                //resultFilter = getResultWithCityOrNeighborhood(category,categoryBefore,0.0,100000000.0,burnedPrice,city,neighborhood,numberResult);
            }
        }
    }

    private static void getItems(int category_id, double price_from, double price_to
            ,Context context,ItemSelectedFilterModel itemSelectedFilterModel,SearchResult searchResult) {

        if (checkIfAndroidVBiggerThan9()) {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/ads?is_active=1&is_hot_price=0&category_id="+category_id)
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
                    JSONArray jsonArrayAllAds = obj.getJSONArray("DATA");

                    getAdsList(jsonArrayAllAds,context,itemSelectedFilterModel,searchResult);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void getAdsList(JSONArray jsonArrayAllAds, Context context
            ,ItemSelectedFilterModel itemSelectedFilterModel,SearchResult searchResult) {
        //create suggested to you as object
        JSONObject adsDetails=null,attributes=null,creator_json_info=null;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        CreatorInfo creatorInfo =null;
        try {
            for (int i =0;i<jsonArrayAllAds.length();i++)
            {
                adsDetails = jsonArrayAllAds.getJSONObject(i);
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

                CategoryComp categoryComp = new CategoryComp(1,itemSelectedFilterModel.getFilterS(),itemSelectedFilterModel.getFilterS(),itemSelectedFilterModel.getFilterType(),itemSelectedFilterModel.getFilter(),itemSelectedFilterModel.getFilter());
                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryComp,photosArrayList,attributesArrayList,creatorInfo);


                adsArrayList.add(ccemtModel);

            }


            searchResult.whenGetCCEMTListSearchSuccess(adsArrayList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
