package com.cars.halamotor_obeidat.model;

public class City {
    String id,code,name,name_en,name_ar;

    public City(String id, String code, String name, String name_en, String name_ar) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.name_en = name_en;
        this.name_ar = name_ar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
