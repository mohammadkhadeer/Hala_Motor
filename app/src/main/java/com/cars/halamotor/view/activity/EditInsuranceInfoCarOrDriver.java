package com.cars.halamotor.view.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.view.fragments.carInformationFragment.AgencyRepair;
import com.cars.halamotor.view.fragments.carInformationFragment.CarCondition;
import com.cars.halamotor.view.fragments.carInformationFragment.CarMakeFragment;
import com.cars.halamotor.view.fragments.carInformationFragment.CitiesFragment;
import com.cars.halamotor.view.fragments.carInformationFragment.CylinderNumberFragment;
import com.cars.halamotor.view.fragments.carInformationFragment.InsurancePolicy;
import com.cars.halamotor.view.fragments.carInformationFragment.LicenceExpired;
import com.cars.halamotor.view.fragments.carInformationFragment.ModelFragment;
import com.cars.halamotor.view.fragments.carInformationFragment.ModifiedFragment;
import com.cars.halamotor.view.fragments.carInformationFragment.YearFragment;
import com.cars.halamotor.view.fragments.driverInformationFragment.BirthDay;
import com.cars.halamotor.view.fragments.driverInformationFragment.CertificateClaim;
import com.cars.halamotor.view.fragments.driverInformationFragment.DriverDuration;
import com.cars.halamotor.view.fragments.driverInformationFragment.DriverNationality;
import com.cars.halamotor.view.fragments.driverInformationFragment.Email;
import com.cars.halamotor.view.fragments.driverInformationFragment.InsurancePay;
import com.cars.halamotor.view.fragments.driverInformationFragment.LicenceNationality;
import com.cars.halamotor.view.fragments.driverInformationFragment.Name;
import com.cars.halamotor.view.fragments.driverInformationFragment.PhoneNumber;
import com.cars.halamotor.view.fragments.driverInformationFragment.RegisterDate;

import java.util.Locale;

import static com.cars.halamotor.functions.Functions.setLocale;

public class EditInsuranceInfoCarOrDriver extends AppCompatActivity {

    DriverNationality driverNationality = new DriverNationality();
    LicenceNationality licenceNationality = new LicenceNationality();
    DriverDuration driverDuration = new DriverDuration();
    RegisterDate registerDate = new RegisterDate();
    InsurancePay insurancePay = new InsurancePay();
    CertificateClaim certificateClaim = new CertificateClaim();
    Name name = new Name();
    PhoneNumber phoneNumber = new PhoneNumber();
    Email email = new Email();
    BirthDay birthDay = new BirthDay();

    CarMakeFragment carMakeFragment = new CarMakeFragment();
    ModelFragment modelFragment = new ModelFragment();
    YearFragment yearFragment = new YearFragment();
    CarCondition carCondition = new CarCondition();
    CylinderNumberFragment cylinderNumberFragment = new CylinderNumberFragment();
    CitiesFragment citiesFragment = new CitiesFragment();
    LicenceExpired licenceExpired = new LicenceExpired();
    ModifiedFragment modifiedFragment = new ModifiedFragment();
    InsurancePolicy insurancePolicy = new InsurancePolicy();
    AgencyRepair agencyRepair = new AgencyRepair();

