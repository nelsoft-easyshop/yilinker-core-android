package com.yilinker.core.model.seller.request;

import java.util.List;

/**
 * Created by patVillanueva on 5/20/2016.
 */
public class CountryStoreSaveCombination {

    private String productId;
    private String code;
    private List<String> productUnitId;
    private List<String> price;
    private List<String> discountedPrice;
    private List<String> commission;
    private List<String> status;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(List<String> productUnitId) {
        this.productUnitId = productUnitId;
    }

    public List<String> getPrice() {
        return price;
    }

    public void setPrice(List<String> price) {
        this.price = price;
    }

    public List<String> getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(List<String> discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public List<String> getCommission() {
        return commission;
    }

    public void setCommission(List<String> commission) {
        this.commission = commission;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }
}
