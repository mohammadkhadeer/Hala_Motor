package com.cars.halamotor_obeidat.view.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.view.activity.Insurance;
import com.squareup.picasso.Picasso;

import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.numberOfCarProcessSelected;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.numberOfDriverProcessSelected;

public class InsuranceFragment extends Fragment {

    public InsuranceFragment(){}
    View view;
    TextView insuranceTV,completeProcessTV,textView,textView2,textViewCarCompletedProcess,textViewAllCarProcess
            ,textViewDriverCompletedProcess,textViewAllDriverProcess;

    ImageView imageView,imageViewInsurance,imageViewCar,imageViewDriver;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout,linearLayoutCarProcess,linearLayoutDriverProcess;
    int numberOfDriverCompletedProcess,numberOfCarCompletedProcess;
    private static final int REQUEST_DETAILS = 130;
    String carPic = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/pic%2F1car.png?alt=media&token=3e490ba4-8aa9-4fa7-b2ae-ac96e023b9c3";
    String driverPic = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/pic%2Fdriver_logo.jpg?alt=media&token=5ab66a0a-0ad6-4e0a-bf64-b81c739d139f";
    String insurancePic = "https://firebasestorage.googleapis.com/v0/b/hala-motor-8ff46.appspot.com/o/pic%2Finsurance_logo.png?alt=media&token=b00be8d9-b881-4c8a-95a0-8b3e74791c88";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insurance, container, false);

        init();
        changeFont();
        fillImages();
        actionListenerToLinerLayout();
        checkIfCompletedOrEmptyOrShow();
        return view;
    }

    private void fillImages() {
        Picasso.get()
                .load(insurancePic)
                .fit()
                .centerCrop()
                .into(imageViewInsurance);

        Picasso.get()
                .load(carPic)
                .fit()
                .centerCrop()
                .into(imageViewCar);

        Picasso.get()
                .load(driverPic)
                .fit()
                .centerCrop()
                .into(imageViewDriver);
    }

    private void checkIfCompletedOrEmptyOrShow() {
        numberOfDriverCompletedProcess = numberOfDriverProcessSelected(getActivity());
        numberOfCarCompletedProcess = numberOfCarProcessSelected(getActivity());
        if (numberOfDriverCompletedProcess ==10 && numberOfCarCompletedProcess==10)
        {
            showAllInfo();
            completeProcessTV.setText(getActivity().getResources().getString(R.string.show_result));
        }else{
            if (numberOfDriverCompletedProcess ==0 && numberOfCarCompletedProcess==0)
            {
                hideAllInfo();
            }else {
                if (numberOfDriverCompletedProcess >0 || numberOfCarCompletedProcess>0)
                {
                    showAllInfo();
                    textView.setText("(");
                    textView2.setText("(");
                    textViewCarCompletedProcess.setText(String.valueOf(numberOfCarCompletedProcess));
                    textViewAllCarProcess.setText(getActivity().getResources().getString(R.string.coute10)+")");
                    textViewDriverCompletedProcess.setText(String.valueOf(numberOfDriverCompletedProcess));
                    textViewAllDriverProcess.setText(getActivity().getResources().getString(R.string.coute10)+")");
                }
            }
        }
    }

    private void showAllInfo() {
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);
        completeProcessTV.setVisibility(View.VISIBLE);
        linearLayoutCarProcess.setVisibility(View.VISIBLE);
        linearLayoutDriverProcess.setVisibility(View.VISIBLE);
    }

    private void hideAllInfo() {
        textView.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        completeProcessTV.setVisibility(View.GONE);
        linearLayoutCarProcess.setVisibility(View.GONE);
        linearLayoutDriverProcess.setVisibility(View.GONE);
    }

    private void actionListenerToLinerLayout() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCompleteInsuranceDetails();
            }
        });
    }

    private void moveToCompleteInsuranceDetails() {
        Intent intent = new Intent(getActivity(), Insurance.class);
        InsuranceFragment.this.startActivityForResult(intent , REQUEST_DETAILS);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void changeFont() {
        insuranceTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        completeProcessTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        textView.setTypeface(Functions.changeFontGeneral(getActivity()));
        textView2.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewCarCompletedProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewAllCarProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewDriverCompletedProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewAllDriverProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void init() {
        insuranceTV = (TextView) view.findViewById(R.id.insurance_fragment_complete_process_main_tv);
        completeProcessTV = (TextView) view.findViewById(R.id.insurance_fragment_complete_process_tv);
        imageView = (ImageView) view.findViewById(R.id.insurance_fragment_complete_process_iv);
        imageViewInsurance = (ImageView) view.findViewById(R.id.insurance_logo);
        imageViewCar = (ImageView) view.findViewById(R.id.fragment_insurance_car_logo);
        imageViewDriver = (ImageView) view.findViewById(R.id.fragment_insurance_driver_logo);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.insurance_fragment_complete_process_rl);
        linearLayout = (LinearLayout) view.findViewById(R.id.insurance_fragment_complete_process_main_ll);
        linearLayoutCarProcess = (LinearLayout) view.findViewById(R.id.fragment_insurance_car_con);
        linearLayoutDriverProcess = (LinearLayout) view.findViewById(R.id.fragment_insurance_driver_con);
        textViewCarCompletedProcess = (TextView) view.findViewById(R.id.fragment_insurance_car_process_completed);
        textViewAllCarProcess = (TextView) view.findViewById(R.id.fragment_insurance_car_all_process);
        textViewDriverCompletedProcess = (TextView) view.findViewById(R.id.fragment_insurance_driver_process_completed);
        textViewAllDriverProcess = (TextView) view.findViewById(R.id.fragment_insurance_driver_all_process);
        textView = (TextView) view.findViewById(R.id.fragment_insurance_car_tv);
        textView2 = (TextView) view.findViewById(R.id.fragment_insurance_tv2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAILS && resultCode == Activity.RESULT_OK) {
            checkIfCompletedOrEmptyOrShow();
        }
    }
}
