package com.cars.halamotor.functions;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.model.BoostPost;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarColor;
import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CarOption;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CommentsComp;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.sharedPreferences.SharedPreferencesInApp;
import com.cars.halamotor.utils.MySpannable;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getAddressInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getBurnedPriceInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getDesInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPhoneNumberInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPriceInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getTitleInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserImage;

public class Functions {

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

    @RequiresApi(api = Build.VERSION_CODES.O)
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


    public static CarDetailsModel updateCarDetailsModel(CarDetailsModel carDetailsModel
            , String whatUserWantToChange
            , String valueInWhatUserWantToChange) {

        if (whatUserWantToChange.equals("model"))
        {
            carDetailsModel.setModelStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("year"))
        {
            carDetailsModel.setYearStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("condition"))
        {
            carDetailsModel.setConditionStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("kilometers"))
        {
            carDetailsModel.setKilometersStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("transmission"))
        {
            carDetailsModel.setTransmissionStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("fuel"))
        {
            carDetailsModel.setFuelStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("options"))
        {
            carDetailsModel.setCarOptionsStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("licensed"))
        {
            carDetailsModel.setLicenseStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("insurance"))
        {
            carDetailsModel.setInsurance(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("color"))
        {
            carDetailsModel.setCarColorStr(valueInWhatUserWantToChange);
        }
        if (whatUserWantToChange.equals("payment"))
        {
            carDetailsModel.setPaymentMethod(valueInWhatUserWantToChange);
        }

        return carDetailsModel;
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
        def = Math.abs(serverTimeStamp-System.currentTimeMillis());
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

    public static String[] splitString2(String textStr,String signal) {
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
        CategoryComp carForSaleCCAL = new CategoryComp(R.drawable.car_for_sale,context.getResources().getString(R.string.car_for_sale));
        CategoryComp carForRentCCAL = new CategoryComp(R.drawable.car_rent,context.getResources().getString(R.string.car_for_rent));
        CategoryComp carForExchangeCCAL = new CategoryComp(R.drawable.exchange_car,context.getResources().getString(R.string.exchange_car));
        CategoryComp motorcycleCCAL = new CategoryComp(R.drawable.motorcycle,context.getResources().getString(R.string.motorcycle));
        CategoryComp carPlatesCCAL = new CategoryComp(R.drawable.vip,context.getResources().getString(R.string.car_plates));
        CategoryComp accessoriesCCAL = new CategoryComp(R.drawable.accessories,context.getResources().getString(R.string.accessories));
        CategoryComp wheelsRimCCAL = new CategoryComp(R.drawable.wheels_rim,context.getResources().getString(R.string.wheels_rim));
        CategoryComp truckComp = new CategoryComp(R.drawable.trucks,context.getResources().getString(R.string.trucks));
        CategoryComp junkCarComp = new CategoryComp(R.drawable.junk_car,context.getResources().getString(R.string.junk_car));
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

        carKilometersArrayL.add(context.getResources().getString(R.string.k_0));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_1K_10K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_20K_30K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_30K_40K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_40K_50K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_50K_60K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_60K_70K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_70K_80K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_80K_90K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_90K_100K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_100K_110K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_120K_130K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_130K_140K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_140K_150K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_150K_160K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_160K_170K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_170K_180K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_180K_190K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_190K_200K));
        carKilometersArrayL.add(context.getResources().getString(R.string.k_up_200K));

        return carKilometersArrayL;
    }

    public static ArrayList<String> fillTransmissionArrayL(ArrayList<String> carTransmissionArrayL, Context context) {
        carTransmissionArrayL = new ArrayList<String>();

        carTransmissionArrayL.add(context.getResources().getString(R.string.automatic));
        carTransmissionArrayL.add(context.getResources().getString(R.string.manual));
        carTransmissionArrayL.add(context.getResources().getString(R.string.other));

        return carTransmissionArrayL;
    }

    public static ArrayList<String> fillFuelArrayL(ArrayList<String> carFuelArrayL, Context context) {
        carFuelArrayL = new ArrayList<String>();

        carFuelArrayL.add(context.getResources().getString(R.string.gasoline));
        carFuelArrayL.add(context.getResources().getString(R.string.diesel));
        carFuelArrayL.add(context.getResources().getString(R.string.hybrid));
        carFuelArrayL.add(context.getResources().getString(R.string.electric));

        return carFuelArrayL;
    }

