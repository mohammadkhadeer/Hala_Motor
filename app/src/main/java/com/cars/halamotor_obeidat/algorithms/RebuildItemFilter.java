package com.cars.halamotor_obeidat.algorithms;

import android.content.Context;
import android.util.Log;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.SimilarAdsComp;
import com.cars.halamotor_obeidat.model.SimilarNeeded;

import java.util.ArrayList;

public class RebuildItemFilter {
    public static SimilarAdsComp rebuildItemFilter(SimilarNeeded similarNeeded,
                                                   String category, Context context){
        ArrayList<ItemSelectedFilterModel> itemFilterArrayList = new ArrayList<ItemSelectedFilterModel>();

        SimilarAdsComp similarAdsComp = null;

        //////////////////Exchange car ///////////////////////////
        if (category.equals(context.getResources().getString(R.string.exchange_car_s)))
        {
            if (!similarNeeded.getCarMake().equals("empty"))
            {
                if (!similarNeeded.getCarModel().equals("empty"))
                {
                    if (similarNeeded.getCity().equals("empty"))
                    {
                        Log.i("TAJ","exchange car Full");
                        ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );

                        ItemSelectedFilterModel itemSelectedFilterMake= new ItemSelectedFilterModel(
                                similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                        );

                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                similarNeeded.getCarModel(),similarNeeded.getCarMake(),category
                        );

                        itemFilterArrayList.add(itemSelectedFilterCategory);
                        itemFilterArrayList.add(itemSelectedFilterMake);
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                    }else{
                        if (similarNeeded.getNeighborhood().equals("empty"))
                        {
                            Log.i("TAJ","exchange car model but select city");
                            ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterMake= new ItemSelectedFilterModel(
                                    similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    similarNeeded.getCarModel(),similarNeeded.getCarMake(),category
                            );

                            itemFilterArrayList.add(itemSelectedFilterCategory);
                            itemFilterArrayList.add(itemSelectedFilterMake);
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                        }else{
                            Log.i("TAJ","exchange car model but select city and Neighborhood");
                            ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterMake= new ItemSelectedFilterModel(
                                    similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    similarNeeded.getCarModel(),similarNeeded.getCarMake(),category
                            );

                            itemFilterArrayList.add(itemSelectedFilterCategory);
                            itemFilterArrayList.add(itemSelectedFilterMake);
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                        }
                    }
                }else{
                    if (similarNeeded.getCity().equals("empty"))
                    {
                        Log.i("TAJ","exchange car model empty");
                        ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );

                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterCategory);
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                    }else{
                        if (similarNeeded.getNeighborhood().equals("empty"))
                        {
                            Log.i("TAJ","exchange car model but select city");
                            ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                            );


                            itemFilterArrayList.add(itemSelectedFilterCategory);
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                        }else{
                            Log.i("TAJ","exchange car model but select city and Neighborhood");
                            ItemSelectedFilterModel itemSelectedFilterCategory= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );

                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    similarNeeded.getCarMake(),similarNeeded.getCarMake(),category
                            );
                            itemFilterArrayList.add(itemSelectedFilterCategory);
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                        }
                    }
                }
            }else{
                if (similarNeeded.getCity().equals("empty"))
                {
                    Log.i("TAJ","exchange car comletey empty");
                    ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                    );
                    itemFilterArrayList.add(itemSelectedFilterModel);
                    similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                }else{
                    if (similarNeeded.getNeighborhood().equals("empty"))
                    {
                        Log.i("TAJ","exchange car comletey empty but select city");
                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                    }else{
                        Log.i("TAJ","exchange car comletey empty but select city and Neighborhood");
                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                    }
                }
            }
        }else{
            /////////////////All category without exchange car without any filter///////////////////
            if (similarNeeded.getPriceFrom() == 2.0)
            {
                if (similarNeeded.getCity().equals("empty"))
                {
                    Log.i("TAJ","comletey empty");
                    ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                    );
                    itemFilterArrayList.add(itemSelectedFilterModel);
                    similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                }else{
                    if (similarNeeded.getNeighborhood().equals("empty"))
                    {
                        Log.i("TAJ","comletey empty but select city");
                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                    }else{
                        Log.i("TAJ","comletey empty but select city and Neighborhood");
                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                    }
                }
            }else{
                /////////////////All category without exchange car with price start from filter///////////////////
                if (similarNeeded.getPriceFrom() != 2.0 && similarNeeded.getPriceTo() == 200000000.0 && !category.equals(context.getResources().getString(R.string.exchange_car_s)))
                {
                    if (similarNeeded.getCity().equals("empty"))
                    {
                        Log.i("TAJ","Selected from price ****");
                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                        );
                        itemFilterArrayList.add(itemSelectedFilterModel);
                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                    }else{
                        if (similarNeeded.getNeighborhood().equals("empty"))
                        {
                            Log.i("TAJ","Selected from price **** but select city");
                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );
                            ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                        }else{
                            Log.i("TAJ","Selected from price **** but select city and Neighborhood");
                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );
                            ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                            );
                            itemFilterArrayList.add(itemSelectedFilterModel);
                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                        }
                    }
                }else{
                    /////////////////All category without exchange car with price start from and price to filter///////////////////
                    if (similarNeeded.getPriceFrom() != 2.0 && similarNeeded.getPriceTo() != 200000000.0 && !category.equals(context.getResources().getString(R.string.exchange_car_s)))
                    {
                        if (similarNeeded.getCarMake().equals("empty") && similarNeeded.getWheelsSize() ==0 && similarNeeded.getCarPlatesCity().equals("empty"))
                        {
                            if (similarNeeded.getCity().equals("empty"))
                            {
                                Log.i("TAJ","Selected To price ****");
                                ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                        String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                );
                                ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                        String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                );
                                ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                        String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                );
                                itemFilterArrayList.add(itemSelectedFilterModel);
                                itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                            }else{
                                if (similarNeeded.getNeighborhood().equals("empty"))
                                {
                                    Log.i("TAJ","Selected To price **** but select city");
                                    ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                    );
                                    itemFilterArrayList.add(itemSelectedFilterModel);
                                    itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                    itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                    similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                                }else{
                                    Log.i("TAJ","Selected from To **** but select city and Neighborhood");
                                    ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                            String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                    );
                                    itemFilterArrayList.add(itemSelectedFilterModel);
                                    itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                    itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                    similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                                }
                            }
                        }else{
                            /////////////////Category car_for_sale or car_for_rent or motorcycle or trucks with
                            // price start from ,price to and car make
                            //Category plates prim price start from ,price to and plates city
                            if (!similarNeeded.getCarMake().equals("empty"))
                            {
                                if (!similarNeeded.getCarModel().equals("empty"))
                                {
                                    if (similarNeeded.getCity().equals("empty")) {
                                        Log.i("TAJ", "Selected carModel ****");
                                        ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterCarModel = new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getCarModel()), String.valueOf(similarNeeded.getCarModel()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterCarMake);
                                        itemFilterArrayList.add(itemSelectedFilterCarModel);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList, "empty", "empty");
                                    } else {
                                        if (similarNeeded.getNeighborhood().equals("empty")) {
                                            Log.i("TAJ", "Selected carModel **** but select city");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getCarModel()), String.valueOf(similarNeeded.getCarModel()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterCarMake);
                                            itemFilterArrayList.add(itemSelectedFilterCarModel);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), "empty");
                                        } else {
                                            Log.i("TAJ", "Selected carModel **** but select city and Neighborhood");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getCarModel()), String.valueOf(similarNeeded.getCarModel()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterCarMake);
                                            itemFilterArrayList.add(itemSelectedFilterCarModel);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), similarNeeded.getNeighborhood());
                                        }
                                    }
                                }else {
                                    if (similarNeeded.getCity().equals("empty")) {
                                        Log.i("TAJ", "Selected carMake ****");
                                        ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterCarMake);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList, "empty", "empty");
                                    } else {
                                        if (similarNeeded.getNeighborhood().equals("empty")) {
                                            Log.i("TAJ", "Selected carMake **** but select city");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterCarMake);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), "empty");
                                        } else {
                                            Log.i("TAJ", "Selected carMake **** but select city and Neighborhood");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterCarMake = new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getCarMake()), String.valueOf(similarNeeded.getCarMake()),category
                                            );

                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterCarMake);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), similarNeeded.getNeighborhood());
                                        }
                                    }
                                }
                            }

                            //Category wheels prim price start from ,price to and wheels size
                            if (similarNeeded.getWheelsSize() !=0)
                            {
                                if (similarNeeded.getWheelsType().equals("empty"))
                                {
                                    if (similarNeeded.getCity().equals("empty"))
                                    {
                                        Log.i("TAJ","Selected WheelsSize ****");
                                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterWheelsSize= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getWheelsSize()),String.valueOf(similarNeeded.getWheelsSize()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                                    }else{
                                        if (similarNeeded.getNeighborhood().equals("empty"))
                                        {
                                            Log.i("TAJ","Selected WheelsSize **** but select city");
                                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsSize= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getWheelsSize()),String.valueOf(similarNeeded.getWheelsSize()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                                        }else{
                                            Log.i("TAJ","Selected WheelsSize **** but select city and Neighborhood");
                                            ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsSize= new ItemSelectedFilterModel(
                                                    String.valueOf(similarNeeded.getWheelsSize()),String.valueOf(similarNeeded.getWheelsSize()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                                        }
                                    }
                                }else{
                                    //Category wheels prim price start from ,price to,wheels size and wheels Type
                                    if (similarNeeded.getCity().equals("empty"))
                                    {
                                        Log.i("TAJ","Selected WheelsType ****");
                                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterWheelsSize= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getWheelsSize()),String.valueOf(similarNeeded.getWheelsSize()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterWheelsType= new ItemSelectedFilterModel(
                                                String.valueOf(similarNeeded.getWheelsType()),String.valueOf(similarNeeded.getWheelsType()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                        itemFilterArrayList.add(itemSelectedFilterWheelsType);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                                    }else {
                                        if (similarNeeded.getNeighborhood().equals("empty")) {
                                            Log.i("TAJ", "Selected WheelsType **** but select city");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsSize = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getWheelsSize()), String.valueOf(similarNeeded.getWheelsSize()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsType= new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getWheelsType()),String.valueOf(similarNeeded.getWheelsType()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsType);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), "empty");
                                        } else {
                                            Log.i("TAJ", "Selected WheelsType **** but select city and Neighborhood");
                                            ItemSelectedFilterModel itemSelectedFilterModel = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceFrom = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceFrom()), String.valueOf(similarNeeded.getPriceFrom()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterPriceTo = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getPriceTo()), String.valueOf(similarNeeded.getPriceTo()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsSize = new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getWheelsSize()), String.valueOf(similarNeeded.getWheelsSize()),category
                                            );
                                            ItemSelectedFilterModel itemSelectedFilterWheelsType= new ItemSelectedFilterModel(
                                                     String.valueOf(similarNeeded.getWheelsType()),String.valueOf(similarNeeded.getWheelsType()),category
                                            );
                                            itemFilterArrayList.add(itemSelectedFilterModel);
                                            itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                            itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsSize);
                                            itemFilterArrayList.add(itemSelectedFilterWheelsType);
                                            similarAdsComp = new SimilarAdsComp(itemFilterArrayList, similarNeeded.getCity(), similarNeeded.getNeighborhood());
                                        }
                                    }
                                }
                            }

                            //Category carPlates price start from ,price to and wheels size
                            if (!similarNeeded.getCarPlatesCity().equals("empty"))
                            {
                                if (similarNeeded.getCity().equals("empty"))
                                {
                                    Log.i("TAJ","Selected plates ****");
                                    ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                             String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                             String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                             String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                    );
                                    ItemSelectedFilterModel itemSelectedFilterPlatesCity= new ItemSelectedFilterModel(
                                             String.valueOf(similarNeeded.getCarPlatesCity()),String.valueOf(similarNeeded.getCarPlatesCity()),category
                                    );
                                    itemFilterArrayList.add(itemSelectedFilterModel);
                                    itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                    itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                    itemFilterArrayList.add(itemSelectedFilterPlatesCity);
                                    similarAdsComp = new SimilarAdsComp(itemFilterArrayList,"empty","empty");
                                }else{
                                    if (similarNeeded.getNeighborhood().equals("empty"))
                                    {
                                        Log.i("TAJ","Selected plates **** but select city");
                                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPlatesCity= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getCarPlatesCity()),String.valueOf(similarNeeded.getCarPlatesCity()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterPlatesCity);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),"empty");
                                    }else{
                                        Log.i("TAJ","Selected plates **** but select city and Neighborhood");
                                        ItemSelectedFilterModel itemSelectedFilterModel= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceFrom= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceFrom()),String.valueOf(similarNeeded.getPriceFrom()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPriceTo= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getPriceTo()),String.valueOf(similarNeeded.getPriceTo()),category
                                        );
                                        ItemSelectedFilterModel itemSelectedFilterPlatesCity= new ItemSelectedFilterModel(
                                                 String.valueOf(similarNeeded.getCarPlatesCity()),String.valueOf(similarNeeded.getCarPlatesCity()),category
                                        );
                                        itemFilterArrayList.add(itemSelectedFilterModel);
                                        itemFilterArrayList.add(itemSelectedFilterPriceFrom);
                                        itemFilterArrayList.add(itemSelectedFilterPriceTo);
                                        itemFilterArrayList.add(itemSelectedFilterPlatesCity);
                                        similarAdsComp = new SimilarAdsComp(itemFilterArrayList,similarNeeded.getCity(),similarNeeded.getNeighborhood());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return similarAdsComp;
    }
}
