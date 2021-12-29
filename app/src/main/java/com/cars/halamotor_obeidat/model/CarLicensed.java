package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CarLicensed implements Parcelable {
    String setting_id,setting_code,setting_name,setting_name_en,setting_name_ar
            ,setting_content_id,setting_content_code,setting_content_name,setting_content_name_en,setting_content_name_ar;

    public CarLicensed(String setting_id, String setting_code, String setting_name, String setting_name_en, String setting_name_ar, String setting_content_id, String setting_content_code, String setting_content_name, String setting_content_name_en, String setting_content_name_ar) {
        this.setting_id = setting_id;
        this.setting_code = setting_code;
        this.setting_name = setting_name;
        this.setting_name_en = setting_name_en;
        this.setting_name_ar = setting_name_ar;
        this.setting_content_id = setting_content_id;
        this.setting_content_code = setting_content_code;
        this.setting_content_name = setting_content_name;
        this.setting_content_name_en = setting_content_name_en;
        this.setting_content_name_ar = setting_content_name_ar;
    }

    protected CarLicensed(Parcel in) {
        setting_id = in.readString();
        setting_code = in.readString();
        setting_name = in.readString();
        setting_name_en = in.readString();
        setting_name_ar = in.readString();
        setting_content_id = in.readString();
        setting_content_code = in.readString();
        setting_content_name = in.readString();
        setting_content_name_en = in.readString();
        setting_content_name_ar = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(setting_id);
        dest.writeString(setting_code);
        dest.writeString(setting_name);
        dest.writeString(setting_name_en);
        dest.writeString(setting_name_ar);
        dest.writeString(setting_content_id);
        dest.writeString(setting_content_code);
        dest.writeString(setting_content_name);
        dest.writeString(setting_content_name_en);
        dest.writeString(setting_content_name_ar);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarLicensed> CREATOR = new Creator<CarLicensed>() {
        @Override
        public CarLicensed createFromParcel(Parcel in) {
            return new CarLicensed(in);
        }

        @Override
        public CarLicensed[] newArray(int size) {
            return new CarLicensed[size];
        }
    };

    public String getSetting_id() {
        return setting_id;
    }

    public void setSetting_id(String setting_id) {
        this.setting_id = setting_id;
    }

    public String getSetting_code() {
        return setting_code;
    }

    public void setSetting_code(String setting_code) {
        this.setting_code = setting_code;
    }

    public String getSetting_name() {
        return setting_name;
    }

    public void setSetting_name(String setting_name) {
        this.setting_name = setting_name;
    }

    public String getSetting_name_en() {
        return setting_name_en;
    }

    public void setSetting_name_en(String setting_name_en) {
        this.setting_name_en = setting_name_en;
    }

    public String getSetting_name_ar() {
        return setting_name_ar;
    }

    public void setSetting_name_ar(String setting_name_ar) {
        this.setting_name_ar = setting_name_ar;
    }

    public String getSetting_content_id() {
        return setting_content_id;
    }

    public void setSetting_content_id(String setting_content_id) {
        this.setting_content_id = setting_content_id;
    }

    public String getSetting_content_code() {
        return setting_content_code;
    }

    public void setSetting_content_code(String setting_content_code) {
        this.setting_content_code = setting_content_code;
    }

    public String getSetting_content_name() {
        return setting_content_name;
    }

    public void setSetting_content_name(String setting_content_name) {
        this.setting_content_name = setting_content_name;
    }

    public String getSetting_content_name_en() {
        return setting_content_name_en;
    }

    public void setSetting_content_name_en(String setting_content_name_en) {
        this.setting_content_name_en = setting_content_name_en;
    }

    public String getSetting_content_name_ar() {
        return setting_content_name_ar;
    }

    public void setSetting_content_name_ar(String setting_content_name_ar) {
        this.setting_content_name_ar = setting_content_name_ar;
    }
}
