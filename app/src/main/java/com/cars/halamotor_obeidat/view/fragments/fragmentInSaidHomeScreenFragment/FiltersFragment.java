package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CityModel;
import com.cars.halamotor_obeidat.model.ItemFilterModel;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.Neighborhood;
import com.cars.halamotor_obeidat.presnter.Filter;
import com.cars.halamotor_obeidat.view.adapters.adapterFilterFragment.AdapterFiltersCity;
import com.cars.halamotor_obeidat.view.adapters.adapterFilterFragment.AdapterFiltersItem;
import com.cars.halamotor_obeidat.view.adapters.adapterFilterFragment.AdapterSelectedFilters;
import com.cars.halamotor_obeidat.view.adapters.adapterFilterFragment.AdapterFiltersNeighborhood;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.cars.halamotor_obeidat.functions.FillFilters.fillFilter;
import static com.cars.halamotor_obeidat.functions.FillNeighborhood.fillCityArrayL;
import static com.cars.halamotor_obeidat.functions.FillNeighborhood.fillNeighborhoodArrayLFromDataBase;
import static com.cars.halamotor_obeidat.functions.FillNeighborhood.resortNeighborhoodArrayL;
import static com.cars.halamotor_obeidat.functions.NewFunction.getTitle;

public class FiltersFragment extends Fragment implements AdapterFiltersCity.PassCity
            , AdapterFiltersNeighborhood.PassNeighborhood,AdapterFiltersItem.PassFilter
            ,AdapterSelectedFilters.PassCancelItem{

    public FiltersFragment(){}
    View view;
    ArrayList<CityModel> emiratesItemsArrayL = new ArrayList<CityModel>();
    ArrayList<ItemSelectedFilterModel> selectedFilterArrayL = new ArrayList<ItemSelectedFilterModel>();
    ArrayList<ItemFilterModel> filterItemsArrayL = new ArrayList<ItemFilterModel>();
    AdapterFiltersCity adapterFilters;
    AdapterSelectedFilters adapterSelectedFilters;
    RecyclerView filter1RV,selectedFilterRV,filter2RV,recyclerViewNeighborhood;
    RecyclerView.LayoutManager layoutManagerSuggested,layoutManagerSelected,layoutManagerNeighborhood;

    RelativeLayout cancelCityRL,cancelNeighborhoodRL;
    CardView selectedCityCV,selectedNeighborhoodCV;
    TextView cityNameTV,neighborhoodNameTV;

    ArrayList<Neighborhood> cityNeighborhoodArrayL = new ArrayList<Neighborhood>();
    AdapterFiltersNeighborhood adapterFiltersNeighborhood;
    String selectedCityStr;
    ArrayList<ItemSelectedFilterModel> itemTypeFromFilterAdapter = new ArrayList<ItemSelectedFilterModel>();


    AdapterFiltersItem adapterFiltersItem;
    int numberOfSelectedFilter=0;
    Filter filter;
    LinearLayout containerFilterLL;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Filter) {
            filter = (Filter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        filter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filters_fragment, container, false);
        init();
//        changeFont();
        createFilterOneRV();
        createFilterTowRV();
        createSelectedFilterRV();
        actionListener();
        return view;
    }

