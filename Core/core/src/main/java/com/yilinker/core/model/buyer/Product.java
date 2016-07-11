package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class Product {

    private static final String OBJ_NAME = "Product";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_FULL_DESCRIPTION = "fullDescription";
    private static final String KEY_SELLER_ID = "sellerId";
    private static final String KEY_ATTRIBUTES = "attributes";
    private static final String KEY_AVAILABLE_ATTRIBUTES = "productUnits";
    private static final String KEY_ORIGINAL_PRICE = "originalPrice";
    private static final String KEY_NEW_PRICE = "newPrice";
    private static final String KEY_DISCOUNT = "discount";

    private int id;
    private String productName;
    private String title;
    private String image;
    private List<ProductImages> images;
    private String shortDescription;
    private String fullDescription;
    private String slug;

    private int sellerId;
    private List<ProductGroupAttribute> attributes;
//    private List<AttributeCombination> productUnits;
    private List<AttributeCombination2> productUnits;
//    private double originalPrice;
//    private double newPrice;
//    private double discount;
    /***for seller list*/
    private String name;
    private String productId;
    private String imageUrl;
    private boolean hasCOD;
    private boolean isInternationalWarehouse;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName(){
        return  productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductName(String productName){
        this.productName = productName;
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



    //    public List<AttributeCombination> getAvailableAttributeCombi() {
//        return productUnits;
//    }
//
//    public void setAvailableAttributeCombi(List<AttributeCombination> productUnits) {
//        this.productUnits = productUnits;
//    }

    public List<AttributeCombination2> getAvailableAttributeCombi() {
        return productUnits;
    }

    public void setAvailableAttributeCombi(List<AttributeCombination2> productUnits) {
        this.productUnits = productUnits;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean isHasCOD() {
        return hasCOD;
    }

    public void setHasCOD(boolean hasCOD) {
        this.hasCOD = hasCOD;
    }

    public boolean isInternationalWarehouse() {
        return isInternationalWarehouse;
    }

    public void setInternationalWarehouse(boolean internationalWarehouse) {
        isInternationalWarehouse = internationalWarehouse;
    }

    //    public double getOriginalPrice() {
//        return originalPrice;
//    }
//
//    public void setOriginalPrice(double originalPrice) {
//        this.originalPrice = originalPrice;
//    }
//
//    public double getNewPrice() {
//        return newPrice;
//    }
//
//    public void setNewPrice(double newPrice) {
//        this.newPrice = newPrice;
//    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }

//    @Override
//    public String toString() {
//        return OBJ_NAME + KEY_ID + id + KEY_TITLE + title + KEY_SHORT_DESCRIPTION + shortDescription + KEY_FULL_DESCRIPTION + fullDescription + KEY_SELLER_ID + sellerId + KEY_ATTRIBUTES + attributes + KEY_AVAILABLE_ATTRIBUTES + productUnits + KEY_ORIGINAL_PRICE + originalPrice + KEY_NEW_PRICE + newPrice + KEY_DISCOUNT + discount;
//    }

    public static class ProductInstance implements InstanceCreator<Product> {

    @Override
    public Product createInstance(Type type) {

        return new Product();
    }
}
}