package com.yilinker.core.model.buyer.home;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.HomeAPIConstants;

import java.util.List;

/**
 * Created by jaybryantc on 7/5/16.
 */
public class SellerHomeData extends HomeData {

    private String name;
    private String specialty;
    @SerializedName(HomeAPIConstants.KEY_DATA)
    private List<ProductHomeData> products;
    private String image;
    private String thumbnail;
    private String small;
    private String medium;
    private String large;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<ProductHomeData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductHomeData> products) {
        this.products = products;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public HomeTarget getTarget() {
        return target;
    }

    @Override
    public void setTarget(HomeTarget target) {
        this.target = target;
    }
}
