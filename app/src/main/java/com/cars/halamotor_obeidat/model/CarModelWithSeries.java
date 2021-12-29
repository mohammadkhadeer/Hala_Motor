package com.cars.halamotor_obeidat.model;

public class CarModelWithSeries {
    String seriesStr,carModelStr;
    public CarModelWithSeries(String seriesStr,String carModelStr)
    {
        this.seriesStr=seriesStr;
        this.carModelStr=carModelStr;
    }

    public String getSeriesStr() {
        return seriesStr;
    }

    public void setSeriesStr(String seriesStr) {
        this.seriesStr = seriesStr;
    }

    public String getCarModelStr() {
        return carModelStr;
    }

    public void setCarModelStr(String carModelStr) {
        this.carModelStr = carModelStr;
    }
}
