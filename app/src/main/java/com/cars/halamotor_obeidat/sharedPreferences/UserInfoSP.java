package com.cars.halamotor_obeidat.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.cars.halamotor_obeidat.model.Follower;

import static android.content.Context.MODE_PRIVATE;

public class UserInfoSP {

    private static final String REGISTER = "REGISTER";

    public static Follower getUserInfoFromSP(Context context) {
        String followerName,followerID,followerToken,followerImage,followerEmail
                ,followerCity,followerNeighborhood;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        followerName = (shared.getString("firstName", ""))
                +" "+ (shared.getString("lastName", ""));
        followerID = (shared.getString("serverID", ""));
        followerToken = (shared.getString("userToken", ""));
        followerImage = (shared.getString("imageURL", ""));
        followerEmail = (shared.getString("email", ""));
        followerCity = (shared.getString("userCity", ""));
        followerNeighborhood = (shared.getString("userNeighborhood", ""));

        Follower followerInfo = new Follower(followerName,followerID,followerToken
                        ,followerImage,followerEmail,followerCity,followerNeighborhood);
        return followerInfo;
    }

    public static String getUserEmailFromSP(Context context) {
        String email;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        email = (shared.getString("email", ""));
        if (email.equals("") || email == null) {
            return  "empty";
        }
        else {
            return  email;
        }
    }

    public static String getUserNameFromSP(Context context) {
        String name,name1,name2;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        name1 = (shared.getString("firstName", ""));
        name2 = (shared.getString("lastName", ""));
        name = name1+" "+name2;
        if (name.equals("") || name == null) {
            return  "empty";
        }
        else {
            return  name;
        }
    }


}
