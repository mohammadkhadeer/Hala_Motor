package com.cars.halamotor_obeidat.view.fragments.driverInformationFragment;

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
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.LicenseDuration;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.adapters.adapterDriverInfo.AdapterDriverDuration;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.fillLicenseDurationArrayL;

public class DriverDuration extends Fragment implements AdapterDriverDuration.PassLicenseDuration {

    public ArrayList<LicenseDuration> licenseDurationsArrayL  = new ArrayList<LicenseDuration>();
    RecyclerView recyclerView;
    AdapterDriverDuration adapterDriverDuration;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    TextView textViewQ;

    public DriverDuration(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_drive_duration, container, false);

        inti();
        createRV();
        changeFont();
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
        ArrayList<LicenseDuration> licenseDurationsArrayList2  = new ArrayList<LicenseDuration>();
        for (LicenseDuration licenseDuration : licenseDurationsArrayL) {
            if (licenseDuration.getDuration().toLowerCase().contains(text.toLowerCase())) {
                licenseDurationsArrayList2.add(licenseDuration);
            }
        }
        adapterDriverDuration.filterList(licenseDurationsArrayList2);
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
        licenseDurationsArrayL =fillLicenseDurationArrayL(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterDriverDuration = new AdapterDriverDuration(getActivity(), licenseDurationsArrayL,this);
        recyclerView.setAdapter(adapterDriverDuration);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_drive_duration_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_drive_duration_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_drive_duration_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_drive_duration_ImageV);
        textViewQ = (TextView) view.findViewById(R.id.fragment_drive_duration_q_tv);
    }

    private void changeFont() {
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
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
    public void onLicenseDurationClicked(LicenseDuration licenseDuration) {
        saveInDB(licenseDuration);

        if (getProcessTypeFromIntent().equals("fill"))
        {
            CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
            completeInsuranceInfo.nextFragment("Register Date");
            completeInsuranceInfo.updateTitle("Register Date");
        }else{
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
        }
    }

    private void saveInDB(LicenseDuration licenseDuration) {
        getDataBaseInstance(getActivity()).updateDriverInfo(
                "Drive duration",getActivity().getResources().getString(R.string.drive_duration_process)
                ,licenseDuration.getDuration()
                ,licenseDuration.getDurationS(),"true");
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}