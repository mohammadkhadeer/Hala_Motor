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

public class CarCondition extends Fragment {

    View view;
    TextView textViewQ,textViewNew,textViewUsed;
    RelativeLayout relativeLayoutUsed,relativeLayoutNew;

    public CarCondition(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_condition, container, false);

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
//        relativeLayoutNew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (getProcessTypeFromIntent().equals("fill"))
//                {
//                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
//                    completeInsuranceInfo.nextFragmentCar("Car cylinder");
//                    completeInsuranceInfo.updateTitleCar("Car cylinder");
//                    getDataBaseInstance(getActivity()).updateCarDetails(
//                            "Car condition", getActivity().getResources().getString(R.string.car_condition_process)
//                            , getActivity().getResources().getString(R.string.car_condition_1)
//                            , getActivity().getResources().getString(R.string.car_condition_1_s)
//                            , "true");
//                }else {
//                    getDataBaseInstance(getActivity()).updateCarDetails(
//                            "Car condition", getActivity().getResources().getString(R.string.licence_expired_process)
//                            , getActivity().getResources().getString(R.string.car_condition_1)
//                            , getActivity().getResources().getString(R.string.car_condition_1_s)
//                            , "true");
//
//                    Intent resultIntent = new Intent();
//                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
//                    getActivity().finish();
//                }
//            }
//        });
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
        relativeLayoutUsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInDB();
                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragmentCar("Car cylinder");
                    completeInsuranceInfo.updateTitleCar("Car cylinder");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private void saveInDB() {
//                getDataBaseInstance(getActivity()).updateCarDetails(
//                "Car condition", getActivity().getResources().getString(R.string.licence_expired_process)
//                , getActivity().getResources().getString(R.string.car_condition_2)
//                , getActivity().getResources().getString(R.string.car_condition_2_s)
//                , "true");
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_condition_q_tv);
        textViewUsed = (TextView) view.findViewById(R.id.fragment_condition_used_tv);
        textViewNew = (TextView) view.findViewById(R.id.fragment_condition_new_tv);

        relativeLayoutUsed = (RelativeLayout) view.findViewById(R.id.fragment_condition_used_rl);
        relativeLayoutNew = (RelativeLayout) view.findViewById(R.id.fragment_condition_new_rl);
    }

    private void changeFont() {
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewUsed.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNew.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}