package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeProductItems {

    private static final String OBJ_NAME = "HomeProductItems";
    private static final String KEY_PRODUCT_ID = "productId";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_ORIGINAL_PRICE = "originalPrice";
    private static final String KEY_DISCOUNTED_PRICE = "discountedPrice";
    private static final String KEY_DISCOUNTED_PERCENTAGE = "discountedPercentage";
    private static final String KEY_TARGET = "target";

    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    private String productName;
    private String image;
    private String originalPrice;
    private String discountedPrice;
    private double discountedPercentage;
    private String target;

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

    public double getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(double discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_PRODUCT_ID + productId + ", " + KEY_PRODUCT_NAME + productName + ", " + KEY_IMAGE + image + ", " + KEY_ORIGINAL_PRICE + originalPrice + ", " + KEY_DISCOUNTED_PRICE + discountedPrice + ", " + KEY_DISCOUNTED_PERCENTAGE + discountedPercentage + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeProductItemsInstance implements InstanceCreator<HomeProductItems> {

        @Override
        public HomeProductItems createInstance(Type type) {

            return new HomeProductItems();
        }
    }

}