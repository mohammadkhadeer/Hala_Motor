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
import com.cars.halamotor.model.ItemSelectedFilterModel;
import com.cars.halamotor.model.ResultFilter;
import com.cars.halamotor.model.SimilarAdsComp;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.model.SuggestedItem;
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
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class FragmentSuggestedAds extends Fragment {

    RecyclerView recyclerView,recyclerViewLoading;
    TextView textView;
    public FragmentSuggestedAds(){}

    View view;
    SimilarNeeded similarNeeded;
    AdapterUserItemLoading adapterUserItemLoading;
    RecyclerView.LayoutManager layoutManagerLoading;
    ArrayList<ItemSelectedFilterModel> itemFilterArrayList ;
    SimilarAdsComp similarAdsComp;
    String city,neighborhood;
    String category,itemId;
    ResultFilter resultFilter = null;

    List<SuggestedItem> resultItemsArrayListCont = new ArrayList<>();
    List<SuggestedItem> resultItemsArrayList = new ArrayList<>();
    List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();

    DocumentSnapshot lastVisible;

    private int currentPage = PAGE_START;
    private int totalPage = 10;
    private boolean isLastPage = false;
    private boolean isLoading = false;
    AdapterSuggestedItems adapterSuggestedItems;
    LinearLayoutManager mLayoutManager;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            category = getArguments().getString("category");
            itemId = getArguments().getString("itemID");
            similarNeeded = (SimilarNeeded) getArguments().getParcelable("similarNeeded");
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_suggested_ads, container, false);
//        Log.i("TAG",test);
        inti();
        changeFont();
        createLoadingRV();
        createRV();
        actionListenerToRV();
        return view;
    }

    private void actionListenerToRV() {
        recyclerView.addOnScrollListener(new PaginationListenerUser(mLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
                getData();
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
        adapterSuggestedItems = new AdapterSuggestedItems(new ArrayList<SuggestedItem>(),getActivity(),"call",similarNeeded);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterSuggestedItems);
        handelResult();
    }

    private void handelResult() {
        itemFilterArrayList = new ArrayList<ItemSelectedFilterModel>();
        similarAdsComp = rebuildItemFilter(similarNeeded,category,getActivity());
        itemFilterArrayList = similarAdsComp.getItemFilterArrayList();
        city =similarAdsComp.getCityS();
        neighborhood = similarAdsComp.getNeighborhoodS();
        resultFilter=filterResult(itemFilterArrayList,0,getActivity(),city,neighborhood,9);
        intiRe();
    }

    private void intiRe() {
        resultItemsArrayListCont = new ArrayList<>();
        resultItemsArrayListCont = resultFilter.getResultItemsArrayList();
        doApiCall(0);
    }

    private void doApiCall(final int t) {
        resultItemsArrayList = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.setVisibility(View.VISIBLE);
                recyclerViewLoading.setVisibility(View.GONE);
                //set t number to check if this first filter if yes set data else clean old data and load new
                if (t ==1)
                {
                    //case load more
                    resultItemsArrayList.addAll(resultItemsArrayListCont);
                    if (currentPage != PAGE_START) adapterSuggestedItems.removeLoading();
                    adapterSuggestedItems.addItems(resultItemsArrayList,similarNeeded);
                    if (currentPage < totalPage) {
                        adapterSuggestedItems.addLoading();
                    } else {
                        isLastPage = true;
                    }
                    isLoading = false;
                }else{
                    //case get response
                    currentPage = PAGE_START;
                    resultItemsArrayList.addAll(resultItemsArrayListCont);
                    resultItemsArrayList = getResultWithoutSameAds(resultItemsArrayList);
                    if (currentPage != PAGE_START) adapterSuggestedItems.removeLoading();
                    adapterSuggestedItems.addItems(resultItemsArrayList,similarNeeded);
                    if (currentPage < totalPage) {
                        adapterSuggestedItems.addLoading();
                    } else {
                        isLastPage = true;
                    }
                    isLoading = false;
//                    if (resultItemsArrayList.size() <8)
//                    {
//                        //this mean the result is less 8 if remove filter we take anther suggested item
//                        similarNeeded = new SimilarNeeded(similarNeeded.getPriceFrom(),similarNeeded.getPriceTo(),"empty","empty",similarNeeded.getCity(),"empty",similarNeeded.getWheelsType(),similarNeeded.getCarPlatesCity(),similarNeeded.getWheelsSize());
//                        similarAdsComp = rebuildItemFilter(similarNeeded,category,getActivity());
//                        itemFilterArrayList = similarAdsComp.getItemFilterArrayList();
//                        city =similarAdsComp.getCityS();
//                        neighborhood = similarAdsComp.getNeighborhoodS();
//                        int numberOfAds = 9-resultItemsArrayListCont.size();
//                        resultFilter=filterResult(itemFilterArrayList,0,getActivity(),city,neighborhood,numberOfAds);
//                        resultItemsArrayListCont = resultFilter.getResultItemsArrayList();
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                doApiCall(0);
//                            }
//                        }, 3000);
//                    }else{
//
//                    }
                }

            }
        }, 2100);
    }

    private List<SuggestedItem> getResultWithoutSameAds(List<SuggestedItem> resultItemsArray) {
        for (int i=0;i<resultItemsArray.size();i++)
        {
            if (resultItemsArray.get(i).getItemIdInServer().equals(itemId))
            {
                resultItemsArray.remove(i);
            }
        }
        return resultItemsArray;
    }

    private void getData() {
        fcsItemsArrayList = new ArrayList<>();
        final String category = itemFilterArrayList.get(0).getFilterType();
        final String categoryAfter = convertCat(category);

        if(resultItemsArrayListCont.size() !=0)
        {
            resultItemsArrayListCont = new ArrayList<>();
            int x= currentPage-1;
            if (x == PAGE_START)
                lastVisible = resultFilter.getDocumentSnapshotsArrayL().get(resultFilter.getDocumentSnapshotsArrayL().size()-1);

//        if (lastVisible == null)
//        {
//            Log.i("TAG","lastVisible: "+"Null");
//        }else{
//            Log.i("TAG","lastVisible: "+lastVisible);
//        }
            CollectionReference mRef = getDataStoreInstance().collection(categoryAfter);
            mRef.limit(8)
                    .startAfter(lastVisible)
                    .whereEqualTo("activeOrNotS", "1")
                    .whereEqualTo("burnedPrice",0 )
                    .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                                    @Override
                                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                                        for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
//                                                            Log.i("LoadMore", "New Object " + documentSnapshots);
                                                            fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(documentSnapshots,category));
                                                            lastVisible = documentSnapshots;
                                                        }
                                                    }
                                                }
            ).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("ERROR fireStore", e.toString());
                }
            });

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resultItemsArrayListCont.addAll(fcsItemsArrayList);
                    doApiCall(1);
                }
            }, 2000);
        }

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
