package com.cars.halamotor_obeidat.view.fragments.carInformationFragment;

import android.app.Activity;
import android.content.Intent;
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
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.adapters.adapterInCarDetails.AdapterCarYear;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.Functions.fillCarYearArrayList;
import static com.cars.halamotor_obeidat.functions.NewFunction.convertYearToEng;

public class YearFragment extends Fragment implements AdapterCarYear.PassCarYear{

    public ArrayList<String> carYearArrayL  = new ArrayList<String>();
    RecyclerView recyclerView;
    AdapterCarYear adapterCarYear;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;

    public YearFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_year, container, false);

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
        ArrayList<String> carYearArrayList2  = new ArrayList<String>();
        for (String carYear : carYearArrayL) {
            if (carYear.toLowerCase().contains(text.toLowerCase())) {
                carYearArrayList2.add(carYear);
            }
        }
        adapterCarYear.filterList(carYearArrayList2);
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

    private String getProcessTypeFromIntent() {
        String processType = null;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            processType =bundle.getString("editOrFill");
        }
        return processType;
    }

    @Override
    public void onYearClicked(String carYear) {
        saveInDataBase(carYear);
        if (getProcessTypeFromIntent().equals("fill"))
        {
            CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
            completeInsuranceInfo.nextFragmentCar("Car condition");
            completeInsuranceInfo.updateTitleCar("Car condition");
        }else{
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
        }
    }

    private void saveInDataBase(String year) {
        getDataBaseInstance(getActivity()).updateCarDetails(
                "Car year",getActivity().getResources().getString(R.string.car_year_process)
                ,year
                ,convertYearToEng(year),"true");
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}