package com.yilinker.core.model.seller.request;

import java.util.HashMap;

/**
 * Created by J.Bautista on 5/11/16.
 */
public class WarehouseProductFilter {

    private int warehouseId;
    private int pageId;
    private HashMap<String, Integer[]> filter;
    private String query;/***for searched product*/

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public HashMap<String, Integer[]> getFilter() {
        return filter;
    }

    public void setFilter(HashMap<String, Integer[]> filter) {
        this.filter = filter;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
