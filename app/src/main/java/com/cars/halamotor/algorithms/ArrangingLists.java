package com.cars.halamotor.algorithms;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cars.halamotor.model.AccAndJunkFirstCase;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.cars.halamotor.model.FavouriteCallSearch;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.model.WheelsRimFirstCase;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;

public class ArrangingLists {

    //check if item favourite or not we have 2 cases
    //1. Init case no item favourite yet we can check this case via size table in data base this method
    //2. must to use quick sort algo to check in best performance

    public static String checkFavouriteOrNot1(Context context,String itemID) {

        String favouriteOrNot = "";
        ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayL = new ArrayList<FavouriteCallSearch>();

        Cursor res = getDataBaseInstance(context).descendingFCS();

        while (res.moveToNext()) {
            if (res.getString(38).replace("\n", "").equals("favorite"))
            {
                FavouriteCallSearch favouriteCallSearch = new FavouriteCallSearch(
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
                        , res.getString(37).replace("\n", "")
                        , res.getString(38).replace("\n", "")
                );
                favouriteCallSearchesArrayL.add(favouriteCallSearch);
            }
        }

        if (favouriteCallSearchesArrayL.isEmpty()) {
            favouriteOrNot = "not_favorite";
        }
        else {
            int flag = 0;
            for (int i = 0; i < favouriteCallSearchesArrayL.size(); i++) {
                if (favouriteCallSearchesArrayL.get(i).getFcsType().equals("favorite")) {
                    if (favouriteCallSearchesArrayL.get(i).getItemIdInServer().equals(itemID)) {
                        flag = 1;
                        favouriteOrNot = "favorite";
                    }
                }
            }
            if (flag == 0)
            {
                favouriteOrNot = "not_favorite";
            }
        }
        return favouriteOrNot;
    }

    //this four algo just to re store lists make edit text first
    public static ArrayList<CCEMTFirestCase> setEditTextFirstItemCCEMTFirstCase
            (ArrayList<CCEMTFirestCase> ccemtFirstCaseArrayList) {

        ArrayList<CCEMTFirestCase> ccemtFCContainer1ArrayList = new ArrayList<>();
        ArrayList<CCEMTFirestCase> ccemtFCContainer2ArrayList = new ArrayList<>();
        for (int i =0 ; i <ccemtFirstCaseArrayList.size();i++)
        {
            if (ccemtFirstCaseArrayList.get(i).getItemPostEdit().equals("1"))
            {
                ccemtFCContainer1ArrayList.add(ccemtFirstCaseArrayList.get(i));
            }else{
                ccemtFCContainer2ArrayList.add(ccemtFirstCaseArrayList.get(i));
            }
        }
        ccemtFirstCaseArrayList = new ArrayList<>();
        int lastPostion = 0;
        for (int j = 0;j<ccemtFCContainer1ArrayList.size();j++)
        {
            ccemtFirstCaseArrayList.add(j,ccemtFCContainer1ArrayList.get(j));
            lastPostion =j;
        }
        for (int k = 0;k<ccemtFCContainer2ArrayList.size();k++)
        {
            if (lastPostion == 0)
                lastPostion = 0;
            else
                lastPostion = lastPostion + 1;
            ccemtFirstCaseArrayList.add(lastPostion,ccemtFCContainer2ArrayList.get(k));
        }

        return ccemtFirstCaseArrayList;
    }

