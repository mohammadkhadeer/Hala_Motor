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

    public static ArrayList<CarInformation> getAllCarProcess(Context context) {

        ArrayList<CarInformation> carInformationArrayList = new ArrayList<CarInformation>();

        Cursor res = getDataBaseInstance(context).descendingCarDetails();

        while (res.moveToNext()) {
            CarProcess carProcess= new CarProcess(
                    res.getString(2).replace("\n", "")
                    ,res.getString(1).replace("\n", "")
            );
            ProcessContent processContent=new ProcessContent(
                    res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
            );
            boolean isSelected = Boolean.valueOf(res.getString(5).replace("\n", ""));

            CarInformation driverInformation = new CarInformation(
                    carProcess,processContent,isSelected
            );
            carInformationArrayList.add(driverInformation);
        }

        return carInformationArrayList;
    }

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

    public static ArrayList<SuggestedItem> getSuggestedItemFromDatabase(Context context) {
        ArrayList<SuggestedItem> suggestedItemsArrayL = new ArrayList<SuggestedItem>();
        Cursor res = getDataBaseInstance(context).descendingItem();
        while (res.moveToNext()) {
            //we can calling via number of col cos Suggested model build it like database exactly
            SuggestedItem suggestedItem = new SuggestedItem(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")
                    ,res.getString(6).replace("\n", "")
                    ,res.getString(7).replace("\n", "")
                    ,res.getString(8).replace("\n", "")
                    ,res.getString(9).replace("\n", "")
                    ,res.getString(10).replace("\n", "")
                    ,res.getString(11).replace("\n", "")
                    ,res.getString(12).replace("\n", "")
                    ,res.getString(13).replace("\n", "")
                    ,res.getString(14).replace("\n", "")
                    ,res.getString(15).replace("\n", "")
                    ,res.getString(16).replace("\n", "")
                    ,res.getString(17).replace("\n", "")
                    ,res.getString(18).replace("\n", "")
                    ,res.getString(19).replace("\n", "")
                    ,res.getString(20).replace("\n", "")
                    ,res.getString(21).replace("\n", "")
                    ,res.getString(22).replace("\n", "")
                    ,res.getString(23).replace("\n", "")
                    ,res.getString(24).replace("\n", "")
                    ,res.getString(25).replace("\n", "")
                    ,res.getString(26).replace("\n", "")
                    ,res.getString(27).replace("\n", "")
                    ,res.getString(28).replace("\n", "")
                    ,res.getString(29).replace("\n", "")
                    ,res.getString(30).replace("\n", "")
                    ,res.getString(31).replace("\n", "")
                    ,res.getString(32).replace("\n", "")
                    ,res.getString(33).replace("\n", "")
                    ,res.getString(34).replace("\n", "")
                    ,res.getString(35).replace("\n", "")
                    ,res.getString(36).replace("\n", "")
                    ,res.getString(37).replace("\n", "")
                    ,res.getString(38).replace("\n", "")
            );
            suggestedItemsArrayL.add(suggestedItem);
        }
        return suggestedItemsArrayL;
    }

    public static ArrayList<SimilarItem> getSimilarFromDatabase(Context context) {
        ArrayList<SimilarItem> similarItemsArrayL = new ArrayList<SimilarItem>();
        Cursor res = getDataBaseInstance(context).descendingSimilarAds();
        while (res.moveToNext()) {
            //we can calling via number of col cos Suggested model build it like database exactly
            SimilarItem similarItem = new SimilarItem(
                    res.getString(1).replace("\n", "")
                    ,res.getString(2).replace("\n", "")
                    ,res.getString(3).replace("\n", "")
                    ,res.getString(4).replace("\n", "")
                    ,res.getString(5).replace("\n", "")
                    ,res.getString(6).replace("\n", "")
                    ,res.getString(7).replace("\n", "")
                    ,res.getString(8).replace("\n", "")
                    ,res.getString(9).replace("\n", "")
                    ,res.getString(10).replace("\n", "")
                    ,res.getString(11).replace("\n", "")
                    ,res.getString(12).replace("\n", "")
                    ,res.getString(13).replace("\n", "")
                    ,res.getString(14).replace("\n", "")
                    ,res.getString(15).replace("\n", "")
                    ,res.getString(16).replace("\n", "")
                    ,res.getString(17).replace("\n", "")
                    ,res.getString(18).replace("\n", "")
                    ,res.getString(19).replace("\n", "")
                    ,res.getString(20).replace("\n", "")
                    ,res.getString(21).replace("\n", "")
                    ,res.getString(22).replace("\n", "")
                    ,res.getString(23).replace("\n", "")
                    ,res.getString(24).replace("\n", "")
                    ,res.getString(25).replace("\n", "")
                    ,res.getString(26).replace("\n", "")
                    ,res.getString(27).replace("\n", "")
                    ,res.getString(28).replace("\n", "")
                    ,res.getString(29).replace("\n", "")
                    ,res.getString(30).replace("\n", "")
                    ,res.getString(31).replace("\n", "")
                    ,res.getString(32).replace("\n", "")
                    ,res.getString(33).replace("\n", "")
                    ,res.getString(34).replace("\n", "")
                    ,res.getString(35).replace("\n", "")
                    ,res.getString(36).replace("\n", "")
                    ,res.getString(37).replace("\n", "")
            );
            similarItemsArrayL.add(similarItem);
        }
        return similarItemsArrayL;
    }


    public static ArrayList<CarPlatesFirstCase> getCarPlatesDatabase(Context context) {
        ArrayList<CarPlatesFirstCase> carPlatesArrayL = new ArrayList<CarPlatesFirstCase>();
        Cursor res = getDataBaseInstance(context).descendingCarPlates();
        while (res.moveToNext()) {

            if (res.getString(21).replace("\n", "").equals("0"))
            {
                CarPlatesFirstCase carPlatesFirstCase = new CarPlatesFirstCase(
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
                        , res.getString(15).replace("\n", "")
                        , res.getString(16).replace("\n", "")
                        , res.getString(17).replace("\n", "")
                        , res.getString(18).replace("\n", "")
                        , res.getString(19).replace("\n", "")
                        , res.getString(20).replace("\n", "")
                        , res.getString(21).replace("\n", "")
                        , res.getString(22).replace("\n", "")
                        , res.getString(23).replace("\n", "")
                        , res.getString(24).replace("\n", "")
                        , res.getString(25).replace("\n", "")
                        , res.getString(26).replace("\n", "")
                );
                carPlatesArrayL.add(carPlatesFirstCase);
            }
        }
        return carPlatesArrayL;
    }

    public static ArrayList<AccAndJunkFirstCase> getAccAndJunkDatabase(Context context, String category) {
        ArrayList<AccAndJunkFirstCase> accAndJunkRimArrayL = new ArrayList<AccAndJunkFirstCase>();
        Cursor res = getDataBaseInstance(context).descendingAccAndJunk();
        while (res.moveToNext()) {

            if (res.getString(3).replace("\n", "").equals(category))
            {
                AccAndJunkFirstCase accAndJunkFirstCase = new AccAndJunkFirstCase(
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
                        , res.getString(15).replace("\n", "")
                        , res.getString(16).replace("\n", "")
                        , res.getString(17).replace("\n", "")
                        , res.getString(18).replace("\n", "")
                        , res.getString(19).replace("\n", "")
                        , res.getString(20).replace("\n", "")
                        , res.getString(21).replace("\n", "")
                        , res.getString(22).replace("\n", "")
                        , res.getString(23).replace("\n", "")
                        , res.getString(24).replace("\n", "")
                );
                accAndJunkRimArrayL.add(accAndJunkFirstCase);
            }
        }
        return accAndJunkRimArrayL;
    }

    public static ArrayList<WheelsRimFirstCase> getWheelsRimDatabase(Context context) {
        ArrayList<WheelsRimFirstCase> wheelsRimArrayL = new ArrayList<WheelsRimFirstCase>();
        Cursor res = getDataBaseInstance(context).descendingWheelsSize();
        while (res.moveToNext()) {

            if (res.getString(19).replace("\n", "").equals("0"))
            {
                WheelsRimFirstCase wheelsRimFirstCase = new WheelsRimFirstCase(
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
                        , res.getString(15).replace("\n", "")
                        , res.getString(16).replace("\n", "")
                        , res.getString(17).replace("\n", "")
                        , res.getString(18).replace("\n", "")
                        , res.getString(19).replace("\n", "")
                        , res.getString(20).replace("\n", "")
                        , res.getString(21).replace("\n", "")
                        , res.getString(22).replace("\n", "")
                        , res.getString(23).replace("\n", "")
                        , res.getString(24).replace("\n", "")
                );
                wheelsRimArrayL.add(wheelsRimFirstCase);
            }
        }
        return wheelsRimArrayL;
    }

    public static ArrayList<CCEMTFirestCase> getCarForSaleDatabase(Context context,String category) {
        ArrayList<CCEMTFirestCase> carForSaleArrayL = new ArrayList<CCEMTFirestCase>();
        Cursor res = getDataBaseInstance(context).descendingCCEMT();
        while (res.moveToNext()) {

            if (res.getString(3).replace("\n", "").equals(category)
                && res.getString(31).replace("\n", "").equals("0"))
            {
                CCEMTFirestCase carForSaleCCEMT = new CCEMTFirestCase(
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
                        , res.getString(15).replace("\n", "")
                        , res.getString(16).replace("\n", "")
                        , res.getString(17).replace("\n", "")
                        , res.getString(18).replace("\n", "")
                        , res.getString(19).replace("\n", "")
                        , res.getString(20).replace("\n", "")
                        , res.getString(21).replace("\n", "")
                        , res.getString(22).replace("\n", "")
                        , res.getString(23).replace("\n", "")
                        , res.getString(24).replace("\n", "")
                        , res.getString(25).replace("\n", "")
                        , res.getString(26).replace("\n", "")
                        , res.getString(27).replace("\n", "")
                        , res.getString(28).replace("\n", "")
                        , res.getString(29).replace("\n", "")
                        , res.getString(30).replace("\n", "")
                        , res.getString(31).replace("\n", "")
                        , res.getString(32).replace("\n", "")
                        , res.getString(33).replace("\n", "")
                        , res.getString(34).replace("\n", "")
                        , res.getString(35).replace("\n", "")
                        , res.getString(36).replace("\n", "")
                );
                carForSaleArrayL.add(carForSaleCCEMT);
            }
        }
        return carForSaleArrayL;
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
                );
                notificationCompsArrayL.add(notificationComp);
            }
        }
        return notificationCompsArrayL;
    }

}
