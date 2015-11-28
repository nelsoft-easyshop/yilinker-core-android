package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 11/23/2015.
 */
public class Voucher {

    @SerializedName("less")
    private double discount;
    @SerializedName("origPrice")
    private double originalPrice;
    @SerializedName("voucherPrice")
    private double discountedPrice;

    public Voucher() {

    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public static class VoucherInstance implements InstanceCreator<Voucher> {

        @Override
        public Voucher createInstance(Type type) {
            return new Voucher();
        }
    }

}
