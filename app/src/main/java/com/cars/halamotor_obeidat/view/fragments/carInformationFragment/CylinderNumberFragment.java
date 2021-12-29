package com.cars.halamotor_obeidat.view.fragments.carInformationFragment;

import android.app.Activity;
import android.content.Context;
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
import com.cars.halamotor_obeidat.model.CylinderNumber;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.adapters.adapterInsurance.AdapterCylinderNumber;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getAllCarProcess;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.fillCylinderNumberArrayL;

public class CylinderNumberFragment extends Fragment implements AdapterCylinderNumber.PassCylinderNumber{

    public ArrayList<CylinderNumber> cylinderNumbersArrayL  = new ArrayList<CylinderNumber>();
    RecyclerView recyclerView;
    AdapterCylinderNumber adapterCylinderNumber;
    String carMakeStr;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            carMakeStr = getAllCarProcess(getActivity()).get(0).getProcessContent().getProcessContent();
        }
        super.onAttach(context);
    }

    public CylinderNumberFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_model, container, false);

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
        ArrayList<CylinderNumber> cylinderNumbersArrayList2  = new ArrayList<CylinderNumber>();
        for (CylinderNumber cylinderNumber : cylinderNumbersArrayL) {
            //if the existing elements contains the search input
            if (cylinderNumber.getCylinderNumber().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                cylinderNumbersArrayList2.add(cylinderNumber);
            }
        }
        //calling a method of the adapter class and passing the filtered list
        adapterCylinderNumber.filterList(cylinderNumbersArrayList2);
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
        cylinderNumbersArrayL= fillCylinderNumberArrayL(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCylinderNumber = new AdapterCylinderNumber(getActivity(), cylinderNumbersArrayL,this);
        recyclerView.setAdapter(adapterCylinderNumber);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_model_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_model_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_model_cancel_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_model_ImageV);
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
    public void onCylinderNumberClicked(CylinderNumber cylinderNumber) {
        saveInDataBase(cylinderNumber);
        if (getProcessTypeFromIntent().equals("fill"))
        {
            CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
            completeInsuranceInfo.nextFragmentCar("City");
            completeInsuranceInfo.updateTitleCar("City");
        }else{
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
        }
    }

    private void saveInDataBase(CylinderNumber cylinderNumber) {
        getDataBaseInstance(getActivity()).updateCarDetails(
                "Car cylinder",getActivity().getResources().getString(R.string.car_cylinder_process)
                ,cylinderNumber.getCylinderNumber()
                ,cylinderNumber.getCylinderNumberS(),"true");
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }


}