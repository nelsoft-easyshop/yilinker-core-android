package com.yilinker.core.model.buyer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Patrick on 9/17/2015.
 */
public class Aggregation {

    @SerializedName("maxPrice")
    private double maxPrice;
    @SerializedName("minPrice")
    private double minPrice;
    @SerializedName("attributes")
    private List<FilterGroup> filterGroups;

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public List<FilterGroup> getFilterGroups() {
        return filterGroups;
    }

    public void setFilterGroups(List<FilterGroup> filterGroups) {
        this.filterGroups = filterGroups;
    }

}