    public static ArrayList<String> fillInsuranceArrayL(ArrayList<String> fillInsuranceArrayL, Context context) {
        fillInsuranceArrayL = new ArrayList<String>();

        fillInsuranceArrayL.add(context.getResources().getString(R.string.insurance_compulsory));
        fillInsuranceArrayL.add(context.getResources().getString(R.string.insurance_comprehensive));
        fillInsuranceArrayL.add(context.getResources().getString(R.string.insurance_not));

        return fillInsuranceArrayL;
    }

    public static ArrayList<CarColor> fillColorArrayL(ArrayList<CarColor> fillColorArrayL, Context context) {
        fillColorArrayL = new ArrayList<CarColor>();

        CarColor carColor1 = new CarColor(context.getResources().getString(R.string.color_beige)
                ,context.getResources().getColor(R.color.colorBeige));
        CarColor carColor2 = new CarColor(context.getResources().getString(R.string.color_black)
                ,context.getResources().getColor(R.color.colorBlack));
        CarColor carColor3 = new CarColor(context.getResources().getString(R.string.color_blue)
                ,context.getResources().getColor(R.color.colorBlue_));
        CarColor carColor4 = new CarColor(context.getResources().getString(R.string.color_brown)
                ,context.getResources().getColor(R.color.colorBrown));
        CarColor carColor5 = new CarColor(context.getResources().getString(R.string.color_green)
                ,context.getResources().getColor(R.color.colorGreen_));
        CarColor carColor6 = new CarColor(context.getResources().getString(R.string.color_grey)
                ,context.getResources().getColor(R.color.colorGrey));
        CarColor carColor7 = new CarColor(context.getResources().getString(R.string.color_maroon)
                ,context.getResources().getColor(R.color.colorMaroon));
        CarColor carColor8 = new CarColor(context.getResources().getString(R.string.color_orange)
                ,context.getResources().getColor(R.color.colorOrange));
        CarColor carColor9 = new CarColor(context.getResources().getString(R.string.color_pink)
                ,context.getResources().getColor(R.color.colorPink));
        CarColor carColor10 = new CarColor(context.getResources().getString(R.string.color_purple)

                ,context.getResources().getColor(R.color.colorPurple));
        CarColor carColor11 = new CarColor(context.getResources().getString(R.string.color_red)
                ,context.getResources().getColor(R.color.colorRed));
        CarColor carColor12 = new CarColor(context.getResources().getString(R.string.color_silver)
                ,context.getResources().getColor(R.color.colorSilver_));
        CarColor carColor13 = new CarColor(context.getResources().getString(R.string.color_turquoise)
                ,context.getResources().getColor(R.color.colorTurquoise));
        CarColor carColor14 = new CarColor(context.getResources().getString(R.string.color_white)
                ,context.getResources().getColor(R.color.colorWhite));
        CarColor carColor15 = new CarColor(context.getResources().getString(R.string.color_yellow)
                ,context.getResources().getColor(R.color.colorYellow));
        CarColor carColor16 = new CarColor(context.getResources().getString(R.string.color_gold)
                ,context.getResources().getColor(R.color.colorGold));

        fillColorArrayL.add(carColor1);
        fillColorArrayL.add(carColor2);
        fillColorArrayL.add(carColor3);
        fillColorArrayL.add(carColor4);
        fillColorArrayL.add(carColor5);
        fillColorArrayL.add(carColor6);
        fillColorArrayL.add(carColor7);
        fillColorArrayL.add(carColor8);
        fillColorArrayL.add(carColor9);
        fillColorArrayL.add(carColor10);
        fillColorArrayL.add(carColor11);
        fillColorArrayL.add(carColor12);
        fillColorArrayL.add(carColor13);
        fillColorArrayL.add(carColor14);
        fillColorArrayL.add(carColor15);
        fillColorArrayL.add(carColor16);

        return fillColorArrayL;
    }

