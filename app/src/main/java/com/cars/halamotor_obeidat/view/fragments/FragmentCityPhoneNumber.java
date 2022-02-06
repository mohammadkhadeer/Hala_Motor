package com.cars.halamotor_obeidat.view.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.selectAddress.SelectCityAndNeighborhood;

import static com.cars.halamotor_obeidat.functions.FillText.fillImageView;
import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanAddress;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.cleanPhoneNumber;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.saveAddressInSP;
import static com.cars.halamotor_obeidat.sharedPreferences.SharedPreferencesInApp.savePhoneNumberInSP;

public class FragmentCityPhoneNumber extends Fragment {
    CardView cityCV,phoneCV;
    TextView cityTV;
    EditText phoneNumberEdt;
    ImageView cityArrowIV,cancelPhoneIV;
    private static final int UPDATE_LOCATION = 5;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    View view;

    public FragmentCityPhoneNumber(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_city_phone_number, container, false);
        inti();
        fillImageView(getActivity(),cityArrowIV);
        actionListener();
        changeFontType();
        return view;
    }

    private void actionListener() {
        makeCancelPhoneNumIVDeleteTextInPhoneNumEdt();

        listenerAdPhone();
        selectCityActionListener();
    }

    private void selectCityActionListener() {
        cityCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition fade = new Fade();
                fade.excludeTarget(android.R.id.statusBarBackground, true);
                getActivity().getWindow().setExitTransition(fade);

                moveToSelectCity();
            }
        });
    }

    private void moveToSelectCity() {
        Bundle bundle = new Bundle();
        bundle.putString("whereComeFrom", "fragment");

        Intent intent = new Intent(getActivity(), SelectCityAndNeighborhood.class);
        intent.putExtras(bundle);
        startActivityForResult(intent , UPDATE_LOCATION);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_LOCATION && resultCode == Activity.RESULT_OK) {
            String city_en = data.getStringExtra("city_en");
            String city_ar = data.getStringExtra("city_ar");
            String area_id = data.getStringExtra("area_id");
            String area_name_en = data.getStringExtra("area_name_en");
            String area_name_ar = data.getStringExtra("area_name_ar");

            cityTV.setText(getTextEngOrLocal(getActivity(),city_en,city_ar) + " >> " + getTextEngOrLocal(getActivity(),area_name_en,area_name_ar));
            saveAddressInSP(getActivity(),sharedPreferences,editor
                    ,city_en,area_name_en
                    ,city_ar,area_name_ar,area_id);
        }
    }

    private void listenerAdPhone() {
        phoneNumberEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() != 0) {
                    String phoneNumberStr = String.valueOf(cs);
                    savePhoneNumberInSP(getActivity(),sharedPreferences,editor,phoneNumberStr);
                    makeCancelPhoneIVVISIBLE();
                }
                else {
                    makeCancelPhoneIVGONE();
                    cleanPhoneNumber(getActivity(),sharedPreferences,editor);
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

    private void makeCancelPhoneIVVISIBLE() {
        cancelPhoneIV.setVisibility(View.VISIBLE);
    }

    private void makeCancelPhoneIVGONE() {
        cancelPhoneIV.setVisibility(View.GONE);
    }

    private void makeCancelPhoneNumIVDeleteTextInPhoneNumEdt() {
        cancelPhoneIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumberEdt.setText("");
            }
        });
    }

    private void changeFontType() {
        cityTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        phoneNumberEdt.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void inti() {
        cityTV = (TextView) view.findViewById(R.id.fragment_city_phone_number_city_TV);
        phoneNumberEdt = (EditText) view.findViewById(R.id.fragment_city_phone_number_city_phone_number_Edt);

        cityArrowIV = (ImageView) view.findViewById(R.id.fragment_city_phone_number_city_IV);
        cancelPhoneIV = (ImageView) view.findViewById(R.id.fragment_city_phone_number_city_phone_number_TV);

        cityCV = (CardView) view.findViewById(R.id.fragment_city_phone_number_city);
        phoneCV = (CardView) view.findViewById(R.id.fragment_city_phone_number_PN);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cleanAddress(getActivity(),sharedPreferences,editor);
        cleanPhoneNumber(getActivity(),sharedPreferences,editor);
    }
}