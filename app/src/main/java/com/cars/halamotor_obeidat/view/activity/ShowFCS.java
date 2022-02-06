package com.cars.halamotor_obeidat.view.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.FCSFunctions;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.FavouriteCallSearch;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.presnter.FCSItems;
import com.cars.halamotor_obeidat.presnter.FCSItemsList;
import com.cars.halamotor_obeidat.presnter.ItemModel;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFavouriteCallSearch;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;
import static com.cars.halamotor_obeidat.functions.Functions.setLocale;
import static com.cars.halamotor_obeidat.functions.NewFunction.actionBarTitleInFCS;
import static com.cars.halamotor_obeidat.functions.NewFunction.getNumberOfObject;
import static com.cars.halamotor_obeidat.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor_obeidat.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor_obeidat.presnter.FCSFromServer.getFCS;
import static com.cars.halamotor_obeidat.presnter.RelatedAdToSameCreator.getRelatedAds;
import static com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class ShowFCS extends AppCompatActivity implements FCSItemsList{
    String fcsTypeStr,type;
    ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayList;
    ArrayList<FavouriteCallSearch> favouriteCallSearchesArrayListNew;
    public List<SuggestedItem> suggestedItemsArrayListTest;
    public List<SuggestedItem> suggestedItemsArrayListDO;
    TextView messageTV;
    ProgressBar progressBar;
     int numberOfObjectNow = 0;
     int numberOfObjectReturn = 0;
    FCSItems fcsItems;
    private int currentPage = PAGE_START;
    RecyclerView fcsItemsRecyclerView;
    private boolean isLastPage = false;
    private boolean isLoading = false;
    LinearLayoutManager layoutManager;
    AdapterShowFCSItems adapterShowFCSItems;
    FCSItemsList fcsItemsList;
    NestedScrollView nestedScrollView;
    int numberOfResultAfterRe;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_show_fcs);

        statusBarColor();
        fcsItemsList = (FCSItemsList) this;
        init();
        changeFont();
        getInfoFromIntent();
        setTitleFCS();

        getData();
        createRV();
        scrollView();

    }

    private void setTitleFCS() {
        title.setText(type);
    }

    private void scrollView() {
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new
                                                                                  ViewTreeObserver.OnScrollChangedListener() {
                                                                                      @Override
                                                                                      public void onScrollChanged() {
                                                                                          View view = (View) nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                                                                                          int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()));
                                                                                          if (diff == 0) {
                                                                                              if (numberOfResultAfterRe!=0)
                                                                                              {
                                                                                                  progressBar.setVisibility(View.VISIBLE);
                                                                                                  //numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,suggestedItemsArrayListTest.size());
                                                                                                  isLoading = true;
                                                                                                  currentPage++;
                                                                                                  //Log.i("TAG","currentPage"+currentPage);
                                                                                                  getFCS(ShowFCS.this,fcsTypeStr,fcsItemsList,currentPage);

                                                                                              }

                                                                                          }
                                                                                      }
                                                                                  });
    }

    private void checkIfHaveFavOrNot() {
        if (favouriteCallSearchesArrayList.size()==0)
        {
            progressBar.setVisibility(View.GONE);
            messageTV.setText(getResources().getString(R.string.no_favorite));
        }
    }

    private void changeFont() {
        title.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void init() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_fcs);
        fcsItemsRecyclerView = (RecyclerView) findViewById(R.id.show_fcs_RV);
        progressBar = (ProgressBar) findViewById(R.id.show_fcs_progress);
        title = (TextView) findViewById(R.id.title);
    }

    private void getInfoFromIntent() {
        Bundle bundle = getIntent().getExtras();
        fcsTypeStr =bundle.getString("fcsTypeStr");
        type=bundle.getString("fcsType");

    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void createRV() {
        fcsItemsRecyclerView.setNestedScrollingEnabled(false);
        fcsItemsRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        fcsItemsRecyclerView.setLayoutManager(layoutManager);
        adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<CCEMTModel>(),this,"search");
        fcsItemsRecyclerView.setAdapter(adapterShowFCSItems);
    }



    private void getData() {
        Log.i("TAG","fcsTypeStr: "+fcsTypeStr);
        getFCS(this,fcsTypeStr,fcsItemsList,currentPage);
    }

    @Override
    public void passArrayList(final ArrayList<CCEMTModel> items) {
        Log.i("TAG","items size: "+String.valueOf(items.size()));
        numberOfResultAfterRe = 0;
        int numberOfResultAfterRe = items.size();
        if (numberOfResultAfterRe>0)
        {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    adapterShowFCSItems.addItems(items);
                }
            }, 50);
        }

    }
}