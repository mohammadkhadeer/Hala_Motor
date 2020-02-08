package com.cars.halamotor.view.fragments.carDetailsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cars.halamotor.R;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarYear;

import java.util.ArrayList;

import static com.cars.halamotor.functions.Functions.fillCarYearArrayList;

public class FragmentYear extends Fragment implements AdapterCarYear.PassCarYear{

    public ArrayList<String> carYearArrayL  = new ArrayList<String>();
    RecyclerView recyclerView;
    AdapterCarYear adapterCarYear;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;

    public FragmentYear() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_year, container, false);
        inti();
        createRV();
        actionListenerToSearchEdt();
        return view;
    }

    private void actionListenerToSearchEdt() {
        searchEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0)
                    makeCancelTitleIVVISIBLE();
                else
                    makeCancelTitleIVGONE();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }

        });
    }

    private void filter(String text) {
        ArrayList<String> carModelArrayList2  = new ArrayList<String>();
        for (String carModel : carYearArrayL) {
            //if the existing elements contains the search input
            if (carModel.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                carModelArrayList2.add(carModel);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapterCarYear.filterList(carModelArrayList2);
    }

    private void makeCancelTitleIVGONE() {
        cancelIV.setVisibility(View.GONE);
    }

    private void makeCancelTitleIVVISIBLE() {
        cancelIV.setVisibility(View.VISIBLE);
    }

    private void createRV() {
        carYearArrayL = fillCarYearArrayList(carYearArrayL,getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarYear = new AdapterCarYear(getActivity(), carYearArrayL,this);
        recyclerView.setAdapter(adapterCarYear);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_year_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_year_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_year_cancel_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_year_ImageV);
    }

    @Override
    public void onYearClicked(String carYear) {

    }
}