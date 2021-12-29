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
import com.cars.halamotor_obeidat.view.activity.CompleteInsuranceInfo;
import com.cars.halamotor_obeidat.view.activity.EditInsuranceInfoCarOrDriver;
import com.cars.halamotor_obeidat.view.adapters.adapterInsurance.AdapterDriverProcess;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.ReadFunction.getAllDriverProcess;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.createDriverInfoTable;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.getDriverProcess;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.nextFragment;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.numberOfDriverProcessSelected;
import static com.cars.halamotor_obeidat.functions.InsuranceFunctions.resetAllDriverInfoTable;

public class DriverInformation extends Fragment implements AdapterDriverProcess.PassProcess {

    public DriverInformation(){}
    View view;
    TextView textViewCompleteDriverInfo,textViewRestAll,textViewCompleteProcess,textViewNumberOfCompletedProcess;
    RecyclerView recyclerView;
    LinearLayout linearLayout,linearLayoutRestAllProcess;
    AdapterDriverProcess adapterDriverProcess;
    ArrayList<com.cars.halamotor_obeidat.model.DriverInformation> driverAllProcessArrayL = new ArrayList<com.cars.halamotor_obeidat.model.DriverInformation>();
    int numberOfCompletedProcess;
    private static final int REQUEST_DETAILS = 130;
    RecyclerView.LayoutManager layoutManager;
    RelativeLayout relativeLayoutRestAll,relativeLayoutCompleteProcess;
    InsuranceResult insuranceResult;
    FragmentDriverDetailsCheck fragmentDriverDetailsCheck;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        numberOfCompletedProcess = numberOfDriverProcessSelected(getActivity());
        if (context instanceof FragmentDriverDetailsCheck) {
            fragmentDriverDetailsCheck = (FragmentDriverDetailsCheck) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_driver_info, container, false);
        insuranceResult = new InsuranceResult();
        init();
        creteDriverInfoProcessIfNotHaveIt();
        changeFont();
        actionListenerToRL();
        createProcessRV();
        checkIfNoProcessSelectedMakeRestAllGone();
        fillNumberOfCompletedProcess();
        checkCompleteProcess();
        //checkIfNeedToUpdateInsuranceResult();

        return view;
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
        driverAllProcessArrayL = new ArrayList<>();
        driverAllProcessArrayL = getAllDriverProcess(getActivity());

        layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        adapterDriverProcess =new AdapterDriverProcess(getActivity()
                ,driverAllProcessArrayL,numberOfCompletedProcess,this);
        recyclerView.setAdapter(adapterDriverProcess);
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
                resetAllDriverInfoTable(getActivity());
                numberOfCompletedProcess = numberOfDriverProcessSelected(getActivity());
                checkIfNoProcessSelectedMakeRestAllGone();
                createProcessRV();
                checkIfNeedToUpdateInsuranceResult();
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
        numberOfCompletedProcess = numberOfDriverProcessSelected(getActivity());

        if (numberOfCompletedProcess!=10)
        {
            Bundle bundle = new Bundle();
            bundle.putString("partType","1");
            bundle.putString("nextFragment",nextFragment(numberOfCompletedProcess));
            bundle.putString("from","main");
            bundle.putString("completeOrInti","complete");
            bundle.putString("dOrC","driver");

            Intent intent = new Intent(getActivity(), CompleteInsuranceInfo.class);
            intent.putExtras(bundle);
            DriverInformation.this.startActivityForResult(intent , REQUEST_DETAILS);
            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }
    }

    private void moveToCompleteInsuranceDetails() {
        Bundle bundle = new Bundle();
        bundle.putString("partType","1");
        bundle.putString("from","main");
        bundle.putString("completeOrInti","inti");
        bundle.putString("dOrC","driver");

        Intent intent = new Intent(getActivity(), CompleteInsuranceInfo.class);
        intent.putExtras(bundle);
        DriverInformation.this.startActivityForResult(intent , REQUEST_DETAILS);
        getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
    }

    private void changeFont() {
        textViewCompleteDriverInfo.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewRestAll.setTypeface(Functions.changeFontGeneral(getActivity()));
        textViewCompleteProcess.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void init() {
        textViewCompleteDriverInfo = (TextView) view.findViewById(R.id.driver_info_complete_info_tv);
        linearLayout = (LinearLayout) view.findViewById(R.id.driver_info_complete_info_ll);
        recyclerView = (RecyclerView) view.findViewById(R.id.driver_info_complete_info_rv);
        linearLayoutRestAllProcess = (LinearLayout) view.findViewById(R.id.driver_info_complete_rest_all_ll);
        textViewRestAll = (TextView) view.findViewById(R.id.driver_info_complete_info_reset_tv);
        textViewCompleteProcess = (TextView) view.findViewById(R.id.driver_info_complete_info_next_tv);
        textViewNumberOfCompletedProcess = (TextView) view.findViewById(R.id.driver_info_complete_info_number_completed_process_tv);
        relativeLayoutRestAll = (RelativeLayout) view.findViewById(R.id.driver_info_complete_rest_all_rl);
        relativeLayoutCompleteProcess = (RelativeLayout) view.findViewById(R.id.driver_info_complete_info_nextRL);
    }

    private void creteDriverInfoProcessIfNotHaveIt() {
        //1.nationality 2.licence nationality 3.from when ur drive in uae ?
        //4.when you want to register your car ?
        //5.Did you pay your uae car insurance last 12 months
        //6.Did you have "no claims certificate" from your insurance company
        //7. full name 8. phone number 9. email 10 birthDay
        createDriverInfoTable(getActivity());
    }

    @Override
    public void onProcessClicked(com.cars.halamotor_obeidat.model.DriverInformation driverInformation) {
        Bundle bundle = new Bundle();
        bundle.putString("processTypeS",driverInformation.getDriverProcess().getProcessS());
        bundle.putString("processType",driverInformation.getDriverProcess().getProcess());

        if (!getDriverProcess(getActivity(),driverInformation.getDriverProcess().getProcessS()).getProcessContent().getProcessContentS().equals("empty"))
        {
            Intent intent = new Intent(getActivity(), EditInsuranceInfoCarOrDriver.class);
            intent.putExtras(bundle);
            DriverInformation.this.startActivityForResult(intent , REQUEST_DETAILS);
            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAILS && resultCode == Activity.RESULT_OK) {
            numberOfCompletedProcess = numberOfDriverProcessSelected(getActivity());
            checkIfNoProcessSelectedMakeRestAllGone();
            createProcessRV();
            fillNumberOfCompletedProcess();
            checkCompleteProcess();
            checkIfNeedToUpdateInsuranceResult();
        }
    }

    private void checkIfNeedToUpdateInsuranceResult() {
        //check if all process fill to get result
        numberOfCompletedProcess = numberOfDriverProcessSelected(getActivity());
        if (numberOfCompletedProcess == 10)
        {
            fragmentDriverDetailsCheck.onDriverComplete(true);
        }else{
            fragmentDriverDetailsCheck.onDriverComplete(false);
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

    public interface FragmentDriverDetailsCheck {
        void onDriverComplete(Boolean status);
    }

}
