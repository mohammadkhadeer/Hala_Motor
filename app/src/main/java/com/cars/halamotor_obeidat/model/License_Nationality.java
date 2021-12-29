package com.cars.halamotor_obeidat.model;

public class License_Nationality {
    String licenseNationality,licenseNationalityS;

    public License_Nationality(String licenseNationality, String licenseNationalityS) {
        this.licenseNationality = licenseNationality;
        this.licenseNationalityS = licenseNationalityS;
    }

    public String getLicenseNationality() {
        return licenseNationality;
    }

    public void setLicenseNationality(String licenseNationality) {
        this.licenseNationality = licenseNationality;
    }

    public String getLicenseNationalityS() {
        return licenseNationalityS;
    }

    public void setLicenseNationalityS(String licenseNationalityS) {
        this.licenseNationalityS = licenseNationalityS;
    }
}
