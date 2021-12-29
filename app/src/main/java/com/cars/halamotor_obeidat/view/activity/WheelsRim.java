package com.cars.halamotor_obeidat.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.WheelsType;
import com.cars.halamotor_obeidat.presnter.WheelsComp;
import com.cars.halamotor_obeidat.view.fragments.wheelsRimFragment.FragmentWheelsRimSize;
import com.cars.halamotor_obeidat.view.fragments.wheelsRimFragment.FragmentWheelsType;

import static com.cars.halamotor_obeidat.functions.Functions.changeFontBold;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;

public class WheelsRim extends AppCompatActivity implements WheelsComp {

    FragmentWheelsRimSize fragmentWheelsRimSize = new FragmentWheelsRimSize();
    FragmentWheelsType fragmentWheelsType = new FragmentWheelsType();
    String sizeStr = "empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_wheels_rim);

        statusBarColor();
        actionBarTitle();
        intiFragment();

    }

    private void intiFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_wheels_comp, fragmentWheelsRimSize)
                .commit();
    }

    private void actionBarTitle() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ActionBar abar = getSupportActionBar();
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_custom_title_view_centered, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
        textviewTitle.setText(getResources().getString(R.string.detect_wheels_siz));
        textviewTitle.setTypeface(changeFontBold(this));
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(true);
        abar.setHomeButtonEnabled(true);
    }

    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onWheelsSize(String wheelsSizeStr) {
        sizeStr = wheelsSizeStr;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_wheels_comp, fragmentWheelsType);
        transaction.setCustomAnimations
                (R.anim.right_to_left, R.anim.no_animation).show(fragmentWheelsType);
        transaction.commit();

    }

    @Override
    public void onWheelsType(WheelsType wheelsType) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("inchSize", sizeStr);
        resultIntent.putExtra("type", wheelsType.getWheelsTypeStr());
        resultIntent.putExtra("typeS", wheelsType.getWheelsTypeStrS());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
