package com.cars.halamotor.presnter;

import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CCEMTModelDetails;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.WheelsRimModel;
import com.cars.halamotor.view.activity.WheelsRim;

import java.util.ArrayList;

public interface ItemModel {
    void onReceiveAccAndJunkObject(ItemAccAndJunk accAndJunk);

    void onReceiveWheelsRimObject(ItemWheelsRim wheelsRim);

    void onReceiveCarPlatesObject(ItemPlates carPlatesModel);

    void onReceiveCCEMTObjectDetails(CCEMTModelDetails ccemtModelDetails, ArrayList<CCEMTModel> ccemtModelArrayList);

}
