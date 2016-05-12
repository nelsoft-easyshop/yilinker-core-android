package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by patVillanueva on 5/12/2016.
 */
public class InventoryFilter {

    private final static String KEY_PRODUCT_STATUSES = "status";
    private final static String KEY_CATEGORIES = "categories";
    private final static String KEY_PRODUCT_GROUPS = "productGroups";


    @SerializedName(KEY_CATEGORIES)
    private List<Category> categories;
    @SerializedName(KEY_PRODUCT_STATUSES)
    private List<InventoryFilterStatus> statuses;
    @SerializedName(KEY_PRODUCT_GROUPS)
    private List<InventoryFilterProductGroup> groups;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<InventoryFilterStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<InventoryFilterStatus> statuses) {
        this.statuses = statuses;
    }

    public List<InventoryFilterProductGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<InventoryFilterProductGroup> groups) {
        this.groups = groups;
    }

    public static class InventoryFilterInstance implements InstanceCreator<InventoryFilter>{

        @Override
        public InventoryFilter createInstance(Type type) {
            return new InventoryFilter();
        }
    }
}
