package com.cars.halamotor_obeidat.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cars.halamotor_obeidat.model.AccAndJunkFirstCase;
import com.cars.halamotor_obeidat.model.BrowsingFilter;
import com.cars.halamotor_obeidat.model.CCEMTFirestCase;
import com.cars.halamotor_obeidat.model.CarInformation;
import com.cars.halamotor_obeidat.model.CarPlatesFirstCase;
import com.cars.halamotor_obeidat.model.CarProcess;
import com.cars.halamotor_obeidat.model.DriverInformation;
import com.cars.halamotor_obeidat.model.DriverProcess;
import com.cars.halamotor_obeidat.model.FavouriteCallSearch;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.model.NotificationComp;
import com.cars.halamotor_obeidat.model.ProcessContent;
import com.cars.halamotor_obeidat.model.SimilarItem;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.WheelsRimFirstCase;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class ReadFunction {

    public static ArrayList<DriverInformation> getAllDriverProcess(Context context) {

        ArrayList<DriverInformation> driverInformationArrayList = new ArrayList<DriverInformation>();

        Cursor res = getDataBaseInstance(context).descendingDriverInfo();

        while (res.moveToNext()) {
            DriverProcess driverProcess= new DriverProcess(
                    res.getString(2).replace("\n", "")
                    ,res.getString(1).replace("\n", "")
            );
            ProcessContent processContent=new ProcessContent(
                    res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
            );
            boolean isSelected = Boolean.valueOf(res.getString(5).replace("\n", ""));

            DriverInformation driverInformation = new DriverInformation(
                    driverProcess,processContent,isSelected
            );
            driverInformationArrayList.add(driverInformation);
        }

        return driverInformationArrayList;
    }

//    public static ArrayList<CarInformation> getAllCarProcess(Context context) {
//
//        ArrayList<CarInformation> carInformationArrayList = new ArrayList<CarInformation>();
//
//        Cursor res = getDataBaseInstance(context).descendingCarDetails();
//
//        while (res.moveToNext()) {
//            CarProcess carProcess= new CarProcess(
//                    res.getString(2).replace("\n", "")
//                    ,res.getString(1).replace("\n", "")
//            );
//            ProcessContent processContent=new ProcessContent(
//                    res.getString(3).replace("\n", "")
//                    ,res.getString(4).replace("\n", "")
//            );
//            boolean isSelected = Boolean.valueOf(res.getString(5).replace("\n", ""));
//
//            CarInformation driverInformation = new CarInformation(
//                    carProcess,processContent,isSelected
//            );
//            carInformationArrayList.add(driverInformation);
//        }
//
//        return carInformationArrayList;
//    }

    //check if table have column
    public static long checkIfDriverProcessCreated(Context context) {
        SQLiteDatabase db = getDataBaseInstance(context).getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, "driver_info_table");
        db.close();
        return count;
    }

    public static long checkIfCarDetailsProcessCreated(Context context) {
        SQLiteDatabase db = getDataBaseInstance(context).getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, "car_details_table");
        db.close();
        return count;
    }

    public static ArrayList<FavouriteCallSearch>
    getFCSCallSearch(ArrayList<BrowsingFilter> favouriteCallSearchesArrayListFilter
            ,Context context) {

        ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();

        Cursor res = getDataBaseInstance(context).descendingFCS();

        if (favouriteCallSearchesArrayListFilter !=null)
        {
            Log.i("TAG","Size: "+String.valueOf(favouriteCallSearchesArrayListFilter.size()));
        }
        if (favouriteCallSearchesArrayListFilter ==null ||favouriteCallSearchesArrayListFilter.isEmpty() || favouriteCallSearchesArrayListFilter.size() ==5)
        {
            while (res.moveToNext()) {
                FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                );
                favouriteCallSearchesArrayList.add(favouriteCallSearch);
            }
        }
        if (favouriteCallSearchesArrayListFilter !=null && favouriteCallSearchesArrayListFilter.size() ==1)
        {
            while (res.moveToNext()) {
                if (favouriteCallSearchesArrayListFilter.get(0).getFilterContentStr()
                        .equals(res.getString(3).replace("\n", "")))
                {
                    FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                            res.getString(1).replace("\n", "")
                            ,res.getString(2).replace("\n", "")
                            ,res.getString(3).replace("\n", "")
                    );
                    favouriteCallSearchesArrayList.add(favouriteCallSearch);
                }
            }
        }
        if (favouriteCallSearchesArrayListFilter !=null && favouriteCallSearchesArrayListFilter.size() ==2)
        {
            while (res.moveToNext()) {
                if (favouriteCallSearchesArrayListFilter.get(0).getFilterContentStr().equals(res.getString(3).replace("\n", "")) ||
                        favouriteCallSearchesArrayListFilter.get(1).getFilterContentStr().equals(res.getString(3).replace("\n", "")))
                {
                    FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                            res.getString(1).replace("\n", "")
                            ,res.getString(2).replace("\n", "")
                            ,res.getString(3).replace("\n", "")
                    );
                    favouriteCallSearchesArrayList.add(favouriteCallSearch);
                }
            }
        }
        if (favouriteCallSearchesArrayListFilter !=null && favouriteCallSearchesArrayListFilter.size() ==3)
        {
            while (res.moveToNext()) {
                if (favouriteCallSearchesArrayListFilter.get(0).getFilterContentStr().equals(res.getString(3).replace("\n", "")) ||
                        favouriteCallSearchesArrayListFilter.get(1).getFilterContentStr().equals(res.getString(3).replace("\n", "")) ||
                        favouriteCallSearchesArrayListFilter.get(2).getFilterContentStr().equals(res.getString(3).replace("\n", ""))
                )
                {
                    FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                            res.getString(1).replace("\n", "")
                            ,res.getString(2).replace("\n", "")
                            ,res.getString(3).replace("\n", "")
                    );
                    favouriteCallSearchesArrayList.add(favouriteCallSearch);
                }
            }
        }

        return favouriteCallSearchesArrayList;
    }

    //use arrayList to get object from database

    public static ArrayList<FavouriteCallSearch> getFavouriteCallSearch(Context context,String category) {

        ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();

        Cursor res = getDataBaseInstance(context).descendingFCS();

        while (res.moveToNext()) {
            if (category.equals(res.getString(3).replace("\n", "")))
            {
                FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                );
                favouriteCallSearchesArrayList.add(favouriteCallSearch);
            }
        }

        return favouriteCallSearchesArrayList;
    }

    public static long checkIfTableFollowing(Context context) {
        SQLiteDatabase db = getDataBaseInstance(context).getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, "following_table");
        db.close();
        return count;
    }

    public static ArrayList<Following> getFollowing(Context context) {

        ArrayList<Following> followingArrayList = new ArrayList<Following>();

        Cursor res = getDataBaseInstance(context).descendingFollowing();

        while (res.moveToNext()) {
            Following favouriteCallSearch = new Following(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")

            );
            followingArrayList.add(favouriteCallSearch);
        }

        return followingArrayList;
    }


    public static ArrayList<FavouriteCallSearch> getFCSDatabase(Context context) {

        ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayL = new ArrayList<FavouriteCallSearch>();

        Cursor res = getDataBaseInstance(context).descendingFCS();

        while (res.moveToNext()) {
            FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")

            );
            favouriteCallSearchesArrayL.add(favouriteCallSearch);
        }

        return favouriteCallSearchesArrayL;
    }


    public static ArrayList<NotificationComp> getNotificationFromDatabase(Context context,int numberOfNotification) {
        ArrayList<NotificationComp> notificationCompsArrayL = new ArrayList<NotificationComp>();
        Cursor res = getDataBaseInstance(context).descendingNotification();
        while (res.moveToNext()) {
            int curSize=res.getCount();
            if (curSize < numberOfNotification) {
                //we can calling via number of col cos Suggested model build it like database exactly
                NotificationComp notificationComp = new NotificationComp(
                        res.getString(1).replace("\n", "")
                        , res.getString(2).replace("\n", "")
                        , res.getString(3).replace("\n", "")
                        , res.getString(4).replace("\n", "")
                        , res.getString(5).replace("\n", "")
                        , res.getString(6).replace("\n", "")
                        , res.getString(7).replace("\n", "")
                        , res.getString(8).replace("\n", "")
                        , res.getString(9).replace("\n", "")
                        , res.getString(10).replace("\n", "")
                        , res.getString(11).replace("\n", "")
                        , res.getString(12).replace("\n", "")
                        , res.getString(13).replace("\n", "")
                        , res.getString(14).replace("\n", "")
                );
                notificationCompsArrayL.add(notificationComp);
            }
        }
        return notificationCompsArrayL;
    }

}
