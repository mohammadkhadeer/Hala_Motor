package com.cars.halamotor_obeidat.service;

import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;


import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.model.Attributes;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.view.activity.AboutUs;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor_obeidat.functions.Functions.getNotificationObject;
import static com.cars.halamotor_obeidat.presnter.LoginAndUpdateProfile.updateDeviceToken;
import static com.cars.halamotor_obeidat.sharedPreferences.NotificationSharedPreferences.getUnreadNotificationsInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.NotificationSharedPreferences.updateNumberUnreadNotifications;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FcmMessagingService extends FirebaseMessagingService {
    private NotificationManagerCompat notificationManager;
    Bitmap bitmap1;
    ConvertUrlToBitmap convertUrlToBitmap;
    String process_en="",process_ar="",ads_id="",creator_image=""
            ,creator_name="",category_id="",ads_image="",title,des,ads_des;
    ArrayList <String> photosArrayList ;
    ArrayList <Attributes> attributesArrayList ;
    JSONObject notification_json_object = null,creator_json_info=null,categoryComp=null,attributes=null;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    CategoryComp categoryCompModel =null;

    //String channel_id;
    String[] titleArray,desArray,optionalArray,optionalAndDesArray;
    DBHelper dbHelper;

    public static final String CHANNEL_1_ID="new_items";
    public static final String CHANNEL_2_ID="new_offers";
    public static final String CHANNEL_3_ID="important_message";

    @Override
    public void onNewToken(String new_token) {
        super.onNewToken(new_token);
        Log.e("NEW_TOKEN",new_token);
        updateDeviceToken(getUserTokenFromServer(getApplicationContext()),new_token);

        Intent intent = new Intent(FcmMessagingService.this, SaveFCMTokenService.class);
        intent.putExtra("TOKEN",new_token);
        getSharedPreferences("REGISTER", MODE_PRIVATE).edit().putString("userToken", new_token).apply();
        FcmMessagingService.this.startService(intent);

    }

    @SuppressLint("WrongThread")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        intiValue();
        Log.i("TAG", "onMessageReceived: ");
//        if (remoteMessage.getData() != null)
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//                sendNotificationAPI26(remoteMessage);
//            else
//                sendNotificationAPI(remoteMessage);
//
//
//
//         Check if message contains a notification payload.
        //remoteMessage.getNotification()

        if (remoteMessage.getData() != null) {

            //Log.d("TAG", "remoteMessage: " + remoteMessage.getData().toString());
            String notification_object = remoteMessage.getData().get("ad").toString();
            Log.d("TAG", "notification_object: " +  notification_object);

            initNotificationComponent(notification_object);

            updateNotOpenNotificationNumber();

            insertNotificationInDataBase();

            Log.i("TAG","ads_image: "+ads_image);
            sendNotificationAPI26();
//            if (!ads_image.equals("no_image"))
//                convertUrlToBitmap = (ConvertUrlToBitmap) new ConvertUrlToBitmap().execute(ads_image);

        }else{
            Log.i("TAG", "onMessageReceived: remoteMessage.getNotification() == null");
            //Log.d("TAG", "remoteMessage: " + remoteMessage.getData().toString());
        }
    }

    private void insertNotificationInDataBase() {
        insertNotificationTable(
                getNotificationObject(
                        process_en +"#"+process_ar
                        , title
                        ,ads_id
                        ,"in"
                        ,creator_name
                        ,creator_image
                        ,ads_des
                        ,category_id
                        ,ads_image)
                ,getDataBaseInstance(getApplicationContext()));
    }

    private void initNotificationComponent(String notification_object) {
        try {
            notification_json_object = new JSONObject(notification_object);

            creator_json_info  = notification_json_object.getJSONObject("creator");
            creator_image = creator_json_info.getString("photo");
            creator_name = creator_json_info.getString("name");

            categoryComp = notification_json_object.getJSONObject("category");
            process_en = categoryComp.getString("name_en");
            process_ar = categoryComp.getString("name_ar");
            category_id = categoryComp.getString("id");
            categoryCompModel = new CategoryComp(
                    0
                    ,categoryComp.getString("id")
                    ,categoryComp.getString("code")
                    ,categoryComp.getString("name")
                    ,categoryComp.getString("name_en")
                    ,categoryComp.getString("name_ar")
            );

            title = notification_json_object.getString("title");
            ads_id = notification_json_object.getString("id");

            JSONArray jsonArrayAttributes = notification_json_object.getJSONArray("attributes");
            attributesArrayList =new ArrayList<>();
            for (int j=0;j<jsonArrayAttributes.length();j++)
            {
                attributes =  jsonArrayAttributes.getJSONObject(j);
                Attributes attributesObj = new Attributes(attributes.getString("type"),attributes.getString("value"),attributes.getString("title"));
                attributesArrayList.add(attributesObj);
            }

            ads_des = attributesArrayList.get(0).getTitle()+" "+attributesArrayList.get(1).getTitle();

            JSONArray jsonArrayPhotos = notification_json_object.getJSONArray("photos");
            photosArrayList =new ArrayList<>();
            if (jsonArrayPhotos !=null && jsonArrayPhotos.length()>0)
            {
                for (int x=0;x<jsonArrayPhotos.length();x++)
                {
                    photosArrayList.add(jsonArrayPhotos.getString(x));
                }
            }
            if (!photosArrayList.isEmpty())
                ads_image = photosArrayList.get(0);
            else
                ads_image = "no_image";



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


//
    private void sendNotificationAPI26() {
        Log.i("TAG","sendNotificationAPI26: "+"on");

        Intent resultIntent = new Intent(getApplicationContext(), AboutUs.class);
        resultIntent.putExtra("category",categoryCompModel.getCode());
        resultIntent.putExtra("category_comp",categoryCompModel);
        resultIntent.putExtra("from","ml");
        resultIntent.putExtra("itemID",ads_id);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        String content = creator_name + " "
                + " " + ads_des;
        Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_3_ID)
                .setColor(Color.BLUE)
                .setContentTitle(title)
                .setContentText(content)
                .setLargeIcon(bitmap1)
                .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        notificationManager.notify(1, notification);
        //notificationListener.ready(1);
    }

    private void updateNotOpenNotificationNumber() {
        //check if app in the front ground update the number of notifications
        int unreadNotification = Integer.parseInt(getUnreadNotificationsInSP(this));
        unreadNotification = unreadNotification + 1;
        updateNumberUnreadNotifications(this, sharedPreferences, editor, String.valueOf(unreadNotification));
    }

    private class ConvertUrlToBitmap extends AsyncTask<String, Long, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                Log.i("TAG","ConvertUrlToBitmap: "+"on");

                URL url = new URL(params[0]);
                bitmap1 = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                //Log.d("TAG", "channel_id: " + channel_id);

                Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_1_ID)
                        .setColor(Color.BLUE)
                        .setContentTitle(title)
                        .setContentText(des)
                        .setLargeIcon(bitmap1)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(bitmap1)
                                .bigLargeIcon(null))
                        .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();

                notificationManager.notify(123, notification);

