package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.cars.halamotor.R;
import com.cars.halamotor.functions.Action;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.AccAndJunk;
import com.cars.halamotor.model.CCEMT;
import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CarMakeAndCarModel;
import com.cars.halamotor.model.CarPlatesDetails;
import com.cars.halamotor.model.CarPlatesModel;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.CityWithNeighborhood;
import com.cars.halamotor.model.CustomGallery;
import com.cars.halamotor.model.EditValueInCDM;
import com.cars.halamotor.model.ItemAccAndJunk;
import com.cars.halamotor.model.ItemCCEMT;
import com.cars.halamotor.model.ItemPlates;
import com.cars.halamotor.model.ItemWheelsRim;
import com.cars.halamotor.model.WheelsInfo;
import com.cars.halamotor.model.WheelsRimModel;
import com.cars.halamotor.permission.CheckPermission;
import com.cars.halamotor.presnter.NumberOfAllowedAds;
import com.cars.halamotor.presnter.PassCategories;
import com.cars.halamotor.utils.Utils;
import com.cars.halamotor.view.adapters.AdapterSelectCategory;
import com.cars.halamotor.view.adapters.SelectedImageAdapter;
import com.cars.halamotor.view.fragments.FragmentCityPhoneNumber;
import com.cars.halamotor.view.fragments.ShowSelectedCarDetailsFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.ButterKnife;

import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.checkUserCanInsertAddOrNot;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.checkUserCanInsertBurnedPrice;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getNumberOfAllowedAdsFromServer;
import static com.cars.halamotor.fireBaseDB.GetFromFireBaseDB.getNumberOfOldAds;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadAccessoriesModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarForExchangeModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarForMotorcycleModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarForRentModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarForSaleModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarForTrucksModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadCarPlatesModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadJunkCarModel;
import static com.cars.halamotor.fireBaseDB.UploadToStorage.uploadImagesBeforeUploadWheelsRimModel;
import static com.cars.halamotor.functions.FillCarModel.fillAllCarArrayL;
import static com.cars.halamotor.functions.FillNeighborhood.fillCityAndNeighborhoodArrayL;
import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor.functions.Functions.checkBurnedPrice;
import static com.cars.halamotor.functions.Functions.checkPhoneNumberRealOrNot;
import static com.cars.halamotor.functions.Functions.checkTitleAndDescription;
import static com.cars.halamotor.functions.Functions.checkTitleAndDescriptionRealOrNot;
import static com.cars.halamotor.functions.Functions.cityS;
import static com.cars.halamotor.functions.Functions.fillCategoryArrayList;
import static com.cars.halamotor.functions.Functions.getDAY;
import static com.cars.halamotor.functions.Functions.getDefaultBoostPostArrayL;
import static com.cars.halamotor.functions.Functions.getDefaultCommentCompArrayL;
import static com.cars.halamotor.functions.Functions.getImagePathsNoImage;
import static com.cars.halamotor.functions.Functions.getMONTH;
import static com.cars.halamotor.functions.Functions.getTime;
import static com.cars.halamotor.functions.Functions.getTimeStamp;
import static com.cars.halamotor.functions.Functions.getVideoPath;
import static com.cars.halamotor.functions.Functions.getYEAR;
import static com.cars.halamotor.functions.Functions.isNetworkAvailable;
import static com.cars.halamotor.functions.Functions.splitString;
import static com.cars.halamotor.functions.Functions.updateCarDetailsModel;
import static com.cars.halamotor.functions.NewFunction.convertYearToEng;
import static com.cars.halamotor.functions.UploadDamiData.uploadDamiDataForTest;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getAddressInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getBurnedPriceInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getCityFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getCitySFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getDesInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getNeighborhoodFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getNeighborhoodSFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPhoneNumberInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getPriceAfterConvertedToDoubleInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getTitleInSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserImage;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserName;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;

