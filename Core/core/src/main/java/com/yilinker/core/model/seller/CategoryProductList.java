package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Bryan on 9/2/2015.
 */
public class CategoryProductList {

    private List<CategoryProducts> products;

    public List<CategoryProducts> getProducts() {
        return products;
    }

    public void setProducts(List<CategoryProducts> products) {
        this.products = products;
    }

    public static class ProductMangementInstance implements InstanceCreator<CategoryProductList> {
        @Override
        public CategoryProductList createInstance(Type type) {
            return new CategoryProductList();
        }
    }
}
