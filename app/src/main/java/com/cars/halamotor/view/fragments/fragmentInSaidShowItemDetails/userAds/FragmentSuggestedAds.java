package com.cars.halamotor.view.fragments.fragmentInSaidShowItemDetails.userAds;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.FCSFunctions;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CCEMTModel;
import com.cars.halamotor.model.ItemSelectedFilterModel;
import com.cars.halamotor.model.ResultFilter;
import com.cars.halamotor.model.SimilarAdsComp;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.new_presenter.RelativeResult;
import com.cars.halamotor.new_presenter.SearchResult;
import com.cars.halamotor.utils.PaginationListenerUser;
import com.cars.halamotor.view.adapters.adapterShowItemDetails.AdapterUserItemLoading;
import com.cars.halamotor.view.adapters.userAds.AdapterShowUserItems;
import com.cars.halamotor.view.adapters.userAds.AdapterSuggestedItems;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.algorithms.RebuildItemFilter.rebuildItemFilter;
import static com.cars.halamotor.fireBaseDB.FilterFireStore.filterResult;
import static com.cars.halamotor.fireBaseDB.FilterFireStore.filterResult2;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.new_presenter.RelatedAdToSameAd.getRelatedAds;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;
import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentSuggestedAds extends Fragment {

    RecyclerView recyclerView,recyclerViewLoading;
    TextView textView;
    public FragmentSuggestedAds(){}

    View view;
    AdapterUserItemLoading adapterUserItemLoading;
    RecyclerView.LayoutManager layoutManagerLoading;
    ArrayList<ItemSelectedFilterModel> itemFilterArrayList ;
    String city,neighborhood;
    String category,itemId;
    ResultFilter resultFilter = null;

    List<SuggestedItem> resultItemsArrayListCont = new ArrayList<>();
    List<SuggestedItem> resultItemsArrayList = new ArrayList<>();
    List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();

    DocumentSnapshot lastVisible;
    AdapterShowUserItems adapterShowUserItems;

    private int currentPage = PAGE_START;
    private int totalPage = 10;
    private boolean isLastPage = false;
    private boolean isLoading = false;
    AdapterSuggestedItems adapterSuggestedItems;
    LinearLayoutManager mLayoutManager;
    RelativeResult relativeResult;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            category = getArguments().getString("category");
            itemId = getArguments().getString("itemID");
        }
        super.onAttach(context);

        if (context instanceof RelativeResult) {
            relativeResult = (RelativeResult) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        relativeResult = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_suggested_ads, container, false);
        inti();
        changeFont();
        createLoadingRV();
        getRelatedAds(getApplicationContext(),itemId,relativeResult);
        return view;
    }
    ArrayList<CCEMTModel> suggestedItemsArrayListDO = new ArrayList<>();

    public void handleResult(final ArrayList<CCEMTModel> ccemtModelArrayList){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("TAG",String.valueOf(ccemtModelArrayList.size()));
                recyclerViewLoading.setVisibility(View.GONE);
                createRV();
                setData(ccemtModelArrayList);

                //resultFilter=filterResult2(itemFilterArrayList,0,getApplicationContext(),city,neighborhoodStr,8,searchResult);
            }
        }, 400);
    }

    private void setData(ArrayList<CCEMTModel> ccemtModelArrayList) {

        suggestedItemsArrayListDO = new ArrayList<>();
        ccemtModelArrayList.addAll(suggestedItemsArrayListDO);

        if (currentPage != PAGE_START) adapterShowUserItems.removeLoading();
        adapterShowUserItems.addItems(ccemtModelArrayList);

        isLoading = false;


        suggestedItemsArrayListDO.addAll(ccemtModelArrayList);
        if (currentPage != PAGE_START) adapterShowUserItems.removeLoading();
        adapterShowUserItems.addItems(suggestedItemsArrayListDO);
        if (currentPage < totalPage) {
            adapterShowUserItems.addLoading();
        } else {
            isLastPage = true;
        }
        isLoading = false;
    }

    private void createRV() {
        adapterShowUserItems = new AdapterShowUserItems(new ArrayList<CCEMTModel>(),getActivity(),"call");
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterShowUserItems);
        //getData();
    }

    private void changeFont() {
        textView.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void createLoadingRV() {
        recyclerViewLoading.setHasFixedSize(true);
        layoutManagerLoading = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerViewLoading.setLayoutManager(layoutManagerLoading);
        adapterUserItemLoading =new AdapterUserItemLoading();
        recyclerViewLoading.setAdapter(adapterUserItemLoading);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_similar_item_suggested_rv);
        recyclerViewLoading = (RecyclerView) view.findViewById(R.id.fragment_similar_item_loading_rv);
        textView = (TextView) view.findViewById(R.id.fragment_suggested_ads_tv);
    }
}
