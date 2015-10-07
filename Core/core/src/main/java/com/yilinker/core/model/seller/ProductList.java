package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 9/3/2015.
 */
public class ProductList {

    private List<Products> products;

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public static class ProductListInstance implements InstanceCreator<ProductList> {
        @Override
        public ProductList createInstance(Type type) {
            return new ProductList();
        }
    }
}