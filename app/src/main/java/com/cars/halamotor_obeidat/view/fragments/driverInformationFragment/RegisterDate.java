package com.cars.halamotor_obeidat.view.fragments.driverInformationFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.Functions.getDAY;
import static com.cars.halamotor_obeidat.functions.Functions.getMONTH;
import static com.cars.halamotor_obeidat.functions.Functions.getYEAR;

public class RegisterDate extends Fragment {

    View view;
    TextView textViewQ,textViewNext;
    RelativeLayout relativeLayoutNext;
    DatePicker datePicker;
    private int yearInt, monthInt, dayInt,
            yearDPInt, monthDPInt, dayDPInt;
    public RegisterDate(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_date, container, false);

        inti();
        changeFont();
        intiDateToStartInDataP();
        actionListenerToNext();
        return view;
    }

    private void intiDateToStartInDataP() {
        yearInt = Integer.parseInt(getYEAR());
        monthInt = Integer.parseInt(getMONTH())-1;
        dayInt = Integer.parseInt(getDAY());
        datePicker.init(yearInt, monthInt, dayInt, null);
    }

    private String getProcessTypeFromIntent() {
        String processType = null;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            processType =bundle.getString("editOrFill");
        }
        return processType;
    }

    private void actionListenerToNext() {
        relativeLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInDB();
                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragment("Insurance pay");
                    completeInsuranceInfo.updateTitle("Insurance pay");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }

    private void saveInDB() {
        yearDPInt = datePicker.getYear();
        monthDPInt  = datePicker.getMonth() + 1;
        dayDPInt = datePicker.getDayOfMonth();

        String date = String.valueOf(yearDPInt)+"/"+String.valueOf(monthDPInt)+"/" +String.valueOf(dayDPInt);

        getDataBaseInstance(getActivity()).updateDriverInfo(
                "Register Date",getActivity().getResources().getString(R.string.register_date_process)
                ,date
                ,date,"true");
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_register_date_q_tv);
        textViewNext = (TextView) view.findViewById(R.id.fragment_register_date_next_tv);
        relativeLayoutNext = (RelativeLayout) view.findViewById(R.id.fragment_register_date_next_rl);
        datePicker = (DatePicker) view.findViewById(R.id.fragment_register_date_calendar_v);
    }

    private void changeFont() {
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNext.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}