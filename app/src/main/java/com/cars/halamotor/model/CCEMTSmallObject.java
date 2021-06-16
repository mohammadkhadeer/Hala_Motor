package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CCEMTSmallObject implements Parcelable {
    String ad_id,ad_title,ad_description,ad_price,ad_phone,ad_time_post,year,kilometers_from,kilometers_to
            ,car_insurance_type,car_license_type,car_fuel_type,car_transmission_type,car_condition_type
            ,payment_method,car_color;

    ArrayList <String> options;

    public CCEMTSmallObject(String ad_id, String ad_title, String ad_description, String ad_price, String ad_phone, String ad_time_post, String year, String kilometers_from, String kilometers_to, String car_insurance_type, String car_license_type, String car_fuel_type, String car_transmission_type, String car_condition_type, String payment_method, String car_color, ArrayList<String> options) {
        this.ad_id = ad_id;
        this.ad_title = ad_title;
        this.ad_description = ad_description;
        this.ad_price = ad_price;
        this.ad_phone = ad_phone;
        this.ad_time_post = ad_time_post;
        this.year = year;
        this.kilometers_from = kilometers_from;
        this.kilometers_to = kilometers_to;
        this.car_insurance_type = car_insurance_type;
        this.car_license_type = car_license_type;
        this.car_fuel_type = car_fuel_type;
        this.car_transmission_type = car_transmission_type;
        this.car_condition_type = car_condition_type;
        this.payment_method = payment_method;
        this.car_color = car_color;
        this.options = options;
    }

    protected CCEMTSmallObject(Parcel in) {
        ad_id = in.readString();
        ad_title = in.readString();
        ad_description = in.readString();
        ad_price = in.readString();
        ad_phone = in.readString();
        ad_time_post = in.readString();
        year = in.readString();
        kilometers_from = in.readString();
        kilometers_to = in.readString();
        car_insurance_type = in.readString();
        car_license_type = in.readString();
        car_fuel_type = in.readString();
        car_transmission_type = in.readString();
        car_condition_type = in.readString();
        payment_method = in.readString();
        car_color = in.readString();
        options = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ad_id);
        dest.writeString(ad_title);
        dest.writeString(ad_description);
        dest.writeString(ad_price);
        dest.writeString(ad_phone);
        dest.writeString(ad_time_post);
        dest.writeString(year);
        dest.writeString(kilometers_from);
        dest.writeString(kilometers_to);
        dest.writeString(car_insurance_type);
        dest.writeString(car_license_type);
        dest.writeString(car_fuel_type);
        dest.writeString(car_transmission_type);
        dest.writeString(car_condition_type);
        dest.writeString(payment_method);
        dest.writeString(car_color);
        dest.writeStringList(options);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CCEMTSmallObject> CREATOR = new Creator<CCEMTSmallObject>() {
        @Override
        public CCEMTSmallObject createFromParcel(Parcel in) {
            return new CCEMTSmallObject(in);
        }

        @Override
        public CCEMTSmallObject[] newArray(int size) {
            return new CCEMTSmallObject[size];
        }
    };

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getAd_title() {
        return ad_title;
    }

    public void setAd_title(String ad_title) {
        this.ad_title = ad_title;
    }

    public String getAd_description() {
        return ad_description;
    }

    public void setAd_description(String ad_description) {
        this.ad_description = ad_description;
    }

    public String getAd_price() {
        return ad_price;
    }

    public void setAd_price(String ad_price) {
        this.ad_price = ad_price;
    }

    public String getAd_phone() {
        return ad_phone;
    }

    public void setAd_phone(String ad_phone) {
        this.ad_phone = ad_phone;
    }

    public String getAd_time_post() {
        return ad_time_post;
    }

    public void setAd_time_post(String ad_time_post) {
        this.ad_time_post = ad_time_post;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKilometers_from() {
        return kilometers_from;
    }

    public void setKilometers_from(String kilometers_from) {
        this.kilometers_from = kilometers_from;
    }

    public String getKilometers_to() {
        return kilometers_to;
    }

    public void setKilometers_to(String kilometers_to) {
        this.kilometers_to = kilometers_to;
    }

    public String getCar_insurance_type() {
        return car_insurance_type;
    }

    public void setCar_insurance_type(String car_insurance_type) {
        this.car_insurance_type = car_insurance_type;
    }

    public String getCar_license_type() {
        return car_license_type;
    }

    public void setCar_license_type(String car_license_type) {
        this.car_license_type = car_license_type;
    }

    public String getCar_fuel_type() {
        return car_fuel_type;
    }

    public void setCar_fuel_type(String car_fuel_type) {
        this.car_fuel_type = car_fuel_type;
    }

    public String getCar_transmission_type() {
        return car_transmission_type;
    }

    public void setCar_transmission_type(String car_transmission_type) {
        this.car_transmission_type = car_transmission_type;
    }

    public String getCar_condition_type() {
        return car_condition_type;
    }

    public void setCar_condition_type(String car_condition_type) {
        this.car_condition_type = car_condition_type;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
