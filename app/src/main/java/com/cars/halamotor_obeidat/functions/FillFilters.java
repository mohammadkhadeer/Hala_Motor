package com.cars.halamotor_obeidat.functions;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.CategoryComp;
import com.cars.halamotor_obeidat.model.ItemFilterModel;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import static com.cars.halamotor_obeidat.functions.CheckLanguage.checkLanguage;
import static com.cars.halamotor_obeidat.functions.FillCarMakeArrayListsInCarDerails.fillCarMakeArrayL;
import static com.cars.halamotor_obeidat.functions.FillCarModel.fillCarmodelFilterArrayL;
import static com.cars.halamotor_obeidat.functions.NewFunction.convertYearToEng;
import static com.cars.halamotor_obeidat.staticFiles.StaticFiles.getCategoriesArrayL;

public class FillFilters {

    public static ArrayList<ItemFilterModel> fillFilter(Context context
            , int numberOfFilterSelectedNow, ArrayList<ItemSelectedFilterModel> filterType)
    {
        ArrayList<ItemFilterModel> filterArrayL = new ArrayList<>();

        //Log.i("TAG","Filter type"+filterType.get(0).getFilterType());
        //Log.i("TAG","numberOfFilterSelectedNow "+String.valueOf(numberOfFilterSelectedNow));

        if (numberOfFilterSelectedNow ==0)
        {
            filterArrayL = fillCategory(context);
        }

        if (numberOfFilterSelectedNow ==1)
        {
            if (!filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.exchange_car)))
            {
                filterArrayL = fillFromPrice(context,filterType.get(0).getFilterType());
            }else{
                filterArrayL =fillCarMakeArrayL(context);

            }
        }

        if (numberOfFilterSelectedNow ==2)
        {
            if (!filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.exchange_car)))
            {
                filterArrayL = fillToPrice(context,filterType.get(1).getFilterS(),filterType.get(0).getFilterType());
//                textView.setText(context.getResources().getString(R.string.price_to));

            }else{
                filterArrayL =fillCarmodelFilterArrayL(context,filterType.get(1).getFilter());
                Collections.sort(filterArrayL, new Comparator<ItemFilterModel>() {
                    @Override
                    public int compare(ItemFilterModel lhs, ItemFilterModel rhs) {
                        return lhs.getFilter().compareTo(rhs.getFilter());
                    }
                });
            }
        }

        if (numberOfFilterSelectedNow ==3)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.exchange_car))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.accessories))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.junk_car)))
            {
//                textView.setText(context.getResources().getString(R.string.no_filter));

            }else{
                if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                        || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                        || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
                        || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.trucks))
                )
                {
//                    textView.setText(context.getResources().getString(R.string.detect_car_make));
                    filterArrayL =fillCarMakeArrayL(context);
                    Collections.sort(filterArrayL, new Comparator<ItemFilterModel>() {
                        @Override
                        public int compare(ItemFilterModel lhs, ItemFilterModel rhs) {
                            return lhs.getFilter().compareTo(rhs.getFilter());
                        }
                    });
                }
                if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.wheels_rim))
                ){
//                    textView.setText(context.getResources().getString(R.string.detect_size));
                    filterArrayL =fillWheelsInchesFilterArrayL(context);
                }
                if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_plates))
                ){
//                    textView.setText(context.getResources().getString(R.string.plats_city));
                    filterArrayL =fillCityPlatesArrayL(context);
                }
            }
        }

        if (numberOfFilterSelectedNow ==4)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
//                textView.setText(context.getResources().getString(R.string.detect_car_make));
                filterArrayL =fillCarmodelFilterArrayL(context,filterType.get(3).getFilterS());
                Collections.sort(filterArrayL, new Comparator<ItemFilterModel>() {
                    @Override
                    public int compare(ItemFilterModel lhs, ItemFilterModel rhs) {
                        return lhs.getFilter().compareTo(rhs.getFilter());
                    }
                });
            }
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.wheels_rim))
            ){
//                textView.setText(context.getResources().getString(R.string.detect_type));
                filterArrayL =fillWheelsFilterType(context);
            }
        }
        if (numberOfFilterSelectedNow ==5)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
//                textView.setText(context.getResources().getString(R.string.detect_year));
                filterArrayL =fillCarYearFilterArrayList(context);
            }
        }
        if (numberOfFilterSelectedNow ==6)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
