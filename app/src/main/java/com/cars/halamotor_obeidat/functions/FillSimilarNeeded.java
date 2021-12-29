package com.cars.halamotor_obeidat.functions;

import android.content.Context;

import com.cars.halamotor_obeidat.R;
import com.cars.halamotor_obeidat.model.ItemSelectedFilterModel;
import com.cars.halamotor_obeidat.model.SimilarNeeded;

import java.util.ArrayList;

public class FillSimilarNeeded {

    static double priceFromInti=2.0,priceToInti=200000000.0;

    public static SimilarNeeded getSimilarNeeded(ArrayList<ItemSelectedFilterModel> itemFilterArrayList
                                                , String city, String neighborhood, Context context){
        SimilarNeeded similarNeeded=null;

        if (itemFilterArrayList.size() ==1)
        {
            if (city.equals("empty")){
                similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,"empty","empty","empty","empty","empty","empty",0);
            }else{
                if (neighborhood.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,"empty","empty",city,"empty","empty","empty",0);
                }else{
                    similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,"empty","empty",city,neighborhood,"empty","empty",0);
                }
            }
        }

        if (itemFilterArrayList.size() ==2)
        {
            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.exchange_car)))
            {
                String carMake = itemFilterArrayList.get(1).getFilterS();
                if (city.equals("empty")) {
                    similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,"empty","empty","empty","empty","empty",0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,"empty",city,"empty","empty","empty",0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,"empty",city,neighborhood,"empty","empty",0);
                    }
                }
            }else{
                double priceFrom = Double.parseDouble(itemFilterArrayList.get(1).getFilterS());
                if (neighborhood.endsWith("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceToInti,"empty","empty",city,"empty","empty","empty",0);
                }else{
                    similarNeeded = new SimilarNeeded(priceFrom,priceToInti,"empty","empty",city,neighborhood,"empty","empty",0);
                }
            }
        }

        if (itemFilterArrayList.size() ==3)
        {
            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.exchange_car)))
            {
                String carMake = itemFilterArrayList.get(1).getFilterS();
                String carModel = itemFilterArrayList.get(2).getFilterS();
                if (city.equals("empty")) {
                    similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,carModel,"empty","empty","empty","empty",0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,carModel,city,"empty","empty","empty",0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFromInti,priceToInti,carMake,carModel,city,neighborhood,"empty","empty",0);
                    }
                }
            }else {
                double priceFrom = Double.parseDouble(itemFilterArrayList.get(1).getFilterS());
                double priceTo = Double.parseDouble(itemFilterArrayList.get(2).getFilterS());
                if (city.equals("empty")) {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty","empty","empty","empty","empty",0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,"empty","empty","empty",0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,neighborhood,"empty","empty",0);
                    }
                }
            }
        }

        if(itemFilterArrayList.size()==4)
        {
            double priceFrom = Double.parseDouble(itemFilterArrayList.get(1).getFilterS());
            double priceTo = Double.parseDouble(itemFilterArrayList.get(2).getFilterS());

            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.trucks))
            )
            {
                String carMake = itemFilterArrayList.get(3).getFilterS();
                if (city.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,"empty","empty","empty","empty","empty",0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,"empty",city,"empty","empty","empty",0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,"empty",city,neighborhood,"empty","empty",0);
                    }
                }
            }

            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.wheels_rim))
            ){
                int wheelsSize = Integer.parseInt(itemFilterArrayList.get(3).getFilterS());
                if (city.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty","empty","empty","empty","empty",wheelsSize);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,"empty","empty","empty",wheelsSize);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,neighborhood,"empty","empty",wheelsSize);
                    }
                }
            }

            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.car_plates))
            ){
                String platesCity = itemFilterArrayList.get(3).getFilterS();
                if (city.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty","empty","empty","empty",platesCity,0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,"empty","empty",platesCity,0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,neighborhood,"empty",platesCity,0);
                    }
                }
            }

        }

        if(itemFilterArrayList.size()==5)
        {
            double priceFrom = Double.parseDouble(itemFilterArrayList.get(1).getFilterS());
            double priceTo = Double.parseDouble(itemFilterArrayList.get(2).getFilterS());

            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_sale))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.car_for_rent))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.motorcycle))
                    || itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.trucks))
            )
            {
                String carMake = itemFilterArrayList.get(3).getFilterS();
                String carModel = itemFilterArrayList.get(4).getFilterS();
                if (city.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,carModel,"empty","empty","empty","empty",0);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,carModel,city,"empty","empty","empty",0);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,carMake,carModel,city,neighborhood,"empty","empty",0);
                    }
                }

            }

            if (itemFilterArrayList.get(0).getFilterType().equals(context.getResources().getString(R.string.wheels_rim)))
            {
                int wheelsSize = Integer.parseInt(itemFilterArrayList.get(3).getFilterS());
                String wheelsType = itemFilterArrayList.get(4).getFilterS();
                if (city.equals("empty"))
                {
                    similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty","empty","empty",wheelsType,"empty",wheelsSize);
                }else{
                    if (neighborhood.endsWith("empty"))
                    {
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,"empty",wheelsType,"empty",wheelsSize);
                    }else{
                        similarNeeded = new SimilarNeeded(priceFrom,priceTo,"empty","empty",city,neighborhood,wheelsType,"empty",wheelsSize);
                    }
                }
            }

        }

        return similarNeeded;
    }
}
