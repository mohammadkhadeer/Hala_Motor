package com.cars.halamotor_obeidat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Neighborhood implements Parcelable {
    private String neighborhood,neighborhoodS,neighborhoodAr;

    public static Creator<Neighborhood> getCREATOR() {
        return CREATOR;
    }

    public Neighborhood(Parcel in) {
        neighborhood = in.readString();
        neighborhoodS = in.readString();
        neighborhoodAr = in.readString();
    }

    public String getNeighborhoodAr() {
        return neighborhoodAr;
    }

    public void setNeighborhoodAr(String neighborhoodAr) {
        this.neighborhoodAr = neighborhoodAr;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String type) {
        this.neighborhood = type;
    }

    public String getNeighborhoodS() {
        return neighborhoodS;
    }

    public void setNeighborhoodS(String type) {
        this.neighborhoodS = type;
    }

    public Neighborhood(String neighborhood,String neighborhoodS,String neighborhoodAr) {
        this.neighborhood = neighborhood;
        this.neighborhoodS = neighborhoodS;
        this.neighborhoodAr = neighborhoodAr;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(neighborhood);
        dest.writeString(neighborhoodS);
        dest.writeString(neighborhoodAr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Neighborhood> CREATOR = new Creator<Neighborhood>() {
        @Override
        public Neighborhood createFromParcel(Parcel in) {
            return new Neighborhood(in);
        }

        @Override
        public Neighborhood[] newArray(int size) {
            return new Neighborhood[size];
        }
    };
}
