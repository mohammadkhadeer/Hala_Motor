package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.NotificationComp;
import com.cars.halamotor.presnter.CountryCitesAndAreas;
import com.cars.halamotor.presnter.ModelsInstald;
import com.cars.halamotor.presnter.UpdateProfile;
import com.cars.halamotor.service.CarBrandsAndModelService;
import com.cars.halamotor.view.activity.selectAddress.SelectCityAndNeighborhood;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertNotificationTable;
import static com.cars.halamotor.functions.Functions.getNotification;
import static com.cars.halamotor.presnter.CarsBrandsAndModels.getCarsBrandsAndModel;
import static com.cars.halamotor.presnter.CountryCitesAndArea.getCountryCitesAndAreas;
import static com.cars.halamotor.presnter.LoginAndUpdateProfile.updateProfileSuccess;
import static com.cars.halamotor.sharedPreferences.AddressSharedPreferences.getUserAddressFromSP;
import static com.cars.halamotor.sharedPreferences.AddressSharedPreferences.saveUserInfoInSP;
import static com.cars.halamotor.sharedPreferences.CarsAndModels.getNumberOfUse;
import static com.cars.halamotor.sharedPreferences.CarsAndModels.saveUserInfoSP;
import static com.cars.halamotor.sharedPreferences.CountryInfo.getCountryId;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.getWelcomeNotificationsInSP;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.updateNumberUnreadNotifications;
import static com.cars.halamotor.sharedPreferences.NotificationSharedPreferences.welcomeNotifications;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getPlatform_id;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserEmail;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserName;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.cars.halamotor.sharedPreferences.SharedPreferencesInApp.checkIfUserRegisterOnServerSP;

public class SplashScreen extends AppCompatActivity implements CountryCitesAndAreas, UpdateProfile ,ModelsInstald{

    private static final int SELECT_LOCATION = 555;
    private static final int LOGIN = 556;

    DBHelper myDB;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    CountryCitesAndAreas countryCitesAndAreas;
    UpdateProfile updateProfile;
    ModelsInstald modelsInstald;
    TextView setup_messageTextView,setup_message_per;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        statusBarColor();

        myDB = getDataBaseInstance(getApplicationContext());
        addWelcomeNotifications();
        deleteOldData();
        init();
        changeFont();
        intiPersenters();

        //get all cites and area just run one time when open app first time
        if (getCountryId(this) == "empty") {
            getCountryCitesAndAreas(countryCitesAndAreas,myDB,getApplicationContext());
        }

//        to update brands every user open app 10 the table updates every 10's
        if (getNumberOfUse(this) == "empty" || getNumberOfUse(this).equals("70")) {
            reqToServerToGetCarsBrandsAndModels();
        }else{
            updateNumberOfOpenApp();
            Log.w("TAG","number of use insaid else"+ getNumberOfUse(this));
            loginCheck();
        }

    }

    private void init() {
        setup_messageTextView = (TextView) findViewById(R.id.setup_message);
        setup_message_per = (TextView) findViewById(R.id.setup_message_per);
    }

    private void changeFont() {
        setup_messageTextView.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
        setup_message_per.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void updateNumberOfOpenApp() {
        if (getNumberOfUse(this) != "empty") {
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

        setup_messageTextView.setText(getApplicationContext().getResources().getString(R.string.setup_message_1));
        setup_message_per.setText(getApplicationContext().getResources().getString(R.string.setup_message_2));
        updateNumberOfOpenApp();
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                getCarsBrandsAndModel(myDB);
//            }
//        }, 1500);
    }

    private void intiPersenters() {
        this.countryCitesAndAreas = (CountryCitesAndAreas) this;
        this.updateProfile = (UpdateProfile) this;
        this.modelsInstald = (ModelsInstald) this;
    }

    private void loginCheck() {
        Log.w("TAG","loginCheck");
        Log.w("TAG","getPlatform_id(this): "+getPlatform_id(this));
        Log.w("TAG","getUserAddressFromSP(this): "+getUserAddressFromSP(this));
        if (getPlatform_id(this) == "empty")
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
                    ,updateProfile,area_id,area_name_en);
            //updateCityNeighborhood(this,cityS,neighborhoodS);

            transportToMainActivity();
        }
    }

    private void deleteOldData() {
        getDataBaseInstance(getApplicationContext()).deleteAllItem();
        getDataBaseInstance(getApplicationContext()).deleteCCEMTItem();
        getDataBaseInstance(getApplicationContext()).deleteWheels_RimItem();
        getDataBaseInstance(getApplicationContext()).deleteCarPlatesItem();
        getDataBaseInstance(getApplicationContext()).deleteAccAndJunkItem();
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
                Bundle bundle = new Bundle();
                bundle.putString("address", "splash");

                Intent intent = new Intent(SplashScreen.this, LoginWithSocialMedia.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , LOGIN);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//                finish();
            }
        }, 1000);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addWelcomeNotifications() {
        if (getWelcomeNotificationsInSP(this) ==null)
        {
            NotificationComp welcomeNotification = getNotification(
                    "welcome", "Hala Motor" ,this,"welcome","welcome","welcome"
                    ,"R.dra  wable.logo"
            );
            if (insertNotificationTable(welcomeNotification,getDataBaseInstance(this)) == true)
            {
                welcomeNotifications(this,sharedPreferences,editor,"created");
                updateNumberUnreadNotifications(this,sharedPreferences,editor,String.valueOf(1));
            }
        }
    }

    private void transportToMainActivity() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
                finish();
            }
        }, 1000);
    }


    @Override
    public void countryCitesAreasInfo() {
        Log.w("TAG","Area and Citeis complete");
        loginCheck();
    }

    @Override
    public void updateSuccess(JSONObject obj) {
        Log.w("TAG","Update personal info complete");
    }

    @Override
    public void insertedSuccess() {
        Log.w("TAG","installed Success ...");
        //setup_messageTextView.setVisibility(View.GONE);
        //setup_message_per.setVisibility(View.GONE);

        loginCheck();
    }

}
