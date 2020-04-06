package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CCEMTFirestCase implements Parcelable {

    String boostOrNot,boostType,type,personOrGallery,itemIdInServer
            ,itemCarMake,itemCarModel,itemCarYeay,itemCarCondition
            ,itemCarKilometers,itemCarTransmission,itemCarFuel
            ,ItemCarLicense,itemCarInsurance,itemCarColor,itemCarPaymentMethod
            ,itemCarOptions,itemNumberOfComments,itemNumberOfImage
            ,itemCity,itemNeighborhood,itemTimePost,itemUserPhoneNumber
            ,itemName,itemImage,itemDescription,itemUserImage,itemUserName
            ,itemPostEdit,itemNewPrice,itemBurnedPrice,itemPrice,itemActiveOrNot
            ,date,timeStamp;
//34
    public CCEMTFirestCase(String boostOrNot, String boostType, String type, String personOrGallery, String itemIdInServer, String itemCarMake, String itemCarModel, String itemCarYeay, String itemCarCondition, String itemCarKilometers, String itemCarTransmission, String itemCarFuel, String itemCarLicense, String itemCarInsurance, String itemCarColor, String itemCarPaymentMethod, String itemCarOptions, String itemNumberOfComments, String itemNumberOfImage, String itemCity, String itemNeighborhood, String itemTimePost, String itemUserPhoneNumber, String itemName, String itemImage, String itemDescription, String itemUserImage, String itemUserName, String itemPostEdit, String itemNewPrice, String itemBurnedPrice, String itemPrice, String itemActiveOrNot,String date,String timeStamp) {
        this.boostOrNot = boostOrNot;
        this.boostType = boostType;
        this.type = type;
        this.personOrGallery = personOrGallery;
        this.itemIdInServer = itemIdInServer;
        this.itemCarMake = itemCarMake;
        this.itemCarModel = itemCarModel;
        this.itemCarYeay = itemCarYeay;
        this.itemCarCondition = itemCarCondition;
        this.itemCarKilometers = itemCarKilometers;
        this.itemCarTransmission = itemCarTransmission;
        this.itemCarFuel = itemCarFuel;
        ItemCarLicense = itemCarLicense;
        this.itemCarInsurance = itemCarInsurance;
        this.itemCarColor = itemCarColor;
        this.itemCarPaymentMethod = itemCarPaymentMethod;
        this.itemCarOptions = itemCarOptions;
        this.itemNumberOfComments = itemNumberOfComments;
        this.itemNumberOfImage = itemNumberOfImage;
        this.itemCity = itemCity;
        this.itemNeighborhood = itemNeighborhood;
        this.itemTimePost = itemTimePost;
        this.itemUserPhoneNumber = itemUserPhoneNumber;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemDescription = itemDescription;
        this.itemUserImage = itemUserImage;
        this.itemUserName = itemUserName;
        this.itemPostEdit = itemPostEdit;
        this.itemNewPrice = itemNewPrice;
        this.itemBurnedPrice = itemBurnedPrice;
        this.itemPrice = itemPrice;
        this.itemActiveOrNot = itemActiveOrNot;
        this.date = date;
        this.timeStamp = timeStamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBoostOrNot() {
        return boostOrNot;
    }

    public void setBoostOrNot(String boostOrNot) {
        this.boostOrNot = boostOrNot;
    }

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPersonOrGallery() {
        return personOrGallery;
    }

    public void setPersonOrGallery(String personOrGallery) {
        this.personOrGallery = personOrGallery;
    }

    public String getItemIdInServer() {
        return itemIdInServer;
    }

    public void setItemIdInServer(String itemIdInServer) {
        this.itemIdInServer = itemIdInServer;
    }

    public String getItemCarMake() {
        return itemCarMake;
    }

    public void setItemCarMake(String itemCarMake) {
        this.itemCarMake = itemCarMake;
    }

    public String getItemCarModel() {
        return itemCarModel;
    }

    public void setItemCarModel(String itemCarModel) {
        this.itemCarModel = itemCarModel;
    }

    public String getItemCarYeay() {
        return itemCarYeay;
    }

    public void setItemCarYeay(String itemCarYeay) {
        this.itemCarYeay = itemCarYeay;
    }

    public String getItemCarCondition() {
        return itemCarCondition;
    }

    public void setItemCarCondition(String itemCarCondition) {
        this.itemCarCondition = itemCarCondition;
    }

    public String getItemCarKilometers() {
        return itemCarKilometers;
    }

    public void setItemCarKilometers(String itemCarKilometers) {
        this.itemCarKilometers = itemCarKilometers;
    }

    public String getItemCarTransmission() {
        return itemCarTransmission;
    }

    public void setItemCarTransmission(String itemCarTransmission) {
        this.itemCarTransmission = itemCarTransmission;
    }

    public String getItemCarFuel() {
        return itemCarFuel;
    }

    public void setItemCarFuel(String itemCarFuel) {
        this.itemCarFuel = itemCarFuel;
    }

    public String getItemCarLicense() {
        return ItemCarLicense;
    }

    public void setItemCarLicense(String itemCarLicense) {
        ItemCarLicense = itemCarLicense;
    }

    public String getItemCarInsurance() {
        return itemCarInsurance;
    }

    public void setItemCarInsurance(String itemCarInsurance) {
        this.itemCarInsurance = itemCarInsurance;
    }

    public String getItemCarColor() {
        return itemCarColor;
    }

    public void setItemCarColor(String itemCarColor) {
        this.itemCarColor = itemCarColor;
    }

    public String getItemCarPaymentMethod() {
        return itemCarPaymentMethod;
    }

    public void setItemCarPaymentMethod(String itemCarPaymentMethod) {
        this.itemCarPaymentMethod = itemCarPaymentMethod;
    }

    public String getItemCarOptions() {
        return itemCarOptions;
    }

    public void setItemCarOptions(String itemCarOptions) {
        this.itemCarOptions = itemCarOptions;
    }

    public String getItemNumberOfComments() {
        return itemNumberOfComments;
    }

    public void setItemNumberOfComments(String itemNumberOfComments) {
        this.itemNumberOfComments = itemNumberOfComments;
    }

    public String getItemNumberOfImage() {
        return itemNumberOfImage;
    }

    public void setItemNumberOfImage(String itemNumberOfImage) {
        this.itemNumberOfImage = itemNumberOfImage;
    }

    public String getItemCity() {
        return itemCity;
    }

    public void setItemCity(String itemCity) {
        this.itemCity = itemCity;
    }

    public String getItemNeighborhood() {
        return itemNeighborhood;
    }

    public void setItemNeighborhood(String itemNeighborhood) {
        this.itemNeighborhood = itemNeighborhood;
    }

    public String getItemTimePost() {
        return itemTimePost;
    }

    public void setItemTimePost(String itemTimePost) {
        this.itemTimePost = itemTimePost;
    }

    public String getItemUserPhoneNumber() {
        return itemUserPhoneNumber;
    }

    public void setItemUserPhoneNumber(String itemUserPhoneNumber) {
        this.itemUserPhoneNumber = itemUserPhoneNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemUserImage() {
        return itemUserImage;
    }

    public void setItemUserImage(String itemUserImage) {
        this.itemUserImage = itemUserImage;
    }

    public String getItemUserName() {
        return itemUserName;
    }

    public void setItemUserName(String itemUserName) {
        this.itemUserName = itemUserName;
    }

    public String getItemPostEdit() {
        return itemPostEdit;
    }

    public void setItemPostEdit(String itemPostEdit) {
        this.itemPostEdit = itemPostEdit;
    }

    public String getItemNewPrice() {
        return itemNewPrice;
    }

    public void setItemNewPrice(String itemNewPrice) {
        this.itemNewPrice = itemNewPrice;
    }

    public String getItemBurnedPrice() {
        return itemBurnedPrice;
    }

    public void setItemBurnedPrice(String itemBurnedPrice) {
        this.itemBurnedPrice = itemBurnedPrice;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemActiveOrNot() {
        return itemActiveOrNot;
    }

    public void setItemActiveOrNot(String itemActiveOrNot) {
        this.itemActiveOrNot = itemActiveOrNot;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(boostOrNot);
        dest.writeString(boostType);
        dest.writeString(type);
        dest.writeString(personOrGallery);
        dest.writeString(itemIdInServer);
        dest.writeString(itemCarMake);
        dest.writeString(itemCarModel);
        dest.writeString(itemCarYeay);
        dest.writeString(itemCarCondition);
        dest.writeString(itemCarKilometers);
        dest.writeString(itemCarTransmission);
        dest.writeString(ItemCarLicense);
        dest.writeString(itemCarInsurance);
        dest.writeString(itemCarColor);
        dest.writeString(itemCarPaymentMethod);
        dest.writeString(itemCarOptions);
        dest.writeString(itemNumberOfComments);
        dest.writeString(itemNumberOfImage);
        dest.writeString(itemCity);
        dest.writeString(itemNeighborhood);
        dest.writeString(itemTimePost);
        dest.writeString(itemUserPhoneNumber);
        dest.writeString(itemName);
        dest.writeString(itemImage);
        dest.writeString(itemDescription);
        dest.writeString(itemUserImage);
        dest.writeString(itemUserName);
        dest.writeString(itemPostEdit);
        dest.writeString(itemNewPrice);
        dest.writeString(itemBurnedPrice);
        dest.writeString(itemPrice);
        dest.writeString(itemActiveOrNot);
        dest.writeString(date);
        dest.writeString(timeStamp);
    }

}
