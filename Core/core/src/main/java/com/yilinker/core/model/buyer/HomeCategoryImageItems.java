package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeCategoryImageItems {

    private static final String OBJ_NAME = "HomeCategoryImageItems";
    private static final String KEY_CATEGORY_IMAGE = "categoryImage";
    private static final String KEY_TARGET = "target";


    private String categoryImage;
    private String target;

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CATEGORY_IMAGE + categoryImage + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeCategoryImageItemsInstance implements InstanceCreator<HomeCategoryImageItems> {

        @Override
        public HomeCategoryImageItems createInstance(Type type) {

            return new HomeCategoryImageItems();
        }
    }

}