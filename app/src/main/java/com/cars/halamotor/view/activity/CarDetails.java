package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CarColor;
import com.cars.halamotor.model.CarCondition;
import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CarFuel;
import com.cars.halamotor.model.CarInsurance;
import com.cars.halamotor.model.CarLicensed;
import com.cars.halamotor.model.CarMake;
import com.cars.halamotor.model.CarModel;
import com.cars.halamotor.model.CarTransmission;
import com.cars.halamotor.model.PaymentMethod;
import com.cars.halamotor.presnter.CarsBrandsAndModels;
import com.cars.halamotor.presnter.carDetails.CarBrand;
import com.cars.halamotor.presnter.carDetails.CarColorPresnter;
import com.cars.halamotor.presnter.carDetails.CarConditionPresnter;
import com.cars.halamotor.presnter.carDetails.CarFuelPresnter;
import com.cars.halamotor.presnter.carDetails.CarInsurancePresnter;
import com.cars.halamotor.presnter.carDetails.CarKilometers;
import com.cars.halamotor.presnter.carDetails.CarLicensedPresnter;
import com.cars.halamotor.presnter.carDetails.CarModelDetails;
import com.cars.halamotor.presnter.carDetails.CarOptionsPresnter;
import com.cars.halamotor.presnter.carDetails.CarPaymentMethodPresnter;
import com.cars.halamotor.presnter.carDetails.CarTransmissionPresnter;
import com.cars.halamotor.presnter.carDetails.CarYear;
import com.cars.halamotor.view.fragments.ShowSelectedCarDetailsFragment;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentCarCondition;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentCarMake;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentColor;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentFuel;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentInsurance;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentKilometers;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentLicensed;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentModel;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentOptions;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentPaymentMethod;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentTransmission;
import com.cars.halamotor.view.fragments.carDetailsFragment.FragmentYear;

import java.io.Serializable;
import java.util.ArrayList;

import static com.cars.halamotor.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor.functions.NewFunction.convertYearToEng;


