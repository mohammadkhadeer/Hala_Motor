package com.cars.halamotor.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.cars.halamotor.model.UserFaceBookInfo;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesInApp {

    private static final String REGISTER = "REGISTER";
    private static final String TITLE_AND_DES = "TITLE_AND_DES";
    private static final String PHONE_AND_ADDRESS = "PHONE_AND_ADDRESS";
    private static final String FB_INFO = "FB_INFO";
    private static final String ADS_INFO_SERVER = "ADS_INFO_SERVER";

    public static void saveUserTokenInFromSP(Context context,SharedPreferences SharedPreferences,
                                            SharedPreferences.Editor editor,String userToken) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("userToken",userToken);
        editor.commit();
    }

    public static String getUserTokenInFromSP(Context context) {
        String userToken;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        userToken = (shared.getString("userToken", ""));
        if (userToken.equals("") || userToken == null) {
            return  "empty";
        }
        else {
            return  userToken;
        }
    }

    public static void checkIfUserRegisterOrNotFromSP(Context context,SharedPreferences rgSharedPreferences,
                                         SharedPreferences.Editor rgEditor,String status) {
        rgSharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        rgEditor = rgSharedPreferences.edit();
        rgEditor.putString("registerOrNotYet",status);
        rgEditor.commit();
    }

    public static boolean checkIfUserRegisterOrNotFromSP(Context context) {
        String registerOrNotYetStr;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        registerOrNotYetStr = (shared.getString("registerOrNotYet", ""));
        if (registerOrNotYetStr.equals("") || registerOrNotYetStr == null) {
            return  false;
        }
        else {
            return  true;
        }
    }

    public static boolean checkIfUserRegisterOnServerSP(Context context) {
        String userIDOnServer;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check but this not clean any where then
        // no way to update user path in server to can test again go to
        //LoginWithSocialMedia and make checkIfUserRegisterOnServerSP method true and try
        userIDOnServer = (shared.getString("serverID", ""));
        if (userIDOnServer.equals("") || userIDOnServer == null ) {
            return  false;
        }
        else {
            return  true;
        }
    }

    public static String getUserIdInServerFromSP(Context context) {
        String userIDOnServer;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        //can use any comp from user info to check
        userIDOnServer = (shared.getString("serverID", ""));
        if (userIDOnServer.equals("") || userIDOnServer == null) {
            return  "empty";
        }
        else {
            return  userIDOnServer;
        }
    }

    public static boolean checkFBLoginOrNot(Context context) {
        String loginOrNotStr;
        SharedPreferences shared = context.getSharedPreferences(FB_INFO, MODE_PRIVATE);
        loginOrNotStr = (shared.getString("loginOrNot", ""));
        if (loginOrNotStr.equals("0") || loginOrNotStr == null) {
            return  false;
        }
        else {
            return  true;
        }
    }

    public static void checkFBLoginOrNot(Context context,SharedPreferences fbSharedPreferences,
                                      SharedPreferences.Editor fbEditor,String status) {
        fbSharedPreferences = context.getSharedPreferences(FB_INFO, MODE_PRIVATE);
        fbEditor = fbSharedPreferences.edit();
        fbEditor.putString("loginOrNot",status);
        fbEditor.commit();
    }

    public static UserFaceBookInfo getUserInfo(Context context) {
        String firstNameStr,lastNameStr,emailStr,idStr,userBirthdayStr,userImageStr;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        firstNameStr = (shared.getString("firstName", ""));
        lastNameStr = (shared.getString("lastName", ""));
        emailStr = (shared.getString("email", ""));
        idStr = (shared.getString("id", ""));
        userBirthdayStr = (shared.getString("birthday", ""));
        userImageStr = (shared.getString("imageURL", ""));

        UserFaceBookInfo userFaceBookInfo = new UserFaceBookInfo(firstNameStr,lastNameStr,emailStr,idStr,userBirthdayStr,userImageStr);
        return userFaceBookInfo;
    }


    public static void saveUserInfoInSP(Context context,SharedPreferences SharedPreferences,
                                      SharedPreferences.Editor Editor,String firstNameStr,String lastNameStr
            ,String emailStr,String idStr,String birthdayStr,String imageURLStr) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        Editor = SharedPreferences.edit();
        Editor.putString("firstName",firstNameStr);
        Editor.putString("lastName",lastNameStr);
        Editor.putString("email",emailStr);
        Editor.putString("id",idStr);
        Editor.putString("birthday",birthdayStr);
        Editor.putString("imageURL",imageURLStr);
        Editor.commit();
    }

    public static String getUserName(Context context) {
        String userName;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        userName = (shared.getString("firstName", ""));
        if (userName.equals("") || userName == null) {
            return  null;
        }
        else {
            return  userName;
        }
    }

    public static String getUserImage(Context context) {
        String imageStr;
        SharedPreferences shared = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        imageStr = (shared.getString("imageURL", ""));
        if (imageStr.equals("") || imageStr == null) {
            return  null;
        }
        else {
            return  imageStr;
        }
    }

    public static void saveFBInfoInSP(Context context,SharedPreferences fbSharedPreferences,
                                      SharedPreferences.Editor fbEditor,String firstNameStr,String lastNameStr
                                      ,String emailStr,String idStr,String birthdayStr,String imageURLStr) {
        fbSharedPreferences = context.getSharedPreferences(FB_INFO, MODE_PRIVATE);
        fbEditor = fbSharedPreferences.edit();
        fbEditor.putString("firstName",firstNameStr);
        fbEditor.putString("lastName",lastNameStr);
        fbEditor.putString("email",emailStr);
        fbEditor.putString("id",idStr);
        fbEditor.putString("birthday",birthdayStr);
        fbEditor.putString("imageURL",imageURLStr);
        fbEditor.commit();
    }

    public static UserFaceBookInfo getUserFBInfo(Context context) {
        String firstNameStr,lastNameStr,emailStr,idStr,userBirthdayStr,userImageStr;
        SharedPreferences shared = context.getSharedPreferences(FB_INFO, MODE_PRIVATE);
        firstNameStr = (shared.getString("firstName", ""));
        lastNameStr = (shared.getString("lastName", ""));
        emailStr = (shared.getString("email", ""));
        idStr = (shared.getString("id", ""));
        userBirthdayStr = (shared.getString("birthday", ""));
        userImageStr = (shared.getString("imageURL", ""));

        UserFaceBookInfo userFaceBookInfo = new UserFaceBookInfo(firstNameStr,lastNameStr,emailStr,idStr,userBirthdayStr,userImageStr);
        return userFaceBookInfo;
    }

    public static void saveServerIDInfoInSP(Context context,SharedPreferences SharedPreferences,
                                      SharedPreferences.Editor editor,String userIDStr) {
        SharedPreferences = context.getSharedPreferences(REGISTER, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("serverID",userIDStr);
        editor.commit();
    }

    public static void saveBurnedPriceInSP(Context context,SharedPreferences SharedPreferences,
                                     SharedPreferences.Editor editor,String burnedStr) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("burned",burnedStr);
        editor.commit();
    }

    public static String getBurnedPriceInSP(Context context) {
        String burnedStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        burnedStr = (shared.getString("burned", ""));
        if (burnedStr.equals("") || burnedStr == null || burnedStr.equals("0")) {
            return  null;
        }
        else {
            return  burnedStr;
        }
    }

    public static int getBurnedPriceIntInSP(Context context) {
        String burnedStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        burnedStr = (shared.getString("burned", ""));
        if (burnedStr.equals("") || burnedStr == null || burnedStr.equals("0")) {
            return  0;
        }
        else {
            return  1;
        }
    }

    public static void saveTitleInSP(Context context,SharedPreferences SharedPreferences,
                                            SharedPreferences.Editor editor,String titleStr) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("title",titleStr);
        editor.commit();
    }

    public static String getTitleInSP(Context context) {
        String titleStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        titleStr = (shared.getString("title", ""));
        if (titleStr.equals("") || titleStr == null) {
            return  null;
        }
        else {
            return  titleStr;
        }
    }

    public static void cleanTitle(Context context,SharedPreferences SharedPreferences,
                                   SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("title","");
        editor.commit();
    }

    public static void saveDesInSP(Context context,SharedPreferences SharedPreferences,
                                           SharedPreferences.Editor editor,String titleStr) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("des",titleStr);
        editor.commit();
    }

    public static String getDesInSP(Context context) {
        String desStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        desStr = (shared.getString("des", ""));
        if (desStr.equals("") || desStr == null) {
            return  null;
        }
        else {
            return  desStr;
        }
    }

    public static void cleanDes(Context context,SharedPreferences SharedPreferences,
                                                SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("des","");
        editor.commit();
    }

    public static void savePriceInSP(Context context,SharedPreferences SharedPreferences,
                                   SharedPreferences.Editor editor,String priceStr) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("price",priceStr);
        editor.commit();
    }

    public static String getPriceInSP(Context context) {
        String priceStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        priceStr = (shared.getString("price", ""));
        if (priceStr.equals("") || priceStr == null) {
            return  null;
        }
        else {
            return  priceStr;
        }
    }

    public static double getPriceAfterConvertedToDoubleInSP(Context context) {
        String priceStr;
        SharedPreferences shared = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        //can use any comp from user info to check
        priceStr = (shared.getString("price", ""));
        if (priceStr.equals("") || priceStr == null) {
            return  0;
        }
        else {
            return  Double.parseDouble(priceStr);
        }
    }

    public static void cleanPrice(Context context,SharedPreferences SharedPreferences,
                                                SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("price","");
        editor.commit();
    }

    public static void saveAddressInSP(Context context,SharedPreferences SharedPreferences,
             SharedPreferences.Editor editor,String cityStr,String neighborhoodStr
            ,String cityStrS,String neighborhoodStrS,String area_id) {
        SharedPreferences = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("city",cityStr);
        editor.putString("neighborhood",neighborhoodStr);
        editor.putString("cityS",cityStrS);
        editor.putString("neighborhoodS",neighborhoodStrS);
        editor.putString("area_id",area_id);
        editor.commit();
    }

    public static String getAreaIDInSP(Context context) {
        String req;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        req = (shared.getString("area_id", ""));
        if (req.equals("") || req == null) {
            return  null;
        }
        else {
            return  req;
        }
    }

    public static String getAddressInSP(Context context) {
        String addressStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        addressStr = (shared.getString("city", ""));
        if (addressStr.equals("") || addressStr == null) {
            return  null;
        }
        else {
            return  addressStr;
        }
    }

    public static String getCityFromSP(Context context) {
        String cityStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        cityStr = (shared.getString("city", ""));
        if (cityStr.equals("") || cityStr == null) {
            return  null;
        }
        else {
            return  cityStr;
        }
    }

    public static String getNeighborhoodFromSP(Context context) {
        String neighborhoodStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        neighborhoodStr = (shared.getString("neighborhood", ""));
        if (neighborhoodStr.equals("") || neighborhoodStr == null) {
            return  null;
        }
        else {
            return  neighborhoodStr;
        }
    }

    public static String getCitySFromSP(Context context) {
        String cityStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        cityStr = (shared.getString("cityS", ""));
        if (cityStr.equals("") || cityStr == null) {
            return  null;
        }
        else {
            return  cityStr;
        }
    }

    public static String getNeighborhoodSFromSP(Context context) {
        String neighborhoodStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        neighborhoodStr = (shared.getString("neighborhoodS", ""));
        if (neighborhoodStr.equals("") || neighborhoodStr == null) {
            return  null;
        }
        else {
            return  neighborhoodStr;
        }
    }

    public static void cleanAddress(Context context,SharedPreferences SharedPreferences,
                                  SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("city","");
        editor.putString("neighborhood","");
        editor.putString("cityS","");
        editor.putString("neighborhoodS","");
        editor.commit();
    }

    public static void savePhoneNumberInSP(Context context,SharedPreferences SharedPreferences,
                                       SharedPreferences.Editor editor,String phoneNumberStr) {
        SharedPreferences = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("phoneNumber",phoneNumberStr);
        editor.commit();
    }

    public static String getPhoneNumberInSP(Context context) {
        String phoneNumberStr;
        SharedPreferences shared = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        //can use any comp from user info to check
        phoneNumberStr = (shared.getString("phoneNumber", ""));
        if (phoneNumberStr.equals("") || phoneNumberStr == null) {
            return  null;
        }
        else {
            return  phoneNumberStr;
        }
    }

    public static void cleanPhoneNumber(Context context,SharedPreferences SharedPreferences,
                                    SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(PHONE_AND_ADDRESS, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("phoneNumber","");
        editor.commit();
    }

    public static void cleanTitleAndDesAndPrice(Context context,SharedPreferences SharedPreferences,
                                     SharedPreferences.Editor editor) {
        SharedPreferences = context.getSharedPreferences(TITLE_AND_DES, MODE_PRIVATE);
        editor = SharedPreferences.edit();
        editor.putString("title","");
        editor.putString("des","");
        editor.putString("price","");
        editor.putString("burned","");
        editor.commit();
    }

}
