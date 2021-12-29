package com.cars.halamotor_obeidat.view.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CCEMTModel;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.ItemFilterModel;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.Neighborhood;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment.FiltersFragment;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment.FragmentAdsList;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment.FragmentResults;
import com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment.ListsMainScreenFragment;

import java.util.ArrayList;

public class FragmentHomeScreen extends Fragment {
    FiltersFragment filtersFragment = new FiltersFragment();
    ArrayList<ItemSelectedFilterModel> itemFilterArrayList = new ArrayList<ItemSelectedFilterModel>();

    NestedScrollView nestedScrollView;
    int resulteCreate =0;
    public FragmentHomeScreen() {
    }

    View view;
    ListsMainScreenFragment listsMainScreenFragment = new ListsMainScreenFragment();
    FragmentAdsList fragmentAdsList = new FragmentAdsList();

    FragmentResults fragmentResults = new FragmentResults();

    Boolean citySelected;
    public static ArrayList<CategoryComp> categoriesArrayL  = new ArrayList<CategoryComp>();

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoriesArrayL = this.getArguments().getParcelableArrayList("categories");
            butCategoriesListOnFragmentAds();
        }
        super.onAttach(context);
    }

    private void butCategoriesListOnFragmentAds() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("categories", categoriesArrayL);
        fragmentAdsList.setArguments(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        inti();
        createFilterFragment();
        createMain();
        return view;
    }

    private void scrollView() {
        nestedScrollView.getViewTreeObserver().addOnScrollChangedListener(new
                                                                                  ViewTreeObserver.OnScrollChangedListener() {
                                                                                      @Override
                                                                                      public void onScrollChanged() {
                                                                                          View view = (View) nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1);
                                                                                          int diff = (view.getBottom() - (nestedScrollView.getHeight() + nestedScrollView.getScrollY()));
                                                                                          if (diff == 0) {
                                                                                              fragmentResults.loadMore();

                                                                                          }
                                                                                      }
                                                                                  });
    }

    private void inti() {
        nestedScrollView = (NestedScrollView) view.findViewById(R.id.nested);
    }

    public void onCityClicked(CityModel cityModel) {
        fragmentResults.onCityClicked(cityModel);
        citySelected = true;
        //createFragmentResults();
    }

    public void onCityCanceled(Boolean isCanceled) {
        citySelected = isCanceled;
        fragmentResults.onCityCanceled(isCanceled);
        checkDef();
    }

    public void onNeighborhoodClicked(Neighborhood neighborhood) {
        fragmentResults.onNeighborhoodClicked(neighborhood);
    }

    public void onNeighborhoodCanceled(Boolean isCanceled) {
        fragmentResults.onNeighborhoodCanceled(isCanceled);
    }

    public void onResultCome(ArrayList<CCEMTModel> ccemtModelArrayList) {
        fragmentResults.showResult(ccemtModelArrayList);
    }

    ////////////////////////+searchResult
    public void onFilterClicked(ArrayList<ItemSelectedFilterModel> newItemFilterArrayList) {
        itemFilterArrayList.addAll(newItemFilterArrayList);

        if (resulteCreate==0)
        {
            createFragmentResults();
            scrollView();
        }
        resulteCreate =1;
        fragmentResults.onSearchClicked(newItemFilterArrayList);
        filtersFragment.onSearch(newItemFilterArrayList);
    }

    ////////////////////////+++++++++++++++++++
    public void onFilterClicked(ItemFilterModel itemFilterModel, String filterType) {
        itemFilterArrayList.add(new ItemSelectedFilterModel(itemFilterModel.getFilter(), itemFilterModel.getFilterS(), filterType));

        fragmentResults.onFilterClicked(itemFilterModel, filterType);
        if (resulteCreate==0)
        {
            createFragmentResults();
            scrollView();
        }
        resulteCreate =1;
    }

    ///////////////////////---------------------
    public void onFilterCanceled() {
        itemFilterArrayList.remove(itemFilterArrayList.size() - 1);
        fragmentResults.onFilterCanceled();
        checkDef();
    }

    public void removeAllFilter(){
        itemFilterArrayList.clear();
        filtersFragment.removeAllSelectedFilter();
        fragmentResults.removeAllFilter();
        checkDef();
    }

    public void removeLastFilter(){
        itemFilterArrayList.remove(itemFilterArrayList.size() - 1);
        fragmentResults.onFilterCanceled();
        filtersFragment.removeLastFilter();
        checkDef();
    }

    private void createFilterFragment() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_home_fragment_filters_container, filtersFragment);
        transaction.commit();
    }

    private void createMain() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_home_fragment_suggested_item_container, fragmentAdsList);
        transaction.commit();
    }

    private void createFragmentResults() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_home_fragment_suggested_item_container, fragmentResults);
        transaction.commit();
    }

    private void checkDef() {
        if (itemFilterArrayList.isEmpty() && citySelected == null) {
            resulteCreate=0;
            createMain();
        } else {
            if (itemFilterArrayList.size() == 0 && citySelected == false) {
                resulteCreate=0;
                createMain();
            }
        }
    }

}
