package com.cars.halamotor_obeidat.view.activity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.view.adapters.AdapterFollowing;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;

public class FollowingActivity extends AppCompatActivity {

    ArrayList<com.cars.halamotor_obeidat.model.Following> followersArrayList = new ArrayList<>();
    AdapterFollowing adapterFollowing;
    LinearLayoutManager layoutManager;

    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_followers);

        statusBarColor();
        actionBarTitle();
        inti();
        getFollowing();
        timer();
    }

    private void inti() {
        progressBar = (ProgressBar) findViewById(R.id.following_progress);
        recyclerView = (RecyclerView) findViewById(R.id.following_RV);
    }

    private void timer() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                prite();
            }
        }, 1000);
    }

    private void prite() {
        if (followersArrayList.size() ==0)
        {
            timer();
        }else{
            createRV();
        }
    }

    private void createRV() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapterFollowing = new AdapterFollowing(getApplicationContext(),followersArrayList,"following");
        recyclerView.setAdapter(adapterFollowing);
    }

    private void getFollowing() {
        followersArrayList = new ArrayList<>();
        getUserPathInServer(getUserIdInServerFromSP(getApplicationContext()))
                .child("following")
                .limitToFirst(101)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                            com.cars.halamotor_obeidat.model.Following following = dataSnapshot1.getValue(com.cars.halamotor_obeidat.model.Following.class);
                            followersArrayList.add(following);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("TAG ERROR", databaseError.toString());

                    }

                });
    }


    private void statusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorRed));
        }
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
        textviewTitle.setText(getResources().getString(R.string.following));
        textviewTitle.setTypeface(typeface);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);
    }
}
