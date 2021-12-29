package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CommentsComp implements Parcelable {

    String commentContentStr,narratorTokenStr,narratorImageStr,commentTimeStampStr;

    public CommentsComp (){}

    public CommentsComp(String commentContentStr, String narratorTokenStr
            , String narratorImageStr, String commentTimeStampStr)
    {
        this.commentContentStr= commentContentStr;
        this.narratorTokenStr = narratorTokenStr;
        this.narratorImageStr = narratorImageStr;
        this.commentTimeStampStr = commentTimeStampStr;
    }

    protected CommentsComp(Parcel in) {
        commentContentStr = in.readString();
        narratorTokenStr = in.readString();
        narratorImageStr = in.readString();
        commentTimeStampStr = in.readString();
    }

    public static final Creator<CommentsComp> CREATOR = new Creator<CommentsComp>() {
        @Override
        public CommentsComp createFromParcel(Parcel in) {
            return new CommentsComp(in);
        }

        @Override
        public CommentsComp[] newArray(int size) {
            return new CommentsComp[size];
        }
    };

    public String getCommentContentStr() {
        return commentContentStr;
    }

    public void setCommentContentStr(String commentContentStr) {
        this.commentContentStr = commentContentStr;
    }

    public String getNarratorTokenStr() {
        return narratorTokenStr;
    }

    public void setNarratorTokenStr(String narratorTokenStr) {
        this.narratorTokenStr = narratorTokenStr;
    }

    public String getNarratorImageStr() {
        return narratorImageStr;
    }

    public void setNarratorImageStr(String narratorImageStr) {
        this.narratorImageStr = narratorImageStr;
    }

    public String getCommentTimeStampStr() {
        return commentTimeStampStr;
    }

    public void setCommentTimeStampStr(String commentTimeStampStr) {
        this.commentTimeStampStr = commentTimeStampStr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(commentContentStr);
        dest.writeString(narratorTokenStr);
        dest.writeString(narratorImageStr);
        dest.writeString(commentTimeStampStr);
    }
}
