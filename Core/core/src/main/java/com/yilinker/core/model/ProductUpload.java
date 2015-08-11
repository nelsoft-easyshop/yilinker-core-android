package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 8/7/2015.
 */
public class ProductUpload {

    private static final String OBJ_NAME = "ProductUpload";
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_FULL_DESCRIPTION = "fullDescription";
    private static final String KEY_SELLER_ID = "sellerId";
    private static final String KEY_ATTRIBUTES = "attributes";
    private static final String KEY_AVAILABLE_ATTRIBUTES = "availableAttributeCombi";
    private static final String KEY_ORIGINAL_PRICE = "originalPrice";
    private static final String KEY_NEW_PRICE = "newPrice";
    private static final String KEY_DISCOUNT = "discount";

    private int id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private int sellerId;
    private List<String> images;
    private List<ProductGroupAttribute> attributes;
    private List<AttributeCombination> availableAttributeCombi;
    private double originalPrice;
    private double newPrice;
    private double discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public List<ProductGroupAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductGroupAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<AttributeCombination> getAvailableAttributeCombi() {
        return availableAttributeCombi;
    }

    public void setAvailableAttributeCombi(List<AttributeCombination> availableAttributeCombi) {
        this.availableAttributeCombi = availableAttributeCombi;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public static class ProductUploadInstance implements InstanceCreator<ProductUpload> {

        @Override
        public ProductUpload createInstance(Type type) {

            return new ProductUpload();
        }
    }
}
