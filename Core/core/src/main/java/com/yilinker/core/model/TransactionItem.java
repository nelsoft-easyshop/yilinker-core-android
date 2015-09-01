package com.yilinker.core.model;

import java.util.List;

/**
 * Created by Patrick on 8/21/2015.
 */
public class TransactionItem {
    private String transactionId;
    private int productCount;
    private double totalCost;
    private String status,paymentType,dateCreated;
    private int totalQuantity;
    private double totalUnitCost,shippingFee;
    private String consigneeName,consigneeAddress;
    private int consigneeNumber;
    private List<TransactionProduct> transactionProducts;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalUnitCost() {
        return totalUnitCost;
    }

    public void setTotalUnitCost(double totalUnitCost) {
        this.totalUnitCost = totalUnitCost;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public int getConsigneeNumber() {
        return consigneeNumber;
    }

    public void setConsigneeNumber(int consigneeNumber) {
        this.consigneeNumber = consigneeNumber;
    }

    public List<TransactionProduct> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(List<TransactionProduct> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }


}
