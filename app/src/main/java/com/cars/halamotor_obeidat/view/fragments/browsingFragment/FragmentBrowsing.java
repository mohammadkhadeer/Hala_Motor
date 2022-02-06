package com.cars.halamotor_obeidat.view.fragments.browsingFragment;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.FCSFunctions;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.Attributes;
import com.cars.halamotor_obeidat.model.BrowsingFilter;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.CreatorInfo;
import com.cars.halamotor_obeidat.model.FavouriteCallSearch;
import com.cars.halamotor_obeidat.model.SuggestedItem;
import com.cars.halamotor_obeidat.presnter.FCSItems;
import com.cars.halamotor_obeidat.presnter.FCSItemsList;
import com.cars.halamotor_obeidat.presnter.RelatedAds;
import com.cars.halamotor_obeidat.view.adapters.AdapterBrowsingFilter;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.AdapterShowFCSItems;
import com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.cars.halamotor_obeidat.API.APIS.BASE_API;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getFCSCallSearch;
import static com.cars.halamotor_obeidat.fireBaseDB.FireStorePaths.getDataStoreInstance;
import static com.cars.halamotor_obeidat.functions.FCSFunctions.convertCat;
import static com.cars.halamotor_obeidat.functions.Functions.checkIfAndroidVBiggerThan9;
import static com.cars.halamotor_obeidat.functions.NewFunction.fillBrowsingArrayL;
import static com.cars.halamotor_obeidat.functions.NewFunction.getNumberOfObject;
import static com.cars.halamotor_obeidat.functions.NewFunction.handelNumberOfObject;
import static com.cars.halamotor_obeidat.functions.NewFunction.nowNumberOfObject;
import static com.cars.halamotor_obeidat.presnter.FCSFromServer.getFCS;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserTokenFromServer;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.getUserTokenInFromSP;
import static com.cars.halamotor_obeidat.view.adapters.adapterShowFCS.PaginationListener.PAGE_START;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


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
    ProgressBar progressBar,progressBarLoadMore;
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
    CardView cardView;

    int number_of_items=0;
    public FragmentBrowsing(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_browsing, container, false);

        init();
        changeFont();
        createSelectedFilterRV();

        favouriteCallSearchesArrayList = new ArrayList<FavouriteCallSearch>();
        favouriteCallSearchesArrayList = getFCSCallSearch(filterContentArrayL,getActivity());
        //checkIfHaveFavOrNot();
        createRV();
        Log.i("TAG","fcsTypeStr: "+fcsTypeStr);
