package com.cars.halamotor.presnter;

import com.cars.halamotor.model.CCEMTModelDetails;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.SuggestedItem;

import java.util.List;

public interface RelatedAds {

    void relatedAdsToSameUser(List<SuggestedItem> relatedAdsToSameUserList);

}
