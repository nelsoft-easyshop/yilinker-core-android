package com.yilinker.core.model.buyer;

import java.util.List;

/**
 * Created by Patrick on 9/17/2015.
 */
public class Aggregation {

    private int maxPrice,minPrice;

    private List<FilterGroup> attributes;

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public List<FilterGroup> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<FilterGroup> attributes) {
        this.attributes = attributes;
    }
}
