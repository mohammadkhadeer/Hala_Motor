package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ItemWheelsRim implements Parcelable {

    String itemID,city,neighborhood,userToken,timePost,phoneNumber,itemName,itemDescription
            ,userImage,userName,postEdit,newPrice,numberOfEdit,videoPath
            ,categoryName,subCategory
            ,wheelSize
            ,personOrGallery
            ,timeStamp,userIDPathInServer;
    ArrayList<String> imagePathArrayL = new ArrayList<String>();
    int burnedPrice,reportsOrNot,numberOfReports
            ,activeOrNot,yearDate,monthDate,dayDate,wheelSizeInt;
    Double price;
    String wheelsType;
    String activeOrNotS,wheelsTypeS,cityS,neighborhoodS,categoryNameS;
    String languageStr;

    public ItemWheelsRim(){}

    public ItemWheelsRim(String itemID, String city, String neighborhood, String userToken, String timePost, String phoneNumber, String itemName, String itemDescription, String userImage, String userName, String postEdit, String newPrice, String numberOfEdit, String videoPath, String categoryName, String subCategory, String wheelSize, String personOrGallery, String timeStamp, String userIDPathInServer, ArrayList<String> imagePathArrayL, int burnedPrice, int reportsOrNot, int numberOfReports, int activeOrNot, int yearDate, int monthDate, int dayDate, int wheelSizeInt, Double price,String wheelsType, String activeOrNotS, String wheelsTypeS, String cityS, String neighborhoodS, String categoryNameS,String languageStr) {
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
        this.imagePathArrayL = imagePathArrayL;
        this.burnedPrice = burnedPrice;
        this.reportsOrNot = reportsOrNot;
        this.numberOfReports = numberOfReports;
        this.activeOrNot = activeOrNot;
        this.yearDate = yearDate;
        this.monthDate = monthDate;
        this.dayDate = dayDate;
        this.wheelSizeInt = wheelSizeInt;
        this.price = price;
        this.wheelsType = wheelsType;
        this.activeOrNotS = activeOrNotS;
        this.wheelsTypeS = wheelsTypeS;
        this.cityS = cityS;
        this.neighborhoodS = neighborhoodS;
        this.categoryNameS = categoryNameS;
        this.languageStr = languageStr;
    }

    protected ItemWheelsRim(Parcel in) {
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
        imagePathArrayL = in.createStringArrayList();
        burnedPrice = in.readInt();
        wheelsType = in.readString();
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
        activeOrNotS = in.readString();
        wheelsTypeS = in.readString();
        cityS = in.readString();
        neighborhoodS = in.readString();
        categoryNameS = in.readString();
        languageStr = in.readString();
    }

    public static final Creator<ItemWheelsRim> CREATOR = new Creator<ItemWheelsRim>() {
        @Override
        public ItemWheelsRim createFromParcel(Parcel in) {
            return new ItemWheelsRim(in);
        }

        @Override
        public ItemWheelsRim[] newArray(int size) {
            return new ItemWheelsRim[size];
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

    public ArrayList<String> getImagePathArrayL() {
        return imagePathArrayL;
    }

    public void setImagePathArrayL(ArrayList<String> imagePathArrayL) {
        this.imagePathArrayL = imagePathArrayL;
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

    public String getWheelsType() {
        return wheelsType;
    }

    public void setWheelsType(String wheelsType) {
        this.wheelsType = wheelsType;
    }

    public String getActiveOrNotS() {
        return activeOrNotS;
    }

    public void setActiveOrNotS(String activeOrNotS) {
        this.activeOrNotS = activeOrNotS;
    }

    public String getWheelsTypeS() {
        return wheelsTypeS;
    }

    public void setWheelsTypeS(String wheelsTypeS) {
        this.wheelsTypeS = wheelsTypeS;
    }

    public String getCityS() {
        return cityS;
    }

    public void setCityS(String cityS) {
        this.cityS = cityS;
    }

    public String getNeighborhoodS() {
        return neighborhoodS;
    }

    public void setNeighborhoodS(String neighborhoodS) {
        this.neighborhoodS = neighborhoodS;
    }

    public String getCategoryNameS() {
        return categoryNameS;
    }

    public void setCategoryNameS(String categoryNameS) {
        this.categoryNameS = categoryNameS;
    }

    public String getLanguageStr() {
        return languageStr;
    }

    public void setLanguageStr(String languageStr) {
        this.languageStr = languageStr;
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

        dest.writeStringList(imagePathArrayL);

        dest.writeInt(burnedPrice);
        dest.writeInt(reportsOrNot);
        dest.writeInt(numberOfReports);
        dest.writeInt(activeOrNot);
        dest.writeInt(yearDate);
        dest.writeInt(monthDate);
        dest.writeInt(dayDate);
        dest.writeInt(wheelSizeInt);

        dest.writeDouble(price);
        dest.writeString(wheelsType);

        dest.writeString(activeOrNotS);
        dest.writeString(wheelsTypeS);
        dest.writeString(cityS);
        dest.writeString(neighborhoodS);
        dest.writeString(categoryNameS);
        dest.writeString(languageStr);
    }
}
