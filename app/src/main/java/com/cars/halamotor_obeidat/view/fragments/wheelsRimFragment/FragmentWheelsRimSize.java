package com.cars.halamotor_obeidat.view.fragments.wheelsRimFragment;

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
import com.cars.halamotor_obeidat.presnter.WheelsComp;
import com.cars.halamotor_obeidat.view.adapters.AdapterWheelsInches;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.Functions.fillFuelArrayL;
import static com.cars.halamotor_obeidat.functions.Functions.fillWheelsInchesArrayL;

public class FragmentWheelsRimSize extends Fragment implements AdapterWheelsInches.PassSize{

    public ArrayList<String> wheelsInchesArrayL  = new ArrayList<String>();
    AdapterWheelsInches adapterWheelsInches;
    RecyclerView recyclerView;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    WheelsComp wheelsComp;
    View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WheelsComp) {
            wheelsComp = (WheelsComp) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        wheelsComp = null;
    }

    public FragmentWheelsRimSize(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wheels_size, container, false);

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
        ArrayList<String> wheelsInchesArrayL2  = new ArrayList<String>();
        for (String size : wheelsInchesArrayL2) {
            if (size.toLowerCase().contains(text.toLowerCase())) {
                wheelsInchesArrayL2.add(size);
            }
        }
        adapterWheelsInches.filterList(wheelsInchesArrayL2);
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
        wheelsInchesArrayL =fillWheelsInchesArrayL(wheelsInchesArrayL,getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterWheelsInches = new AdapterWheelsInches(getActivity(), wheelsInchesArrayL,this);
        recyclerView.setAdapter(adapterWheelsInches);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_wheels_size_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_wheels_size_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_wheels_size_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_wheels_size_ImageV);
    }

    @Override
    public void onFuelClicked(String wheelsSizeStr) {
        wheelsComp.onWheelsSize(wheelsSizeStr);
    }
}