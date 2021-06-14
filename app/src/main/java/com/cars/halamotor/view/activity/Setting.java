package com.cars.halamotor.view.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class Setting extends AppCompatActivity {

    RelativeLayout setting_language,setting_country,setting_contact_us,setting_about_us,setting_log_out;
    TextView setting_language_TV,setting_country_TV,setting_contact_us_TV,setting_about_us_TV,setting_log_out_TV;
    ImageView setting_language_IV,setting_country_IV,setting_contact_us_IV,setting_about_us_IV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_setting);

        statusBarColor();
        inti();
        changeFont();
        fillLanguage();
        actionListenerToLanguage();
        fillAboutUsImage();
        fillLoginOrLogout();
        actionListenerToLogoutOrLogin();
        actionListenerToContact();
        actionListenerAboutUs();
    }

    private void actionListenerAboutUs() {
        setting_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, AboutUs.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void actionListenerToContact() {
        setting_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, ContactUs.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorSilver));
        }
    }

    private void changeFont() {
        setting_language_TV.setTypeface(Functions.changeFontGeneral(this));
        setting_country_TV.setTypeface(Functions.changeFontGeneral(this));
        setting_contact_us_TV.setTypeface(Functions.changeFontGeneral(this));
        setting_about_us_TV.setTypeface(Functions.changeFontGeneral(this));
        setting_log_out_TV.setTypeface(Functions.changeFontGeneral(this));
    }

    private void inti() {
        setting_language = (RelativeLayout) findViewById(R.id.setting_language);
        setting_country = (RelativeLayout) findViewById(R.id.setting_country);
        setting_contact_us = (RelativeLayout) findViewById(R.id.setting_contact_us);
        setting_about_us = (RelativeLayout) findViewById(R.id.setting_about_us);
        setting_log_out = (RelativeLayout) findViewById(R.id.setting_log_out);

        setting_language_TV = (TextView) findViewById(R.id.setting_language_TV);
        setting_country_TV = (TextView) findViewById(R.id.setting_country_TV);
        setting_contact_us_TV = (TextView) findViewById(R.id.setting_contact_us_TV);
        setting_about_us_TV = (TextView) findViewById(R.id.setting_about_us_TV);
        setting_log_out_TV = (TextView) findViewById(R.id.setting_log_out_TV);

        setting_language_IV = (ImageView) findViewById(R.id.setting_language_IV);
        setting_country_IV = (ImageView) findViewById(R.id.setting_country_IV);
        setting_contact_us_IV = (ImageView) findViewById(R.id.setting_contact_us_IV);
        setting_about_us_IV = (ImageView) findViewById(R.id.setting_about_us_IV);
    }

    private void fillLanguage() {
        if (getUserLanguage(this) != null)
        {
            if (getUserLanguage(this).equals("ar"))
            {
                setting_language_TV.setText(getResources().getString(R.string.language)+"        "+getResources().getString(R.string.arabic));
                Picasso.get()
                        .load(R.drawable.uae)
                        .fit()
                        .centerCrop()
                        .into(setting_language_IV);
            }else{
                setting_language_TV.setText(getResources().getString(R.string.language)+"        "+getResources().getString(R.string.english));
                Picasso.get()
                        .load(R.drawable.en_logo)
                        .fit()
                        .centerCrop()
                        .into(setting_language_IV);
            }
        }
    }

    private void actionListenerToLanguage() {
        setting_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("from","setting");

                Intent intent = new Intent(Setting.this, Language.class);
//                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
            }
        });
    }

    private void fillLoginOrLogout() {
        setting_log_out_TV.setText(getResources().getString(R.string.log_out));
    }

    private void actionListenerToLogoutOrLogin() {
        setting_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (getLoginOrNotFromSP(getApplicationContext()).isEmpty())
//                {
//                    Intent intent = new Intent(getApplicationContext(), LoginWithSocialMedia.class);
//                    intent.putExtra("from", "login");
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//                }else{
//                    cleanLogin(getApplicationContext());
//                    moveToSplashScreen();
//                }
            }
        });
    }

    private void moveToSplashScreen() {
        Intent intent = new Intent(Setting.this, SplashScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        finishAffinity();
    }

    private void fillAboutUsImage() {
        Picasso.get()
                .load(R.drawable.logo)
                .fit()
                .centerCrop()
                .into(setting_about_us_IV);
    }
}