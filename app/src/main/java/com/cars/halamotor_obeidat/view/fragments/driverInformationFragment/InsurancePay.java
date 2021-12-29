package com.cars.halamotor_obeidat.view.fragments.driverInformationFragment;

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

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;

public class InsurancePay extends Fragment {

    View view;
    TextView textViewQ1,textViewQ2,textViewNext,textViewYes,textViewNo,textViewHint;
    RelativeLayout relativeLayoutNext,relativeLayoutNo,relativeLayoutYes;
    LinearLayout linearLayout;
    EditText editText;
    public InsurancePay(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insurance_pay, container, false);

        inti();
        changeFont();
        actionListener();
        return view;
    }

    private void actionListener() {
        ationListenerToEdt();
        actionListenerToNo();
        actionListenerToYes();
        actionListenerToNext();
    }

    private void ationListenerToEdt() {
        editText.addTextChangedListener(new TextWatcher() {

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

            }

        });
    }

    private void makeCancelTitleIVGONE() {
        textViewHint.setVisibility(View.VISIBLE);
    }

    private void makeCancelTitleIVVISIBLE() {
        textViewHint.setVisibility(View.GONE);
    }

    private void actionListenerToYes() {
        relativeLayoutYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
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
                linearLayout.setVisibility(View.GONE);
                saveInDB();
                if (getProcessTypeFromIntent().equals("fill"))
                {
                    CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                    completeInsuranceInfo.nextFragment("Certificate claims");
                    completeInsuranceInfo.updateTitle("Certificate claims");
                }else{
                    Intent resultIntent = new Intent();
                    getActivity().setResult(Activity.RESULT_OK, resultIntent);
                    getActivity().finish();
                }
            }
        });
    }


    private void actionListenerToNext() {
        relativeLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.fill_how_many)
                            ,Toast.LENGTH_SHORT).show();
                }else{
                    if (getProcessTypeFromIntent().equals("fill"))
                    {
                        CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                        completeInsuranceInfo.nextFragment("Certificate claims");
                        completeInsuranceInfo.updateTitle("Certificate claims");

                        getDataBaseInstance(getActivity()).updateDriverInfo(
                                "Insurance pay", getActivity().getResources().getString(R.string.insurance_pay_process)
                                , editText.getText().toString()
                                , editText.getText().toString(), "true");
                    }else {
                        getDataBaseInstance(getActivity()).updateDriverInfo(
                                "Insurance pay", getActivity().getResources().getString(R.string.insurance_pay_process)
                                , editText.getText().toString()
                                , editText.getText().toString(), "true");

                        Intent resultIntent = new Intent();
                        getActivity().setResult(Activity.RESULT_OK, resultIntent);
                        getActivity().finish();
                    }
                }
                //saveInDB();
            }
        });
    }

    private void saveInDB() {
        String no = getActivity().getResources().getString(R.string.no);

        getDataBaseInstance(getActivity()).updateDriverInfo(
                "Insurance pay",getActivity().getResources().getString(R.string.insurance_pay_process)
                ,no
                ,"No","true");
    }

    private void inti() {
        textViewQ1 = (TextView) view.findViewById(R.id.fragment_insurance_pay_q1_tv);
        textViewNo = (TextView) view.findViewById(R.id.fragment_insurance_pay_no_tv);
        textViewYes = (TextView) view.findViewById(R.id.fragment_insurance_pay_yes_tv);
        textViewQ2 = (TextView) view.findViewById(R.id.fragment_insurance_pay_q2_tv);

        textViewHint = (TextView) view.findViewById(R.id.fragment_insurance_pay_edt_tv);

        textViewNext = (TextView) view.findViewById(R.id.fragment_insurance_pay_next_tv);
        relativeLayoutNext = (RelativeLayout) view.findViewById(R.id.fragment_insurance_pay_next_rl);
        relativeLayoutNo = (RelativeLayout) view.findViewById(R.id.fragment_insurance_pay_no_rl);
        relativeLayoutYes = (RelativeLayout) view.findViewById(R.id.fragment_insurance_pay_yes_rl);
        linearLayout = (LinearLayout) view.findViewById(R.id.fragment_insurance_pay_case_yes_ll);
        editText = (EditText) view.findViewById(R.id.fragment_insurance_pay_edt);

    }

    private void changeFont() {
        textViewQ1.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNo.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewYes.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewQ2.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewHint.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNext.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}