public class CarDetails extends AppCompatActivity implements CarBrand , CarModelDetails , CarYear , CarConditionPresnter
                                                             , CarKilometers , CarTransmissionPresnter , CarFuelPresnter
                                                             , CarOptionsPresnter , CarLicensedPresnter , CarInsurancePresnter
                                                             , CarColorPresnter , CarPaymentMethodPresnter {

   RelativeLayout backRl,cancelRl;
   TextView titleTV;

    ArrayList<String> carDetailsProNowArrayL = new ArrayList<String>();

    final Fragment fragmentCarMake = new FragmentCarMake();
    final Fragment fragmentModel = new FragmentModel();
    final Fragment fragmentYear = new FragmentYear();
    final Fragment fragmentCondition = new FragmentCarCondition();
    final Fragment fragmentKilometers = new FragmentKilometers();
    final Fragment fragmentTransmission = new FragmentTransmission();
    final Fragment fragmentFuel = new FragmentFuel();
    final Fragment fragmentOptions = new FragmentOptions();
    final Fragment fragmentLicensed = new FragmentLicensed();
    final Fragment fragmentInsurance = new FragmentInsurance();
    final Fragment fragmentColor = new FragmentColor();
    final Fragment fragmentPaymentMethod = new FragmentPaymentMethod();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentCarMake;
    String whereComeFromStr,fragmentTypeStr,carMakeStr,carOptionStr;
    CarDetailsModel carDetailsModel= new CarDetailsModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        statusBarColor();
        init();
        getStringFromIntent();
        checkComeFromWhereAndIntiStartFragment();
        actionListener();
        changeFontType();
    }

    private void passObjectFromCarDetailsToAddItem(String dictionaryStr,String dictionaryStr2
            ,String valueStr,String valueStr2) {
        Intent resultIntent = new Intent();
        if (dictionaryStr.equals("model"))
        {
            resultIntent.putExtra(dictionaryStr, valueStr);
            resultIntent.putExtra(dictionaryStr2, valueStr2);
            resultIntent.putExtra("make", carMakeStr);
        }else {
            resultIntent.putExtra(dictionaryStr, valueStr);
            resultIntent.putExtra(dictionaryStr2, valueStr2);
            resultIntent.putExtra("make", "nothing_to_pass");
        }
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void checkComeFromWhereAndIntiStartFragment() {
        if (whereComeFromStr.equals("fromAddItem") && fragmentTypeStr.equals(getResources().getString(R.string.car_make)))
        {
            intiCarMakeFragmentSpecific(fragmentCarMake,getResources().getString(R.string.car_make));
        }

        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.car_make)))
        {
            intiCarMakeFragmentSpecific(fragmentCarMake,getResources().getString(R.string.car_make));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.model)))
        {
            intiCarMakeFragmentSpecific(fragmentModel,getResources().getString(R.string.model));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.year)))
        {
            intiCarMakeFragmentSpecific(fragmentYear,getResources().getString(R.string.year));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.condition)))
        {
            intiCarMakeFragmentSpecific(fragmentCondition,getResources().getString(R.string.condition));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.kilometers)))
        {
            intiCarMakeFragmentSpecific(fragmentKilometers,getResources().getString(R.string.kilometers));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.transmission)))
        {
            intiCarMakeFragmentSpecific(fragmentTransmission,getResources().getString(R.string.transmission));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.fuel)))
        {
            intiCarMakeFragmentSpecific(fragmentFuel,getResources().getString(R.string.fuel));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.car_options)))
        {
            intiCarMakeFragmentSpecific(fragmentOptions,getResources().getString(R.string.car_options));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.car_license)))
        {
            intiCarMakeFragmentSpecific(fragmentLicensed,getResources().getString(R.string.car_license));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.insurance)))
        {
            intiCarMakeFragmentSpecific(fragmentInsurance,getResources().getString(R.string.insurance));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.color)))
        {
            intiCarMakeFragmentSpecific(fragmentColor,getResources().getString(R.string.color));
        }
        if (whereComeFromStr.equals("fromAShowSelected") && fragmentTypeStr.equals(getResources().getString(R.string.payment_method)))
        {
            intiCarMakeFragmentSpecific(fragmentPaymentMethod,getResources().getString(R.string.payment_method));
        }
    }

    private void intiCarMakeFragmentSpecific(Fragment fragment,String titleStr) {
        //pass value to model fragment
        if (titleStr.equals(getResources().getString(R.string.model)) || titleStr.equals(getResources().getString(R.string.car_options)) )
        {
            if (titleStr.equals(getResources().getString(R.string.model)))
            {
                Bundle bundle = new Bundle();
                bundle.putString("whereComeFrom", "fromFragment");
                bundle.putString("carMake", carMakeStr);
                fragmentModel.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.car_details_container, fragmentModel);
                transaction.setCustomAnimations
                        (R.anim.right_to_left, R.anim.no_animation).show(fragmentModel);
                transaction.addToBackStack(null);
                transaction.commit();

                changeHeadTitle(getResources().getString(R.string.model));
            }
            if (titleStr.equals(getResources().getString(R.string.car_options)))
            {
                //pass value to model fragment
                Bundle bundle = new Bundle();
                bundle.putString("whereComeFrom", "fromFragment");
                bundle.putString("options", carOptionStr);
                fragmentOptions.setArguments(bundle);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.car_details_container, fragmentOptions);
                transaction.setCustomAnimations
                        (R.anim.right_to_left, R.anim.no_animation).show(fragmentOptions);
                transaction.addToBackStack(null);
                transaction.commit();

                changeHeadTitle(getResources().getString(R.string.car_options));
            }
        }else{
            carDetailsProNowArrayL.add(getResources().getString(R.string.car_make));
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.car_details_container, fragment);
            transaction.show(fragment);
            transaction.addToBackStack(null);
            transaction.commit();

            changeHeadTitle(titleStr);
        }
    }

    private void getStringFromIntent() {
        Bundle bundle = getIntent().getExtras();
        whereComeFromStr =bundle.getString("whereComeFrom");
        fragmentTypeStr =bundle.getString("specificFragmentType");
        if (fragmentTypeStr.equals(getResources().getString(R.string.model)))
        {
            carMakeStr =bundle.getString("ifPressModelPassCarMake");
        }
        if (fragmentTypeStr.equals(getResources().getString(R.string.car_options)))
        {
            carOptionStr =bundle.getString("options");
        }
    }

    private void actionListener() {
        backRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfLastFragmentFinshActivityElseMoveToPrivuseFragment();
            }
        });
        cancelRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void changeHeadTitle(String title) {
        titleTV.setText(title);
    }

    private void moveFromColorFragmentToPaymentFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.payment_method));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentPaymentMethod);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentPaymentMethod);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void passCarMakeToModeFragmentAndMove(CarMake carMake) {
        // add fragment and translate to next fragment

        //add car model on arrayList to check when user press back finsh or move tp privuse fragment
        carDetailsProNowArrayL.add(getResources().getString(R.string.model));
        //pass value to model fragment
        Bundle bundle = new Bundle();
        bundle.putString("carMake", carMake.getName_en());
        fragmentModel.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentModel);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentModel);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromInsuranceFragmentToColorFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.color));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentColor);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentColor);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromLicensedFragmentToInsuranceFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.insurance));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentInsurance);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentInsurance);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromOptionsFragmentToLicensedFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.car_license));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentLicensed);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentLicensed);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromFuelFragmentToOptionsFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.car_options));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentOptions);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentOptions);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromTransmissionFragmentToFuelFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.fuel));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentFuel);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentFuel);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromConditionFragmentToTransmissionFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.transmission));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentTransmission);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentTransmission);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromConditionFragmentToKilometersFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.kilometers));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentKilometers);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentKilometers);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromYearFragmentToCondtionFragment() {
        carDetailsProNowArrayL.add(getResources().getString(R.string.condition));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentCondition);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentCondition);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveFromModelFragmentToYearFragment() {
        //add car year on arrayList to check when user press back finish or move tp privuse fragment
        carDetailsProNowArrayL.add(getResources().getString(R.string.year));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.car_details_container, fragmentYear);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentYear);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void changeFontType() {
        titleTV.setTypeface(Functions.changeFontBold(getApplicationContext()));
    }

    private void init() {
        backRl = (RelativeLayout) findViewById(R.id.car_details_activity_back_RL);
        cancelRl = (RelativeLayout) findViewById(R.id.car_details_activity_cancel_RL);
        titleTV = (TextView) findViewById(R.id.car_details_activity_title_TV);
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void checkIfLastFragmentFinshActivityElseMoveToPrivuseFragment() {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            finish();
        }else{
            if (carDetailsProNowArrayL != null && !carDetailsProNowArrayL.isEmpty()) {
                String lastFragment = carDetailsProNowArrayL.get(carDetailsProNowArrayL.size()-1);
                if (lastFragment.equals(getResources().getString(R.string.car_make)))
                {
                    finish();
                } else
                {
                    changeHeadTitle(carDetailsProNowArrayL.get(carDetailsProNowArrayL.size()-2));
                    fm.popBackStack();
                    carDetailsProNowArrayL.remove(carDetailsProNowArrayL.size()-1);
                }
            }else{
                finish();
            }
        }
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        checkIfLastFragmentFinshActivityElseMoveToPrivuseFragment();
    }

    @Override
    public void passCarBrand(CarMake carMake) {
        passCarMakeToModeFragmentAndMove(carMake);
        changeHeadTitle(getResources().getString(R.string.model));
        carDetailsModel.setCarMake(carMake);
    }





















    @Override
    public void passCarModelDetails(CarModel carModel) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedCarModel(carModel);
        }else {
            moveFromModelFragmentToYearFragment();
            changeHeadTitle(getResources().getString(R.string.year));
            carDetailsModel.setCarModel(carModel);
        }
    }

    @Override
    public void passCarYear(String carYear) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedYear(carYear);
        }else{
            moveFromYearFragmentToCondtionFragment();
            changeHeadTitle(getResources().getString(R.string.condition));
            carDetailsModel.setYearStr(carYear);
        }
    }

    @Override
    public void passCarCondition(CarCondition carCondition) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedCondition(carCondition);
        }else {
            moveFromConditionFragmentToKilometersFragment();
            changeHeadTitle(getResources().getString(R.string.kilometers));
            carDetailsModel.setCarCondition(carCondition);
        }
    }

    @Override
    public void passCarKilometers(String carKilometers) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedKilometers(carKilometers);
        }else {
            moveFromConditionFragmentToTransmissionFragment();
            changeHeadTitle(getResources().getString(R.string.transmission));
            carDetailsModel.setKilometersStr(carKilometers);
        }
    }

    @Override
    public void passCarCondition(CarTransmission carTransmission) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedTransmission(carTransmission);
        }else {
            moveFromTransmissionFragmentToFuelFragment();
            changeHeadTitle(getResources().getString(R.string.fuel));
            carDetailsModel.setCarTransmission(carTransmission);
        }
    }

    @Override
    public void passCarFuel(CarFuel carFuel) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedFuel(carFuel);
        }else {
            moveFromFuelFragmentToOptionsFragment();
            changeHeadTitle(getResources().getString(R.string.car_options));
            carDetailsModel.setCarFuel(carFuel);
        }
    }

    @Override
    public void passCarOptions(String carOptions,ArrayList<String> selectedOptions) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedOptions(carOptions,selectedOptions);
        }else {
            moveFromOptionsFragmentToLicensedFragment();
            changeHeadTitle(getResources().getString(R.string.car_license));
            carDetailsModel.setCarOptionsStr(carOptions);
            carDetailsModel.setCar_options_array(selectedOptions);
        }
    }

    @Override
    public void passCarLicensed(CarLicensed carLicensed) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedLicensed(carLicensed);
        }else {
            moveFromLicensedFragmentToInsuranceFragment();
            changeHeadTitle(getResources().getString(R.string.insurance));
            carDetailsModel.setCarLicensed(carLicensed);
        }
    }

    @Override
    public void passCarInsurance(CarInsurance carInsurance) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedInsurance(carInsurance);
        }else {
            moveFromInsuranceFragmentToColorFragment();
            changeHeadTitle(getResources().getString(R.string.color));
            carDetailsModel.setCarInsurance(carInsurance);
        }
    }

    @Override
    public void passCarColor(CarColor carColor) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedColor(carColor);
        }else {
            moveFromColorFragmentToPaymentFragment();
            changeHeadTitle(getResources().getString(R.string.payment_method));
            carDetailsModel.setCarColorStr(getTextEngOrLocal(getApplicationContext(),carColor.getSetting_content_name_en(),carColor.getSetting_content_name_ar()));
        }
    }

    @Override
    public void passPaymentMethod(PaymentMethod paymentMethod) {
        if (whereComeFromStr.equals("fromAShowSelected"))
        {
            passEditedPaymentMethod(paymentMethod);
        }else {
            carDetailsModel.setPaymentMethod(paymentMethod);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("carDetailsObject", carDetailsModel);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
    }



    private void passEditedCarModel(CarModel carModel) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "model");
        resultIntent.putExtra("model", carModel);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedYear(String year) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "year");
        resultIntent.putExtra("year", year);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedCondition(CarCondition carCondition) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "condition");
        resultIntent.putExtra("car_condition", carCondition);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedKilometers(String kilometers) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "kilometers");
        resultIntent.putExtra("kilometers", kilometers);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedTransmission(CarTransmission carTransmission) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "transmission");
        resultIntent.putExtra("transmission", carTransmission);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedFuel(CarFuel carFuel) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "fuel");
        resultIntent.putExtra("fuel", carFuel);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedOptions(String options, ArrayList<String> selectedOptionCode) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "options");
        resultIntent.putExtra("options", options);
        resultIntent.putStringArrayListExtra("option_array_list", selectedOptionCode);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedLicensed(CarLicensed carLicensed) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "licensed");
        resultIntent.putExtra("licensed", carLicensed);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedInsurance(CarInsurance carInsurance) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "insurance");
        resultIntent.putExtra("insurance", carInsurance);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedColor(CarColor carColor) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "color");
        resultIntent.putExtra("color", carColor);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void passEditedPaymentMethod(PaymentMethod paymentMethod) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("where_edit", "payment");
        resultIntent.putExtra("payment", paymentMethod);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
