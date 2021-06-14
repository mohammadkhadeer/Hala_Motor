package com.cars.halamotor.presnter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CategoryComp;

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

import static com.cars.halamotor.API.APIS.BASE_API;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor.functions.Functions.getNotification;
import static com.cars.halamotor.functions.Functions.getNotificationObject;

public class UploadCCMET {

    public static void postCCMET(String model_id, String category_id, String area_id, String title, String description,
                                 ArrayList<String> photos, double price, String year, String insurance_type
                                 , String license_type, ArrayList<String> car_options_array, String options, String fuel_type, String transmission_type
                                 , String condition_type, String payment_method, String kilometers_from, String kilometers_to
                                 , String userTokenInServer, UploadCCMETObjectToServer uploadCCMETObjectToServer
                                 , String isHotPrice, String color_code, CarDetailsModel carDetailsModel, CategoryComp categoryCompNow
                                 , Context context)
    {

        Log.w("TAG","model_id: "+carDetailsModel);
        Log.w("TAG","category_id: "+category_id);
        Log.w("TAG","area_id: "+area_id);
        Log.w("TAG","title: "+title);
        Log.w("TAG","description: "+description);

        for (int i=0;i<photos.size();i++)
        {
            Log.w("TAG","photos: "+String.valueOf(i)+" "+photos.get(i));
        }

        Log.w("TAG","price: "+String.valueOf(price));
        Log.w("TAG","is Hot price: "+isHotPrice);
        Log.w("TAG","year: "+year);
        Log.w("TAG","insurance_type: "+insurance_type);
        Log.w("TAG","license_type: "+license_type);

        for (int i=0;i<car_options_array.size();i++)
        {
            Log.w("TAG","car_options: "+car_options_array.get(i));
        }

        Log.w("TAG","fuel_type: "+fuel_type);
        Log.w("TAG","transmission_type: "+transmission_type);
        Log.w("TAG","condition_type: "+condition_type);
        Log.w("TAG","payment_method: "+payment_method);
        Log.w("TAG","kilometers_from: "+kilometers_from);
        Log.w("TAG","kilometers_to: "+kilometers_to);


        if (checkIfAndroidVBiggerThan9()) {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");

            MultipartBody.Builder body = new MultipartBody.Builder();
            body.addFormDataPart("type","motors");
            body.addFormDataPart("model_id",model_id);
            body .addFormDataPart("category_id",category_id);
            body.addFormDataPart("area_id",area_id);
            body.addFormDataPart("title",title);
            body.addFormDataPart("description",description);

            for (int i=0;i<photos.size();i++)
            {
                    body.addFormDataPart("photos[]",photos.get(i),
                    RequestBody.create(MediaType.parse("application/octet-stream"),
                            new File(photos.get(i))));
            }

            body.addFormDataPart("price",String.valueOf(price));
            body.addFormDataPart("is_hot_price",isHotPrice);
            body.addFormDataPart("year",year);
            body.addFormDataPart("car_insurance_type",insurance_type);
            body.addFormDataPart("car_license_type",license_type);

            for (int i=0;i<car_options_array.size();i++)
            {
                body.addFormDataPart("car_option[]",car_options_array.get(i));
            }


            body.addFormDataPart("car_fuel_type",fuel_type);
            body.addFormDataPart("car_transmission_type",transmission_type);
            body.addFormDataPart("car_condition_type",condition_type);
            body.addFormDataPart("payment_method",payment_method);
            body.addFormDataPart("kilometers_from",kilometers_from);
            body.addFormDataPart("kilometers_to",kilometers_to);
            body.addFormDataPart("car_color",color_code);


            RequestBody body1 = body.setType(MultipartBody.FORM).build();

            Request request = new Request.Builder()
                    .url(BASE_API+"/ads")
                    .method("POST", body1)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + userTokenInServer)
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
                    if (jsonArray != null) {
                        image_path =jsonArray.getString(0);
                    }else{
                        image_path ="no_image";
                    }

                    Log.w("TAG", "DATA: " + data.toString());
                    Log.w("TAG", "image_path: " + image_path);
                    Log.w("TAG", "post id: " + data.getString("id"));


                    insertNotificationTable(getNotificationObject(categoryCompNow.getName_en()+"#"+categoryCompNow.getName_ar(),title,data.getString("id"),"out","item",image_path),getDataBaseInstance(context));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                uploadCCMETObjectToServer.updateCCEMTSuccess();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
