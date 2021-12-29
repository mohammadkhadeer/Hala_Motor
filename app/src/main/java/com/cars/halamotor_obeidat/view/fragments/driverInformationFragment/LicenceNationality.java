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
import com.cars.halamotor_obeidat.model.License_Nationality;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.adapters.adapterDriverInfo.AdapterDriverLicenceNationality;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.fillLicenseNationalityArrayL;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.getDriverProcess;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.getLicenseNationality;

public class LicenceNationality extends Fragment implements AdapterDriverLicenceNationality.PassLicenceNationality {

    public ArrayList<License_Nationality> licenceNationalitiesArrayL  = new ArrayList<License_Nationality>();
    RecyclerView recyclerView;
    AdapterDriverLicenceNationality adapterDriverLicenceNationality;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    RelativeLayout relativeLayoutCompletedProcess,relativeLayoutEmptyProcess,relativeLayoutYes,relativeLayoutNo;
    TextView textViewYes,textViewNo,textViewQ;
    String nationality,nationalityS;

    public LicenceNationality(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_licence_nationality, container, false);

        inti();
        changeFont();
        checkIfSelectedNationalityOrNotSelectedYet();
        actionListenerToSearchEdt();
        actionListenerToRemoveTextInSearchEdt();

        return view;
    }

    private void changeFont() {
        textViewYes.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNo.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void checkIfSelectedNationalityOrNotSelectedYet() {
        if (getDriverProcess(getActivity(),"License Nationality").getProcessContent().getProcessContentS()
                .equals("empty") &&
                getDriverProcess(getActivity(),"Nationality").getProcessContent().getProcessContentS()
                        .equals("empty")
        )
        {
            //lazam ekon ma 7add jenseto we kman ma ekon 3baha mn kabel
            createNationalityList();
        }else{
            relativeLayoutCompletedProcess.setVisibility(View.VISIBLE);
            relativeLayoutEmptyProcess.setVisibility(View.GONE);
            if (!getDriverProcess(getActivity(),"License Nationality").getProcessContent().getProcessContentS()
                    .equals("empty"))
            {
                fillNationalityText2();
            }else{
                fillNationalityText();
            }
            actionListenerToYesOrNo();
        }
    }

    private void fillNationalityText2() {
        String text = getActivity().getResources().getString(R.string.lic_nationality_q);
        nationality = getDriverProcess(getActivity(),"License Nationality").getProcessContent().getProcessContent();
        nationalityS = getDriverProcess(getActivity(),"License Nationality").getProcessContent().getProcessContent();
        textViewQ.setText(text+" "+nationality+" ?");
    }

    private void createNationalityList() {
        relativeLayoutCompletedProcess.setVisibility(View.GONE);
        relativeLayoutEmptyProcess.setVisibility(View.VISIBLE);
        createRV();
    }

    private void actionListenerToYesOrNo() {
        relativeLayoutNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNationalityList();
            }

        });

        relativeLayoutYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataBaseInstance(getActivity()).updateDriverInfo(
                        "License Nationality",getActivity().getResources().getString(R.string.lic_nationality_process)
                        ,nationality
                        ,nationalityS
                        ,"true");

                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragment("Drive duration");
                    completeInsuranceInfo.updateTitle("Drive duration");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private void fillNationalityText() {
        String text = getActivity().getResources().getString(R.string.lic_nationality_q);
        //hay el7ala lama ekon kolo ffade etha m3abea mn kabel lazam yo5othha
        nationality = getLicenseNationality(getDriverProcess(getActivity(),"Nationality").getProcessContent().getProcessContent(),getActivity()).getLicenseNationality();
        nationalityS = getLicenseNationality(getDriverProcess(getActivity(),"Nationality").getProcessContent().getProcessContent(),getActivity()).getLicenseNationalityS();
        textViewQ.setText(text+" "+nationality+" ?");
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
        ArrayList<License_Nationality> licenceNationalitiesArrayList2  = new ArrayList<License_Nationality>();
        for (License_Nationality license_nationality : licenceNationalitiesArrayL) {
            if (license_nationality.getLicenseNationality().toLowerCase().contains(text.toLowerCase())) {
                licenceNationalitiesArrayList2.add(license_nationality);
            }
        }
        adapterDriverLicenceNationality.filterList(licenceNationalitiesArrayList2);
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
        licenceNationalitiesArrayL =fillLicenseNationalityArrayL(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterDriverLicenceNationality = new AdapterDriverLicenceNationality(getActivity(), licenceNationalitiesArrayL,this);
        recyclerView.setAdapter(adapterDriverLicenceNationality);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_licence_nationality_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_licence_nationality_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_licence_nationality_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_licence_nationality_ImageV);
        relativeLayoutCompletedProcess = (RelativeLayout) view.findViewById(R.id.fragment_licence_nationality_complete_case_case_rl);
        relativeLayoutEmptyProcess = (RelativeLayout) view.findViewById(R.id.fragment_licence_nationality_empty_case_rl);
        relativeLayoutYes = (RelativeLayout) view.findViewById(R.id.fragment_licence_nationality_yes_rl);
        relativeLayoutNo = (RelativeLayout) view.findViewById(R.id.fragment_licence_nationality_no_rl);

        textViewYes = (TextView) view.findViewById(R.id.fragment_licence_nationality_yes_tv);
        textViewNo = (TextView) view.findViewById(R.id.fragment_licence_nationality_no_tv);
        textViewQ = (TextView) view.findViewById(R.id.fragment_licence_nationality_tv);
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
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
    public void onLicenceNationalityClicked(License_Nationality license_nationality) {
        saveInDB(license_nationality);
        if (getProcessTypeFromIntent().equals("fill"))
        {
            CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
            completeInsuranceInfo.nextFragment("Drive duration");
            completeInsuranceInfo.updateTitle("Drive duration");
        }else{
            Intent resultIntent = new Intent();
            getActivity().setResult(Activity.RESULT_OK, resultIntent);
            getActivity().finish();
        }
    }

    private void saveInDB(License_Nationality license_nationality) {
        getDataBaseInstance(getActivity()).updateDriverInfo(
                "License Nationality",getActivity().getResources().getString(R.string.lic_nationality_process)
                ,license_nationality.getLicenseNationality()
                ,license_nationality.getLicenseNationalityS(),"true");
    }
}