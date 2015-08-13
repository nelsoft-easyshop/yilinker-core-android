package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class ProductList {

    private List<Product> products;
    private int totalResultCount;
    private List<FilterGroup> filterGroupList;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public List<FilterGroup> getFilterGroupList() {
        return filterGroupList;
    }

    public void setFilterGroupList(List<FilterGroup> filterGroupList) {
        this.filterGroupList = filterGroupList;
    }

    public static class ProductListInstance implements InstanceCreator<ProductList> {

        @Override
        public ProductList createInstance(Type type) {

            return new ProductList();
        }
    }
}
