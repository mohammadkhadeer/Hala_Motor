package com.cars.halamotor.view.fragments.browsingFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.presnter.FCSItems;
import com.cars.halamotor.view.adapters.AdapterBrowsingFilter;
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

import static com.cars.halamotor.dataBase.ReadFunction.getFCSCallSearch;
import static com.cars.halamotor.dataBase.ReadFunction.getFavouriteCallSearch;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.NewFunction.fillBrowsingArrayL;
import static com.cars.halamotor.functions.NewFunction.getNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;


public class FragmentBrowsing extends Fragment implements AdapterBrowsingFilter.PassSelectedFilter {

    View view;
    FilterBrowsingFragment filterBrowsingFragment = new FilterBrowsingFragment();
    BrowsingItems browsingItems = new BrowsingItems();


    String message = "";

    String fcsTypeStr = "seen" ;
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

    ArrayList<BrowsingFilter> filterArrayList;
    RecyclerView recyclerView;
    AdapterBrowsingFilter adapterBrowsingFilter;
    RecyclerView.LayoutManager layoutManagerSuggested;
    public ArrayList<BrowsingFilter> filterContentArrayL ;
    TextView textView,browsingDep;

    public FragmentBrowsing(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_browsing, container, false);

        init();
        changeFont();
        createSelectedFilterRV();

        favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();
        favouriteCallSearchesArrayList = getFavouriteCallSearch(getActivity(),fcsTypeStr);
//        checkIfHaveFavOrNot();
        createRV();
        getData();
        doApiCall();
        actionListenerToRV();

        return view;
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
        adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<SuggestedItem>(),getActivity(),fcsTypeStr);
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
                adapterShowFCSItems.addItems(suggestedItemsArrayListDO);
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
                if(category != null){
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

    private void changeFont() {
        textView.setTypeface(Functions.changeFontGeneral(getActivity()));
        browsingDep.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void createSelectedFilterRV() {
        filterArrayList = new ArrayList<>();
        filterArrayList = fillBrowsingArrayL(getActivity());

        recyclerView.setHasFixedSize(true);
        layoutManagerSuggested = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManagerSuggested);
        adapterBrowsingFilter =new AdapterBrowsingFilter(getActivity()
                , filterArrayList,this);
        recyclerView.setAdapter(adapterBrowsingFilter);
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_browsing_filter_1_RV);
        textView = (TextView) view.findViewById(R.id.browsing_by_text_view);
        browsingDep = (TextView) view.findViewById(R.id.browsing_dep_text_view);
        messageTV = (TextView) view.findViewById(R.id.show_fcs_messageTV);
        fcsItemsRecyclerView = (RecyclerView) view.findViewById(R.id.show_fcs_RV);
        progressBar = (ProgressBar) view.findViewById(R.id.show_fcs_progress);
    }

    @Override
    public void onFilterClicked(ArrayList<BrowsingFilter> selectedFilter) {
        String filterBy = "";
        filterContentArrayL = new ArrayList<>();
        for (int j =0;j<selectedFilter.size();j++)
        {
            if (selectedFilter.get(j).isSelected() == true)
            {
                filterContentArrayL.add(selectedFilter.get(j));
            }
        }

        if (filterContentArrayL.isEmpty())
        {
            filterBy = getActivity().getResources().getString(R.string.all);
        }else{
            if (1 <filterContentArrayL.size())
            {
                for (int i =0 ;i <filterContentArrayL.size();i++)
                {
                    if (i ==0)
                    {
                        filterBy = filterContentArrayL.get(i).getFilterString();
                    }else{
                        filterBy = filterBy + " | "+  filterContentArrayL.get(i).getFilterString();
                    }
                }
            }else{
                filterBy = filterContentArrayL.get(0).getFilterString();
            }
        }
        textView.setText(filterBy);
        message = filterBy;
        progressBar.setVisibility(View.VISIBLE);

        favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();
        favouriteCallSearchesArrayList = getFCSCallSearch(filterContentArrayL,getActivity());
//        Log.i("TAG","**************");
//        Log.i("TAG fcs", String.valueOf(favouriteCallSearchesArrayList.size()));
//        Log.i("TAG filter", String.valueOf(filterContentArrayL.size()));

        refresh();
    }

    private void refresh() {
        Log.i("TAG",message);
        numberOfObjectNow = 0;
        numberOfObjectReturn = 0;
        currentPage = PAGE_START;
        isLastPage = false;
        createRV();
        getData();
        adapterShowFCSItems.clear();
        doApiCall();
    }

//
//    private void createBrowsingItemFragment() {
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_browsing_filters_container, filterBrowsingFragment);
//        transaction.commit();
//    }

    //    private void createBrowsingItems() {
//        Bundle bundle = new Bundle();
//        bundle.putString("filterBy", message);
//
//        browsingItems.setArguments(bundle);
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_browsing_items, browsingItems);
//        transaction.commit();
//    }

}
