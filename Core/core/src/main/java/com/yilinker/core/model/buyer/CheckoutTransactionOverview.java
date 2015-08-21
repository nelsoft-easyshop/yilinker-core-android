package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 8/20/15.
 */
public class CheckoutTransactionOverview {

    private double grandTotal;
    private String referenceNumber;
    private String transactionDate;
    private List<CheckoutOrderedItems> orderedItem;

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<CheckoutOrderedItems> getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(List<CheckoutOrderedItems> orderedItem) {
        this.orderedItem = orderedItem;
    }

    public static class CheckoutTransactionOverviewInstance implements InstanceCreator<CheckoutTransactionOverview>{

        @Override
        public CheckoutTransactionOverview createInstance(Type type) {
            return new CheckoutTransactionOverview();
        }
    }
}