    public static ArrayList<CarOption> fillOptionsArrayL(ArrayList<CarOption> carOptionsArrayL, Context context) {
        carOptionsArrayL = new ArrayList<CarOption>();

        CarOption carOption1 = new CarOption(context.getResources().getString(R.string.option_1),0);
        CarOption carOption2 = new CarOption(context.getResources().getString(R.string.option_2),0);
        CarOption carOption3 = new CarOption(context.getResources().getString(R.string.option_3),0);
        CarOption carOption4 = new CarOption(context.getResources().getString(R.string.option_4),0);
        CarOption carOption5 = new CarOption(context.getResources().getString(R.string.option_5),0);
        CarOption carOption6 = new CarOption(context.getResources().getString(R.string.option_6),0);
        CarOption carOption7 = new CarOption(context.getResources().getString(R.string.option_7),0);
        CarOption carOption8 = new CarOption(context.getResources().getString(R.string.option_8),0);
        CarOption carOption9 = new CarOption(context.getResources().getString(R.string.option_9),0);
        CarOption carOption10 = new CarOption(context.getResources().getString(R.string.option_10),0);
        CarOption carOption11 = new CarOption(context.getResources().getString(R.string.option_11),0);
        CarOption carOption12 = new CarOption(context.getResources().getString(R.string.option_12),0);
        CarOption carOption13 = new CarOption(context.getResources().getString(R.string.option_13),0);
        CarOption carOption14 = new CarOption(context.getResources().getString(R.string.option_14),0);
        CarOption carOption15 = new CarOption(context.getResources().getString(R.string.option_15),0);
        CarOption carOption16 = new CarOption(context.getResources().getString(R.string.option_16),0);
        CarOption carOption17 = new CarOption(context.getResources().getString(R.string.option_17),0);
        CarOption carOption18 = new CarOption(context.getResources().getString(R.string.option_18),0);

        carOptionsArrayL.add(carOption1);
        carOptionsArrayL.add(carOption2);
        carOptionsArrayL.add(carOption3);
        carOptionsArrayL.add(carOption4);
        carOptionsArrayL.add(carOption5);
        carOptionsArrayL.add(carOption6);
        carOptionsArrayL.add(carOption7);
        carOptionsArrayL.add(carOption8);
        carOptionsArrayL.add(carOption9);
        carOptionsArrayL.add(carOption10);
        carOptionsArrayL.add(carOption11);
        carOptionsArrayL.add(carOption12);
        carOptionsArrayL.add(carOption13);
        carOptionsArrayL.add(carOption14);
        carOptionsArrayL.add(carOption15);
        carOptionsArrayL.add(carOption16);
        carOptionsArrayL.add(carOption17);
        carOptionsArrayL.add(carOption18);


        return carOptionsArrayL;
    }

    public static ArrayList<String> fillLicensedArrayL(ArrayList<String> carLicensedArrayL, Context context) {
        carLicensedArrayL = new ArrayList<String>();

        carLicensedArrayL.add(context.getResources().getString(R.string.licensed));
        carLicensedArrayL.add(context.getResources().getString(R.string.no_licensed));


        return carLicensedArrayL;
    }

    public static ArrayList<String> fillPaymentArrayL(ArrayList<String> carPaymentArrayL, Context context) {
        carPaymentArrayL = new ArrayList<String>();

        carPaymentArrayL.add(context.getResources().getString(R.string.payment_method_1));
        carPaymentArrayL.add(context.getResources().getString(R.string.payment_method_2));
        carPaymentArrayL.add(context.getResources().getString(R.string.payment_method_3));


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
        if (size == 125)
        {
            city = context.getResources().getString(R.string.dubai);
        }
        if (size == 90)
        {
            city = context.getResources().getString(R.string.abu_dhabi);
        }
        if (size == 69)
        {
            city = context.getResources().getString(R.string.sharjah);
        }
        if (size == 23)
        {
            city = context.getResources().getString(R.string.al_ain);
        }
        if (size == 34)
        {
            city = context.getResources().getString(R.string.ajman);
        }
        if (size == 25)
        {
            city = context.getResources().getString(R.string.ras_al_khaimah);
        }
        if (size == 21)
        {
            city = context.getResources().getString(R.string.um_al_quwain);
        }
        if (size == 12)
        {
            city = context.getResources().getString(R.string.fujairah);
        }
        return city;
    }
}
