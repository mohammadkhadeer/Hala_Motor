package com.cars.halamotor.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.cars.halamotor.R;

import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.cars.halamotor.sharedPreferences.PersonalSP.setUserLanguage;

public class Language extends AppCompatActivity {

    RadioButton radioButtonArabic,radioButtonEnglish;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor2;
    SharedPreferences sharedPreferences2;

    String comeFrom=null;
    LinearLayout linearLayoutArabic,linearLayoutEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_language);

        statusBarColor();
        init();
        //getFromIntent();
        fillRadioButton();
        actionListenerToArabic();
    }

    private void getFromIntent() {
        Bundle bundle = getIntent().getExtras();
        comeFrom =bundle.getString("setting");
    }

    private void fillRadioButton() {
        Drawable d = getResources().getDrawable(R.drawable.language_por);
        if (getUserLanguage(this) != null)
        {
            if (getUserLanguage(this).equals("ar"))
            {
                radioButtonArabic.setChecked(true);

                linearLayoutArabic.setBackgroundDrawable(d);
            }else{
                radioButtonEnglish.setChecked(true);
                linearLayoutEng.setBackgroundDrawable(d);
            }
        }
    }

    private void actionListenerToArabic() {
        linearLayoutArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getUserTokenFromServer(getApplicationContext()).equals("1"))
                {
                    Drawable d = getResources().getDrawable(R.drawable.language_por);
                    Drawable dd = getResources().getDrawable(R.drawable.language_without_por);
                    linearLayoutArabic.setBackgroundDrawable(d);
                    linearLayoutEng.setBackgroundDrawable(dd);
                    setUserLanguage(getApplicationContext(),"ar");

                    restartApp();
                }else{
                    fun();
                }

            }
        });


        linearLayoutEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getUserTokenFromServer(getApplicationContext()).equals("1"))
                {
                    Drawable d = getResources().getDrawable(R.drawable.language_por);
                    Drawable dd = getResources().getDrawable(R.drawable.language_without_por);
                    linearLayoutEng.setBackgroundDrawable(d);
                    linearLayoutArabic.setBackgroundDrawable(dd);
                    setUserLanguage(getApplicationContext(),"en");

                    restartApp();
                }else{
                    Drawable d = getResources().getDrawable(R.drawable.language_por);
                    Drawable dd = getResources().getDrawable(R.drawable.language_without_por);
                    linearLayoutEng.setBackgroundDrawable(d);
                    linearLayoutArabic.setBackgroundDrawable(dd);
                    setUserLanguage(getApplicationContext(),"en");

                    restartApp();
                }
            }
        });





        radioButtonArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserLanguage(getApplicationContext(),"ar");
                //Toast.makeText(getApplicationContext(),getLanguageFromSP(getApplicationContext()),Toast.LENGTH_SHORT).show();

                restartApp();
            }
        });
        radioButtonEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUserLanguage(getApplicationContext(),"en");
                //Toast.makeText(getApplicationContext(),getLanguageFromSP(getApplicationContext()),Toast.LENGTH_SHORT).show();

                restartApp();
            }
        });    }

    private void fun() {
        Drawable d = getResources().getDrawable(R.drawable.language_por);
        Drawable dd = getResources().getDrawable(R.drawable.language_without_por);
        linearLayoutArabic.setBackgroundDrawable(d);
        linearLayoutEng.setBackgroundDrawable(dd);
        setUserLanguage(getApplicationContext(),"ar");

        restartApp();
    }
    private void restartApp(){
//        Intent intent = new Intent(Language.this, Login.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//        finish();

//        Intent mStartActivity = new Intent(Language.this, SplashScreen.class);
//        int mPendingIntentId = 123456;
//        PendingIntent mPendingIntent = PendingIntent.getActivity(Language.this, mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
//        AlarmManager mgr = (AlarmManager)getApplicationContext().getSystemService(Language.this.ALARM_SERVICE);
//        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
//        System.exit(0);

        Intent intent = new Intent(Language.this, SplashScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

        //Runtime.getRuntime().exit(0);
    }
    private void init() {
        radioButtonArabic = (RadioButton) findViewById(R.id.radioButton);
        radioButtonEnglish = (RadioButton) findViewById(R.id.radioButton2);
        linearLayoutArabic = (LinearLayout) findViewById(R.id.arab_lan);
        linearLayoutEng = (LinearLayout) findViewById(R.id.eng_lan);
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}