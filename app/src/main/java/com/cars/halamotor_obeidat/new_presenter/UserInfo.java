package com.cars.halamotor_obeidat.new_presenter;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.model.CreatorInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserInfo {

    public static void userInfo(String user_id, Context context,UserInfoP userInfoP)
    {
        JSONObject obj = null,creator_info = null;
        //Log.i("TAG","in said user info user_id: "+user_id);
        //Log.i("TAG","Bearer: "+getUserTokenFromServer(context));

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(BASE_API+"/users/"+user_id)
                .method("GET", null)
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                .build();

        try {
            Response response = client.newCall(request).execute();
            try {
                JSONObject objData = null,objUser=null;

                Log.i("TAG","creator response: "+response.toString());

                obj = new JSONObject(response.body().string());
                creator_info = obj.getJSONObject("DATA");

                //Log.i("TAG","obj: "+obj.toString());
                String followers_count = creator_info.getString("followers_count");

                //Log.i("TAG","creatorInfo followers: "+followers_count);
                userInfoP.updateNumberOfFollowers(followers_count);

                //login.whenLoginSuccess(obj,platform,platform_id,photo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
