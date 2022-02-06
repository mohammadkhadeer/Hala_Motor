package com.cars.halamotor_obeidat.view.fragments.insuranceFargment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CarInformation;
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.activity.EditInsuranceInfoCarOrDriver;
import com.cars.halamotor_obeidat.view.adapters.adapterInsurance.AdapterCarProcess;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.createCarInfoTable;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.nextCarFragment;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.numberOfCarProcessSelected;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.resetAllCarInfoTable;

public class CarDetailsInsurance extends Fragment implements AdapterCarProcess.PassProcess{

    public CarDetailsInsurance(){}
    View view;
    TextView textViewCompleteCarDetails,textViewRestAll,textViewCompleteProcess,textViewNumberOfCompletedProcess;
    RecyclerView recyclerView;
    LinearLayout linearLayout,linearLayoutRestAllProcess;
    RecyclerView.LayoutManager layoutManager;
    RelativeLayout relativeLayoutRestAll,relativeLayoutCompleteProcess;
    ArrayList<com.cars.halamotor_obeidat.model.CarInformation> carAllProcessArrayL = new ArrayList<com.cars.halamotor_obeidat.model.CarInformation>();
    AdapterCarProcess adapterCarProcess;
    int numberOfCompletedProcess;
    private static final int REQUEST_DETAILS = 130;
    InsuranceResult insuranceResult = new InsuranceResult();
    FragmentCarDetailsCheck fragmentCarDetailsCheck;

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentCarDetailsCheck = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        numberOfCompletedProcess = numberOfCarProcessSelected(getActivity());
        if (context instanceof FragmentCarDetailsCheck) {
            fragmentCarDetailsCheck = (FragmentCarDetailsCheck) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_details_incurance, container, false);

        init();
        createCarDetailsProcessIfNotHaveIt();
        changeFont();
        createProcessRV();
        actionListenerToRL();
        checkIfNoProcessSelectedMakeRestAllGone();
        fillNumberOfCompletedProcess();
        checkCompleteProcess();
        //checkIfMustUpdateFragmentInsuranceResult();

