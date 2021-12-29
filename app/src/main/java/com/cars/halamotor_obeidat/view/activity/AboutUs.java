package com.cars.halamotor_obeidat.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;

import static com.cars.halamotor_obeidat.functions.Functions.setLocale;

public class AboutUs extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_about_us);
        statusBarColor();
        inti();
        changeFont();
    }

    private void inti() {
        textView = (TextView) findViewById(R.id.about_us_activity_text);
    }

    private void changeFont() {
        textView.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}
