package com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cars.halamotor.model.Attributes;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterCCEMTAllCases;

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
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;

public class FillCCEMTType  {

    static AdapterCCEMTAllCases adapterCCEMTAllCases;
    static RecyclerView.LayoutManager layoutManager;
    public static void handelCCEMTAdsList(final Context context, final CategoryComp categoryComp, final RecyclerView recyclerView){

        if (categoryComp.getCode().equals("car_for_sale") || categoryComp.getCode().equals("car_for_rent") || categoryComp.getCode().equals("exchange_car") || categoryComp.getCode().equals("motorcycle") || categoryComp.getCode().equals("trucks"))
        {
            getCCEMT(context,categoryComp,recyclerView);
        }
    }

    private static void createRV(final ArrayList<CCEMTModel> adsArrayList, final Context context, final RecyclerView recyclerView) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, false);

                recyclerView.setLayoutManager(layoutManager);
                adapterCCEMTAllCases =new AdapterCCEMTAllCases(context
                        ,adsArrayList,"suggested_fragment");
                recyclerView.setAdapter(adapterCCEMTAllCases);
            }
        });
        thread.start();

    }

    public static void getCCEMT(Context context, CategoryComp categoryComp, RecyclerView recyclerView)
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

                    getAdsList(jsonArrayAllAds,categoryComp,recyclerView,context);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getAdsList(JSONArray jsonArrayAllAds,CategoryComp categoryComp, RecyclerView recyclerView,Context context) {
        //create suggested to you as object
        JSONObject adsDetails=null,attributes=null;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        try {
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
            }

            createRV(adsArrayList,context,recyclerView);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}