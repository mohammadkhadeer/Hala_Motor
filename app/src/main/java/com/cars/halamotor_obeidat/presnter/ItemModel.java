package com.cars.halamotor_obeidat.presnter;

import com.cars.halamotor_obeidat.model.CCEMTModelDetails;
import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;

public interface ItemModel {
    void onReceiveAccAndJunkObject(ItemAccAndJunk accAndJunk);

    void onReceiveWheelsRimObject(ItemWheelsRim wheelsRim);

    void onReceiveCarPlatesObject(ItemPlates carPlatesModel);

    void onReceiveCCEMTObjectDetails(CCEMTModelDetails ccemtModelDetails);

}