//                if (channel_id.equals("new_items"))
//                {
//                    Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_1_ID)
//                            .setColor(Color.BLUE)
//                            .setContentTitle(title)
//                            .setContentText(des)
//                            .setLargeIcon(bitmap1)
//                            .setStyle(new NotificationCompat.BigPictureStyle()
//                                .bigPicture(bitmap1)
//                                .bigLargeIcon(null))
//                            .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
//                            .setPriority(NotificationCompat.PRIORITY_HIGH)
//                            .build();
//
//                    notificationManager.notify(123, notification);
//                }
//
//                if (channel_id.equals("new_offers"))
//                {
//                    Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_1_ID)
//                            .setColor(Color.BLUE)
//                            .setContentTitle(title)
//                            .setContentText(des)
//                            .setLargeIcon(bitmap1)
//                            .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
//                            .setPriority(NotificationCompat.PRIORITY_HIGH)
//                            .build();
//
//                    notificationManager.notify(12, notification);
//                }
//
//                if (channel_id.equals("important_message"))
//                {
//                    Intent resultIntent = new Intent(getApplicationContext(), AboutUs.class);
////                    resultIntent.putExtra("item_object", notificationModel);
//                    resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//                    Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_3_ID)
//                            .setColor(Color.BLUE)
//                            .setContentTitle(title)
//                            .setContentText(des)
//                            .setLargeIcon(bitmap1)
//                            .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
//                            .setPriority(NotificationCompat.PRIORITY_HIGH)
//                            .setAutoCancel(true)
//                            .setContentIntent(pendingIntent)
//                            .build();
//
//                    notificationManager.notify(1, notification);
//                    //notificationListener.ready(1);
//                }

                return true;
            } catch (Exception e) {
                Log.e("TAG", e.toString());
                return false;
            }
        }
    }

    private void intiValue() {
        notificationManager = NotificationManagerCompat.from(this);
        dbHelper = getDataBaseInstance(getApplicationContext());
    }

}
