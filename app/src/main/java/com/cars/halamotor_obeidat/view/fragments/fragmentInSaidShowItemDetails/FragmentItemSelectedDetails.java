package com.cars.halamotor_obeidat.view.fragments.fragmentInSaidShowItemDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.functions.Functions;
import com.cars.halamotor_obeidat.model.CCEMTModelDetails;
import com.cars.halamotor_obeidat.model.ItemAccAndJunk;
import com.cars.halamotor_obeidat.model.ItemPlates;
import com.cars.halamotor_obeidat.model.ItemWheelsRim;
import com.cars.halamotor_obeidat.view.adapters.AdapterCarOption;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.functions.FillText.getTextEngOrLocal;
import static com.cars.halamotor_obeidat.functions.Functions.getCarPlatesNumber;

public class FragmentItemSelectedDetails extends Fragment {

    public FragmentItemSelectedDetails(){}

    String categoryStr,itemIDStr,cat = "null"
            ,cityStr="null",neighborhoodStr="null",catStr="null";
    TextView text_title1,text_title_content1,text_title2,text_title_content2
             ,text_title3,text_title_content3,text_title4,text_title_content4
             ,text_title5,text_title_content5,text_title6,text_title_content6
             ,text_title7,text_title_content7,text_title8,text_title_content8
             ,text_title9,text_title_content9,text_title10,text_title_content10
             ,text_title11,text_title_content11,text_title12,text_title_content12
             ,cityTV,neighborhoodTV,categoryTV,cityTitleTV,neighborhoodTitleTV
             ,categoryTitleTV;
    LinearLayout itemDetailsLL,con1LL,con2LL;
    RecyclerView carOptionRV;
    ArrayList<String> carOptionsArrayList = new ArrayList<String>();
    AdapterCarOption adapterCarOption;


    CCEMTModelDetails ccemtModelDetails;
    ItemPlates carPlatesModel;
    ItemWheelsRim wheelsRimModel;
    ItemAccAndJunk accAndJunkObject;

    View view;

