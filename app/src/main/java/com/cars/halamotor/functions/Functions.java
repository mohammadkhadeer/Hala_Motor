package com.cars.halamotor.functions;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.telephony.PhoneNumberUtils;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.model.BoostPost;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarColor;
import com.cars.halamotor.model.CarCondition;
import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CarFuel;
import com.cars.halamotor.model.CarInsurance;
import com.cars.halamotor.model.CarLicensed;
import com.cars.halamotor.model.CarModel;
import com.cars.halamotor.model.CarOption;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CommentsComp;
import com.cars.halamotor.model.ContactUsTitle;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.model.PaymentMethod;
import com.cars.halamotor.model.ReportType;
import com.cars.halamotor.sharedPreferences.SharedPreferencesInApp;
import com.cars.halamotor.utils.MySpannable;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getAddressInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getBurnedPriceInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getDesInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPhoneNumberInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPriceInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getTitleInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserImage;

public class Functions {

    public static void setLocale(Activity context) {
        Locale locale;
        //Log.e("Lan",session.getLanguage());
        locale = new Locale(getUserLanguage(context));
        Configuration config = new Configuration(context.getResources().getConfiguration());
        Locale.setDefault(locale);
        config.setLocale(locale);

        context.getBaseContext().getResources().updateConfiguration(config,
                context.getBaseContext().getResources().getDisplayMetrics());
    }

