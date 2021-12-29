package com.cars.halamotor_obeidat.model;

public class Nationality {
    String nationality,nationalityS;

    public Nationality(String nationality, String nationalityS) {
        this.nationality = nationality;
        this.nationalityS = nationalityS;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityS() {
        return nationalityS;
    }

    public void setNationalityS(String nationalityS) {
        this.nationalityS = nationalityS;
    }
}
