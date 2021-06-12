package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Area implements Parcelable{
    String id,name,name_en,name_ar;
    City city;

    public Area(String id, String name, String name_en, String name_ar, City city) {
        this.id = id;
        this.name = name;
        this.name_en = name_en;
        this.name_ar = name_ar;
        this.city = city;
    }

    protected Area(Parcel in) {
        id = in.readString();
        name = in.readString();
        name_en = in.readString();
        name_ar = in.readString();
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel in) {
            return new Area(in);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(name_en);
        dest.writeString(name_ar);
    }
}
