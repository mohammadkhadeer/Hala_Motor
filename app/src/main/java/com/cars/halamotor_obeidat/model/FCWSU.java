package com.cars.halamotor_obeidat.model;

public class FCWSU {
    //this is use to save 1.favourite item 2.call item
    //3.watches item 4.user inset item
    //just in general and use it when save all previous types to set
    // in user profile but in details well use FCS

    String itemID;

    public FCWSU(){}

    public FCWSU(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
