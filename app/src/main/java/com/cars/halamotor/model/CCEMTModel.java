package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CCEMTModel implements Parcelable{

    String ad_id,ad_title,ad_description,ad_price,ad_phone,ad_time_post,ad_category_id,ad_category_name_en,ad_category_name_ar;
    ArrayList <String> photosArrayList;
    ArrayList <Attributes> attributesArrayList;

    public CCEMTModel(String ad_id, String ad_title, String ad_description, String ad_price, String ad_phone, String ad_time_post, String ad_category_id, String ad_category_name_en, String ad_category_name_ar, ArrayList<String> photosArrayList, ArrayList<Attributes> attributesArrayList) {
        this.ad_id = ad_id;
        this.ad_title = ad_title;
        this.ad_description = ad_description;
        this.ad_price = ad_price;
        this.ad_phone = ad_phone;
        this.ad_time_post = ad_time_post;
        this.ad_category_id = ad_category_id;
        this.ad_category_name_en = ad_category_name_en;
        this.ad_category_name_ar = ad_category_name_ar;
        this.photosArrayList = photosArrayList;
        this.attributesArrayList = attributesArrayList;
    }

    protected CCEMTModel(Parcel in) {
        ad_id = in.readString();
        ad_title = in.readString();
        ad_description = in.readString();
        ad_price = in.readString();
        ad_phone = in.readString();
        ad_time_post = in.readString();
        ad_category_id = in.readString();
        ad_category_name_en = in.readString();
        ad_category_name_ar = in.readString();
        photosArrayList = in.createStringArrayList();
        attributesArrayList = in.createTypedArrayList(Attributes.CREATOR);
    }

    public static final Creator<CCEMTModel> CREATOR = new Creator<CCEMTModel>() {
        @Override
        public CCEMTModel createFromParcel(Parcel in) {
            return new CCEMTModel(in);
        }

        @Override
        public CCEMTModel[] newArray(int size) {
            return new CCEMTModel[size];
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

    public String getAd_category_id() {
        return ad_category_id;
    }

    public void setAd_category_id(String ad_category_id) {
        this.ad_category_id = ad_category_id;
    }

    public String getAd_category_name_en() {
        return ad_category_name_en;
    }

    public void setAd_category_name_en(String ad_category_name_en) {
        this.ad_category_name_en = ad_category_name_en;
    }

    public String getAd_category_name_ar() {
        return ad_category_name_ar;
    }

    public void setAd_category_name_ar(String ad_category_name_ar) {
        this.ad_category_name_ar = ad_category_name_ar;
    }

    public ArrayList<String> getPhotosArrayList() {
        return photosArrayList;
    }

    public void setPhotosArrayList(ArrayList<String> photosArrayList) {
        this.photosArrayList = photosArrayList;
    }

    public ArrayList<Attributes> getAttributesArrayList() {
        return attributesArrayList;
    }

    public void setAttributesArrayList(ArrayList<Attributes> attributesArrayList) {
        this.attributesArrayList = attributesArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ad_id);
        dest.writeString(ad_title);
        dest.writeString(ad_description);
        dest.writeString(ad_price);
        dest.writeString(ad_phone);
        dest.writeString(ad_time_post);
        dest.writeString(ad_category_id);
        dest.writeString(ad_category_name_en);
        dest.writeString(ad_category_name_ar);
        dest.writeStringList(photosArrayList);
        dest.writeTypedList(attributesArrayList);
    }
}
