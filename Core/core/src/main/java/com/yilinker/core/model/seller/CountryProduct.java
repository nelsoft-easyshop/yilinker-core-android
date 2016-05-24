package com.yilinker.core.model.seller;

import com.yilinker.core.model.buyer.ProductImages;

import java.util.List;

/**
 * Created by patVillanueva on 5/17/2016.
 */
public class CountryProduct {

    private String id;
    private String title;
    private List<ProductImages> images;
    private String shortDescription;
    private String brand;
    private String category;
    private List<CountryProductUnit> productUnits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<CountryProductUnit> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(List<CountryProductUnit> productUnits) {
        this.productUnits = productUnits;
    }

}
