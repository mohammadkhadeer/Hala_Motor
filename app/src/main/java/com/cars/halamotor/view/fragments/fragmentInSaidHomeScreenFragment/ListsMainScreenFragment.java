package com.cars.halamotor.view.fragments.fragmentInSaidHomeScreenFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cars.halamotor.R;
import com.cars.halamotor.functions.Functions;
import com.cars.halamotor.model.AccAndJunkFirstCase;
import com.cars.halamotor.model.CCEMTFirestCase;
import com.cars.halamotor.model.CarPlatesFirstCase;
import com.cars.halamotor.model.SuggestedItem;
import com.cars.halamotor.model.WheelsRimFirstCase;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterAccAndJunkFirstCase;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterCarPlatesFirstCase;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterSuggestedItem;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterWheelsRim;
import com.cars.halamotor.view.adapters.adapterMainScreen.AdapterCCEMTAllCases;
import com.cars.halamotor.view.fragments.InsuranceFragment;

import java.util.ArrayList;

import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstAccAndJunk;
import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstItemCCEMTFirstCase;
import static com.cars.halamotor.algorithms.ArrangingLists.setEditTextFirstItemWheelsRim;
import static com.cars.halamotor.dataBase.ReadFunction.getAccAndJunkDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getCarForSaleDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getCarPlatesDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getSuggestedItemFromDatabase;
import static com.cars.halamotor.dataBase.ReadFunction.getWheelsRimDatabase;

public class ListsMainScreenFragment extends Fragment {

    public ListsMainScreenFragment(){}
    View view;
    AdapterSuggestedItem adapterSuggestedItem;
    private static final int REQUEST_SHOW_ITEM_SELECTED_DETAILS = 100;

    TextView suggestedTV,suggestedSeeAllTV,carForSaleTV,carForSaleSeeAllTV
                ,carForRentTV,carForRentSeeAllTV,exchangeCarTV,exchangeCarSeeAllTV
                ,motorcycleTV,motorcycleSeeAllTV,trucksTV,trucksSeeAllTV
                ,wheelsRimTV,wheelsRimSeeAllTV,carPlatesTV,carPlatesSeeAllTV
                ,accessoriesTV,accessoriesSeeAllTV,junkCarTV,junkCarSeeAllTV;
    RelativeLayout suggestedSeeAllRL,carForSaleSeeAllRL,carForRentSeeAllRL
                ,exchangeCarSeeAllRL,motorcycleSeeAllRL,trucksSeeAllRL
                ,wheelsRimSeeAllRL,carPlatesSeeAllRL,accessoriesSeeAllRL
                ,junkCarSeeAllRL;

    ArrayList<SuggestedItem> suggestedItemsArrayL = new ArrayList<SuggestedItem>();
    ArrayList<CCEMTFirestCase> carForSaleArrayL = new ArrayList<CCEMTFirestCase>();
    ArrayList<CCEMTFirestCase> carForRentArrayL = new ArrayList<CCEMTFirestCase>();
    ArrayList<CCEMTFirestCase> carExchangeArrayL = new ArrayList<CCEMTFirestCase>();
    ArrayList<CCEMTFirestCase> motorcycleArrayL = new ArrayList<CCEMTFirestCase>();
    ArrayList<CCEMTFirestCase> trucksArrayL = new ArrayList<CCEMTFirestCase>();
    ArrayList<WheelsRimFirstCase> wheelsRimArrayL = new ArrayList<WheelsRimFirstCase>();
    ArrayList<CarPlatesFirstCase> carPlatesArrayL = new ArrayList<CarPlatesFirstCase>();
    ArrayList<AccAndJunkFirstCase> accessoriesArrayL = new ArrayList<AccAndJunkFirstCase>();
    ArrayList<AccAndJunkFirstCase> junkArrayL = new ArrayList<AccAndJunkFirstCase>();

    AdapterCCEMTAllCases adapterCarForSale,getAdapterCarRentSale,adapterCarExchange,adapterCarMotorcycle
            , adapterTrucks;

    AdapterWheelsRim adapterWheelsRim;
    AdapterCarPlatesFirstCase adapterCarPlatesFirstCase;
    AdapterAccAndJunkFirstCase adapterAccessoriesFirstCase,adapterJunkFirstCase;