    public static void AddShineEffect(final RelativeLayout father, final ImageView child) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                    animationEffect(father,child);
                    AddShineEffect(father,child);
            }
        }, 3000);
    }

    public static void animationEffect(RelativeLayout father, ImageView child) {
        Animation animation = new TranslateAnimation(0,
                father.getWidth()+child.getWidth(),0, 0);
        animation.setDuration(950);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        child.startAnimation(animation);
    }

    public static boolean checkIfAndroidVBiggerThan9() {
        // we use this method cos OkHttpClient not allwed less than 9
        boolean value = false;
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            value = true;
        }else{
            value = false;
        }
        return value;
    }

    public static String replace(String category) {

        if (category.equals("Car for sale"))
        {
            category ="Car_For_Sale";
        }
        if (category.equals("Car for rent"))
        {
            category ="Car_For_Rent";
        }
        if (category.equals("Exchange car"))
        {
            category ="Car_For_Exchange";
        }
        if (category.equals("Motorcycle"))
        {
            category ="Motorcycle";
        }
        if (category.equals("Trucks"))
        {
            category ="Trucks";
        }
        if (category.equals("Car plates"))
        {
            category ="Plates";
        }
        if (category.equals("Wheels rim"))
        {
            category ="Wheels_Rim";
        }
        if (category.equals("Junk car"))
        {
            category ="JunkCar";
        }
        if (category.equals("Accessories"))
        {
            category ="Accessories";
        }

        return category;
    }

    public static void makeTextViewResizable(final TextView tv, final int maxLine
            , final String expandText, final boolean viewMore, final Context context) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                String text;
                int lineEndIndex;
                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    lineEndIndex = tv.getLayout().getLineEnd(0);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else {
                    lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                }
                tv.setText(text);
                //tv.setTextColor(context.getResources().getColor(R.color.colorSilver_));
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(
                        addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                viewMore,context), TextView.BufferType.SPANNABLE);
            }
        });
    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore, final Context context) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {
            ssb.setSpan(new MySpannable(false){
                @Override
                public void onClick(View widget) {
                    tv.setLayoutParams(tv.getLayoutParams());
                    tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    if (viewMore) {
                        makeTextViewResizable(tv, -1, context.getResources().getString(R.string.see_less), false,context);
                    } else {
                        makeTextViewResizable(tv, 4,  context.getResources().getString(R.string.see_more), true,context);
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;
    }

    public static String getCarPlatesNumber(String carNumber) {
        String newNumber ="";
        char[] chars = carNumber.toCharArray();
        int j = carNumber.length() -2;
        for (int i = 0; i < j; i++) {
            newNumber = newNumber + chars[i];
        }

        return newNumber;
    }

    public static NotificationComp getNotification(String process, String notificationTitle
            , Context context,String itemIdInServer,String outOrCome,String AuctionOrItem
            ,String itemImage)
    {
        NotificationComp notificationComp = new NotificationComp(
                process,"0",notificationTitle
                ,"person","if we want can set user image"
                ,itemImage,getTimeStamp(),outOrCome,itemIdInServer,AuctionOrItem,getDATE()
        );
        return notificationComp;
    }

    public static NotificationComp getNotificationObject(String process, String notificationTitle
            ,String itemIdInServer,String outOrCome,String AuctionOrItem
            ,String itemImage)
    {
        NotificationComp notificationComp = new NotificationComp(
                process,"0",notificationTitle
                ,"person","if we want can set user image"
                ,itemImage,getTimeStamp(),outOrCome,itemIdInServer,AuctionOrItem,getDATE()
        );
        return notificationComp;
    }

    public static int checkBurnedPrice(Context context) {
        if (getBurnedPriceInSP(context) != null)
            return 1;
        else
            return 0;
    }

    public static String getPostTime(String date,String timeStamp,Context context) {
        String timePost ="0";
        long serverTimeStamp = Long.parseLong(timeStamp);
        long def ;
        def = Math.abs(System.currentTimeMillis()-serverTimeStamp);
        timePost = getDurationBreakdown(def,context,date);

        return timePost;
    }

    public static String getDurationBreakdown(long millis,Context context,String date) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        String timePost ="0";

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(days);
        sb.append(" Days ");
        sb.append(hours);
        sb.append(" Hours ");
        sb.append(minutes);
        sb.append(" Minutes ");
        sb.append(seconds);
        sb.append(" Seconds");

        if (days > 31)
        {
            timePost =date;
        }else{
            if (days < 14 && 7 < days || days ==7)
            {
                timePost = "1" + context.getResources().getString(R.string.week);
            }else{
                if (days == 6)
                {
                    timePost = days + context.getResources().getString(R.string.days);
                }
                if (days == 5)
                {
                    timePost = days + context.getResources().getString(R.string.days);
                }
                if (days == 4)
                {
                    timePost = days + context.getResources().getString(R.string.days);
                }
                if (days == 3)
                {
                    timePost = days + context.getResources().getString(R.string.days);
                }
                if (days == 2)
                {
                    timePost = days + context.getResources().getString(R.string.days);
                }
                if (days == 0)
                {
                    if (hours < 23 && hours !=0)
                    {
                        timePost = hours + " " +
                                context.getResources().getString(R.string.hour);
                    }
                    if (hours ==0)
                    {
                        if (minutes <59 && minutes !=0)
                        {
                            timePost = minutes + " " +
                                    context.getResources().getString(R.string.min);
                        }
                    }
                }
            }
        }

        return timePost;
    }

    public static String getDAY() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);

        DATE_FORMAT = new SimpleDateFormat("dd");
        date = DATE_FORMAT.format(today);

        return date;
    }

    public static String getDATE() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);

        DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        date = DATE_FORMAT.format(today);

        return date;
    }

    public static String getMONTH() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);

        DATE_FORMAT = new SimpleDateFormat("MM");
        date = DATE_FORMAT.format(today);

        return date;
    }

    public static String getYEAR() {
        Date today = new Date();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);

        DATE_FORMAT = new SimpleDateFormat("yyyy");
        date = DATE_FORMAT.format(today);

        return date;
    }

    public static String[] splitString(String textStr,String signal) {
        final String[] stringAfterSplit = textStr.split(signal);;

        return stringAfterSplit;
    }

    public static String[] splitNotification(String textStr) {
        final String[] stringAfterSplit = textStr.split("#");
        return stringAfterSplit;
    }

    public static String[] splitString2(String textStr) {
        String[] items = textStr.split("|");
        String text=" ";
        for (String item : items)
        {
            if (!item.equals("|"))
            {
                text = text+item;
            }
            if (item.equals("|"))
            {
                text = " ";
            }
        }
        return items;
    }

    public static ArrayList<String> getCarOptionsArrayL(String options) {
        ArrayList<String> carOptionsArrayL = new ArrayList<String>();
        //this mithod split every single charchter
        String[] items = options.split("|");
        String text="  ";
        for (String item : items)
        {
            if (!item.equals("|"))
            {
                text = text+item;
            }
            if (item.equals("|"))
            {
                carOptionsArrayL.add(text);
                text = " ";
            }
        }

        return carOptionsArrayL;
    }

    public static ArrayList<BoostPost> getDefaultBoostPostArrayL() {
        ArrayList<BoostPost> boostPostArrayL = new ArrayList<BoostPost>();
        BoostPost boostPost = new BoostPost("boostType","postID");
        boostPostArrayL.add(boostPost);

        return boostPostArrayL;
    }

    public static ArrayList<CommentsComp> getDefaultCommentCompArrayL() {
        ArrayList<CommentsComp>  commentsCompsArrayL = new ArrayList<CommentsComp>();

        CommentsComp commentsComp = new CommentsComp("commentContentStr"
                    ,"narratorTokenStr","narratorImageStr"
                ,"commentTimeStampStr");

        commentsCompsArrayL.add(commentsComp);

        return commentsCompsArrayL;
    }

    public static boolean checkIfUserSetImages(ArrayList<String> imagePathsArrayL) {
        if (imagePathsArrayL.size() != 0)
            return true;
        else
        return false;
    }

    public static ArrayList<String> getImagePathsNoImage() {
        ArrayList<String> imagePathsArray;

            imagePathsArray = new ArrayList<String>();

            imagePathsArray.add("https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d");

        return imagePathsArray;
    }

    public static String getVideoPath(Uri videoPath) {
        String imagePath = null;
        if (videoPath != null)
            imagePath = "imagePathTest";
        else
            imagePath = "noVideo";
        return imagePath;
    }

    public static String getTime() {
        Date currentTime = Calendar.getInstance().getTime();
        String time = String.valueOf(currentTime);
        return time;
    }

    public static String getTimeStamp() {
        String ts = String.valueOf(System.currentTimeMillis());
        return ts;
    }

    public static Typeface changeFontAppName(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "Pacifico.ttf");
        return typeFace;
    }

    public static Typeface changeFontGeneral(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "NTAILU.TTF");
        return typeFace;
    }

    public static Typeface changeFontBold(Context context) {
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), "NTAILUB.TTF");
        return typeFace;
    }

    public static String checkPhoneNumberRealOrNot(Context context) {
        String caseStr = context.getResources().getString(R.string.fill);
        String phoneNumberStr = getPhoneNumberInSP(context);
        if ((phoneNumberStr != null) && (phoneNumberStr.length() != 10))
            caseStr = caseStr + " " + context.getResources().getString(R.string.fill_real_title);

        caseStr = caseStr + " " + context.getResources().getString(R.string.please);

        if (caseStr.equals(context.getResources().getString(R.string.fill) + " " + context.getResources().getString(R.string.please)))
            return null;
        else
            return caseStr;
    }

    public static String checkTitleAndDescriptionRealOrNot(Context context) {
        String caseStr = context.getResources().getString(R.string.fill);
        double price = Double.parseDouble(getPriceInSP(context));
        if (getTitleInSP(context).length() < 3)
            caseStr = caseStr + " " + context.getResources().getString(R.string.fill_real_title);
        if (getDesInSP(context).length() < 7)
            caseStr = caseStr + " " + context.getResources().getString(R.string.fill_real_des);
        if (price < 10 || price > 10000000)
            caseStr = caseStr + " " + context.getResources().getString(R.string.fill_real_price);

        caseStr = caseStr + " " + context.getResources().getString(R.string.please);

        if (caseStr.equals(context.getResources().getString(R.string.fill) + " " + context.getResources().getString(R.string.please)))
        return null;
        else
        return caseStr;
    }

    public static String checkTitleAndDescription(Context context) {
        String caseStr = null;
        if (getTitleInSP(context) == null || getDesInSP(context)==null || getPriceInSP(context)==null)
        {
            if (getTitleInSP(context) == null && getDesInSP(context)==null && getPriceInSP(context)==null)
            {
                caseStr = context.getResources().getString(R.string.fill_title_and_description_and_price);
            }else {
                if ((getTitleInSP(context) == null && getDesInSP(context) == null)
                        || (getTitleInSP(context) == null && getPriceInSP(context) == null)
                        || (getPriceInSP(context) == null && getDesInSP(context) == null)) {

                    if (getTitleInSP(context) == null && getDesInSP(context) == null)
                    {
                        caseStr = context.getResources().getString(R.string.fill_title_and_description);
                    }
                    if (getTitleInSP(context) == null && getPriceInSP(context) == null)
                    {
                        caseStr = context.getResources().getString(R.string.message_fill_title_and_price);
                    }
                    if (getPriceInSP(context) == null && getDesInSP(context) == null)
                    {
                        caseStr = context.getResources().getString(R.string.message_fill_des_and_price);
                    }
                } else {
                    if (getTitleInSP(context) == null) {
                        caseStr = context.getResources().getString(R.string.fill_title);
                    }
                    if (getDesInSP(context) == null) {
                        caseStr = context.getResources().getString(R.string.fill_description);
                    }
                    if (getPriceInSP(context) == null) {
                        caseStr = context.getResources().getString(R.string.fill_price);
                    }
                }
            }
        }
        return caseStr;
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean haveConnected = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnected = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnected = true;
        }
        return haveConnected;
    }

    public static String[] fillEmiratesEmirate(String[] emiratesEmirate, Context context) {
         final String[] EmiratesEmirate = {
                context.getResources().getString(R.string.abu_dhabi),
                context.getResources().getString(R.string.dubai),
                context.getResources().getString(R.string.sharjah),
                context.getResources().getString(R.string.al_ain),
                context.getResources().getString(R.string.ajman),
                context.getResources().getString(R.string.ras_al_khaimah),
                context.getResources().getString(R.string.um_al_quwain),
                context.getResources().getString(R.string.fujairah)
        };

        return EmiratesEmirate;
    }

    public static String[] fillTitleContactUs(Context context) {
        final String[] contactUsTitle = {
                context.getResources().getString(R.string.suggestion),
                context.getResources().getString(R.string.complaint),
                context.getResources().getString(R.string.issue),
                context.getResources().getString(R.string.other_sp),
        };

        return contactUsTitle;
    }

    public static String checkIfContactUsReadyToSend(String name,String email,String phoneNumber,String massage,Context context) {
        String result = "";
        if ((name.equals("")|| name.equals("empty")) || (email.equals("")|| email.equals("empty"))
                || phoneNumber.equals("") || massage.equals(""))
        {
            result = context.getResources().getString(R.string.message_contact_1);
        }else{
            result = "done";
        }
        return result;
    }

    public static ContactUsTitle getObjectContactUs(String text,Context context) {
        ContactUsTitle contactUsTitle = null;
        if (text.equals(context.getResources().getString(R.string.suggestion)))
        {
            contactUsTitle = new ContactUsTitle(context.getResources().getString(R.string.suggestion),context.getResources().getString(R.string.suggestion_s));
        }
        if (text.equals(context.getResources().getString(R.string.complaint)))
        {
            contactUsTitle = new ContactUsTitle(context.getResources().getString(R.string.complaint),context.getResources().getString(R.string.complaint_s));
        }
        if (text.equals(context.getResources().getString(R.string.issue)))
        {
            contactUsTitle = new ContactUsTitle(context.getResources().getString(R.string.issue),context.getResources().getString(R.string.issue_s));
        }
        if (text.equals(context.getResources().getString(R.string.other_sp)))
        {
            contactUsTitle = new ContactUsTitle(context.getResources().getString(R.string.other_sp),context.getResources().getString(R.string.other_sp_s));
        }

        return contactUsTitle;
    }


    public static ArrayList<String> fillWheelsInchesArrayL(ArrayList<String> wheelsRimArrayL, Context context) {
        wheelsRimArrayL = new ArrayList<String>();

        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_13));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_14));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_15));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_16));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_17));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_18));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_19));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_20));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_21));
        wheelsRimArrayL.add(context.getResources().getString(R.string.wheels_siz_other));

        return wheelsRimArrayL;
    }

    public static ArrayList<CategoryComp> fillCategoryArrayList(ArrayList<CategoryComp> categoryCompsArrayL,Context context) {
        categoryCompsArrayL = new ArrayList<CategoryComp>();

        CategoryComp carForSaleCCAL = new CategoryComp(R.drawable.car_for_sale,"1",context.getResources().getString(R.string.car_for_sale_s)
        ,context.getResources().getString(R.string.car_for_sale_name),context.getResources().getString(R.string.car_for_sale_name)
        ,context.getResources().getString(R.string.car_for_sale_ar));

        CategoryComp carForRentCCAL = new CategoryComp(R.drawable.car_rent,"2",context.getResources().getString(R.string.car_for_rent_s)
                ,context.getResources().getString(R.string.car_for_rent_name),context.getResources().getString(R.string.car_for_rent_name)
                ,context.getResources().getString(R.string.car_for_rent_ar));

        CategoryComp carForExchangeCCAL = new CategoryComp(R.drawable.exchange_car,"3",context.getResources().getString(R.string.exchange_car_s)
                ,context.getResources().getString(R.string.exchange_car_name),context.getResources().getString(R.string.exchange_car_name)
                ,context.getResources().getString(R.string.exchange_car_ar));

        CategoryComp motorcycleCCAL = new CategoryComp(R.drawable.motorcycle,"4",context.getResources().getString(R.string.motorcycle_s)
                ,context.getResources().getString(R.string.motorcycle_name),context.getResources().getString(R.string.motorcycle_name)
                ,context.getResources().getString(R.string.motorcycle_ar));

        CategoryComp carPlatesCCAL = new CategoryComp(R.drawable.vip,"5",context.getResources().getString(R.string.car_plates_s)
                ,context.getResources().getString(R.string.car_plates_name),context.getResources().getString(R.string.car_plates_name)
                ,context.getResources().getString(R.string.car_plates_ar));

        CategoryComp accessoriesCCAL = new CategoryComp(R.drawable.accessories,"6",context.getResources().getString(R.string.accessories_s)
                ,context.getResources().getString(R.string.accessories_name),context.getResources().getString(R.string.accessories_name)
                ,context.getResources().getString(R.string.accessories_ar));

        CategoryComp wheelsRimCCAL = new CategoryComp(R.drawable.wheels_rim,"7",context.getResources().getString(R.string.wheels_rim_s)
                ,context.getResources().getString(R.string.wheels_rim_name),context.getResources().getString(R.string.wheels_rim_name)
                ,context.getResources().getString(R.string.wheels_rim_ar));

        CategoryComp truckComp = new CategoryComp(R.drawable.trucks,"8",context.getResources().getString(R.string.trucks_s)
                ,context.getResources().getString(R.string.trucks_name),context.getResources().getString(R.string.trucks_name)
                ,context.getResources().getString(R.string.trucks_ar));

        CategoryComp junkCarComp = new CategoryComp(R.drawable.junk_car,"9",context.getResources().getString(R.string.junk_car_s)
                ,context.getResources().getString(R.string.junk_car_name),context.getResources().getString(R.string.junk_car_name)
                ,context.getResources().getString(R.string.junk_car_ar));


        categoryCompsArrayL.add(carForSaleCCAL);
        categoryCompsArrayL.add(carForRentCCAL);
        categoryCompsArrayL.add(carForExchangeCCAL);
        categoryCompsArrayL.add(motorcycleCCAL);
        categoryCompsArrayL.add(carPlatesCCAL);
        categoryCompsArrayL.add(accessoriesCCAL);
        categoryCompsArrayL.add(wheelsRimCCAL);
        categoryCompsArrayL.add(truckComp);
        categoryCompsArrayL.add(junkCarComp);

        return categoryCompsArrayL;
    }

    public static ArrayList<String> fillCarYearArrayList(ArrayList<String> carYearArrayL,Context context) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        carYearArrayL = new ArrayList<String>();

        for (int i=year;i>=1970;i--)
        {
            carYearArrayL.add(String.valueOf(i));
        }

        return carYearArrayL;
    }

    public static ArrayList<String> fillKilometersArrayL(ArrayList<String> carKilometersArrayL, Context context)   {
        carKilometersArrayL = new ArrayList<String>();

        carKilometersArrayL.add(context.getResources().getString(R.string.k_0_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_1K_10K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_20K_30K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_30K_40K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_40K_50K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_50K_60K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_60K_70K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_70K_80K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_80K_90K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_90K_100K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_100K_110K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_120K_130K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_130K_140K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_140K_150K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_150K_160K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_160K_170K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_170K_180K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_180K_190K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_190K_200K_s));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_up_200K_s));

        return carKilometersArrayL;
    }

    public static ArrayList<String> fillTransmissionArrayL(ArrayList<String> carTransmissionArrayL, Context context) {
        carTransmissionArrayL = new ArrayList<String>();

        carTransmissionArrayL.add(context.getResources().getString(R.string.automatic));
        carTransmissionArrayL.add(context.getResources().getString(R.string.manual));
        carTransmissionArrayL.add(context.getResources().getString(R.string.other));

        return carTransmissionArrayL;
    }

    public static ArrayList<CarFuel> fillFuelArrayL(ArrayList<CarFuel> carFuelArrayL, Context context) {
        carFuelArrayL = new ArrayList<CarFuel>();

//        carFuelArrayL.add(new CarFuel(context.getResources().getString(R.string.gasoline),context.getResources().getString(R.string.gasoline_s)));
//        carFuelArrayL.add(new CarFuel(context.getResources().getString(R.string.diesel),context.getResources().getString(R.string.diesel_s)));
//        carFuelArrayL.add(new CarFuel(context.getResources().getString(R.string.hybrid),context.getResources().getString(R.string.hybrid_s)));
//        carFuelArrayL.add(new CarFuel(context.getResources().getString(R.string.electric),context.getResources().getString(R.string.electric_s)));

        return carFuelArrayL;
    }

    public static ArrayList<CarInsurance> fillInsuranceArrayL(ArrayList<CarInsurance> fillInsuranceArrayL, Context context) {
        fillInsuranceArrayL = new ArrayList<CarInsurance>();

//        fillInsuranceArrayL.add(new CarInsurance(context.getResources().getString(R.string.insurance_compulsory),context.getResources().getString(R.string.insurance_compulsory_s)));
//        fillInsuranceArrayL.add(new CarInsurance(context.getResources().getString(R.string.insurance_comprehensive),context.getResources().getString(R.string.insurance_comprehensive_s)));
//        fillInsuranceArrayL.add(new CarInsurance(context.getResources().getString(R.string.insurance_not),context.getResources().getString(R.string.insurance_not_s)));

        return fillInsuranceArrayL;
    }

