package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BoostPost implements Parcelable {
    String boostType,postID;

    public BoostPost(){}

    public BoostPost(String boostType, String postID) {
        this.boostType = boostType;
        this.postID = postID;
    }

    protected BoostPost(Parcel in) {
        boostType = in.readString();
        postID = in.readString();
    }

    public static final Creator<BoostPost> CREATOR = new Creator<BoostPost>() {
        @Override
        public BoostPost createFromParcel(Parcel in) {
            return new BoostPost(in);
        }

        @Override
        public BoostPost[] newArray(int size) {
            return new BoostPost[size];
        }
    };

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(boostType);
        dest.writeString(postID);

    }
}
