package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class Cart {

    private static final String OBJ_NAME = "Cart";
    private static final String KEY_CART_ITEM = "cartItem";
    private static final String KEY_TOTAL = "total";
    private static final String KEY_TOTAL_AMOUNT = "totalAmount";

    private List<CartItem2> items;
    private double total;
    private String totalAmount;

    public List<CartItem2> getCartItems() {
        return items;
    }

    public void setCartItems(List<CartItem2> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CART_ITEM + items + ", " + KEY_TOTAL + total + "]";
    }

    public static class CartInstance implements InstanceCreator<Cart> {

        @Override
        public Cart createInstance(Type type) {

            return new Cart();
        }
    }
}