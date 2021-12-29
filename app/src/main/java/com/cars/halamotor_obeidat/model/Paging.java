package com.cars.halamotor_obeidat.model;

public class Paging {
    int numberOfItems;
    boolean isLastPage,isLoading;

    public Paging(int numberOfItems, boolean isLastPage, boolean isLoading) {
        this.numberOfItems = numberOfItems;
        this.isLastPage = isLastPage;
        this.isLoading = isLoading;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}
