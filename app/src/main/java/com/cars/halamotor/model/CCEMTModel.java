package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CCEMTModel implements Parcelable{

    String ad_id,ad_title,ad_description,ad_price,ad_phone,ad_time_post;
    CategoryComp categoryComp;
    ArrayList <String> photosArrayList;
    ArrayList <Attributes> attributesArrayList;
    CreatorInfo creatorInfo;

    public CCEMTModel(){}

    public CCEMTModel(String ad_id, String ad_title, String ad_description, String ad_price, String ad_phone, String ad_time_post, CategoryComp categoryComp, ArrayList<String> photosArrayList, ArrayList<Attributes> attributesArrayList, CreatorInfo creatorInfo) {
        this.ad_id = ad_id;
        this.ad_title = ad_title;
        this.ad_description = ad_description;
        this.ad_price = ad_price;
        this.ad_phone = ad_phone;
        this.ad_time_post = ad_time_post;
        this.categoryComp = categoryComp;
        this.photosArrayList = photosArrayList;
        this.attributesArrayList = attributesArrayList;
        this.creatorInfo = creatorInfo;
    }

    protected CCEMTModel(Parcel in) {
        ad_id = in.readString();
        ad_title = in.readString();
        ad_description = in.readString();
        ad_price = in.readString();
        ad_phone = in.readString();
        ad_time_post = in.readString();
        categoryComp = in.readParcelable(CategoryComp.class.getClassLoader());
        photosArrayList = in.createStringArrayList();
        attributesArrayList = in.createTypedArrayList(Attributes.CREATOR);
        creatorInfo = in.readParcelable(CreatorInfo.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ad_id);
        dest.writeString(ad_title);
        dest.writeString(ad_description);
        dest.writeString(ad_price);
        dest.writeString(ad_phone);
        dest.writeString(ad_time_post);
        dest.writeParcelable(categoryComp, flags);
        dest.writeStringList(photosArrayList);
        dest.writeTypedList(attributesArrayList);
        dest.writeParcelable(creatorInfo, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public CategoryComp getCategoryComp() {
        return categoryComp;
    }

    public void setCategoryComp(CategoryComp categoryComp) {
        this.categoryComp = categoryComp;
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

    public CreatorInfo getCreatorInfo() {
        return creatorInfo;
    }

    public void setCreatorInfo(CreatorInfo creatorInfo) {
        this.creatorInfo = creatorInfo;
    }
}
