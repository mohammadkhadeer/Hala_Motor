package com.cars.halamotor_obeidat.model;

public class EditValueInCDM {
    String whatUserWantToChangeStr,valueInWhatUserWantToChangeStr;

    public EditValueInCDM(String whatUserWantToChangeStr, String valueInWhatUserWantToChangeStr) {
        this.whatUserWantToChangeStr = whatUserWantToChangeStr;
        this.valueInWhatUserWantToChangeStr = valueInWhatUserWantToChangeStr;
    }

    public String getWhatUserWantToChangeStr() {
        return whatUserWantToChangeStr;
    }

    public void setWhatUserWantToChangeStr(String whatUserWantToChangeStr) {
        this.whatUserWantToChangeStr = whatUserWantToChangeStr;
    }

    public String getValueInWhatUserWantToChangeStr() {
        return valueInWhatUserWantToChangeStr;
    }

    public void setValueInWhatUserWantToChangeStr(String valueInWhatUserWantToChangeStr) {
        this.valueInWhatUserWantToChangeStr = valueInWhatUserWantToChangeStr;
    }
}