//    public static ArrayList<CarColor> fillColorArrayL(ArrayList<CarColor> fillColorArrayL, Context context) {
//        fillColorArrayL = new ArrayList<CarColor>();
//
//        CarColor carColor1 = new CarColor(context.getResources().getString(R.string.color_beige)
//                ,context.getResources().getColor(R.color.colorBeige));
//        CarColor carColor2 = new CarColor(context.getResources().getString(R.string.color_black)
//                ,context.getResources().getColor(R.color.colorBlack));
//        CarColor carColor3 = new CarColor(context.getResources().getString(R.string.color_blue)
//                ,context.getResources().getColor(R.color.colorBlue_));
//        CarColor carColor4 = new CarColor(context.getResources().getString(R.string.color_brown)
//                ,context.getResources().getColor(R.color.colorBrown));
//        CarColor carColor5 = new CarColor(context.getResources().getString(R.string.color_green)
//                ,context.getResources().getColor(R.color.colorGreen_));
//        CarColor carColor6 = new CarColor(context.getResources().getString(R.string.color_grey)
//                ,context.getResources().getColor(R.color.colorGrey));
//        CarColor carColor7 = new CarColor(context.getResources().getString(R.string.color_maroon)
//                ,context.getResources().getColor(R.color.colorMaroon));
//        CarColor carColor8 = new CarColor(context.getResources().getString(R.string.color_orange)
//                ,context.getResources().getColor(R.color.colorOrange));
//        CarColor carColor9 = new CarColor(context.getResources().getString(R.string.color_pink)
//                ,context.getResources().getColor(R.color.colorPink));
//        CarColor carColor10 = new CarColor(context.getResources().getString(R.string.color_purple)
//
//                ,context.getResources().getColor(R.color.colorPurple));
//        CarColor carColor11 = new CarColor(context.getResources().getString(R.string.color_red)
//                ,context.getResources().getColor(R.color.colorRed));
//        CarColor carColor12 = new CarColor(context.getResources().getString(R.string.color_silver)
//                ,context.getResources().getColor(R.color.colorSilver_));
//        CarColor carColor13 = new CarColor(context.getResources().getString(R.string.color_turquoise)
//                ,context.getResources().getColor(R.color.colorTurquoise));
//        CarColor carColor14 = new CarColor(context.getResources().getString(R.string.color_white)
//                ,context.getResources().getColor(R.color.colorWhite));
//        CarColor carColor15 = new CarColor(context.getResources().getString(R.string.color_yellow)
//                ,context.getResources().getColor(R.color.colorYellow));
//        CarColor carColor16 = new CarColor(context.getResources().getString(R.string.color_gold)
//                ,context.getResources().getColor(R.color.colorGold));
//
//        fillColorArrayL.add(carColor1);
//        fillColorArrayL.add(carColor2);
//        fillColorArrayL.add(carColor3);
//        fillColorArrayL.add(carColor4);
//        fillColorArrayL.add(carColor5);
//        fillColorArrayL.add(carColor6);
//        fillColorArrayL.add(carColor7);
//        fillColorArrayL.add(carColor8);
//        fillColorArrayL.add(carColor9);
//        fillColorArrayL.add(carColor10);
//        fillColorArrayL.add(carColor11);
//        fillColorArrayL.add(carColor12);
//        fillColorArrayL.add(carColor13);
//        fillColorArrayL.add(carColor14);
//        fillColorArrayL.add(carColor15);
//        fillColorArrayL.add(carColor16);
//
//        return fillColorArrayL;
//    }

    public static int fillColorCode(String colorName, Context context) {
        int color = 0;
        if (colorName.equals("beige"))
        { color = context.getResources().getColor(R.color.colorBeige); }
        if (colorName.equals("black"))
        { color = context.getResources().getColor(R.color.colorBlack); }
        if (colorName.equals("blue"))
        { color = context.getResources().getColor(R.color.colorBlue_); }
        if (colorName.equals("brown"))
        { color = context.getResources().getColor(R.color.colorBrown); }
        if (colorName.equals("green"))
        { color = context.getResources().getColor(R.color.colorGreen_); }
        if (colorName.equals("grey"))
        { color = context.getResources().getColor(R.color.colorGrey); }
        if (colorName.equals("maroon"))
        { color = context.getResources().getColor(R.color.colorMaroon); }
        if (colorName.equals("orange"))
        { color = context.getResources().getColor(R.color.colorOrange); }
        if (colorName.equals("pink"))
        { color = context.getResources().getColor(R.color.colorPink); }
        if (colorName.equals("purple"))
        { color = context.getResources().getColor(R.color.colorPurple); }
        if (colorName.equals("red"))
        { color = context.getResources().getColor(R.color.colorRed); }
        if (colorName.equals("silver"))
        { color = context.getResources().getColor(R.color.colorSilver_); }
        if (colorName.equals("turquoise"))
        { color = context.getResources().getColor(R.color.colorTurquoise); }
        if (colorName.equals("white"))
        { color = context.getResources().getColor(R.color.colorWhite); }
        if (colorName.equals("yello"))
        { color = context.getResources().getColor(R.color.colorYellow); }
        if (colorName.equals("gold"))
        { color = context.getResources().getColor(R.color.colorGold); }

        return color;
    }

