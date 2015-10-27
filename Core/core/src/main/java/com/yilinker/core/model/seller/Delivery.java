package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 9/12/2015.
 */
public class Delivery {

    private static final String KEY_ORDER_PRODUCT_ID = "orderProductId";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_DELIVERY_LOGS = "deliveryLogs";

    @SerializedName(KEY_ORDER_PRODUCT_ID)
    private int orderProductId;

    @SerializedName(KEY_PRODUCT_NAME)
    private String productName;

    @SerializedName(KEY_DELIVERY_LOGS)
    private List<DeliveryLog> deliveryLogs;

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<DeliveryLog> getDeliveryLogs() {
        return deliveryLogs;
    }

    public void setDeliveryLogs(List<DeliveryLog> deliveryLogs) {
        this.deliveryLogs = deliveryLogs;
    }

    public class DeliveryLog {

        private static final String KEY_ACTION_TYPE = "actionType";
        private static final String KEY_DATE = "date";
        private static final String KEY_LOCATION = "location";
        private static final String KEY_RIDER_NAME = "riderName";
        private static final String KEY_CLIENT_SIGNATURE = "clientSignature";

        @SerializedName(KEY_ACTION_TYPE)
        private String actionType;

        @SerializedName(KEY_DATE)
        private Date date;

        @SerializedName(KEY_LOCATION)
        private String location;

        @SerializedName(KEY_RIDER_NAME)
        private String riderName;

        @SerializedName(KEY_CLIENT_SIGNATURE)
        private String clientSignature;

        public String getActionType() {
            return actionType;
        }

        public void setActionType(String actionType) {
            this.actionType = actionType;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getRiderName() {
            return riderName;
        }

        public void setRiderName(String riderName) {
            this.riderName = riderName;
        }

        public String getClientSignature() {
            return clientSignature;
        }

        public void setClientSignature(String clientSignature) {
            this.clientSignature = clientSignature;
        }

    }

    public class Date {

        private static final String KEY_DATE = "date";
        private static final String KEY_TIMEZONE = "timezone";
        private static final String KEY_TIMEZONE_TYPE = "timezone_type";

        @SerializedName(KEY_DATE)
        private String date;

        @SerializedName(KEY_TIMEZONE)
        private String timezone;

        @SerializedName(KEY_TIMEZONE_TYPE)
        private int timezoneType;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public int getTimezoneType() {
            return timezoneType;
        }

        public void setTimezoneType(int timezoneType) {
            this.timezoneType = timezoneType;
        }

    }

    public static class DeliveryInstance implements InstanceCreator<Delivery> {

        @Override
        public Delivery createInstance(Type type) {

            return new Delivery();
        }

    }

}
