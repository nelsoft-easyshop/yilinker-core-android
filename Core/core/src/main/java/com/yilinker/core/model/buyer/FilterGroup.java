package com.yilinker.core.model.buyer;

import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class FilterGroup {

    private int id;
    private String filterName;
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
