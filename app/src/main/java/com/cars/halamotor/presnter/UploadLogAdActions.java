package com.cars.halamotor.presnter;

import android.content.Context;
import android.util.Log;

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
import static com.cars.halamotor.functions.Functions.getNotificationObject;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;

public class UploadLogAdActions {

    public static void postAdAction(final String ad_id, final String action
                                 , final Context context)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("text/plain");
                RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("type",action)
                        .build();

                Request request = new Request.Builder()
                        .url(BASE_API+"/ads/"+ad_id+"/log")
                        .method("POST", body)
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                        .addHeader("Accept-Language", "ar")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    //Log.w("TAG", "Response upload: " + response);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

}