    String processType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_edit_driver_info);

        statusBarColor();
        actionBarTitle();

        switch (getProcessTypeSFromIntent()) {
            case "Nationality":
                handelNationalityFragment();
                break;
            case "License Nationality":
                handelLicenseNationalityFragment();
                break;
            case "Drive duration":
                handelDriverDurationFragment();
                break;
            case "Register Date":
                handelRegisterDateFragment();
                break;
            case "Insurance pay":
                handelInsurancePayFragment();
                break;
            case "Certificate claims":
                handelCertificateClaimFragment();
                break;
            case "Name":
                handelNameFragment();
                break;
            case "Phone number":
                handelPhoneFragment();
                break;
            case "Email":
                handelEmailFragment();
                break;
            case "Birth day":
                handelBDFragment();
                break;
            case "Car make":
                handelCarMake();
                break;
            case "Car model":
                handelCarModel();
                break;
            case "Car year":
                handelCarYear();
                break;
            case "Car condition":
                handelCarCondition();
                break;
            case "Car cylinder":
                handelCarCylinder();
                break;
            case "City":
                handelCity();
                break;
            case "Licence expired":
                handelLicenceExpired();
                break;
            case "Follow GCC":
                handelFollowGCCFragment();
                break;
            case "Insurance policy":
                handelInsurancePolicyFragment();
                break;
            case "Agency repair":
                handelAgencyRepairFragment();
                break;
        }

    }

    private void handelAgencyRepairFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        agencyRepair.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, agencyRepair)
                .commit();
    }

    private void handelInsurancePolicyFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        insurancePolicy.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, insurancePolicy)
                .commit();
    }

    private void handelFollowGCCFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        modifiedFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, modifiedFragment)
                .commit();
    }

    private void handelCity() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        citiesFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, citiesFragment)
                .commit();
    }

    private void handelLicenceExpired() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        licenceExpired.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, licenceExpired)
                .commit();
    }

    private void handelCarCylinder() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        cylinderNumberFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, cylinderNumberFragment)
                .commit();
    }

    private void handelCarYear() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        yearFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, yearFragment)
                .commit();
    }

    private void handelCarCondition() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        carCondition.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, carCondition)
                .commit();
    }

    private void handelCarModel() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        modelFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, modelFragment)
                .commit();
    }

    private void handelCarMake() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        carMakeFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, carMakeFragment)
                .commit();
    }

    private void handelLicenseNationalityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        licenceNationality.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, licenceNationality)
                .commit();
    }

    private void handelDriverDurationFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        driverDuration.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, driverDuration)
                .commit();
    }

    private void handelRegisterDateFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        registerDate.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, registerDate)
                .commit();
    }

    private void handelInsurancePayFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        insurancePay.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, insurancePay)
                .commit();
    }

    private void handelCertificateClaimFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        certificateClaim.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, certificateClaim)
                .commit();
    }

    private void handelNameFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        name.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, name)
                .commit();
    }

    private void handelPhoneFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        phoneNumber.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, phoneNumber)
                .commit();
    }

    private void handelEmailFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        email.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, email)
                .commit();
    }

    private void handelBDFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        birthDay.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, birthDay)
                .commit();
    }

    private void handelNationalityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","edit");
        driverNationality.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info_fragments, driverNationality)
                .commit();
    }

    private String getProcessTypeSFromIntent() {
        Bundle bundle = getIntent().getExtras();
        processType =bundle.getString("processTypeS");
        return processType;
    }

    private String getProcessTypeFromIntent() {
        Bundle bundle = getIntent().getExtras();
        String processType =bundle.getString("processType");
        return processType;
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void actionBarTitle() {
        Typeface typeface;
        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        if (Locale.getDefault().getLanguage().equals("ar")) {
            typeface = Typeface.createFromAsset(getAssets(), "GE_DINAR_ONE_LIGHT.TTF");
        }else{
            typeface = Typeface.createFromAsset(getAssets(), "NTAILU.TTF");
        }
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setTextColor(Color.parseColor("#FF0000"));
        textviewTitle.setText(getProcessTypeFromIntent());
        textviewTitle.setTypeface(typeface);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);
    }

    @Override
    public void onBackPressed() {
        switch (getProcessTypeSFromIntent()) {
            case "Nationality":
                driverNationality.endDriverNationality();
                break;
            case "License Nationality":
                licenceNationality.endDriverNationality();
                break;
            case "Drive duration":
                driverDuration.endDriverNationality();
                break;
            case "Register Date":
                registerDate.endDriverNationality();
                break;
            case "Insurance pay":
                insurancePay.endDriverNationality();
                break;
            case "Certificate claims":
                certificateClaim.endDriverNationality();
                break;
            case "Name":
                name.endDriverNationality();
                break;
            case "Phone number":
                phoneNumber.endDriverNationality();
                break;
            case "Email":
                email.endDriverNationality();
                break;
            case "Birth day":
                birthDay.endDriverNationality();
                break;
            case "Car make":
                carMakeFragment.endDriverNationality();
                break;
            case "Car model":
                modelFragment.endDriverNationality();
                break;
            case "Car year":
                yearFragment.endDriverNationality();
                break;
            case "Car Condition":
                carCondition.endDriverNationality();
                break;
            case "Car cylinder":
                cylinderNumberFragment.endDriverNationality();
                break;
            case "City":
                citiesFragment.endDriverNationality();
                break;
            case "Licence expired":
                licenceExpired.endDriverNationality();
                break;
            case "Follow GCC":
                modifiedFragment.endDriverNationality();
                break;
            case "Insurance policy":
                insurancePolicy.endDriverNationality();
                break;
            case "Agency repair":
                agencyRepair.endDriverNationality();
                break;
        }
    }
}