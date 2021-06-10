package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CarModel implements Parcelable {
    String brandID,brand_name,brand_name_en,brand_name_ar,model_id,model_name,model_name_en,model_name_ar;

    public CarModel(String brandID, String brand_name, String brand_name_en, String brand_name_ar, String model_id, String model_name, String model_name_en, String model_name_ar) {
        this.brandID = brandID;
        this.brand_name = brand_name;
        this.brand_name_en = brand_name_en;
        this.brand_name_ar = brand_name_ar;
        this.model_id = model_id;
        this.model_name = model_name;
        this.model_name_en = model_name_en;
        this.model_name_ar = model_name_ar;
    }

    protected CarModel(Parcel in) {
        brandID = in.readString();
        brand_name = in.readString();
        brand_name_en = in.readString();
        brand_name_ar = in.readString();
        model_id = in.readString();
        model_name = in.readString();
        model_name_en = in.readString();
        model_name_ar = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brandID);
        dest.writeString(brand_name);
        dest.writeString(brand_name_en);
        dest.writeString(brand_name_ar);
        dest.writeString(model_id);
        dest.writeString(model_name);
        dest.writeString(model_name_en);
        dest.writeString(model_name_ar);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarModel> CREATOR = new Creator<CarModel>() {
        @Override
        public CarModel createFromParcel(Parcel in) {
            return new CarModel(in);
        }

        @Override
        public CarModel[] newArray(int size) {
            return new CarModel[size];
        }
    };

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_name_en() {
        return brand_name_en;
    }

    public void setBrand_name_en(String brand_name_en) {
        this.brand_name_en = brand_name_en;
    }

    public String getBrand_name_ar() {
        return brand_name_ar;
    }

    public void setBrand_name_ar(String brand_name_ar) {
        this.brand_name_ar = brand_name_ar;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_name_en() {
        return model_name_en;
    }

    public void setModel_name_en(String model_name_en) {
        this.model_name_en = model_name_en;
    }

    public String getModel_name_ar() {
        return model_name_ar;
    }

    public void setModel_name_ar(String model_name_ar) {
        this.model_name_ar = model_name_ar;
    }
}