public class AddItem extends AppCompatActivity implements
        ShowSelectedCarDetailsFragment.OnDataPass , NumberOfAllowedAds , PassCategories {

    RelativeLayout cancelRL, selectImageFGRL, selectVideoRL, coverVideoViewRL, cancelVideoRL, cancelSelectedCategoryRL, add_activity_complete_car_dCV, cityPhoneNumberRL;
    RelativeLayout showSelectedCarDetailsRL, messageContainerRL, messageContentRL;
    LinearLayout categoryContLL, headLL;
    TextView insertAddTV, textTitleTV, categorySelectedNameTV, completeCarDetailsTV, generalMessageTV;
    RecyclerView viewSelectedImageRV, selectCategoryRV;
    VideoView viewVideoSelected;
    ImageView imageCategorySelectedIV;
    CardView viewSelectedCategoryCV, completeCarDetailsCV;
    Button insertItemBtn;
    RecyclerView.LayoutManager layoutManager, layoutManagerCategory;
    ProgressBar progressBar;

    private static final int PICK_FROM_GALLERY = 1;
    private static final int REQUEST_TAKE_GALLERY_VIDEO = 2;
    private static final int STATIC_BACK_VALUE = 3;
    private static final int REQUEST_WHEELS_RIM = 6;
    private static final int EDIT_CAR_DETAILS = 4;
    private static final int REQUEST_CAR_PLATES = 7;

    ImageLoader imageLoader;
    SelectedImageAdapter selectedImageAdapter;
    AdapterSelectCategory adapterSelectCategory;
    ArrayList<String> imagePathArrL = new ArrayList<String>();

    public ArrayList<CategoryComp> categoryCompsArrayL;

    final Fragment fragmentShowSelectedDetails = new ShowSelectedCarDetailsFragment();
    final Fragment fragmentCityPhoneNumber = new FragmentCityPhoneNumber();

    static int selectVideoOrNotYet = 0;
    int productDetailsComplete = 0;

    int selectedCategoryPositionInt = 100,itemLiveOrMustToWaitIfBurnedPriceOn;

    Uri mVideoURI;

    ItemCCEMT itemCCEMT;
    ItemPlates itemPlates;
    ItemWheelsRim itemWheelsRim;
    ItemAccAndJunk itemAccAndJunk;
    CarDetailsModel carDetailsModel;
    String wheelsSize,wheelsType,wheelsTypeS;
    CarPlatesDetails carPlatesDetails;


    NumberOfAllowedAds numberOfAllowedAds;
    int numberOfAllowedAdsInt,numberOfOldAds,canInsertAndOrNot,canInsertBurnedPrice;

    CategoryComp categoryCompNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);
        numberOfAllowedAds = (NumberOfAllowedAds) this;
        statusBarColor();
        inti();
        hideVideoShowBeforeSelected();
        initImageLoader();
        changeFontType();
        actionListener();
        createSelectCategoryRV();

        //get user info from server
        getNumberOfAllowedAdsFromServer(this,numberOfAllowedAds);
        getNumberOfOldAds(this,numberOfAllowedAds);
        checkUserCanInsertAddOrNot(this,numberOfAllowedAds);
        checkUserCanInsertBurnedPrice(this,numberOfAllowedAds);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            getSelectedImagePathes(data);
            showSelectedImage();
            if (selectVideoOrNotYet == 1)
                replayVideo();
        }
        if (requestCode == REQUEST_TAKE_GALLERY_VIDEO && resultCode == Activity.RESULT_OK) {
            selectVideoOrNotYet = 1;
            showSelectedVideo(data);
        }
        if (requestCode == STATIC_BACK_VALUE && resultCode == Activity.RESULT_OK) {
            productDetailsComplete = 1;
            createShowSelectedCarDetails(data, resultCode, requestCode);
            createCityPhoneNumber();
            ChangeUI();
        }
        if (requestCode == REQUEST_WHEELS_RIM && resultCode == Activity.RESULT_OK) {
            productDetailsComplete = 1;
            selectedCategoryPositionInt = 6;
            createShowSelectedCarDetails(data, resultCode, REQUEST_WHEELS_RIM);
            createCityPhoneNumber();
            ChangeUI();
        }
        if (requestCode == REQUEST_CAR_PLATES && resultCode == Activity.RESULT_OK) {
            productDetailsComplete = 1;
            selectedCategoryPositionInt = 4;
            createShowSelectedCarDetails(data, resultCode, REQUEST_CAR_PLATES);
            createCityPhoneNumber();
            ChangeUI();
        }
    }

    private void insertBtnListener() {
        insertItemBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                checkBeforUpload();
                //uploadDamiDataForTest(getApplicationContext());
            }
        });
    }

    private void checkBeforUpload() {
        String selectCategory ;
        if (isNetworkAvailable(getApplicationContext())) {
            if (selectedCategoryPositionInt != 100) {
                if (checkTitleAndDescription(getApplicationContext()) == null) {
                    if (checkTitleAndDescriptionRealOrNot(getApplicationContext()) == null) {
                        if (productDetailsComplete == 1) {
                            if (getAddressInSP(getApplicationContext()) != null) {
                                if (checkPhoneNumberRealOrNot(getApplicationContext()) == null) {
                                    if (numberOfOldAds < numberOfAllowedAdsInt) {
                                        if (canInsertAndOrNot == 1) {
                                            selectCategory = categoryCompNow.getCode();
                                            if (getBurnedPriceInSP(getApplicationContext()) != null) {
                                                if (canInsertBurnedPrice == 1) {
                                                    itemLiveOrMustToWaitIfBurnedPriceOn =0;
                                                    checkCategoryAndUpload(selectCategory);
                                                } else {
                                                    completeMessage(getResources().getString(R.string.blocked_bp));
                                                }
                                            } else {
                                                itemLiveOrMustToWaitIfBurnedPriceOn =1;
                                                checkCategoryAndUpload(selectCategory);
                                            }
                                        } else {
                                            completeMessage(getResources().getString(R.string.blocked));
                                        }
                                    } else {
                                        completeMessage(getResources().getString(R.string.upgrade_ur_account));
                                    }
                                } else {
                                    completeMessage(checkPhoneNumberRealOrNot(getApplicationContext()));
                                }
                            } else {
                                completeMessage(getResources().getString(R.string.select_address));
                            }
                        } else {
                            completeMessage(getResources().getString(R.string.complete_product_details));
                        }
                    } else {
                        completeMessage(checkTitleAndDescriptionRealOrNot(getApplicationContext()));
                    }
                } else {
                    completeMessage(checkTitleAndDescription(getApplicationContext()));
                }
            } else {
                completeMessage(getResources().getString(R.string.select_category));
            }
        } else {
            completeMessage(getResources().getString(R.string.message_no_internet));
        }
    }

    private void createCCMETObject(String selectedCategory) {
        String firstNumber = "0", secondNumber = "0";
        if (!carDetailsModel.getKilometersStr().equals(getResources().getString(R.string.k_0))
                && !carDetailsModel.getKilometersStr().equals(getResources().getString(R.string.k_up_200K)))
        {
            String[] stringAfterSplitKilometers = splitString(carDetailsModel.getKilometersStr(), "-");
            firstNumber = splitString(stringAfterSplitKilometers[0], ",")[0] + splitString(stringAfterSplitKilometers[0], ",")[1];
            secondNumber = splitString(stringAfterSplitKilometers[1], ",")[0] + splitString(stringAfterSplitKilometers[1], ",")[1];
        }else{
            if (carDetailsModel.getKilometersStr().equals(getResources().getString(R.string.k_0)))
            {
                firstNumber = "0" ;
                secondNumber = "0" ;
            }
            if (carDetailsModel.getKilometersStr().equals(getResources().getString(R.string.k_up_200K)))
            {
                firstNumber = "200000" ;
                secondNumber = "200000" ;
            }
        }
//        itemCCEMT = new ItemCCEMT(
//                "NOTYET"
//                ,getCityFromSP(getApplicationContext())
//                ,getNeighborhoodFromSP(getApplicationContext())
//                ,getUserTokenInFromSP(getApplicationContext())
//                ,getTime(), getPhoneNumberInSP(getApplicationContext())
//                , getTitleInSP(getApplicationContext())
//                , getDesInSP(getApplicationContext())
//                , getUserImage(getApplicationContext())
//                ,getUserName(getApplicationContext())
//                ,"0","123","0","0"
//                ,selectedCategory, selectedCategory
//                , carDetailsModel.getCarMakeStr().getName_en()
//                , carDetailsModel.getModelStr().getModel_name_en()
//                , carDetailsModel.getYearStr()
//                , carDetailsModel.getConditionStr().getCarConditionStr()
//                , carDetailsModel.getKilometersStr()
//                , carDetailsModel.getTransmissionStr()
//                , carDetailsModel.getFuelStr().getCarFuelStr()
//                , carDetailsModel.getLicenseStr().getCarLicensedStr()
//                , carDetailsModel.getInsurance().getCarInsuranceStr()
//                , carDetailsModel.getCarColorStr()
//                , carDetailsModel.getPaymentMethod().getPaymentMethodStr()
//                , carDetailsModel.getCarOptionsStr()
//                ,"person", getTimeStamp()
//                , getUserIdInServerFromSP(getApplicationContext())
//                ,getImagePathsNoImage()
//                ,checkBurnedPrice(getApplicationContext())
//                ,0,Integer.parseInt(getYEAR()), Integer.parseInt(getMONTH())
//                , Integer.parseInt(getDAY())
//                ,getPriceAfterConvertedToDoubleInSP(getApplicationContext())
//                , Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)
//                ,String.valueOf(itemLiveOrMustToWaitIfBurnedPriceOn)
//                ,selectedCategory
//                ,getCitySFromSP(getApplicationContext())
//                ,getNeighborhoodSFromSP(getApplicationContext())
//                ,carDetailsModel.getCarMakeStr().getName_en()
//                ,carDetailsModel.getModelStr().getModel_name_en()
//                ,"person"
//                ,carDetailsModel.getPaymentMethod().getPaymentMethodStrS()
//                ,carDetailsModel.getFuelStr().getCarFuelStrS()
//                ,carDetailsModel.getConditionStr().getCarConditionStrS()
//                ,carDetailsModel.getInsurance().getCarInsuranceStrS()
//                ,carDetailsModel.getLicenseStr().getCarLicensedStrS()
//                ,Integer.parseInt(convertYearToEng(carDetailsModel.getYearStr()))
//                , Locale.getDefault().getLanguage()
//        );
    }

    private void checkCategoryAndUpload(String selectCategory) {
        //we have 4 model 1.car plates 2.accessories/junk car 3.wheels-rim
        // 4.car for sale/car for rent/exchange/motorcycle/trucks ... in model well be name CCEMT
        progressBar.setVisibility(View.VISIBLE);
        if (selectCategory.equals(getResources().getString(R.string.car_for_sale))) {
            createCCMETObject("Car for sale");
            uploadImagesBeforeUploadCarForSaleModel(imagePathArrL, itemCCEMT, "Car_For_Sale"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.car_for_rent))) {
            createCCMETObject("Car for rent");
            uploadImagesBeforeUploadCarForRentModel(imagePathArrL, itemCCEMT, "Car_For_Rent"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.exchange_car))) {
            createCCMETObject("Exchange car");
            uploadImagesBeforeUploadCarForExchangeModel(imagePathArrL, itemCCEMT, "Car_For_Exchange"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.motorcycle))) {
            createCCMETObject("Motorcycle");
            uploadImagesBeforeUploadCarForMotorcycleModel(imagePathArrL, itemCCEMT, "Car_For_Motorcycle"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.trucks))) {
            createCCMETObject("Trucks");
            uploadImagesBeforeUploadCarForTrucksModel(imagePathArrL, itemCCEMT, "Trucks"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.car_plates))) {
            createCarPlatesObject("Car plates");
            uploadImagesBeforeUploadCarPlatesModel(imagePathArrL, itemPlates, "Plates"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.wheels_rim))) {
            createWheelsRimObject("Wheels rim");
            uploadImagesBeforeUploadWheelsRimModel(imagePathArrL, itemWheelsRim, "Wheels_Rim"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.accessories))) {
            createAccAndHunkObject("Accessories");
            uploadImagesBeforeUploadAccessoriesModel(imagePathArrL, itemAccAndJunk, "Accessories"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        if (selectCategory.equals(getResources().getString(R.string.junk_car))) {
            createAccAndHunkObject("Junk car");
            uploadImagesBeforeUploadJunkCarModel(imagePathArrL, itemAccAndJunk, "JunkCar"
                    , getUserIdInServerFromSP(getApplicationContext()), numberOfOldAds,getApplicationContext());
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                Intent resultIntent = new Intent();
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        }, 5000);

    }

    private void createAccAndHunkObject(String selectedCategory) {
        itemAccAndJunk = new ItemAccAndJunk(
                "NOTYET", getCityFromSP(getApplicationContext())
                , getNeighborhoodFromSP(getApplicationContext())
                , getUserTokenInFromSP(getApplicationContext())
                , getTime(), getPhoneNumberInSP(getApplicationContext())
                , getTitleInSP(getApplicationContext())
                , getDesInSP(getApplicationContext())
                , getUserImage(getApplicationContext()), getUserName(getApplicationContext())
                , "0", "123", "0"
                , getVideoPath(mVideoURI), selectedCategory, selectedCategory
                ,"person"
                , getTimeStamp()
                , getUserIdInServerFromSP(getApplicationContext())
                , getImagePathsNoImage()
                , checkBurnedPrice(getApplicationContext())
                , 0, 0, itemLiveOrMustToWaitIfBurnedPriceOn
                , Integer.parseInt(getYEAR()), Integer.parseInt(getMONTH()), Integer.parseInt(getDAY())
                , getPriceAfterConvertedToDoubleInSP(getApplicationContext())
                ,String.valueOf(itemLiveOrMustToWaitIfBurnedPriceOn)
                ,selectedCategory
                ,getCitySFromSP(getApplicationContext())
                ,getNeighborhoodSFromSP(getApplicationContext())
                ,Locale.getDefault().getLanguage()
        );
    }

    private void createWheelsRimObject(String selectedCategory) {
        int convertWheelsSize;
        if (!wheelsSize.equals("other"))
            convertWheelsSize = Integer.parseInt(wheelsSize);
        else
            convertWheelsSize = 100;

        itemWheelsRim = new ItemWheelsRim(
                "NOTYET", getCityFromSP(getApplicationContext())
                , getNeighborhoodFromSP(getApplicationContext())
                , getUserTokenInFromSP(getApplicationContext())
                , getTime(), getPhoneNumberInSP(getApplicationContext())
                , getTitleInSP(getApplicationContext())
                , getDesInSP(getApplicationContext())
                , getUserImage(getApplicationContext()), getUserName(getApplicationContext())
                , "0", "123", "0"
                , getVideoPath(mVideoURI), selectedCategory, selectedCategory
                , wheelsSize
                ,"person"
                , getTimeStamp()
                , getUserIdInServerFromSP(getApplicationContext())
                ,getImagePathsNoImage()
                ,checkBurnedPrice(getApplicationContext())
                ,0,0, itemLiveOrMustToWaitIfBurnedPriceOn
                , Integer.parseInt(getYEAR()), Integer.parseInt(getMONTH()), Integer.parseInt(getDAY())
                ,convertWheelsSize
                ,getPriceAfterConvertedToDoubleInSP(getApplicationContext())
                ,wheelsType
                ,String.valueOf(itemLiveOrMustToWaitIfBurnedPriceOn)
                ,wheelsTypeS
                ,getCitySFromSP(getApplicationContext())
                ,getNeighborhoodSFromSP(getApplicationContext())
                ,selectedCategory
                ,Locale.getDefault().getLanguage()
        );
    }

    private void createCarPlatesObject(String selectedCategory) {

        String[] cityAndChar = splitString(carPlatesDetails.getCarPlatesCity(), "  ");

        itemPlates = new ItemPlates(
                "NOTYET", getCityFromSP(getApplicationContext())
                , getNeighborhoodFromSP(getApplicationContext())
                , getUserTokenInFromSP(getApplicationContext())
                , getTime(), getPhoneNumberInSP(getApplicationContext())
                , getTitleInSP(getApplicationContext())
                , getDesInSP(getApplicationContext())
                , getUserImage(getApplicationContext()), getUserName(getApplicationContext())
                , "0", "123", "0"
                ,getVideoPath(mVideoURI),selectedCategory, selectedCategory
                , cityAndChar[0]
                , carPlatesDetails.getCarPlatesNumber()
                ,"person", getTimeStamp()
                ,getUserIdInServerFromSP(getApplicationContext())
                ,getImagePathsNoImage()
                ,itemLiveOrMustToWaitIfBurnedPriceOn
                ,checkBurnedPrice(getApplicationContext())
                ,0,0,Integer.parseInt(getYEAR()), Integer.parseInt(getMONTH()), Integer.parseInt(getDAY())
                ,carPlatesDetails.getSpecialOrNot()
                ,getPriceAfterConvertedToDoubleInSP(getApplicationContext())
                ,carPlatesDetails.getCarPlatesNumber()
                ,String.valueOf(itemLiveOrMustToWaitIfBurnedPriceOn)
                ,selectedCategory
                ,cityS(carPlatesDetails.getCarPlatesCity(),this)
                ,getCitySFromSP(getApplicationContext())
                ,getNeighborhoodSFromSP(getApplicationContext())
                ,cityAndChar[1]
                ,Locale.getDefault().getLanguage()
        );

    }

    private void translateToCarPlatesActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("specialIntOrNot", "normal");

        Intent intent = new Intent(AddItem.this, CarPlates.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 7);
        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void translateToWheelsRimActivity() {
        Intent intent = new Intent(AddItem.this, WheelsRim.class);
        startActivityForResult(intent, REQUEST_WHEELS_RIM);
        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void completeMessage(String string) {
        generalMessageTV.setText(string);
        makeMessageCompVisable();
    }

    private void makeMessageCompVisable() {
        generalMessageTV.setVisibility(View.VISIBLE);
        messageContainerRL.setVisibility(View.VISIBLE);
        messageContentRL.setVisibility(View.VISIBLE);
        headLL.setVisibility(View.GONE);
        reSetGoneAfter2Sec();
    }

    private void reSetGoneAfter2Sec() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                generalMessageTV.setVisibility(View.GONE);
                messageContainerRL.setVisibility(View.GONE);
                messageContentRL.setVisibility(View.GONE);
                headLL.setVisibility(View.VISIBLE);
            }
        }, 2000);

    }

    private void checkIfNeedToMakeCompleteCarDetailsToBeVisable(CategoryComp categoryComp) {
        if (!categoryComp.getCode().equals("car_plates")
                && !categoryComp.getCode().equals("accessories")
                && !categoryComp.getCode().equals("wheels_rim")
                && !categoryComp.getCode().equals("exchange_car")
                && !categoryComp.getCode().equals("junk_car"))
        {
            makeCompleteCarDetailsVisable();
        } else {
            productDetailsComplete = 1;
            makeCompleteCarDetailsGone();
            createCityPhoneNumber();
        }
    }

    private void makeCompleteCarDetailsGone() {
        completeCarDetailsCV.setVisibility(View.GONE);
    }

    private void makeCompleteCarDetailsVisable() {
        completeCarDetailsCV.setVisibility(View.VISIBLE);
    }

    private void goneRVAndVisableSelectedCategoryAndFillSelectedInfo(CategoryComp categoryComp) {
        viewSelectedCategoryCV.setVisibility(View.VISIBLE);
        selectCategoryRV.setVisibility(View.GONE);
        imageCategorySelectedIV.setBackgroundResource(categoryComp.getImageIdInt());
        categorySelectedNameTV.setText(getTextEngOrLocal(getApplicationContext(),categoryComp.getName_en(),categoryComp.getName_ar()));
        textTitleTV.setText(getResources().getText(R.string.process_now));
    }

    private void createSelectCategoryRV() {
        categoryCompsArrayL = fillCategoryArrayList(categoryCompsArrayL, getApplicationContext());
        selectCategoryRV.setNestedScrollingEnabled(false);
        selectCategoryRV.setHasFixedSize(true);
        layoutManagerCategory = new LinearLayoutManager(AddItem.this,
                LinearLayoutManager.HORIZONTAL, false);
        selectCategoryRV.setLayoutManager(layoutManagerCategory);
        adapterSelectCategory = new AdapterSelectCategory(AddItem.this
                , categoryCompsArrayL,this);
        selectCategoryRV.setAdapter(adapterSelectCategory);
    }

    private void hideVideoShowBeforeSelected() {
        viewVideoSelected.setVisibility(View.GONE);
        coverVideoViewRL.setVisibility(View.GONE);
    }

    public void initImageLoader() {
        imageLoader = Utils.initImageLoader(AddItem.this);
    }

    private void actionListener() {
        insertBtnListener();
        cancelRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        selectImageFGRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToSelectPhoto(AddItem.this) == true) {
                    Intent i = new Intent(Action.ACTION_MULTIPLE_PICK);
                    startActivityForResult(i, 200);
                }
            }
        });

        selectVideoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckPermission.checkPermissionMethodToSelectPhoto(AddItem.this) == true) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, REQUEST_TAKE_GALLERY_VIDEO);
                }
            }
        });

        cancelVideoRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coverVideoViewRL.setVisibility(View.GONE);
                selectVideoOrNotYet = 0;
                mVideoURI = null;
                viewVideoSelected.stopPlayback();
            }
        });

