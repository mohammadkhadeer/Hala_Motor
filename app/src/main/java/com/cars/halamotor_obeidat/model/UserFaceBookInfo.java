package com.cars.halamotor_obeidat.model;

public class UserFaceBookInfo {
    String firstNameStr,lastNameStr,emailStr,idStr,userBirthdayStr,userImageStr;

    public UserFaceBookInfo(String firstNameStr, String lastNameStr, String emailStr, String idStr, String userBirthdayStr, String userImageStr) {
        this.firstNameStr = firstNameStr;
        this.lastNameStr = lastNameStr;
        this.emailStr = emailStr;
        this.idStr = idStr;
        this.userBirthdayStr = userBirthdayStr;
        this.userImageStr = userImageStr;
    }

    public String getFirstNameStr() {
        return firstNameStr;
    }

    public void setFirstNameStr(String firstNameStr) {
        this.firstNameStr = firstNameStr;
    }

    public String getLastNameStr() {
        return lastNameStr;
    }

    public void setLastNameStr(String lastNameStr) {
        this.lastNameStr = lastNameStr;
    }

    public String getEmailStr() {
        return emailStr;
    }

    public void setEmailStr(String emailStr) {
        this.emailStr = emailStr;
    }

    public String getIsStr() {
        return idStr;
    }

    public void setIsStr(String isStr) {
        this.idStr = isStr;
    }

    public String getUserBirthdayStr() {
        return userBirthdayStr;
    }

    public void setUserBirthdayStr(String userBirthdayStr) {
        this.userBirthdayStr = userBirthdayStr;
    }

    public String getUserImageStr() {
        return userImageStr;
    }

    public void setUserImageStr(String userImageStr) {
        this.userImageStr = userImageStr;
    }
}
