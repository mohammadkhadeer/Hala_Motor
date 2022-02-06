package com.cars.halamotor_obeidat.model;

public class NotificationComp {
    String process,openOrNotYet,notificationTitle
            ,fromPersonOrGallery,imagePath,processImage,timeStamp,itemServerID
            , inOrOut,creator_name,creator_image,ads_des,category_id,date;

    public NotificationComp(String process, String openOrNotYet, String notificationTitle, String fromPersonOrGallery, String imagePath, String processImage, String timeStamp, String itemServerID, String inOrOut, String creator_name, String creator_image, String ads_des, String category_id, String date) {
        this.process = process;
        this.openOrNotYet = openOrNotYet;
        this.notificationTitle = notificationTitle;
        this.fromPersonOrGallery = fromPersonOrGallery;
        this.imagePath = imagePath;
        this.processImage = processImage;
        this.timeStamp = timeStamp;
        this.itemServerID = itemServerID;
        this.inOrOut = inOrOut;
        this.creator_name = creator_name;
        this.creator_image = creator_image;
        this.ads_des = ads_des;
        this.category_id = category_id;
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

    public String getCreator_name() {
        return creator_name;
    }

    public void setCreator_name(String creator_name) {
        this.creator_name = creator_name;
    }

    public String getCreator_image() {
        return creator_image;
    }

    public void setCreator_image(String creator_image) {
        this.creator_image = creator_image;
    }

    public String getAds_des() {
        return ads_des;
    }

    public void setAds_des(String ads_des) {
        this.ads_des = ads_des;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
