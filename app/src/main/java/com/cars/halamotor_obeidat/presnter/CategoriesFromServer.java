package com.cars.halamotor_obeidat.presnter;

import android.util.Log;

import com.cars.halamotor_obeidat.model.CategoryComp;

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

public class CategoriesFromServer {
    public static ArrayList<CategoryComp> categoriesArrayL  = new ArrayList<CategoryComp>();

    public static void getCategories(CategoriesPresenter categoriesPresenter)
    {
        if (checkIfAndroidVBiggerThan9()) {
            categoriesArrayL  = new ArrayList<CategoryComp>();
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/categories")
                    .method("GET", null)
                    .addHeader("Accept", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllCategories = obj.getJSONArray("DATA");

                    getCategories(jsonArrayAllCategories,categoriesPresenter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getCategories(JSONArray jsonArrayAllCategories, CategoriesPresenter categoriesPresenter) {
        //create suggested to you as object
        CategoryComp suggestedToYou=new CategoryComp(0,"0","suggested","suggested","Suggested to you","مقترح لك");
        categoriesArrayL.add(suggestedToYou);

        JSONObject jObjectSingleCategory;
        int flag=0;
        try {
            for (int i =0;i<jsonArrayAllCategories.length();i++)
            {
                jObjectSingleCategory = jsonArrayAllCategories.getJSONObject(i);
                CategoryComp categoryComp=new CategoryComp
                        (0
                                ,jObjectSingleCategory.getString("id")
                                ,jObjectSingleCategory.getString("code")
                                ,jObjectSingleCategory.getString("name")
                                ,jObjectSingleCategory.getString("name_en")
                                , jObjectSingleCategory.getString("name_ar")
                        );

                categoriesArrayL.add(categoryComp);

                if (i == (jsonArrayAllCategories.length()-1))
                { flag =1; }
            }

            if (flag==1)
            {
                Log.w("TAG","Categories done");
                categoriesPresenter.whenGetCategoriesSuccess(categoriesArrayL);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
