package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by patVillanueva on 5/11/2016.
 */
public class InventoryProduct {

    private final static String KEY_PRODUCT_UNIT_ID = "productUnitId";
    private final static String KEY_NAME = "name";
    private final static String KEY_SKU = "sku";
    private final static String KEY_QUANTITY = "quantity";

    @SerializedName(KEY_PRODUCT_UNIT_ID)
    private int productUnitId;
    @SerializedName(KEY_NAME)
    private String name;
    @SerializedName(KEY_SKU)
    private String sku;
    @SerializedName(KEY_QUANTITY)
    private String quantity;

    public int getProductUnitId() {
        return productUnitId;
    }

    public void setProductUnitId(int productUnitId) {
        this.productUnitId = productUnitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public static class InventoryProductInstance implements InstanceCreator<InventoryProduct> {

        @Override
        public InventoryProduct createInstance(Type type) {
            return new InventoryProduct();
        }
    }
}
