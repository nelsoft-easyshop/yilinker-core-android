package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 9/8/2015.
 */
public class SearchTransaction implements Parcelable {

    private String order_id;
    private String buyer_id;
    private String date_added;
    private String invoice_number;
    private String payment_type;
    private String payment_method_id;
    private String order_status;
    private String order_status_id;
    private String total_price;
    private String total_unit_price;
    private String total_handling_fee;
    private String total_quantity;
    private String product_names;
    private String product_count;
    private String target;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
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

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.order_id);
        dest.writeString(this.buyer_id);
        dest.writeString(this.date_added);
        dest.writeString(this.invoice_number);
        dest.writeString(this.payment_type);
        dest.writeString(this.payment_method_id);
        dest.writeString(this.order_status);
        dest.writeString(this.order_status_id);
        dest.writeString(this.total_price);
        dest.writeString(this.total_unit_price);
        dest.writeString(this.total_handling_fee);
        dest.writeString(this.total_quantity);
        dest.writeString(this.product_names);
        dest.writeString(this.product_count);
        dest.writeString(this.target);
    }

    public SearchTransaction() {
    }

    protected SearchTransaction(Parcel in) {
        this.order_id = in.readString();
        this.buyer_id = in.readString();
        this.date_added = in.readString();
        this.invoice_number = in.readString();
        this.payment_type = in.readString();
        this.payment_method_id = in.readString();
        this.order_status = in.readString();
        this.order_status_id = in.readString();
        this.total_price = in.readString();
        this.total_unit_price = in.readString();
        this.total_handling_fee = in.readString();
        this.total_quantity = in.readString();
        this.product_names = in.readString();
        this.product_count = in.readString();
        this.target = in.readString();
    }

    public static final Creator<SearchTransaction> CREATOR = new Creator<SearchTransaction>() {
        public SearchTransaction createFromParcel(Parcel source) {
            return new SearchTransaction(source);
        }

        public SearchTransaction[] newArray(int size) {
            return new SearchTransaction[size];
        }
    };


public static class SearchTransactionInstance implements InstanceCreator<SearchTransaction> {
        @Override
        public SearchTransaction createInstance(Type type) {
            return new SearchTransaction();
        }
    }
}
