package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/2/2015.
 */
public class TransactionItem {

    private String order_id;
    private String date_added;
    private String invoice_number;
    private String payment_type;
    private String payment_method_id;
    private String order_status;
    private String order_status_id;
    private String total_price;
    private String total_unit_price;
    private String total_item_price;
    private String total_handling_fee;
    private String total_quantity;
    private String product_names;
    private String product_cost;
    private String product_count;

    public String getOrder_Id() {
        return order_id;
    }

    public void setOrder_Id(String order_id) {
        this.order_id = order_id;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(String order_status_id) {
        this.order_status_id = order_status_id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getTotal_unit_price() {
        return total_unit_price;
    }

    public void setTotal_unit_price(String total_unit_price) {
        this.total_unit_price = total_unit_price;
    }

    public String getTotal_item_price() {
        return total_item_price;
    }

    public void setTotal_item_price(String total_item_price) {
        this.total_item_price = total_item_price;
    }

    public String getTotal_handling_fee() {
        return total_handling_fee;
    }

    public void setTotal_handling_fee(String total_handling_fee) {
        this.total_handling_fee = total_handling_fee;
    }

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getProduct_names() {
        return product_names;
    }

    public void setProduct_names(String product_names) {
        this.product_names = product_names;
    }

    public String getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(String product_cost) {
        this.product_cost = product_cost;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public static class TransactionItemInstance implements InstanceCreator<TransactionItem> {

        @Override
        public TransactionItem createInstance(Type type) {

            return new TransactionItem();
        }
    }
}
