package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 8/21/2015.
 */
public class TransactionProduct {

    private static final String KEY_ORDER_PRODUCT_ID = "orderProductId";
    private static final String KEY_PRODUCT_ID = "productId";
    private static final String KEY_PRODUCT_QUANTITY = " quantity";
    private static final String KEY_PRODUCT_UNIT_PRICE = "unitPrice";
    private static final String KEY_PRODUCT_TOTAL_PRICE = "totalPrice";
    private static final String KEY_PRODUCT_PRODUCT_NAME = "productName";
    private static final String KEY_PRODUCT_HANDLING_FEE = "handlingFee";
    private static final String KEY_PRODUCT_PRODUCT_IMAGE = "productImage";
    private static final String KEY_PRODUCT_SKU = "sku";
    private static final String KEY_PRODUCT_ATTRIBUTES = "attributes";
    private static final String KEY_PRODUCT_ORIGINAL_UNIT_PRICE = "originalUnitPrice";
    private static final String KEY_PRODUCT_DISCOUNT = "discount";
    private static final String KEY_PRODUCT_WIDTH = "width";
    private static final String KEY_PRODUCT_LENGTH = "length";
    private static final String KEY_PRODUCT_HEIGHT = "height";
    private static final String KEY_PRODUCT_WEIGHT = "weight";
    private static final String KEY_PRODUCT_DESCRIPTION = "description";
    private static final String KEY_PRODUCT_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_PRODUCT_SELLER = "seller";
    private static final String KEY_PRODUCT_BRAND = "brand";
    private static final String KEY_PRODUCT_CONDITION = "condition";
    private static final String KEY_PRODUCT_CATEGORY_ID = "productCategoryId";

    @SerializedName(KEY_ORDER_PRODUCT_ID)
    private String orderProductId;
    @SerializedName(KEY_PRODUCT_ID)
    private String productId;
    @SerializedName(KEY_PRODUCT_QUANTITY)
    private int quantity;
    @SerializedName(KEY_PRODUCT_UNIT_PRICE)
    private String unitPrice;
    @SerializedName(KEY_PRODUCT_TOTAL_PRICE)
    private String totalPrice;
    @SerializedName(KEY_PRODUCT_PRODUCT_NAME)
    private String productName;
    @SerializedName(KEY_PRODUCT_HANDLING_FEE)
    private String handlingFee;
    @SerializedName(KEY_PRODUCT_PRODUCT_IMAGE)
    private String productImage;
    @SerializedName(KEY_PRODUCT_SKU)
    private String sku;
    @SerializedName(KEY_PRODUCT_ATTRIBUTES)
    private List<Attributes> attributes = new ArrayList<>();
    @SerializedName(KEY_PRODUCT_ORIGINAL_UNIT_PRICE)
    private String originalUnitPrice;
    @SerializedName(KEY_PRODUCT_DISCOUNT)
    private String discount;
    @SerializedName(KEY_PRODUCT_WIDTH)
    private String width;
    @SerializedName(KEY_PRODUCT_HEIGHT)
    private String height;
    @SerializedName(KEY_PRODUCT_LENGTH)
    private String length;
    @SerializedName(KEY_PRODUCT_WEIGHT)
    private String weight;
    @SerializedName(KEY_PRODUCT_DESCRIPTION)
    private String description;
    @SerializedName(KEY_PRODUCT_SHORT_DESCRIPTION)
    private String shortDescription;
//    @SerializedName(KEY_PRODUCT_SELLER)
//    private Seller seller;
    @SerializedName(KEY_PRODUCT_BRAND)
    private Brand brand;
    @SerializedName(KEY_PRODUCT_CONDITION)
    private Condition condition;

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOriginalUnitPrice() {
        return originalUnitPrice;
    }

    public void setOriginalUnitPrice(String originalUnitPrice) {
        this.originalUnitPrice = originalUnitPrice;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }

    public class Attributes {

        private static final String KEY_ATTRIBUTE_NAME = "attributeName";
        private static final String KEY_ATTRIBUTE_VALUE = "attributeValue";

        @SerializedName(KEY_ATTRIBUTE_NAME)
        private String attributeName;
        @SerializedName(KEY_ATTRIBUTE_VALUE)
        private String attributeValue;

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getAttributeValue() {
            return attributeValue;
        }

        public void setAttributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
        }
    }

    public class Brand {

        private static final String KEY_BRAND_ID = "id";
        private static final String KEY_BRAND_NAME = "name";

        @SerializedName(KEY_BRAND_ID)
        private int id;
        @SerializedName(KEY_BRAND_NAME)
        private String name;

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
    }

    public class Condition {

        private static final String KEY_BRAND_ID = "id";
        private static final String KEY_BRAND_NAME = "name";

        @SerializedName(KEY_BRAND_ID)
        private int id;
        @SerializedName(KEY_BRAND_NAME)
        private String name;

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
    }


    public static class TransactionProductInstance implements InstanceCreator<TransactionProduct> {

        @Override
        public TransactionProduct createInstance(Type type) {

            return new TransactionProduct();
        }

    }



}