    RecyclerView suggestedItemRecyclerView,carForSaleRecyclerView
            ,carForRentRecyclerView,carExchangeRecyclerView,motorcycleRecyclerView
            ,junkCarRecyclerView,wheelsRimRecyclerView,carPlatesRecyclerView
            ,accessoriesRecyclerView,junkRecyclerView;

    RecyclerView.LayoutManager layoutManagerSuggested,layoutManagerCarForSale
            ,layoutManagerCarRentSale,layoutManagerCarExchange,layoutManagerCarMotorcycle
            , layoutManagerTrucks,layoutManagerWheelsRim,carPlatesWheelsRim
            , layoutManagerAccessories,layoutManagerJunk;

    private Activity activity;

    InsuranceFragment insuranceFragment = new InsuranceFragment();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
        fillArrayLists();
        applyAlgorithmToAllLists();
    }

    private void fillArrayLists() {
        carForSaleArrayL = new ArrayList<>();
        carForRentArrayL = new ArrayList<>();
        carExchangeArrayL = new ArrayList<>();
        motorcycleArrayL = new ArrayList<>();
        trucksArrayL = new ArrayList<>();
        wheelsRimArrayL = new ArrayList<>();
        carPlatesArrayL = new ArrayList<>();
        accessoriesArrayL = new ArrayList<>();
        junkArrayL = new ArrayList<>();
        suggestedItemsArrayL = new ArrayList<SuggestedItem>();
        suggestedItemsArrayL = getSuggestedItemFromDatabase(getActivity());
        carForSaleArrayL = getCarForSaleDatabase(getActivity(),"Car for sale");
        carForRentArrayL = getCarForSaleDatabase(getActivity(),"Car for rent");
        carExchangeArrayL = getCarForSaleDatabase(getActivity(),"Exchange car");
        motorcycleArrayL = getCarForSaleDatabase(getActivity(),"Motorcycle");
        trucksArrayL = getCarForSaleDatabase(getActivity(),"Trucks");
        wheelsRimArrayL = getWheelsRimDatabase(getActivity());
        carPlatesArrayL = getCarPlatesDatabase(getActivity());
        accessoriesArrayL = getAccAndJunkDatabase(getActivity(),"Accessories");
        junkArrayL = getAccAndJunkDatabase(getActivity(),"Junk car");
    }


    private void applyAlgorithmToAllLists() {
        carForSaleArrayL = setEditTextFirstItemCCEMTFirstCase(carForSaleArrayL);
        carForRentArrayL = setEditTextFirstItemCCEMTFirstCase(carForRentArrayL);
        carExchangeArrayL = setEditTextFirstItemCCEMTFirstCase(carExchangeArrayL);
        motorcycleArrayL = setEditTextFirstItemCCEMTFirstCase(motorcycleArrayL);
        trucksArrayL = setEditTextFirstItemCCEMTFirstCase(trucksArrayL);
        wheelsRimArrayL = setEditTextFirstItemWheelsRim(wheelsRimArrayL);
        //carPlatesArrayL = setEditTextFirstCarPlates(carPlatesArrayL);
        accessoriesArrayL = setEditTextFirstAccAndJunk(accessoriesArrayL);
        junkArrayL = setEditTextFirstAccAndJunk(junkArrayL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_main_item, container, false);
        inti();
        changeFont();
        createSuggestedItemRV();
        createInsuranceFragment();
//        createCarForSaleRV();
//        createCarForRentRV();
//        createCarExchangeRV();
//        createMotorcycleRV();
//        createJunkCarRV();
        createWheelsRimRV();
        createCarPlatesRV();
        createAccessoriesRV();
        createJunkRV();
        return view;
    }

    private void createInsuranceFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_insurance_fragment, insuranceFragment)
                .commit();
    }

    private void changeFont() {
        suggestedTV.setTypeface(Functions.changeFontBold(getActivity()));
        suggestedSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));


        carForSaleTV.setTypeface(Functions.changeFontBold(getActivity()));
        carForSaleSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        carForRentTV.setTypeface(Functions.changeFontBold(getActivity()));
        carForRentSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        exchangeCarTV.setTypeface(Functions.changeFontBold(getActivity()));
        exchangeCarSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        motorcycleTV.setTypeface(Functions.changeFontBold(getActivity()));
        motorcycleSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        trucksTV.setTypeface(Functions.changeFontBold(getActivity()));
        trucksSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        wheelsRimTV.setTypeface(Functions.changeFontBold(getActivity()));
        wheelsRimSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        carPlatesTV.setTypeface(Functions.changeFontBold(getActivity()));
        carPlatesSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        accessoriesTV.setTypeface(Functions.changeFontBold(getActivity()));
        accessoriesSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));

        junkCarTV.setTypeface(Functions.changeFontBold(getActivity()));
        junkCarSeeAllTV.setTypeface(Functions.changeFontGeneral(getActivity()));
    }

    private void createJunkRV() {
        junkRecyclerView.setHasFixedSize(true);
        layoutManagerJunk = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        junkRecyclerView.setLayoutManager(layoutManagerJunk);
        adapterJunkFirstCase =new AdapterAccAndJunkFirstCase(getActivity()
                , junkArrayL,"suggested_fragment");
        junkRecyclerView.setAdapter(adapterJunkFirstCase);
    }

    private void createAccessoriesRV() {
        accessoriesRecyclerView.setHasFixedSize(true);
        layoutManagerAccessories = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        accessoriesRecyclerView.setLayoutManager(layoutManagerAccessories);
        adapterAccessoriesFirstCase =new AdapterAccAndJunkFirstCase(getActivity()
                , accessoriesArrayL,"suggested_fragment");
        accessoriesRecyclerView.setAdapter(adapterAccessoriesFirstCase);
    }

    private void createCarPlatesRV() {
        carPlatesRecyclerView.setHasFixedSize(true);
        carPlatesWheelsRim = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        carPlatesRecyclerView.setLayoutManager(carPlatesWheelsRim);
        adapterCarPlatesFirstCase =new AdapterCarPlatesFirstCase(getActivity()
                , carPlatesArrayL,"suggested_fragment");
        carPlatesRecyclerView.setAdapter(adapterCarPlatesFirstCase);
    }

    private void createWheelsRimRV() {
        wheelsRimRecyclerView.setHasFixedSize(true);
        layoutManagerWheelsRim = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        wheelsRimRecyclerView.setLayoutManager(layoutManagerWheelsRim);
        adapterWheelsRim =new AdapterWheelsRim(getActivity()
                , wheelsRimArrayL,"suggested_fragment");
        wheelsRimRecyclerView.setAdapter(adapterWheelsRim);
    }

