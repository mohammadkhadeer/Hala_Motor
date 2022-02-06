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

public class ModifiedFragment extends Fragment {

    View view;
    TextView textViewQ,textViewYes,textViewNo;
    RelativeLayout relativeLayoutNo,relativeLayoutYes;

    public ModifiedFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_modified, container, false);

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
//                if (getProcessTypeFromIntent().equals("fill"))
//                {
//                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
//                    completeInsuranceInfo.nextFragmentCar("Insurance policy");
//                    completeInsuranceInfo.updateTitleCar("Insurance policy");
//                    getDataBaseInstance(getActivity()).updateCarDetails(
//                            "Follow GCC", getActivity().getResources().getString(R.string.car_modified_process)
//                            , getActivity().getResources().getString(R.string.car_modified_1)
//                            , getActivity().getResources().getString(R.string.car_modified_1_s)
//                            , "true");
//                }else {
//                    getDataBaseInstance(getActivity()).updateCarDetails(
//                            "Follow GCC", getActivity().getResources().getString(R.string.car_modified_process)
//                            , getActivity().getResources().getString(R.string.car_modified_1)
//                            , getActivity().getResources().getString(R.string.car_modified_1_s)
//                            , "true");
//
//                    Intent resultIntent = new Intent();
//                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
//                    getActivity().finish();
//                }
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
                    completeInsuranceInfo.nextFragmentCar("Insurance policy");
                    completeInsuranceInfo.updateTitleCar("Insurance policy");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private void saveInDB() {
//        getDataBaseInstance(getActivity()).updateCarDetails(
//                "Follow GCC", getActivity().getResources().getString(R.string.car_modified_process)
//                , getActivity().getResources().getString(R.string.car_modified_2)
//                , getActivity().getResources().getString(R.string.car_modified_2_s)
//                , "true");
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_modified_q_tv);
        textViewNo = (TextView) view.findViewById(R.id.fragment_modified_no_tv);
        textViewYes = (TextView) view.findViewById(R.id.fragment_modified_yes_tv);

        relativeLayoutNo = (RelativeLayout) view.findViewById(R.id.fragment_modified_no_rl);
        relativeLayoutYes = (RelativeLayout) view.findViewById(R.id.fragment_modified_yes_rl);
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