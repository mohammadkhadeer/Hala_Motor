package com.cars.halamotor_obeidat.functions;

import android.content.Context;
import android.database.Cursor;

import com.cars.halamotor_obeidat.model.AccAndJunkFirstCase;
import com.cars.halamotor_obeidat.model.CCEMTFirestCase;
import com.cars.halamotor_obeidat.model.CarPlatesFirstCase;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.model.WheelsRimFirstCase;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class HandelItemObjectBeforePass {

    public static Following getFollowingObjectFromDB(String itemID, Context context) {

        Cursor res = getDataBaseInstance(context).getFollowing(itemID);
        Following userFollowingInfo = new Following(
                res.getString(1).replace("\n", "")
                , res.getString(2).replace("\n", "")
                , res.getString(3).replace("\n", "")
                , res.getString(4).replace("\n", "")
                , res.getString(5).replace("\n", "")
        );
        return userFollowingInfo;
    }

    public static CCEMTFirestCase getCCEMTFirstCaseFromDB(String itemID, Context context) {

        Cursor res = getDataBaseInstance(context).getCCEMTObject(itemID);
        CCEMTFirestCase ccemtFirestCase = new CCEMTFirestCase(
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
        );
        return ccemtFirestCase;
    }

    public static WheelsRimFirstCase getWheelsRimFirstCaseFromDB(String itemID, Context context) {

        Cursor res = getDataBaseInstance(context).getWheelsRimObject(itemID);
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
        return wheelsRimFirstCase;
    }

    public static CarPlatesFirstCase getCarPlatesFirstCaseFromDB(String itemID, Context context) {

        Cursor res = getDataBaseInstance(context).getCarPlatesObject(itemID);
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
        return carPlatesFirstCase;
    }

    public static AccAndJunkFirstCase getAccAndJunkFirstCaseFromDB(String itemID, Context context) {

        Cursor res = getDataBaseInstance(context).getAccAndJunkObject(itemID);
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
        return accAndJunkFirstCase;
    }
}
