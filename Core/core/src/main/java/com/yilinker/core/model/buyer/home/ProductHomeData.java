package com.yilinker.core.model.buyer.home;

/**
 * Created by jaybryantc on 7/5/16.
 */
public class ProductHomeData extends HomeData {

    private int productId;
    private int productUnitId;
    private String name;
    private String originalPrice;
    private String discountedPrice;
    private String discountedPercentage;
    private String currency;
    private String image;
    private String thumbnail;
    private String small;
    private String medium;
    private String large;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(int productUnitId) {
        this.productUnitId = productUnitId;
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

    public String getDiscountedPercentage() {
        return discountedPercentage;
    }

    public void setDiscountedPercentage(String discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
