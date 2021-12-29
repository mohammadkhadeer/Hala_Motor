package com.cars.halamotor_obeidat.model;

import java.util.ArrayList;

public class SimilarAdsComp {
    ArrayList<ItemSelectedFilterModel> itemFilterArrayList;
    String cityS,neighborhoodS;

    public SimilarAdsComp(ArrayList<ItemSelectedFilterModel> itemFilterArrayList, String cityS, String neighborhoodS) {
        this.itemFilterArrayList = itemFilterArrayList;
        this.cityS = cityS;
        this.neighborhoodS = neighborhoodS;
    }

    public ArrayList<ItemSelectedFilterModel> getItemFilterArrayList() {
        return itemFilterArrayList;
    }

    public void setItemFilterArrayList(ArrayList<ItemSelectedFilterModel> itemFilterArrayList) {
        this.itemFilterArrayList = itemFilterArrayList;
    }

    public String getCityS() {
        return cityS;
    }

    public void setCityS(String cityS) {
        this.cityS = cityS;
    }

    public String getNeighborhoodS() {
        return neighborhoodS;
    }

    public void setNeighborhoodS(String neighborhoodS) {
        this.neighborhoodS = neighborhoodS;
    }
}
