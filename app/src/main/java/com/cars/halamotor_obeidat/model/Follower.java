package com.cars.halamotor_obeidat.model;

public class Follower {
    String userName,userID,userToken,userImage,userEmail,userCity,userNeighborhood;

    Follower(){}

    public Follower(String userName, String userID, String userToken, String userImage, String userEmail, String userCity, String userNeighborhood) {
        this.userName = userName;
        this.userID = userID;
        this.userToken = userToken;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userCity = userCity;
        this.userNeighborhood = userNeighborhood;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserNeighborhood() {
        return userNeighborhood;
    }

    public void setUserNeighborhood(String userNeighborhood) {
        this.userNeighborhood = userNeighborhood;
    }
}
