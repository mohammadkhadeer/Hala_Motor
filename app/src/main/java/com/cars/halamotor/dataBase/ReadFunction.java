package com.cars.halamotor.dataBase;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.cars.halamotor.model.SuggestedItem;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;

public class ReadFunction {
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
            );
            suggestedItemsArrayL.add(suggestedItem);
        }
        return suggestedItemsArrayL;
    }

}
