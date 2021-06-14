package com.cars.halamotor.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CarDetailsModel implements Parcelable {

    CarMake carMake;
    CarColor carColor;
    CarModel carModel;
    String yearStr,carOptionsStr;
    CarCondition carCondition;
    String kilometersStr;
    CarTransmission carTransmission;
    CarFuel carFuel;
    CarLicensed carLicensed;
    CarInsurance carInsurance;
    PaymentMethod paymentMethod;
    public CarDetailsModel(){}
    ArrayList<String> car_options_array;

    public CarDetailsModel(CarMake carMake, CarColor carColor, CarModel carModel, String yearStr, String carOptionsStr, CarCondition carCondition, String kilometersStr, CarTransmission carTransmission, CarFuel carFuel, CarLicensed carLicensed, CarInsurance carInsurance, PaymentMethod paymentMethod, ArrayList<String> car_options_array) {
        this.carMake = carMake;
        this.carColor = carColor;
        this.carModel = carModel;
        this.yearStr = yearStr;
        this.carOptionsStr = carOptionsStr;
        this.carCondition = carCondition;
        this.kilometersStr = kilometersStr;
        this.carTransmission = carTransmission;
        this.carFuel = carFuel;
        this.carLicensed = carLicensed;
        this.carInsurance = carInsurance;
        this.paymentMethod = paymentMethod;
        this.car_options_array = car_options_array;
    }

    protected CarDetailsModel(Parcel in) {
        carMake = in.readParcelable(CarMake.class.getClassLoader());
        carColor = in.readParcelable(CarColor.class.getClassLoader());
        carModel = in.readParcelable(CarModel.class.getClassLoader());
        yearStr = in.readString();
        carOptionsStr = in.readString();
        carCondition = in.readParcelable(CarCondition.class.getClassLoader());
        kilometersStr = in.readString();
        carTransmission = in.readParcelable(CarTransmission.class.getClassLoader());
        carFuel = in.readParcelable(CarFuel.class.getClassLoader());
        carLicensed = in.readParcelable(CarLicensed.class.getClassLoader());
        carInsurance = in.readParcelable(CarInsurance.class.getClassLoader());
        paymentMethod = in.readParcelable(PaymentMethod.class.getClassLoader());
        car_options_array = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(carMake, flags);
        dest.writeParcelable(carColor, flags);
        dest.writeParcelable(carModel, flags);
        dest.writeString(yearStr);
        dest.writeString(carOptionsStr);
        dest.writeParcelable(carCondition, flags);
        dest.writeString(kilometersStr);
        dest.writeParcelable(carTransmission, flags);
        dest.writeParcelable(carFuel, flags);
        dest.writeParcelable(carLicensed, flags);
        dest.writeParcelable(carInsurance, flags);
        dest.writeParcelable(paymentMethod, flags);
        dest.writeStringList(car_options_array);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CarDetailsModel> CREATOR = new Creator<CarDetailsModel>() {
        @Override
        public CarDetailsModel createFromParcel(Parcel in) {
            return new CarDetailsModel(in);
        }

        @Override
        public CarDetailsModel[] newArray(int size) {
            return new CarDetailsModel[size];
        }
    };

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getYearStr() {
        return yearStr;
    }

    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }

    public String getCarOptionsStr() {
        return carOptionsStr;
    }

    public void setCarOptionsStr(String carOptionsStr) {
        this.carOptionsStr = carOptionsStr;
    }

    public CarCondition getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(CarCondition carCondition) {
        this.carCondition = carCondition;
    }

    public String getKilometersStr() {
        return kilometersStr;
    }

    public void setKilometersStr(String kilometersStr) {
        this.kilometersStr = kilometersStr;
    }

    public CarTransmission getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(CarTransmission carTransmission) {
        this.carTransmission = carTransmission;
    }

    public CarFuel getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(CarFuel carFuel) {
        this.carFuel = carFuel;
    }

    public CarLicensed getCarLicensed() {
        return carLicensed;
    }

    public void setCarLicensed(CarLicensed carLicensed) {
        this.carLicensed = carLicensed;
    }

    public CarInsurance getCarInsurance() {
        return carInsurance;
    }

    public void setCarInsurance(CarInsurance carInsurance) {
        this.carInsurance = carInsurance;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<String> getCar_options_array() {
        return car_options_array;
    }

    public void setCar_options_array(ArrayList<String> car_options_array) {
        this.car_options_array = car_options_array;
    }
}
