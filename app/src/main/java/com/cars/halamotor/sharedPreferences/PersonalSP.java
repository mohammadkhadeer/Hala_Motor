package com.cars.halamotor.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class PersonalSP {
    static SharedPreferences SharedPreferences;
    static SharedPreferences.Editor editor;

    private static final String REGISTER = "PERSONAL_INFO";

    public static void saveUserInfoSP(Context context, String id, String name,String email,String phone,String photo
            ,String phone_is_verified,String email_is_verified,String language,String mute_notification,String area_id
            ,String area,String token) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("id",name);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.putString("photo",photo);
        editor.putString("phone_is_verified",phone_is_verified);
        editor.putString("email_is_verified",email_is_verified);
        editor.putString("language",language);
        editor.putString("mute_notification",mute_notification);
        editor.putString("area_id",area_id);
        editor.putString("area",area);
        editor.putString("token",token);
        editor.commit();
    }


    public static String getUserID(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("id", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserName(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("name", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserEmail(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("email", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserPhone(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("phone", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserPhoto(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("photo", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserPhoneV(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("phone_is_verified", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserEmailV(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("email_is_verified", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserLanguage(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("language", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserMute_notification(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("mute_notification", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserArea_id(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("area_id", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserArea(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("area", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }

    public static String getUserToken(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("token", ""));
        if (req.equals("") || req == null) {
            return  "empty";
        }
        else {
            return  req;
        }
    }
}
