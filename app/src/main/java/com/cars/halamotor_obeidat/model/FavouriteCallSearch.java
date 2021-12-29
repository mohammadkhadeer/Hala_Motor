package com.cars.halamotor_obeidat.model;

public class FavouriteCallSearch {

    String idInDatabase,itemType,fcsType;

    public FavouriteCallSearch(String idInDatabase, String itemType, String fcsType) {
        this.idInDatabase = idInDatabase;
        this.itemType = itemType;
        this.fcsType = fcsType;
    }

    public String getIdInDatabase() {
        return idInDatabase;
    }

    public void setIdInDatabase(String idInDatabase) {
        this.idInDatabase = idInDatabase;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getFcsType() {
        return fcsType;
    }

    public void setFcsType(String fcsType) {
        this.fcsType = fcsType;
    }
}
