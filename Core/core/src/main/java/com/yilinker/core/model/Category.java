package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 8/17/2015.
 */
public class Category {

    private int productCategoryId;
    private String name;
    private String hasChildren;
    private String image;

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public static class CategoryInstance implements InstanceCreator<Category> {

        @Override
        public Category createInstance(Type type) {

            return new Category();
        }
    }
}
