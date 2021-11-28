package com.cars.halamotor.view.fragments.browsingFragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.FCSFunctions;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.BrowsingFilter;
import com.cars.halamotor.model.FavouriteCallSearch;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.presnter.FCSItems;
import com.cars.halamotor.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.dataBase.ReadFunction.getFavouriteCallSearch;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.NewFunction.getNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class BrowsingItems extends Fragment {

    public BrowsingItems(){}

    String fcsTypeStr = "favorite" ;
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
    View view;
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_message, container, false);
        inti();
        changeFont();
        getInfoFromIntent();
        favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();
        favouriteCallSearchesArrayList = getFavouriteCallSearch(getActivity(),fcsTypeStr);
        checkIfHaveFavOrNot();
        createRV();
        getData();
        doApiCall();
        actionListenerToRV();

        return view;
    }

    private void refresh() {
        numberOfObjectNow = 0;
        numberOfObjectReturn = 0;
        currentPage = PAGE_START;
        isLastPage = false;
        adapterShowFCSItems.clear();
        doApiCall();
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
        layoutManager = new LinearLayoutManager(getActivity());
        fcsItemsRecyclerView.setLayoutManager(layoutManager);
        //adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<SuggestedItem>(),getActivity(),fcsTypeStr);
        fcsItemsRecyclerView.setAdapter(adapterShowFCSItems);
    }

    private void doApiCall() {
        suggestedItemsArrayListDO = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
//                fcsItemsRecyclerView.setVisibility(View.VISIBLE);
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

    private void checkIfHaveFavOrNot() {
        if (favouriteCallSearchesArrayList.size()==0)
        {
            progressBar.setVisibility(View.GONE);
            messageTV.setText(getResources().getString(R.string.no_favorite));
        }
    }

    private void getInfoFromIntent() {
//        Bundle bundle = getIntent().getExtras();
//        fcsTypeStr =bundle.getString("fcsTypeStr");
        fcsTypeStr = "favorite";
    }

    private void inti() {
        messageTV = (TextView) view.findViewById(R.id.show_fcs_messageTV);
        fcsItemsRecyclerView = (RecyclerView) view.findViewById(R.id.show_fcs_RV);
        progressBar = (ProgressBar) view.findViewById(R.id.show_fcs_progress);
        editText = (EditText) view.findViewById(R.id.edit_text);
    }

    private void changeFont() {
        if (numberOfObjectNow == 0)
            messageTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

}
