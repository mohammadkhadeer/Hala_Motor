package com.cars.halamotor_obeidat.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.view.activity.AboutUs;
import com.cars.halamotor_obeidat.view.activity.MainActivity;
import com.cars.halamotor_obeidat.view.activity.ShowItemDetails;

import java.net.URL;

public class NotificationHelper extends ContextWrapper {
    Bitmap bitmap1;
    ConvertUrlToBitmap convertUrlToBitmap;
    private static final String EDMT_CHANNEL_ID="com.cars.halamotor_obeidat.utils";
    private static final String EDMT_CHANNEL_NAME="EDMTDEV Channel";
    private NotificationManager manager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  NotificationHelper(Context base)
    {
        super(base);
        createChannels();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels()
    {
        NotificationChannel edmtChannel=new NotificationChannel(EDMT_CHANNEL_ID,EDMT_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        edmtChannel.enableLights(true);
        edmtChannel.enableVibration(true);
        edmtChannel.setLightColor(Color.GREEN);
        edmtChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(edmtChannel);

    }
    public NotificationManager getManager()
    {
        if (manager==null)
            manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;

    }
    public NotificationCompat.Builder getEDMTChannelNotification(String title, String body
            , CategoryComp categoryComp,String ad_id,String ad_image)
    {
        convertUrlToBitmap = new ConvertUrlToBitmap();
        convertUrlToBitmap.doInBackground(ad_image);
        convertUrlToBitmap.execute();

        Intent resultIntent = new Intent(getApplicationContext(), ShowItemDetails.class);
        resultIntent.putExtra("category",categoryComp.getCode());
        resultIntent.putExtra("category_comp",categoryComp);
        resultIntent.putExtra("from","ml");
        resultIntent.putExtra("itemID",ad_id);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        return new NotificationCompat.Builder(getApplicationContext(),EDMT_CHANNEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.logo)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setLargeIcon(bitmap1)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
    }

    private class ConvertUrlToBitmap extends AsyncTask<String, Long, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                Log.i("TAG","ConvertUrlToBitmap: "+"on");

                URL url = new URL(params[0]);
                bitmap1 = BitmapFactory.decodeStream(url.openConnection().getInputStream());



                return true;
            } catch (Exception e) {
                Log.e("TAG", e.toString());
                return false;
            }
        }
    }

//    Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_3_ID)
//            .setColor(Color.BLUE)
//            .setContentTitle(title)
//            .setContentText(content)
//            .setLargeIcon(bitmap1)
//            .setSmallIcon(com.cars.halamotor_obeidat.R.mipmap.ic_launcher)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setAutoCancel(true)
//            .setContentIntent(pendingIntent)
//            .build();

}
