package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CCEMT implements Parcelable {

    String itemID,city,neighborhood,userToken,timePost,phoneNumber,itemName,itemDescription
            ,userImage,userName,auctionPath,postEdit,newPrice,numberOfEdit,videoPath
            ,categoryName,subCategory
            ,carMake
            ,carModel
            ,year
            ,condition
            ,kilometers
            ,transmission
            ,fuel
            ,carLicense
            ,insurance
            ,color
            ,paymentMethod
            ,carOptions
            ,personOrGallery
            ,timeStamp,userIDPathInServer;
    ArrayList<String> reportDescriptionArrayL = new ArrayList<String>();
    ArrayList<String> imagePathArrayL = new ArrayList<String>();
    ArrayList<CommentsComp> commentsArrayL = new ArrayList<CommentsComp>();
    ArrayList<String> watchersArrayL = new ArrayList<String>();
    ArrayList<BoostPost> boostPostsArrayL = new ArrayList<BoostPost>();
    int auctionOrNot,burnedPrice,reportsOrNot,numberOfReports,activeOrNot,yearDate,monthDate,dayDate;
    Double price,fromKilometers,toKilometers;

    public CCEMT(){}

    public CCEMT(String itemID, String city, String neighborhood, String userToken, String timePost, String phoneNumber, String itemName, String itemDescription, String userImage, String userName, String auctionPath, String postEdit, String newPrice, String numberOfEdit, String videoPath, String categoryName, String subCategory, String carMake, String carModel, String year, String condition, String kilometers, String transmission, String fuel, String carLicense, String insurance, String color, String paymentMethod, String carOptions, String personOrGallery, String timeStamp, String userIDPathInServer, ArrayList<String> reportDescriptionArrayL, ArrayList<String> imagePathArrayL, ArrayList<CommentsComp> commentsArrayL, ArrayList<String> watchersArrayL, ArrayList<BoostPost> boostPostsArrayL, int auctionOrNot, int burnedPrice, int reportsOrNot, int numberOfReports, int activeOrNot, int yearDate, int monthDate, int dayDate, Double price, Double fromKilometers, Double toKilometers) {
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
        this.auctionPath = auctionPath;
        this.postEdit = postEdit;
        this.newPrice = newPrice;
        this.numberOfEdit = numberOfEdit;
        this.videoPath = videoPath;
        this.categoryName = categoryName;
        this.subCategory = subCategory;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.condition = condition;
        this.kilometers = kilometers;
        this.transmission = transmission;
        this.fuel = fuel;
        this.carLicense = carLicense;
        this.insurance = insurance;
        this.color = color;
        this.paymentMethod = paymentMethod;
        this.carOptions = carOptions;
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
        this.price = price;
        this.fromKilometers = fromKilometers;
        this.toKilometers = toKilometers;
    }

    protected CCEMT(Parcel in) {
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
        auctionPath = in.readString();
        postEdit = in.readString();
        newPrice = in.readString();
        numberOfEdit = in.readString();
        videoPath = in.readString();
        categoryName = in.readString();
        subCategory = in.readString();
        carMake = in.readString();
        carModel = in.readString();
        year = in.readString();
        condition = in.readString();
        kilometers = in.readString();
        transmission = in.readString();
        fuel = in.readString();
        carLicense = in.readString();
        insurance = in.readString();
        color = in.readString();
        paymentMethod = in.readString();
        carOptions = in.readString();
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
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readDouble();
        }
        if (in.readByte() == 0) {
            fromKilometers = null;
        } else {
            fromKilometers = in.readDouble();
        }
        if (in.readByte() == 0) {
            toKilometers = null;
        } else {
            toKilometers = in.readDouble();
        }
    }

    public static final Creator<CCEMT> CREATOR = new Creator<CCEMT>() {
        @Override
        public CCEMT createFromParcel(Parcel in) {
            return new CCEMT(in);
        }

        @Override
        public CCEMT[] newArray(int size) {
            return new CCEMT[size];
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

    public String getAuctionPath() {
        return auctionPath;
    }

    public void setAuctionPath(String auctionPath) {
        this.auctionPath = auctionPath;
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

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(String carOptions) {
        this.carOptions = carOptions;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getFromKilometers() {
        return fromKilometers;
    }

    public void setFromKilometers(Double fromKilometers) {
        this.fromKilometers = fromKilometers;
    }

    public Double getToKilometers() {
        return toKilometers;
    }

    public void setToKilometers(Double toKilometers) {
        this.toKilometers = toKilometers;
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
        dest.writeString(auctionPath);
        dest.writeString(postEdit);
        dest.writeString(newPrice);
        dest.writeString(numberOfEdit);
        dest.writeString(videoPath);
        dest.writeString(categoryName);
        dest.writeString(subCategory);

        dest.writeString(carMake);
        dest.writeString(carModel);
        dest.writeString(year);
        dest.writeString(condition);
        dest.writeString(kilometers);
        dest.writeString(transmission);
        dest.writeString(fuel);
        dest.writeString(carLicense);
        dest.writeString(insurance);
        dest.writeString(color);
        dest.writeString(paymentMethod);
        dest.writeString(carOptions);

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
        dest.writeDouble(fromKilometers);
        dest.writeDouble(toKilometers);
    }
}
