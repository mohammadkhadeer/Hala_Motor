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

}
