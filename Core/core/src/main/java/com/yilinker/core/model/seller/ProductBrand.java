package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/11/16.
 */
public class ProductBrand {

    @SerializedName("brandId")
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

    public static class BrandInstance implements InstanceCreator<ProductBrand> {

        @Override
        public ProductBrand createInstance(Type type) {
            return new ProductBrand();
        }

    }

}
