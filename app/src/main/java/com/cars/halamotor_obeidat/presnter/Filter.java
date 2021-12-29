package com.cars.halamotor_obeidat.presnter;

import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.ItemFilterModel;
import com.cars.halamotor_obeidat.model.Neighborhood;

public interface Filter {

    void onFilterClick(ItemFilterModel filterModel,String filterType);

    void onFilterCancel();

    void onFilterCityClick(CityModel cityModel);

    void onFilterCityCancel(Boolean cancel);

    void onFilterNeighborhoodClick(Neighborhood neighborhood);

    void onFilterNeighborhoodCancel(Boolean cancel);

    //CityModel
}
