package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista on 5/17/16.
 */
public class InventoryProductList {

    private List<InventoryProduct> inventoryProducts;
    private int totalpage;

    public List<InventoryProduct> getInventoryProducts() {
        return inventoryProducts;
    }

    public void setInventoryProducts(List<InventoryProduct> inventoryProducts) {
        this.inventoryProducts = inventoryProducts;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public static class InventoryProductListInstance implements InstanceCreator<InventoryProductList> {

        @Override
        public InventoryProductList createInstance(Type type) {
            return new InventoryProductList();
        }
    }
}
