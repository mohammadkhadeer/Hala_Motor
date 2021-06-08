package com.cars.halamotor.presnter;

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

import static com.cars.halamotor.API.APIS.BASE_API;

public class LoginAndUpdateProfile {

    public static void whenLoginCompleteSuccess(String name, String email, String password, String platform, String platform_id,
                                                String userToken, String photo, String phone,Login login)
    {
        JSONObject obj = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("name",name)
                .addFormDataPart("email",email)
                .addFormDataPart("password",password)
                .addFormDataPart("platform",platform)
                .addFormDataPart("platform_id",platform_id)
                .addFormDataPart("platform_token",userToken)
                .addFormDataPart("photo",photo)
                .addFormDataPart("phone",phone)
                .build();
        Request request = new Request.Builder()
                .url(BASE_API+"/login")
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            try {
                obj = new JSONObject(response.body().string());
                //send response by interface
                login.whenLoginSuccess(obj,platform,platform_id);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateProfileSuccess(final String userTokenInServer, final UpdateProfile updateProfile
            , final String areaId, final String area) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                JSONObject obj = null;
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
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
                        Log.w("TAG", "Response " + response);

                        obj = new JSONObject(response.body().string());

                        JSONObject data = obj.getJSONObject("DATA");

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
}
