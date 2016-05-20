package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista on 5/18/16.
 */
public class InventoryProductFilter {

    private List<InventoryProductFilterItem> status;
    private List<InventoryProductFilterItem> categories;
    private List<InventoryProductFilterItem> productGroups;

    public List<InventoryProductFilterItem> getStatus() {
        return status;
    }

    public void setStatus(List<InventoryProductFilterItem> status) {
        this.status = status;
    }

    public List<InventoryProductFilterItem> getCategories() {
        return categories;
    }

    public void setCategories(List<InventoryProductFilterItem> categories) {
        this.categories = categories;
    }

    public List<InventoryProductFilterItem> getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(List<InventoryProductFilterItem> productGroups) {
        this.productGroups = productGroups;
    }

    public static class InventoryProductFilterInstance implements InstanceCreator<InventoryProductFilter> {

        @Override
        public InventoryProductFilter createInstance(Type type) {

            return new InventoryProductFilter();
        }
    }
}
