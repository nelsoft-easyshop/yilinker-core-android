package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeProductItems {

    private static final String OBJ_NAME = "HomeProductItems";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_ORIGINAL_PRICE = "originalPrice";
    private static final String KEY_DISCOUNTED_PRICE = "discountedPrice";
    private static final String KEY_DISCOUNTED_PERCENTAGE = "discountedPercentage";
    private static final String KEY_TARGET = "target";

    private String productName;
    private String image;
    private double originalPrice;
    private double discountedPrice;
    private int discountedPercentage;
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

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public int getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(int discountedPercentage) {
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
        return OBJ_NAME + "[" + KEY_PRODUCT_NAME + productName + ", " + KEY_IMAGE + image + ", " + KEY_ORIGINAL_PRICE + originalPrice + ", " + KEY_DISCOUNTED_PRICE + discountedPrice + ", " + KEY_DISCOUNTED_PERCENTAGE + discountedPercentage + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeProductItemsInstance implements InstanceCreator<HomeProductItems> {

        @Override
        public HomeProductItems createInstance(Type type) {

            return new HomeProductItems();
        }
    }

}