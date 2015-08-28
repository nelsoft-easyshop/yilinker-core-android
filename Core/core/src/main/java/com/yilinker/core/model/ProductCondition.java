package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 8/18/2015.
 */
public class ProductCondition {

    private static final String OBJ_NAME = "ProductCondition";
    private static final String KEY_PRODUCTCONDITIONID = "productConditionId";
    private static final String KEY_NAME = "name";

    private int productConditionId;
    private String name;

    public int getProductConditionId() {
        return productConditionId;
    }

    public void setProductConditionId(int productConditionId) {
        this.productConditionId = productConditionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ProductConditionInstance implements InstanceCreator<ProductCondition> {

        @Override
        public ProductCondition createInstance(Type type) {

            return new ProductCondition();
        }
    }
}
