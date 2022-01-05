package com.cars.halamotor_obeidat.functions;

import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.BrowsingFilter;
import com.cars.halamotor_obeidat.model.PlatesChar;
import com.cars.halamotor_obeidat.model.WheelsType;

import java.util.ArrayList;

public class NewFunction {

    public static ArrayList<WheelsType> fillWheelsType(Context context)
    {
        ArrayList<WheelsType> wheelsTypesArrayList = new ArrayList<WheelsType>();

        wheelsTypesArrayList.add(new WheelsType(context.getResources().getString(R.string.kushuk),context.getResources().getString(R.string.kushuk_s)));
        wheelsTypesArrayList.add(new WheelsType(context.getResources().getString(R.string.metal),context.getResources().getString(R.string.metal_s)));

        return wheelsTypesArrayList;
    }

    public static String getTitle(String orginTitle,String newTitle,Context context){
        String title_str="";
        if (isEnglish(orginTitle) == true && getUserLanguage(context).equals("en"))
        {
            title_str = orginTitle;
        }else{
            if (isEnglish(orginTitle) == false && getUserLanguage(context).equals("ar"))
            {
                title_str = orginTitle;
            }else{
                title_str = newTitle;
            }
        }
        return title_str;
    }

    public static boolean isEnglish(String text){
        boolean onlyEnglish = false;

        for (char character : text.toCharArray()) {

            if (Character.UnicodeBlock.of(character) == Character.UnicodeBlock.BASIC_LATIN
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_1_SUPPLEMENT
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_EXTENDED_A
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.GENERAL_PUNCTUATION) {

                onlyEnglish = true;
            } else {

                onlyEnglish = false;
            }
        }

        return onlyEnglish;
    }

    public static ArrayList<PlatesChar> fillPlatesChar(Context context)
    {
        ArrayList<PlatesChar> platesCharArrayList = new ArrayList<PlatesChar>();

        platesCharArrayList.add(new PlatesChar("A",true));
        platesCharArrayList.add(new PlatesChar("B",false));
        platesCharArrayList.add(new PlatesChar("C",false));
        platesCharArrayList.add(new PlatesChar("D",false));
        platesCharArrayList.add(new PlatesChar("E",false));
        platesCharArrayList.add(new PlatesChar("F",false));
        platesCharArrayList.add(new PlatesChar("G",false));
        platesCharArrayList.add(new PlatesChar("H",false));
        platesCharArrayList.add(new PlatesChar("I",false));
        platesCharArrayList.add(new PlatesChar("J",false));
        platesCharArrayList.add(new PlatesChar("K",false));
        platesCharArrayList.add(new PlatesChar("L",false));
        platesCharArrayList.add(new PlatesChar("M",false));
        platesCharArrayList.add(new PlatesChar("O",false));
        platesCharArrayList.add(new PlatesChar("N",false));
        platesCharArrayList.add(new PlatesChar("P",false));
        platesCharArrayList.add(new PlatesChar("Q",false));
        platesCharArrayList.add(new PlatesChar("R",false));
        platesCharArrayList.add(new PlatesChar("S",false));
        platesCharArrayList.add(new PlatesChar("T",false));
        platesCharArrayList.add(new PlatesChar("U",false));
        platesCharArrayList.add(new PlatesChar("V",false));
        platesCharArrayList.add(new PlatesChar("W",false));
        platesCharArrayList.add(new PlatesChar("X",false));
        platesCharArrayList.add(new PlatesChar("Y",false));
        platesCharArrayList.add(new PlatesChar("Z",false));

        return platesCharArrayList;
    }

