package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CreatorInfo implements Parcelable {
    String name,ads_count,followers_count,following_count,type,photo;

    public CreatorInfo(){}

    public CreatorInfo(String name, String ads_count, String followers_count, String following_count, String type, String photo) {
        this.name = name;
        this.ads_count = ads_count;
        this.followers_count = followers_count;
        this.following_count = following_count;
        this.type = type;
        this.photo = photo;
    }

    protected CreatorInfo(Parcel in) {
        name = in.readString();
        ads_count = in.readString();
        followers_count = in.readString();
        following_count = in.readString();
        type = in.readString();
        photo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(ads_count);
        dest.writeString(followers_count);
        dest.writeString(following_count);
        dest.writeString(type);
        dest.writeString(photo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CreatorInfo> CREATOR = new Creator<CreatorInfo>() {
        @Override
        public CreatorInfo createFromParcel(Parcel in) {
            return new CreatorInfo(in);
        }

        @Override
        public CreatorInfo[] newArray(int size) {
            return new CreatorInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAds_count() {
        return ads_count;
    }

    public void setAds_count(String ads_count) {
        this.ads_count = ads_count;
    }

    public String getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(String followers_count) {
        this.followers_count = followers_count;
    }

    public String getFollowing_count() {
        return following_count;
    }

    public void setFollowing_count(String following_count) {
        this.following_count = following_count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
