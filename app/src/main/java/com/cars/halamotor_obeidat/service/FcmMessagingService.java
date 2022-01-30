package com.cars.halamotor_obeidat.service;

import static android.os.Build.VERSION_CODES.R;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;


import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.view.activity.AboutUs;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.net.URL;
import java.util.Map;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.presnter.LoginAndUpdateProfile.updateDeviceToken;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;

import org.json.JSONException;
import org.json.JSONObject;

public class FcmMessagingService extends FirebaseMessagingService {
    private NotificationManagerCompat notificationManager;
    Bitmap bitmap1;
    ConvertUrlToBitmap convertUrlToBitmap;
    String title,des,imageUrl,optional;
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

        if (remoteMessage.getNotification() != null) {

            Log.d("TAG", "remoteMessage: " + remoteMessage.getData().toString());
            Log.d("TAG", "Key Data : " +  remoteMessage.getData().get("priority").toString());
            Log.d("TAG", "Key Data : " +  remoteMessage.getData().get("object").toString());
            Log.d("TAG", "Key Data : " +  remoteMessage.getData().get("ad").toString());
            String testS = remoteMessage.getData().get("ad").toString();
            Log.d("TAG", "testS : " +  testS);
            JSONObject json = null;
            try {
                json = new JSONObject(testS);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("TAG json", json.toString());




//            title = remoteMessage.getNotification().getTitle();
//            des = remoteMessage.getNotification().getBody();

            //updateNotOpenNotificationNumber();
            //insetNotificationToDB();

            //Log.d("TAG", "channel_id: " + channel_id);
            //Log.d("TAG", "title_en: " + title);
            //Log.d("TAG", "des: " + des);
//            Log.d("TAG", "des_en: " + desArray[0]);
//            Log.d("TAG", "des_Local: " + desArray[1]);
//            Log.d("TAG", "optional_en: " + optionalArray[0]);
//            Log.d("TAG", "optional_Local: " + optionalArray[1]);
//
            //Log.d("TAG", "imageUrl: " + imageUrl);
            //convertUrlToBitmap = (ConvertUrlToBitmap) new ConvertUrlToBitmap().execute(imageUrl);

        }else{
            Log.i("TAG", "onMessageReceived: remoteMessage.getNotification() == null");
        }
    }


//    private void sendNotificationAPI(RemoteMessage remoteMessage) {
//        Map<String,String> data = remoteMessage.getData();
//
//        String title = data.get("title");
//        String contact = data.get("des");
//
//
//    }
//
//
//
//
//    private void sendNotificationAPI26(RemoteMessage remoteMessage) {
//        Map<String,String> data = remoteMessage.getData();
//
//        //cb2PcyO1I6Q:APA91bHSJOqgwgHKvPAg6pqztuu84l_3zpBhJ8UrxwaZHOZU-ukgdWTo-D0Pz7EvMStqJFh5NCaqBgF5rUCYshHX5qw3_k585rjT_CG3nBkIkF3Q7hyXUNWJd1atmilhyn_XB4s5WjAD
//        String title = data.get("title");
//        String contact = data.get("des");
//        Log.i("TAG title: ", title);
//        Log.i("TAG des" , contact);
//
//        Intent resultIntent = new Intent(getApplicationContext(), AboutUs.class);
//        resultIntent.putExtra("item_object", notificationModel);
//        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_3_ID)
//                .setColor(Color.BLUE)
//                .setContentTitle(title)
//                .setContentText(contact)
//                .setLargeIcon(bitmap1)
//                .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .build();
//
//        notificationManager.notify(1, notification);
//        //notificationListener.ready(1);
//    }















//    private void updateNotOpenNotificationNumber() {
//        //check if app in the front ground update the number of notifications
//
//        String num = getNumberOfItemInCartFromSP(getApplicationContext());
//        if (num != null && !num.isEmpty())
//        {
//         int x = Integer.parseInt(num);
//         int y = x+1;
//            saveNumberOfItemsInCartInSP(getApplicationContext(),String.valueOf(y));
//        }else{
//            saveNumberOfItemsInCartInSP(getApplicationContext(),"1");
//        }
//    }

//    private void insetNotificationToDB() {
//        String itemID = "null";
//        if (!channel_id.equals("important_message"))
//        { itemID = "empty"; }
//
//        notificationModel = new NotificationModel(
//                imageUrl,titleArray[0],titleArray[1],desArray[0].replace("\n", "")
//                ,desArray[1].replace("\n", ""),channel_id,itemID,getTimeStamp()
//                ,optionalArray[0].replace("\n", "")
//                ,optionalArray[1].replace("\n", ""),"0"
//        );
//
//        dbHelper.insertNotifications(imageUrl,titleArray[0],titleArray[1],desArray[0].replace("\n", "")
//                ,desArray[1].replace("\n", ""),channel_id,itemID,getTimeStamp()
//                ,optionalArray[0].replace("\n", "")
//                ,optionalArray[1].replace("\n", ""),"0");
//    }

    private class ConvertUrlToBitmap extends AsyncTask<String, Long, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            try {
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















    //1.url image first image
    //2. title (in case local langauge and the ads on eng i will take car_model + car_year + category)
    // in case in eng i will take the normal title

    //chanel 1
    //1.image_url
    //2.orgin title
    //3.orgin des
    //4.+ 5 title+des (car_model + car_year + category) athor language
    //ad_id , ad_cat

    //chanel 2
    //1.image_url
    //2.title_ar 3.title_en 4. des_ar 5. des_en 6.long_maessage_ar 7.long_message_en

}
