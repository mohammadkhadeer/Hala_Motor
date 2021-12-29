package com.cars.halamotor_obeidat.view.fragments.carDetailsFragment;

import android.content.Context;
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
import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CarColor;
import com.cars.halamotor_obeidat.presnter.carDetails.CarColorPresnter;
import com.cars.halamotor_obeidat.view.adapters.adapterInCarDetails.AdapterCarColor;
import java.util.ArrayList;
import static com.cars.halamotor_obeidat.dataBase.ReadSetting.getCarColorFromDataBase;
import static com.cars.halamotor_obeidat.sharedPreferences.PersonalSP.getUserLanguage;


public class FragmentColor extends Fragment implements AdapterCarColor.PassColor{

    public ArrayList<CarColor> carColorsArrayL  = new ArrayList<CarColor>();
    RecyclerView recyclerView;
    AdapterCarColor adapterCarColor;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarColorPresnter carColorPresnter;

    public FragmentColor(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarColorPresnter) {
            carColorPresnter = (CarColorPresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carColorPresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_color, container, false);

        inti();
        createRV();
        actionListenerToSearchEdt();
        actionListenerToRemoveTextInSearchEdt();

        return view;
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
        ArrayList<CarColor> carColorsArrayList2  = new ArrayList<CarColor>();
        for (CarColor carColor : carColorsArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (carColor.getSetting_content_name_en().toLowerCase().contains(text.toLowerCase())) {
                    carColorsArrayList2.add(carColor);
                }
            }else{
                if (carColor.getSetting_content_name_ar().toLowerCase().contains(text.toLowerCase())) {
                    carColorsArrayList2.add(carColor);
                }
            }
        }
        adapterCarColor.filterList(carColorsArrayList2);
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
        carColorsArrayL =getCarColorFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarColor = new AdapterCarColor(getActivity(), carColorsArrayL,this);
        recyclerView.setAdapter(adapterCarColor);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_color_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_color_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_color_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_color_ImageV);
    }

    @Override
    public void onColorClicked(CarColor carColor) {
        carColorPresnter.passCarColor(carColor);
    }
}