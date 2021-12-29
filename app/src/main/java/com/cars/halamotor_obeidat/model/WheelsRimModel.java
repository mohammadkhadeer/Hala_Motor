package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class WheelsRimModel implements Parcelable {
    String itemID,city,neighborhood,userToken,timePost,phoneNumber,itemName,itemDescription
            ,userImage,userName,postEdit,newPrice,numberOfEdit,videoPath
            ,categoryName,subCategory
            ,wheelSize
            ,personOrGallery
            ,timeStamp,userIDPathInServer;
    ArrayList<String> reportDescriptionArrayL = new ArrayList<String>();
    ArrayList<String> imagePathArrayL = new ArrayList<String>();
    ArrayList<CommentsComp> commentsArrayL = new ArrayList<CommentsComp>();
    ArrayList<String> watchersArrayL = new ArrayList<String>();
    ArrayList<BoostPost> boostPostsArrayL = new ArrayList<BoostPost>();
    int auctionOrNot,burnedPrice,reportsOrNot,numberOfReports
            ,activeOrNot,yearDate,monthDate,dayDate,wheelSizeInt;
    Double price;

    public WheelsRimModel(){}

    public WheelsRimModel(String itemID, String city, String neighborhood, String userToken, String timePost, String phoneNumber, String itemName, String itemDescription, String userImage, String userName, String postEdit, String newPrice, String numberOfEdit, String videoPath, String categoryName, String subCategory, String wheelSize, String personOrGallery, String timeStamp, String userIDPathInServer, ArrayList<String> reportDescriptionArrayL, ArrayList<String> imagePathArrayL, ArrayList<CommentsComp> commentsArrayL, ArrayList<String> watchersArrayL, ArrayList<BoostPost> boostPostsArrayL, int auctionOrNot, int burnedPrice, int reportsOrNot, int numberOfReports, int activeOrNot, int yearDate, int monthDate, int dayDate, int wheelSizeInt, Double price) {
        this.itemID = itemID;
        this.city = city;
        this.neighborhood = neighborhood;
        this.userToken = userToken;
        this.timePost = timePost;
        this.phoneNumber = phoneNumber;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.userImage = userImage;
        this.userName = userName;
        this.postEdit = postEdit;
        this.newPrice = newPrice;
        this.numberOfEdit = numberOfEdit;
        this.videoPath = videoPath;
        this.categoryName = categoryName;
        this.subCategory = subCategory;
        this.wheelSize = wheelSize;
        this.personOrGallery = personOrGallery;
        this.timeStamp = timeStamp;
        this.userIDPathInServer = userIDPathInServer;
        this.reportDescriptionArrayL = reportDescriptionArrayL;
        this.imagePathArrayL = imagePathArrayL;
        this.commentsArrayL = commentsArrayL;
        this.watchersArrayL = watchersArrayL;
        this.boostPostsArrayL = boostPostsArrayL;
        this.auctionOrNot = auctionOrNot;
        this.burnedPrice = burnedPrice;
        this.reportsOrNot = reportsOrNot;
        this.numberOfReports = numberOfReports;
        this.activeOrNot = activeOrNot;
        this.yearDate = yearDate;
        this.monthDate = monthDate;
        this.dayDate = dayDate;
        this.wheelSizeInt = wheelSizeInt;
        this.price = price;
    }

    protected WheelsRimModel(Parcel in) {
        itemID = in.readString();
        city = in.readString();
        neighborhood = in.readString();
        userToken = in.readString();
        timePost = in.readString();
        phoneNumber = in.readString();
        itemName = in.readString();
        itemDescription = in.readString();
        userImage = in.readString();
        userName = in.readString();
        postEdit = in.readString();
        newPrice = in.readString();
        numberOfEdit = in.readString();
        videoPath = in.readString();
        categoryName = in.readString();
        subCategory = in.readString();
        wheelSize = in.readString();
        personOrGallery = in.readString();
        timeStamp = in.readString();
        userIDPathInServer = in.readString();
        reportDescriptionArrayL = in.createStringArrayList();
        imagePathArrayL = in.createStringArrayList();
        commentsArrayL = in.createTypedArrayList(CommentsComp.CREATOR);
        watchersArrayL = in.createStringArrayList();
        boostPostsArrayL = in.createTypedArrayList(BoostPost.CREATOR);
        auctionOrNot = in.readInt();
        burnedPrice = in.readInt();
        reportsOrNot = in.readInt();
        numberOfReports = in.readInt();
        activeOrNot = in.readInt();
        yearDate = in.readInt();
        monthDate = in.readInt();
        dayDate = in.readInt();
        wheelSizeInt = in.readInt();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
    }

    public static final Creator<WheelsRimModel> CREATOR = new Creator<WheelsRimModel>() {
        @Override
        public WheelsRimModel createFromParcel(Parcel in) {
            return new WheelsRimModel(in);
        }

        @Override
        public WheelsRimModel[] newArray(int size) {
            return new WheelsRimModel[size];
        }
    };

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostEdit() {
        return postEdit;
    }

    public void setPostEdit(String postEdit) {
        this.postEdit = postEdit;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getNumberOfEdit() {
        return numberOfEdit;
    }

    public void setNumberOfEdit(String numberOfEdit) {
        this.numberOfEdit = numberOfEdit;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getPersonOrGallery() {
        return personOrGallery;
    }

    public void setPersonOrGallery(String personOrGallery) {
        this.personOrGallery = personOrGallery;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserIDPathInServer() {
        return userIDPathInServer;
    }

    public void setUserIDPathInServer(String userIDPathInServer) {
        this.userIDPathInServer = userIDPathInServer;
    }

    public ArrayList<String> getReportDescriptionArrayL() {
        return reportDescriptionArrayL;
    }

    public void setReportDescriptionArrayL(ArrayList<String> reportDescriptionArrayL) {
        this.reportDescriptionArrayL = reportDescriptionArrayL;
    }

    public ArrayList<String> getImagePathArrayL() {
        return imagePathArrayL;
    }

    public void setImagePathArrayL(ArrayList<String> imagePathArrayL) {
        this.imagePathArrayL = imagePathArrayL;
    }

    public ArrayList<CommentsComp> getCommentsArrayL() {
        return commentsArrayL;
    }

    public void setCommentsArrayL(ArrayList<CommentsComp> commentsArrayL) {
        this.commentsArrayL = commentsArrayL;
    }

    public ArrayList<String> getWatchersArrayL() {
        return watchersArrayL;
    }

    public void setWatchersArrayL(ArrayList<String> watchersArrayL) {
        this.watchersArrayL = watchersArrayL;
    }

    public ArrayList<BoostPost> getBoostPostsArrayL() {
        return boostPostsArrayL;
    }

    public void setBoostPostsArrayL(ArrayList<BoostPost> boostPostsArrayL) {
        this.boostPostsArrayL = boostPostsArrayL;
    }

    public int getAuctionOrNot() {
        return auctionOrNot;
    }

    public void setAuctionOrNot(int auctionOrNot) {
        this.auctionOrNot = auctionOrNot;
    }

    public int getBurnedPrice() {
        return burnedPrice;
    }

    public void setBurnedPrice(int burnedPrice) {
        this.burnedPrice = burnedPrice;
    }

    public int getReportsOrNot() {
        return reportsOrNot;
    }

    public void setReportsOrNot(int reportsOrNot) {
        this.reportsOrNot = reportsOrNot;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public int getActiveOrNot() {
        return activeOrNot;
    }

    public void setActiveOrNot(int activeOrNot) {
        this.activeOrNot = activeOrNot;
    }

    public int getYearDate() {
        return yearDate;
    }

    public void setYearDate(int yearDate) {
        this.yearDate = yearDate;
    }

    public int getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(int monthDate) {
        this.monthDate = monthDate;
    }

    public int getDayDate() {
        return dayDate;
    }

    public void setDayDate(int dayDate) {
        this.dayDate = dayDate;
    }

    public int getWheelSizeInt() {
        return wheelSizeInt;
    }

    public void setWheelSizeInt(int wheelSizeInt) {
        this.wheelSizeInt = wheelSizeInt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemID);
        dest.writeString(city);
        dest.writeString(neighborhood);
        dest.writeString(userToken);
        dest.writeString(timePost);
        dest.writeString(phoneNumber);
        dest.writeString(itemName);
        dest.writeString(itemDescription);
        dest.writeString(userImage);
        dest.writeString(userName);
        dest.writeString(postEdit);
        dest.writeString(newPrice);
        dest.writeString(numberOfEdit);
        dest.writeString(videoPath);
        dest.writeString(categoryName);
        dest.writeString(subCategory);
        dest.writeString(wheelSize);
        dest.writeString(personOrGallery);
        dest.writeString(timeStamp);
        dest.writeString(userIDPathInServer);

        dest.writeStringList(reportDescriptionArrayL);
        dest.writeStringList(imagePathArrayL);
        dest.writeTypedList(commentsArrayL);
        dest.writeStringList(watchersArrayL);
        dest.writeTypedList(boostPostsArrayL);

        dest.writeInt(auctionOrNot);
        dest.writeInt(burnedPrice);
        dest.writeInt(reportsOrNot);
        dest.writeInt(numberOfReports);
        dest.writeInt(activeOrNot);
        dest.writeInt(yearDate);
        dest.writeInt(monthDate);
        dest.writeInt(dayDate);

        dest.writeDouble(price);
    }
}
