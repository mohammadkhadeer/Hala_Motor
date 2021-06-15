package com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.AccAndJunkFirstCase;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.cars.halamotor.model.CategoryComp;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.model.WheelsRimFirstCase;
import com.cars.halamotor.presnter.PassCCEMT;
import com.cars.halamotor.presnter.carDetails.CarConditionPresnter;
import com.cars.halamotor.view.adapters.AdapterAdsList;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarFuel;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterAccAndJunkFirstCase;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterCCEMTAllCases;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterCarPlatesFirstCase;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterSuggestedItem;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterWheelsRim;
import com.cars.halamotor.view.fragments.InsuranceFragment;

import java.util.ArrayList;

import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstAccAndJunk;
import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstItemCCEMTFirstCase;
import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstItemWheelsRim;
import static com.cars.halamotor.dataBase.ReadFunction.getAccAndJunkDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getCarForSaleDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getCarPlatesDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getSuggestedItemFromDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getWheelsRimDatabase;
import static com.cars.halamotor.dataBase.ReadSetting.getCarFuelFromDataBase;

public class FragmentAdsList extends Fragment implements AdapterAdsList.PassCategoryCompWhenUserPressSeeAll{
    RecyclerView recyclerView;
    public static ArrayList<CategoryComp> categoriesArrayL  = new ArrayList<CategoryComp>();

    AdapterAdsList adapterAdsList;
    public FragmentAdsList(){}
    View view;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoriesArrayL = this.getArguments().getParcelableArrayList("categories");
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ads_list, container, false);
        inti();
        createList();

        return view;
    }

    private void createList() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterAdsList = new AdapterAdsList(getActivity(), categoriesArrayL,this);
        recyclerView.setAdapter(adapterAdsList);

    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.ads_RV);

    }


    @Override
    public void onSeeAllClicked(CategoryComp categoryComp) {
        Log.w("TAG","CategoryComp name: "+categoryComp.getName_en());

    }
}
