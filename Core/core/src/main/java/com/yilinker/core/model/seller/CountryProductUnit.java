package com.yilinker.core.model.seller;

import java.util.List;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountryProductUnit {

    private String productId;
    private String productUnitId;
    private String price;
    private String sku;
    private double discount;
    private String commission;
    private int status;//use status instead of isAvailable
    private String weight;
    private String length;
    private String height;
    private String width;
    private List<CountryVariantCombination> variantCombination;
    private String discountedPrice;

    //TODO add combination and combination name


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public List<CountryVariantCombination> getVariantCombination() {
        return variantCombination;
    }

    public void setVariantCombination(List<CountryVariantCombination> variantCombination) {
        this.variantCombination = variantCombination;
    }
}
