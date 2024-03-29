package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/12/16.
 */
public class ProductUploadDetails {

    @SerializedName("productId")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("shortDescription")
    private String shortDescription;
    @SerializedName("description")
    private String completeDescription;
    @SerializedName("youtubeVideoUrl")
    private String videoUrl;
    @SerializedName("productConditionId")
    private int conditionId;
    @SerializedName("productConditionName")
    private String conditionName;
    @SerializedName("productCategoryId")
    private int categoryId;
    @SerializedName("productCategoryName")
    private String categoryName;
    @SerializedName("shippingCategoryId")
    private int shippingCategoryId;
    @SerializedName("shippingCategoryName")
    private String shippingCategoryName;
    @SerializedName("brandId")
    private int brandId;
    @SerializedName("brandName")
    private String brandName;
    @SerializedName("status")
    private int status;
    @SerializedName("hasCombination")
    private boolean hasCombination;
    @SerializedName("productGroups")
    private String[] productGroups;
    @SerializedName("productImages")
    private Image[] images;
    @SerializedName("productUnits")
    private ProductUnit[] productUnits;
    @SerializedName("productVariants")
    private ProductVariant[] productVariants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getShippingCategoryId() {
        return shippingCategoryId;
    }

    public void setShippingCategoryId(int shippingCategoryId) {
        this.shippingCategoryId = shippingCategoryId;
    }

    public String getShippingCategoryName() {
        return shippingCategoryName;
    }

    public void setShippingCategoryName(String shippingCategoryName) {
        this.shippingCategoryName = shippingCategoryName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isHasCombination() {
        return hasCombination;
    }

    public void setHasCombination(boolean hasCombination) {
        this.hasCombination = hasCombination;
    }

    public String[] getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(String[] productGroups) {
        this.productGroups = productGroups;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public ProductUnit[] getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(ProductUnit[] productUnits) {
        this.productUnits = productUnits;
    }

    public ProductVariant[] getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(ProductVariant[] productVariants) {
        this.productVariants = productVariants;
    }

    public class Image {

        @SerializedName("raw")
        private String name;
        @SerializedName("imageLocation")
        private String location;
        @SerializedName("isPrimary")
        private boolean isPrimary;
        @SerializedName("isDeleted")
        private boolean isDeleted;
        @SerializedName("sizes")
        private ImageSize size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public boolean isPrimary() {
            return isPrimary;
        }

        public void setPrimary(boolean primary) {
            isPrimary = primary;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean deleted) {
            isDeleted = deleted;
        }

        public ImageSize getSize() {
            return size;
        }

        public void setSize(ImageSize size) {
            this.size = size;
        }

    }

    public class ImageSize {

        @SerializedName("thumbnail")
        private String thumbnail;
        @SerializedName("small")
        private String small;
        @SerializedName("medium")
        private String medium;
        @SerializedName("large")
        private String large;

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

    }

    public class ProductUnit {

        @SerializedName("productUnitId")
        private int id;
        @SerializedName("quantity")
        private int quantity;
        @SerializedName("sku")
        private String sku;
        @SerializedName("price")
        private String price;
        @SerializedName("discountedPrice")
        private String discountedPrice;
        @SerializedName("length")
        private String length;
        @SerializedName("width")
        private String width;
        @SerializedName("height")
        private String height;
        @SerializedName("weight")
        private String weight;
        @SerializedName("attributes")
        private Attribute[] attributes;
        @SerializedName("images")
        private Image[] images;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
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

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public Attribute[] getAttributes() {
            return attributes;
        }

        public void setAttributes(Attribute[] attributes) {
            this.attributes = attributes;
        }

        public Image[] getImages() {
            return images;
        }

        public void setImages(Image[] images) {
            this.images = images;
        }

    }

    public class Attribute {

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

    public class ProductVariant {

        @SerializedName("name")
        private String name;
        @SerializedName("values")
        private Value[] values;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Value[] getValues() {
            return values;
        }

        public void setValues(Value[] values) {
            this.values = values;
        }

    }

    public class Value {

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ProductUploadDetailsInstance implements InstanceCreator<ProductUploadDetails> {
        @Override
        public ProductUploadDetails createInstance(Type type) {
            return new ProductUploadDetails();
        }
    }

}
