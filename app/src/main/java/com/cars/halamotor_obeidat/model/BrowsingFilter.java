package com.cars.halamotor_obeidat.model;

public class BrowsingFilter {
    String filterContentStr,filterString;
    boolean isSelected;

    public BrowsingFilter(String filterContentStr, String filterString, boolean isSelected) {
        this.filterContentStr = filterContentStr;
        this.filterString = filterString;
        this.isSelected = isSelected;
    }

    public String getFilterContentStr() {
        return filterContentStr;
    }

    public void setFilterContentStr(String filterContentStr) {
        this.filterContentStr = filterContentStr;
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
