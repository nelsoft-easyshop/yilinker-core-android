package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/17/2015.
 */
public class ManufacturerProduct {

    private static final String KEY_ID = "id";
    private static final String KEY_MANUFACTURER = "manufacturer";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_IMAGE = "image";

    @SerializedName(KEY_ID)
    private int id;
    @SerializedName(KEY_MANUFACTURER)
    private String manufacturer;
    @SerializedName(KEY_PRODUCT_NAME)
    private String productName;
    @SerializedName(KEY_IMAGE)
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static class ManufacturerProductInstance implements InstanceCreator<ManufacturerProduct> {

        @Override
        public ManufacturerProduct createInstance(Type type) {
            return new ManufacturerProduct();
        }

    }

}
