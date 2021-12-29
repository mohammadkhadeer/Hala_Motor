package com.cars.halamotor_obeidat.view.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;

import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanDes;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanPrice;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanTitle;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanTitleAndDesAndPrice;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveBurnedPriceInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveDesInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.savePriceInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveTitleInSP;


public class FragmentTitleDescriptionPrice extends Fragment {
    View view;
    EditText adTitleEdt,adDesEdt,priceEdt;
    ImageView cancelTitleIV,cancelDesIV;
    TextView questionTV,messageTV;
    Switch switchCompat;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_title_description_price, container, false);

        inti();
        actionListener();
        changeFontType();

        return view;
    }

    private void changeFontType() {
        adTitleEdt.setTypeface(Functions.changeFontGeneral(getActivity()));
        adDesEdt.setTypeface(Functions.changeFontGeneral(getActivity()));
        priceEdt.setTypeface(Functions.changeFontGeneral(getActivity()));
        questionTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        messageTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void actionListener() {
        listenerAdTitle();
        makeCancelTitleIVDeleteTextInTitaleEdt();
        listenerAddDes();
        makeCancelDesIVDeleteTextInDesEdt();
        listenerToPrice();
        listenerSwitch();
    }

    private void listenerToPrice() {
        priceEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    String price = String.valueOf(cs);
                    savePriceInSP(getActivity(),sharedPreferences,editor,price);
                }
                else {
                    cleanPrice(getActivity(),sharedPreferences,editor);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void listenerSwitch() {
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {

                if (isChecked) {
                    //if 'isChecked' is true do whatever you need...
                    messageTV.setVisibility(View.VISIBLE);
                    saveBurnedPriceInSP(getActivity(),sharedPreferences,editor,"1");
                }
                else {
                    messageTV.setVisibility(View.GONE);
                    saveBurnedPriceInSP(getActivity(),sharedPreferences,editor,"0");
                }
        }
    });
    }

    private void inti() {
        adTitleEdt = (EditText) view.findViewById(R.id.fragment_title_description_title_Edt);
        adDesEdt = (EditText) view.findViewById(R.id.fragment_title_description_description_Edt);
        priceEdt = (EditText) view.findViewById(R.id.fragment_title_description_price_Edt);
        cancelTitleIV = (ImageView) view.findViewById(R.id.fragment_title_description_title_IV);
        cancelDesIV = (ImageView) view.findViewById(R.id.fragment_title_description_description_IV);
        messageTV = (TextView) view.findViewById(R.id.fragment_title_description_message_TV);
        questionTV = (TextView) view.findViewById(R.id.fragment_title_description_q_TV);
        switchCompat = (Switch) view.findViewById(R.id.fragment_title_description_switch_TV);
    }

    private void makeCancelDesIVDeleteTextInDesEdt() {
        cancelDesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adDesEdt.setText("");
                cleanDes(getActivity(),sharedPreferences,editor);
            }
        });
    }

    private void makeCancelTitleIVDeleteTextInTitaleEdt() {
        cancelTitleIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanTitle(getActivity(),sharedPreferences,editor);
                adTitleEdt.setText("");
            }
        });
    }

    private void makeCancelDesIVVISIBLE() {
        cancelDesIV.setVisibility(View.VISIBLE);
    }

    private void makeCancelDesIVGONE() {
        cancelDesIV.setVisibility(View.GONE);
    }

    private void makeCancelTitleIVVISIBLE() {
        cancelTitleIV.setVisibility(View.VISIBLE);
    }

    private void makeCancelTitleIVGONE() {
        cancelTitleIV.setVisibility(View.GONE);
    }

    private void listenerAdTitle() {
        adTitleEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    String titleStr = String.valueOf(cs);
                    makeCancelTitleIVVISIBLE();
                    saveTitleInSP(getActivity(),sharedPreferences,editor,titleStr);
                }
                else {
                    makeCancelTitleIVGONE();
                    cleanTitle(getActivity(),sharedPreferences,editor);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    private void listenerAddDes() {
        adDesEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    String desStr = String.valueOf(cs);
                    makeCancelDesIVVISIBLE();
                    saveDesInSP(getActivity(),sharedPreferences,editor,desStr);
                }
                else {
                    makeCancelDesIVGONE();
                    cleanDes(getActivity(),sharedPreferences,editor);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cleanTitleAndDesAndPrice(getActivity(),sharedPreferences,editor);
    }
}
