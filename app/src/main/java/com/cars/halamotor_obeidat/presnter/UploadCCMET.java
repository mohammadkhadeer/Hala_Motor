package com.cars.halamotor_obeidat.presnter;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.model.CarDetailsModel;
import com.cars.halamotor_obeidat.model.CategoryComp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor_obeidat.functions.Functions.getNotificationObject;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.facebook.FacebookSdk.getApplicationContext;

public class UploadCCMET {

    public static void postCCMET(String model_id, String category_id, String area_id, String title, String description,
                                 ArrayList<String> photos, double price, String year, String insurance_type
            , String license_type, ArrayList<String> car_options_array, String options, String fuel_type, String transmission_type
            , String condition_type, String payment_method, String kilometers_from, String kilometers_to
            , String userTokenInServer, UploadCCMETObjectToServer uploadCCMETObjectToServer
            , String isHotPrice, String color_code, CarDetailsModel carDetailsModel, CategoryComp categoryCompNow
            , Context context,String phone_number)
    {

        Log.w("TAG","area_id: "+area_id);

        Log.w("TAG","category_id: "+category_id);
       // Log.w("TAG","image_path: "+photos.get(0));
//        Log.w("TAG","area_id: "+area_id);
//        Log.w("TAG","title: "+title);
//        Log.w("TAG","description: "+description);
//
//        for (int i=0;i<photos.size();i++)
//        {
//            Log.w("TAG","photos: "+String.valueOf(i)+" "+photos.get(i));
//        }
//
//        Log.w("TAG","price: "+String.valueOf(price));
//        Log.w("TAG","is Hot price: "+isHotPrice);
//        Log.w("TAG","year: "+year);
//        Log.w("TAG","insurance_type: "+insurance_type);
//        Log.w("TAG","license_type: "+license_type);
//
//        for (int i=0;i<car_options_array.size();i++)
//        {
//            Log.w("TAG","car_options: "+car_options_array.get(i));
//        }
//
//        Log.w("TAG","fuel_type: "+fuel_type);
//        Log.w("TAG","transmission_type: "+transmission_type);
//        Log.w("TAG","condition_type: "+condition_type);
//        Log.w("TAG","payment_method: "+payment_method);
//        Log.w("TAG","kilometers_from: "+kilometers_from);
//        Log.w("TAG","kilometers_to: "+kilometers_to);


        if (checkIfAndroidVBiggerThan9()) {
            Log.w("TAG","Start upload procces: ");

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();
            bodyBuilder.addFormDataPart("type","motors");
            bodyBuilder.addFormDataPart("model_id",model_id);
            bodyBuilder.addFormDataPart("category_id",category_id);
            bodyBuilder.addFormDataPart("area_id",area_id);
            bodyBuilder.addFormDataPart("title",title);
            bodyBuilder.addFormDataPart("description",description);

            for (int i=0;i<photos.size();i++)
            {
                bodyBuilder.addFormDataPart("photos[]",photos.get(i),
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File(photos.get(i))));
            }

            bodyBuilder.addFormDataPart("price",String.valueOf(price));
            bodyBuilder.addFormDataPart("is_hot_price",isHotPrice);
            bodyBuilder.addFormDataPart("year",year);
            bodyBuilder.addFormDataPart("car_insurance_type",insurance_type);
            bodyBuilder.addFormDataPart("car_license_type",license_type);

            for (int i=0;i<car_options_array.size();i++)
            {
                bodyBuilder.addFormDataPart("car_option[]",car_options_array.get(i));
            }

            bodyBuilder.addFormDataPart("car_fuel_type",fuel_type);
            bodyBuilder.addFormDataPart("car_transmission_type",transmission_type);
            bodyBuilder.addFormDataPart("car_condition_type",condition_type);
            bodyBuilder.addFormDataPart("payment_method",payment_method);
            bodyBuilder.addFormDataPart("kilometers_from",kilometers_from);
            bodyBuilder.addFormDataPart("kilometers_to",kilometers_to);
            bodyBuilder.addFormDataPart("phone",phone_number);
            bodyBuilder.addFormDataPart("color",color_code);
            bodyBuilder.build();

            MultipartBody.Builder builder = bodyBuilder.setType(MultipartBody.FORM);


            RequestBody body1 = builder.setType(MultipartBody.FORM).build();



            Request request = new Request.Builder()
                    .url(BASE_API+"/ads")
                    .method("POST", body1)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(getApplicationContext()))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Log.w("TAG", "Response upload: " + response);

