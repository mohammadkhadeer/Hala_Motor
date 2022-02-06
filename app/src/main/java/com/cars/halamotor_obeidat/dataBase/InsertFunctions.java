package com.cars.halamotor_obeidat.dataBase;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.model.BoostPost;
import com.cars.halamotor_obeidat.model.CarInformation;
import com.cars.halamotor_obeidat.model.CommentsComp;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.DriverInformation;
import com.cars.halamotor_obeidat.model.Following;
import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemCCEMT;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.cars.halamotor_obeidat.model.NotificationComp;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class InsertFunctions {

    public static boolean insertDriverProcessTable(DriverInformation driverInformation, DBHelper database) {
        boolean isInserted = database.insertDriverInfo(
                driverInformation.getDriverProcess().getProcessS()
                ,driverInformation.getDriverProcess().getProcess()
                ,driverInformation.getProcessContent().getProcessContent()
                ,driverInformation.getProcessContent().getProcessContentS()
                ,String.valueOf(driverInformation.isProcessStatus())
        );
        return isInserted;
    }

    public static boolean insertFollowingTable(CreatorInfo creatorInfo, DBHelper database) {
        boolean isInserted = database.insertFollowing(
                creatorInfo.getName()
                ,creatorInfo.getPhoto()
                ,creatorInfo.getUser_id()
                ,creatorInfo.getUser_id()
                ,creatorInfo.getUser_id()
        );
//        boolean isInserted = database.insertFollowing(
//                following.getName()
//                ,following.getImage()
//                ,following.getUserID()
//                ,following.getFollowID()
//                ,following.getFollowerIDOtherSaid()
//        );
        return isInserted;
    }

    public static boolean insertItemsToFCS(String itemID, String category, DBHelper database, String fcsType, Context context) {
        //remove item if already exist
        boolean isInserted =false;
        if (fcsType.equals("favorite"))
        {
            DBHelper dataBase = getDataBaseInstance(context);
            if (dataBase.CheckIsDataAlreadyInDBorNot(itemID))
            {
                dataBase.deleteFCS(itemID);
            }
             isInserted = database.insertDataFCSItem(
                    itemID
                    ,category
                    ,fcsType
            );
        }

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
                ,notificationComp.getCreator_name()
                ,notificationComp.getCreator_image()
                ,notificationComp.getAds_des()
                ,notificationComp.getCategory_id()
                ,notificationComp.getDate()
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
