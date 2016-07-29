package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/25/15.
 */
public class ProductCartItem {
    private String price;
    private String discountedPrice;
    private double discount;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static class ProductCartItemInstance implements InstanceCreator<ProductCartItem>{

        @Override
        public ProductCartItem createInstance(Type type) {
            return new ProductCartItem();
        }
    }
}
