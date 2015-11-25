package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 11/25/2015.
 */
public class Product {

    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_NAME)
    private String name;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_ORIGINAL_PRICE)
    private String originalPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PRICE)
    private String discountedPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PERCENTAGE)
    private String discountedPercentage;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_CURRENCY)
    private String currency;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_IMAGE)
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(String discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static class ProductInstance implements InstanceCreator<Product> {

        @Override
        public Product createInstance(Type type) {
            return new Product();
        }
    }
}