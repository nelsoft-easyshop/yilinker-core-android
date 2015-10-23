package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.buyer.AttributeCombination;

import org.json.JSONArray;

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
    private double retailPrice, discountedPrice, length, width, height, weight;
    private String sku;
    private String productUnitId;


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

    public JSONArray getImageIndices(int index) {
        JSONArray array = new JSONArray();
        for (String string:this.images) {
            array.put(index);
            index++;
        }

        return array;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }

    public static class AttributeCombinationUploadInstance implements InstanceCreator<AttributeCombinationUpload> {

        @Override
        public AttributeCombinationUpload createInstance(Type type) {

            return new AttributeCombinationUpload();
        }
    }
}
