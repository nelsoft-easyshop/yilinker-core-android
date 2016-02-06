package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class ProductGroupAttribute {

    private static final String OBJ_NAME = "ProductGroupAttribute";
    private static final String KEY_ID = "productUnitId";
    private static final String KEY_NAME = "name";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_CHOICES = "choices";

    private int id;
    private String groupName;

    private int selectedAttributeId;
    private List<ProductAttribute> items;
    @SerializedName(KEY_CHOICES)
    private List<String> choices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return groupName;
    }

    public void setName(String groupName) {
        this.groupName = groupName;
    }

    public List<ProductAttribute> getItems() {
        return this.items;
    }

    public void setItems(List<ProductAttribute> items) {
        this.items = items;
    }

    public int getSelectedAttributeId() {
        return selectedAttributeId;
    }

    public void setSelectedAttributeId(int selectedAttributeId) {
        this.selectedAttributeId = selectedAttributeId;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_ID + id + ", " + KEY_NAME + groupName + KEY_ITEMS + items + "]";
    }

    public static class ProductGroupAttributeInstance implements InstanceCreator<ProductGroupAttribute> {

        @Override
        public ProductGroupAttribute createInstance(Type type) {

            return new ProductGroupAttribute();
        }
    }
}
