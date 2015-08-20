package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 8/18/2015.
 */
public class ProductBrand {

    private static final String OBJ_NAME = "ProductBrand";
    private static final String KEY_PRODUCTCONDITIONID = "brandId";
    private static final String KEY_NAME = "name";

    private int brandId;
    private String name;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class ProductBrandInstance implements InstanceCreator<ProductBrand> {

        @Override
        public ProductBrand createInstance(Type type) {

            return new ProductBrand();
        }
    }
}
