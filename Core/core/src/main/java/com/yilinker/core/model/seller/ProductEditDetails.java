package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 10/1/2015.
 */
public class ProductEditDetails {

    private static final String KEY_PRODUCT_ID = "productId";
    private static final String KEY_CONDITION_ID = "conditionId";
    private static final String KEY_CONDITION_NAME = "conditionName";
    private static final String KEY_CATEGORY_ID = "categoryId";
    private static final String KEY_CATEGORY_NAME = "categoryName";
    private static final String KEY_BRAND_ID = "brandId";
    private static final String KEY_BRAND_NAME = "brandName";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_HAS_COMBINATION = "hasCombination";
    private static final String KEY_PRODUCT_PROPERTIES = "productProperties";
    private static final String KEY_PRODUCT_VARIANTS = "productVariants";

    @SerializedName(KEY_PRODUCT_ID)
    private int productId;
    @SerializedName(KEY_CONDITION_ID)
    private int conditionId;
    @SerializedName(KEY_CONDITION_NAME)
    private String conditionName;
    @SerializedName(KEY_CATEGORY_ID)
    private int categoryId;
    @SerializedName(KEY_CATEGORY_NAME)
    private String categoryName;
    @SerializedName(KEY_BRAND_ID)
    private int brandId;
    @SerializedName(KEY_BRAND_NAME)
    private String brandName;
    @SerializedName(KEY_TITLE)
    private String title;
    @SerializedName(KEY_SHORT_DESCRIPTION)
    private String shortDescription;
    @SerializedName(KEY_DESCRIPTION)
    private String description;
    @SerializedName(KEY_IMAGES)
    private List<Image> images;
    @SerializedName(KEY_HAS_COMBINATION)
    private boolean hasCombination;
    @SerializedName(KEY_PRODUCT_PROPERTIES)
    private List<ProductProperty> productProperties;
    @SerializedName(KEY_PRODUCT_VARIANTS)
    private List<ProductVariant> productVariants;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public boolean isHasCombination() {
        return hasCombination;
    }

    public void setHasCombination(boolean hasCombination) {
        this.hasCombination = hasCombination;
    }

    public List<ProductProperty> getProductProperties() {
        return productProperties;
    }

    public void setProductProperties(List<ProductProperty> productProperties) {
        this.productProperties = productProperties;
    }

    public List<ProductVariant> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariant> productVariants) {
        this.productVariants = productVariants;
    }

    public static class ProductEditDetailsInstance implements InstanceCreator<ProductEditDetails> {

        @Override
        public ProductEditDetails createInstance(Type type) {
            return new ProductEditDetails();
        }

    }

    public class Image {

        private static final String KEY_ID = "id";
        private static final String KEY_PATH = "path";
        private static final String KEY_IMAGE = "image";

        @SerializedName(KEY_ID)
        private int id;
        @SerializedName(KEY_PATH)
        private String path;
        @SerializedName(KEY_IMAGE)
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public class ProductProperty {

        private static final String KEY_ID = "id";
        private static final String KEY_PRODUCT_UNIT_ID = "productUnitId";
        private static final String KEY_QUANTITY = "quantity";
        private static final String KEY_SKU = "sku";
        private static final String KEY_PRICE = "price";
        private static final String KEY_DISCOUNTED_PRICE = "discountedPrice";
        private static final String KEY_UNIT_LENGTH = "unitLength";
        private static final String KEY_UNIT_WIDTH = "unitWidth";
        private static final String KEY_UNIT_HEIGHT = "unitHeight";
        private static final String KEY_UNIT_WEIGHT = "unitWeight";
        private static final String KEY_ATTRIBUTES = "attributes";
        private static final String KEY_IMAGES = "images";

        @SerializedName(KEY_ID)
        private String id;
        @SerializedName(KEY_PRODUCT_UNIT_ID)
        private String productUnitId;
        @SerializedName(KEY_QUANTITY)
        private int quantity;
        @SerializedName(KEY_SKU)
        private String sku;
        @SerializedName(KEY_PRICE)
        private String price;
        @SerializedName(KEY_DISCOUNTED_PRICE)
        private String discountedPrice;
        @SerializedName(KEY_UNIT_LENGTH)
        private String unitLength;
        @SerializedName(KEY_UNIT_WIDTH)
        private String unitWidth;
        @SerializedName(KEY_UNIT_HEIGHT)
        private String unitHeight;
        @SerializedName(KEY_UNIT_WEIGHT)
        private String unitWeight;
        @SerializedName(KEY_ATTRIBUTES)
        private List<Attribute> attributes;
        @SerializedName(KEY_IMAGES)
        private List<Image> images;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProductUnitId() {
            return productUnitId;
        }

        public void setProductUnitId(String productUnitId) {
            this.productUnitId = productUnitId;
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

        public String getUnitLength() {
            return unitLength;
        }

        public void setUnitLength(String unitLength) {
            this.unitLength = unitLength;
        }

        public String getUnitWidth() {
            return unitWidth;
        }

        public void setUnitWidth(String unitWidth) {
            this.unitWidth = unitWidth;
        }

        public String getUnitHeight() {
            return unitHeight;
        }

        public void setUnitHeight(String unitHeight) {
            this.unitHeight = unitHeight;
        }

        public String getUnitWeight() {
            return unitWeight;
        }

        public void setUnitWeight(String unitWeight) {
            this.unitWeight = unitWeight;
        }

        public List<Attribute> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attribute> attributes) {
            this.attributes = attributes;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }


    }

    public class Attribute {

        private static final String KEY_NAME = "name";
        private static final String KEY_VALUE = "value";

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

    public class ProductVariant {

        private static final String KEY_NAME = "name";
        private static final String KEY_VALUES = "values";

        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_VALUES)
        private List<String> values;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getValues() {
            return values;
        }

        public void setValues(List<String> values) {
            this.values = values;
        }

    }

}
