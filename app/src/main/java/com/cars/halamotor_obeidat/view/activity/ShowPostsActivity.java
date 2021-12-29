package com.cars.halamotor_obeidat.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
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
import com.cars.halamotor_obeidat.functions.FCSFunctions;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.UserItem;
import com.cars.halamotor_obeidat.view.adapters.AdapterEditPosts;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserIdInServerFromSP;
import static com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class ShowPostsActivity extends AppCompatActivity {
    private static final int REQUEST_EDIT_POST = 55;

    ProgressBar progressBar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AdapterEditPosts adapterEditPosts;

    ArrayList<UserItem> itemIDsArrayL= new ArrayList<>();
    public List<SuggestedItem> suggestedItemsArrayListTest;
    public List<SuggestedItem> suggestedItemsArrayListDO;


    private int currentPage = PAGE_START;
    private int totalPage = 10;
    private boolean isLastPage = false;
    private boolean isLoading = false;
    int itemCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_show_postes);

        statusBarColor();
        actionBarTitle();
        init();
        getUserItemInfoList();
        timer();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EDIT_POST && resultCode == Activity.RESULT_OK) {
            String editOrNot =data.getExtras().getString("edit");
            if (editOrNot.equals("yes"))
            {
                progressBar.setVisibility(View.VISIBLE);
                createRV();
                getUserItemInfoList();
                timer();
            }
        }
    }

    private void init() {
        progressBar = (ProgressBar) findViewById(R.id.show_posts_progress);
        recyclerView = (RecyclerView) findViewById(R.id.show_posts_RV);
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
        if (itemIDsArrayL.size()==0)
        {
            timer();
        }else {
            createRV();
            getData();
            doApiCall();
            actionListenerToRV();
        }
    }

    private void actionListenerToRV() {
        recyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                progressBar.setVisibility(View.VISIBLE);
                isLoading = true;
                currentPage++;
                getData();
                doApiCall();
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
    }

    private void doApiCall() {
        suggestedItemsArrayListDO = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                suggestedItemsArrayListDO.addAll(suggestedItemsArrayListTest);
                if (currentPage != PAGE_START) adapterEditPosts.removeLoading();
                adapterEditPosts.addItems(suggestedItemsArrayListDO);
                if (currentPage < totalPage) {
                    adapterEditPosts.addLoading();
                } else {
                    isLastPage = true;
                }
                isLoading = false;
            }
        }, 3100);
    }

    private void getData() {
        final List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();
        suggestedItemsArrayListTest = new ArrayList<>();
        int numberOfObject = currentPage*10;

        for (int i = numberOfObject-10; i < numberOfObject; i++) {
            final String category = convertCat(itemIDsArrayL.get(i).getCategoryS());
            final String categoryBefore = itemIDsArrayL.get(i).getCategoryS();

            DocumentReference mRef = null;
            mRef = getDataStoreInstance().collection(category)
                    .document(itemIDsArrayL.get(i).getItemID());
            mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(document, categoryBefore));
                        }
                    }
                }
            });
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                suggestedItemsArrayListTest.addAll(fcsItemsArrayList);
            }
        }, 3000);
    }

    private void createRV() {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapterEditPosts = new AdapterEditPosts(new ArrayList<SuggestedItem>(),this);
        recyclerView.setAdapter(adapterEditPosts);
    }

    private void getUserItemInfoList() {
        itemIDsArrayL = new ArrayList<>();
        getUserPathInServer(getUserIdInServerFromSP(getApplicationContext()))
                .child("usersAds")
                .limitToFirst(101)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                            UserItem userItem = dataSnapshot1.getValue(UserItem.class);
                            itemIDsArrayL.add(userItem);
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
        textviewTitle.setText(getResources().getString(R.string.posts));
        textviewTitle.setTypeface(typeface);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);
    }

}
