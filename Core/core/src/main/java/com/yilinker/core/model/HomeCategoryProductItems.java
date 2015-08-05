package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeCategoryProductItems {

    private static final String OBJ_NAME = "HomeCategoryProductItems";
    private static final String KEY_PRODUCT_NAME = "productName";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_TARGET = "target";

    private String productName;
    private String image;
    private String target;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_PRODUCT_NAME + productName + ", " + KEY_IMAGE + image + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeCategoryProductItemsInstance implements InstanceCreator<HomeCategoryProductItems> {

        @Override
        public HomeCategoryProductItems createInstance(Type type) {

            return new HomeCategoryProductItems();
        }
    }

}
