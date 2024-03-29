package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 8/17/2015.
 */
public class CategoryList {

    private List<Category> categories;


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static class CategoryListInstance implements InstanceCreator<CategoryList> {

        @Override
        public CategoryList createInstance(Type type) {

            return new CategoryList();
        }
    }
}
