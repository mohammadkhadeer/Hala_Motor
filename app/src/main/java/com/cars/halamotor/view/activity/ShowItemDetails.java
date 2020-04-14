package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.cars.halamotor.R;
import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.AccAndJunkFirstCase;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.WheelsRimFirstCase;
import com.cars.halamotor.model.WheelsRimModel;
import com.cars.halamotor.presnter.FavouriteChange;
import com.cars.halamotor.presnter.ItemModel;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentComments;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentContact;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentFollowUser;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentIDescriptionAndGeneralTips;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentImageSlider;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentItemSelectedDetails;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentShare;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentSimilarItems;
import com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.FragmentUserInfo;

import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getAccAndJunkObject;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getCCEMTObject;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getCarPlatesObject;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getWheelsSizeObject;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getAccAndJunkFirstCaseFromDB;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getCCEMTFirstCaseFromDB;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getCarPlatesFirstCaseFromDB;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getWheelsRimFirstCaseFromDB;

public class ShowItemDetails extends AppCompatActivity
         implements FavouriteChange , ItemModel {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appbar;
    FragmentUserInfo fragmentUserInfoAndMainButton = new FragmentUserInfo();
    FragmentItemSelectedDetails fragmentItemSelectedDetails = new FragmentItemSelectedDetails();
    FragmentIDescriptionAndGeneralTips fragmentIDescriptionAndGeneralTips = new FragmentIDescriptionAndGeneralTips();
    FragmentShare fragmentShare = new FragmentShare();
    FragmentSimilarItems fragmentSuggestedAntherItems = new FragmentSimilarItems();
    FragmentComments fragmentComments = new FragmentComments();
    FragmentFollowUser fragmentFollowUser = new FragmentFollowUser();
    FragmentImageSlider fragmentImageSlider = new FragmentImageSlider();
    FragmentContact fragmentContact = new FragmentContact();

    String category;

    CCEMT ccemtObject;
    CarPlatesModel carPlatesModel;
    WheelsRimModel wheelsRimModel;
    AccAndJunk accAndJunkObject;

    String itemIDStr,userNameStr,userImageStr,itemNameStr,timePostStr,postTypeStr
            ,dateStr,timStampStr,itemDescription,userID,itemImage,numberOfImage,whereCome
            ,categoryStr,cat,phoneNumber,price,priceEdit,newPrice;

    int numberOfChangeFromInterface;

    ItemModel itemModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_details);

        makeKeyBordDownEditText();
        //statusBarTransparent();
        itemModel = (ItemModel) this;
        inti();
        getItemIDFromIntent();
        intiObject();

        titleActionBar();

        intiSuggestedFragment();
        //intiCommentsFragment();

    }

    private void makeKeyBordDownEditText() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void intiObject() {
        category =categoryStr;

        if (category.equals("Car for sale")
                ||category.equals("Car for rent")
                ||category.equals("Exchange car")
                ||category.equals("Motorcycle")
                ||category.equals("Trucks")
        ) {
            cat = "ccemt";
            getCCEMTObject(categoryStr,itemIDStr,itemModel);
        }
        if (category.equals("Car plates"))
        {
            cat = "cp";
            getCarPlatesObject(categoryStr,itemIDStr,itemModel);
        }
        if (category.equals("Wheels rim"))
        {
            cat = "wr";
            getWheelsSizeObject(categoryStr,itemIDStr,itemModel);
        }
        if (category.equals("Accessories") || category.equals("Junk car"))
        {
            cat = "aaj";
            getAccAndJunkObject(categoryStr,itemIDStr,itemModel);
        }
    }

    private String getCategoryFromIntent() {
        Bundle bundle = getIntent().getExtras();
        String category =bundle.getString("category");
        return category;
    }


    private void intiImageSlider() {
        Bundle bundle = new Bundle();
        bundle.putString("itemIV", itemImage);
        bundle.putString("cat", cat);
        bundle.putString("price", price);
        bundle.putString("priceE", priceEdit);
        bundle.putString("newP", newPrice);

        if (cat.equals("ccemt"))
            bundle.putParcelable("object",ccemtObject);

        if (cat.equals("cp"))
            bundle.putParcelable("object",carPlatesModel);

        if (cat.equals("wr"))
            bundle.putParcelable("object",wheelsRimModel);

        if (cat.equals("aaj"))
            bundle.putParcelable("object",accAndJunkObject);

        fragmentImageSlider.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_image_slider_container, fragmentImageSlider);
        transaction.commit();
    }

    private void intiFollowUser() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getCategoryFromIntent());
        bundle.putString("userName", userNameStr);
        bundle.putString("userImage", userImageStr);
        bundle.putString("userID", userID);

        fragmentFollowUser.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_follow_user_container, fragmentFollowUser);
        transaction.commit();
    }

