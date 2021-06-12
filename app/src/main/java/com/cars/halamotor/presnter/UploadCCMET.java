package com.cars.halamotor.presnter;

import android.util.Log;

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
import static com.cars.halamotor.functions.Functions.checkIfAndroidVBiggerThan9;

public class UploadCCMET {

    public static void postCCMET(String model_id, String category_id, String area_id, String title, String description,
                                 ArrayList<String> photos, double price, String year,String insurance_type
                                 ,String license_type,String[] car_options_array,String options,String fuel_type,String transmission_type
                                 ,String condition_type,String payment_method,String kilometers_from,String kilometers_to
                                 ,String userTokenInServer,UploadCCMETObjectToServer uploadCCMETObjectToServer)
    {

        Log.w("TAG","model_id: "+model_id);
        Log.w("TAG","category_id: "+category_id);
        Log.w("TAG","area_id: "+area_id);
        Log.w("TAG","title: "+title);
        Log.w("TAG","description: "+description);
        Log.w("TAG","photos: "+"no photos");
        Log.w("TAG","price: "+String.valueOf(price));
        Log.w("TAG","year: "+year);
        Log.w("TAG","insurance_type: "+insurance_type);
        Log.w("TAG","license_type: "+license_type);
        Log.w("TAG","car_options: "+options);
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
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("type","motors")
                    .addFormDataPart("model_id",model_id)
                    .addFormDataPart("category_id",category_id)
                    .addFormDataPart("area_id",area_id)
                    .addFormDataPart("title",title)
                    .addFormDataPart("description",description)

//                    .addFormDataPart("photos[]","Free-Stationery-Branding-Mockup.jpg",
//                            RequestBody.create(MediaType.parse("application/octet-stream"),
//                                    new File("/Users/apple/Downloads/Free-Stationery-Branding-Mockup.jpg")))
//                    .addFormDataPart("photos[]","PsFiles-Business-Card-Mockups.jpg",
//                            RequestBody.create(MediaType.parse("application/octet-stream"),
//                                    new File("/Users/apple/Downloads/PsFiles-Business-Card-Mockups.jpg")))

                    .addFormDataPart("price",String.valueOf(price))
                    .addFormDataPart("is_hot_price","0")
                    .addFormDataPart("year",year)
                    .addFormDataPart("car_insurance_type",insurance_type)
                    .addFormDataPart("car_license_type",license_type)
                    .addFormDataPart("car_option[]",options)
                    .addFormDataPart("car_fuel_type",fuel_type)
                    .addFormDataPart("car_transmission_type",transmission_type)
                    .addFormDataPart("car_condition_type",condition_type)
                    .addFormDataPart("payment_method",payment_method)
                    .addFormDataPart("kilometers_from",kilometers_from)
                    .addFormDataPart("kilometers_to",kilometers_to)
                    .build();

            Request request = new Request.Builder()
                    .url(BASE_API+"/ads")
                    .method("POST", body)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + userTokenInServer)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Log.w("TAG", "Response upload: " + response);
                JSONObject obj = null,data= null;
                try {
                    obj = new JSONObject(response.body().string());
                    data = obj.getJSONObject("DATA");

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                uploadCCMETObjectToServer.updateCCEMTSuccess(data);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