    public static ArrayList<WheelsRimFirstCase> setEditTextFirstItemWheelsRim
            (ArrayList<WheelsRimFirstCase> wheelsRimFirstCaseArrayList) {

        ArrayList<WheelsRimFirstCase> ccemtFCContainer1ArrayList = new ArrayList<>();
        ArrayList<WheelsRimFirstCase> ccemtFCContainer2ArrayList = new ArrayList<>();
        for (int i =0 ; i <wheelsRimFirstCaseArrayList.size();i++)
        {
            if (wheelsRimFirstCaseArrayList.get(i).getItemPostEdit().equals("1"))
            {
                ccemtFCContainer1ArrayList.add(wheelsRimFirstCaseArrayList.get(i));
            }else{
                ccemtFCContainer2ArrayList.add(wheelsRimFirstCaseArrayList.get(i));
            }
        }

        wheelsRimFirstCaseArrayList = new ArrayList<>();
        int lastPostion = 0;
        for (int j = 0;j<ccemtFCContainer1ArrayList.size();j++)
        {
            wheelsRimFirstCaseArrayList.add(j,ccemtFCContainer1ArrayList.get(j));
            lastPostion =j;
        }
        for (int k = 0;k<ccemtFCContainer2ArrayList.size();k++)
        {
            if (lastPostion == 0)
                lastPostion = 0;
            else
                lastPostion = lastPostion + 1;
            wheelsRimFirstCaseArrayList.add(lastPostion,ccemtFCContainer2ArrayList.get(k));
        }

        return wheelsRimFirstCaseArrayList;
    }

    public static ArrayList<CarPlatesFirstCase> setEditTextFirstCarPlates
            (ArrayList<CarPlatesFirstCase> carPlatesFirstCaseArrayList) {

        ArrayList<CarPlatesFirstCase> ccemtFCContainer1ArrayList = new ArrayList<>();
        ArrayList<CarPlatesFirstCase> ccemtFCContainer2ArrayList = new ArrayList<>();
        for (int i =0 ; i <carPlatesFirstCaseArrayList.size();i++)
        {
            if (carPlatesFirstCaseArrayList.get(i).getItemPostEdit().equals("1"))
            {
                ccemtFCContainer1ArrayList.add(carPlatesFirstCaseArrayList.get(i));
            }else{
                ccemtFCContainer2ArrayList.add(carPlatesFirstCaseArrayList.get(i));
            }
        }

        carPlatesFirstCaseArrayList = new ArrayList<>();
        int lastPostion = 0;
        for (int j = 0;j<ccemtFCContainer1ArrayList.size();j++)
        {
            carPlatesFirstCaseArrayList.add(j,ccemtFCContainer1ArrayList.get(j));
            lastPostion =j;
        }
        for (int k = 0;k<ccemtFCContainer2ArrayList.size();k++)
        {
            if (lastPostion == 0)
                lastPostion = 0;
            else
                lastPostion = lastPostion + 1;
            carPlatesFirstCaseArrayList.add(lastPostion,ccemtFCContainer2ArrayList.get(k));
        }

        return carPlatesFirstCaseArrayList;
    }

    public static ArrayList<AccAndJunkFirstCase> setEditTextFirstAccAndJunk
            (ArrayList<AccAndJunkFirstCase> accAndJunkFirstCaseArrayList) {

        ArrayList<AccAndJunkFirstCase> ccemtFCContainer1ArrayList = new ArrayList<>();
        ArrayList<AccAndJunkFirstCase> ccemtFCContainer2ArrayList = new ArrayList<>();
        for (int i =0 ; i <accAndJunkFirstCaseArrayList.size();i++)
        {
            if (accAndJunkFirstCaseArrayList.get(i).getItemPostEdit().equals("1"))
            {
                ccemtFCContainer1ArrayList.add(accAndJunkFirstCaseArrayList.get(i));
            }else{
                ccemtFCContainer2ArrayList.add(accAndJunkFirstCaseArrayList.get(i));
            }
        }
        accAndJunkFirstCaseArrayList = new ArrayList<>();
        int lastPostion = 0;
        for (int j = 0;j<ccemtFCContainer1ArrayList.size() && ccemtFCContainer1ArrayList.size() !=0;j++)
        {
            accAndJunkFirstCaseArrayList.add(j,ccemtFCContainer1ArrayList.get(j));
            lastPostion =j;
        }

        for (int k = 0;k<ccemtFCContainer2ArrayList.size() && ccemtFCContainer2ArrayList.size() !=0;k++)
        {
            if (lastPostion == 0)
                lastPostion = 0;
            else
            lastPostion = lastPostion + 1;
            accAndJunkFirstCaseArrayList.add(lastPostion,ccemtFCContainer2ArrayList.get(k));
        }

        return accAndJunkFirstCaseArrayList;
    }

}
