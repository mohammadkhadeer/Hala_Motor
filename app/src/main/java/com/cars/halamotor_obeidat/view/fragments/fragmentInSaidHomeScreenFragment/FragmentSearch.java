package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidHomeScreenFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.SearchCar;
import com.cars.halamotor_obeidat.view.adapters.AdapterSearch;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.FillCarModel.fillAllCarArrayL2;
import static com.cars.halamotor_obeidat.functions.Functions.fillFuelArrayL;

public class FragmentSearch extends Fragment implements AdapterSearch.PassSearch{

    public ArrayList<SearchCar> searchCarsArrayL  = new ArrayList<SearchCar>();
    RecyclerView recyclerView;
    AdapterSearch adapterSearch;
    View view;
    ArrayList<ItemSelectedFilterModel> itemTypeFromFilterAdapter = new ArrayList<>();

    public FragmentSearch(){}
    private FragmentSearchListener listener;

    public static ArrayList<CategoryComp> categoriesArrayL  = new ArrayList<CategoryComp>();

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoriesArrayL = this.getArguments().getParcelableArrayList("categories");
        }
        super.onAttach(context);
        if (context instanceof FragmentSearchListener) {
            listener = (FragmentSearchListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        inti();
        createRV();

        return view;
    }


    public void filter(String text) {
        ArrayList<SearchCar> searchCarsArrayList2  = new ArrayList<SearchCar>();
        for (SearchCar searchCar : searchCarsArrayL) {
            if (searchCar.getCarModel().toLowerCase().contains(text.toLowerCase())) {
                searchCarsArrayList2.add(searchCar);
            }
        }
        adapterSearch.filterList(searchCarsArrayList2);
    }

    private void createRV() {
        searchCarsArrayL =fillAllCarArrayL2(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterSearch = new AdapterSearch(getActivity(), searchCarsArrayL,this);
        recyclerView.setAdapter(adapterSearch);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_search_RV);
    }

    @Override
    public void onSearchClicked(SearchCar searchCar) {
        itemTypeFromFilterAdapter = new ArrayList<>();

        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel(searchCar.getCategory(),getCategoryID(searchCar.getCategoryS()),searchCar.getCategory()));

        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel("1,000","1",getCategoryID(searchCar.getCategoryS())));
        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel("200,000","100000000",getCategoryID(searchCar.getCategoryS())));

        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel(searchCar.getCarMake(),searchCar.getCarMakeS(),getCategoryID(searchCar.getCategoryS())));
        itemTypeFromFilterAdapter.add(new ItemSelectedFilterModel(searchCar.getCarModel(),searchCar.getCarModelS(),getCategoryID(searchCar.getCategoryS())));

        listener.onInputSearchSent(itemTypeFromFilterAdapter);
    }

    private String getCategoryID(String categoryS) {
        String category_id="";
        for (int i=0;i<categoriesArrayL.size();i++)
        {
            if (categoryS.equals(categoriesArrayL.get(i).getName_en()))
            {
                category_id = categoriesArrayL.get(i).getId();
            }
        }
        return category_id;
    }

    public interface FragmentSearchListener {
        void onInputSearchSent(ArrayList<ItemSelectedFilterModel> itemTypeFromFilterAdapter);
    }
}