package com.cars.halamotor.dataBase;

import android.util.Log;

import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.AccAndJunkFirstCase;
import com.cars.halamotor.model.BoostPost;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.CommentsComp;
import com.cars.halamotor.model.Following;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.model.WheelsRimFirstCase;
import com.cars.halamotor.model.WheelsRimModel;
import java.util.ArrayList;

public class InsertFunctions {

    public static boolean insertFollowingTable(Following following, DBHelper database) {
        boolean isInserted = database.insertFollowing(
                following.getName()
                ,following.getImage()
                ,following.getUserID()
                ,following.getFollowID()
                ,following.getFollowerIDOtherSaid()
        );
        return isInserted;
    }

    public static boolean insertItemsToFCS(String itemID, String category, DBHelper database, String fcsType) {

        boolean isInserted = database.insertDataFCSItem(
                itemID
                ,category
                ,fcsType
        );
        return isInserted;
    }

    public static boolean insertCCEMTItemInCCEMTTable(ItemCCEMT ccemt, DBHelper database) {

        boolean isInserted = database.insertDataCCEMTItem(

                "empty"
                ,"empty"
                ,ccemt.getCategoryName()
                ,ccemt.getPersonOrGallery()
                ,ccemt.getItemID()

                ,ccemt.getCarMake()
                ,ccemt.getCarModel()
                ,ccemt.getYear()
                ,ccemt.getCondition()
                ,ccemt.getKilometers()
                ,ccemt.getTransmission()
                ,ccemt.getFuel()
                ,ccemt.getCarLicense()
                ,ccemt.getInsurance()
                ,ccemt.getColor()
                ,ccemt.getPaymentMethod()
                ,ccemt.getCarOptions()

                ,"3"
                ,numberOfImage(ccemt.getImagePathArrayL())
                ,ccemt.getCity()
                ,ccemt.getNeighborhood()
                ,ccemt.getTimePost()
                ,ccemt.getPhoneNumber()
                ,ccemt.getItemName()
                ,imagePath(ccemt.getImagePathArrayL())
                ,ccemt.getItemDescription()
                ,ccemt.getUserImage()
                ,ccemt.getUserName()
                ,ccemt.getPostEdit()
                ,ccemt.getNewPrice()
                , String.valueOf(ccemt.getBurnedPrice())
                , String.valueOf(ccemt.getPrice())
                , String.valueOf(ccemt.getUserIDPathInServer())
                , String.valueOf(ccemt.getAuctionOrNot())

                ,ccemt.getYearDate() + "/" + ccemt.getMonthDate() + "/" + ccemt.getDayDate()
                ,ccemt.getTimeStamp()
        );
        return isInserted;
    }

    public static boolean insertWheelsRimInWheelsRimTable(ItemWheelsRim wheelsRim, DBHelper database) {
        boolean isInserted = database.insertDataWheels_RimItem(

                "empty"
                ,"empty"
                , wheelsRim.getPersonOrGallery()
                , wheelsRim.getItemID()

                , wheelsRim.getWheelSize()

                , "3"
                , numberOfImage(wheelsRim.getImagePathArrayL())
                , wheelsRim.getCity()
                , wheelsRim.getNeighborhood()
                , wheelsRim.getTimePost()
                , wheelsRim.getPhoneNumber()
                , wheelsRim.getItemName()
                , imagePath(wheelsRim.getImagePathArrayL())
                , wheelsRim.getItemDescription()
                , wheelsRim.getUserImage()
                , wheelsRim.getUserName()
                , wheelsRim.getPostEdit()
                , wheelsRim.getNewPrice()
                , String.valueOf(wheelsRim.getBurnedPrice())
                , String.valueOf(wheelsRim.getPrice())
                , String.valueOf(wheelsRim.getUserIDPathInServer())
                , String.valueOf(wheelsRim.getActiveOrNot())

                , wheelsRim.getYearDate() + "/" +wheelsRim.getMonthDate() + "/" + wheelsRim.getDayDate()
                , wheelsRim.getTimeStamp()
        );
        return isInserted;
    }

