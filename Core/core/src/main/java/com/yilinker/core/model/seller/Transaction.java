package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class Transaction {

    private final static String KEY_ORDER_ID = "order_id";
    private final static String KEY_BUYER_ID = "buyer_id";
    private final static String KEY_ORDER_STATUS_ID = "order_status_id";
    private final static String KEY_DATE_ADDED = "date_added";
    private final static String KEY_DATE_MODIFIED = "date_modified";
    private final static String KEY_INVOICE_NUMBER = "invoice_number";
    private final static String KEY_PAYMENT_TYPE = "payment_type";
    private final static String KEY_PAYMENT_TYPE_ID = "payment_type_id";
    private final static String KEY_ORDER_STATUS = "order_status";
    private final static String KEY_TOTAL_PRICE = "total_price";
    private final static String KEY_TOTAL_UNIT_PRICE = "total_unit_price";
    private final static String KEY_TOTAL_ITEMS_PRICE = "total_items_price";
    private final static String KEY_TOTAL_HANDLING_FEE = "total_handling_fee";
    private final static String KEY_TOTAL_QUANTITY = "total_quantity";
    private final static String KEY_PRODUCT_COUNT = "product_count";

    @SerializedName(KEY_ORDER_ID)
    private String orderId;

    @SerializedName(KEY_BUYER_ID)
    private String buyerId;

    @SerializedName(KEY_ORDER_STATUS_ID)
    private String orderStatusId;

    @SerializedName(KEY_DATE_ADDED)
    private String dateAdded;

    @SerializedName(KEY_DATE_MODIFIED)
    private String dateModified;

    @SerializedName(KEY_INVOICE_NUMBER)
    private String invoiceNumber;

    @SerializedName(KEY_PAYMENT_TYPE)
    private String paymentType;

    @SerializedName(KEY_PAYMENT_TYPE_ID)
    private String paymentTypeId;

    @SerializedName(KEY_ORDER_STATUS)
    private String orderStatus;

    @SerializedName(KEY_TOTAL_PRICE)
    private String totalPrice;

    @SerializedName(KEY_TOTAL_UNIT_PRICE)
    private String totalUnitPrice;

    @SerializedName(KEY_TOTAL_ITEMS_PRICE)
    private String totalItemsPrice;

    @SerializedName(KEY_TOTAL_HANDLING_FEE)
    private String totalHandlingFee;

    @SerializedName(KEY_TOTAL_QUANTITY)
    private String totalQuantity;

    @SerializedName(KEY_PRODUCT_COUNT)
    private int productCount;


    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalUnitPrice() {
        return totalUnitPrice;
    }

    public void setTotalUnitPrice(String totalUnitPrice) {
        this.totalUnitPrice = totalUnitPrice;
    }

    public String getTotalItemsPrice() {
        return totalItemsPrice;
    }

    public void setTotalItemsPrice(String totalItemsPrice) {
        this.totalItemsPrice = totalItemsPrice;
    }

    public String getTotalHandlingFee() {
        return totalHandlingFee;
    }

    public void setTotalHandlingFee(String totalHandlingFee) {
        this.totalHandlingFee = totalHandlingFee;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public static class TransactionInstance implements InstanceCreator<Transaction> {

        @Override
        public Transaction createInstance(Type type) {

            return new Transaction();
        }
    }
}
