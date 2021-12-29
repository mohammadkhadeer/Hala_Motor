package com.cars.halamotor_obeidat.view.fragments.carInformationFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class InsurancePolicy extends Fragment {

    View view;
    TextView textViewQ,textViewYes,textViewNo;
    RelativeLayout relativeLayoutNo,relativeLayoutYes;

    public InsurancePolicy(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insurance_ploicy, container, false);

        inti();
        changeFont();
        actionListener();
        return view;
    }

    private void actionListener() {
        actionListenerToNo();
        actionListenerToYes();
    }

    private void actionListenerToYes() {
        relativeLayoutYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragmentCar("Agency repair");
                    completeInsuranceInfo.updateTitleCar("Agency repair");
                    getDataBaseInstance(getActivity()).updateCarDetails(
                            "Insurance policy", getActivity().getResources().getString(R.string.insurance_policy_process)
                            , getActivity().getResources().getString(R.string.insurance_policy_yes)
                            , getActivity().getResources().getString(R.string.insurance_policy_yes_s)
                            , "true");
                }else {
                    getDataBaseInstance(getActivity()).updateCarDetails(
                            "Insurance policy", getActivity().getResources().getString(R.string.insurance_policy_process)
                            , getActivity().getResources().getString(R.string.insurance_policy_yes)
                            , getActivity().getResources().getString(R.string.insurance_policy_yes_s)
                            , "true");

                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private String getProcessTypeFromIntent() {
        String processType = null;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            processType =bundle.getString("editOrFill");
        }
        return processType;
    }

    private void actionListenerToNo() {
        relativeLayoutNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInDB();
                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragmentCar("Agency repair");
                    completeInsuranceInfo.updateTitleCar("Agency repair");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private void saveInDB() {
        getDataBaseInstance(getActivity()).updateCarDetails(
                "Insurance policy", getActivity().getResources().getString(R.string.insurance_policy_process)
                , getActivity().getResources().getString(R.string.insurance_policy_no)
                , getActivity().getResources().getString(R.string.insurance_policy_no_s)
                , "true");
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_insurance_policy_q_tv);
        textViewNo = (TextView) view.findViewById(R.id.fragment_insurance_policy_no_tv);
        textViewYes = (TextView) view.findViewById(R.id.fragment_insurance_policy_yes_tv);

        relativeLayoutNo = (RelativeLayout) view.findViewById(R.id.fragment_insurance_policy_no_rl);
        relativeLayoutYes = (RelativeLayout) view.findViewById(R.id.fragment_insurance_policy_yes_rl);
    }

    private void changeFont() {
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNo.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewYes.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}