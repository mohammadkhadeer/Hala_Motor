package com.cars.halamotor.view.fragments.carDetailsFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cars.halamotor.R;
import com.cars.halamotor.model.CarOption;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarOptions;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cars.halamotor.functions.Functions.fillOptionArrayL;
import static com.cars.halamotor.functions.Functions.fillOptionsArrayL;

public class FragmentOptions extends Fragment implements AdapterCarOptions.PassOptions{

    public ArrayList<CarOption> carOptionsArrayL  = new ArrayList<CarOption>();
    public ArrayList<String> carOptionsSavedArrayL  = new ArrayList<String>();
    RecyclerView recyclerView;
    AdapterCarOptions adapterCarOptions;
    EditText searchEdt;
    RelativeLayout cancelRL,resetRL,nextRL;
    ImageView cancelIV;
    View view;
    private static String optionsListStr;

    public FragmentOptions(){}

    @Override
    public void onAttach(Context context) {
        Log.i("TAG","onAttach");
        if (getArguments() != null) {
            optionsListStr = getArguments().getString("options");
            Log.i("TAG",optionsListStr);
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_options, container, false);

        inti();
        createRV();
        actionListenerToSearchEdt();
        actionListenerToRemoveTextInSearchEdt();
        actionListenerToResetAndNextButton();
        return view;
    }

    private void actionListenerToResetAndNextButton() {
        resetRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSelectedOptionEmpty();
            }
        });

        nextRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarDetails carDetails = (CarDetails) getActivity();
                String options = "";
                for (int i = 0; i < carOptionsArrayL.size(); i++) {
                    if (carOptionsArrayL.get(i).getIsSelected() == 1)
                    {
                        options = options + carOptionsArrayL.get(i).getCarOptionStr() + " | ";
                    }
                }
                optionsListStr = options;
                carDetails.getCarOptionsStrFromFragmentOptionsAndMoveToFragmentOptions(options);

            }
        });
    }

    private void makeSelectedOptionEmpty() {
        for (int i = 0; i < carOptionsArrayL.size(); i++) {
            carOptionsArrayL.get(i).setIsSelected(0);
            adapterCarOptions.notifyItemChanged(i);
        }
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
        ArrayList<CarOption> carOptionsArrayList2  = new ArrayList<CarOption>();
        for (CarOption carOption : carOptionsArrayL) {
            if (carOption.getCarOptionStr().toLowerCase().contains(text.toLowerCase())) {
                carOptionsArrayList2.add(carOption);
            }
        }
        adapterCarOptions.filterList(carOptionsArrayList2);
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
        carOptionsArrayL =fillOptionsArrayL(carOptionsArrayL,getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterCarOptions = new AdapterCarOptions(getActivity(), carOptionsArrayL,this);
        recyclerView.setAdapter(adapterCarOptions);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_options_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_options_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_options_RL);
        resetRL = (RelativeLayout) view.findViewById(R.id.fragment_car_options_resetRL);
        nextRL = (RelativeLayout) view.findViewById(R.id.fragment_car_options_nextRL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_options_ImageV);
    }

    @Override
    public void onOptionClicked(CarOption carOption,int position) {
        carOptionsArrayL.get(position).setIsSelected(carOption.getIsSelected());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        carOptionsSavedArrayL = new ArrayList<String>();
        reSelectedOptions();
    }

    private void reSelectedOptions() {
        if (optionsListStr != null)
        {
            carOptionsSavedArrayL=fillOptionArrayL(carOptionsSavedArrayL,optionsListStr);
            for (int i=0;i<carOptionsSavedArrayL.size();i++)
            {
                for (int j=0;j<carOptionsArrayL.size();j++)
                {
                    if (carOptionsSavedArrayL.get(i).replace(" ", "").equals(carOptionsArrayL.get(j).getCarOptionStr().replace(" ", "")))
                    {
                        carOptionsArrayL.get(j).setIsSelected(1);
                        adapterCarOptions.notifyItemChanged(j);
                    }
                }

            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        optionsListStr = null;
    }
}