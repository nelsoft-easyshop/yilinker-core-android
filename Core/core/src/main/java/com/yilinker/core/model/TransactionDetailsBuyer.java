package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaybr_000 on 9/8/2015.
 */
public class TransactionDetailsBuyer {

    private static final String KEY_TRANSACTION_INVOICE = "transactionInvoice";
    private static final String KEY_TRANSACTION_SHIPPING_FEE = "transactionShippingFee";
    private static final String KEY_TRANSACTION_DATE = " transactionDate";
    private static final String KEY_TRANSACTION_PRICE = "transactionPrice";
    private static final String KEY_TRANSACTION_QUANTITY = "transactionQuantity";
    private static final String KEY_TRANSACTION_STATUS = "transactionStatus";
    private static final String KEY_TRANSACTION_PAYMENT = "transactionPayment";
    private static final String KEY_TRANSACTION_ORDER_PRODUCTS = "transactionItems";

    @SerializedName(KEY_TRANSACTION_INVOICE)
    private String transactionInvoice;
    @SerializedName(KEY_TRANSACTION_SHIPPING_FEE)
    private String transactionShippingFee;
    @SerializedName(KEY_TRANSACTION_DATE)
    private DateAdded transactionDate;
    @SerializedName(KEY_TRANSACTION_PRICE)
    private String transactionPrice;
    @SerializedName(KEY_TRANSACTION_QUANTITY)
    private int transactionQuantity;
    @SerializedName(KEY_TRANSACTION_STATUS)
    private TransactionStatus transactionStatus;
    @SerializedName(KEY_TRANSACTION_PAYMENT)
    private String transactionPayment;
    @SerializedName(KEY_TRANSACTION_ORDER_PRODUCTS)
    private List<TransactionItems> transactionItems;

    public String getTransactionInvoice() {
        return transactionInvoice;
    }

    public void setTransactionInvoice(String transactionInvoice) {
        this.transactionInvoice = transactionInvoice;
    }

    public String getTransactionShippingFee() {
        return transactionShippingFee;
    }

    public void setTransactionShippingFee(String transactionShippingFee) {
        this.transactionShippingFee = transactionShippingFee;
    }

    public DateAdded getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(DateAdded transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(String transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public int getTransactionQuantity() {
        return transactionQuantity;
    }

    public void setTransactionQuantity(int transactionQuantity) {
        this.transactionQuantity = transactionQuantity;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionPayment() {
        return transactionPayment;
    }

    public void setTransactionPayment(String transactionPayment) {
        this.transactionPayment = transactionPayment;
    }

    public List<TransactionItems> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(List<TransactionItems> transactionItems) {
        this.transactionItems = transactionItems;
    }

    public class DateAdded {

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

    public class TransactionStatus {

        private static final String KEY_STATUS_ID = "statusId";
        private static final String KEY_STATUS_NAME = "statusName";

        @SerializedName(KEY_STATUS_ID)
        private int statusId;
        @SerializedName(KEY_STATUS_NAME)
        private String statusName;

        public int getStatusId() {
            return statusId;
        }

        public void setStatusId(int statusId) {
            this.statusId = statusId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }

    public class TransactionItems {

        private static final String KEY_SELLER_ID = "sellerId";
        private static final String KEY_SELLER_STORE = "sellerStore";
        private static final String KEY_SELLER_CONTACT_NUMBER = "sellerContactNumber";
        private static final String KEY_HAS_FEEDBACK = "hasFeedback";
        private static final String KEY_PRODUCTS = "products";


        @SerializedName(KEY_SELLER_ID)
        private int sellerId;
        @SerializedName(KEY_SELLER_STORE)
        private String sellerStore;
        @SerializedName(KEY_SELLER_CONTACT_NUMBER)
        private String sellerContactNumber;
        @SerializedName(KEY_HAS_FEEDBACK)
        private boolean hasFeedback;
        @SerializedName(KEY_PRODUCTS)
        private List<Products> products = new ArrayList<>();

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public String getSellerStore() {
            return sellerStore;
        }

        public void setSellerStore(String sellerStore) {
            this.sellerStore = sellerStore;
        }

        public String getSellerContactNumber() {
            return sellerContactNumber;
        }

        public void setSellerContactNumber(String sellerContactNumber) {
            this.sellerContactNumber = sellerContactNumber;
        }

        public boolean isHasFeedback() {
            return hasFeedback;
        }

        public void setHasFeedback(boolean hasFeedback) {
            this.hasFeedback = hasFeedback;
        }

        public List<Products> getProducts() {
            return products;
        }

        public void setProducts(List<Products> products) {
            this.products = products;
        }
    }

    public class Products {

        private static final String KEY_ORDER_PRODUCT_ID = "orderProductId";
        private static final String KEY_PRODUCT_ID = "productId";
        private static final String KEY_QUANTITY = "quantity";
        private static final String KEY_UNIT_PRICE = "unitPrice";
        private static final String KEY_TOTAL_PRICE = "totalPrice";
        private static final String KEY_PRODUCT_NAME = "productName";
        private static final String KEY_HANDLING_FEE = "handlingFee";
        private static final String KEY_DATE_ADDED = "dateAdded";
        private static final String KEY_LAST_DATE_MODIFIED = "lastDateModified";
        private static final String KEY_ORDER_PRODUCT_STATUS = "orderProductStatus";
        private static final String KEY_PRODUCT_IMAGE = "productImage";
        private static final String KEY_IS_CANCELLABLE = "isCancellable";


        @SerializedName(KEY_ORDER_PRODUCT_ID)
        private String orderProductId;
        @SerializedName(KEY_PRODUCT_ID)
        private int productId;
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
        private DateAdded dateAdded;
        @SerializedName(KEY_LAST_DATE_MODIFIED)
        private DateAdded lastDateModified;
        @SerializedName(KEY_ORDER_PRODUCT_STATUS)
        private OrderProductStatus orderProductStatus;
        @SerializedName(KEY_PRODUCT_IMAGE)
        private String productImage;
        @SerializedName(KEY_IS_CANCELLABLE)
        private boolean isCancellable;

        public String getOrderProductId() {
            return orderProductId;
        }

        public void setOrderProductId(String orderProductId) {
            this.orderProductId = orderProductId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
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

        public DateAdded getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(DateAdded dateAdded) {
            this.dateAdded = dateAdded;
        }

        public DateAdded getLastDateModified() {
            return lastDateModified;
        }

        public void setLastDateModified(DateAdded lastDateModified) {
            this.lastDateModified = lastDateModified;
        }

        public OrderProductStatus getOrderProductStatus() {
            return orderProductStatus;
        }

        public void setOrderProductStatus(OrderProductStatus orderProductStatus) {
            this.orderProductStatus = orderProductStatus;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public boolean isCancellable() {
            return isCancellable;
        }

        public void setIsCancellable(boolean isCancellable) {
            this.isCancellable = isCancellable;
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

    public static class TransactionDetailsBuyerInstance implements InstanceCreator<TransactionDetailsBuyer> {

        @Override
        public TransactionDetailsBuyer createInstance(Type type) {

            return new TransactionDetailsBuyer();
        }

    }

}
