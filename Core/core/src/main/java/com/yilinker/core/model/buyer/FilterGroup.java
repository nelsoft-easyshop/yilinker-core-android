package com.yilinker.core.model.buyer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class FilterGroup {

    @SerializedName("id")
    private int id;
    @SerializedName("filterName")
    private String filterName;
    @SerializedName("filterItems")
    private List<String> filterItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public List<String> getFilterItems() {
        return filterItems;
    }

    public void setFilterItems(List<String> filterItems) {
        this.filterItems = filterItems;
    }
}
