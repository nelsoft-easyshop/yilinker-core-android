package com.yilinker.core.model.buyer.productV2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class ProductUnits {

    @SerializedName("productId")
    private String productId;
    @SerializedName("productUnitId")
    private String productUnitId;
    @SerializedName("sku")
    private String sku;
    @SerializedName("slug")
    private String slug;
    @SerializedName("price")
    private String price;
    @SerializedName("discountedPrice")
    private String discountedPrice;
    @SerializedName("appliedBaseDiscountPrice")
    private String appliedBaseDiscountPrice;
    @SerializedName("appliedDiscountPrice")
    private String appliedDiscountPrice;
    @SerializedName("primaryImage")
    private String primaryImage;
    @SerializedName("primaryThumbnailImage")
    private String primaryThumbnailImage;
    @SerializedName("primarySmallImage")
    private String primarySmallImage;
    @SerializedName("primaryMediumImage")
    private String primaryMediumImage;
    @SerializedName("primaryLargeImage")
    private String primaryLargeImage;
    @SerializedName("commission")
    private String commission;
    @SerializedName("weight")
    private String weight;
    @SerializedName("length")
    private String length;
    @SerializedName("height")
    private String height;
    @SerializedName("width")
    private String width;

    @SerializedName("quantity")
    private int quantity;
    @SerializedName("status")
    private int status;

    @SerializedName("discount")
    private double discount;

    @SerializedName("inWishlist")
    private boolean inWishList;

    @SerializedName("dateCreated")
    private Date dateCreated;
    @SerializedName("dateLastModified")
    private Date dateLastModified;

    @SerializedName("imageIds")
    private List<String> imageIds;
    @SerializedName("combination")
    private List<String> combination;
    @SerializedName("combinationNames")
    private List<String> combinationNames;
    @SerializedName("variantCombination")
    private List<VariantCombination> variantCombination;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getAppliedBaseDiscountPrice() {
        return appliedBaseDiscountPrice;
    }

    public void setAppliedBaseDiscountPrice(String appliedBaseDiscountPrice) {
        this.appliedBaseDiscountPrice = appliedBaseDiscountPrice;
    }

    public String getAppliedDiscountPrice() {
        return appliedDiscountPrice;
    }

    public void setAppliedDiscountPrice(String appliedDiscountPrice) {
        this.appliedDiscountPrice = appliedDiscountPrice;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public String getPrimaryThumbnailImage() {
        return primaryThumbnailImage;
    }

    public void setPrimaryThumbnailImage(String primaryThumbnailImage) {
        this.primaryThumbnailImage = primaryThumbnailImage;
    }

    public String getPrimarySmallImage() {
        return primarySmallImage;
    }

    public void setPrimarySmallImage(String primarySmallImage) {
        this.primarySmallImage = primarySmallImage;
    }

    public String getPrimaryMediumImage() {
        return primaryMediumImage;
    }

    public void setPrimaryMediumImage(String primaryMediumImage) {
        this.primaryMediumImage = primaryMediumImage;
    }

    public String getPrimaryLargeImage() {
        return primaryLargeImage;
    }

    public void setPrimaryLargeImage(String primaryLargeImage) {
        this.primaryLargeImage = primaryLargeImage;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isInWishList() {
        return inWishList;
    }

    public void setInWishList(boolean inWishList) {
        this.inWishList = inWishList;
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

    public List<String> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<String> imageIds) {
        this.imageIds = imageIds;
    }

    public List<String> getCombination() {
        return combination;
    }

    public void setCombination(List<String> combination) {
        this.combination = combination;
    }

    public List<String> getCombinationNames() {
        return combinationNames;
    }

    public void setCombinationNames(List<String> combinationNames) {
        this.combinationNames = combinationNames;
    }

    public List<VariantCombination> getVariantCombination() {
        return variantCombination;
    }

    public void setVariantCombination(List<VariantCombination> variantCombination) {
        this.variantCombination = variantCombination;
    }

    public class VariantCombination {

        @SerializedName("name")
        private String name;
        @SerializedName("value")
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}