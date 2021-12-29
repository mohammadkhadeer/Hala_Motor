package com.cars.halamotor_obeidat.functions;

import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;

public class FCSFunctions {

    public static SuggestedItem handelNumberOfObject(DocumentSnapshot dataSnapshot,String category) {
        ArrayList<String> imagePaths = new ArrayList<>();
        SuggestedItem suggestedItem = null;
        if (category.equals("Car for sale")
                ||category.equals("Car for rent")
                ||category.equals("Exchange car")
                ||category.equals("Motorcycle")
                ||category.equals("Trucks")
        ) {
            String idInDatabase = (String) dataSnapshot.getString("itemID");
            String itemBoostType = "empty";
            String itemType = (String) dataSnapshot.getString("categoryName");

            String itemPersonGallery = (String) dataSnapshot.getString("personOrGallery");
            String itemIdInServer = (String) dataSnapshot.getString("itemID");
            String itemCarMake = (String) dataSnapshot.getString("carMake");
            String itemCarModel = (String) dataSnapshot.getString("carModel");
            String itemCarYear = (String) dataSnapshot.getString("year");

            String itemCarCondition = (String) dataSnapshot.getString("condition");
            String itemCarKilometers = (String) dataSnapshot.getString("kilometers");
            String itemCarTransmission = (String) dataSnapshot.getString("transmission");
            String itemCarFuel = (String) dataSnapshot.getString("fuel");
            String itemCarLicense = (String) dataSnapshot.getString("carLicense");

            String itemCarInsurance = (String) dataSnapshot.getString("insurance");
            String itemCarColor = (String) dataSnapshot.getString("color");
            String itemCarPaymentMethod = (String) dataSnapshot.getString("paymentMethod");
            String itemCarOptions = (String) dataSnapshot.getString("carOptions");
            String itemNumberOfComment = "0";

            String itemNumberOfImage = "0";
            String itemCity = (String) dataSnapshot.getString("city");
            String itemNeighborhood = (String) dataSnapshot.getString("neighborhood");
            String itemTimePost = (String) dataSnapshot.getString("timePost");
            String itemUserPhoneNumber = (String) dataSnapshot.getString("phoneNumber");

            String itemName = (String) dataSnapshot.getString("itemName");
            imagePaths = (ArrayList<String>) dataSnapshot.get("imagePathArrayL");
            String itemImage;
            if (imagePaths.size()==0)
            {
                itemImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
            }else{
                 itemImage = imagePaths.get(0);
            }
            String itemDescription = (String) dataSnapshot.getString("itemDescription");
            String userImage = (String) dataSnapshot.getString("userImage");
            String userName = (String) dataSnapshot.getString("userName");

            String itemPostEdit = (String) dataSnapshot.getString("postEdit");
            String itemNewPrice = (String) dataSnapshot.getString("newPrice");
            String itemWheelsSize = "empty";
            String itemCarPlatesCity = "empty";
            String itemCarPlatesNumber = "empty";

            String itemCarPlatesSpecial = "empty";
            Long itemBurnedPrice = (Long) dataSnapshot.getLong("burnedPrice");
            Long itemPrice = (Long) dataSnapshot.getLong("price");
            String itemActiveOrNotT = (String) dataSnapshot.getString("activeOrNotS");
            Long itemActiveOrNot = Long.parseLong(itemActiveOrNotT);
            String userID = (String) dataSnapshot.getString("userIDPathInServer");

//            Log.i("TAG","itemID  "+idInDatabase);
//            Log.i("TAG","itemBoostType  "+itemBoostType);
//            Log.i("TAG","itemType  "+itemType);
//            Log.i("TAG","itemPersonGallery  "+itemPersonGallery);
//            Log.i("TAG","itemIdInServer  "+itemIdInServer);
//            Log.i("TAG","itemCarMake  "+itemCarMake);
//            Log.i("TAG","itemCarModel  "+itemCarModel);
//            Log.i("TAG","itemCarYear  "+itemCarYear);
//            Log.i("TAG","itemCarCondition  "+itemCarCondition);
//            Log.i("TAG","itemCarKilometers  "+itemCarKilometers);
//            Log.i("TAG","itemCarTransmission  "+itemCarTransmission);
//            Log.i("TAG","itemCarFuel  "+itemCarFuel);
//            Log.i("TAG","itemCarLicense  "+itemCarLicense);
//            Log.i("TAG","itemCarInsurance  "+itemCarInsurance);
//            Log.i("TAG","itemCarColor  "+itemCarColor);
//
//            Log.i("TAG","itemCarPaymentMethod  "+itemCarPaymentMethod);
//            Log.i("TAG","itemCarOptions  "+itemCarOptions);
//            Log.i("TAG","itemNumberOfComment  "+itemNumberOfComment);
//            Log.i("TAG","itemNumberOfImage  "+itemNumberOfImage);
//            Log.i("TAG","itemCity  "+itemCity);
//            Log.i("TAG","itemNeighborhood  "+itemNeighborhood);
//            Log.i("TAG","itemTimePost  "+itemTimePost);
//            Log.i("TAG","itemUserPhoneNumber  "+itemUserPhoneNumber);
//            Log.i("TAG","itemName  "+itemName);
//            Log.i("TAG","itemImage  "+itemImage);
//
//            Log.i("TAG","itemDescription  "+itemDescription);
//            Log.i("TAG","userImage  "+userImage);
//            Log.i("TAG","userName  "+userName);
//            Log.i("TAG","itemPostEdit  "+itemPostEdit);
//            Log.i("TAG","itemNewPrice  "+itemNewPrice);
//            Log.i("TAG","itemWheelsSize  "+itemWheelsSize);
//            Log.i("TAG","itemCarPlatesCity  "+itemCarPlatesCity);
//            Log.i("TAG","itemCarPlatesNumber  "+itemCarPlatesNumber);
//            Log.i("TAG","itemCarPlatesSpecial  "+itemCarPlatesSpecial);
//            Log.i("TAG","itemBurnedPrice  "+String.valueOf(itemBurnedPrice));
//            Log.i("TAG","************  "+itemPrice);
//            Log.i("TAG","itemActiveOrNot  "+String.valueOf(itemActiveOrNot));
//            Log.i("TAG","userID  "+userID);

            suggestedItem = new SuggestedItem(
                    idInDatabase
                    ,itemBoostType
                    ,itemType

                    ,itemPersonGallery
                    ,itemIdInServer
                    ,itemCarMake
                    ,itemCarModel
                    ,itemCarYear

                    ,itemCarCondition
                    ,itemCarKilometers
                    ,itemCarTransmission
                    ,itemCarFuel
                    ,itemCarLicense

                    ,itemCarInsurance
                    ,itemCarColor
                    ,itemCarPaymentMethod
                    ,itemCarOptions
                    ,itemNumberOfComment

                    ,itemNumberOfImage
                    ,itemCity
                    ,itemNeighborhood
                    ,itemTimePost
                    ,itemUserPhoneNumber

                    ,itemName
                    ,itemImage
                    ,itemDescription
                    ,userImage
                    ,userName

                    ,itemPostEdit
                    ,itemNewPrice
                    ,itemWheelsSize
                    ,itemCarPlatesCity
                    ,itemCarPlatesNumber

                    ,itemCarPlatesSpecial
                    ,String.valueOf(itemBurnedPrice)
                    ,String.valueOf(itemPrice)
                    ,userID
                    ,String.valueOf(itemActiveOrNot)

            );
        }
        if (category.equals("Plates"))
        {
            //BoostPost boostPost = dataSnapshot.child("boostPostsArrayL").child("0").getValue(BoostPost.class);
            String itemBoostType = "empty";
            String itemPersonGallery = (String) dataSnapshot.getString("personOrGallery");
            String itemIdInServer = (String) dataSnapshot.getString("itemID");

            String itemCity = (String) dataSnapshot.getString("city");
            String itemNeighborhood = (String) dataSnapshot.getString("neighborhood");
            String itemTimePost = (String) dataSnapshot.getString("timePost");
            String itemUserPhoneNumber = (String) dataSnapshot.getString("phoneNumber");

            String itemName = (String) dataSnapshot.getString("itemName");
            imagePaths = (ArrayList<String>) dataSnapshot.get("imagePathArrayL");
            String itemImage;
            if (imagePaths.size()==0)
            {
                itemImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
            }else{
                itemImage = imagePaths.get(0);
            }
            String itemDescription = (String) dataSnapshot.getString("itemDescription");
            String userImage = (String) dataSnapshot.getString("userImage");
            String userName = (String) dataSnapshot.getString("userName");

            String itemPostEdit = (String) dataSnapshot.getString("postEdit");
            String itemNewPrice = (String) dataSnapshot.getString("newPrice");

            String carPlatesCity = (String) dataSnapshot.getString("carPlatesCity");
            String carPlatesNumber = (String) dataSnapshot.getString("carPlatesNumber");
            Long specialOrNot = (Long) dataSnapshot.getLong("specialOrNot");

            Long itemBurnedPrice = (Long) dataSnapshot.getLong("burnedPrice");
            Long itemPrice = (Long) dataSnapshot.getLong("price");
            String userID = (String) dataSnapshot.getString("userIDPathInServer");
            String itemActiveOrNot = (String) dataSnapshot.getString("activeOrNotS");

            suggestedItem = new SuggestedItem(
                    itemBoostType
                    ,itemBoostType
                    ,"Plates"
                    ,itemPersonGallery
                    ,itemIdInServer
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
                    ,"0"
                    ,"0"
                    ,itemCity
                    ,itemNeighborhood
                    ,itemTimePost
                    ,itemUserPhoneNumber
                    ,itemName
                    ,itemImage
                    ,itemDescription
                    ,userImage
                    ,userName
                    ,itemPostEdit
                    ,itemNewPrice
                    ,"empty"
                    ,carPlatesCity
                    ,carPlatesNumber
                    , String.valueOf(specialOrNot)
                    , String.valueOf(itemBurnedPrice)
                    , String.valueOf(itemPrice)
                    , userID
                    , String.valueOf(itemActiveOrNot)

            );
        }
        if (category.equals("Wheels_Rim"))
        {
            //BoostPost boostPost = dataSnapshot.child("boostPostsArrayL").child("0").getValue(BoostPost.class);
            String itemBoostType = "empty";
            String itemPersonGallery = (String) dataSnapshot.getString("personOrGallery");
            String itemIdInServer = (String) dataSnapshot.getString("itemID");

            String itemCity = (String) dataSnapshot.getString("city");
            String itemNeighborhood = (String) dataSnapshot.getString("neighborhood");
            String itemTimePost = (String) dataSnapshot.getString("timePost");
            String itemUserPhoneNumber = (String) dataSnapshot.getString("phoneNumber");

            String itemName = (String) dataSnapshot.getString("itemName");
            imagePaths = (ArrayList<String>) dataSnapshot.get("imagePathArrayL");
            String itemImage;
            if (imagePaths.size()==0)
            {
                itemImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
            }else{
                itemImage = imagePaths.get(0);
            }            String itemDescription = (String) dataSnapshot.getString("itemDescription");
            String userImage = (String) dataSnapshot.getString("userImage");
            String userName = (String) dataSnapshot.getString("userName");

            String itemPostEdit = (String) dataSnapshot.getString("postEdit");
            String itemNewPrice = (String) dataSnapshot.getString("newPrice");
            Long itemWheelsSize = (Long) dataSnapshot.getLong("wheelSizeInt");
            Long itemBurnedPrice = (Long) dataSnapshot.getLong("burnedPrice");
            Long itemPrice = (Long) dataSnapshot.getLong("price");
            String userID = (String) dataSnapshot.getString("userIDPathInServer");
            String itemActiveOrNot = (String) dataSnapshot.getString("activeOrNotS");

            suggestedItem = new SuggestedItem(
                    itemBoostType
                    ,itemBoostType
                    ,"Wheels_Rim"
                    ,itemPersonGallery
                    ,itemIdInServer
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
                    ,"0"
                    ,"0"
                    ,itemCity
                    ,itemNeighborhood
                    ,itemTimePost
                    ,itemUserPhoneNumber
                    ,itemName
                    ,itemImage
                    ,itemDescription
                    ,userImage
                    ,userName
                    ,itemPostEdit
                    ,itemNewPrice
                    ,String.valueOf(itemWheelsSize)
                    ,"empty"
                    ,"empty"
                    , "empty"
                    , String.valueOf(itemBurnedPrice)
                    , String.valueOf(itemPrice)
                    , userID
                    , String.valueOf(itemActiveOrNot)

            );
        }
        if (category.equals("Accessories") || category.equals("Junk car"))
        {
            //BoostPost boostPost = dataSnapshot.child("boostPostsArrayL").child("0").getValue(BoostPost.class);
            String itemBoostType = "empty";
            String itemPersonGallery = (String) dataSnapshot.getString("personOrGallery");
            String itemIdInServer = (String) dataSnapshot.getString("itemID");

            String itemCity = (String) dataSnapshot.getString("city");
            String itemNeighborhood = (String) dataSnapshot.getString("neighborhood");
            String itemTimePost = (String) dataSnapshot.getString("timePost");
            String itemUserPhoneNumber = (String) dataSnapshot.getString("phoneNumber");

            String itemName = (String) dataSnapshot.getString("itemName");
            imagePaths = (ArrayList<String>) dataSnapshot.get("imagePathArrayL");
            String itemImage;
            if (imagePaths.size()==0)
            {
                itemImage = "https://firebasestorage.googleapis.com/v0/b/hala-motor.appspot.com/o/images%2FnoImage.png?alt=media&token=4e02ba52-69dd-447b-9c66-4a26df53a80d";
            }else{
                itemImage = imagePaths.get(0);
            }            String itemDescription = (String) dataSnapshot.getString("itemDescription");
            String userImage = (String) dataSnapshot.getString("userImage");
            String userName = (String) dataSnapshot.getString("userName");

            String itemPostEdit = (String) dataSnapshot.getString("postEdit");
            String itemNewPrice = (String) dataSnapshot.getString("newPrice");
            Long itemBurnedPrice = (Long) dataSnapshot.getLong("burnedPrice");
            Long itemPrice = (Long) dataSnapshot.getLong("price");
            String userID = (String) dataSnapshot.getString("userIDPathInServer");
            String itemActiveOrNot = (String) dataSnapshot.getString("activeOrNotS");

            suggestedItem = new SuggestedItem(
                    itemBoostType
                    ,itemBoostType
                    ,category
                    ,itemPersonGallery
                    ,itemIdInServer
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
                    ,"0"
                    ,"0"
                    ,itemCity
                    ,itemNeighborhood
                    ,itemTimePost
                    ,itemUserPhoneNumber
                    ,itemName
                    ,itemImage
                    ,itemDescription
                    ,userImage
                    ,userName
                    ,itemPostEdit
                    ,itemNewPrice
                    ,"empty"
                    ,"empty"
                    ,"empty"
                    , "empty"
                    , String.valueOf(itemBurnedPrice)
                    , String.valueOf(itemPrice)
                    , userID
                    , String.valueOf(itemActiveOrNot)

            );
        }
        return suggestedItem;
    }

    public static String convertCat(String category){
        String CategoryAfterConvert = null;
        if (category.equals("Car for sale"))
        {
            CategoryAfterConvert = "Car_For_Sale";
        }
        if (category.equals("Car for rent"))
        {
            CategoryAfterConvert = "Car_For_Rent";
        }
        if (category.equals("Exchange car"))
        {
            CategoryAfterConvert = "Car_For_Exchange";
        }
        if (category.equals("Motorcycle"))
        {
            CategoryAfterConvert = "Motorcycle";
        }
        if (category.equals("Trucks"))
        {
            CategoryAfterConvert = "Trucks";
        }
        if (category.equals("Plates"))
        {
            CategoryAfterConvert = "Plates";
        }
        if (category.equals("Wheels_Rim"))
        {
            CategoryAfterConvert = "Wheels_Rim";
        }
        if (category.equals("Accessories"))
        {
            CategoryAfterConvert = "Accessories";
        }
        if (category.equals("Junk car"))
        {
            CategoryAfterConvert = "JunkCar";
        }
        return CategoryAfterConvert;
    }
}
