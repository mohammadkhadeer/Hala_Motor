package com.cars.halamotor_obeidat.model;

public class ReportDetails {
    String reportType,reportTypeS,reportIDOnServer,userID,itemID,itemCategory,date,doneOrNot,seeOrNot;

    public ReportDetails(String reportType, String reportTypeS, String reportIDOnServer, String userID, String itemID, String itemCategory, String date, String doneOrNot, String seeOrNot) {
        this.reportType = reportType;
        this.reportTypeS = reportTypeS;
        this.reportIDOnServer = reportIDOnServer;
        this.userID = userID;
        this.itemID = itemID;
        this.itemCategory = itemCategory;
        this.date = date;
        this.doneOrNot = doneOrNot;
        this.seeOrNot = seeOrNot;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportTypeS() {
        return reportTypeS;
    }

    public void setReportTypeS(String reportTypeS) {
        this.reportTypeS = reportTypeS;
    }

    public String getReportIDOnServer() {
        return reportIDOnServer;
    }

    public void setReportIDOnServer(String reportIDOnServer) {
        this.reportIDOnServer = reportIDOnServer;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoneOrNot() {
        return doneOrNot;
    }

    public void setDoneOrNot(String doneOrNot) {
        this.doneOrNot = doneOrNot;
    }

    public String getSeeOrNot() {
        return seeOrNot;
    }

    public void setSeeOrNot(String seeOrNot) {
        this.seeOrNot = seeOrNot;
    }
}
