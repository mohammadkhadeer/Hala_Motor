package com.cars.halamotor_obeidat.model;

public class CylinderNumber {
    String cylinderNumber,cylinderNumberS;

    public CylinderNumber(String cylinderNumber, String cylinderNumberS) {
        this.cylinderNumber = cylinderNumber;
        this.cylinderNumberS = cylinderNumberS;
    }

    public String getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(String cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public String getCylinderNumberS() {
        return cylinderNumberS;
    }

    public void setCylinderNumberS(String cylinderNumberS) {
        this.cylinderNumberS = cylinderNumberS;
    }
}
