package com.cars.halamotor_obeidat.view.fragments.userProfileFragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.FCSFunctions;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.UserItem;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.presnter.WheelsComp;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.AdapterShowFCSItems;
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

import static com.cars.halamotor_obeidat.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;
import static com.cars.halamotor_obeidat.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor_obeidat.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor_obeidat.presnter.RelatedAdToSameCreator.getRelatedAds;
import static com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class UserProfilePostsList extends Fragment implements RelatedAds{

    View view;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AdapterShowFCSItems adapterShowFCSItems;

    ArrayList<UserItem> itemIDsArrayL= new ArrayList<>();
    public List<SuggestedItem> suggestedItemsArrayListTest;
    public List<SuggestedItem> suggestedItemsArrayListDO;


    private int currentPage = PAGE_START;
    private int totalPage = 10;
    private boolean isLastPage = false;
    private boolean isLoading = false;

    CreatorInfo creatorInfo;
    int numberOfObjectNow = 0;

    public UserProfilePostsList(){}
    RelatedAds relatedAds;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            creatorInfo = getArguments().getParcelable("creator_info");
        }
        super.onAttach(context);
        if (context instanceof RelatedAds) {
            relatedAds = (RelatedAds) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        relatedAds = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_posts_list, container, false);
        inti();
        createRV();

        progressBar.getIndeterminateDrawable()
                .setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorRed), PorterDuff.Mode.SRC_IN );

        getRelatedAds(getActivity(),creatorInfo.getUser_id(),creatorInfo.getType(),relatedAds);

//        getUserItemInfoList();
//        timer();

        return view;
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
            //number of ads itemIDsArrayL
            createRV();
            actionListenerToRV();
        }
    }

    private void actionListenerToRV() {
        recyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                progressBar.setVisibility(View.VISIBLE);
                numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,suggestedItemsArrayListTest.size());
                isLoading = true;
                currentPage++;
                //getData();
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


    private void inti() {
        progressBar = (ProgressBar) view.findViewById(R.id.fragment_user_show_posts_progress);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_user_show_posts_RV);
    }

    @Override
    public void relatedAdsToSameUser(List<CCEMTModel> relatedAdsToSameUserList) {
        Log.i("TAG","I'm here in fragment");

    }

    public void handleList(List<CCEMTModel> relatedAdsToSameUserList){
        //adapterShowFCSItems.addItems(relatedAdsToSameUserList);
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
}