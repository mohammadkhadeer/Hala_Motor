package com.cars.halamotor.new_presenter;

import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.SuggestedItem;

import java.util.ArrayList;

public class CovertFromCCEMTObjectToSuggestedObject {

    public static void CovertFromCCEMTObjectToSuggestedObjectFun(ArrayList<CCEMTModel> adsArrayList){

        for (int i=0;i<adsArrayList.size();i++)
        {
            SuggestedItem suggestedItem = new SuggestedItem();
        }
    }
}