//    public static ArrayList<CarOption> fillOptionsArrayL(ArrayList<CarOption> carOptionsArrayL, Context context) {
//        carOptionsArrayL = new ArrayList<CarOption>();
//
//        CarOption carOption1 = new CarOption(context.getResources().getString(R.string.option_1),0);
//        CarOption carOption2 = new CarOption(context.getResources().getString(R.string.option_2),0);
//        CarOption carOption3 = new CarOption(context.getResources().getString(R.string.option_3),0);
//        CarOption carOption4 = new CarOption(context.getResources().getString(R.string.option_4),0);
//        CarOption carOption5 = new CarOption(context.getResources().getString(R.string.option_5),0);
//        CarOption carOption6 = new CarOption(context.getResources().getString(R.string.option_6),0);
//        CarOption carOption7 = new CarOption(context.getResources().getString(R.string.option_7),0);
//        CarOption carOption8 = new CarOption(context.getResources().getString(R.string.option_8),0);
//        CarOption carOption9 = new CarOption(context.getResources().getString(R.string.option_9),0);
//        CarOption carOption10 = new CarOption(context.getResources().getString(R.string.option_10),0);
//        CarOption carOption11 = new CarOption(context.getResources().getString(R.string.option_11),0);
//        CarOption carOption12 = new CarOption(context.getResources().getString(R.string.option_12),0);
//        CarOption carOption13 = new CarOption(context.getResources().getString(R.string.option_13),0);
//        CarOption carOption14 = new CarOption(context.getResources().getString(R.string.option_14),0);
//        CarOption carOption15 = new CarOption(context.getResources().getString(R.string.option_15),0);
//        CarOption carOption16 = new CarOption(context.getResources().getString(R.string.option_16),0);
//        CarOption carOption17 = new CarOption(context.getResources().getString(R.string.option_17),0);
//        CarOption carOption18 = new CarOption(context.getResources().getString(R.string.option_18),0);
//
//        carOptionsArrayL.add(carOption1);
//        carOptionsArrayL.add(carOption2);
//        carOptionsArrayL.add(carOption3);
//        carOptionsArrayL.add(carOption4);
//        carOptionsArrayL.add(carOption5);
//        carOptionsArrayL.add(carOption6);
//        carOptionsArrayL.add(carOption7);
//        carOptionsArrayL.add(carOption8);
//        carOptionsArrayL.add(carOption9);
//        carOptionsArrayL.add(carOption10);
//        carOptionsArrayL.add(carOption11);
//        carOptionsArrayL.add(carOption12);
//        carOptionsArrayL.add(carOption13);
//        carOptionsArrayL.add(carOption14);
//        carOptionsArrayL.add(carOption15);
//        carOptionsArrayL.add(carOption16);
//        carOptionsArrayL.add(carOption17);
//        carOptionsArrayL.add(carOption18);
//
//
//        return carOptionsArrayL;
//    }

    public static ArrayList<CarLicensed> fillLicensedArrayL(ArrayList<CarLicensed> carLicensedArrayL, Context context) {
        carLicensedArrayL = new ArrayList<CarLicensed>();

//        carLicensedArrayL.add(new CarLicensed(context.getResources().getString(R.string.licensed),context.getResources().getString(R.string.licensed_s)));
//        carLicensedArrayL.add(new CarLicensed(context.getResources().getString(R.string.no_licensed),context.getResources().getString(R.string.no_licensed_s)));


        return carLicensedArrayL;
    }

    public static ArrayList<PaymentMethod> fillPaymentArrayL(ArrayList<PaymentMethod> carPaymentArrayL, Context context) {
        carPaymentArrayL = new ArrayList<PaymentMethod>();

//        carPaymentArrayL.add(new PaymentMethod(context.getResources().getString(R.string.payment_method_1),context.getResources().getString(R.string.payment_method_1_s)));
//        carPaymentArrayL.add(new PaymentMethod(context.getResources().getString(R.string.payment_method_2),context.getResources().getString(R.string.payment_method_2_s)));
//        carPaymentArrayL.add(new PaymentMethod(context.getResources().getString(R.string.payment_method_3),context.getResources().getString(R.string.payment_method_3_s)));
//

        return carPaymentArrayL;
    }

    public static ArrayList<String> fillOptionArrayL(ArrayList<String> carOptionsArrayL, String optionsListStr) {
        carOptionsArrayL = new ArrayList<String>();

        String[] arr = optionsListStr.split("[|]+");
        for(int i = 0; i < arr.length-1; i += 1)
        {
            carOptionsArrayL.add(arr[i]);
        }
        return carOptionsArrayL;
    }

    public static String check(int size, Context context) {
        String city = "";
        if (size == 124)
        {
            city = context.getResources().getString(R.string.dubai);
        }
        if (size == 89)
        {
            city = context.getResources().getString(R.string.abu_dhabi);
        }
        if (size == 68)
        {
            city = context.getResources().getString(R.string.sharjah);
        }
        if (size == 21)
        {
            city = context.getResources().getString(R.string.al_ain);
        }
        if (size == 33)
        {
            city = context.getResources().getString(R.string.ajman);
        }
        if (size == 24)
        {
            city = context.getResources().getString(R.string.ras_al_khaimah);
        }
        if (size == 20)
        {
            city = context.getResources().getString(R.string.um_al_quwain);
        }
        if (size == 11)
        {
            city = context.getResources().getString(R.string.fujairah);
        }
        return city;
    }

    public static String cityS(String city, Context context) {
        String cityS = "empty";
        if (city.equals(context.getResources().getString(R.string.dubai)))
        {
            cityS = context.getResources().getString(R.string.dubai_s);
        }
        if (city.equals(context.getResources().getString(R.string.abu_dhabi)))
        {
            cityS = context.getResources().getString(R.string.abu_dhabi_s);
        }
        if (city.equals(context.getResources().getString(R.string.sharjah)))
        {
            cityS = context.getResources().getString(R.string.sharjah_s);
        }
        if (city.equals(context.getResources().getString(R.string.al_ain)))
        {
            cityS = context.getResources().getString(R.string.al_ain_s);
        }
        if (city.equals(context.getResources().getString(R.string.ajman)))
        {
            cityS = context.getResources().getString(R.string.ajman_s);
        }
        if (city.equals(context.getResources().getString(R.string.ras_al_khaimah)))
        {
            cityS = context.getResources().getString(R.string.ras_al_khaimah_s);
        }
        if (city.equals(context.getResources().getString(R.string.um_al_quwain)))
        {
            cityS = context.getResources().getString(R.string.um_al_quwain_s);
        }
        if (city.equals(context.getResources().getString(R.string.fujairah)))
        {
            cityS = context.getResources().getString(R.string.fujairah_s);
        }
        return cityS;
    }

    public static String convertFromCityToCityS(String city, Context context) {
        String cityS = "empty",abu_dhabi,dubai,sharjah,al_ain,ajman,ras_al_khaimah
                ,um_al_quwain,fujairah;
        dubai = context.getResources().getString(R.string.dubai);
        abu_dhabi = context.getResources().getString(R.string.abu_dhabi);
        sharjah = context.getResources().getString(R.string.sharjah);
        al_ain = context.getResources().getString(R.string.al_ain);
        ajman = context.getResources().getString(R.string.ajman);
        ras_al_khaimah = context.getResources().getString(R.string.ajman);
        um_al_quwain = context.getResources().getString(R.string.um_al_quwain);
        fujairah = context.getResources().getString(R.string.fujairah);

        if (city.equals(dubai))
        {
            cityS = context.getResources().getString(R.string.dubai_s);
        }
        if (city.equals(abu_dhabi))
        {
            cityS = context.getResources().getString(R.string.abu_dhabi_s);
        }
        if (city.equals(sharjah))
        {
            cityS = context.getResources().getString(R.string.sharjah_s);
        }
        if (city.equals(al_ain))
        {
            cityS = context.getResources().getString(R.string.al_ain_s);
        }
        if (city.equals(ajman))
        {
            cityS = context.getResources().getString(R.string.ajman_s);
        }
        if (city.equals(ras_al_khaimah))
        {
            cityS = context.getResources().getString(R.string.ras_al_khaimah_s);
        }
        if (city.equals(um_al_quwain))
        {
            cityS = context.getResources().getString(R.string.um_al_quwain_s);
        }
        if (city.equals(fujairah))
        {
            cityS = context.getResources().getString(R.string.fujairah_s);
        }
        return cityS;
    }

    public static String convertCategoryToCategoryS(String category, Context context) {
        String categoryS="empty";

        if (category.equals( context.getResources().getString(R.string.car_for_sale)))
        {
            categoryS = "Car for sale";
        }

        if (category.equals( context.getResources().getString(R.string.car_for_rent)))
        {
            categoryS = "Car for rent";
        }

        if (category.equals( context.getResources().getString(R.string.exchange_car)))
        {
            categoryS = "Exchange car";
        }

        if (category.equals( context.getResources().getString(R.string.motorcycle)))
        {
            categoryS = "Motorcycle";
        }

        if (category.equals( context.getResources().getString(R.string.trucks)))
        {
            categoryS = "Trucks";
        }

        if (category.equals( context.getResources().getString(R.string.car_plates))||category.equals( context.getResources().getString(R.string.car_plates2)))
        {
            categoryS = "Plates";
        }

        if (category.equals( context.getResources().getString(R.string.wheels_rim)) || category.equals( context.getResources().getString(R.string.wheels_rim2)))
        {
            categoryS = "Wheels_Rim";
        }

        if (category.equals( context.getResources().getString(R.string.accessories)))
        {
            categoryS = "Accessories";
        }

        if (category.equals( context.getResources().getString(R.string.junk_car)))
        {
            categoryS = "Junk car";
        }

        return categoryS;
    }

    public static boolean whatsAppInstalledOrNot(String uri,Context context) {
        PackageManager pm = context.getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public static void openWhatsApp(String phoneNumber,Context context) {
        String smsNumber = "971"+phoneNumber.substring(1);
        if (whatsAppInstalledOrNot("com.whatsapp",context)) {

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix

            context.startActivity(sendIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            Toast.makeText(context, "WhatsApp not Installed",
                    Toast.LENGTH_SHORT).show();
            context.startActivity(goToMarket);
        }
    }

    public static ArrayList<ReportType> fillFuelArrayL(Context context) {
        ArrayList<ReportType> reportTypesArrayL = new ArrayList<ReportType>();

        reportTypesArrayL.add(new ReportType(context.getResources().getString(R.string.ad_sold),context.getResources().getString(R.string.ad_sold_s),R.drawable.sold));
        reportTypesArrayL.add(new ReportType(context.getResources().getString(R.string.duplicate_ad),context.getResources().getString(R.string.duplicate_ad_s),R.drawable.duplicat));
        reportTypesArrayL.add(new ReportType(context.getResources().getString(R.string.inappropriate_ad),context.getResources().getString(R.string.inappropriate_ad_s),R.drawable.inappropriate));
        reportTypesArrayL.add(new ReportType(context.getResources().getString(R.string.wrong_category),context.getResources().getString(R.string.wrong_category_s),R.drawable.wrong_category));
        reportTypesArrayL.add(new ReportType(context.getResources().getString(R.string.other_rep),context.getResources().getString(R.string.other_rep_s),R.drawable.junk_car));

        return reportTypesArrayL;
    }

}
