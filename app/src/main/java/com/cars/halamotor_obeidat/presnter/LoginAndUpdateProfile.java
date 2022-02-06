package com.cars.halamotor_obeidat.presnter;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;

import com.cars.halamotor_obeidat.model.CategoryComp;

public class LoginAndUpdateProfile {

    public static void whenLoginCompleteSuccess(String name, String email, String password, String platform, String platform_id,
                                                String userToken, String photo, String phone,Login login)
    {
        JSONObject obj = null;
        Log.i("TAG","email: "+email);
        Log.i("TAG","password: "+password);
        Log.i("TAG","name: "+name);
        Log.i("TAG","platform: "+platform);
        Log.i("TAG","platform_id: "+platform_id);
        Log.i("TAG","platform_token: "+userToken);
        Log.i("TAG","photo: "+photo);
        Log.i("TAG","phone: "+phone);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


//        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("name",name)
//                .addFormDataPart("email","abukhadeer@gmail.com")
//                .addFormDataPart("password","123456")
//                .addFormDataPart("platform","facebook")
//                .addFormDataPart("platform_id",platform_id)
//                .addFormDataPart("platform_token",userToken)
//                .addFormDataPart("photo",photo)
//                .addFormDataPart("phone",phone)
//                .build();

        //                .addFormDataPart("photo",photo)

        if (name == null)
        {
            name = "null";
        }
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("email",email)
                .addFormDataPart("password","123456")
                .addFormDataPart("name",name)
                .addFormDataPart("platform",platform)
                .build();


//        .addFormDataPart("platform_id",platform_id)
//            .addFormDataPart("platform_token",userToken)
//            .addFormDataPart("photo",photo)
//            .addFormDataPart("phone",phone)

        Request request = new Request.Builder()
                .url(BASE_API+"/login")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject objData = null,objUser=null;

                Log.i("TAG","response: "+response.toString());

                obj = new JSONObject(response.body().string());
                objData = obj.getJSONObject("DATA");
                objUser =objData.getJSONObject("user");


                //send response by interface
                login.whenLoginSuccess(obj,platform,platform_id,photo);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void updateProfileSuccess(final String userTokenInServer, final UpdateProfile updateProfile
            , final String areaId, final String area, final String device_token) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                JSONObject obj = null;
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("device_token", device_token)
                        .addFormDataPart("area_id", areaId)
                        .addFormDataPart("area", area)
                        .build();
                Request request = new Request.Builder()
                        .url(BASE_API + "/profile")
                        .method("POST", body)
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", "Bearer " + userTokenInServer)
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    try {
                        Log.w("TAG", "Response update" + response);

                        obj = new JSONObject(response.body().string());

                        JSONObject data = obj.getJSONObject("DATA");
                        Log.w("TAG", "data " + data.toString());
                        //data.getString("id")

                        updateProfile.updateSuccess(obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    public static void updateDeviceToken(final String userTokenInServer,
             final String device_token) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                JSONObject obj = null;
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                        .addFormDataPart("device_token", device_token)
                        .build();
                Request request = new Request.Builder()
                        .url(BASE_API + "/profile")
                        .method("POST", body)
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", "Bearer " + userTokenInServer)
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    try {
                        Log.w("TAG", "Response update" + response);

                        obj = new JSONObject(response.body().string());

                        JSONObject data = obj.getJSONObject("DATA");
                        Log.w("TAG", "data " + data.toString());
                        //data.getString("id")

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}