    public static String convertYearToEng(String yearStr){
        String year = yearStr;
        if (yearStr.equals("١٩٧٠"))
        {
            year = "1970";
        }
        if (yearStr.equals("١٩٧١"))
        {
            year = "1971";
        }
        if (yearStr.equals("١٩٧٢"))
        {
            year = "1972";
        }
        if (yearStr.equals("١٩٧٣"))
        {
            year = "1973";
        }
        if (yearStr.equals("١٩٧٤"))
        {
            year = "1974";
        }
        if (yearStr.equals("١٩٧٥"))
        {
            year = "1975";
        }
        if (yearStr.equals("١٩٧٦"))
        {
            year = "1976";
        }
        if (yearStr.equals("١٩٧٧"))
        {
            year = "1977";
        }
        if (yearStr.equals("١٩٧٨"))
        {
            year = "1978";
        }
        if (yearStr.equals("١٩٧٩"))
        {
            year = "1979";
        }
        if (yearStr.equals("١٩٨٠"))
        {
            year = "1980";
        }
        if (yearStr.equals("١٩٨١"))
        {
            year = "1981";
        }
        if (yearStr.equals("١٩٨٢"))
        {
            year = "1982";
        }
        if (yearStr.equals("١٩٨٣"))
        {
            year = "1983";
        }
        if (yearStr.equals("١٩٨٤"))
        {
            year = "1984";
        }
        if (yearStr.equals("١٩٨٥"))
        {
            year = "1985";
        }
        if (yearStr.equals("١٩٨٦"))
        {
            year = "1986";
        }
        if (yearStr.equals("١٩٨٧"))
        {
            year = "1987";
        }
        if (yearStr.equals("١٩٨٨"))
        {
            year = "1988";
        }
        if (yearStr.equals("١٩٨٩"))
        {
            year = "1989";
        }
        if (yearStr.equals("١٩٩٠"))
        {
            year = "1990";
        }
        if (yearStr.equals("١٩٩١"))
        {
            year = "1991";
        }
        if (yearStr.equals("١٩٩٢"))
        {
            year = "1992";
        }
        if (yearStr.equals("١٩٩٣"))
        {
            year = "1993";
        }
        if (yearStr.equals("١٩٩٤"))
        {
            year = "1994";
        }
        if (yearStr.equals("١٩٩٥"))
        {
            year = "1995";
        }
        if (yearStr.equals("١٩٩٦"))
        {
            year = "1996";
        }
        if (yearStr.equals("١٩٩٧"))
        {
            year = "1997";
        }
        if (yearStr.equals("١٩٩٨"))
        {
            year = "1998";
        }
        if (yearStr.equals("١٩٩٩"))
        {
            year = "1999";
        }
        if (yearStr.equals("٢٠٠٠"))
        {
            year = "2000";
        }
        if (yearStr.equals("٢٠٠١"))
        {
            year = "2001";
        }
        if (yearStr.equals("٢٠٠٢"))
        {
            year = "2002";
        }
        if (yearStr.equals("٢٠٠٣"))
        {
            year = "2003";
        }
        if (yearStr.equals("٢٠٠٤"))
        {
            year = "2004";
        }
        if (yearStr.equals("٢٠٠٥"))
        {
            year = "2005";
        }
        if (yearStr.equals("٢٠٠٦"))
        {
            year = "2006";
        }
        if (yearStr.equals("٢٠٠٧"))
        {
            year = "2007";
        }
        if (yearStr.equals("٢٠٠٨"))
        {
            year = "2008";
        }
        if (yearStr.equals("٢٠٠٩"))
        {
            year = "2009";
        }
        if (yearStr.equals("٢٠١٠"))
        {
            year = "2010";
        }
        if (yearStr.equals("٢٠١١"))
        {
            year = "2011";
        }
        if (yearStr.equals("٢٠١٢"))
        {
            year = "2012";
        }
        if (yearStr.equals("٢٠١٣"))
        {
            year = "2013";
        }
        if (yearStr.equals("٢٠١٤"))
        {
            year = "2014";
        }
        if (yearStr.equals("٢٠١٥"))
        {
            year = "2015";
        }
        if (yearStr.equals("٢٠١٦"))
        {
            year = "2016";
        }
        if (yearStr.equals("٢٠١٧"))
        {
            year = "2017";
        }
        if (yearStr.equals("٢٠١٨"))
        {
            year = "2018";
        }
        if (yearStr.equals("٢٠١٩"))
        {
            year = "2019";
        }
        if (yearStr.equals("٢٠٢٠"))
        {
            year = "2020";
        }
        if (yearStr.equals("٢٠٢١"))
        {
            year = "2021";
        }
        if (yearStr.equals("٢٠٢٢"))
        {
            year = "2022";
        }
        if (yearStr.equals("٢٠٢٣"))
        {
            year = "2023";
        }
        if (yearStr.equals("٢٠٢٤"))
        {
            year = "2024";
        }
        return year;
    }

