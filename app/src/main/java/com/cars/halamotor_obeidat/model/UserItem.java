package com.cars.halamotor_obeidat.model;

public class UserItem {
    String categoryS,itemID;

    public UserItem(){}
    public UserItem(String categoryS, String itemID) {
        this.categoryS = categoryS;
        this.itemID = itemID;
    }

    public String getCategoryS() {
        return categoryS;
    }

    public void setCategoryS(String categoryS) {
        this.categoryS = categoryS;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
