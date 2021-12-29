package com.cars.halamotor_obeidat.presnter;

import android.content.Context;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

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
