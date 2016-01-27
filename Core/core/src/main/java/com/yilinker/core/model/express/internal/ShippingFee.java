package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 07/01/2016.
 */
public class ShippingFee {

    private String totalShippingFee;

    public String getTotalShippingFee() {
        return totalShippingFee;
    }

    public void setTotalShippingFee(String totalShippingFee) {
        this.totalShippingFee = totalShippingFee;
    }

    public static class ShippingFeeInstance implements InstanceCreator<ShippingFee> {

        @Override
        public ShippingFee createInstance(Type type) {

            return new ShippingFee();
        }
    }
}
