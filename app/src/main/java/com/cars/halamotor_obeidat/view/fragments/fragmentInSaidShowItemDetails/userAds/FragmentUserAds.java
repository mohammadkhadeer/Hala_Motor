package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails.userAds;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.model.UserItem;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.view.adapters.adapterShowItemDetails.AdapterUserItemLoading;
import com.cars.halamotor_obeidat.view.adapters.userAds.AdapterShowUserItems;

import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor_obeidat.presnter.RelatedAdToSameCreator.getRelatedAds;

public class FragmentUserAds extends Fragment implements RelatedAds {

    RecyclerView recyclerView,recyclerViewLoading;
    TextView textView;
    ArrayList<UserItem> itemIDsArrayL= new ArrayList<>();
    public List<SuggestedItem> suggestedItemsArrayListTest;
    public List<SuggestedItem> suggestedItemsArrayListDO;
    public FragmentUserAds(){}

    String user_id,user_type,user_name;
    View view;

    LinearLayoutManager mLayoutManager;

    AdapterShowUserItems adapterShowUserItems;
    AdapterUserItemLoading adapterUserItemLoading;
    RecyclerView.LayoutManager layoutManagerLoading;
    RelatedAds relatedAds;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            user_id = getArguments().getString("user_id");
            user_type = getArguments().getString("user_type");
            user_name = getArguments().getString("user_name");
        }
        Log.i("TAG user_id: ",user_id);
        Log.i("TAG user_type: ",user_type);
        Log.i("TAG user_name: ",user_name);
        super.onAttach(context);

        if (context instanceof RelatedAds) {
            relatedAds = (RelatedAds) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user_ads, container, false);
        inti();
        changeFont();
        //timer();

        fillTextView();

        //getRelatedAds(getActivity(),user_id,user_type,relatedAds);

        createLoadingRV();
        //createRV();

        return view;
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
            if (itemIDsArrayL.size()==1)
            {
                //if user just have one active item and not hot price well show nothing
            }else{

                //actionListenerToRV();
            }
        }
    }

    private void fillTextView() {
        String text = user_name+" "+getActivity().getResources().getString(R.string.user_ads);
        textView.setText(text);
    }


//    private void actionListenerToRV() {
//        recyclerView.addOnScrollListener(new PaginationListenerUser(mLayoutManager) {
//            @Override
//            protected void loadMoreItems() {
//                numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,suggestedItemsArrayListTest.size());
//                isLoading = true;
//                currentPage++;
//                getData();
//            }
//
//            @Override
//            public boolean isLastPage() {
//                return isLastPage;
//            }
//
//            @Override
//            public boolean isLoading() {
//                return isLoading;
//            }
//        });
//    }

    private void createRV() {
        adapterShowUserItems = new AdapterShowUserItems(new ArrayList<CCEMTModel>(),getActivity(),"call");
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterShowUserItems);
        //getData();
    }
//    int loopStart=0;
//    private void getData() {
//        final List<SuggestedItem> fcsItemsArrayList = new ArrayList<>();
//        suggestedItemsArrayListTest = new ArrayList<>();
//
//        int numberOfObject = nowNumberOfObject(numberOfObjectNow,itemIDsArrayL.size());
//        if (numberOfObject!=1000) {
//            for (int i = 0; i < numberOfObject; i++) {
//                loopStart++;
//                int xx=itemIDsArrayL.size()-2;
//                if (loopStart < xx)
//                {
//                    final String category = convertCat(itemIDsArrayL.get(loopStart).getCategoryS());
//                    final String categoryBefore = itemIDsArrayL.get(loopStart).getCategoryS();
//                    DocumentReference mRef = null;
//                    mRef = getDataStoreInstance().collection(category)
//                            .document(itemIDsArrayL.get(loopStart).getItemID());
//                    mRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                            if (task.isSuccessful()) {
//                                DocumentSnapshot document = task.getResult();
//                                if (document.exists()) {
//                                    Long itemBurnedPrice = (Long) document.getLong("burnedPrice");
//                                    String itemActiveOrNotT = (String) document.getString("activeOrNotS");
//                                    fcsItemsArrayList.add(FCSFunctions.handelNumberOfObject(document, categoryBefore));
//                                }
//                            }
//                        }
//                    });
//                }
//            }
//        }
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                suggestedItemsArrayListTest.addAll(fcsItemsArrayList);
//                doApiCall();
//            }
//        }, 3000);
//    }

//    private void doApiCall() {
//        suggestedItemsArrayListDO = new ArrayList<>();
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                recyclerViewLoading.setVisibility(View.GONE);
//                suggestedItemsArrayListDO.addAll(suggestedItemsArrayListTest);
//                if (currentPage != PAGE_START) adapterShowUserItems.removeLoading();
//                adapterShowUserItems.addItems(suggestedItemsArrayListDO,similarNeeded);
//                if (currentPage < totalPage) {
//                    adapterShowUserItems.addLoading();
//                } else {
//                    isLastPage = true;
//                }
//                isLoading = false;
//            }
//        }, 100);
//    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        recyclerViewLoading = (RecyclerView) view.findViewById(R.id.fragment_user_item_loading_rv);
        textView = (TextView) view.findViewById(R.id.fragment_user_ads_more_ads);
    }

    @Override
    public void relatedAdsToSameUser(List<CCEMTModel> relatedAdsToSameUserList) {
        Log.i("TAG InFragment: ","T");
    }

//    private void getUserItemInfoList() {
//        itemIDsArrayL = new ArrayList<>();
//        getUserPathInServer(userID)
//                .child("usersAds")
//                .limitToFirst(500)
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
//                            UserItem userItem = dataSnapshot1.getValue(UserItem.class);
//                            itemIDsArrayL.add(userItem);
//                        }
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                         Log.i("TAG ERROR", databaseError.toString());
//                    }
//                });
//    }

}