//                textView.setText(context.getResources().getString(R.string.detect_condition));
                filterArrayL =fillPaymentArrayL(context);
            }
        }
        if (numberOfFilterSelectedNow ==7)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
                filterArrayL =fillCarConditionsFilterType(context);
            }
        }
        if (numberOfFilterSelectedNow ==8)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
                filterArrayL =fillInsuranceFilterArrayL(context);
            }
        }
        if (numberOfFilterSelectedNow ==9)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
                filterArrayL =fillLicensedFilterArrayL(context);
            }
        }

        if (numberOfFilterSelectedNow ==10)
        {
            if (filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || filterType.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
            )
            {
                filterArrayL =fillFuelFilterArrayL(context);
            }
        }

        return filterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillFuelFilterArrayL(Context context) {
        ArrayList<ItemFilterModel> carFuelFilterArrayL = new ArrayList<ItemFilterModel>();

        String any = context.getResources().getString(R.string.any);
//        carFuelFilterArrayL.add(new ItemFilterModel(any,any));

        carFuelFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.gasoline),context.getResources().getString(R.string.gasoline_s)));
        carFuelFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.diesel),context.getResources().getString(R.string.diesel_s)));
        carFuelFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.hybrid),context.getResources().getString(R.string.hybrid_s)));
        carFuelFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.electric),context.getResources().getString(R.string.electric_s)));

        return carFuelFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillInsuranceFilterArrayL(Context context) {
        ArrayList<ItemFilterModel> carInsuranceFilterArrayL = new ArrayList<ItemFilterModel>();

        String any = context.getResources().getString(R.string.any);
//        carInsuranceFilterArrayL.add(new ItemFilterModel(any,any));

        carInsuranceFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.insurance_compulsory),context.getResources().getString(R.string.insurance_compulsory_s)));
        carInsuranceFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.insurance_comprehensive),context.getResources().getString(R.string.insurance_comprehensive_s)));
        carInsuranceFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.insurance_not),context.getResources().getString(R.string.insurance_not_s)));

        return carInsuranceFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillPaymentArrayL(Context context) {
        ArrayList<ItemFilterModel> carPMFilterArrayL = new ArrayList<ItemFilterModel>();

//        carPMFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.payment_method_1),context.getResources().getString(R.string.payment_method_1_s)));
//        carPMFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.payment_method_2),context.getResources().getString(R.string.payment_method_2_s)));
//        carPMFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.payment_method_3),context.getResources().getString(R.string.payment_method_3_s)));

        return carPMFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillLicensedFilterArrayL(Context context) {
        ArrayList<ItemFilterModel> carLicensedFilterArrayL = new ArrayList<ItemFilterModel>();

        String any = context.getResources().getString(R.string.any);
//        carLicensedFilterArrayL.add(new ItemFilterModel(any,any));

        carLicensedFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.licensed),context.getResources().getString(R.string.licensed_s)));
        carLicensedFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.no_licensed),context.getResources().getString(R.string.no_licensed_s)));

        return carLicensedFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillCarConditionsFilterType(Context context)
    {
        ArrayList<ItemFilterModel> carConditionsFilterArrayL = new ArrayList<ItemFilterModel>();

        String any = context.getResources().getString(R.string.any);
        String anyS = context.getResources().getString(R.string.any_s);

//        carConditionsFilterArrayL.add(new ItemFilterModel(any,any));
        carConditionsFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.used),context.getResources().getString(R.string.used_s)));
        carConditionsFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.car_new),context.getResources().getString(R.string.car_new_s)));

        return carConditionsFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillCarYearFilterArrayList(Context context) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        ArrayList<ItemFilterModel> filterYearArrayList = new ArrayList<ItemFilterModel>();

        String any = context.getResources().getString(R.string.any);
        String anyS = context.getResources().getString(R.string.any_s);
