package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeImageItems {

    private static final String OBJ_NAME = "HomeImageItems";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_TARGET = "target";
    private static final String KEY_TARGET_TYPE = "targetType";

    private String image;
    private String target;
    private String targetType;

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

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGE + image + ", " + KEY_TARGET + target + ", " + KEY_TARGET_TYPE + targetType + "]";
    }

    public static class HomeImageItemsInstance implements InstanceCreator<HomeImageItems> {

        @Override
        public HomeImageItems createInstance(Type type) {

            return new HomeImageItems();
        }
    }

}