//    private void createJunkCarRV() {
//        junkCarRecyclerView.setHasFixedSize(true);
//        layoutManagerTrucks = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//
//        junkCarRecyclerView.setLayoutManager(layoutManagerTrucks);
//        adapterTrucks =new AdapterCCEMTAllCases(getActivity()
//                , trucksArrayL,"suggested_fragment");
//        junkCarRecyclerView.setAdapter(adapterTrucks);
//    }
//
//    private void createMotorcycleRV() {
//        motorcycleRecyclerView.setHasFixedSize(true);
//        layoutManagerCarMotorcycle = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//
//        motorcycleRecyclerView.setLayoutManager(layoutManagerCarMotorcycle);
//        adapterCarMotorcycle =new AdapterCCEMTAllCases(getActivity()
//                ,motorcycleArrayL,"suggested_fragment");
//        motorcycleRecyclerView.setAdapter(adapterCarMotorcycle);
//    }
//
//    private void createCarExchangeRV() {
//        carExchangeRecyclerView.setHasFixedSize(true);
//        layoutManagerCarExchange = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//
//        carExchangeRecyclerView.setLayoutManager(layoutManagerCarExchange);
//        adapterCarExchange =new AdapterCCEMTAllCases(getActivity()
//                ,carExchangeArrayL,"suggested_fragment");
//        carExchangeRecyclerView.setAdapter(adapterCarExchange);
//    }
//
//    private void createCarForRentRV() {
//        carForRentRecyclerView.setHasFixedSize(true);
//        layoutManagerCarRentSale = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//
//        carForRentRecyclerView.setLayoutManager(layoutManagerCarRentSale);
//        getAdapterCarRentSale =new AdapterCCEMTAllCases(getActivity()
//                ,carForRentArrayL,"suggested_fragment");
//        carForRentRecyclerView.setAdapter(getAdapterCarRentSale);
//    }
//
//    private void createCarForSaleRV() {
//        carForSaleRecyclerView.setHasFixedSize(true);
//        layoutManagerCarForSale = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//
//        carForSaleRecyclerView.setLayoutManager(layoutManagerCarForSale);
//        adapterCarForSale =new AdapterCCEMTAllCases(getActivity()
//                ,carForSaleArrayL,"suggested_fragment");
//        carForSaleRecyclerView.setAdapter(adapterCarForSale);
//    }

    private void createSuggestedItemRV() {
        suggestedItemRecyclerView.setHasFixedSize(true);
        layoutManagerSuggested = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);

        suggestedItemRecyclerView.setLayoutManager(layoutManagerSuggested);
        adapterSuggestedItem =new AdapterSuggestedItem(getActivity()
                ,suggestedItemsArrayL,"suggested_fragment");
        suggestedItemRecyclerView.setAdapter(adapterSuggestedItem);
    }

    private void inti() {
        suggestedItemRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_item_RV);
        carForSaleRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_car_for_sale_RV);
        carForRentRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_car_for_rent_RV);
        carExchangeRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_car_exchange_RV);
        motorcycleRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_motorcycle_RV);
        junkCarRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_suggested_trucks_RV);
        wheelsRimRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_list_main_wheels_rim_RV);
        carPlatesRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_list_main_car_plates_RV);
        accessoriesRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_list_main_accessories_RV);
        junkRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_list_main_junk_RV);

        suggestedTV = (TextView) view.findViewById(R.id.fragment_list_main_suggested_tv);
        suggestedSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_stu_tv);
        suggestedSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_stu_rl);

        carForSaleTV = (TextView) view.findViewById(R.id.fragment_list_main_car_for_sale_tv);
        carForSaleSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_cfs_tv);
        carForSaleSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_cfs_rl);

        carForRentTV = (TextView) view.findViewById(R.id.fragment_list_main_car_for_rent_tv);
        carForRentSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_cfr_tv);
        carForRentSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_cfr_rl);

        exchangeCarTV = (TextView) view.findViewById(R.id.fragment_list_main_car_exchange_tv);
        exchangeCarSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_ec_tv);
        exchangeCarSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_ec_rl);

        motorcycleTV = (TextView) view.findViewById(R.id.fragment_list_main_car_motorcycle_tv);
        motorcycleSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_m_tv);
        motorcycleSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_m_rl);

        trucksTV = (TextView) view.findViewById(R.id.fragment_ist_main_car_trucks_tv);
        trucksSeeAllTV = (TextView) view.findViewById(R.id.fragment_ist_main_see_all_t_tv);
        trucksSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_ist_main_see_all_t_rl);

        wheelsRimTV = (TextView) view.findViewById(R.id.fragment_list_main_wheels_rim_tv);
        wheelsRimSeeAllTV = (TextView) view.findViewById(R.id.fragment_list_main_see_all_wr_tv);
        wheelsRimSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_list_main_see_all_wr_rl);

        carPlatesTV = (TextView) view.findViewById(R.id.fragment_list_main_car_plates_tv);
        carPlatesSeeAllTV = (TextView) view.findViewById(R.id.fragment_suggested_item_see_all_cp_tv);
        carPlatesSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_suggested_item_see_all_cp_rl);

        accessoriesTV = (TextView) view.findViewById(R.id.fragment_list_main_accessories_tv);
        accessoriesSeeAllTV = (TextView) view.findViewById(R.id.fragment_suggested_item_see_all_acc_tv);
        accessoriesSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_suggested_item_see_all_acc_rl);

        junkCarTV = (TextView) view.findViewById(R.id.fragment_list_main_junk_tv);
        junkCarSeeAllTV = (TextView) view.findViewById(R.id.fragment_suggested_item_see_all_j_tv);
        junkCarSeeAllRL = (RelativeLayout) view.findViewById(R.id.fragment_suggested_item_see_all_j_rl);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_SHOW_ITEM_SELECTED_DETAILS) {
//            Log.i("TAG", "Update in child fragment");
//        }
//    }

}