    private static final int PAGE_SIZEH = 8;

    public static ArrayList<BrowsingFilter> fillBrowsingArrayL(Context context)
    {
        ArrayList<BrowsingFilter> browsingArrayL = new ArrayList<BrowsingFilter>();

//        BrowsingFilter browsingItemsAll = new BrowsingFilter("all", context.getResources().getString(R.string.all),true);
        BrowsingFilter browsingItemsCall = new BrowsingFilter("call", context.getResources().getString(R.string.call),false);
        BrowsingFilter browsingItemsFavorite = new BrowsingFilter("favorite", context.getResources().getString(R.string.favourite),false);
        BrowsingFilter browsingItemsMessage = new BrowsingFilter("message", context.getResources().getString(R.string.tab_message),false);
        BrowsingFilter browsingItemsSearch = new BrowsingFilter("search", context.getResources().getString(R.string.recent_searches),false);
        BrowsingFilter browsingItemsSeen = new BrowsingFilter("seen", context.getResources().getString(R.string.seen),false);

//        browsingArrayL.add(browsingItemsAll);
        browsingArrayL.add(browsingItemsCall);
        browsingArrayL.add(browsingItemsFavorite);
        browsingArrayL.add(browsingItemsMessage);
        browsingArrayL.add(browsingItemsSearch);
        browsingArrayL.add(browsingItemsSeen);


        return browsingArrayL;
    }

    public static int handelNumberOfObject(int x ,int y) {
        if (y ==0)
        {
            x =0;
        }else{
            if (y > PAGE_SIZEH)
            {
                if (x >= y)
                {
                    x=x;
//                    Log.i("TAG","x >= y");
                }else {
                    int d = y - x;
                    if (d >= PAGE_SIZEH)
                    {
//                        Log.i("TAG","x = x+10");
                        x = x+PAGE_SIZEH;
                    }else {
//                        Log.i("TAG","x = x+d");
                        x = x +d;
                    }
                }
            }else {
                x = y;
            }
        }
        return x;
    }

    public static int nowNumberOfObject(int x , int y) {
        int z =0;
        if (y ==0)
        {
            z =0;
        }else{
            if (y > PAGE_SIZEH)
            {
                if (x >= y)
                {
                    z =1000;
                }else {
                    int d = y - x;
                    if (d >= PAGE_SIZEH)
                    {
//                        Log.i("TAG","x = x+10");
                        z =PAGE_SIZEH;
                    }else {
//                        Log.i("TAG","x = x+d");
                        z =d;
                    }
                }
            }else {
                z =y;
            }
        }
        return z;
    }

    public static boolean getNumberOfObject(int x , int y) {
        Boolean isLastPage;
        if (y ==0)
        {
            isLastPage =true;
        }else{
            if (y > PAGE_SIZEH)
            {
                if (x >= y)
                {
                    isLastPage =true;
                }else {
                    int d = y - x;
                    if (d >= PAGE_SIZEH)
                    {
                        isLastPage =false;
                    }else {
                        isLastPage =true;
                    }
                }
            }else {
                isLastPage =true;
            }
        }
        return isLastPage;
    }

    public static String actionBarTitleInFCS(Context context,String FCSType){
        String fcsType="";
        if (FCSType.equals("favorite"))
        {
            fcsType = context.getResources().getString(R.string.favourite_ads);
        }

        if (FCSType.equals("call"))
        {
            fcsType = context.getResources().getString(R.string.call);
        }

        if (FCSType.equals("message"))
        {
            fcsType = context.getResources().getString(R.string.tab_message);
        }

        if (FCSType.equals("search"))
        {
            fcsType = context.getResources().getString(R.string.just_search);
        }

        if (FCSType.equals("seen"))
        {
            fcsType = context.getResources().getString(R.string.seen);
        }

        return fcsType;
    }

    @SuppressLint("MissingPermission")
    public static void callAds(Context context, String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(callIntent);
    }
}
