package com.cars.halamotor_obeidat.new_presenter;

import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.SuggestedItem;

import java.util.ArrayList;

public class CovertFromCCEMTObjectToSuggestedObject {

    public static void CovertFromCCEMTObjectToSuggestedObjectFun(ArrayList<CCEMTModel> adsArrayList){

        for (int i=0;i<adsArrayList.size();i++)
        {
            SuggestedItem suggestedItem = new SuggestedItem();
        }
    }
}
