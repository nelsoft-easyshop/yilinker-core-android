package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista on 5/10/16.
 */
public class CheckoutCart {

    private List<CartItem2> items;
    private double totalShippingCost;

    public List<CartItem2> getItems() {
        return items;
    }

    public void setItems(List<CartItem2> items) {
        this.items = items;
    }

    public double getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(double totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }

    public static class CheckoutCartInstance implements InstanceCreator<CheckoutCart> {

        @Override
        public CheckoutCart createInstance(Type type) {

            return new CheckoutCart();
        }
    }
}
