package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 9/16/2015.
 */
public class OrderProduct {

    private static final String KEY_ORDER_PRODUCT_ID = "orderProductId";
    private static final String KEY_PRODUCT_ID = "productId";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_UNIT_PRICE = "unitPrice";
    private static final String KEY_TOTAL_PRICE = "totalPrice";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_HANDLING_FEE = "handlingFee";
    private static final String KEY_DATE_ADDED = "dateAdded";
    private static final String KEY_LAST_DATE_MODIFIED = "lastDateModified";
    private static final String KEY_SKU = "sku";
    private static final String KEY_ORIGINAL_UNIT_PRICE = "originalUnitPrice";
    private static final String KEY_DISCOUNT = "discount";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WIDTH = "width";
    private static final String KEY_LENGTH = "length";
    private static final String KEY_BUYER = "buyer";
    private static final String KEY_BRAND = "brand";
    private static final String KEY_CONDITION = "condition";
    private static final String KEY_PRODUCT_CATEGORY = "productCategoryId";
    private static final String KEY_ATTRIBUTES = "attributes";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_SHORT_DESCRIPTION = "shortDescription";
    private static final String KEY_PRODUCT_IMAGE = "productImage";
    private static final String KEY_DELIVERY_LOGS = "deliveryLogs";


    @SerializedName(KEY_ORDER_PRODUCT_ID)
    private String orderProductId;
    @SerializedName(KEY_PRODUCT_ID)
    private String productId;
    @SerializedName(KEY_QUANTITY)
    private int quantity;
    @SerializedName(KEY_UNIT_PRICE)
    private String unitPrice;
    @SerializedName(KEY_TOTAL_PRICE)
    private String totalPrice;
    @SerializedName(KEY_PRODUCT_NAME)
    private String productName;
    @SerializedName(KEY_HANDLING_FEE)
    private String handlingFee;
    @SerializedName(KEY_DATE_ADDED)
    private Date dateAdded;
    @SerializedName(KEY_LAST_DATE_MODIFIED)
    private Date lastDateModified;
    @SerializedName(KEY_SKU)
    private String sku;
    @SerializedName(KEY_ORIGINAL_UNIT_PRICE)
    private String originalUnitPrice;
    @SerializedName(KEY_DISCOUNT)
    private String discount;
    @SerializedName(KEY_WEIGHT)
    private String weight;
    @SerializedName(KEY_HEIGHT)
    private String height;
    @SerializedName(KEY_LENGTH)
    private String length;
    @SerializedName(KEY_WIDTH)
    private String width;
    @SerializedName(KEY_BUYER)
    private Buyer buyer;
    @SerializedName(KEY_BRAND)
    private Brand brand;
    @SerializedName(KEY_CONDITION)
    private Condition condition;
    @SerializedName(KEY_PRODUCT_CATEGORY)
    private ProductCategory productCategory;
    @SerializedName(KEY_ATTRIBUTES)
    private List<Attribute> attributes;
    @SerializedName(KEY_DESCRIPTION)
    private String fullDescription;
    @SerializedName(KEY_SHORT_DESCRIPTION)
    private String shortDescription;
    @SerializedName(KEY_PRODUCT_IMAGE)
    private String productImage;
    @SerializedName(KEY_DELIVERY_LOGS)
    private DeliveryLogs deliveryLogs;

