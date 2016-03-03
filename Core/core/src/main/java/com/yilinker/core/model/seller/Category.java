package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 2/23/16.
 */
public class Category {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    private boolean selected = true;

    public Category() {

    }

    public Category(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.selected = category.isSelected();
    }

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class CategoryInstance implements InstanceCreator<Category> {

        @Override
        public Category createInstance(Type type) {
            return new Category();
        }
    }

}
