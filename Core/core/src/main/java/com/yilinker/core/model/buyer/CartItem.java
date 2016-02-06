package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class CartItem {

    private static final String OBJ_NAME = "CartItem";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_SELECTED_ATTRIBUTES = "selectedAttributes";
    private static final String KEY_UNIT_ID = "unitId";
    private static final String KEY_QUANTITY = "quantity";

    private Product product;
    private List<Integer> selectedAttributes;
    private int unitId;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Integer> getSelectedAttributes() {
        return selectedAttributes;
    }

    public void setSelectedAttributes(List<Integer> selectedAttributes) {
        this.selectedAttributes = selectedAttributes;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //    @Override
//    public String toString() {
//        return OBJ_NAME + "[" + KEY_PRODUCT + product + ", " + KEY_UNIT_ID + unitId + ", " + KEY_QUANTITY + quantity + "]";
//    }

    public static class CartItemInstance implements InstanceCreator<CartItem> {

        @Override
        public CartItem createInstance(Type type) {

            return new CartItem();
        }
    }
}