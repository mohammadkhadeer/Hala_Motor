package com.cars.halamotor_obeidat.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.dataBase.DBHelper;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.NotificationComp;
import com.cars.halamotor_obeidat.presnter.CategoriesPresenter;
import com.cars.halamotor_obeidat.presnter.CountryCitesAndAreas;
import com.cars.halamotor_obeidat.presnter.UpdateProfile;
import com.cars.halamotor_obeidat.service.CarBrandsAndModelService;
import com.cars.halamotor_obeidat.view.activity.selectAddress.SelectCityAndNeighborhood;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor_obeidat.functions.Functions.getNotification;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.presnter.CategoriesFromServer.getCategories;
import static com.cars.halamotor_obeidat.presnter.CountryCitesAndArea.getCountryCitesAndAreas;
import static com.cars.halamotor_obeidat.presnter.LoginAndUpdateProfile.updateProfileSuccess;
import static com.cars.halamotor_obeidat.presnter.Setting.getSetting;
import static com.cars.halamotor_obeidat.sharedPreferences.AddressSharedPreferences.getUserAddressFromSP;
import static com.cars.halamotor_obeidat.sharedPreferences.AddressSharedPreferences.saveUserInfoInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.CarsAndModels.getNumberOfUse;
import static com.cars.halamotor_obeidat.sharedPreferences.CarsAndModels.saveUserInfoSP;
import static com.cars.halamotor_obeidat.sharedPreferences.CountryInfo.getCountryId;
import static com.cars.halamotor_obeidat.sharedPreferences.NotificationSharedPreferences.getWelcomeNotificationsInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.NotificationSharedPreferences.updateNumberUnreadNotifications;
import static com.cars.halamotor_obeidat.sharedPreferences.NotificationSharedPreferences.welcomeNotifications;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getPlatform_id;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor_obeidat.staticFiles.StaticFiles.setCategoriesArrayL;

public class SplashScreen extends AppCompatActivity implements CountryCitesAndAreas, UpdateProfile, CategoriesPresenter {

    private static final int SELECT_LOCATION = 555;
    private static final int LOGIN = 556;

    DBHelper myDB;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    CountryCitesAndAreas countryCitesAndAreas;
    UpdateProfile updateProfile;
    CategoriesPresenter categoriesPresenter;
    TextView setup_messageTextView,setup_message_per;
    RelativeLayout setup_profile_message_rl;
    ArrayList<CategoryComp> categoriesArrayL2 = new ArrayList<>();

    int splashScreenTime=0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_splash_screen);
        statusBarColor();

        myDB = getDataBaseInstance(getApplicationContext());
        addWelcomeNotifications();

        //getFBKey();

        Log.i("TAG","Device token: "+getUserTokenInFromSP(getApplicationContext()));

        init();
        changeFont();
        intiPersenters();


        //get all cites and area just run one time when open app first time
        getCitesAndAreasAndCarsSetting();

        setup_profile_message_rl.setVisibility(View.VISIBLE);
        setup_messageTextView.setText(getResources().getString(R.string.setup_message_1));
        setup_message_per.setText(getResources().getString(R.string.setup_message_2));

//        to update brands every user open app 10 the table updates every 10's
        if (getNumberOfUse(this).equals("empty") || getNumberOfUse(this).equals("170")) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
