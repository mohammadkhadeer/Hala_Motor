package com.cars.halamotor_obeidat.model;

public class NotificationComp {
    String process,openOrNotYet,notificationTitle
            ,fromPersonOrGallery,imagePath,processImage,timeStamp,itemServerID
            , inOrOut,AuctionORItem,date;

    public NotificationComp(String process, String openOrNotYet, String notificationTitle, String fromPersonOrGallery, String imagePath, String processImage, String timeStamp, String itemServerID, String inOrOut, String auctionORItem, String date) {
        this.process = process;
        this.openOrNotYet = openOrNotYet;
        this.notificationTitle = notificationTitle;
        this.fromPersonOrGallery = fromPersonOrGallery;
        this.imagePath = imagePath;
        this.processImage = processImage;
        this.timeStamp = timeStamp;
        this.itemServerID = itemServerID;
        this.inOrOut = inOrOut;
        AuctionORItem = auctionORItem;
        this.date = date;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getOpenOrNotYet() {
        return openOrNotYet;
    }

    public void setOpenOrNotYet(String openOrNotYet) {
        this.openOrNotYet = openOrNotYet;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getFromPersonOrGallery() {
        return fromPersonOrGallery;
    }

    public void setFromPersonOrGallery(String fromPersonOrGallery) {
        this.fromPersonOrGallery = fromPersonOrGallery;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getProcessImage() {
        return processImage;
    }

    public void setProcessImage(String processImage) {
        this.processImage = processImage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getItemServerID() {
        return itemServerID;
    }

    public void setItemServerID(String itemServerID) {
        this.itemServerID = itemServerID;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getAuctionORItem() {
        return AuctionORItem;
    }

    public void setAuctionORItem(String auctionORItem) {
        AuctionORItem = auctionORItem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