//    private void changeFont() {
//        textViewFilterName.setTypeface(Functions.changeFontGeneral(getApplicationContext()));
//    }

    private void actionListenerToCancelNeighborhood() {
        cancelNeighborhoodRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedNeighborhoodCV.setVisibility(View.GONE);
                recyclerViewNeighborhood.setVisibility(View.VISIBLE);
                filter.onFilterNeighborhoodCancel(false);
//                createNeighborhoodRV(selectedCityStr);
            }
        });
    }

    private void actionListenerToCancelCity() {
        cancelCityRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedNeighborhoodCV.setVisibility(View.GONE);
                recyclerViewNeighborhood.setVisibility(View.GONE);

                selectedCityCV.setVisibility(View.GONE);
                filter1RV.setVisibility(View.VISIBLE);

                filter.onFilterCityCancel(false);
            }
        });
    }

    private void createSelectedFilterRV() {
        fillSelected();
        selectedFilterRV.setHasFixedSize(true);
        layoutManagerSelected = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        selectedFilterRV.setLayoutManager(layoutManagerSelected);
        adapterSelectedFilters =new AdapterSelectedFilters(getActivity()
                ,selectedFilterArrayL,"main_screen",this);
        selectedFilterRV.setAdapter(adapterSelectedFilters);
    }

    private void fillSelected() {
        if (numberOfSelectedFilter==0)
        {
            selectedFilterArrayL = new ArrayList<ItemSelectedFilterModel>();
            selectedFilterArrayL.add(new ItemSelectedFilterModel(getActivity().getResources().getString(R.string.all),getActivity().getResources().getString(R.string.all),"empty" ));
        }
    }

    private void createFilterOneRV() {
        emiratesItemsArrayL = fillCityArrayL(getActivity());
        filter1RV.setHasFixedSize(true);
        layoutManagerSuggested = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        filter1RV.setLayoutManager(layoutManagerSuggested);
        adapterFilters =new AdapterFiltersCity(getActivity()
                , emiratesItemsArrayL,"main_screen",this);
        filter1RV.setAdapter(adapterFilters);
    }


    private void init() {
        filter1RV = (RecyclerView) view.findViewById(R.id.fragment_filter_1_RV);
        selectedFilterRV = (RecyclerView) view.findViewById(R.id.fragment_selected_filter_RV);
        filter2RV = (RecyclerView) view.findViewById(R.id.fragment_filter_2_RV);

        recyclerViewNeighborhood = (RecyclerView) view.findViewById(R.id.fragment_filter_neighborhood_RV);

        selectedCityCV = (CardView) view.findViewById(R.id.fragment_filter_selected_city);
        cancelCityRL = (RelativeLayout) view.findViewById(R.id.fragment_filter_selected_cancel_city);
        cityNameTV = (TextView) view.findViewById(R.id.fragment_filter_selected_content_text_view);

        selectedNeighborhoodCV = (CardView) view.findViewById(R.id.fragment_filter_selected_neighborhood);
        cancelNeighborhoodRL = (RelativeLayout) view.findViewById(R.id.fragment_filter_selected_cancel_neighborhood);
        neighborhoodNameTV = (TextView) view.findViewById(R.id.fragment_filter_selected_neighborhood_text_view);
        containerFilterLL = (LinearLayout) view.findViewById(R.id.container_filter);
    }

    private void actionListener() {
        actionListenerToCancelCity();
        actionListenerToCancelNeighborhood();
    }

    @Override
    public void onCityClicked(CityModel cityModel) {
        cityNameTV.setText(getTitle(cityModel.getCity(),cityModel.getCityAr(),getActivity()));
        selectedCityCV.setVisibility(View.VISIBLE);
        filter1RV.setVisibility(View.GONE);

        selectedCityStr = cityModel.getCity();

        filter.onFilterCityClick(cityModel);

        createNeighborhoodRV(cityModel.getCityS());
//        if (selectedFilterArrayL.size() == 0)
//        {
//            Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.fill_category_please),Toast.LENGTH_SHORT).show();
//        }else{
//
//        }
    }

    private void createNeighborhoodRV(String city) {
        recyclerViewNeighborhood.setVisibility(View.VISIBLE);
        cityNeighborhoodArrayL = new ArrayList<>();
        cityNeighborhoodArrayL = fillNeighborhoodArrayLFromDataBase(getActivity(),city);

        Collections.sort(cityNeighborhoodArrayL, new Comparator<Neighborhood>() {
            @Override
            public int compare(Neighborhood lhs, Neighborhood rhs) {
                return lhs.getNeighborhood().compareTo(rhs.getNeighborhood());
            }
        });

        cityNeighborhoodArrayL =resortNeighborhoodArrayL(cityNeighborhoodArrayL,getActivity());
        recyclerViewNeighborhood.setHasFixedSize(true);
        layoutManagerNeighborhood = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerViewNeighborhood.setLayoutManager(layoutManagerNeighborhood);
        adapterFiltersNeighborhood =new AdapterFiltersNeighborhood(getActivity()
                , cityNeighborhoodArrayL,"main_screen",this);
        recyclerViewNeighborhood.setAdapter(adapterFiltersNeighborhood);
    }

    @Override
    public void onNeighborhoodClicked(Neighborhood neighborhood) {
        filter.onFilterNeighborhoodClick(neighborhood);
        neighborhoodNameTV.setText(getTitle(neighborhood.getNeighborhood(),neighborhood.getNeighborhoodAr(),getActivity()));
        selectedNeighborhoodCV.setVisibility(View.VISIBLE);
        recyclerViewNeighborhood.setVisibility(View.GONE);
    }

    /////////////////////////////+
    @Override
    public void onFilterClicked(ItemFilterModel itemFilterModel) {
        //reVISIBLEFilter();
        //to remove word "All" from selected filter
        if (numberOfSelectedFilter==0)
        {
            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            adapterSelectedFilters.notifyDataSetChanged();
        }

        numberOfSelectedFilter =numberOfSelectedFilter+1;

        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel(itemFilterModel.getFilter(),itemFilterModel.getFilterS(),itemFilterModel.getFilter()));

        selectedFilterArrayL.add(new ItemSelectedFilterModel(itemFilterModel.getFilter(),itemFilterModel.getFilterS(),itemTypeFromFilterAdapter.get(itemTypeFromFilterAdapter.size()-1).getFilterType()));
        adapterSelectedFilters.notifyDataSetChanged();

        //FilterItemsFun(selectedFilterArrayL,getApplicationContext(),"empty","empty");

        filter.onFilterClick(itemFilterModel,itemTypeFromFilterAdapter.get(itemTypeFromFilterAdapter.size()-1).getFilterType());

        createFilterTowRV();

    }


    public void onSearch(ArrayList<ItemSelectedFilterModel> newSelectedFilterArrayL){
        if (numberOfSelectedFilter==0)
        {
            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
        }else{
            for (int i=0;i<selectedFilterArrayL.size();i++)
            {
                selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            }
        }

        numberOfSelectedFilter = 5;
        selectedFilterArrayL.addAll(newSelectedFilterArrayL);
        adapterSelectedFilters.notifyDataSetChanged();
        //add all fillter
        for (int i=0;i<selectedFilterArrayL.size();i++)
        {
            itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel(selectedFilterArrayL.get(i).getFilter(),selectedFilterArrayL.get(i).getFilterS(),selectedFilterArrayL.get(i).getFilterType()));
        }
        createFilterTowRV();
    }

    private void createFilterTowRV() {

        filterItemsArrayL = fillFilter(getActivity(),numberOfSelectedFilter,itemTypeFromFilterAdapter);
        filter2RV.setHasFixedSize(true);
        layoutManagerSuggested = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        filter2RV.setLayoutManager(layoutManagerSuggested);
        adapterFiltersItem =new AdapterFiltersItem(getActivity()
                , filterItemsArrayL,"category",this);
        filter2RV.setAdapter(adapterFiltersItem);
    }

    private void reVISIBLEFilter() {
        containerFilterLL.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                containerFilterLL.setVisibility(View.VISIBLE);
            }
        }, 200);
    }

    @Override
    public void onFilterClicked(ItemSelectedFilterModel itemSelectedFilterModel) {
        numberOfSelectedFilter =numberOfSelectedFilter-1;
        //itemTypeFromFilterAdapter = itemSelectedFilterModel.getFilterS();
        reVISIBLEFilter();
        if (numberOfSelectedFilter==0)
        {
            itemTypeFromFilterAdapter.clear();
            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            selectedFilterArrayL.add(new ItemSelectedFilterModel(getActivity().getResources().getString(R.string.all),getActivity().getResources().getString(R.string.all),"empty" ));
            adapterSelectedFilters.notifyDataSetChanged();
        }else{
            itemTypeFromFilterAdapter.remove(itemTypeFromFilterAdapter.size()-1);

            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            adapterSelectedFilters.notifyDataSetChanged();
        }
        filter.onFilterCancel();
        createFilterTowRV();
    }

    public void removeLastFilter(){
        numberOfSelectedFilter =selectedFilterArrayL.size()-1;
        //itemTypeFromFilterAdapter = itemSelectedFilterModel.getFilterS();
        reVISIBLEFilter();
        if (numberOfSelectedFilter==0)
        {
            itemTypeFromFilterAdapter.clear();
            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            selectedFilterArrayL.add(new ItemSelectedFilterModel(getActivity().getResources().getString(R.string.all),getActivity().getResources().getString(R.string.all),"empty" ));
            adapterSelectedFilters.notifyDataSetChanged();
        }else{
            itemTypeFromFilterAdapter.remove(itemTypeFromFilterAdapter.size()-1);

            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
            adapterSelectedFilters.notifyDataSetChanged();
        }
        createFilterTowRV();
    }

    public void removeAllSelectedFilter(){
        reVISIBLEFilter();
        numberOfSelectedFilter =0;
        itemTypeFromFilterAdapter.clear();
        int x=selectedFilterArrayL.size();
        for (int i=0;i<x;i++)
        {
            selectedFilterArrayL.remove(selectedFilterArrayL.size()-1);
        }
        createFilterTowRV();
        selectedFilterArrayL.add(new ItemSelectedFilterModel(getActivity().getResources().getString(R.string.all),getActivity().getResources().getString(R.string.all),"empty" ));
        adapterSelectedFilters.notifyDataSetChanged();
    }
}