//        filterYearArrayList.add(new ItemFilterModel(any,anyS));

        for (int i=year;i>=1970;i--)
        {
            filterYearArrayList.add(new ItemFilterModel(String.valueOf(i),convertYearToEng(String.valueOf(i))));
        }

        return filterYearArrayList;
    }

    public static ArrayList<ItemFilterModel> fillWheelsFilterType(Context context)
    {
        ArrayList<ItemFilterModel> wheelsTypesArrayList = new ArrayList<ItemFilterModel>();

        wheelsTypesArrayList.add(new ItemFilterModel(context.getResources().getString(R.string.kushuk),context.getResources().getString(R.string.kushuk_s)));
        wheelsTypesArrayList.add(new ItemFilterModel(context.getResources().getString(R.string.metal),context.getResources().getString(R.string.metal_s)));

        return wheelsTypesArrayList;
    }

    public static ArrayList<ItemFilterModel> fillCityPlatesArrayL(Context context) {
        ArrayList<ItemFilterModel> cityArrayL = new ArrayList<>();
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.abu_dhabi),context.getResources().getString(R.string.abu_dhabi_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.dubai),context.getResources().getString(R.string.dubai_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.sharjah),context.getResources().getString(R.string.sharjah_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.al_ain),context.getResources().getString(R.string.al_ain_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ajman),context.getResources().getString(R.string.ajman_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.um_al_quwain),context.getResources().getString(R.string.um_al_quwain_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ras_al_khaimah),context.getResources().getString(R.string.ras_al_khaimah_s)));
        cityArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.fujairah),context.getResources().getString(R.string.fujairah_s)));

        return cityArrayL;
    }

    public static ArrayList<ItemFilterModel> fillWheelsInchesFilterArrayL( Context context) {
        ArrayList<ItemFilterModel> wheelsSizeFilterArrayL = new ArrayList<>();
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_13),context.getResources().getString(R.string.wheels_siz_13)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_14),context.getResources().getString(R.string.wheels_siz_14)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_15),context.getResources().getString(R.string.wheels_siz_15)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_16),context.getResources().getString(R.string.wheels_siz_16)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_17),context.getResources().getString(R.string.wheels_siz_17)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_18),context.getResources().getString(R.string.wheels_siz_18)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_19),context.getResources().getString(R.string.wheels_siz_19)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_20),context.getResources().getString(R.string.wheels_siz_20)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_21),context.getResources().getString(R.string.wheels_siz_21)));
        wheelsSizeFilterArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_siz_other),context.getResources().getString(R.string.wheels_siz_other)));

        return wheelsSizeFilterArrayL;
    }

    public static ArrayList<ItemFilterModel> fillCategory(Context context)
    {
        ArrayList<ItemFilterModel> categoryArrayL = new ArrayList<>();
        ArrayList<CategoryComp> categoriesArrayList = new ArrayList();
        categoriesArrayList = getCategoriesArrayL();

        for (int i = 1;i<categoriesArrayList.size();i++)
        {
            categoryArrayL.add(new ItemFilterModel(checkLanguage(categoriesArrayList.get(i).getName_en(),categoriesArrayList.get(i).getName_ar(),context),categoriesArrayList.get(i).getId()));
        }

//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.car_for_sale),context.getResources().getString(R.string.car_for_sale_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.car_for_rent),context.getResources().getString(R.string.car_for_rent_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.exchange_car),context.getResources().getString(R.string.exchange_car_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.motorcycle),context.getResources().getString(R.string.motorcycle_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.trucks),context.getResources().getString(R.string.trucks_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.car_plates),context.getResources().getString(R.string.car_plates_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wheels_rim),context.getResources().getString(R.string.wheels_rim_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.accessories),context.getResources().getString(R.string.accessories_s)));
//        categoryArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.junk_car),context.getResources().getString(R.string.junk_car_s)));
        return categoryArrayL;
    }

    public static ArrayList<ItemFilterModel> fillFromPrice(Context context,String category)
    {
        ArrayList<ItemFilterModel> priceArrayL = new ArrayList<>();

        if (category.equals(context.getResources().getString(R.string.car_for_sale))||category.equals(context.getResources().getString(R.string.trucks))||category.equals(context.getResources().getString(R.string.motorcycle))||category.equals(context.getResources().getString(R.string.car_plates)))
        {
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_1000),context.getResources().getString(R.string.t_1000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_5000),context.getResources().getString(R.string.t_5000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_10000),context.getResources().getString(R.string.t_10000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_15000),context.getResources().getString(R.string.t_15000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_20000),context.getResources().getString(R.string.t_20000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));

            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));

        }
        if (category.equals(context.getResources().getString(R.string.car_for_rent))||category.equals(context.getResources().getString(R.string.accessories)))
        {
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_50),context.getResources().getString(R.string.ra_50_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_100),context.getResources().getString(R.string.ra_100_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_150),context.getResources().getString(R.string.ra_200_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_200),context.getResources().getString(R.string.ra_200_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_250),context.getResources().getString(R.string.ra_250_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));

            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
        }

        if (category.equals(context.getResources().getString(R.string.junk_car))||category.equals(context.getResources().getString(R.string.wheels_rim)))
        {
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_500),context.getResources().getString(R.string.wj_500_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_600),context.getResources().getString(R.string.wj_600_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_700),context.getResources().getString(R.string.wj_700_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_800),context.getResources().getString(R.string.wj_800_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_900),context.getResources().getString(R.string.wj_900_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));

            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
            priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_500_s)));

        }

        return priceArrayL;
    }

    public static ArrayList<ItemFilterModel> fillToPrice(Context context,String fromPrice,String category)
    {
        ArrayList<ItemFilterModel> priceArrayL = new ArrayList<>();
        if (category.equals(context.getResources().getString(R.string.car_for_sale))||category.equals(context.getResources().getString(R.string.trucks))||category.equals(context.getResources().getString(R.string.motorcycle))||category.equals(context.getResources().getString(R.string.car_plates)))
        {
            int x = Integer.parseInt(fromPrice);
            if (x==1)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_5000),context.getResources().getString(R.string.t_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_10000),context.getResources().getString(R.string.t_10000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_15000),context.getResources().getString(R.string.t_15000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_20000),context.getResources().getString(R.string.t_20000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==5000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_10000),context.getResources().getString(R.string.t_10000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_15000),context.getResources().getString(R.string.t_15000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_20000),context.getResources().getString(R.string.t_20000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==10000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_15000),context.getResources().getString(R.string.t_15000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_20000),context.getResources().getString(R.string.t_20000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==15000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_20000),context.getResources().getString(R.string.t_20000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==20000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_25000),context.getResources().getString(R.string.t_25000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==25000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_30000),context.getResources().getString(R.string.t_30000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==30000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_35000),context.getResources().getString(R.string.t_35000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==35000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_40000),context.getResources().getString(R.string.t_40000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==40000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_45000),context.getResources().getString(R.string.t_45000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==45000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_50000),context.getResources().getString(R.string.t_50000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==50000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_60000),context.getResources().getString(R.string.t_60000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==60000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_70000),context.getResources().getString(R.string.t_70000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==70000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_80000),context.getResources().getString(R.string.t_80000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==80000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_90000),context.getResources().getString(R.string.t_90000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==90000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_100000),context.getResources().getString(R.string.t_100000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==100000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_150000),context.getResources().getString(R.string.t_150000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==150000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
            if (x==200000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.t_200000),context.getResources().getString(R.string.t_200000_s)));
            }
        }
        if (category.equals(context.getResources().getString(R.string.car_for_rent))||category.equals(context.getResources().getString(R.string.accessories)))
        {
            int x = Integer.parseInt(fromPrice);
            if (x ==5)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_100),context.getResources().getString(R.string.ra_100_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_150),context.getResources().getString(R.string.ra_200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_200),context.getResources().getString(R.string.ra_200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_250),context.getResources().getString(R.string.ra_250_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==100)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_150),context.getResources().getString(R.string.ra_200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_200),context.getResources().getString(R.string.ra_200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_250),context.getResources().getString(R.string.ra_250_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==150)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_200),context.getResources().getString(R.string.ra_200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_250),context.getResources().getString(R.string.ra_250_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==200)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_250),context.getResources().getString(R.string.ra_250_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==250)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_300),context.getResources().getString(R.string.ra_300_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==300)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_350),context.getResources().getString(R.string.ra_350_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==350)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_400),context.getResources().getString(R.string.ra_400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==400)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_450),context.getResources().getString(R.string.ra_450_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==450)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_500),context.getResources().getString(R.string.ra_500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==500)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_600),context.getResources().getString(R.string.ra_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==600)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_700),context.getResources().getString(R.string.ra_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==700)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_800),context.getResources().getString(R.string.ra_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==800)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_900),context.getResources().getString(R.string.ra_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==900)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1000),context.getResources().getString(R.string.ra_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==1000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_1500),context.getResources().getString(R.string.ra_1500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==1500)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
            if (x ==2000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.ra_2000),context.getResources().getString(R.string.ra_2000_s)));
            }
        }
        if (category.equals(context.getResources().getString(R.string.junk_car))||category.equals(context.getResources().getString(R.string.wheels_rim)))
        {
            int x = Integer.parseInt(fromPrice);
            if (x == 5)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_600),context.getResources().getString(R.string.wj_600_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_700),context.getResources().getString(R.string.wj_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_800),context.getResources().getString(R.string.wj_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_900),context.getResources().getString(R.string.wj_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 600)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_700),context.getResources().getString(R.string.wj_700_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_800),context.getResources().getString(R.string.wj_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_900),context.getResources().getString(R.string.wj_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 700)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_800),context.getResources().getString(R.string.wj_800_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_900),context.getResources().getString(R.string.wj_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 800)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_900),context.getResources().getString(R.string.wj_900_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 900)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1000),context.getResources().getString(R.string.wj_1000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 1000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1200),context.getResources().getString(R.string.wj_1200_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 1200)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1400),context.getResources().getString(R.string.wj_1400_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 1400)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_1750),context.getResources().getString(R.string.wj_1750_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 1750)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2000),context.getResources().getString(R.string.wj_2000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 2000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_2500),context.getResources().getString(R.string.wj_2500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 2500)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3000),context.getResources().getString(R.string.wj_3000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 3000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_3500),context.getResources().getString(R.string.wj_3500_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 3500)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_4000),context.getResources().getString(R.string.wj_4000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 4000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_5000),context.getResources().getString(R.string.wj_5000_s)));
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 5000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
            if (x == 10000)
            {
                priceArrayL.add(new ItemFilterModel(context.getResources().getString(R.string.wj_10000),context.getResources().getString(R.string.wj_10000_s)));
            }
        }
            return priceArrayL;
    }
}
