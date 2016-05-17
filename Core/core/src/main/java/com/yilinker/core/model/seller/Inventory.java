package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by patVillanueva on 5/12/2016.
 */
public class Inventory {

    private final static String KEY_INVENTORY_PRODUCTS = "inventoryProducts";
    private final static  String KEY_TOTAL_ITEM_COUNT = "totalpage";

    @SerializedName(KEY_INVENTORY_PRODUCTS)
    private List<InventoryProduct> inventoryProducts;
    @SerializedName(KEY_TOTAL_ITEM_COUNT)
    private int totalPageCount;

    public List<InventoryProduct> getInventoryProducts() {
        return inventoryProducts;
    }

    public void setInventoryProducts(List<InventoryProduct> inventoryProducts) {
        this.inventoryProducts = inventoryProducts;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public static class InventoryInstance implements InstanceCreator<Inventory>{

        @Override
        public Inventory createInstance(Type type) {
            return new Inventory();
        }
    }
}
