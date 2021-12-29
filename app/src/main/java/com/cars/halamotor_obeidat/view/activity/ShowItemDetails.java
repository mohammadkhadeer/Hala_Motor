package com.cars.halamotor_obeidat.view.activity;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CCEMTModelDetails;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.new_presenter.RelativeResult;
import com.cars.halamotor_obeidat.presnter.FavouriteChange;
import com.cars.halamotor_obeidat.presnter.ImageClicked;
import com.cars.halamotor_obeidat.presnter.ItemModel;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentComments;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentContact;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentFollowUser;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentFullImageSlider;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentIDescriptionAndGeneralTips;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentImageSlider;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentItemSelectedDetails;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentShare;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentSimilarItems;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.FragmentUserInfo;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor_obeidat.fireBaseDB.GetFromFireBaseDB.getAccAndJunkObject;
import static com.cars.halamotor_obeidat.fireBaseDB.GetFromFireBaseDB.getCarPlatesObject;
import static com.cars.halamotor_obeidat.fireBaseDB.GetFromFireBaseDB.getWheelsSizeObject;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.presnter.CCEMTObjectDetailsFromServer.getCCEMTObjectDetails;

public class ShowItemDetails extends AppCompatActivity
         implements FavouriteChange , ItemModel, ImageClicked , RelatedAds, RelativeResult {

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
    FragmentFullImageSlider fragmentFullImageSlider = new FragmentFullImageSlider();

    String category;

    CCEMTModelDetails ccemtModelDetails1;
    ItemPlates carPlatesModel;
    ItemWheelsRim wheelsRimModel;
    ItemAccAndJunk accAndJunkObject;

    String itemIDStr,item_id,userNameStr,userImageStr,itemNameStr
            ,timStampStr,itemDescription,user_id,numberOfImage,whereCome
            ,categoryStr,cat,phoneNumber,price,priceEdit,newPrice
            ,personOrGallery,category_code;

    ArrayList<String> photosArrayList = new ArrayList<>();

    CategoryComp categoryComp;

    int numberOfChangeFromInterface;

    ItemModel itemModel;

    TextView itemPriceTV,oldPriceTV,itemNewPriceTV,title;
    LinearLayout show_item_details_header;
    RelativeLayout fullImageCont;
    int fullImageOnTheTop =0;

    CreatorInfo creatorInfo;

    private static final int REPORT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_show_item_details);

        makeKeyBordDownEditText();
        //statusBarTransparent();
        itemModel = (ItemModel) this;
        //this object come from privuse activity to take filter comp to can create good suggested list
        inti();

        getItemIDFromIntent();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                intiObject();

            }
        }, 50);


        //intiCommentsFragment();
    }

    private void intiImageSlider() {
        Bundle bundle = new Bundle();
        bundle.putString("cat", cat);
        bundle.putString("price", price);
        bundle.putString("priceE", priceEdit);
        bundle.putString("newP", newPrice);
        bundle.putStringArrayList("photos_list", photosArrayList);

        fragmentImageSlider.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_image_slider_container, fragmentImageSlider);
        transaction.commit();
    }

    private void inti() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.show_item_details_toolbar);
        appbar = (AppBarLayout)findViewById(R.id.show_item_details_app_bar);
        itemPriceTV = (TextView) findViewById(R.id.show_item_details_car_price);
        oldPriceTV = (TextView) findViewById(R.id.show_item_details_car_old_price);
        itemNewPriceTV = (TextView) findViewById(R.id.show_item_details_new_price);
        show_item_details_header = (LinearLayout) findViewById(R.id.show_item_details_header);
        title = (TextView) findViewById(R.id.show_item_details_title);
        fullImageCont = (RelativeLayout) findViewById(R.id.fullImageCont);
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    private void titleActionBar() {
        toolbar.setTitle(" ");
        setSupportActionBar(toolbar);

        fillPrice();
        title.setText(itemNameStr);
        title.setTypeface(Functions.changeFontGeneral(getApplicationContext()));

        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    show_item_details_header.setVisibility(View.VISIBLE);
                    collapsingToolbarLayout.setTitle(itemNameStr);

                    statusBarColor();
                    isVisible = true;
                } else if(isVisible) {
                    collapsingToolbarLayout.setTitle(" ");
                    show_item_details_header.setVisibility(View.GONE);
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    isVisible = false;
                }
            }
        });

    }

    private void fillPrice() {
        if (priceEdit.equals("0"))
        {
            itemPriceTV.setVisibility(View.VISIBLE);
            oldPriceTV.setVisibility(View.GONE);
            itemNewPriceTV.setText(price
                    +" "+getResources().getString(R.string.price_contry)+"   ");
            //itemPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            //set new price empty to stay design
            itemPriceTV.setText("");
            //itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        }else{
            itemPriceTV.setVisibility(View.GONE);
            oldPriceTV.setVisibility(View.VISIBLE);

            oldPriceTV.setText(price);
            //change text color
            oldPriceTV.setTextColor(getResources().getColor(R.color.colorWhite));
            //set line above old price
            oldPriceTV.setPaintFlags(itemPriceTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            //change size new price
            //itemNewPriceTV.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);

            itemNewPriceTV.setText(newPrice
                    +" "+getResources().getString(R.string.price_contry));
            //fill old price
            itemPriceTV.setText(price
                    +" "+getResources().getString(R.string.price_contry));

        }
    }

    private void makeKeyBordDownEditText() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    private void intiObject() {
        category =categoryStr;

        if (category.equals("car_for_sale")
                ||category.equals("car_for_rent")
                ||category.equals("exchange_car")
                ||category.equals("motorcycle")
                ||category.equals("trucks")
        ) {
            cat = "ccemt";
            getCCEMTObjectDetails(getApplicationContext(),itemIDStr,categoryComp,itemModel);
        }
        if (category.equals("Car plates") || category.equals("Plates"))
        {
            cat = "cp";
            getCarPlatesObject(categoryStr,itemIDStr,itemModel);
        }
        if (category.equals("Wheels rim") || category.equals("Wheels_Rim"))
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

    private void intiFollowUser() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CreatorInfo",creatorInfo);

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
        bundle.putString("item_id", item_id);
        bundle.putString("user_id", user_id);
        bundle.putString("user_type", personOrGallery);
        bundle.putString("user_name", userNameStr);
        bundle.putString("category", category);

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
            bundle.putParcelable("object",ccemtModelDetails1);

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
        bundle.putString("itemID", itemIDStr);
        bundle.putString("category", getCategoryFromIntent());

        fragmentContact.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.selected_item_details_contact, fragmentContact);
        transaction.commit();
    }

    private void intiUserInfoFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("itemID", itemIDStr);
        bundle.putString("item_name", itemNameStr);
        bundle.putString("timePost", timStampStr);
        bundle.putString("category_code", category_code);
        bundle.putParcelable("CreatorInfo",creatorInfo);

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

    private void changeFont() {
        title.setTypeface(Functions.changeFontBold(this));
        itemPriceTV.setTypeface(Functions.changeFontGeneral(this));
        oldPriceTV.setTypeface(Functions.changeFontGeneral(this));
        itemNewPriceTV.setTypeface(Functions.changeFontGeneral(this));
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


    private void getItemIDFromIntent() {
        Bundle bundle = getIntent().getExtras();
        itemIDStr =bundle.getString("itemID");
        categoryStr =bundle.getString("category");
        whereCome =bundle.getString("from");
        if (whereCome.equals("ml"))
        {
            categoryComp = bundle.getParcelable("category_comp");
        }

    }

    private void intiValues(String userName,String itemID, String userImage, String itemName,String itemDes
            ,ArrayList<String> photosArrayL,String timeStamp
            , String boostType, String userIDPathInServer
            , String numberOfIg,String phoneN,String itemPrice,String priceE
            ,String newP,String personOrGalleryS,CreatorInfo creatorInfoFromServer) {

        userNameStr =userName;
        item_id =itemID;
        userImageStr =userImage;
        itemNameStr =itemName;
        itemDescription =itemDes;
        photosArrayList =photosArrayL;

        timStampStr =timeStamp;
        category_code =boostType;
        user_id =userIDPathInServer;
        numberOfImage =numberOfIg;

        phoneNumber = phoneN;
        price = itemPrice;
        priceEdit = priceE;
        newPrice = newP;
        personOrGallery = personOrGalleryS;
        creatorInfo = creatorInfoFromServer;
    }

    @Override
    public void onReceiveAccAndJunkObject(ItemAccAndJunk accAndJunk) {
        accAndJunkObject = accAndJunk;
        String date = String.valueOf(accAndJunk.getDayDate())+"/"+String.valueOf(accAndJunk.getMonthDate())+"/"+String.valueOf(accAndJunk.getYearDate());
//        intiValues(accAndJunk.getUserName(),accAndJunk.getUserImage(),accAndJunk.getItemName()
//                ,accAndJunk.getTimeStamp(),"empty",date
//                ,accAndJunk.getItemDescription(),accAndJunk.getUserIDPathInServer(),accAndJunk.getImagePathArrayL().get(0)
//                ,accAndJunk.getImagePathArrayL().size(),accAndJunk.getPhoneNumber(),accAndJunk.getPrice()
//                ,accAndJunk.getPostEdit(),accAndJunk.getNewPrice(),accAndJunk.getPersonOrGallery());

        intiAllFragment();
    }

    @Override
    public void onReceiveWheelsRimObject(ItemWheelsRim wheelsRim) {
        wheelsRimModel = wheelsRim;


        String date = String.valueOf(wheelsRim.getDayDate())+"/"+String.valueOf(wheelsRim.getMonthDate())+"/"+String.valueOf(wheelsRim.getYearDate());
//        intiValues(wheelsRim.getUserName(),wheelsRim.getUserImage(),wheelsRim.getItemName()
//                ,wheelsRim.getTimeStamp(),"empty",date
//                ,wheelsRim.getItemDescription(),wheelsRim.getUserIDPathInServer(),wheelsRim.getImagePathArrayL().get(0)
//                ,wheelsRim.getImagePathArrayL().size(),wheelsRim.getPhoneNumber(),wheelsRim.getPrice()
//                ,wheelsRim.getPostEdit(),wheelsRim.getNewPrice(),wheelsRim.getPersonOrGallery());

        intiAllFragment();
    }

    @Override
    public void onReceiveCarPlatesObject(ItemPlates carPlates) {
        carPlatesModel = carPlates;
        String date = String.valueOf(carPlates.getDayDate())+"/"+String.valueOf(carPlates.getMonthDate())+"/"+String.valueOf(carPlates.getYearDate());
//        intiValues(carPlates.getUserName(),carPlates.getUserImage(),carPlates.getItemName()
//                ,carPlates.getTimeStamp(),"empty",date
//                ,carPlates.getItemDescription(),carPlates.getUserIDPathInServer(),carPlates.getImagePathArrayL().get(0)
//                ,carPlates.getImagePathArrayL().size(),carPlates.getPhoneNumber(),carPlates.getPrice()
//                ,carPlates.getPostEdit(),carPlates.getNewPrice(),carPlates.getPersonOrGallery());

        intiAllFragment();
    }

    @Override
    public void onReceiveCCEMTObjectDetails(CCEMTModelDetails ccemtModelDetails) {
        ccemtModelDetails1 = ccemtModelDetails;
        intiValues(ccemtModelDetails.getCcemtSmallObject().getCreatorInfo().getName()
                ,ccemtModelDetails.getCcemtSmallObject().getAd_id()
                ,"R.color.colorSilver"
                ,ccemtModelDetails.getCcemtSmallObject().getAd_title()
                ,ccemtModelDetails.getCcemtSmallObject().getAd_description()
                ,ccemtModelDetails.getPhotosArrayList()
                ,ccemtModelDetails.getCcemtSmallObject().getAd_time_post()
                ,ccemtModelDetails.getCategoryComp().getCode()
                ,ccemtModelDetails.getCcemtSmallObject().getCreatorInfo().getUser_id()
                ,String.valueOf(ccemtModelDetails.getPhotosArrayList().size())
                ,ccemtModelDetails.getCcemtSmallObject().getAd_phone()
                ,ccemtModelDetails.getCcemtSmallObject().getAd_price()
                ,"0",ccemtModelDetails.getCcemtSmallObject().getAd_price()
                ,ccemtModelDetails.getCcemtSmallObject().getCreatorInfo().getType()
                ,ccemtModelDetails.getCcemtSmallObject().getCreatorInfo());

        intiAllFragment();
    }

    private void intiAllFragment() {
        titleActionBar();
        intiUserInfoFragment();
        intiItemDetails();
        intiImageSlider();
        intiItemDescriptionAndGeneralTips();
        intiShareFragment();
        intiFollowUser();
        intiContact();
        intiSuggestedFragment();
    }

    @Override
    public void imageClicked(String test) {
        fullImageCont.setVisibility(View.VISIBLE);
        fullImageOnTheTop =1;
        handelFragmentFullImage();
    }

    public void handelFragmentFullImage() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("allImage", photosArrayList);


        fragmentFullImageSlider.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_full_image_slider, fragmentFullImageSlider)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (fullImageOnTheTop==1)
        {
            fullImageOnTheTop =0;
            fragmentFullImageSlider.diestroyAsynk();
            fullImageCont.setVisibility(View.GONE);
        }else{
            finish();
        }
    }

    @Override
    public void relatedAdsToSameUser(List<SuggestedItem> relatedAdsToSameUserList) {

    }

    @Override
    public void whenGetCCEMTListSearchSuccess(ArrayList<CCEMTModel> ccemtModelArrayList) {
        fragmentSuggestedAntherItems.recivedARelativeRe(ccemtModelArrayList);
    }
}
