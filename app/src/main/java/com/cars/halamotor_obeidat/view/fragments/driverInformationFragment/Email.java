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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.sharedPreferences.UserInfoSP.getUserEmailFromSP;

public class Email extends Fragment {

    View view;
    TextView textViewQ,textViewNext,textViewHint;
    RelativeLayout relativeLayoutNext;
    String email;
    EditText editText;
    public Email(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_email, container, false);

        inti();
        email = getUserEmailFromSP(getActivity());
        fillNameInEditText();
        changeFont();
        actionListener();
        return view;
    }

    private void fillNameInEditText() {
        if (email != null || email.equals(""))
        {
            textViewHint.setVisibility(View.GONE);
            editText.setText(email);
        }
    }

    private void actionListener() {
        actionListenerToEdt();
        actionListenerToNext();
    }

    private void actionListenerToEdt() {
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


    private void actionListenerToNext() {
        relativeLayoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty())
                {
                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.fill_email)
                            ,Toast.LENGTH_SHORT).show();
                }else{
                    saveInDB();
                    if (getProcessTypeFromIntent().equals("fill"))
                    {
                        CompleteInsuranceInfo completeInsuranceInfo = (CompleteInsuranceInfo) getActivity();
                        completeInsuranceInfo.nextFragment("Birth day");
                        completeInsuranceInfo.updateTitle("Birth day");
                    }else {
                        Intent resultIntent = new Intent();
                        getActivity().setResult(Activity.RESULT_OK, resultIntent);
                        getActivity().finish();
                    }
                }
            }
        });
    }

    private void saveInDB() {
        getDataBaseInstance(getActivity()).updateDriverInfo(
                "Email",getActivity().getResources().getString(R.string.email_process)
                ,editText.getText().toString()
                ,editText.getText().toString(),"true");
    }

    private String getProcessTypeFromIntent() {
        String processType = null;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            processType =bundle.getString("editOrFill");
        }
        return processType;
    }

    private void inti() {
        textViewQ = (TextView) view.findViewById(R.id.fragment_email_q_tv);
        textViewHint = (TextView) view.findViewById(R.id.fragment_email_edt_tv);
        textViewNext = (TextView) view.findViewById(R.id.fragment_email_next_tv);
        relativeLayoutNext = (RelativeLayout) view.findViewById(R.id.fragment_email_next_rl);
        editText = (EditText) view.findViewById(R.id.fragment_email_edt);

    }

    private void changeFont() {
        textViewQ.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewHint.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewNext.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    public void endDriverNationality(){
        Intent resultIntent = new Intent();
        getActivity().setResult(Activity.RESULT_OK, resultIntent);
        getActivity().finish();
    }
}