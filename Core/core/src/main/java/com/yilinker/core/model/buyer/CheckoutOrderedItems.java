package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/20/15.
 */
public class CheckoutOrderedItems {

    private String productName;
    private int quantity;
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static class CheckoutOrderedItemsInstance implements InstanceCreator<CheckoutOrderedItems>{

        @Override
        public CheckoutOrderedItems createInstance(Type type) {
            return new CheckoutOrderedItems();
        }
    }
}
