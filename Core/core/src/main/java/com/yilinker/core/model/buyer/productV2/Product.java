package com.yilinker.core.model.buyer.productV2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Product {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("slug")
    private String slug;
    @SerializedName("image")
    private String image;
    @SerializedName("raw")
    private String raw;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("small")
    private String small;
    @SerializedName("medium")
    private String medium;
    @SerializedName("large")
    private String large;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("fullDescription")
    private String fullDescription;
    @SerializedName("shippingCost")
    private String shippingCost;

    @SerializedName("status")
    private int status;
    @SerializedName("sellerId")
    private int sellerId;
    @SerializedName("storeId")
    private int storeId;
    @SerializedName("brandId")
    private int brandId;
    @SerializedName("productCategoryId")
    private int productCategoryId;

    @SerializedName("isAffiliate")
    private boolean isAffiliate;
    @SerializedName("hasCOD")
    private boolean hasCOD;
    @SerializedName("isInternationalWarehouse")
    private boolean isInternationalWarehouse;

    @SerializedName("dateCreated")
    private Date dateCreated;
    @SerializedName("dateLastModified")
    private Date dateLastModified;

    @SerializedName("images")
    private List<Images> images;
    @SerializedName("attributes")
    private List<Attributes> attributes;
    @SerializedName("productUnits")
    private List<ProductUnits> productUnits;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
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

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public boolean isAffiliate() {
        return isAffiliate;
    }

    public void setAffiliate(boolean affiliate) {
        isAffiliate = affiliate;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }

    public List<ProductUnits> getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(List<ProductUnits> productUnits) {
        this.productUnits = productUnits;
    }

    public static class ProductInstance implements InstanceCreator<Product> {

        @Override
        public Product createInstance(Type type) {

            return new Product();

        }

    }

}
