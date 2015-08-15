package com.yilinker.core.model;

import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class FilterGroup {

    private int id;
    private String name;
    private List<FilterGroupItem> filterGroupItems;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFilterGroupItems(List<FilterGroupItem> filterGroupItems) {
        this.filterGroupItems = filterGroupItems;
    }

    public List<FilterGroupItem> getFilterGroupItems() {
        return this.filterGroupItems;
    }

}
