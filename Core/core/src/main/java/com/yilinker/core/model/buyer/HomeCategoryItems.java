package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeCategoryItems {

    private static final String OBJ_NAME = "HomeCategoryItems";
    private static final String KEY_CATEGORY_NAME = "categoryName";
    private static final String KEY_LAYOUT_ID = "layoutId";
    private static final String KEY_VIEW_MORE_TARGET = "viewMoreTarget";
    private static final String KEY_IMAGES = "images";

    private String categoryName;
    private String layoutId;
    private String viewMoreTarget;
    private List<HomeCategoryProductItems> images = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public String getViewMoreTarget() {
        return viewMoreTarget;
    }

    public void setViewMoreTarget(String viewMoreTarget) {
        this.viewMoreTarget = viewMoreTarget;
    }

    public List<HomeCategoryProductItems> getImages() {
        return images;
    }

    public void setImages(List<HomeCategoryProductItems> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CATEGORY_NAME + categoryName + ", " + KEY_LAYOUT_ID + layoutId + ", " + KEY_VIEW_MORE_TARGET + viewMoreTarget + ", " + KEY_IMAGES + images + "]";
    }

    public static class HomeCategoryItemsInstance implements InstanceCreator<HomeCategoryItems> {

        @Override
        public HomeCategoryItems createInstance(Type type) {

            return new HomeCategoryItems();
        }
    }

}