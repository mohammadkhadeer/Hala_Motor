package com.cars.halamotor_obeidat.model;

public class CarMakeAndCarModel {
    String carMakeStr,CarMakeSStr,carModelStr,carModelSStr;

    public CarMakeAndCarModel(String carMakeStr, String carMakeSStr, String carModelStr, String carModelSStr) {
        this.carMakeStr = carMakeStr;
        CarMakeSStr = carMakeSStr;
        this.carModelStr = carModelStr;
        this.carModelSStr = carModelSStr;
    }

    public String getCarMakeStr() {
        return carMakeStr;
    }

    public void setCarMakeStr(String carMakeStr) {
        this.carMakeStr = carMakeStr;
    }

    public String getCarMakeSStr() {
        return CarMakeSStr;
    }

    public void setCarMakeSStr(String carMakeSStr) {
        CarMakeSStr = carMakeSStr;
    }

    public String getCarModelStr() {
        return carModelStr;
    }

    public void setCarModelStr(String carModelStr) {
        this.carModelStr = carModelStr;
    }

    public String getCarModelSStr() {
        return carModelSStr;
    }

    public void setCarModelSStr(String carModelSStr) {
        this.carModelSStr = carModelSStr;
    }
}