//        cancelSelectedCategoryRL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectedCategoryPositionInt =100;
//                viewSelectedCategoryCV.setVisibility(View.GONE);
//                selectCategoryRV.setVisibility(View.VISIBLE);
//                makeCompleteCarDetailsGone();
//                textTitleTV.setText(getResources().getText(R.string.what_do));
//            }
//        });

        add_activity_complete_car_dCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition fade = new Fade();
                fade.excludeTarget(android.R.id.statusBarBackground, true);
                getWindow().setExitTransition(fade);

                moveToCarDetailsCar();
            }
        });
    }

    private void moveToCarDetailsCar() {
        Bundle bundle = new Bundle();
        bundle.putString("whereComeFrom", "fromAddItem");
        bundle.putString("specificFragmentType", getResources().getString(R.string.car_make));

        Intent intent = new Intent(AddItem.this, CarDetails.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, STATIC_BACK_VALUE);
        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PICK_FROM_GALLERY:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    Intent i = new Intent(Action.ACTION_MULTIPLE_PICK);
                    startActivityForResult(i, 200);
                } else {
                }
                break;
        }
    }

    private void changeFontType() {
        insertAddTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        textTitleTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        categorySelectedNameTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        completeCarDetailsTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void inti() {
        viewSelectedImageRV = (RecyclerView) findViewById(R.id.add_activity_view_selected_image_RV);
        selectCategoryRV = (RecyclerView) findViewById(R.id.add_activity_view_select_category_RV);
        cancelRL = (RelativeLayout) findViewById(R.id.add_activity_cancelRL);
        textTitleTV = (TextView) findViewById(R.id.add_activity_titleTV);
        completeCarDetailsTV = (TextView) findViewById(R.id.add_activity_complete_car_dTV);
        insertAddTV = (TextView) findViewById(R.id.add_activity_insert_titleTV);
        categorySelectedNameTV = (TextView) findViewById(R.id.add_activity_view_select_category_from_RV_TV);
        selectImageFGRL = (RelativeLayout) findViewById(R.id.add_activity_selectIFG_RL);
        selectVideoRL = (RelativeLayout) findViewById(R.id.add_activity_select_videoRL);
        coverVideoViewRL = (RelativeLayout) findViewById(R.id.add_activity_cover_show_video);
        viewVideoSelected = (VideoView) findViewById(R.id.add_activity_show_video);
        cancelVideoRL = (RelativeLayout) findViewById(R.id.add_activity_cancel_videoRL);
        viewSelectedCategoryCV = (CardView) findViewById(R.id.add_activity_view_select_category_from_RV);
        completeCarDetailsCV = (CardView) findViewById(R.id.add_activity_copmlete_car_details_CV);
        add_activity_complete_car_dCV = (RelativeLayout) findViewById(R.id.add_activity_complete_car_dCV);
        cancelSelectedCategoryRL = (RelativeLayout) findViewById(R.id.add_activity_view_select_category_from_RV_delete);
        imageCategorySelectedIV = (ImageView) findViewById(R.id.add_activity_view_select_category_from_RV_IV);
        showSelectedCarDetailsRL = (RelativeLayout) findViewById(R.id.add_activity_show_car_details);
        categoryContLL = (LinearLayout) findViewById(R.id.add_activity_category_cont);
        cityPhoneNumberRL = (RelativeLayout) findViewById(R.id.add_activity_city_phone_numberRL);
        insertItemBtn = (Button) findViewById(R.id.add_activity_city_insert_Btn);
        messageContainerRL = (RelativeLayout) findViewById(R.id.add_activity_message_container_RL);
        messageContentRL = (RelativeLayout) findViewById(R.id.add_activity_message_cover_RL);
        generalMessageTV = (TextView) findViewById(R.id.add_activity_general_message_content_TV);
        headLL = (LinearLayout) findViewById(R.id.add_activity_general_head_LL);
        progressBar = (ProgressBar) findViewById(R.id.add_item_activity_progress_bar);
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void createCityPhoneNumber() {
        cityPhoneNumberRL.setVisibility(View.VISIBLE);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.selected_city_phone_number_container, fragmentCityPhoneNumber);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    private void ChangeUI() {
        showSelectedCarDetailsRL.setVisibility(View.VISIBLE);
        categoryContLL.setVisibility(View.GONE);
        makeCompleteCarDetailsGone();
    }

    private void createShowSelectedCarDetails(Intent data, int resultCode, int requestCode) {
        // 6 to wheelsRim 7 to car Plates
        if (requestCode == REQUEST_WHEELS_RIM || requestCode == REQUEST_CAR_PLATES) {
            if (requestCode == REQUEST_WHEELS_RIM) {
                Bundle bundle = new Bundle();
                bundle.putString("category", getResources().getString(R.string.wheels_rim));
                bundle.putString("inchSize", data.getExtras().getString("inchSize"));
                bundle.putString("type", data.getExtras().getString("type"));
                bundle.putString("typeS", data.getExtras().getString("typeS"));
                fragmentShowSelectedDetails.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                fragmentShowSelectedDetails.onActivityResult(requestCode, resultCode, data);

                transaction.replace(R.id.selected_car_details_container, fragmentShowSelectedDetails);
                transaction.addToBackStack(null);
                transaction.commit();
                wheelsSize = data.getExtras().getString("inchSize");
                wheelsType = data.getExtras().getString("type");
                wheelsTypeS = data.getExtras().getString("typeS");
            }
            if (requestCode == REQUEST_CAR_PLATES) {
                int specialOrNotInt = 0;
                if (data.getExtras().getString("specialOrNot").equals("special"))
                    specialOrNotInt = 1;
                 carPlatesDetails = new CarPlatesDetails(
                        data.getExtras().getString("carPlatesCity")
                        ,data.getExtras().getString("carPlatesNum")
                        ,specialOrNotInt
                );

                Bundle bundle = new Bundle();
                bundle.putString("category", getResources().getString(R.string.car_plates));
                bundle.putString("carPlatesNum", data.getExtras().getString("carPlatesNum"));
                bundle.putString("carPlatesCity", data.getExtras().getString("carPlatesCity"));
                bundle.putString("specialOrNot", data.getExtras().getString("specialOrNot"));
                fragmentShowSelectedDetails.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                fragmentShowSelectedDetails.onActivityResult(requestCode, resultCode, data);

                transaction.replace(R.id.selected_car_details_container, fragmentShowSelectedDetails);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        } else {
            //pass value to model fragment as object because this we make
            // CarDetailsModel extend from Parcelable to can do this action
            carDetailsModel = (CarDetailsModel) data.getParcelableExtra("carDetailsObject");
            getIntent().putExtra("carDetailsObject", carDetailsModel);
            Bundle bundle = new Bundle();
            bundle.putString("category", categoryCompNow.getCode());
            fragmentShowSelectedDetails.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            fragmentShowSelectedDetails.onActivityResult(requestCode, resultCode, data);

            transaction.replace(R.id.selected_car_details_container, fragmentShowSelectedDetails);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private void showSelectedVideo(Intent data) {
        // String pickedVideoUrl = getRealPathFromUri(getApplicationContext(), data.getDate());
        viewVideoSelected.setVisibility(View.VISIBLE);
        coverVideoViewRL.setVisibility(View.VISIBLE);
        mVideoURI = data.getData();
        viewVideoSelected.setVideoURI(mVideoURI);

        viewVideoSelected.requestFocus();
        viewVideoSelected.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                viewVideoSelected.start();
                replayVideo();
            }
        });
    }

    private void replayVideo() {
        viewVideoSelected.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                viewVideoSelected.start();
            }
        });
    }

    private void getSelectedImagePathes(Intent data) {
        String[] all_path = data.getStringArrayExtra("all_path");

        ArrayList<CustomGallery> dataT = new ArrayList<CustomGallery>();
        imagePathArrL = new ArrayList<String>();

        for (String string : all_path) {
            CustomGallery item = new CustomGallery();
            item.sdcardPath = string;
            imagePathArrL.add(item.sdcardPath);
            dataT.add(item);
        }
    }

    private void showSelectedImage() {
        viewSelectedImageRV.setNestedScrollingEnabled(false);
        viewSelectedImageRV.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(AddItem.this,
                LinearLayoutManager.HORIZONTAL, false);
        viewSelectedImageRV.setLayoutManager(layoutManager);

        selectedImageAdapter = new SelectedImageAdapter(AddItem.this
                , imagePathArrL);
        viewSelectedImageRV.setAdapter(selectedImageAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onDataPass(EditValueInCDM data,EditValueInCDM data2) {
        carDetailsModel =updateCarDetailsModel(carDetailsModel,data.getWhatUserWantToChangeStr(),data.getValueInWhatUserWantToChangeStr(),data2.getValueInWhatUserWantToChangeStr());
    }

    @Override
    public void onDataPassCarPlates(CarPlatesDetails carPlatesDetailsAfterEdit) {
        carPlatesDetails = carPlatesDetailsAfterEdit;
    }

    @Override
    public void onWheelsDataChange(WheelsInfo wheelsInfo) {
        wheelsSize = wheelsInfo.getWheelsSizeStr();
        wheelsType = wheelsInfo.getWheelsTypeStr();
        wheelsTypeS = wheelsInfo.getWheelsTypeSStr();
    }

    @Override
    public void numberOfAllowedAds(String AllowedAds) {
        numberOfAllowedAdsInt = Integer.parseInt(AllowedAds);
    }

    @Override
    public void numberOfAds(String oldAds) {
        numberOfOldAds = Integer.parseInt(oldAds);
    }

    @Override
    public void canInsertAds(String canOrNot) {
        canInsertAndOrNot = Integer.parseInt(canOrNot);
    }

    @Override
    public void canInsertBurnedPrice(String canOrNot) {
        canInsertBurnedPrice = Integer.parseInt(canOrNot);
    }

    @Override
    public void passCategoriesInfo(CategoryComp categoryComp) {
        categoryCompNow = categoryComp;
        if (categoryComp.getCode().equals("wheels_rim") || categoryComp.getCode().equals("car_plates")) {
            if (categoryComp.getCode().equals("wheels_rim")) {
                translateToWheelsRimActivity();
            }
            if (categoryComp.getCode().equals("car_plates")) {
                translateToCarPlatesActivity();
            }
        } else {
            goneRVAndVisableSelectedCategoryAndFillSelectedInfo(categoryComp);
            checkIfNeedToMakeCompleteCarDetailsToBeVisable(categoryComp);
        }
    }
}
