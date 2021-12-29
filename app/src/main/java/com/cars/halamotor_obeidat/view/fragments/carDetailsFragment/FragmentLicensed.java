package com.cars.halamotor_obeidat.view.fragments.carDetailsFragment;

import android.content.Context;
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

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CarLicensed;
import com.cars.halamotor_obeidat.presnter.carDetails.CarLicensedPresnter;
import com.cars.halamotor_obeidat.view.adapters.adapterInCarDetails.AdapterCarLicensed;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.ReadSetting.getCarLicensedFromDataBase;
import static com.cars.halamotor_obeidat.functions.Functions.fillFuelArrayL;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;

public class FragmentLicensed extends Fragment implements AdapterCarLicensed.PassLicensed {

    public ArrayList<CarLicensed> carLicensedArrayL  = new ArrayList<CarLicensed>();
    RecyclerView recyclerView;
    AdapterCarLicensed adapterCarLicensed;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarLicensedPresnter carLicensedPresnter;

    public FragmentLicensed(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarLicensedPresnter) {
            carLicensedPresnter = (CarLicensedPresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carLicensedPresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_licensed, container, false);

        inti();
        createRV();
        actionListenerToSearchEdt();
        actionListenerToRemoveTextInSearchEdt();

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
        ArrayList<CarLicensed> carLicensedArrayL2  = new ArrayList<CarLicensed>();
        for (CarLicensed tex : carLicensedArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (tex.getSetting_content_name_en().toLowerCase().contains(text.toLowerCase())) {
                    carLicensedArrayL2.add(tex);
                }
            }else{
                if (tex.getSetting_content_name_ar().toLowerCase().contains(text.toLowerCase())) {
                    carLicensedArrayL2.add(tex);
                }
            }
        }
        adapterCarLicensed.filterList(carLicensedArrayL2);
    }

    private void makeCancelTitleIVGONE() {
        cancelIV.setVisibility(View.GONE);
    }

    private void makeCancelTitleIVVISIBLE() {
        cancelIV.setVisibility(View.VISIBLE);
    }

    private void actionListenerToRemoveTextInSearchEdt() {
        cancelRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEdt.setText("");
            }
        });
    }

    private void createRV() {
        carLicensedArrayL =getCarLicensedFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarLicensed = new AdapterCarLicensed(getActivity(), carLicensedArrayL,this);
        recyclerView.setAdapter(adapterCarLicensed);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_licensed_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_licensed_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_licensed_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_licensed_ImageV);
    }

    @Override
    public void onLicensedClicked(CarLicensed carLicensed) {
        carLicensedPresnter.passCarLicensed(carLicensed);
    }
}