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

    private List<CartItem> cartItems;
    private double total;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CART_ITEM + cartItems + ", " + KEY_TOTAL + total + "]";
    }

    public static class CartInstance implements InstanceCreator<Cart> {

        @Override
        public Cart createInstance(Type type) {

            return new Cart();
        }
    }
}