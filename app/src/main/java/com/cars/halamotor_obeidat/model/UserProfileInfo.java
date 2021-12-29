package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserProfileInfo implements Parcelable {

    String userID,nameStr,userImageStr,surNameStr,emailStr,cityStr
            ,neighbourhoodStr
            ,numberOfAdvStr,userTokensStr;

    public UserProfileInfo(){}

    public UserProfileInfo(String userID,String nameStr, String userImageStr, String surNameStr, String emailStr, String cityStr, String neighbourhoodStr, String numberOfAdvStr, String userTokensStr) {
        this.userID = userID;
        this.nameStr = nameStr;
        this.userImageStr = userImageStr;
        this.surNameStr = surNameStr;
        this.emailStr = emailStr;
        this.cityStr = cityStr;
        this.neighbourhoodStr = neighbourhoodStr;
        this.numberOfAdvStr = numberOfAdvStr;
        this.userTokensStr = userTokensStr;
    }

    protected UserProfileInfo(Parcel in) {
        userID = in.readString();
        nameStr = in.readString();
        userImageStr = in.readString();
        surNameStr = in.readString();
        emailStr = in.readString();
        cityStr = in.readString();
        neighbourhoodStr = in.readString();
        numberOfAdvStr = in.readString();
        userTokensStr = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userID);
        dest.writeString(nameStr);
        dest.writeString(userImageStr);
        dest.writeString(surNameStr);
        dest.writeString(emailStr);
        dest.writeString(cityStr);
        dest.writeString(neighbourhoodStr);
        dest.writeString(numberOfAdvStr);
        dest.writeString(userTokensStr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserProfileInfo> CREATOR = new Creator<UserProfileInfo>() {
        @Override
        public UserProfileInfo createFromParcel(Parcel in) {
            return new UserProfileInfo(in);
        }

        @Override
        public UserProfileInfo[] newArray(int size) {
            return new UserProfileInfo[size];
        }
    };

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getUserImageStr() {
        return userImageStr;
    }

    public void setUserImageStr(String userImageStr) {
        this.userImageStr = userImageStr;
    }

    public String getSurNameStr() {
        return surNameStr;
    }

    public void setSurNameStr(String surNameStr) {
        this.surNameStr = surNameStr;
    }

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
    }

    public String getCityStr() {
        return cityStr;
    }

    public void setCityStr(String cityStr) {
        this.cityStr = cityStr;
    }

    public String getNeighbourhoodStr() {
        return neighbourhoodStr;
    }

    public void setNeighbourhoodStr(String neighbourhoodStr) {
        this.neighbourhoodStr = neighbourhoodStr;
    }

    public String getNumberOfAdvStr() {
        return numberOfAdvStr;
    }

    public void setNumberOfAdvStr(String numberOfAdvStr) {
        this.numberOfAdvStr = numberOfAdvStr;
    }

    public String getUserTokensStr() {
        return userTokensStr;
    }

    public void setUserTokensStr(String userTokensStr) {
        this.userTokensStr = userTokensStr;
    }
}