//    private void intiCommentsFragment() {
//
//        Bundle bundle = new Bundle();
//        bundle.putString("category", getCategoryFromIntent());
//        bundle.putString("itemID", itemIDStr);
//        bundle.putString("userID", userID);
//
//        fragmentComments.setArguments(bundle);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.selected_item_details_comments_container, fragmentComments);
//        transaction.commit();
//    }

    private void intiSuggestedFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getCategoryFromIntent());
        bundle.putString("itemID", itemIDStr);

        fragmentSuggestedAntherItems.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_suggested_container, fragmentSuggestedAntherItems);
        transaction.commit();
    }

    private void intiShareFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getResources().getString(R.string.sharjah));

        fragmentShare.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_share_container, fragmentShare);
        transaction.commit();
    }

    private void intiItemDescriptionAndGeneralTips() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getCategoryFromIntent());
        bundle.putString("itemDes", itemDescription);

        fragmentIDescriptionAndGeneralTips.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_des_general_container, fragmentIDescriptionAndGeneralTips);
        transaction.commit();
    }

    private void intiItemDetails() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getCategoryFromIntent());
        bundle.putString("itemID", itemIDStr);
        bundle.putString("cat", cat);

        if (cat.equals("ccemt"))
            bundle.putParcelable("object",ccemtObject);

        if (cat.equals("cp"))
            bundle.putParcelable("object",carPlatesModel);

        if (cat.equals("wr"))
            bundle.putParcelable("object",wheelsRimModel);

        if (cat.equals("aaj"))
            bundle.putParcelable("object",accAndJunkObject);

        fragmentItemSelectedDetails.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_container, fragmentItemSelectedDetails);
        transaction.commit();
    }

    private void intiContact() {
        Bundle bundle = new Bundle();
        bundle.putString("phoneN", phoneNumber);

        fragmentContact.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_contact, fragmentContact);
        transaction.commit();
    }

    private void intiUserInfoFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("category", getCategoryFromIntent());
        bundle.putString("itemID", itemIDStr);
        bundle.putString("userName", userNameStr);
        bundle.putString("userImage", userImageStr);
        bundle.putString("itemName", itemNameStr);
        bundle.putString("timePost", timePostStr);
        bundle.putString("postType", postTypeStr);
        bundle.putString("date", dateStr);
        bundle.putString("timStamp", timStampStr);
        bundle.putString("cat", cat);

        if (cat.equals("ccemt"))
        bundle.putParcelable("object",ccemtObject);

        if (cat.equals("cp"))
            bundle.putParcelable("object",carPlatesModel);

        if (cat.equals("wr"))
            bundle.putParcelable("object",wheelsRimModel);

        if (cat.equals("aaj"))
            bundle.putParcelable("object",accAndJunkObject);

        fragmentUserInfoAndMainButton.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_user_info_container, fragmentUserInfoAndMainButton);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        changeFont();
    }

    private void titleActionBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setTitle("Title");
                    isVisible = true;
                } else if(isVisible) {
                    toolbar.setTitle("");
                    isVisible = false;
                }
            }
        });

    }


    private void changeFont() {

    }

    private void inti() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.show_item_details_toolbar);
        appbar = (AppBarLayout)findViewById(R.id.show_item_details_app_bar);
    }

    private void statusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    public void onFavouriteChange(int numberOfChange) {
        numberOfChangeFromInterface = numberOfChange;
    }

    @Override
    public void onBackPressed() {
        String number = String.valueOf(numberOfChangeFromInterface);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("numberOfChange",number);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void getItemIDFromIntent() {
        Bundle bundle = getIntent().getExtras();
        itemIDStr =bundle.getString("itemID");
        categoryStr =bundle.getString("category");
        whereCome =bundle.getString("from");

    }

    private void intiValues(String userName, String userImage, String itemName, String timeStamp
            , String boostType,String date, String itemDes, String userIDPathInServer
            , String itemIV, int numberOfIg,String phoneN,Double itemPrice,String priceE,String newP) {

        userNameStr =userName;
        userImageStr =userImage;
        itemNameStr =itemName;
        timePostStr =timeStamp;
        postTypeStr =boostType;
        dateStr =date;
        timStampStr =timeStamp;
        itemDescription =itemDes;
        userID =userIDPathInServer;
        itemImage =itemIV;
        numberOfImage =String.valueOf(numberOfIg);
        phoneNumber = phoneN;
        price = String.valueOf(itemPrice);
        priceEdit = priceE;
        newPrice = newP;
    }
    @Override
    public void onReceiveCCEMTObject(CCEMT ccemt) {
       //to pass object to fragment
        ccemtObject = ccemt;
        String date = String.valueOf(ccemt.getDayDate())+"/"+String.valueOf(ccemt.getMonthDate())+"/"+String.valueOf(ccemt.getYear());
        intiValues(ccemt.getUserName(),ccemt.getUserImage(),ccemt.getItemName()
        ,ccemt.getTimeStamp(),ccemt.getBoostPostsArrayL().get(0).getBoostType(),date
        ,ccemt.getItemDescription(),ccemt.getUserIDPathInServer(),ccemt.getImagePathArrayL().get(0)
        ,ccemt.getImagePathArrayL().size(),ccemt.getPhoneNumber(),ccemt.getPrice()
        ,ccemt.getPostEdit(),ccemt.getNewPrice());
        intiAllFragment();
    }

    @Override
    public void onReceiveAccAndJunkObject(AccAndJunk accAndJunk) {
        accAndJunkObject = accAndJunk;
        String date = String.valueOf(accAndJunk.getDayDate())+"/"+String.valueOf(accAndJunk.getMonthDate())+"/"+String.valueOf(accAndJunk.getYearDate());
        intiValues(accAndJunk.getUserName(),accAndJunk.getUserImage(),accAndJunk.getItemName()
                ,accAndJunk.getTimeStamp(),accAndJunk.getBoostPostsArrayL().get(0).getBoostType(),date
                ,accAndJunk.getItemDescription(),accAndJunk.getUserIDPathInServer(),accAndJunk.getImagePathArrayL().get(0)
                ,accAndJunk.getImagePathArrayL().size(),accAndJunk.getPhoneNumber(),accAndJunk.getPrice()
                ,accAndJunk.getPostEdit(),accAndJunk.getNewPrice());
        intiAllFragment();
    }

    @Override
    public void onReceiveWheelsRimObject(WheelsRimModel wheelsRim) {
        wheelsRimModel = wheelsRim;
        String date = String.valueOf(wheelsRim.getDayDate())+"/"+String.valueOf(wheelsRim.getMonthDate())+"/"+String.valueOf(wheelsRim.getYearDate());
        intiValues(wheelsRim.getUserName(),wheelsRim.getUserImage(),wheelsRim.getItemName()
                ,wheelsRim.getTimeStamp(),wheelsRim.getBoostPostsArrayL().get(0).getBoostType(),date
                ,wheelsRim.getItemDescription(),wheelsRim.getUserIDPathInServer(),wheelsRim.getImagePathArrayL().get(0)
                ,wheelsRim.getImagePathArrayL().size(),wheelsRim.getPhoneNumber(),wheelsRim.getPrice()
                ,wheelsRim.getPostEdit(),wheelsRim.getNewPrice());
        intiAllFragment();
    }

    @Override
    public void onReceiveCarPlatesObject(CarPlatesModel carPlates) {
        carPlatesModel = carPlates;
        String date = String.valueOf(carPlates.getDayDate())+"/"+String.valueOf(carPlates.getMonthDate())+"/"+String.valueOf(carPlates.getYearDate());
        intiValues(carPlates.getUserName(),carPlates.getUserImage(),carPlates.getItemName()
                ,carPlates.getTimeStamp(),carPlates.getBoostPostsArrayL().get(0).getBoostType(),date
                ,carPlates.getItemDescription(),carPlates.getUserIDPathInServer(),carPlates.getImagePathArrayL().get(0)
                ,carPlates.getImagePathArrayL().size(),carPlates.getPhoneNumber(),carPlates.getPrice()
                ,carPlates.getPostEdit(),carPlates.getNewPrice());
        intiAllFragment();
    }

    private void intiAllFragment() {
        intiUserInfoFragment();
        intiItemDetails();
        intiImageSlider();
        intiItemDescriptionAndGeneralTips();
        intiShareFragment();
        intiFollowUser();
        intiContact();
    }

}
