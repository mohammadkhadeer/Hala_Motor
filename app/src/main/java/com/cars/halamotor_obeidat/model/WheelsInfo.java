package com.cars.halamotor_obeidat.model;

public class WheelsInfo {
    String wheelsSizeStr,WheelsTypeStr,WheelsTypeSStr;

    public WheelsInfo(String wheelsSizeStr, String wheelsTypeStr, String wheelsTypeSStr) {
        this.wheelsSizeStr = wheelsSizeStr;
        WheelsTypeStr = wheelsTypeStr;
        WheelsTypeSStr = wheelsTypeSStr;
    }

    public String getWheelsSizeStr() {
        return wheelsSizeStr;
    }

    public void setWheelsSizeStr(String wheelsSizeStr) {
        this.wheelsSizeStr = wheelsSizeStr;
    }

    public String getWheelsTypeStr() {
        return WheelsTypeStr;
    }

    public void setWheelsTypeStr(String wheelsTypeStr) {
        WheelsTypeStr = wheelsTypeStr;
    }

    public String getWheelsTypeSStr() {
        return WheelsTypeSStr;
    }

    public void setWheelsTypeSStr(String wheelsTypeSStr) {
        WheelsTypeSStr = wheelsTypeSStr;
    }
}