        return view;
    }

    private void fillNumberOfCompletedProcess() {
        String text = "("+String.valueOf(numberOfCompletedProcess)+"/"+"10)";
        textViewNumberOfCompletedProcess.setText(text);
        if (numberOfCompletedProcess>0)
        {
            linearLayout.setVisibility(View.GONE);
        }else{
            linearLayout.setVisibility(View.VISIBLE);
        }
    }

    private void checkIfNoProcessSelectedMakeRestAllGone() {
        if (numberOfCompletedProcess ==0)
        {
            linearLayout.setVisibility(View.VISIBLE);
            linearLayoutRestAllProcess.setVisibility(View.GONE);
        }else{
            linearLayout.setVisibility(View.GONE);
            linearLayoutRestAllProcess.setVisibility(View.VISIBLE);
        }
    }

    private void createProcessRV() {
        carAllProcessArrayL = new ArrayList<>();
        //carAllProcessArrayL = getAllCarProcess(getActivity());

        layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapterCarProcess =new AdapterCarProcess(getActivity()
                ,carAllProcessArrayL,numberOfCompletedProcess,this);
        recyclerView.setAdapter(adapterCarProcess);
    }

    private void createCarDetailsProcessIfNotHaveIt() {
        //1.carMake 2.carModel 3.car year 4. carCondition 5.cylinderNumber 6.is your insurance policy expired
        //7.city 8.Dose the car modified or not follow Gulf Cooperation Council
        //9.Current policy is "Third party liability" only
        //10.Do your current policy include agency repair

        createCarInfoTable(getActivity());
//        Log.i("TAG","Number: "+String.valueOf(checkIfCarDetailsProcessCreated(getActivity())));
    }

    private void actionListenerToRL() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCompleteInsuranceDetails();
            }
        });
        relativeLayoutRestAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllCarInfoTable(getActivity());
                numberOfCompletedProcess = numberOfCarProcessSelected(getActivity());
                checkIfNoProcessSelectedMakeRestAllGone();
                createProcessRV();
                checkIfMustUpdateFragmentInsuranceResult();
            }
        });
        relativeLayoutCompleteProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCompleteInsuranceInfo();
            }
        });
    }

    private void moveToCompleteInsuranceInfo() {
        numberOfCompletedProcess = numberOfCarProcessSelected(getActivity());

        if (numberOfCompletedProcess!=10)
        {
            Bundle bundle = new Bundle();
            bundle.putString("partType","2");
            bundle.putString("nextFragment",nextCarFragment(numberOfCompletedProcess));
            bundle.putString("from","main");
            bundle.putString("completeOrInti","complete");
            bundle.putString("dOrC","car");

            Intent intent = new Intent(getActivity(), CompleteInsuranceInfo.class);
            intent.putExtras(bundle);
            com.cars.halamotor_obeidat.view.fragments.insuranceFargment.CarDetailsInsurance.this.startActivityForResult(intent , REQUEST_DETAILS);
            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }
    }

    private void moveToCompleteInsuranceDetails() {
        Bundle bundle = new Bundle();
        bundle.putString("partType","2");
        bundle.putString("from","main");
        bundle.putString("completeOrInti","inti");
        bundle.putString("dOrC","car");

        Intent intent = new Intent(getActivity(), CompleteInsuranceInfo.class);
        intent.putExtras(bundle);
        CarDetailsInsurance.this.startActivityForResult(intent , REQUEST_DETAILS);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void changeFont() {
        textViewCompleteCarDetails.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewRestAll.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewCompleteProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void init() {
        textViewCompleteCarDetails = (TextView) view.findViewById(R.id.car_details_insurance_complete_info_tv);
        linearLayout = (LinearLayout) view.findViewById(R.id.car_details_insurance_complete_info_ll);
        recyclerView = (RecyclerView) view.findViewById(R.id.car_details_insurance_complete_info_rv);
        linearLayoutRestAllProcess = (LinearLayout) view.findViewById(R.id.car_details_insurance_complete_rest_all_ll);
        textViewRestAll = (TextView) view.findViewById(R.id.car_details_insurance_complete_info_reset_tv);
        textViewCompleteProcess = (TextView) view.findViewById(R.id.car_details_insurance_complete_info_next_tv);
        textViewNumberOfCompletedProcess = (TextView) view.findViewById(R.id.car_details_insurance_complete_process_tv);
        relativeLayoutRestAll = (RelativeLayout) view.findViewById(R.id.car_details_insurance_complete_rest_all_rl);
        relativeLayoutCompleteProcess = (RelativeLayout) view.findViewById(R.id.car_details_insurance_complete_info_nextRL);
    }

    @Override
    public void onProcessClicked(CarInformation carInformation) {
        Bundle bundle = new Bundle();
        bundle.putString("processTypeS",carInformation.getCarProcess().getProcessS());
        bundle.putString("processType",carInformation.getCarProcess().getProcess());

//        if (!getCarProcess(getActivity(),carInformation.getCarProcess().getProcessS()).getProcessContent().getProcessContentS().equals("empty")
//            && !getCarProcess(getActivity(),carInformation.getCarProcess().getProcessS()).getCarProcess().getProcessS().equals("Car model"))
//        {
//            Intent intent = new Intent(getActivity(), EditInsuranceInfoCarOrDriver.class);
//            intent.putExtras(bundle);
//            com.cars.halamotor_obeidat.view.fragments.insuranceFargment.CarDetailsInsurance.this.startActivityForResult(intent , REQUEST_DETAILS);
//            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//        }else{
//            String carMakeProcess = getAllCarProcess(getActivity()).get(0).getProcessContent().getProcessContentS();
//            if (!carMakeProcess.equals("empty"))
//            {
//                Intent intent = new Intent(getActivity(), EditInsuranceInfoCarOrDriver.class);
//                intent.putExtras(bundle);
//                com.cars.halamotor_obeidat.view.fragments.insuranceFargment.CarDetailsInsurance.this.startActivityForResult(intent , REQUEST_DETAILS);
//                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
//            }
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAILS && resultCode == Activity.RESULT_OK) {
            numberOfCompletedProcess = numberOfCarProcessSelected(getActivity());
            checkIfNoProcessSelectedMakeRestAllGone();
            createProcessRV();
            fillNumberOfCompletedProcess();
            checkCompleteProcess();
            checkIfMustUpdateFragmentInsuranceResult();
        }
    }

    private void checkIfMustUpdateFragmentInsuranceResult() {
        //check if all process fill to get result
        numberOfCompletedProcess = numberOfCarProcessSelected(getActivity());
        if (numberOfCompletedProcess == 10)
        {
            fragmentCarDetailsCheck.onCarDetailsComplete(true);
        }else{
            fragmentCarDetailsCheck.onCarDetailsComplete(false);
        }
    }

    private void checkCompleteProcess() {
        if (numberOfCompletedProcess == 10)
        {
            relativeLayoutCompleteProcess.setAlpha((float) 0.5);
        }else{
            relativeLayoutCompleteProcess.setAlpha((float) 1.0);
        }
    }

    public interface FragmentCarDetailsCheck {
        void onCarDetailsComplete(Boolean status);
    }
}
