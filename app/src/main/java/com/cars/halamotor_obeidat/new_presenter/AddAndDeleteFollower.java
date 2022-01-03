package com.cars.halamotor_obeidat.new_presenter;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.presnter.Login;
import com.cars.halamotor_obeidat.presnter.UpdateProfile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddAndDeleteFollower {

    public static void addNewFollower(String user_id, Context context)
    {
        JSONObject obj = null;
        Log.i("TAG","user_id: "+user_id);
        Log.i("TAG","Bearer: "+getUserTokenFromServer(context));

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");


        Request request = new Request.Builder()
                .url(BASE_API+"/users/"+user_id+"/follow")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject objData = null,objUser=null;

                Log.i("TAG","response: "+response.toString());

                obj = new JSONObject(response.body().string());
                Log.i("TAG","obj: "+obj.toString());

                //login.whenLoginSuccess(obj,platform,platform_id,photo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteFollow(String user_id, Context context)
    {
        JSONObject obj = null;
        Log.i("TAG","user_id: "+user_id);
        Log.i("TAG","Bearer: "+getUserTokenFromServer(context));

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("payment_method","cash")
                .build();


        Request request = new Request.Builder()
                .url(BASE_API+"/plans/"+user_id+"/subscribe")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject objData = null,objUser=null;

                Log.i("TAG","response: "+response.toString());

                obj = new JSONObject(response.body().string());
                Log.i("TAG","obj: "+obj.toString());

                //login.whenLoginSuccess(obj,platform,platform_id,photo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
