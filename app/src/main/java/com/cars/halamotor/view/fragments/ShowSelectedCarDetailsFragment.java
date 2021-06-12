package com.cars.halamotor.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.model.CarDetailsModel;
import com.cars.halamotor.model.CarPlatesDetails;
import com.cars.halamotor.model.EditValueInCDM;
import com.cars.halamotor.model.ItemDetails;
import com.cars.halamotor.model.WheelsInfo;
import com.cars.halamotor.presnter.WheelsComp;
import com.cars.halamotor.view.activity.CarDetails;
import com.cars.halamotor.view.activity.CarPlates;
import com.cars.halamotor.view.activity.WheelsRim;

import java.util.ArrayList;

import static com.cars.halamotor.functions.Functions.splitString;

public class ShowSelectedCarDetailsFragment extends Fragment {

    TextView carMakeTV,modelTV,yearTV,conditionTV,kilometersTV
            ,transmissionTV,fuelTV,carOptionsTV,carLicenseTV,insuranceTV
            ,colorTV,paymentMethodTV,categoryTV,wheelsRimTV,carPlatesCityTV
            ,carPlatesNumTV,carPlatesSpiOrNotTV;
    RelativeLayout carMakeRL,modelRL,yearRL,conditionRL,kilometersRL
            ,transmissionRL,fuelRL,carOptionsRL,carLicenseRL,insuranceRL
            ,colorRL,paymentMethodRL,categoryRL,wheelsRimRL,carPlatesRL;

    LinearLayout containerCarDetailsLL;

    View view;

    private static final int REQUEST_WHEELS_RIM = 6;
    private static final int EDIT_CAR_DETAILS = 4;
    private static final int REQUEST_CAR_PLATES = 7;

