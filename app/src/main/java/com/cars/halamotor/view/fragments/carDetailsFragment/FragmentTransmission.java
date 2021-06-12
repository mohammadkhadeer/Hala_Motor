package com.cars.halamotor.view.fragments.carDetailsFragment;

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

import com.cars.halamotor.R;
import com.cars.halamotor.model.CarTransmission;
import com.cars.halamotor.presnter.carDetails.CarBrand;
import com.cars.halamotor.presnter.carDetails.CarKilometers;
import com.cars.halamotor.presnter.carDetails.CarTransmissionPresnter;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarTransmission;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.ReadSetting.getCarTransmissionFromDataBase;
import static com.cars.halamotor.functions.Functions.fillTransmissionArrayL;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class FragmentTransmission extends Fragment implements AdapterCarTransmission.PassTransmission{

    public ArrayList<CarTransmission> carTransmissionArrayL  = new ArrayList<CarTransmission>();
    RecyclerView recyclerView;
    AdapterCarTransmission adapterCarTransmission;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarTransmissionPresnter carTransmissionPresnter;
    public FragmentTransmission(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarTransmissionPresnter) {
            carTransmissionPresnter = (CarTransmissionPresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carTransmissionPresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_transmission, container, false);

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
        ArrayList<CarTransmission> carKilometersArrayList2  = new ArrayList<CarTransmission>();
        for (CarTransmission Kilometers : carTransmissionArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (Kilometers.getSetting_content_name_en().contains(text.toLowerCase())) {
                    carKilometersArrayList2.add(Kilometers);
                }
                else{
                    if (Kilometers.getSetting_content_name_ar().contains(text.toLowerCase())) {
                        carKilometersArrayList2.add(Kilometers);
                    }
               }
            }
        }
        adapterCarTransmission.filterList(carKilometersArrayList2);
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
        carTransmissionArrayL =getCarTransmissionFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarTransmission = new AdapterCarTransmission(getActivity(), carTransmissionArrayL,this);
        recyclerView.setAdapter(adapterCarTransmission);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_transmission_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_transmission_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_transmission_cancel_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_transmission_ImageV);
    }

    @Override
    public void onTransmissionClicked(CarTransmission carTransmission) {
        carTransmissionPresnter.passCarCondition(carTransmission);
    }
}
