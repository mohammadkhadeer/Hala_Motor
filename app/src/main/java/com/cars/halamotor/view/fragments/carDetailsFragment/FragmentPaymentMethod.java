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
import com.cars.halamotor.model.PaymentMethod;
import com.cars.halamotor.presnter.carDetails.CarFuelPresnter;
import com.cars.halamotor.presnter.carDetails.CarPaymentMethodPresnter;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterCarFuel;
import com.cars.halamotor.view.adapters.adapterInCarDetails.AdapterPaymentMethod;

import java.util.ArrayList;

import static com.cars.halamotor.dataBase.ReadSetting.getCarPaymentMethodFromDataBase;
import static com.cars.halamotor.functions.Functions.fillFuelArrayL;
import static com.cars.halamotor.functions.Functions.fillPaymentArrayL;
import static com.cars.halamotor.sharedPreferences.PersonalSP.getUserLanguage;

public class FragmentPaymentMethod extends Fragment implements AdapterPaymentMethod.PassPayment{

    public ArrayList<PaymentMethod> carPaymentArrayL  = new ArrayList<PaymentMethod>();
    RecyclerView recyclerView;
    AdapterPaymentMethod adapterPaymentMethod;
    EditText searchEdt;
    RelativeLayout cancelRL;
    ImageView cancelIV;
    View view;
    CarPaymentMethodPresnter carPaymentMethodPresnter;

    public FragmentPaymentMethod(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CarPaymentMethodPresnter) {
            carPaymentMethodPresnter = (CarPaymentMethodPresnter) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        carPaymentMethodPresnter = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_payment_method, container, false);

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
        ArrayList<PaymentMethod> carPaymentArrayList2  = new ArrayList<PaymentMethod>();
        for (PaymentMethod payment : carPaymentArrayL) {
            if (getUserLanguage(getActivity()).equals("en"))
            {
                if (payment.getSetting_content_name_en().toLowerCase().contains(text.toLowerCase())) {
                    carPaymentArrayList2.add(payment);
                }
            }else{
                if (payment.getSetting_content_name_ar().toLowerCase().contains(text.toLowerCase())) {
                    carPaymentArrayList2.add(payment);
                }
            }
        }
        adapterPaymentMethod.filterList(carPaymentArrayList2);
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
        carPaymentArrayL =getCarPaymentMethodFromDataBase(getActivity());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        adapterPaymentMethod = new AdapterPaymentMethod(getActivity(), carPaymentArrayL,this);
        recyclerView.setAdapter(adapterPaymentMethod);
    }

    private void inti() {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_car_payment_RV);
        searchEdt = (EditText) view.findViewById(R.id.fragment_car_payment_searchEdt);
        cancelRL = (RelativeLayout) view.findViewById(R.id.fragment_car_payment_RL);
        cancelIV = (ImageView) view.findViewById(R.id.fragment_car_payment_ImageV);
    }

    @Override
    public void onPaymentClicked(PaymentMethod paymentMethod) {
        carPaymentMethodPresnter.passPaymentMethod(paymentMethod);
    }
}