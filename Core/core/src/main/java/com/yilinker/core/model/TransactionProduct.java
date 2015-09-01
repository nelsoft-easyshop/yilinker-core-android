package com.yilinker.core.model;

import java.util.List;

/**
 * Created by Patrick on 8/21/2015.
 */
public class TransactionProduct {


    private String productName;
    private double price,totalCost;
    private int quantity;
    private String description,shortDescription;
    private List<String> images;
    private List<TransactionProductAttribute> details;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<TransactionProductAttribute> getDetails() {
        return details;
    }

    public void setDetails(List<TransactionProductAttribute> details) {
        this.details = details;
    }


}
