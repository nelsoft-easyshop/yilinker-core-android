package com.yilinker.core.model.seller.request;

/**
 * Created by patVillanueva on 5/12/2016.
 */
public class WarehouseUpdateInventory {

    private int warehouseId;
    private int productUnit;
    private int quantity;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(int productUnit) {
        this.productUnit = productUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
