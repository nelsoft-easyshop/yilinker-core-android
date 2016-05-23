package com.yilinker.core.model.seller.request;

/**
 * Created by jaybryantc on 5/19/16.
 */
public class ProductTranslation {

    private int id;
    private String productName;
    private String shortDescription;
    private String completeDescription;
    private String brand;
    private String productImages;
    private String productGroups;
    private String productVariants;
    private String countryCode;
    private String languageCode;

    public ProductTranslation() {

    }

    public ProductTranslation(int id, String productName, String shortDescription, String completeDescription,
                              String brand, String productImages, String productGroups, String productVariants) {

        this.id = id;
        this.productName = productName;
        this.shortDescription = shortDescription;
        this.completeDescription = completeDescription;
        this.brand = brand;
        this.productImages = productImages;
        this.productGroups = productGroups;
        this.productVariants = productVariants;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCompleteDescription() {
        return completeDescription;
    }

    public void setCompleteDescription(String completeDescription) {
        this.completeDescription = completeDescription;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public String getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(String productVariants) {
        this.productVariants = productVariants;
    }

    public String getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(String productGroups) {
        this.productGroups = productGroups;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