                JSONObject obj = null,data= null;
                JSONArray jsonArray= null;
                String image_path = null;

                try {
                    obj = new JSONObject(response.body().string());
                    data = obj.getJSONObject("DATA");
                    jsonArray= data.getJSONArray("photos");

                    //insert process eng and ar
                    if (jsonArray != null && jsonArray.length() > 0) {
                        Log.w("TAG", "jsonArray.length(): " + String.valueOf(jsonArray.length()));

                        image_path =jsonArray.getString(0);
                    }else{
                        image_path ="no_image";
                    }

                    Log.w("TAG", "DATA: " + data.toString());
                    Log.w("TAG", "image_path: " + image_path);
                    Log.w("TAG", "post id: " + data.getString("id"));


                    insertNotificationTable(
                            getNotificationObject(
                                    categoryCompNow.getName_en() +"#"+categoryCompNow.getName_ar()
                                    , title
                                    ,data.getString("id")
                                    ,"out"
                                    ,"creator_name","creator_image","ads_des"
                                    ,category_id
                                    ,image_path)
                            ,getDataBaseInstance(context));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                uploadCCMETObjectToServer.updateCCEMTSuccess();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void postCCMET1(ArrayList<String> photos)
    {
        if (checkIfAndroidVBiggerThan9()) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();

            MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();
            bodyBuilder.addFormDataPart("type","motors");
            bodyBuilder.addFormDataPart("model_id","1");
            bodyBuilder.addFormDataPart("category_id","1");
            bodyBuilder.addFormDataPart("area_id","1");
            bodyBuilder.addFormDataPart("title","Obeidat static test from phone");
            bodyBuilder.addFormDataPart("description","Des static test from phone");

            for (int i=0;i<photos.size();i++)
            {
                bodyBuilder.addFormDataPart("photos[]",photos.get(i),
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/Users/apple/Downloads"+photos.get(i))));
            }

            bodyBuilder.addFormDataPart("price","4554");
            bodyBuilder.addFormDataPart("is_hot_price","0");
            bodyBuilder.addFormDataPart("year","2019");
            bodyBuilder.addFormDataPart("car_insurance_type","compulsory_insurance");
            bodyBuilder.addFormDataPart("car_license_type","licensed");
            bodyBuilder.addFormDataPart("car_option[]","sunroof");
            bodyBuilder.addFormDataPart("car_fuel_type","hybrid");
            bodyBuilder.addFormDataPart("car_transmission_type","automatic");
            bodyBuilder.addFormDataPart("car_condition_type","used");
            bodyBuilder.addFormDataPart("payment_method","installments_only");
            bodyBuilder.addFormDataPart("kilometers_from","200");
            bodyBuilder.addFormDataPart("kilometers_to","4000");
            bodyBuilder.addFormDataPart("phone","9090");
            bodyBuilder.addFormDataPart("color","red");
            bodyBuilder.build();

            MultipartBody.Builder builder = bodyBuilder.setType(MultipartBody.FORM);


            RequestBody body1 = builder.setType(MultipartBody.FORM).build();



            Request request = new Request.Builder()
                    .url(BASE_API+"/ads")
                    .method("POST", body1)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(getApplicationContext()))
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Log.w("TAG", "Response upload: " + response);

                JSONObject obj = null,data= null;
                JSONArray jsonArray= null;
                String image_path = null;

                try {
                    obj = new JSONObject(response.body().string());
                    data = obj.getJSONObject("DATA");
                    jsonArray= data.getJSONArray("photos");

                    //insert process eng and ar
                    if (jsonArray != null && jsonArray.length() > 0) {
                        Log.w("TAG", "jsonArray.length(): " + String.valueOf(jsonArray.length()));

                        image_path =jsonArray.getString(0);
                    }else{
                        image_path ="no_image";
                    }

                    Log.w("TAG", "DATA: " + data.toString());
                    Log.w("TAG", "image_path: " + image_path);
                    Log.w("TAG", "post id: " + data.getString("id"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
