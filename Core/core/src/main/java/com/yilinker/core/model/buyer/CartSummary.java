package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista on 6/8/16.
 */
public class CartSummary {

        private List<CartItem2> items;
        private String totalShippingCost;
        @SerializedName("totalAmount")
        private String totalCost;
        @SerializedName("hasFlashSaleItem")
        private boolean hasSaleItems;

        public List<CartItem2> getItems() {
            return items;
        }

        public void setItems(List<CartItem2> items) {
            this.items = items;
        }

        public String getTotalShippingCost() {
            return totalShippingCost;
        }

        public void setTotalShippingCost(String totalShippingCost) {
            this.totalShippingCost = totalShippingCost;
        }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }


    public boolean hasSaleItems() {
        return hasSaleItems;
    }

    public void setIsVoucherAllowed(boolean isVoucherAllowed) {
        this.hasSaleItems = isVoucherAllowed;
    }

    public static class CartSummaryInstance implements InstanceCreator<CartSummary> {

            @Override
            public CartSummary createInstance(Type type) {

                return new CartSummary();
            }
        }

}
