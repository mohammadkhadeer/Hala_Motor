package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SimilarNeeded implements Parcelable {
    double priceFrom,priceTo;
    String carMake,carModel,city,neighborhood,wheelsType,carPlatesCity;
    int wheelsSize;

    public SimilarNeeded(double priceFrom, double priceTo, String carMake, String carModel, String city, String neighborhood, String wheelsType, String carPlatesCity, int wheelsSize) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.carMake = carMake;
        this.carModel = carModel;
        this.city = city;
        this.neighborhood = neighborhood;
        this.wheelsType = wheelsType;
        this.carPlatesCity = carPlatesCity;
        this.wheelsSize = wheelsSize;
    }

    protected SimilarNeeded(Parcel in) {
        priceFrom = in.readDouble();
        priceTo = in.readDouble();
        carMake = in.readString();
        carModel = in.readString();
        city = in.readString();
        neighborhood = in.readString();
        wheelsType = in.readString();
        carPlatesCity = in.readString();
        wheelsSize = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(priceFrom);
        dest.writeDouble(priceTo);
        dest.writeString(carMake);
        dest.writeString(carModel);
        dest.writeString(city);
        dest.writeString(neighborhood);
        dest.writeString(wheelsType);
        dest.writeString(carPlatesCity);
        dest.writeInt(wheelsSize);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SimilarNeeded> CREATOR = new Creator<SimilarNeeded>() {
        @Override
        public SimilarNeeded createFromParcel(Parcel in) {
            return new SimilarNeeded(in);
        }

        @Override
        public SimilarNeeded[] newArray(int size) {
            return new SimilarNeeded[size];
        }
    };

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getWheelsType() {
        return wheelsType;
    }

    public void setWheelsType(String wheelsType) {
        this.wheelsType = wheelsType;
    }

    public String getCarPlatesCity() {
        return carPlatesCity;
    }

    public void setCarPlatesCity(String carPlatesCity) {
        this.carPlatesCity = carPlatesCity;
    }

    public int getWheelsSize() {
        return wheelsSize;
    }

    public void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }
}
