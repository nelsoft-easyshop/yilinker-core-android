package com.yilinker.core.model.buyer;

import java.util.List;

/**
 * Created by Patrick on 9/17/2015.
 */
public class Aggregation {

    private double maxPrice,minPrice;

    private List<FilterGroup> attributes;

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

    public List<FilterGroup> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FilterGroup> attributes) {
        this.attributes = attributes;
    }
}
