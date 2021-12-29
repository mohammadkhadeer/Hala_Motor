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
import com.cars.halamotor_obeidat.model.CarInsurance;
import com.cars.halamotor_obeidat.presnter.carDetails.CarInsurancePresnter;
import com.cars.halamotor_obeidat.view.adapters.adapterInCarDetails.AdapterCarInsurance;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.ReadSetting.getCarInsuranceFromDataBase;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;

public class FragmentInsurance extends Fragment implements AdapterCarInsurance.PassIncense{

    public ArrayList<CarInsurance> carInsuranceArrayL = new ArrayList<CarInsurance>();
    RecyclerView recyclerView;
    AdapterCarInsurance adapterCarInsurance;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarInsurancePresnter carInsurancePresnter;

    public FragmentInsurance(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarInsurancePresnter) {
            carInsurancePresnter = (CarInsurancePresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carInsurancePresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_insurance, container, false);

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
        ArrayList<CarInsurance> carInsuranceArrayList2  = new ArrayList<CarInsurance>();
        for (CarInsurance carInsurance : carInsuranceArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (carInsurance.getSetting_content_name_en().toLowerCase().contains(text.toLowerCase())) {
                    carInsuranceArrayList2.add(carInsurance);
                }
            }else{
                if (carInsurance.getSetting_content_name_ar().toLowerCase().contains(text.toLowerCase())) {
                    carInsuranceArrayList2.add(carInsurance);
                }
            }
        }
        adapterCarInsurance.filterList(carInsuranceArrayList2);
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
        carInsuranceArrayL =getCarInsuranceFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarInsurance = new AdapterCarInsurance(getActivity(), carInsuranceArrayL,this);
        recyclerView.setAdapter(adapterCarInsurance);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_insurance_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_insurance_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_insurance_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_insurance_ImageV);
    }

    @Override
    public void onIncenseClicked(CarInsurance carInsurance) {
        carInsurancePresnter.passCarInsurance(carInsurance);
    }
}