package com.yilinker.core.model.buyer.product2;

import com.google.gson.annotations.SerializedName;

import static com.yilinker.core.constants.ProductAPIConstants.*;

import java.util.List;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class ProductUnits {

    @SerializedName(KEY_PRODUCT_ID)
    private String productId;
    @SerializedName(KEY_PRODUCT_UNIT_ID)
    private String productUnitId;
    @SerializedName(KEY_SKU)
    private String sku;
    @SerializedName(KEY_SLUG)
    private String slug;
    @SerializedName(KEY_PRICE)
    private String price;
    @SerializedName(KEY_DISCOUNTED_PRICE)
    private String discountedPrice;
    @SerializedName(KEY_APPLIED_BASE_DISCOUNT_PRICE)
    private String appliedBaseDiscountPrice;
    @SerializedName(KEY_APPLIED_DISCOUNT_PRICE)
    private String appliedDiscountPrice;
    @SerializedName(KEY_PRIMARY_IMAGE)
    private String primaryImage;
    @SerializedName(KEY_PRIMARY_THUMBNAIL_IMAGE)
    private String primaryThumbnailImage;
    @SerializedName(KEY_PRIMARY_SMALL_IMAGE)
    private String primarySmallImage;
    @SerializedName(KEY_PRIMARY_MEDIUM_IMAGE)
    private String primaryMediumImage;
    @SerializedName(KEY_PRIMARY_LARGE_IMAGE)
    private String primaryLargeImage;
    @SerializedName(KEY_COMMISSION)
    private String commission;
    @SerializedName(KEY_WEIGHT)
    private String weight;
    @SerializedName(KEY_LENGTH)
    private String length;
    @SerializedName(KEY_HEIGHT)
    private String height;
    @SerializedName(KEY_WIDTH)
    private String width;

    @SerializedName(KEY_QUANTITY)
    private int quantity;
    @SerializedName(KEY_STATUS)
    private int status;

    @SerializedName(KEY_DISCOUNT)
    private double discount;

    @SerializedName(KEY_IN_WISH_LIST)
    private boolean inWishList;

    @SerializedName(KEY_DATE_CREATED)
    private Date dateCreated;
    @SerializedName(KEY_DATE_LAST_MODIFIED)
    private Date dateLastModified;

    @SerializedName(KEY_IMAGE_IDS)
    private List<String> imageIds;
    @SerializedName(KEY_COMBINATION)
    private List<String> combination;
    @SerializedName(KEY_COMBINATION_NAMES)
    private List<String> combinationNames;
    @SerializedName(KEY_VARIANT_COMBINATION)
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

        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_VALUE)
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