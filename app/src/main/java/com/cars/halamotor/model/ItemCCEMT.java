package com.cars.halamotor.model;

import java.util.ArrayList;

public class ItemCCEMT {

    String itemID,city,neighborhood,userToken,timePost,phoneNumber,itemName,itemDescription
            ,userImage,userName,postEdit,newPrice,numberOfEdit,videoPath
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
    ArrayList<String> imagePathArrayL = new ArrayList<String>();

    int burnedPrice,numberOfReports,yearDate,monthDate,dayDate;
    Double price,fromKilometers,toKilometers;

    String auctionOrNot,categoryNameS,cityS,neighborhoodS,carMakeS,carModelS
            ,personOrGalleryS,paymentMethodS,fuelS,conditionS,insuranceS,carLicenseS;
    int yearS;

    String language;

    public ItemCCEMT(){}

    public ItemCCEMT(String itemID, String city, String neighborhood, String userToken, String timePost, String phoneNumber, String itemName, String itemDescription, String userImage, String userName, String postEdit, String newPrice, String numberOfEdit, String videoPath, String categoryName, String subCategory, String carMake, String carModel, String year, String condition, String kilometers, String transmission, String fuel, String carLicense, String insurance, String color, String paymentMethod, String carOptions, String personOrGallery, String timeStamp, String userIDPathInServer, ArrayList<String> imagePathArrayL, int burnedPrice, int numberOfReports, int yearDate, int monthDate, int dayDate, Double price, Double fromKilometers, Double toKilometers, String auctionOrNot, String categoryNameS, String cityS, String neighborhoodS, String carMakeS, String carModelS, String personOrGalleryS, String paymentMethodS, String fuelS, String conditionS, String insuranceS, String carLicenseS, int yearS, String language) {
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
        this.imagePathArrayL = imagePathArrayL;
        this.burnedPrice = burnedPrice;
        this.numberOfReports = numberOfReports;
        this.yearDate = yearDate;
        this.monthDate = monthDate;
        this.dayDate = dayDate;
        this.price = price;
        this.fromKilometers = fromKilometers;
        this.toKilometers = toKilometers;
        this.auctionOrNot = auctionOrNot;
        this.categoryNameS = categoryNameS;
        this.cityS = cityS;
        this.neighborhoodS = neighborhoodS;
        this.carMakeS = carMakeS;
        this.carModelS = carModelS;
        this.personOrGalleryS = personOrGalleryS;
        this.paymentMethodS = paymentMethodS;
        this.fuelS = fuelS;
        this.conditionS = conditionS;
        this.insuranceS = insuranceS;
        this.carLicenseS = carLicenseS;
        this.yearS = yearS;
        this.language = language;
    }

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

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
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

    public String getAuctionOrNot() {
        return auctionOrNot;
    }

    public void setAuctionOrNot(String auctionOrNot) {
        this.auctionOrNot = auctionOrNot;
    }

    public String getCategoryNameS() {
        return categoryNameS;
    }

    public void setCategoryNameS(String categoryNameS) {
        this.categoryNameS = categoryNameS;
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

    public String getCarMakeS() {
        return carMakeS;
    }

    public void setCarMakeS(String carMakeS) {
        this.carMakeS = carMakeS;
    }

    public String getCarModelS() {
        return carModelS;
    }

    public void setCarModelS(String carModelS) {
        this.carModelS = carModelS;
    }

    public String getPersonOrGalleryS() {
        return personOrGalleryS;
    }

    public void setPersonOrGalleryS(String personOrGalleryS) {
        this.personOrGalleryS = personOrGalleryS;
    }

    public String getPaymentMethodS() {
        return paymentMethodS;
    }

    public void setPaymentMethodS(String paymentMethodS) {
        this.paymentMethodS = paymentMethodS;
    }

    public String getFuelS() {
        return fuelS;
    }

    public void setFuelS(String fuelS) {
        this.fuelS = fuelS;
    }

    public String getConditionS() {
        return conditionS;
    }

    public void setConditionS(String conditionS) {
        this.conditionS = conditionS;
    }

    public String getInsuranceS() {
        return insuranceS;
    }

    public void setInsuranceS(String insuranceS) {
        this.insuranceS = insuranceS;
    }

    public String getCarLicenseS() {
        return carLicenseS;
    }

    public void setCarLicenseS(String carLicenseS) {
        this.carLicenseS = carLicenseS;
    }

    public int getYearS() {
        return yearS;
    }

    public void setYearS(int yearS) {
        this.yearS = yearS;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