//        getData();
//        doApiCall();
        actionListenerToRV();
        getFCS(getActivity(),"call",currentPage);

        return view;
    }

    private void checkIfHaveFavOrNot() {
        if (favouriteCallSearchesArrayList.size()==0)
        {
            progressBar.setVisibility(View.GONE);
            cardView.setVisibility(View.VISIBLE);
            messageTV.setText(getResources().getString(R.string.no_favorite));
        }else{
            cardView.setVisibility(View.GONE);
        }
    }

    private void actionListenerToRV() {
        fcsItemsRecyclerView.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                //numberOfObjectNow =handelNumberOfObject(numberOfObjectNow,favouriteCallSearchesArrayList.size());
                currentPage++;
                if (number_of_items > 0)
                    getFCS(getActivity(),fcsTypeStr,currentPage);

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
        adapterShowFCSItems = new AdapterShowFCSItems(new ArrayList<CCEMTModel>(),getActivity(),fcsTypeStr);
        fcsItemsRecyclerView.setAdapter(adapterShowFCSItems);
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
        progressBarLoadMore = (ProgressBar) view.findViewById(R.id.show_fcs_progress_load_more);
        cardView = (CardView) view.findViewById(R.id.fragment_message_message_empty);
    }

    @Override
    public void onFilterClicked(BrowsingFilter selectedFilter) {
        filterContentArrayL = new ArrayList<>();

        textView.setText(selectedFilter.getFilterString());
        message = selectedFilter.getFilterString();

        progressBar.setVisibility(View.VISIBLE);

        //checkIfHaveFavOrNot();

        refresh(selectedFilter.getFilterContentStr());
    }

    private void refresh(String type) {
        //getFCS(this,fcsTypeStr,fcsItemsList,currentPage);

        Log.i("TAG type",type);
        numberOfObjectNow = 0;
        numberOfObjectReturn = 0;
        currentPage = PAGE_START;
        isLastPage = false;
        createRV();
        adapterShowFCSItems.clear();
        getFCS(getActivity(),type,currentPage);

    }

    public void getFCS(Context context,String FCSType,int pageNumber)
    {
//        Log.i("TAG Bearer Token",getUserTokenFromServer(context));
//        Log.i("TAG device Token",getUserTokenInFromSP(context));
//        //Log.i("TAG API",BASE_API+"/ads?is_active=1&is_hot_price=0&category_id="+categoryComp.getId());
//        Log.i("TAG","FCSType: "+FCSType);

        if (checkIfAndroidVBiggerThan9()) {
            JSONObject obj = null;
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(BASE_API+"/logs?type="+FCSType+"&page="+pageNumber)
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + getUserTokenFromServer(context))
                    .addHeader("Accept-Language", getUserLanguage(context))
                    .build();

            try {
                Response response = client.newCall(request).execute();
                try {
                    obj = new JSONObject(response.body().string());
                    JSONArray jsonArrayAllAds = obj.getJSONArray("DATA");

                    getAdsList(jsonArrayAllAds);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getAdsList(JSONArray jsonArrayAllAds) {
        //create suggested to you as object
        number_of_items = 0;
        CategoryComp categoryCompModel =null;
        JSONObject adsDetails=null,attributes=null,creator_json_info=null,categoryComp=null;
        ArrayList <String> photosArrayList ;
        ArrayList <Attributes> attributesArrayList ;
        final ArrayList <CCEMTModel> adsArrayList = new ArrayList<>();
        CreatorInfo creatorInfo =null;
        try {
            for (int i =0;i<jsonArrayAllAds.length();i++)
            {
                adsDetails = jsonArrayAllAds.getJSONObject(i).getJSONObject("ad");
                //Log.i("TAG","adsDetails: "+adsDetails.toString());

                JSONArray jsonArrayPhotos = adsDetails.getJSONArray("photos");
                JSONArray jsonArrayAttributes = adsDetails.getJSONArray("attributes");
                creator_json_info = adsDetails.getJSONObject("creator");
                creatorInfo = new CreatorInfo(
                        creator_json_info.getString("id")
                        ,creator_json_info.getString("name")
                        ,creator_json_info.getString("ads_count")
                        ,creator_json_info.getString("followers_count")
                        ,creator_json_info.getString("following_count")
                        ,creator_json_info.getString("type")
                        ,creator_json_info.getString("photo")
                );
                photosArrayList =new ArrayList<>();
                if (jsonArrayPhotos !=null && jsonArrayPhotos.length()>0)
                {
                    for (int x=0;x<jsonArrayPhotos.length();x++)
                    {
                        photosArrayList.add(jsonArrayPhotos.getString(x));
                    }
                }

                attributesArrayList =new ArrayList<>();
                for (int j=0;j<jsonArrayAttributes.length();j++)
                {
                    attributes =  jsonArrayAttributes.getJSONObject(j);
                    Attributes attributesObj = new Attributes(attributes.getString("type"),attributes.getString("value"),attributes.getString("title"));
                    attributesArrayList.add(attributesObj);
                }

                categoryComp = adsDetails.getJSONObject("category");

                categoryCompModel = new CategoryComp(
                        0
                        ,categoryComp.getString("id")
                        ,categoryComp.getString("code")
                        ,categoryComp.getString("name")
                        ,categoryComp.getString("name_en")
                        ,categoryComp.getString("name_ar")
                );

                CCEMTModel ccemtModel = new CCEMTModel(adsDetails.getString("id"),adsDetails.getString("title"),adsDetails.getString("description"),adsDetails.getString("price"),adsDetails.getString("phone"),adsDetails.getString("created_at"),categoryCompModel,photosArrayList,attributesArrayList,creatorInfo);

                adsArrayList.add(ccemtModel);
            }
            progressBar.setVisibility(View.GONE);
            number_of_items = adsArrayList.size();

            if (number_of_items > 0)
                adapterShowFCSItems.addItems(adsArrayList);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
