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
import com.cars.halamotor_obeidat.view.adapters.AdapterAdsList;

import java.util.ArrayList;

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
