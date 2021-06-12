package com.cars.halamotor.model;

public class CarOption {
    String setting_id,setting_code,setting_name,setting_name_en,setting_name_ar
            ,setting_content_id,setting_content_code,setting_content_name,setting_content_name_en,setting_content_name_ar;

    int isSelected;

    public CarOption(String setting_id, String setting_code, String setting_name, String setting_name_en, String setting_name_ar, String setting_content_id, String setting_content_code, String setting_content_name, String setting_content_name_en, String setting_content_name_ar, int isSelected) {
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
        this.isSelected = isSelected;
    }

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

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }
}
