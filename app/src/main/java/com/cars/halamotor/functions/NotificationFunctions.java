package com.cars.halamotor.functions;

import android.content.Context;

import com.cars.halamotor.R;

public class NotificationFunctions {

    public static int processImage(String process){
        int processImage = -1;
        if (process.equals("Car_For_Sale"))
        {
            processImage = R.drawable.car_for_sale;
        }
        if (process.equals("Car_For_Rent"))
        {
            processImage = R.drawable.car_rent;
        }
        if (process.equals("Car_For_Exchange"))
        {
            processImage = R.drawable.exchange_car;
        }
        if (process.equals("Motorcycle"))
        {
            processImage = R.drawable.motorcycle;
        }
        if (process.equals("Trucks"))
        {
            processImage = R.drawable.vip;
        }
        if (process.equals("Plates"))
        {
            processImage = R.drawable.accessories;
        }
        if (process.equals("Wheels_Rim"))
        {
            processImage = R.drawable.wheels_rim;
        }
        if (process.equals("Accessories"))
        {
            processImage = R.drawable.trucks;
        }
        if (process.equals("JunkCar"))
        {
            processImage = R.drawable.junk_car;
        }
        return processImage;
    }

    public static String processName(String process, Context context){
        String processName = null;
        if (process.equals("car_for_sale"))
        {
            processName = context.getResources().getString(R.string.car_for_sale);
        }
        if (process.equals("car_for_rent"))
        {
            processName = context.getResources().getString(R.string.car_for_rent);
        }
        if (process.equals("Car_For_Exchange"))
        {
            processName = context.getResources().getString(R.string.exchange_car);
        }
        if (process.equals("Motorcycle"))
        {
            processName = context.getResources().getString(R.string.motorcycle);
        }
        if (process.equals("Trucks"))
        {
            processName = context.getResources().getString(R.string.trucks);
        }
        if (process.equals("Plates"))
        {
            processName = context.getResources().getString(R.string.car_plates);
        }
        if (process.equals("Wheels_Rim"))
        {
            processName = context.getResources().getString(R.string.wheels_rim);
        }
        if (process.equals("Accessories"))
        {
            processName = context.getResources().getString(R.string.accessories);
        }
        if (process.equals("JunkCar"))
        {
            processName = context.getResources().getString(R.string.junk_car);
        }
        if (process.equals("welcome"))
        {
            processName = context.getResources().getString(R.string.app_name);
        }
        return processName;
    }

}