//                    getCarsBrandsAndModel(myDB);
                    splashScreenTime =9500;


                    reqToServerToGetCarsBrandsAndModels();

                }
            }, 2500);
        }else{
            splashScreenTime =700;
            setup_profile_message_rl.setVisibility(View.GONE);
            updateNumberOfOpenApp();
            Log.w("TAG","number of use insaid else"+ getNumberOfUse(this));
            loginCheck();
        }

    }

    private void getFBKey() {
        Log.d("TAG", "getFBKey");

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.cars.halamotor",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("TAG KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e) {
            Log.d("TAG KeyHash:", e.getMessage());
        }
        catch (NoSuchAlgorithmException e) {
            Log.d("TAG KeyHash:", e.getMessage());
        }
    }

    private void getCitesAndAreasAndCarsSetting() {
        if (getCountryId(this).equals("empty")) {
            getCountryCitesAndAreas(countryCitesAndAreas,myDB,getApplicationContext());
            if (checkIfAndroidVBiggerThan9()) {
                getSetting(myDB);
            }
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                }
//            });
//            thread.start();
        }
    }

    private void init() {
        setup_messageTextView = (TextView) findViewById(R.id.setup_message);
        setup_message_per = (TextView) findViewById(R.id.setup_message_per);
        setup_profile_message_rl = (RelativeLayout) findViewById(R.id.setup_profile_message_rl);

    }

    private void changeFont() {
        setup_messageTextView.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        setup_message_per.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void updateNumberOfOpenApp() {
        if (!getNumberOfUse(this).equals("empty")) {
            String numberOfUse = getNumberOfUse(this);
            int i = Integer.parseInt(numberOfUse);
            i = i + 1;
            saveUserInfoSP(this, String.valueOf(i));
        }else{
            saveUserInfoSP(this, String.valueOf(1));
        }
    }

    private void reqToServerToGetCarsBrandsAndModels() {
        myDB.deleteAllCarsBrands();
        myDB.deleteAllCarsModel();

        Intent intent = new Intent(this, CarBrandsAndModelService.class);
        this.startService(intent);
        //CarBrandsAndModelService

        updateNumberOfOpenApp();
        loginCheck();
    }

    private void intiPersenters() {
        this.countryCitesAndAreas = (CountryCitesAndAreas) this;
        this.updateProfile = (UpdateProfile) this;
        this.categoriesPresenter= (CategoriesPresenter) this;
    }

    private void loginCheck() {
        Log.i("TAG","getPlatform_id(this): "+getPlatform_id(this));
        Log.i("TAG","ggetUserAddressFromSP(this): "+getUserAddressFromSP(this));
        if (getPlatform_id(this).equals("empty"))
        {
            transportToLoginScreen();
        }
        else{
            if (getUserAddressFromSP(this) == null)
            {
                selectAddress();
            }else {
                transportToMainActivity();
            }
        }
    }

    public void Get_hash_key() {
        //to get fb hash key
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.cars.halamotor", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN && resultCode == Activity.RESULT_OK) {
            selectAddress();
        }
        if (requestCode == SELECT_LOCATION && resultCode == Activity.RESULT_OK) {
            String city_en = data.getStringExtra("city_en");
            String city_ar = data.getStringExtra("city_ar");
            String city_code = data.getStringExtra("city_code");
            String city_id = data.getStringExtra("city_id");
            String area_id = data.getStringExtra("area_id");
            String area_name_en = data.getStringExtra("area_name_en");
            String area_name_ar = data.getStringExtra("area_name_ar");

            saveUserInfoInSP(this,city_en,city_ar,city_code,city_id,area_id,area_name_en,area_name_ar);
            updateProfileSuccess(
                    getUserTokenFromServer(getApplicationContext())
                    ,updateProfile,area_id,area_name_en,getUserTokenInFromSP(getApplicationContext()));
            //updateCityNeighborhood(this,cityS,neighborhoodS);
            splashScreenTime =700;
            transportToMainActivity();
        }
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void selectAddress() {
            Bundle bundle = new Bundle();
            bundle.putString("whereComeFrom", "activity");

            Intent intent = new Intent(SplashScreen.this, SelectCityAndNeighborhood.class);
            intent.putExtras(bundle);
            startActivityForResult(intent , SELECT_LOCATION);
            overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            //finish();
    }

    private void transportToLoginScreen() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                setup_profile_message_rl.setVisibility(View.GONE);

                Bundle bundle = new Bundle();
                bundle.putString("address", "splash");

                Intent intent = new Intent(SplashScreen.this, LoginWithSocialMedia.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , LOGIN);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//                finish();
            }
        }, splashScreenTime);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addWelcomeNotifications() {
        if (getWelcomeNotificationsInSP(this) ==null)
        {
            NotificationComp welcomeNotification = getNotification(
                    "welcome", "Hala Motor" ,this,"welcome","welcome","welcome","welcome","welcome","welcome"
                    ,"R.drawable.logo"
            );
            if (insertNotificationTable(welcomeNotification,getDataBaseInstance(this)) == true)
            {
                welcomeNotifications(this,sharedPreferences,editor,"created");
                updateNumberUnreadNotifications(this,sharedPreferences,editor,String.valueOf(1));
            }
        }
    }

    private void transportToMainActivity() {
        Log.w("TAG","categoriesPresenter");
        getCategories(categoriesPresenter);
    }


    @Override
    public void countryCitesAreasInfo() {
        Log.w("TAG","Area and Citeis complete");

    }

    @Override
    public void updateSuccess(JSONObject obj) {
        Log.w("TAG","Update personal info complete");
    }

    @Override
    public void whenGetCategoriesSuccess(final ArrayList<CategoryComp> categoriesArrayL) {
        Log.i("TAG","categories: "+String.valueOf(categoriesArrayL.size()));
        categoriesArrayL2 = categoriesArrayL;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                setCategoriesArrayL(categoriesArrayL);
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                intent.putExtra("categories",categoriesArrayL);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                finish();
            }
        }, splashScreenTime);
    }
}
