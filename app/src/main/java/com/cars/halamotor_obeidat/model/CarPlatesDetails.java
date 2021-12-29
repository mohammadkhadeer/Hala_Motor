package com.cars.halamotor_obeidat.model;

public class CarPlatesDetails {
    String carPlatesCity,carPlatesNumber;
    int specialOrNot;

    public CarPlatesDetails(String carPlatesCity, String carPlatesNumber, int specialOrNot) {
        this.carPlatesCity = carPlatesCity;
        this.carPlatesNumber = carPlatesNumber;
        this.specialOrNot = specialOrNot;
    }

    public String getCarPlatesCity() {
        return carPlatesCity;
    }

    public void setCarPlatesCity(String carPlatesCity) {
        this.carPlatesCity = carPlatesCity;
    }

    public String getCarPlatesNumber() {
        return carPlatesNumber;
    }

    public void setCarPlatesNumber(String carPlatesNumber) {
        this.carPlatesNumber = carPlatesNumber;
    }

    public int getSpecialOrNot() {
        return specialOrNot;
    }

    public void setSpecialOrNot(int specialOrNot) {
        this.specialOrNot = specialOrNot;
    }
}
