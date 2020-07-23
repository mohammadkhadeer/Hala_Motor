package com.cars.halamotor.view.fragments.userProfileFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.functions.FCSFunctions;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.Follower;
import com.cars.halamotor.model.Following;
import com.cars.halamotor.model.SimilarNeeded;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.model.UserItem;
import com.cars.halamotor.model.UserProfileInfo;
import com.cars.halamotor.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor.algorithms.FollowingTest.checkIfFollow;
import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.dataBase.InsertFunctions.insertFollowingTable;
import static com.cars.halamotor.dataBase.ReadFunction.checkIfTableFollowing;
import static com.cars.halamotor.dataBase.ReadFunction.getFollowing;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.getUserPathInServer;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertFollower;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertFollowing;
import static com.cars.halamotor.fireBaseDB.FireBaseDBPaths.insertNewUser;
import static com.cars.halamotor.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor.functions.FCSFunctions.convertCat;
import static com.cars.halamotor.functions.FillSimilarNeeded.intiEmptyObject;
import static com.cars.halamotor.functions.HandelItemObjectBeforePass.getFollowingObjectFromDB;
import static com.cars.halamotor.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor.sharedPreferences.UserInfoSP.getUserInfoFromSP;
import static com.cars.halamotor.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

public class UserProfilePostsList extends Fragment {

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
    SimilarNeeded similarNeeded;
    String userID;
    int numberOfObjectNow = 0;

    public UserProfilePostsList(){}

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            userID = getArguments().getString("userID");
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_posts_list, container, false);
        similarNeeded = intiEmptyObject();
        inti();
        getUserItemInfoList();
        timer();

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
                numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,suggestedItemsArrayListTest.size());
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
                if (currentPage != PAGE_START) adapterShowFCSItems.removeLoading();
                adapterShowFCSItems.addItems(suggestedItemsArrayListDO,similarNeeded);
                if (currentPage < totalPage) {
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

        //int numberOfObject = currentPage*10;
        int numberOfObject = nowNumberOfObject(numberOfObjectNow,itemIDsArrayL.size());

        int i;
        for ( i =0; i < numberOfObject; i++) {
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
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<SuggestedItem>(),getActivity(),"call",similarNeeded);
        recyclerView.setAdapter(adapterShowFCSItems);
    }

    private void getUserItemInfoList() {
        itemIDsArrayL = new ArrayList<>();
        getUserPathInServer(userID)
                .child("usersAds")
                .limitToFirst(500)
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

    private void inti() {
        progressBar = (ProgressBar) view.findViewById(R.id.fragment_user_show_posts_progress);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_user_show_posts_RV);
    }

}