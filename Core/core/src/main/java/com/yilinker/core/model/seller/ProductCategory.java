package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 5/12/16.
 */
public class ProductCategory {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("parent")
    private int parent;
    @SerializedName("description")
    private String description;
    @SerializedName("hasChildren")
    private boolean hasChildren;

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

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public static class ProductCategoryInstance implements InstanceCreator<ProductCategory> {

        @Override
        public ProductCategory createInstance(Type type) {
            return new ProductCategory();
        }

    }

}
