package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 5/11/16.
 */
public class Warehouse {

    private WarehouseDetails warehouse;
    private Location location;

    public WarehouseDetails getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDetails warehouse) {
        this.warehouse = warehouse;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class WarehouseInstance implements InstanceCreator<Warehouse> {

        @Override
        public Warehouse createInstance(Type type) {

            return new Warehouse();
        }
    }
}
