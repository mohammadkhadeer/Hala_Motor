package com.cars.halamotor.model;

public class Area {
    String id,name,name_en,name_ar;
    City city;

    public Area(String id, String name, String name_en, String name_ar, City city) {
        this.id = id;
        this.name = name;
        this.name_en = name_en;
        this.name_ar = name_ar;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
