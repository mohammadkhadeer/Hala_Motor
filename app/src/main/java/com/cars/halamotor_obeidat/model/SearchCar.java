package com.cars.halamotor_obeidat.model;

public class SearchCar {
    String image,category,categoryS,carMake,carMakeS,carModel,carModelS;

    public SearchCar(String image, String category, String categoryS, String carMake, String carMakeS, String carModel, String carModelS) {
        this.image = image;
        this.category = category;
        this.categoryS = categoryS;
        this.carMake = carMake;
        this.carMakeS = carMakeS;
        this.carModel = carModel;
        this.carModelS = carModelS;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryS() {
        return categoryS;
    }

    public void setCategoryS(String categoryS) {
        this.categoryS = categoryS;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarMakeS() {
        return carMakeS;
    }

    public void setCarMakeS(String carMakeS) {
        this.carMakeS = carMakeS;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModelS() {
        return carModelS;
    }

    public void setCarModelS(String carModelS) {
        this.carModelS = carModelS;
    }
}
