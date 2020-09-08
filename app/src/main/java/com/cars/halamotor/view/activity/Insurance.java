package com.cars.halamotor.view.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.view.fragments.insuranceFargment.CarDetailsInsurance;
import com.cars.halamotor.view.fragments.insuranceFargment.DriverInformation;
import com.cars.halamotor.view.fragments.insuranceFargment.InsuranceResult;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.functions.InsuranceFunctions.numberOfCarProcessSelected;
import static com.cars.halamotor.functions.InsuranceFunctions.numberOfDriverProcessSelected;
import static com.cars.halamotor.sharedPreferences.InsuranceSP.cleanInsuranceStatus;
import static com.cars.halamotor.sharedPreferences.InsuranceSP.getInsuranceStatusSP;
import static com.cars.halamotor.sharedPreferences.InsuranceSP.saveInsuranceSP;


public class Insurance extends AppCompatActivity implements CarDetailsInsurance.FragmentCarDetailsCheck
        , DriverInformation.FragmentDriverDetailsCheck {
    TextView textViewWelcome;
    ImageView imageView;
    CarDetailsInsurance carDetailsInsurance = new CarDetailsInsurance();
    DriverInformation driverInformation = new DriverInformation();
    InsuranceResult insuranceResult = new InsuranceResult();

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    String insurancePic = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/pic%2Finsurance_logo.png?alt=media&token=b00be8d9-b881-4c8a-95a0-8b3e74791c88";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);

//        getDataBaseInstance(this).deleteAllDriverInfo();
//        getDataBaseInstance(this).deleteAllCarDetails();
        statusBarColor();
        inti();
        fillImage();
        dialogMessage();
        changeFont();
        createDriverFragment();
        createCarFragment();
        createInsuranceResultFragment();
    }

    private void fillImage() {
        Picasso.get()
                .load(insurancePic)
                .fit()
                .centerCrop()
                .into(imageView);
    }

    private void createCarFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_car_details_insurance, carDetailsInsurance)
                .commit();
    }

    private void createDriverFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_driver_info, driverInformation)
                .commit();
    }

    private void changeFont() {
        textViewWelcome.setTypeface(Functions.changeFontBold(getApplicationContext()));
    }

    private void inti() {
        textViewWelcome = (TextView) findViewById(R.id.insurance_activity_welcome_tv);
        imageView = (ImageView) findViewById(R.id.insuranceLogo);
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void dialogMessage() {
        //cleanInsuranceStatus(this,sharedPreferences,editor);
        if (getInsuranceStatusSP(this).equals("empty") || getInsuranceStatusSP(this).equals("0"))
        {
            final int[] isSelected = {0};
            View content = getLayoutInflater().inflate(
                    R.layout.dialog_content, null); // inflate the content of the dialog
            final CheckBox userCheck = (CheckBox) content //the checkbox from that view
                    .findViewById(R.id.check_box1);
            final TextView messageTV = (TextView) content //the textView from that view
                    .findViewById(R.id.textView1);

            messageTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));

            userCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSelected[0] ==0)
                    {
                        isSelected[0] =1;
                    }else{
                        isSelected[0] =0;
                    }
                }
            });

            new AlertDialog.Builder(this)
                    .setView(content)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {

                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {
                                    Log.i("TAG","which: "+String.valueOf(which));
                                    Log.i("TAG","userCheck.isChecked(): "+String.valueOf(userCheck.isChecked()));

                                    if (isSelected[0] ==0)
                                    {
                                        saveInsuranceSP(getApplicationContext(),sharedPreferences,editor,"0");
                                    }else{
                                        saveInsuranceSP(getApplicationContext(),sharedPreferences,editor,"1");
                                    }
                                    dialog.dismiss(); //end the dialog.
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {

                                public void onClick(
                                        DialogInterface dialog,
                                        int which) {
                                    saveInsuranceSP(getApplicationContext(),sharedPreferences,editor,"0");
                                    dialog.dismiss();
                                }
                            }).show();
        }
    }

    private void createInsuranceResultFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_insurance_result, insuranceResult)
                .commit();
    }

    @Override
    public void onCarDetailsComplete(Boolean status) {
        if (status)
            insuranceResult.updateResult();
        else
            insuranceResult.hideResult();
    }

    @Override
    public void onDriverComplete(Boolean status) {
        if (status)
            insuranceResult.updateResult();
        else
            insuranceResult.hideResult();
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
