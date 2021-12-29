package com.cars.halamotor_obeidat.model;

public class CityModel {
    String city,cityS,cityAr;

    public CityModel(String city, String cityS, String cityAr) {
        this.city = city;
        this.cityS = cityS;
        this.cityAr = cityAr;
    }

    public String getCityAr() {
        return cityAr;
    }

    public void setCityAr(String cityAr) {
        this.cityAr = cityAr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityS() {
        return cityS;
    }

    public void setCityS(String cityS) {
        this.cityS = cityS;
    }
}