    public static boolean insertCarPlatesItemInCarPlatesTable(ItemPlates carPlatesModel, DBHelper database) {
        boolean isInserted = database.insertDataCarPlatesItem(
                "empty"
                ,"empty"
                ,carPlatesModel.getPersonOrGallery()
                ,carPlatesModel.getItemID()

                , carPlatesModel.getCarPlatesCity()
                , String.valueOf(carPlatesModel.getCarPlatesNum())
                , String.valueOf(carPlatesModel.getSpecialOrNot())

                ,"2"
                ,numberOfImage(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getCity()
                ,carPlatesModel.getNeighborhood()
                ,carPlatesModel.getTimePost()
                ,carPlatesModel.getPhoneNumber()
                ,carPlatesModel.getItemName()
                ,imagePath(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getItemDescription()
                ,carPlatesModel.getUserImage()
                ,carPlatesModel.getUserName()
                ,carPlatesModel.getPostEdit()
                ,carPlatesModel.getNewPrice()
                , String.valueOf(carPlatesModel.getBurnedPrice())
                , String.valueOf(carPlatesModel.getPrice())
                , String.valueOf(carPlatesModel.getUserIDPathInServer())
                , String.valueOf(carPlatesModel.getActiveOrNot())

                , carPlatesModel.getYearDate() + "/" + carPlatesModel.getMonthDate() + "/" + carPlatesModel.getDayDate()
                , carPlatesModel.getTimeStamp()
        );
        return isInserted;
    }

    public static boolean insertAccAndJunkItemInAccAndJunkTable(ItemAccAndJunk accAndJunk, DBHelper database) {
    boolean isInserted = database.insertDataAccAndJunkItem(
            "empty"
            ,"empty"

            ,accAndJunk.getCategoryName()

            ,accAndJunk.getPersonOrGallery()
            ,accAndJunk.getItemID()

            ,"empty"
            ,numberOfImage(accAndJunk.getImagePathArrayL())
            ,accAndJunk.getCity()
            ,accAndJunk.getNeighborhood()
            ,accAndJunk.getTimePost()
            ,accAndJunk.getPhoneNumber()
            ,accAndJunk.getItemName()
            ,imagePath(accAndJunk.getImagePathArrayL())
            ,accAndJunk.getItemDescription()
            ,accAndJunk.getUserImage()
            ,accAndJunk.getUserName()
            ,accAndJunk.getPostEdit()
            ,accAndJunk.getNewPrice()
            ,accAndJunk.getUserIDPathInServer()

            , String.valueOf(accAndJunk.getBurnedPrice())
            , String.valueOf(accAndJunk.getPrice())
            , String.valueOf(accAndJunk.getActiveOrNot())

            , accAndJunk.getYearDate()+ "/" + accAndJunk.getMonthDate() + "/" + accAndJunk.getDayDate()
            , accAndJunk.getTimeStamp()
    );
    return isInserted;
}

    public static boolean insertNotificationTable(NotificationComp notificationComp,DBHelper database) {
        boolean isInserted = database.insertNotification(
                notificationComp.getProcess()
                ,notificationComp.getOpenOrNotYet()
                ,notificationComp.getNotificationTitle()
                ,notificationComp.getFromPersonOrGallery()
                ,notificationComp.getImagePath()
                ,notificationComp.getProcessImage()
                ,notificationComp.getTimeStamp()
                ,notificationComp.getItemServerID()
                ,notificationComp.getInOrOut()
                ,notificationComp.getAuctionORItem()
                ,notificationComp.getDate()
        );
        return isInserted;
    }

    //this table contain car_for_sale , car_for_rent ,car_for_exchange , motorcycle and truck
    public static boolean insertCCEMTItemTable(ItemCCEMT ccemt,DBHelper database) {

        boolean isInserted = database.insertDataItem(
                "empty"
                ,"empty"
                ,ccemt.getCategoryName()
                ,ccemt.getPersonOrGallery()
                ,ccemt.getItemID()
                ,ccemt.getCarMake()
                ,ccemt.getCarModel()
                ,ccemt.getYear()
                ,ccemt.getCondition()
                ,ccemt.getKilometers()
                ,ccemt.getTransmission()
                ,ccemt.getFuel()
                ,ccemt.getCarLicense()
                ,ccemt.getInsurance()
                ,ccemt.getColor()
                ,ccemt.getPaymentMethod()
                ,ccemt.getCarOptions()
                ,"1"
                ,numberOfImage(ccemt.getImagePathArrayL())
                ,ccemt.getCity()
                ,ccemt.getNeighborhood()
                ,ccemt.getTimeStamp()
                ,ccemt.getPhoneNumber()
                ,ccemt.getItemName()
                ,imagePath(ccemt.getImagePathArrayL())
                ,ccemt.getItemDescription()
                ,ccemt.getUserImage(),ccemt.getUserName()
                ,ccemt.getPostEdit()
                ,ccemt.getNewPrice()
                ,"0"
                ,"0"
                ,"0"
                ,"0"
                , String.valueOf(ccemt.getBurnedPrice())
                , String.valueOf(ccemt.getPrice())
                , String.valueOf(ccemt.getUserIDPathInServer())
                , String.valueOf(ccemt.getAuctionOrNot())
        );
        return isInserted;
    }

    public static boolean insertCarPlatesItemTable(ItemPlates carPlatesModel, DBHelper database) {
        boolean isInserted = database.insertDataItem(
                "empty"
                ,"empty"
                ,carPlatesModel.getCategoryName()
                ,carPlatesModel.getPersonOrGallery()
                ,carPlatesModel.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"4"
                ,numberOfImage(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getCity()
                ,carPlatesModel.getNeighborhood()
                ,carPlatesModel.getTimeStamp()
                ,carPlatesModel.getPhoneNumber()
                ,carPlatesModel.getItemName()
                ,imagePath(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getItemDescription()
                ,carPlatesModel.getUserImage()
                ,carPlatesModel.getUserName()
                ,carPlatesModel.getPostEdit()
                ,carPlatesModel.getNewPrice()
                ,"0"
                ,carPlatesModel.getCarPlatesCity()
                ,String.valueOf(carPlatesModel.getCarPlatesNum())
                , String.valueOf(carPlatesModel.getSpecialOrNot())
                , String.valueOf(carPlatesModel.getBurnedPrice())
                , String.valueOf(carPlatesModel.getPrice())
                , String.valueOf(carPlatesModel.getUserIDPathInServer())
                , String.valueOf(carPlatesModel.getActiveOrNot())
        );
        return isInserted;
    }

    public static boolean insertWheelsRimItemTable(ItemWheelsRim wheelsRim, DBHelper database) {
        boolean isInserted = database.insertDataItem(
                "empty"
                ,"empty"
                ,wheelsRim.getCategoryName()
                ,wheelsRim.getPersonOrGallery()
                ,wheelsRim.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"4"
                ,numberOfImage(wheelsRim.getImagePathArrayL())
                ,wheelsRim.getCity()
                ,wheelsRim.getNeighborhood()
                ,wheelsRim.getTimeStamp()
                ,wheelsRim.getPhoneNumber()
                ,wheelsRim.getItemName()
                ,imagePath(wheelsRim.getImagePathArrayL())
                ,wheelsRim.getItemDescription()
                ,wheelsRim.getUserImage()
                ,wheelsRim.getUserName()
                ,wheelsRim.getPostEdit()
                ,wheelsRim.getNewPrice()
                ,wheelsRim.getWheelSize()
                ,"empty"
                ,"empty"
                , "empty"
                , String.valueOf(wheelsRim.getBurnedPrice())
                , String.valueOf(wheelsRim.getPrice())
                , String.valueOf(wheelsRim.getUserIDPathInServer())
                , String.valueOf(wheelsRim.getActiveOrNot())
        );
        return isInserted;
    }

    public static boolean insertAccAndJunkTable(ItemAccAndJunk accAndJunk, DBHelper database) {
        boolean isInserted = database.insertDataItem(
                "empty"
                ,"empty"
                ,accAndJunk.getCategoryName()
                ,accAndJunk.getPersonOrGallery()
                ,accAndJunk.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,numberOfImage(accAndJunk.getImagePathArrayL())
                ,accAndJunk.getCity()
                ,accAndJunk.getNeighborhood()
                ,accAndJunk.getTimeStamp()
                ,accAndJunk.getPhoneNumber()
                ,accAndJunk.getItemName()
                ,imagePath(accAndJunk.getImagePathArrayL())
                ,accAndJunk.getItemDescription()
                ,accAndJunk.getUserImage()
                ,accAndJunk.getUserName()
                ,accAndJunk.getPostEdit()
                ,accAndJunk.getNewPrice()
                ,"empty"
                ,"empty"
                ,"empty"
                , "empty"
                , String.valueOf(accAndJunk.getBurnedPrice())
                , String.valueOf(accAndJunk.getPrice())
                , String.valueOf(accAndJunk.getUserIDPathInServer())
                , String.valueOf(accAndJunk.getActiveOrNot())
        );
        return isInserted;
    }


    //this table contain car_for_sale , car_for_rent ,car_for_exchange , motorcycle and truck
    public static boolean insertCCEMTSimilarTable(CCEMT ccemt,DBHelper database) {

        boolean isInserted = database.insertSimilarAds(
                boostOrNot(ccemt.getBoostPostsArrayL())
                ,itemBoostType(ccemt.getBoostPostsArrayL())
                ,ccemt.getCategoryName()
                ,ccemt.getPersonOrGallery()
                ,ccemt.getItemID()
                ,ccemt.getCarMake()
                ,ccemt.getCarModel()
                ,ccemt.getYear()
                ,ccemt.getCondition()
                ,ccemt.getKilometers()
                ,ccemt.getTransmission()
                ,ccemt.getFuel()
                ,ccemt.getCarLicense()
                ,ccemt.getInsurance()
                ,ccemt.getColor()
                ,ccemt.getPaymentMethod()
                ,ccemt.getCarOptions()
                ,numberOfComment(ccemt.getCommentsArrayL())
                ,numberOfImage(ccemt.getImagePathArrayL())
                ,ccemt.getCity()
                ,ccemt.getNeighborhood()
                ,ccemt.getTimePost()
                ,ccemt.getPhoneNumber()
                ,ccemt.getItemName()
                ,imagePath(ccemt.getImagePathArrayL())
                ,ccemt.getItemDescription()
                ,ccemt.getUserImage(),ccemt.getUserName()
                ,ccemt.getPostEdit()
                ,ccemt.getNewPrice()
                ,"0"
                ,"0"
                ,"0"
                ,"0"
                , String.valueOf(ccemt.getBurnedPrice())
                , String.valueOf(ccemt.getPrice())
                , String.valueOf(ccemt.getUserIDPathInServer())
                , String.valueOf(ccemt.getActiveOrNot())
        );
        return isInserted;
    }

    public static boolean insertCarPlatesSimilarTable(CarPlatesModel carPlatesModel, DBHelper database) {
        boolean isInserted = database.insertSimilarAds(
                boostOrNot(carPlatesModel.getBoostPostsArrayL())
                ,itemBoostType(carPlatesModel.getBoostPostsArrayL())
                ,carPlatesModel.getCategoryName()
                ,carPlatesModel.getPersonOrGallery()
                ,carPlatesModel.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,numberOfComment(carPlatesModel.getCommentsArrayL())
                ,numberOfImage(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getCity()
                ,carPlatesModel.getNeighborhood()
                ,carPlatesModel.getTimePost()
                ,carPlatesModel.getPhoneNumber()
                ,carPlatesModel.getItemName()
                ,imagePath(carPlatesModel.getImagePathArrayL())
                ,carPlatesModel.getItemDescription()
                ,carPlatesModel.getUserImage()
                ,carPlatesModel.getUserName()
                ,carPlatesModel.getPostEdit()
                ,carPlatesModel.getNewPrice()
                ,"0"
                ,carPlatesModel.getCarPlatesCity()
                ,String.valueOf(carPlatesModel.getCarPlatesNum())
                , String.valueOf(carPlatesModel.getSpecialOrNot())
                , String.valueOf(carPlatesModel.getBurnedPrice())
                , String.valueOf(carPlatesModel.getPrice())
                , String.valueOf(carPlatesModel.getUserIDPathInServer())
                , String.valueOf(carPlatesModel.getActiveOrNot())
        );
        return isInserted;
    }

    public static boolean insertWheelsRimSimilarTable(WheelsRimModel wheelsRim, DBHelper database) {
        boolean isInserted = database.insertSimilarAds(
                boostOrNot(wheelsRim.getBoostPostsArrayL())
                ,itemBoostType(wheelsRim.getBoostPostsArrayL())
                ,wheelsRim.getCategoryName()
                ,wheelsRim.getPersonOrGallery()
                ,wheelsRim.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,numberOfComment(wheelsRim.getCommentsArrayL())
                ,numberOfImage(wheelsRim.getImagePathArrayL())
                ,wheelsRim.getCity()
                ,wheelsRim.getNeighborhood()
                ,wheelsRim.getTimePost()
                ,wheelsRim.getPhoneNumber()
                ,wheelsRim.getItemName()
                ,imagePath(wheelsRim.getImagePathArrayL())
                ,wheelsRim.getItemDescription()
                ,wheelsRim.getUserImage()
                ,wheelsRim.getUserName()
                ,wheelsRim.getPostEdit()
                ,wheelsRim.getNewPrice()
                ,wheelsRim.getWheelSize()
                ,"empty"
                ,"empty"
                , "empty"
                , String.valueOf(wheelsRim.getBurnedPrice())
                , String.valueOf(wheelsRim.getPrice())
                , String.valueOf(wheelsRim.getUserIDPathInServer())
                , String.valueOf(wheelsRim.getActiveOrNot())
        );
        return isInserted;
    }

    public static boolean insertAccAndJunkSimilarTable(AccAndJunk accAndJunk, DBHelper database) {
        boolean isInserted = database.insertSimilarAds(
                boostOrNot(accAndJunk.getBoostPostsArrayL())
                ,itemBoostType(accAndJunk.getBoostPostsArrayL())
                ,accAndJunk.getCategoryName()
                ,accAndJunk.getPersonOrGallery()
                ,accAndJunk.getItemID()
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,"empty"
                ,numberOfComment(accAndJunk.getCommentsArrayL())
                ,numberOfImage(accAndJunk.getImagePathArrayL())
                ,accAndJunk.getCity()
                ,accAndJunk.getNeighborhood()
                ,accAndJunk.getTimePost()
                ,accAndJunk.getPhoneNumber()
                ,accAndJunk.getItemName()
                ,imagePath(accAndJunk.getImagePathArrayL())
                ,accAndJunk.getItemDescription()
                ,accAndJunk.getUserImage()
                ,accAndJunk.getUserName()
                ,accAndJunk.getPostEdit()
                ,accAndJunk.getNewPrice()
                ,"empty"
                ,"empty"
                ,"empty"
                , "empty"
                , String.valueOf(accAndJunk.getBurnedPrice())
                , String.valueOf(accAndJunk.getPrice())
                , String.valueOf(accAndJunk.getUserIDPathInServer())
                , String.valueOf(accAndJunk.getActiveOrNot())
        );
        return isInserted;
    }


    public static String boostOrNot(ArrayList<BoostPost> boostPostsArrayL) {
        String boostOrNotStr = null;
        if (boostPostsArrayL.size() == 1)
            return boostOrNotStr = "no";
        else
            return String.valueOf(boostPostsArrayL.size());
    }

    public static String itemBoostType(ArrayList<BoostPost> boostPostsArrayL) {
        String itemBoostTypeStr = null;
        if (boostPostsArrayL.size() == 1)
            return itemBoostTypeStr = "empty";
        else
            return boostPostsArrayL.get(boostPostsArrayL.size()).getBoostType();
    }

    public static String numberOfComment(ArrayList<CommentsComp> commentsCompsArrayL) {
        String itemBoostTypeStr = null;
        if (commentsCompsArrayL.size() == 1)
            return itemBoostTypeStr = "0";
        else
            return String.valueOf(commentsCompsArrayL.size());
    }

    public static String numberOfImage(ArrayList<String> imageArrayL) {
        String itemImageStr = null;
        if (imageArrayL.size() == 1)
            return itemImageStr = "1";
        else
            return String.valueOf(imageArrayL.size());
    }

    public static String imagePath(ArrayList<String> imageArrayL) {
        String itemImageStr = null;
        String noImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
        if (imageArrayL.isEmpty())
            return itemImageStr = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
        else
            return imageArrayL.get(0);
    }

}
