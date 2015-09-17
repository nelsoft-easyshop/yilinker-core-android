package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/12/2015.
 */
public class TransactionConsignee {

    private static final String KEY_DELIVERY_ADDRESS = "deliveryAddress";
    private static final String KEY_CONSIGNEE_NAME = "consigneeName";
    private static final String KEY_CONSIGNEE_CONTACT_NUMBER = "consigneeContactNumber";

    @SerializedName(KEY_DELIVERY_ADDRESS)
    private String deliveryAddress;

    @SerializedName(KEY_CONSIGNEE_NAME)
    private String name;

    @SerializedName(KEY_CONSIGNEE_CONTACT_NUMBER)
    private String contactNumber;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public static class TransactionConsigneeInstance implements InstanceCreator<TransactionConsignee> {

        @Override
        public TransactionConsignee createInstance(Type type) {

            return new TransactionConsignee();
        }

    }

}
