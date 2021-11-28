package com.cars.halamotor.view.activity;

import android.graphics.Color;
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

import com.cars.halamotor.R;
import com.cars.halamotor.functions.FCSFunctions;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.FavouriteCallSearch;
import com.cars.halamotor.model.Paging;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.presnter.FCSItems;
import com.cars.halamotor.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.cars.halamotor.dataBase.ReadFunction.getFavouriteCallSearch;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.Functions.setLocale;
import static com.cars.halamotor.functions.NewFunction.actionBarTitleInFCS;
import static com.cars.halamotor.functions.NewFunction.getNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class ShowFCS extends AppCompatActivity {
    String fcsTypeStr;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLocale(this);
        setContentView(R.layout.activity_show_fcs);

        statusBarColor();
        init();
        changeFont();
        getInfoFromIntent();
        actionBarTitle();
        favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();
        favouriteCallSearchesArrayList = getFavouriteCallSearch(getApplicationContext(),fcsTypeStr);
//        numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,favouriteCallSearchesArrayList.size());
        checkIfHaveFavOrNot();

        createRV();
        getData();
        doApiCall();
        actionListenerToRV();
    }

    private void checkIfHaveFavOrNot() {
        if (favouriteCallSearchesArrayList.size()==0)
        {
            progressBar.setVisibility(View.GONE);
            messageTV.setText(getResources().getString(R.string.no_favorite));
        }
    }

    private void changeFont() {
        if (numberOfObjectNow == 0)
            messageTV.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
    }

    private void init() {
        messageTV = (TextView) findViewById(R.id.show_fcs_messageTV);
        fcsItemsRecyclerView = (RecyclerView) findViewById(R.id.show_fcs_RV);
        progressBar = (ProgressBar) findViewById(R.id.show_fcs_progress);
    }

    private void getInfoFromIntent() {
        Bundle bundle = getIntent().getExtras();
        fcsTypeStr =bundle.getString("fcsTypeStr");
    }

    private void statusBarColor() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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
        textviewTitle.setTextColor(Color.parseColor("#FF0000"));
        textviewTitle.setText(actionBarTitleInFCS(getApplicationContext(),fcsTypeStr));
        textviewTitle.setTypeface(typeface);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setHomeButtonEnabled(false);
    }

    private void actionListenerToRV() {
        fcsItemsRecyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,favouriteCallSearchesArrayList.size());
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

    private void createRV() {
        fcsItemsRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        fcsItemsRecyclerView.setLayoutManager(layoutManager);
        //adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<SuggestedItem>(),this,fcsTypeStr);
        fcsItemsRecyclerView.setAdapter(adapterShowFCSItems);
    }

    private void doApiCall() {
        suggestedItemsArrayListDO = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                suggestedItemsArrayListDO.addAll(suggestedItemsArrayListTest);
                if (currentPage != PAGE_START) adapterShowFCSItems.removeLoading();
                //adapterShowFCSItems.addItems(suggestedItemsArrayListDO);
                if (getNumberOfObject(numberOfObjectNow,favouriteCallSearchesArrayList.size())==false) {
                    adapterShowFCSItems.addLoading();
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
        favouriteCallSearchesArrayListNew = new ArrayList<>();
        int numberOfObject = nowNumberOfObject(numberOfObjectNow,favouriteCallSearchesArrayList.size());
        favouriteCallSearchesArrayListNew = getCategoryList(numberOfObject);
        if (numberOfObject!=1000)
        {
            for (int i =0;i<numberOfObject;i++)
            {
                final String category = convertCat(favouriteCallSearchesArrayListNew.get(i).getItemType());
                final String categoryBefore = favouriteCallSearchesArrayListNew.get(i).getItemType();
                DocumentReference mRef = null;
                if (category != null)
                {
                    mRef = getDataStoreInstance().collection(category)
                            .document(favouriteCallSearchesArrayListNew.get(i).getIdInDatabase());
                    mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                    fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(document,categoryBefore));
                                }
                            }
                        }
                    });
                }
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                suggestedItemsArrayListTest.addAll(fcsItemsArrayList);
            }
        }, 3000);
    }

    private ArrayList<FavouriteCallSearch> getCategoryList(int condition) {
        ArrayList<FavouriteCallSearch> newCat = new ArrayList<>();
        for (int j=0;j<condition;j++)
        {
            if (numberOfObjectReturn < favouriteCallSearchesArrayList.size())
            {
                newCat.add(favouriteCallSearchesArrayList.get(numberOfObjectReturn));
                numberOfObjectReturn++;
            }
        }
        return newCat;
    }
}