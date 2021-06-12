package com.cars.halamotor.view.fragments.carDetailsFragment;

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
import com.cars.halamotor.R;
import com.cars.halamotor.model.CarFuel;
import com.cars.halamotor.presnter.carDetails.CarFuelPresnter;
import com.cars.halamotor.presnter.carDetails.CarTransmissionPresnter;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarFuel;
import java.util.ArrayList;

import static com.cars.halamotor.dataBase.ReadSetting.getCarFuelFromDataBase;
import static com.cars.halamotor.functions.Functions.fillFuelArrayL;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class FragmentFuel extends Fragment implements AdapterCarFuel.PassFuel{

    public ArrayList<CarFuel> carFuelArrayL  = new ArrayList<CarFuel>();
    RecyclerView recyclerView;
    AdapterCarFuel adapterCarFuel;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarFuelPresnter carTransmissionPresnter;

    public FragmentFuel(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarFuelPresnter) {
            carTransmissionPresnter = (CarFuelPresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carTransmissionPresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_fuel, container, false);

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
        ArrayList<CarFuel> carFuelArrayList2  = new ArrayList<CarFuel>();
        for (CarFuel carFuel : carFuelArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (carFuel.getSetting_content_name_en().toLowerCase().contains(text.toLowerCase())) {
                    carFuelArrayList2.add(carFuel);
                }
            }else{
                if (carFuel.getSetting_content_name_ar().toLowerCase().contains(text.toLowerCase())) {
                    carFuelArrayList2.add(carFuel);
                }
            }

        }
        adapterCarFuel.filterList(carFuelArrayList2);
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
        carFuelArrayL =getCarFuelFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarFuel = new AdapterCarFuel(getActivity(), carFuelArrayL,this);
        recyclerView.setAdapter(adapterCarFuel);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_fuel_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_fuel_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_fuel_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_fuel_ImageV);
    }

    @Override
    public void onFuelClicked(CarFuel carFuel) {
        carTransmissionPresnter.passCarFuel(carFuel);
    }
}