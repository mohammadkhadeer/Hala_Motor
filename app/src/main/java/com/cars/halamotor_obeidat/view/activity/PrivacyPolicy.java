package com.cars.halamotor_obeidat.view.activity;

import static com.cars.halamotor_obeidat.functions.Functions.setLocale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cars.halamotor_obeidat.R;

public class PrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_privacy_policy);

        statusBarColorWhite();
    }

    private void statusBarColorWhite() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}