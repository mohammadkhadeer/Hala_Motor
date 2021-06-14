package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
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
import com.cars.halamotor.view.fragments.insuranceFargment.CounterProcess;

import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.functions.InsuranceFunctions.numberOfCarProcessSelected;
import static com.cars.halamotor.functions.InsuranceFunctions.numberOfDriverProcessSelected;

public class CompleteInsuranceInfo extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
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
    CounterProcess counterProcess = new CounterProcess();

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

    Fragment allFragment[] = {driverNationality,licenceNationality,driverDuration,registerDate,insurancePay
    ,certificateClaim,name,phoneNumber,email,birthDay};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_complete_insurance_info);

        inti();
        changeFont();
        fillIntiInfo();
        createCounterFragment();
        if (getCompleteOrIntiFromIntent().equals("inti"))
            if (getDriverOrCarFromIntent().equals("driver"))
                handelNationalityFragment();
            else
                handelCarMake();
            else
                if (getDriverOrCarFromIntent().equals("driver"))
                    nextFragment(getNextFragmentFromIntent());
                else
                    nextFragmentCar(getNextFragmentFromIntent());
    }

    public void nextFragmentCar(String fragmentCarNext) {
        switch (fragmentCarNext) {
            case "Car make":
                handelCarMake();
                break;
            case "Car model":
                handelModelFragment();
                break;
            case "Car year":
                handelCarYearFragment();
                break;
            case "Car condition":
                handelConditionFragment();
                break;
            case "Car cylinder":
                handelCarCylinderFragment();
                break;
            case "City":
                handelCitiesFragment();
                break;
            case "Licence expired":
                handelLicenceExpiredFragment();
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

    public void updateTitleCar(String newTitle){
        switch (newTitle) {
            case "Car make":
                counterProcess.updateInfoCounteCar(0);
                break;
            case "Car model":
                counterProcess.updateInfoCounteCar(1);
                break;
            case "Car year":
                counterProcess.updateInfoCounteCar(2);
                break;
            case "Car condition":
                counterProcess.updateInfoCounteCar(3);
                break;
            case "Car cylinder":
                counterProcess.updateInfoCounteCar(4);
                break;
            case "City":
                counterProcess.updateInfoCounteCar(5);
                break;
            case "Licence expired":
                counterProcess.updateInfoCounteCar(6);
                break;
            case "Follow GCC":
                counterProcess.updateInfoCounteCar(7);
                break;
            case "Insurance policy":
                counterProcess.updateInfoCounteCar(8);
                break;
            case "Agency repair":
                counterProcess.updateInfoCounteCar(9);
                break;
        }
    }

    private void handelAgencyRepairFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        agencyRepair.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, agencyRepair)
                .commit();
    }

    private void handelInsurancePolicyFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        insurancePolicy.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, insurancePolicy)
                .commit();
    }

    private void handelFollowGCCFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        modifiedFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, modifiedFragment)
                .commit();
    }

    private void handelLicenceExpiredFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        licenceExpired.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, licenceExpired)
                .commit();
    }

    private void handelCitiesFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        citiesFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, citiesFragment)
                .commit();
    }

    private void handelCarCylinderFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        cylinderNumberFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, cylinderNumberFragment)
                .commit();
    }

    private void handelCarYearFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        yearFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, yearFragment)
                .commit();
    }

    private void handelConditionFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        carCondition.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, carCondition)
                .commit();
    }

    private void handelModelFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        modelFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, modelFragment)
                .commit();
    }

    private void handelCarMake() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        carMakeFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, carMakeFragment)
                .commit();
    }



    private void createCounterFragment() {
        int numberOfCompletedProcess=0;
        String dOrC ="0";
        if(getPartTypeFromIntent().equals("1"))
        {
            numberOfCompletedProcess = numberOfDriverProcessSelected(this);
            dOrC = "driver";
        }else{
            numberOfCompletedProcess = numberOfCarProcessSelected(this);
            dOrC = "car";
        }
        Log.i("TAG","ProcessNum: "+String.valueOf(numberOfCompletedProcess));
        Log.i("TAG","dOrC: "+String.valueOf(dOrC));
        Bundle bundle = new Bundle();
        bundle.putString("ProcessNum",String.valueOf(numberOfCompletedProcess));
        bundle.putString("dOrc",dOrC);
        counterProcess.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_process_count,counterProcess )
                .commit();
    }

    private void changeFont() {
        textView.setTypeface(Functions.changeFontBold(this));
    }

    private void fillIntiInfo() {
        if (getPartTypeFromIntent().equals("1"))
        {
            textView.setText(R.string.driver_info);
            imageView.setBackgroundResource(R.drawable.driver);
        }else{
            textView.setText(R.string.car_info);
            imageView.setBackgroundResource(R.drawable.car);
        }
    }

    private void inti() {
        imageView = (ImageView) findViewById(R.id.complete_insurance_info_iv);
        textView = (TextView) findViewById(R.id.complete_insurance_info_tv);
    }

    private String getPartTypeFromIntent() {
        Bundle bundle = getIntent().getExtras();
        String processType =bundle.getString("partType");
        return processType;
    }

    private String getNextFragmentFromIntent() {
        //use it when press complete process
        Bundle bundle = getIntent().getExtras();
        String processType =bundle.getString("nextFragment");
        return processType;
    }

    private String getCompleteOrIntiFromIntent() {
        Bundle bundle = getIntent().getExtras();
        String processType =bundle.getString("completeOrInti");
        return processType;
    }

    private String getDriverOrCarFromIntent() {
        Bundle bundle = getIntent().getExtras();
        String processType =bundle.getString("dOrC");
        return processType;
    }

    public void nextFragment(String fragmentNext){
        switch (fragmentNext) {
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
        }
    }

    public void updateTitle(String newTitle){
        switch (newTitle) {
            case "License Nationality":
                counterProcess.updateInfoCounte(1);
                break;
            case "Drive duration":
                counterProcess.updateInfoCounte(2);
                break;
            case "Register Date":
                counterProcess.updateInfoCounte(3);
                break;
            case "Insurance pay":
                counterProcess.updateInfoCounte(4);
                break;
            case "Certificate claims":
                counterProcess.updateInfoCounte(5);
                break;
            case "Name":
                counterProcess.updateInfoCounte(6);
                break;
            case "Phone number":
                counterProcess.updateInfoCounte(7);
                break;
            case "Email":
                counterProcess.updateInfoCounte(8);
                break;
            case "Birth day":
                counterProcess.updateInfoCounte(9);
                break;
        }
    }

    private void handelLicenseNationalityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        licenceNationality.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, licenceNationality)
                .commit();
    }

    private void handelDriverDurationFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        driverDuration.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, driverDuration)
                .commit();
    }

    private void handelRegisterDateFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        registerDate.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, registerDate)
                .commit();
    }

    private void handelInsurancePayFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        insurancePay.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, insurancePay)
                .commit();
    }

    private void handelCertificateClaimFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        certificateClaim.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, certificateClaim)
                .commit();
    }

    private void handelNameFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        name.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, name)
                .commit();
    }

    private void handelPhoneFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        phoneNumber.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, phoneNumber)
                .commit();
    }

    private void handelEmailFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        email.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, email)
                .commit();
    }

    private void handelBDFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        birthDay.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, birthDay)
                .commit();
    }

    private void handelNationalityFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("editOrFill","fill");
        driverNationality.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_all_driver_info_fragments, driverNationality)
                .commit();
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}