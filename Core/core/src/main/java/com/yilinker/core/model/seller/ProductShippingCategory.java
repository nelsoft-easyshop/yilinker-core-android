package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/12/16.
 */
public class ProductShippingCategory {

    @SerializedName("shippingCategoryId")
    private int id;
    @SerializedName("name")
    private String name;

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

    public static class ProductShippingCategoryInstance implements InstanceCreator<ProductShippingCategory> {

        @Override
        public ProductShippingCategory createInstance(Type type) {
            return new ProductShippingCategory();
        }

    }

}
