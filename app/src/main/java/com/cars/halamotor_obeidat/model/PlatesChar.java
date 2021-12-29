package com.cars.halamotor_obeidat.model;

public class PlatesChar {
    String charStr;
    boolean selectedOrNot;

    public PlatesChar(String charStr, boolean selectedOrNot) {
        this.charStr = charStr;
        this.selectedOrNot = selectedOrNot;
    }

    public String getCharStr() {
        return charStr;
    }

    public void setCharStr(String charStr) {
        this.charStr = charStr;
    }

    public boolean isSelectedOrNot() {
        return selectedOrNot;
    }

    public void setSelectedOrNot(boolean selectedOrNot) {
        this.selectedOrNot = selectedOrNot;
    }
}
