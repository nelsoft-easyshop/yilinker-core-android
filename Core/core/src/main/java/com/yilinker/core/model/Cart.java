package com.yilinker.core.model;

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

    private List<CartItem> cartItem;
    private double total;

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CART_ITEM + cartItem + ", " + KEY_TOTAL + total + "]";
    }

    public static class CartInstance implements InstanceCreator<Cart> {

        @Override
        public Cart createInstance(Type type) {

            return new Cart();
        }
    }
}