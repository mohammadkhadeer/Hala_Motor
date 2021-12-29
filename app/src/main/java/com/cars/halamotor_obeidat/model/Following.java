package com.cars.halamotor_obeidat.model;

public class Following {
    String name,image,userID, followID,followerIDOtherSaid;

    public Following(){}

    public Following(String name, String image, String userID, String followID,String followerIDOtherSaid) {
        this.name = name;
        this.image = image;
        this.userID = userID;
        this.followID = followID;
        this.followerIDOtherSaid = followerIDOtherSaid;
    }

    public String getFollowerIDOtherSaid() {
        return followerIDOtherSaid;
    }

    public void setFollowerIDOtherSaid(String followerIDOtherSaid) {
        this.followerIDOtherSaid = followerIDOtherSaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFollowID() {
        return followID;
    }

    public void setFollowID(String followID) {
        this.followID = followID;
    }
}
