package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 8/18/2015.
 */
public class ProductCategory {

    private static final String OBJ_NAME = "ProductCategory";
    private static final String KEY_PRODUCTCONDITIONID = "productCategoryId";
    private static final String KEY_NAME = "name";
    private static final String KEY_HAS_CHILDREN = "hasChildren";

    private int productCategoryId;
    private String name, hasChildren;

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public static class ProductCategoryInstance implements InstanceCreator<ProductCategory> {

        @Override
        public ProductCategory createInstance(Type type) {

            return new ProductCategory();
        }
    }
}
