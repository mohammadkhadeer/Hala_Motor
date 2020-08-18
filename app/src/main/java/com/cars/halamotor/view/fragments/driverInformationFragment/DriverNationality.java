package com.cars.halamotor.view.fragments.driverInformationFragment;

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
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.dataBase.DBHelper;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.CarFuel;
import com.cars.halamotor.model.Nationality;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterDriverInfo.AdapterDriverNationality;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarFuel;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor.functions.Functions.fillFuelArrayL;
import static com.cars.halamotor.functions.InsuranceFunctions.fillNationalityArrayL;
import static com.cars.halamotor.functions.InsuranceFunctions.getDriverProcess;

public class DriverNationality extends Fragment implements AdapterDriverNationality.PassNationality {

    public ArrayList<Nationality> nationalitiesArrayL  = new ArrayList<Nationality>();
    RecyclerView recyclerView;
    AdapterDriverNationality adapterDriverNationality;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    RelativeLayout relativeLayoutCompletedProcess,relativeLayoutEmptyProcess,relativeLayoutChangeNationality;
    TextView textViewNationality,textViewChange;

    public DriverNationality(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_driver_nationality, container, false);

        inti();
        changeFont();
        checkIfSelectedNationalityOrNotSelectedYet();
        actionListenerToSearchEdt();
        actionListenerToRemoveTextInSearchEdt();

        return view;
    }

    private void changeFont() {
        textViewNationality.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewChange.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void checkIfSelectedNationalityOrNotSelectedYet() {
        if (getDriverProcess(getActivity(),"Nationality").getProcessContent().getProcessContentS()
                .equals("empty"))
        {
            createNationalityList();
        }else{
            relativeLayoutCompletedProcess.setVisibility(View.VISIBLE);
            relativeLayoutEmptyProcess.setVisibility(View.GONE);
            fillNationalityText();
            actionListenerToChangeNationality();
        }
    }

    private void createNationalityList() {
        relativeLayoutCompletedProcess.setVisibility(View.GONE);
        relativeLayoutEmptyProcess.setVisibility(View.VISIBLE);
        createRV();
    }

    private void actionListenerToChangeNationality() {
        relativeLayoutChangeNationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataBaseInstance(getActivity()).updateDriverInfo(
                        "Nationality"
                        ,getActivity().getResources().getString(R.string.nationality_process)
                        ,getActivity().getResources().getString(R.string.empty),"empty","false");

                createNationalityList();
            }

        });
    }

    private void fillNationalityText() {
        String text = getActivity().getResources().getString(R.string.ur_nationality);
        String nationality = getDriverProcess(getActivity(),"Nationality").getProcessContent().getProcessContent();
        textViewNationality.setText(text+" "+nationality);
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
        ArrayList<Nationality> nationalitiesArrayList2  = new ArrayList<Nationality>();
        for (Nationality nationality : nationalitiesArrayL) {
            if (nationality.getNationality().toLowerCase().contains(text.toLowerCase())) {
                nationalitiesArrayList2.add(nationality);
            }
        }
        adapterDriverNationality.filterList(nationalitiesArrayList2);
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
        nationalitiesArrayL =fillNationalityArrayL(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterDriverNationality = new AdapterDriverNationality(getActivity(), nationalitiesArrayL,this);
        recyclerView.setAdapter(adapterDriverNationality);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_driver_nationality_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_driver_nationality_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_driver_nationality_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_driver_nationality_ImageV);
        relativeLayoutCompletedProcess = (RelativeLayout) view.findViewById(R.id.fragment_driver_nationality_complete_case_case_rl);
        relativeLayoutEmptyProcess = (RelativeLayout) view.findViewById(R.id.fragment_driver_nationality_empty_case_rl);
        relativeLayoutChangeNationality = (RelativeLayout) view.findViewById(R.id.fragment_driver_nationality_change_natio_rl);

        textViewNationality = (TextView) view.findViewById(R.id.fragment_driver_nationality_tv);
        textViewChange = (TextView) view.findViewById(R.id.fragment_driver_nationality_change_natio_tv);
    }

    @Override
    public void onNationalityClicked(Nationality nationality) {
        Toast.makeText(getActivity(),nationality.getNationality(),Toast.LENGTH_SHORT).show();
        getDataBaseInstance(getActivity()).updateDriverInfo(
                "Nationality",getActivity().getResources().getString(R.string.nationality_process)
                ,nationality.getNationality()
                ,nationality.getNationalityS(),"true");

        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }

}