    public String getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(String orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(String handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getLastDateModified() {
        return lastDateModified;
    }

    public void setLastDateModified(Date lastDateModified) {
        this.lastDateModified = lastDateModified;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOriginalUnitPrice() {
        return originalUnitPrice;
    }

    public void setOriginalUnitPrice(String originalUnitPrice) {
        this.originalUnitPrice = originalUnitPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<Attribute> getAttributes() {

        boolean hasDimensions = false;
        for (Attribute attribute: attributes) {
            if (attribute.attributeName.equals("width"))
                hasDimensions = true;
        }
        if (!hasDimensions) {
            attributes.add(new Attribute("width", this.width == null ? "-" : this.width + " cm"));
            attributes.add(new Attribute("weight", this.weight == null ? "-" : this.weight + " kg"));
            attributes.add(new Attribute("height", this.height == null ? "-" : this.height + " cm"));
            attributes.add(new Attribute("length", this.length == null ? "-" : this.length + " cm"));
        }
        return attributes;
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

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public DeliveryLogs getDeliveryLogs() {
        return deliveryLogs;
    }

    public void setDeliveryLogs(DeliveryLogs deliveryLogs) {
        this.deliveryLogs = deliveryLogs;
    }


    public class Date {

        private static final String KEY_DATE = "date";
        private static final String KEY_TIMEZONE_TYPE = "timezone_type";
        private static final String KEY_TIMEZONE = "timezone";

        @SerializedName(KEY_DATE)
        private String date;
        @SerializedName(KEY_TIMEZONE_TYPE)
        private int timezoneType;
        @SerializedName(KEY_TIMEZONE)
        private String timezone;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getTimezoneType() {
            return timezoneType;
        }

        public void setTimezoneType(int timezoneType) {
            this.timezoneType = timezoneType;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }

    public class OrderProductStatus {

        private static final String KEY_ORDER_PRODUCT_STATUS_ID = "orderProductStatusId";
        private static final String KEY_NAME = "name";
        private static final String KEY_DESCRIPTION = "description";

        @SerializedName(KEY_ORDER_PRODUCT_STATUS_ID)
        private int orderProductStatusId;
        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_DESCRIPTION)
        private String description;


        public int getOrderProductStatusId() {
            return orderProductStatusId;
        }

        public void setOrderProductStatusId(int orderProductStatusId) {
            this.orderProductStatusId = orderProductStatusId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public class Buyer {

        private static final String KEY_FULLNAME = "fullname";
        private static final String KEY_BUYER_ID = "buyerid";

        @SerializedName(KEY_FULLNAME)
        private String fullName;
        @SerializedName(KEY_BUYER_ID)
        private int buyerId;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(int buyerId) {
            this.buyerId = buyerId;
        }
    }

    public class Condition {

        private static final String KEY_NAME = "name";
        private static final String KEY_ID = "id";

        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_ID)
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class Brand {

        private static final String KEY_NAME = "name";
        private static final String KEY_ID = "id";

        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_ID)
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class ProductCategory {

        private static final String KEY_NAME = "name";
        private static final String KEY_ID = "id";
        private static final String KEY_DESCRIPTION = "description";

        @SerializedName(KEY_NAME)
        private String name;
        @SerializedName(KEY_ID)
        private int id;
        @SerializedName(KEY_DESCRIPTION)
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public class Attribute {

        private static final String KEY_ATTRIBUTE_NAME = "attributeName";
        private static final String KEY_ATTRIBUTE_VALUE = "attributeValue";

        @SerializedName(KEY_ATTRIBUTE_NAME)
        private String attributeName;
        @SerializedName(KEY_ATTRIBUTE_VALUE)
        private String attributeValue;

        public Attribute(String attributeName, String attributeValue) {
            this.attributeName = attributeName;
            this.attributeValue = attributeValue;
        }

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

    public class DeliveryLogs {

        private static final String KEY_LAST_CHECKED_IN_DATE = "lastCheckedInDate";
        private static final String KEY_LAST_CHECKED_IN_BY = "lastCheckedInBy";
        private static final String KEY_LAST_ACTION_TYPE = "lastActionType";
        private static final String KEY_LAST_CHECKED_IN_LOCATION = "lastCheckedinLocation";
        private static final String KEY_PICKUP_RIDER = "pickupRider";
        private static final String KEY_DELIVERY_RIDER = "deliveryRider";


        @SerializedName(KEY_LAST_CHECKED_IN_DATE)
        private LastCheckedInDate lastCheckedInDate;
        @SerializedName(KEY_LAST_CHECKED_IN_BY)
        private String lastCheckedInBy;
        @SerializedName(KEY_LAST_ACTION_TYPE)
        private String lastActionType;
        @SerializedName(KEY_LAST_CHECKED_IN_LOCATION)
        private String lastCheckedInLocation;
        @SerializedName(KEY_PICKUP_RIDER)
        private PickupRider pickupRider;
        @SerializedName(KEY_DELIVERY_RIDER)
        private DeliveryRider deliveryRider;

        public LastCheckedInDate getLastCheckedInDate() {
            return lastCheckedInDate;
        }

        public void setLastCheckedInDate(LastCheckedInDate lastCheckedInDate) {
            this.lastCheckedInDate = lastCheckedInDate;
        }

        public String getLastCheckedInBy() {
            return lastCheckedInBy;
        }

        public void setLastCheckedInBy(String lastCheckedInBy) {
            this.lastCheckedInBy = lastCheckedInBy;
        }

        public String getLastActionType() {
            return lastActionType;
        }

        public void setLastActionType(String lastActionType) {
            this.lastActionType = lastActionType;
        }

        public String getLastCheckedInLocation() {
            return lastCheckedInLocation;
        }

        public void setLastCheckedInLocation(String lastCheckedInLocation) {
            this.lastCheckedInLocation = lastCheckedInLocation;
        }

        public PickupRider getPickupRider() {
            return pickupRider;
        }

        public void setPickupRider(PickupRider pickupRider) {
            this.pickupRider = pickupRider;
        }

        public DeliveryRider getDeliveryRider() {
            return deliveryRider;
        }

        public void setDeliveryRider(DeliveryRider deliveryRider) {
            this.deliveryRider = deliveryRider;
        }

        public class LastCheckedInDate {

            private static final String KEY_DATE = "date";
            private static final String KEY_TIMEZONE_TYPE = "timezone_type";
            private static final String KEY_TIMEZONE = "timezone";

            @SerializedName(KEY_DATE)
            private String date;
            @SerializedName(KEY_TIMEZONE_TYPE)
            private String timezone_type;
            @SerializedName(KEY_TIMEZONE)
            private String timezone;


            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTimezone_type() {
                return timezone_type;
            }

            public void setTimezone_type(String timezone_type) {
                this.timezone_type = timezone_type;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }
        }

        public class PickupRider {

            private static final String KEY_PICKUP_RIDER = "pickupRider";
            private static final String KEY_CONTACT_NUMBER = "contactNumber";

            @SerializedName(KEY_PICKUP_RIDER)
            private String pickupRider;
            @SerializedName(KEY_CONTACT_NUMBER)
            private String contactNumber;

            public String getPickupRider() {
                return pickupRider;
            }

            public void setPickupRider(String pickupRider) {
                this.pickupRider = pickupRider;
            }

            public String getContactNumber() {
                return contactNumber;
            }

            public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
            }
        }

        public class DeliveryRider {

            private static final String KEY_DELIVERY_RIDER = "deliveryRider";
            private static final String KEY_CONTACT_NUMBER = "contactNumber";

            @SerializedName(KEY_DELIVERY_RIDER)
            private String deliveryRider;
            @SerializedName(KEY_CONTACT_NUMBER)
            private String contactNumber;

            public String getDeliveryRider() {
                return deliveryRider;
            }

            public void setDeliveryRider(String deliveryRider) {
                this.deliveryRider = deliveryRider;
            }

            public String getContactNumber() {
                return contactNumber;
            }

            public void setContactNumber(String contactNumber) {
                this.contactNumber = contactNumber;
            }
        }
    }


    public static class OrderProductInstance implements InstanceCreator<OrderProduct> {

        @Override
        public OrderProduct createInstance(Type type) {
            return new OrderProduct();
        }

    }

}
