package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 8/13/2015.
 */
public class ProductList {

    private static final String OBJ_NAME = "CategoryProductList";
    private static final String KEY_PRODUCT_ITEM = "products";

    private List<ProductListItem> products;
    private int totalResultCount;

    public List<ProductListItem> getProducts() {
        return products;
    }

    public void setProducts(List<ProductListItem> products) {
        this.products = products;
    }

    public int getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(int totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_PRODUCT_ITEM + products+ "]";
    }

    public static class ProductListInstance implements InstanceCreator<ProductList> {

        @Override
        public ProductList createInstance(Type type) {

            return new ProductList();
        }
    }
}
