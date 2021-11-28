package com.cars.halamotor.new_presenter;

import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.CategoryComp;

import java.util.ArrayList;

public interface SearchResult {

    void whenGetCCEMTListSearchSuccess(ArrayList<CCEMTModel> ccemtModelArrayList);

}