    CarDetailsModel carDetailsModel= new CarDetailsModel();
    String categoryStr,carMakeStr,whatUserWantToChangeStr,inchSizeStr
            ,carPlatesNumStr,carPlatesCityStr,specialOrNotStr;
    String wheelsTypeStr,wheelsTypeSStr;
    OnDataPass dataPasser;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoryStr = getArguments().getString("category");
        }
        super.onAttach(context);
        dataPasser = (OnDataPass) context;

        if(categoryStr.equals(getResources().getString(R.string.wheels_rim)))
        {
            inchSizeStr = getArguments().getString("inchSize");
            wheelsTypeStr = getArguments().getString("type");
            wheelsTypeSStr = getArguments().getString("typeS");
        }else{
            if(categoryStr.equals(getResources().getString(R.string.car_plates)))
            {
                carPlatesCityStr = getArguments().getString("carPlatesCity");
                carPlatesNumStr = getArguments().getString("carPlatesNum");
                specialOrNotStr = getArguments().getString("specialOrNot");
            }else {
                Intent i = getActivity().getIntent();
                carDetailsModel = (CarDetailsModel) i.getParcelableExtra("carDetailsObject");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_details, container, false);

        inti();
        checkCategoryBeforeFill();

        return view;
    }

    private void checkCategoryBeforeFill() {
        if(categoryStr.equals(getResources().getString(R.string.wheels_rim)))
        {
            showWheelsRim();
            fillCategory();
            fillWheelsSize();
            hideCarDetails();
            hideCarPlates();
            actionListenerToWheels();
        }else{
            if(categoryStr.equals(getResources().getString(R.string.car_plates)))
            {
                fillCategory();
                fillCarPlates();
                showCarPlates();
                hideWheelsRim();
                actionListenerToCarPlates();
                hideCarDetails();
            }else {
                showCarDetails();
                hideWheelsRim();
                hideCarPlates();
                fillCategory();
                fillDetails();
                actionsLister();
            }
        }
    }

    private void actionListenerToCarPlates() {
        carPlatesRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("specialIntOrNot", specialOrNotStr);

                Intent intent = new Intent(getActivity(), CarPlates.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , REQUEST_CAR_PLATES);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void fillCarPlates() {
        String spi;
        if (specialOrNotStr.equals("special"))
            spi = getResources().getString(R.string.special);
        else
            spi = "";
        carPlatesCityTV.setText(carPlatesCityStr + " , ");
        carPlatesNumTV.setText(carPlatesNumStr);
        carPlatesSpiOrNotTV.setText(spi);
    }

//    private void fillCarPlates(String carPlatesCityStr,String carPlatesNumStr,String platesCharS,String specialOrNotStr) {
//        String spi;
//        if (specialOrNotStr.equals("special"))
//            spi = getResources().getString(R.string.special);
//        else
//            spi = "";
//        carPlatesCityTV.setText(platesCharS +"  "+carPlatesCityStr + " , ");
//        carPlatesNumTV.setText(carPlatesNumStr);
//        carPlatesSpiOrNotTV.setText(spi);
//    }

    private void showCarPlates() {
        carPlatesRL.setVisibility(View.VISIBLE);
    }

    private void hideCarPlates() {
        carPlatesRL.setVisibility(View.GONE);
    }

    private void hideWheelsRim() {
        wheelsRimRL.setVisibility(View.GONE);
    }

    private void showWheelsRim() {
        wheelsRimRL.setVisibility(View.VISIBLE);
    }

    private void actionListenerToWheels() {
        wheelsRimRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WheelsRim.class);
                startActivityForResult(intent , REQUEST_WHEELS_RIM);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        });
    }

    private void fillWheelsSize() {
        wheelsRimTV.setText(inchSizeStr+" "+wheelsTypeStr);
    }

    private void showCarDetails() {
        containerCarDetailsLL.setVisibility(View.VISIBLE);
    }

    private void hideCarDetails() {
        containerCarDetailsLL.setVisibility(View.GONE);
    }

    private void fillCategory() {
        categoryTV.setText(categoryStr);
    }

    private void actionsLister() {
        carMakeRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moveToCarDetalisSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.car_make),"make");
            }
        });
        modelRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carMakeStr = carDetailsModel.getCarMakeStr().getName_en();
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.model),"model");
            }
        });
        yearRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.year),"year");
            }
        });
        conditionRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.condition),"condition");
            }
        });
        kilometersRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.kilometers),"kilometers");
            }
        });
        transmissionRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.transmission),"transmission");
            }
        });
        fuelRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.fuel),"fuel");
            }
        });
        carOptionsRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.car_options),"options");
            }
        });
        carLicenseRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.car_license),"licensed");
            }
        });
        insuranceRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.insurance),"insurance");
            }
        });
        colorRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.color),"color");
            }
        });
        paymentMethodRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCarDetailsSpecificFragment("fromAShowSelected",getActivity().getResources().getString(R.string.payment_method),"payment");
            }
        });

    }

    private void moveToCarDetailsSpecificFragment(String fromAddItem,String fragmentType,String dictionaryStr) {
        whatUserWantToChangeStr = dictionaryStr;
        if (fragmentType.equals(getActivity().getResources().getString(R.string.model)) || fragmentType.equals(getActivity().getResources().getString(R.string.car_options)))
        {
            if (fragmentType.equals(getActivity().getResources().getString(R.string.model)))
            {
                Bundle bundle= new Bundle();
                bundle.putString("whereComeFrom",fromAddItem);
                bundle.putString("specificFragmentType",fragmentType);
                bundle.putString("ifPressModelPassCarMake",carMakeStr);
                Intent intent = new Intent(getActivity(), CarDetails.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , EDIT_CAR_DETAILS);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
            if (fragmentType.equals(getActivity().getResources().getString(R.string.car_options)))
            {
                Bundle bundle= new Bundle();
                bundle.putString("whereComeFrom",fromAddItem);
                bundle.putString("specificFragmentType",fragmentType);
                bundle.putString("options",carDetailsModel.getCarOptionsStr());
                Intent intent = new Intent(getActivity(), CarDetails.class);
                intent.putExtras(bundle);
                startActivityForResult(intent , EDIT_CAR_DETAILS);
                getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
            }
        }else{
            Bundle bundle= new Bundle();
            bundle.putString("whereComeFrom",fromAddItem);
            bundle.putString("specificFragmentType",fragmentType);
            Intent intent = new Intent(getActivity(), CarDetails.class);
            intent.putExtras(bundle);
            this.startActivityForResult(intent , EDIT_CAR_DETAILS);
            getActivity().overridePendingTransition(R.anim.right_to_left, R.anim.no_animation);
        }
    }

    private void fillDetails() {
        carMakeTV.setText(carDetailsModel.getCarMakeStr().getName_en());
        modelTV.setText(carDetailsModel.getModelStr().getBrand_name_en());
        yearTV.setText(carDetailsModel.getYearStr());
        conditionTV.setText(carDetailsModel.getConditionStr().getSetting_content_name_en());
        kilometersTV.setText(carDetailsModel.getKilometersStr());
        transmissionTV.setText(carDetailsModel.getTransmissionStr());
        fuelTV.setText(carDetailsModel.getFuelStr().getSetting_content_name_en());
        carOptionsTV.setText(carDetailsModel.getCarOptionsStr());
        carLicenseTV.setText(carDetailsModel.getLicenseStr().getSetting_content_name_en());
        insuranceTV.setText(carDetailsModel.getInsurance().getSetting_content_name_en());
        colorTV.setText(carDetailsModel.getCarColorStr());
        paymentMethodTV.setText(carDetailsModel.getPaymentMethod().getSetting_content_name_en());
    }

    private void inti() {
        categoryTV = (TextView) view.findViewById(R.id.car_details_fragment_category_TV);
        carMakeTV = (TextView) view.findViewById(R.id.car_details_fragment_car_make_TV);
        modelTV = (TextView) view.findViewById(R.id.car_details_fragment_model_TV);
        yearTV = (TextView) view.findViewById(R.id.car_details_fragment_year_TV);
        conditionTV = (TextView) view.findViewById(R.id.car_details_fragment_condition_TV);
        kilometersTV = (TextView) view.findViewById(R.id.car_details_fragment_kilometers_TV);
        transmissionTV = (TextView) view.findViewById(R.id.car_details_fragment_transmission_TV);
        fuelTV = (TextView) view.findViewById(R.id.car_details_fragment_fuel_TV);
        carOptionsTV = (TextView) view.findViewById(R.id.car_details_fragment_car_options_TV);
        carLicenseTV = (TextView) view.findViewById(R.id.car_details_fragment_car_license_TV);
        insuranceTV = (TextView) view.findViewById(R.id.car_details_fragment_insurance_TV);
        colorTV = (TextView) view.findViewById(R.id.car_details_fragment_color_TV);
        paymentMethodTV = (TextView) view.findViewById(R.id.car_details_fragment_payment_method_TV);
        wheelsRimTV = (TextView) view.findViewById(R.id.car_details_fragment_wheels_TV);
        carPlatesCityTV = (TextView) view.findViewById(R.id.car_details_fragment_car_plates_city_TV);
        carPlatesNumTV = (TextView) view.findViewById(R.id.car_details_fragment_car_plates_number_TV);
        carPlatesSpiOrNotTV = (TextView) view.findViewById(R.id.car_details_fragment_car_plates_spi_TV);

        categoryRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_category_RL);
        carMakeRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_car_make_RL);
        modelRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_model_RL);
        yearRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_year_RL);
        conditionRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_condition_RL);
        kilometersRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_kilometers_RL);
        transmissionRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_transmission_RL);
        fuelRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_fuel_RL);
        carOptionsRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_car_options_RL);
        carLicenseRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_car_license_RL);
        insuranceRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_insurance_RL);
        colorRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_color_RL);
        paymentMethodRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_payment_method_RL);
        wheelsRimRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_wheels_RL);
        carPlatesRL = (RelativeLayout) view.findViewById(R.id.car_details_fragment_car_plates_RL);

        containerCarDetailsLL = (LinearLayout) view.findViewById(R.id.car_details_fragment_container_cd_LL);
    }
    ////error
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_CAR_DETAILS) {
            if (null!=data)
            {
                String whatUserWantToChangeValue2Str = whatUserWantToChangeStr+"S";
                String value = data.getStringExtra(whatUserWantToChangeStr);
                String value2 = data.getStringExtra(whatUserWantToChangeValue2Str);
                String makeStr = data.getStringExtra("make");
                EditValueInCDM dataEdit = new EditValueInCDM(whatUserWantToChangeStr,value);
                EditValueInCDM dataEdit2 = new EditValueInCDM(whatUserWantToChangeStr,value);
                dataPasser.onDataPass(dataEdit,dataEdit2);
                checkWhereAChangeHappenedAndChangeIt(value,makeStr);
            }
        }
        if (requestCode == REQUEST_WHEELS_RIM) {
            if (data != null && !data.equals("")) {
                inchSizeStr = data.getExtras().getString("inchSize");
                wheelsTypeStr = data.getExtras().getString("type");
                wheelsTypeSStr = data.getExtras().getString("typeS");

                // unknown error handel it via this timer
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        WheelsInfo wheelsInfo= new WheelsInfo(inchSizeStr,wheelsTypeStr,wheelsTypeSStr);
                        dataPasser.onWheelsDataChange(wheelsInfo);
                        fillWheelsSize();
                    }
                }, 100);
            }
        }
        if (requestCode == REQUEST_CAR_PLATES) {
            if (data != null && !data.equals("")) {
                carPlatesCityStr = data.getExtras().getString("carPlatesCity");
                carPlatesNumStr = data.getExtras().getString("carPlatesNum");
                specialOrNotStr = data.getExtras().getString("specialOrNot");

                // unknown error handel it via this timer
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //pass carPlates details after edit to additem activity
                        int specialOrNotInt = 0;
                        if (specialOrNotStr.equals("special"))
                            specialOrNotInt = 1;

                        CarPlatesDetails carPlatesDetails =new CarPlatesDetails(
                                carPlatesCityStr
                                ,carPlatesNumStr
                                ,specialOrNotInt
                        );
                        dataPasser.onDataPassCarPlates(carPlatesDetails);
                        fillCarPlates();
                    }
                }, 100);

            }
        }
    }

    private void checkWhereAChangeHappenedAndChangeIt(String value,String makeStr) {
        if (whatUserWantToChangeStr.equals("make"))
        {
            carMakeTV.setText(makeStr);
            modelTV.setText(value);
        }

        if (whatUserWantToChangeStr.equals("model"))
        {
            modelTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("year"))
        {
            yearTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("condition"))
        {
            conditionTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("kilometers"))
        {
            kilometersTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("transmission"))
        {
            transmissionTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("fuel"))
        {
            fuelTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("options"))
        {
            carOptionsTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("licensed"))
        {
            carLicenseTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("insurance"))
        {
            insuranceTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("color"))
        {
            colorTV.setText(value);
        }
        if (whatUserWantToChangeStr.equals("payment"))
        {
            paymentMethodTV.setText(value);
        }
    }

    public interface OnDataPass {
        public void onDataPass(EditValueInCDM data,EditValueInCDM data2);
        public void onDataPassCarPlates(CarPlatesDetails carPlatesDetails);
        public void onWheelsDataChange(WheelsInfo wheelsInfo);
    }

}
