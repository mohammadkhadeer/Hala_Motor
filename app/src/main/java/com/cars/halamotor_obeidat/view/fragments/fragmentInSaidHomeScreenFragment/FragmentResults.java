package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.ItemFilterModel;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.Neighborhood;
import com.cars.halamotor_obeidat.model.ResultFilter;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.new_presenter.SearchResult;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import static com.cars.halamotor_obeidat.fireBaseDB.FilterFireStore.filterResult2;
import static com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;
import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentResults extends Fragment {

    public FragmentResults(){}
    View view;
    Boolean citySelected;
    String city="empty",neighborhoodStr="empty";
    ArrayList<ItemSelectedFilterModel> itemFilterArrayList = new ArrayList<ItemSelectedFilterModel>();
    List<SuggestedItem> resultItemsArrayList = new ArrayList<>();
    List<SuggestedItem> resultItemsArrayListCont = new ArrayList<>();
    ResultFilter resultFilter = null;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AdapterShowFCSItems adapterShowFCSItems;

    private int currentPage = PAGE_START;
    private int totalPage = 10;
    private boolean isLastPage = false;
    private boolean isLoading = false;
    int controler;

    DocumentSnapshot lastVisible;

    ProgressBar progressBar;
    RelativeLayout relativeLayout;
    TextView textViewMessage;
    CardView cardViewContainerMessage;

    SearchResult searchResult;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SearchResult) {
            searchResult = (SearchResult) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        searchResult = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_results, container, false);
        inti();
        createRV();

        return view;
    }

    private boolean check(){
        if (itemFilterArrayList.size() ==0)
            return false;
        else return true;
    }

    public void onCityClicked(CityModel cityModel) {
        citySelected = true;

        city = cityModel.getCityS();
        if (check())
        {
            handelResult();
        }
    }

    public void onCityCanceled(Boolean isCanceled) {
        citySelected = isCanceled;
        city="empty";
        neighborhoodStr="empty";
        if (check())
        {
            handelResult();
        }
    }

    public void onNeighborhoodClicked(Neighborhood neighborhood) {
        neighborhoodStr = neighborhood.getNeighborhoodS();
        if (check())
        {
            handelResult();
        }
    }

    public void onNeighborhoodCanceled(Boolean isCanceled) {
        neighborhoodStr="empty";
        if (check())
        {
            handelResult();
        }
    }

    ////////////////////////+++++++++++++++++++
    public void onFilterClicked(ItemFilterModel itemFilterModel, String filterType) {
        currentPage =1;
        itemFilterArrayList.add(new ItemSelectedFilterModel(itemFilterModel.getFilter()
                ,itemFilterModel.getFilterS(),filterType));


        handelResult();
    }

    ////////////////////////+search

    public void onSearchClicked(final ArrayList<ItemSelectedFilterModel> newItemFilterArrayList) {
        // i use handler cos i don't know why context not created
        itemFilterArrayList = new ArrayList<>();
        currentPage =1;
        itemFilterArrayList.addAll(newItemFilterArrayList);
        if (newItemFilterArrayList.size() == 0)
        {
            showMessageNoResult();
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    hidMessageNoResult();
                    handelResult();
                }
            }, 100);
        }
    }

    private void handelResult() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                hidMessageNoResult();
            }
        }, 50);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                resultFilter=filterResult2(itemFilterArrayList,0,getApplicationContext(),city,neighborhoodStr,8,searchResult,currentPage);
            }
        }, 100);
    }

    public void showResult(ArrayList<CCEMTModel> ccemtModelArrayList){
        if (currentPage ==1)
            createRV();
        doApiCall(ccemtModelArrayList);
    }

    ArrayList<CCEMTModel> suggestedItemsArrayListDO = new ArrayList<>();
    private void doApiCall(ArrayList<CCEMTModel> ccemtModelArrayList) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        suggestedItemsArrayListDO = new ArrayList<>();
        ccemtModelArrayList.addAll(suggestedItemsArrayListDO);

        if (currentPage != PAGE_START && ccemtModelArrayList.size() !=0) adapterShowFCSItems.removeLoading();
            if (ccemtModelArrayList.size() !=0)
                adapterShowFCSItems.addItems(ccemtModelArrayList);

        isLoading = false;
    }

    ///////////////////////---------------------
    public void onFilterCanceled() {
        if (itemFilterArrayList.size() != 0)
        {
            currentPage =1;
            itemFilterArrayList.remove(itemFilterArrayList.size()-1);
            if (itemFilterArrayList.size() != 0) {
                handelResult();
            }
        }
    }

    public void removeAllFilter(){
        itemFilterArrayList.clear();
    }

    public void loadMore(){
        if (controler ==0 )
        {
            loading();
            isLoading = true;
            currentPage++;
            getData();
            //doApiCall(1);
        }
        controler =1;
        handelControler();
    }

    private void handelControler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // set this number coz when scroll don nested scroll call the method twice
                controler =0;

            }
        }, 50);
    }


    private void messageNoResult(String message) {
        cardViewContainerMessage.setVisibility(View.VISIBLE);
        textViewMessage.setText(message);
    }

    private void hidMessageNoResult() {
        cardViewContainerMessage.setVisibility(View.GONE);
    }

    private void showMessageNoResult() {
        cardViewContainerMessage.setVisibility(View.VISIBLE);
    }

    List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();

    private void getData() {
        Log.i("TAG","currentPage "+String.valueOf(currentPage));
        resultFilter=filterResult2(itemFilterArrayList,0,getApplicationContext(),city,neighborhoodStr,8,searchResult,currentPage);
//        fcsItemsArrayList = new ArrayList<>();
//        final String category = itemFilterArrayList.get(0).getFilterS();
//        final String categoryAfter = convertCat(category);
//
//        if(resultItemsArrayListCont.size() !=0)
//        {
//
//            resultItemsArrayListCont = new ArrayList<>();
//            int x= currentPage-1;
//            if (x == PAGE_START)
//                lastVisible = resultFilter.getDocumentSnapshotsArrayL().get(resultFilter.getDocumentSnapshotsArrayL().size()-1);
//
////        if (lastVisible == null)
////        {
////            Log.i("TAG","lastVisible: "+"Null");
////        }else{
////            Log.i("TAG","lastVisible: "+lastVisible);
////        }
//            CollectionReference mRef = getDataStoreInstance().collection(categoryAfter);
//            mRef.limit(8)
//                    .startAfter(lastVisible)
//                    .whereEqualTo("activeOrNotS", "1")
//                    .whereEqualTo("burnedPrice",0 )
//                    .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                                                    @Override
//                                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                                                        for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
////                                                            Log.i("LoadMore", "New Object " + documentSnapshots);
//                                                            fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(documentSnapshots,category));
//                                                            lastVisible = documentSnapshots;
//                                                        }
//                                                    }
//                                                }
//            ).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.d("ERROR fireStore", e.toString());
//                }
//            });
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    resultItemsArrayListCont.addAll(fcsItemsArrayList);
//                }
//            }, 2000);
//        }
    }

    private void createRV() {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<CCEMTModel>(),getActivity(),"search");
        recyclerView.setAdapter(adapterShowFCSItems);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.show_result_RV);
        progressBar = (ProgressBar) view.findViewById(R.id.fragment_result);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.progressBarLodaing);
        textViewMessage = (TextView) view.findViewById(R.id.fragment_results_message);
        cardViewContainerMessage=(CardView) view.findViewById(R.id.fragment_results_message_container);
    }

    private void loading(){
        relativeLayout.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.GONE);

            }
        }, 50);
    }

}
