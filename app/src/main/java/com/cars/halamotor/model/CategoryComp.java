package com.cars.halamotor.model;

public class CategoryComp {
    int imageIdInt;
    String id,code,name,name_en,name_ar;

    public CategoryComp(int imageIdInt, String id, String code, String name, String name_en, String name_ar) {
        this.imageIdInt = imageIdInt;
        this.id = id;
        this.code = code;
        this.name = name;
        this.name_en = name_en;
        this.name_ar = name_ar;
    }

    public int getImageIdInt() {
        return imageIdInt;
    }

    public void setImageIdInt(int imageIdInt) {
        this.imageIdInt = imageIdInt;
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
