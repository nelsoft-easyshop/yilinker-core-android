package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class Transaction {

    private String orderId;
    private String buyerId;
    private String orderStatusId;
    private String dateCreated;
    private String invoiceNumber;
    private String paymentType;
    private String paymentTypeId;
    private String orderStatus;
    private String totalPrice;
    private String totalUnitPrice;
    private String totalItemsPrice;
    private String totalHandlingFee;
    private String totalQuantity;

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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public static class TransactionInstance implements InstanceCreator<Transaction> {

        @Override
        public Transaction createInstance(Type type) {

            return new Transaction();
        }
    }
}
