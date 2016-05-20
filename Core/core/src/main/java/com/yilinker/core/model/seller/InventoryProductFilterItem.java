package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 5/18/16.
 */
public class InventoryProductFilterItem {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class InventoryProductFilterItemInstance implements InstanceCreator<InventoryProductFilterItem> {

        @Override
        public InventoryProductFilterItem createInstance(Type type) {

            return new InventoryProductFilterItem();
        }
    }
}
