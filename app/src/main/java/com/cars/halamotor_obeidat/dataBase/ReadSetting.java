package com.cars.halamotor_obeidat.dataBase;

import android.content.Context;
import android.database.Cursor;

import com.cars.halamotor_obeidat.model.CarColor;
import com.cars.halamotor_obeidat.model.CarCondition;
import com.cars.halamotor_obeidat.model.CarFuel;
import com.cars.halamotor_obeidat.model.CarInsurance;
import com.cars.halamotor_obeidat.model.CarLicensed;
import com.cars.halamotor_obeidat.model.CarOption;
import com.cars.halamotor_obeidat.model.CarTransmission;
import com.cars.halamotor_obeidat.model.PaymentMethod;

import java.util.ArrayList;

import static com.cars.halamotor_obeidat.dataBase.DataBaseInstance.getDataBaseInstance;
import static com.cars.halamotor_obeidat.functions.Functions.fillColorCode;

public class ReadSetting {

    public static ArrayList<CarCondition> getCarConditionFromDataBase(Context context) {
        ArrayList<CarCondition> carConditionsArrayList = new ArrayList<CarCondition>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_condition_type"))
            {
                CarCondition carCondition= new CarCondition(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                carConditionsArrayList.add(carCondition);
            }

        }
        return carConditionsArrayList;
    }

    public static ArrayList<CarTransmission> getCarTransmissionFromDataBase(Context context) {
        ArrayList<CarTransmission> carTransmissionArrayList = new ArrayList<CarTransmission>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_transmission_type"))
            {
                CarTransmission carTransmission= new CarTransmission(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                carTransmissionArrayList.add(carTransmission);
            }

        }
        return carTransmissionArrayList;
    }

    public static ArrayList<CarFuel> getCarFuelFromDataBase(Context context) {
        ArrayList<CarFuel> carFuelsArrayList = new ArrayList<CarFuel>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_fuel_type"))
            {
                CarFuel carFuel= new CarFuel(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                carFuelsArrayList.add(carFuel);
            }

        }
        return carFuelsArrayList;
    }

    public static ArrayList<CarOption> getCarOptionsFromDataBase(Context context) {
        ArrayList<CarOption> carOptionsArrayList = new ArrayList<CarOption>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_option"))
            {
                CarOption carOption= new CarOption(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                        ,0
                );
                carOptionsArrayList.add(carOption);
            }

        }
        return carOptionsArrayList;
    }

    public static ArrayList<CarLicensed> getCarLicensedFromDataBase(Context context) {
        ArrayList<CarLicensed> carLicensedArrayList = new ArrayList<CarLicensed>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_license_type"))
            {
                CarLicensed carLicensed= new CarLicensed(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                carLicensedArrayList.add(carLicensed);
            }

        }
        return carLicensedArrayList;
    }

    public static ArrayList<CarInsurance> getCarInsuranceFromDataBase(Context context) {
        ArrayList<CarInsurance> carInsurancesArrayList = new ArrayList<CarInsurance>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_insurance_type"))
            {
                CarInsurance carInsurance= new CarInsurance(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                carInsurancesArrayList.add(carInsurance);
            }

        }
        return carInsurancesArrayList;
    }

    public static ArrayList<CarColor> getCarColorFromDataBase(Context context) {
        ArrayList<CarColor> carColorsArrayList = new ArrayList<CarColor>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("car_color"))
            {
                CarColor carInsurance= new CarColor(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                        ,fillColorCode(res.getString(7).replace("\n", ""),context)
                );
                carColorsArrayList.add(carInsurance);
            }

        }
        return carColorsArrayList;
    }

    public static ArrayList<PaymentMethod> getCarPaymentMethodFromDataBase(Context context) {
        ArrayList<PaymentMethod> paymentMethodsArrayList = new ArrayList<PaymentMethod>();
        Cursor res = getDataBaseInstance(context).descendingSetting();
        while (res.moveToNext()) {
            if (res.getString(2).replace("\n", "").equals("payment_method"))
            {
                PaymentMethod paymentMethod= new PaymentMethod(
                        res.getString(1).replace("\n", "")
                        ,res.getString(2).replace("\n", "")
                        ,res.getString(3).replace("\n", "")
                        ,res.getString(4).replace("\n", "")
                        ,res.getString(5).replace("\n", "")
                        ,res.getString(6).replace("\n", "")
                        ,res.getString(7).replace("\n", "")
                        ,res.getString(8).replace("\n", "")
                        ,res.getString(9).replace("\n", "")
                        ,res.getString(10).replace("\n", "")
                );
                paymentMethodsArrayList.add(paymentMethod);
            }

        }
        return paymentMethodsArrayList;
    }

}
