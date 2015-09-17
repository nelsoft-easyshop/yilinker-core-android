package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.buyer.AttributeCombination;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Jay Bryant Casilang on 8/13/2015.
 */
public class AttributeCombinationUpload extends AttributeCombination {

    private static final String KEY_COMBINATION = "combination";
    private static final String KEY_RETAIL_PRICE = "retail price";
    private static final String KEY_DISCOUNTED_PRICE = "discounted price";

    private List<String> combinationList, images;
    private int quantity;
    private double retailPrice, discountedPrice;
    private String sku;


    public List<String> getCombinationList() {
        return combinationList;
    }

    public void setCombinationList(List<String> combinationList) {
        this.combinationList = combinationList;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public List<String> getImages() {
        return images;
    }

    @Override
    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public static class AttributeCombinationUploadInstance implements InstanceCreator<AttributeCombinationUpload> {

        @Override
        public AttributeCombinationUpload createInstance(Type type) {

            return new AttributeCombinationUpload();
        }
    }
}
