package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Jay Bryant Casilang on 8/13/2015.
 */
public class ProductUpload {

    private final static String OBJ_NAME = "ProductUpload";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_FULL_DESCRIPTION = "fullDescription";
    private static final String KEY_SELLER_ID = "sellerId";
    private static final String KEY_ATTRIBUTES = "attributes";
    private static final String KEY_AVAILABLE_ATTRIBUTES = "availableAttributeCombi";
    private static final String KEY_ORIGINAL_PRICE = "originalPrice";
    private static final String KEY_NEW_PRICE = "newPrice";
    private static final String KEY_LENGTH = "length";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_CONDITION = "condition";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_CATEGORY = "category";

    private int sellerId;
    private List<String> images;
    private String title, shortDescription, fullDescription, condition, brand,category;
    private double originalPrice, newPrice,length, weight, height, width;
    private List<ProductGroupAttribute> productGroupAttributeList;
    private List<AttributeCombinationUpload> attributeCombinationUploadList;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public List<ProductGroupAttribute> getProductGroupAttributeList() {
        return productGroupAttributeList;
    }

    public void setProductGroupAttributeList(List<ProductGroupAttribute> productGroupAttributeList) {
        this.productGroupAttributeList = productGroupAttributeList;
    }

    public List<AttributeCombinationUpload> getAttributeCombinationUploadList() {
        return attributeCombinationUploadList;
    }

    public void setAttributeCombinationUploadList(List<AttributeCombinationUpload> attributeCombinationUploadList) {
        this.attributeCombinationUploadList = attributeCombinationUploadList;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGES + images + "," + KEY_TITLE + title + "," + KEY_SHORT_DESCRIPTION + shortDescription + ","
                + KEY_FULL_DESCRIPTION + fullDescription + "," + KEY_SELLER_ID + sellerId + ","
                + KEY_ORIGINAL_PRICE + originalPrice + "," + KEY_NEW_PRICE + newPrice + ","
                + KEY_LENGTH + length + ","  + KEY_WEIGHT + weight + ","
                + KEY_WIDTH + width + "," + KEY_HEIGHT + height + ","
                + KEY_CONDITION + condition + "," + KEY_BRAND + brand + "]" ;
    }

    public static class ProductUploadInstance implements InstanceCreator<ProductUpload> {
        @Override
        public ProductUpload createInstance(Type type) {
            return new ProductUpload();
        }
    }
}
