package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rlcoronado on 9/3/15.
 */
public class CheckoutOverview {

    private String orderId;
    private String invoiceNumber;
    private String totalPrice;
    private ArrayList<CheckoutOverviewItem> orderProducts = new ArrayList<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CheckoutOverviewItem> getOrderProduct() {
        return orderProducts;
    }

    public void setOrderProduct(ArrayList<CheckoutOverviewItem> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static class CheckoutOverviewInstance implements InstanceCreator<CheckoutOverview>{

        @Override
        public CheckoutOverview createInstance(Type type) {
            return new CheckoutOverview();
        }
    }
}
