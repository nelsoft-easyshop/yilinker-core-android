package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 02/12/2015.
 */
public class HomeData {

    @SerializedName(APIConstants.API_HOME_V2_IMAGE)
    private String image;
    @SerializedName(APIConstants.API_HOME_V2_THUMBNAIL)
    private String thumbnail;
    @SerializedName(APIConstants.API_HOME_V2_LARGE)
    private String large;
    @SerializedName(APIConstants.API_HOME_V2_MEDIUM)
    private String medium;
    @SerializedName(APIConstants.API_HOME_V2_SMALL)
    private String small;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;
    @SerializedName(APIConstants.API_HOME_V2_NAME)
    private String name;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_ORIGINAL_PRICE)
    private String originalPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PRICE)
    private String discountedPrice;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_DISCOUNTED_PERCENTAGE)
    private String discountPercentage;
    @SerializedName(APIConstants.API_HOME_V2_PRODUCT_CURRENCY)
    private String currency;
    @SerializedName(APIConstants.API_HOME_V2_STORE_SPECIALTY)
    private String specialty;
    @SerializedName(APIConstants.API_HOME_V2_STORE_TOP_PRODUCT)
    private List<TopProducts> topProducts = new ArrayList<>();


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<TopProducts> getTopProducts() {
        return topProducts;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public void setTopProducts(List<TopProducts> topProducts) {
        this.topProducts = topProducts;
    }

    public static class HomeDataInstance implements InstanceCreator<HomeData> {

        @Override
        public HomeData createInstance(Type type) {

            return new HomeData();
        }
    }

}
