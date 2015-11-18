package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 8/25/15.
 */
public class AttributeCombination2 {

    private String productUnitId;
    private int[] combination;
    private String[] combinationNames;
    private int quantity;
    private List<String> imageIds = new ArrayList<String>();

    private String price;
    private String discountedPrice;
    private double discount;

    private String primaryImage;

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }


    public String getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(String productUnitId) {
        this.productUnitId = productUnitId;
    }

    public int[] getCombination() {
        return combination;
    }

    public void setCombination(int[] combination) {
        this.combination = combination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<String> imageIds) {
        this.imageIds = imageIds;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String[] getCombinationNames() {
        return combinationNames;
    }

    public void setCombinationNames(String[] combinationNames) {
        this.combinationNames = combinationNames;
    }

    public static class AttributeCombination2Instance implements InstanceCreator<AttributeCombination2>{

        @Override
        public AttributeCombination2 createInstance(Type type) {
            return new AttributeCombination2();
        }
    }
}
