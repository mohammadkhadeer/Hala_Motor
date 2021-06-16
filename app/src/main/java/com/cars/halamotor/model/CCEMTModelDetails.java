package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CCEMTModelDetails implements Parcelable{

    CCEMTSmallObject ccemtSmallObject;
    CategoryComp categoryComp;
    ArrayList <String> photosArrayList;
    ArrayList <Attributes> attributesArrayList;

    public CCEMTModelDetails(CCEMTSmallObject ccemtSmallObject, CategoryComp categoryComp, ArrayList<String> photosArrayList, ArrayList<Attributes> attributesArrayList) {
        this.ccemtSmallObject = ccemtSmallObject;
        this.categoryComp = categoryComp;
        this.photosArrayList = photosArrayList;
        this.attributesArrayList = attributesArrayList;
    }

    protected CCEMTModelDetails(Parcel in) {
        ccemtSmallObject = in.readParcelable(CCEMTSmallObject.class.getClassLoader());
        categoryComp = in.readParcelable(CategoryComp.class.getClassLoader());
        photosArrayList = in.createStringArrayList();
        attributesArrayList = in.createTypedArrayList(Attributes.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(ccemtSmallObject, flags);
        dest.writeParcelable(categoryComp, flags);
        dest.writeStringList(photosArrayList);
        dest.writeTypedList(attributesArrayList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CCEMTModelDetails> CREATOR = new Creator<CCEMTModelDetails>() {
        @Override
        public CCEMTModelDetails createFromParcel(Parcel in) {
            return new CCEMTModelDetails(in);
        }

        @Override
        public CCEMTModelDetails[] newArray(int size) {
            return new CCEMTModelDetails[size];
        }
    };

    public CCEMTSmallObject getCcemtSmallObject() {
        return ccemtSmallObject;
    }

    public void setCcemtSmallObject(CCEMTSmallObject ccemtSmallObject) {
        this.ccemtSmallObject = ccemtSmallObject;
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
}
