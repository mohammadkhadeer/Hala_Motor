package com.cars.halamotor.view.fragments.carInformationFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.view.activity.CompleteInsuranceInfo;

import static com.cars.halamotor.dataBase.DataBaseInstance.getDataBaseInstance;

public class LicenceExpired extends Fragment {

    View view;
    TextView textViewQ,textViewYes,textViewNo;
    RelativeLayout relativeLayoutNo,relativeLayoutYes;

    public LicenceExpired(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_licence_expired, container, false);

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
                    completeInsuranceInfo.nextFragmentCar("Follow GCC");
                    completeInsuranceInfo.updateTitleCar("Follow GCC");
                    getDataBaseInstance(getActivity()).updateCarDetails(
                            "Licence expired", getActivity().getResources().getString(R.string.licence_expired_process)
                            , getActivity().getResources().getString(R.string.licence_expired)
                            , getActivity().getResources().getString(R.string.licence_expired_s)
                            , "true");
                }else {
                    getDataBaseInstance(getActivity()).updateCarDetails(
                            "Licence expired", getActivity().getResources().getString(R.string.licence_expired_process)
                            , getActivity().getResources().getString(R.string.licence_expired)
                            , getActivity().getResources().getString(R.string.licence_expired_s)
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
                    completeInsuranceInfo.nextFragmentCar("Follow GCC");
//            completeInsuranceInfo.updateTitle("License Nationality");
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
                "Licence expired", getActivity().getResources().getString(R.string.licence_expired_process)
                , getActivity().getResources().getString(R.string.licence_not_expired)
                , getActivity().getResources().getString(R.string.licence_not_expired_s)
                , "true");
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_licence_expired_q_tv);
        textViewNo = (TextView) view.findViewById(R.id.fragment_licence_expired_no_tv);
        textViewYes = (TextView) view.findViewById(R.id.fragment_licence_expired_yes_tv);

        relativeLayoutNo = (RelativeLayout) view.findViewById(R.id.fragment_licence_expired_no_rl);
        relativeLayoutYes = (RelativeLayout) view.findViewById(R.id.fragment_licence_expired_yes_rl);
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