    @Override
    public void onAttach(Context context) {
        if (getArguments() != null) {
            categoryStr = getArguments().getString("category");
            itemIDStr = getArguments().getString("itemID");
            cat = getArguments().getString("cat");

            if (cat.equals("ccemt"))
                ccemtModelDetails = getArguments().getParcelable("object");

            if (cat.equals("cp"))
                carPlatesModel = getArguments().getParcelable("object");

            if (cat.equals("wr"))
                wheelsRimModel = getArguments().getParcelable("object");

            if (cat.equals("aaj"))
                accAndJunkObject = getArguments().getParcelable("object");
        }
        super.onAttach(context);
        detectObject();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_selected_details, container, false);
        inti();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeFont();
        fillInfo();
    }

    private void fillInfo() {
        fillGeneralInfo();
        fillItemInfo();
    }

    private void fillGeneralInfo() {
        cityTV.setText(cityStr);
        neighborhoodTV.setText(neighborhoodStr);
        categoryTV.setText(catStr);
    }

    private void fillItemInfo() {
        if (cat.equals("ccemt"))
        {
            fillCarDetails();
        }
        if (cat.equals("cp"))
        {
            fillCarPlates();
        }
        if (cat.equals("wr"))
        {
            fillWheelsSize();
        }
        if (cat.equals("aaj"))
        {
            itemDetailsLL.setVisibility(View.GONE);
        }
    }

    private void fillWheelsSize()  {
        text_title1.setText(getActivity().getResources().getString(R.string.wheels_inch_));
        text_title_content1.setText(wheelsRimModel.getWheelSize());
        con1LL.setVisibility(View.GONE);
        con2LL.setVisibility(View.GONE);
    }

    private void fillArrayList() {
        carOptionsArrayList = new ArrayList<>();
        carOptionsArrayList =ccemtModelDetails.getCcemtSmallObject().getOptions();
    }

    private void detectObject() {
        if (cat.equals("ccemt"))
            intiGeneralInfo(ccemtModelDetails.getAttributesArrayList().get(4).getTitle(),ccemtModelDetails.getCcemtSmallObject().getArea(),getTextEngOrLocal(getActivity(),ccemtModelDetails.getCategoryComp().getName_en(),ccemtModelDetails.getCategoryComp().getName_ar()));

        if (cat.equals("cp"))
            intiGeneralInfo(carPlatesModel.getCity(),carPlatesModel.getNeighborhood(),getActivity().getResources().getString(R.string.car_plates));

        if (cat.equals("wr"))
            intiGeneralInfo(wheelsRimModel.getCity(),wheelsRimModel.getNeighborhood(),getActivity().getResources().getString(R.string.wheels_rim));

        if (cat.equals("aaj"))
            intiGeneralInfo(accAndJunkObject.getCity(),accAndJunkObject.getNeighborhood(),accAndJunkObject.getCategoryName());

    }

    private void intiGeneralInfo(String itemCity, String itemNeighborhood, String type) {
        cityStr = itemCity;
        neighborhoodStr = itemNeighborhood;
        catStr = type;
    }

    private void fillCarPlates() {
        text_title1.setText(getActivity().getResources().getString(R.string.car_plates_city));
        text_title_content1.setText(carPlatesModel.getCarPlatesCity());
        text_title2.setText(getActivity().getResources().getString(R.string.car_plates_number));
        text_title_content2.setText(getCarPlatesNumber(carPlatesModel.getCarPlatesNumber()));
        con2LL.setVisibility(View.GONE);
    }

    private void fillCarDetails() {
        text_title_content1.setText(ccemtModelDetails.getAttributesArrayList().get(0).getTitle());
        text_title_content2.setText(ccemtModelDetails.getCcemtSmallObject().getCar_model());
        text_title_content3.setText(ccemtModelDetails.getAttributesArrayList().get(1).getTitle());
        text_title_content4.setText(ccemtModelDetails.getAttributesArrayList().get(2).getTitle());
        text_title_content5.setText(ccemtModelDetails.getAttributesArrayList().get(3).getTitle());
        text_title_content6.setText(ccemtModelDetails.getCcemtSmallObject().getCar_transmission_type());
        text_title_content7.setText(ccemtModelDetails.getCcemtSmallObject().getCar_fuel_type());
        fillCarOptions();
        text_title_content9.setText(ccemtModelDetails.getCcemtSmallObject().getCar_license_type());
        text_title_content10.setText(ccemtModelDetails.getCcemtSmallObject().getCar_insurance_type());
        text_title_content11.setText(ccemtModelDetails.getCcemtSmallObject().getCar_color());
        text_title_content12.setText(ccemtModelDetails.getCcemtSmallObject().getPayment_method());
    }

    private void fillCarOptions() {
        fillArrayList();
        if (carOptionsArrayList.size() == 0)
        {
            carOptionRV.setVisibility(View.GONE);
            text_title_content8.setVisibility(View.VISIBLE);
//            text_title8.setTextColor(getActivity().getResources().getColor(R.color.colorBlack5, null));
            text_title_content8.setText(getActivity().getResources().getString(R.string.no_options));
        }else{
//            text_title8.setTextColor(getActivity().getResources().getColor(R.color.colorBlack, null));
            text_title_content8.setVisibility(View.GONE);
            carOptionRV.setVisibility(View.VISIBLE);
            carOptionRV.setHasFixedSize(true);
            GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
            carOptionRV.setLayoutManager(mLayoutManager);
            adapterCarOption = new AdapterCarOption(getActivity(), carOptionsArrayList);
            carOptionRV.setAdapter(adapterCarOption);
        }
    }

    private void changeFont() {
        cityTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        neighborhoodTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        categoryTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        cityTitleTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        neighborhoodTitleTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        categoryTitleTV.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title1.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title2.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title3.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title4.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title5.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title6.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title7.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title8.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title9.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title10.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title11.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title12.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content1.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content2.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content3.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content4.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content5.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content6.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content7.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content8.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content9.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content10.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content11.setTypeface(Functions.changeFontGeneral(getActivity()));
        text_title_content12.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void inti() {
        itemDetailsLL = (LinearLayout) view.findViewById(R.id.itemDetailsLL);
        cityTitleTV = (TextView) view.findViewById(R.id.common_title1);
        neighborhoodTitleTV = (TextView) view.findViewById(R.id.common_title2);
        categoryTitleTV = (TextView) view.findViewById(R.id.common_title3);
        cityTV = (TextView) view.findViewById(R.id.text_common_content1);
        neighborhoodTV = (TextView) view.findViewById(R.id.text_common_content2);
        categoryTV = (TextView) view.findViewById(R.id.text_common_content3);
        text_title1 = (TextView) view.findViewById(R.id.text_title1);
        text_title2 = (TextView) view.findViewById(R.id.text_title2);
        text_title3 = (TextView) view.findViewById(R.id.text_title3);
        text_title4 = (TextView) view.findViewById(R.id.text_title4);
        text_title5 = (TextView) view.findViewById(R.id.text_title5);
        text_title6 = (TextView) view.findViewById(R.id.text_title6);
        text_title7 = (TextView) view.findViewById(R.id.text_title7);
        text_title8 = (TextView) view.findViewById(R.id.text_title8);
        text_title9 = (TextView) view.findViewById(R.id.text_title9);
        text_title10 = (TextView) view.findViewById(R.id.text_title10);
        text_title11 = (TextView) view.findViewById(R.id.text_title11);
        text_title12 = (TextView) view.findViewById(R.id.text_title12);
        text_title_content1 = (TextView) view.findViewById(R.id.text_title_content1);
        text_title_content2 = (TextView) view.findViewById(R.id.text_title_content2);
        text_title_content3 = (TextView) view.findViewById(R.id.text_title_content3);
        text_title_content4 = (TextView) view.findViewById(R.id.text_title_content4);
        text_title_content5 = (TextView) view.findViewById(R.id.text_title_content5);
        text_title_content6 = (TextView) view.findViewById(R.id.text_title_content6);
        text_title_content7 = (TextView) view.findViewById(R.id.text_title_content7);
        text_title_content8 = (TextView) view.findViewById(R.id.text_title_content8);
        carOptionRV = (RecyclerView) view.findViewById(R.id.car_options_RV);
        text_title_content9 = (TextView) view.findViewById(R.id.text_title_content9);
        text_title_content10 = (TextView) view.findViewById(R.id.text_title_content10);
        text_title_content11 = (TextView) view.findViewById(R.id.text_title_content11);
        text_title_content12 = (TextView) view.findViewById(R.id.text_title_content12);
        con1LL = (LinearLayout) view.findViewById(R.id.con1);
        con2LL = (LinearLayout) view.findViewById(R.id.con2);
    }

}
