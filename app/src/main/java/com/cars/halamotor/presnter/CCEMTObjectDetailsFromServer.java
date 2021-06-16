package com.cars.halamotor.presnter;

import android.content.Context;
import android.util.Log;
import com.cars.halamotor.model.Attributes;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CCEMTModelDetails;
import com.cars.halamotor.model.CCEMTSmallObject;
import com.cars.halamotor.model.CategoryComp;
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
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;

public class CCEMTObjectDetailsFromServer {

    public static void getCCEMTObjectDetails(Context context, String ad_id, CategoryComp categoryComp,ItemModel itemModel)
    {
        if (checkIfAndroidVBiggerThan9()) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/ads/"+ad_id)
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                    .addHeader("Accept-Language", "ar")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject obj,adObj;
                try {
                    obj = new JSONObject(response.body().string());
                    adObj = obj.getJSONObject("DATA");

                    getAdsDetails(adObj,categoryComp,itemModel);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsDetails(JSONObject adObj, CategoryComp categoryComp, ItemModel itemModel) {
        //create suggested to you as object
        JSONObject adsDetails,attributes;
        ArrayList <String> photosArrayList,photosArrayList2 ;
        ArrayList <String> optionsArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        CCEMTModelDetails ccemtModelDetails=null;

        try {
            JSONArray jsonArrayOptionsAds = adObj.getJSONArray("car_option");

            optionsArrayList =new ArrayList<>();
            if (jsonArrayOptionsAds !=null && jsonArrayOptionsAds.length()>0)
            {
                for (int r=0;r<jsonArrayOptionsAds.length();r++)
                {
                    optionsArrayList.add(jsonArrayOptionsAds.getString(r));
                }
            }

            String car_color;
            if (adObj.getString("car_color") ==null)
            { car_color = "----"; }else{ car_color =adObj.getString("car_color"); }

            JSONArray jsonArrayPhotos2 = adObj.getJSONArray("photos");

            photosArrayList2 =new ArrayList<>();
            if (jsonArrayPhotos2 !=null && jsonArrayPhotos2.length()>0)
            {
                for (int x=0;x<jsonArrayPhotos2.length();x++)
                {
                    photosArrayList2.add(jsonArrayPhotos2.getString(x));
                }
            }

            CCEMTSmallObject ccemtSmallObject = new CCEMTSmallObject(
                    adObj.getString("id")
                    ,adObj.getString("title")
                    ,adObj.getString("description")
                    ,adObj.getString("price")
                    ,adObj.getString("phone")
                    ,adObj.getString("created_at")
                    ,adObj.getString("year")
                    ,adObj.getString("kilometers_from")
                    ,adObj.getString("kilometers_to")
                    ,adObj.getString("car_insurance_type")
                    ,adObj.getString("car_license_type")
                    ,adObj.getString("car_fuel_type")
                    ,adObj.getString("car_transmission_type")
                    ,adObj.getString("car_condition_type")
                    ,adObj.getString("payment_method")
                    ,car_color
                    ,optionsArrayList
            );

            JSONArray jsonArrayAttributes = adObj.getJSONArray("attributes");
            attributesArrayList =new ArrayList<>();
            for (int j=0;j<jsonArrayAttributes.length();j++)
            {
                attributes =  jsonArrayAttributes.getJSONObject(j);
                Attributes attributesObj = new Attributes(attributes.getString("type"),attributes.getString("value"),attributes.getString("title"));
                attributesArrayList.add(attributesObj);
            }



            ccemtModelDetails= new CCEMTModelDetails(
                    ccemtSmallObject
                    ,categoryComp
                    ,photosArrayList2
                    ,attributesArrayList
            );


        } catch (JSONException e) {
            e.printStackTrace();
        }





        //similar ads
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        int flag=0;

        try {
            adsArrayList = new ArrayList<>();
            JSONArray jsonArrayAllAds = adObj.getJSONArray("relevant_ads");
            for (int i =0;i<jsonArrayAllAds.length();i++)
            {
                adsDetails = jsonArrayAllAds.getJSONObject(i);
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

                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryComp,photosArrayList,attributesArrayList);

                adsArrayList.add(ccemtModel);

                if (i == (adsDetails.length()-1))
                { flag =1; }
            }

            if (flag==1)
            {
                itemModel.onReceiveCCEMTObjectDetails(ccemtModelDetails,adsArrayList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
