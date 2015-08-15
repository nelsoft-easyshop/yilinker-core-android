package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/7/2015.
 */
public class HomeSellerNewSellers {

    private static final String OBJ_NAME = "HomeSellerNewSellers";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE_URL = "image";
    private static final String KEY_TARGET = "target";

    private int userId;
    private String name;
    private String image;
    private String target;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return OBJ_NAME + "[" + KEY_USER_ID + userId + "," + KEY_NAME + name + "," + KEY_IMAGE_URL + image + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeSellerNewSellersInstance implements InstanceCreator<HomeSellerNewSellers> {

        @Override
        public HomeSellerNewSellers createInstance(Type type) {

            return new HomeSellerNewSellers();
        }
    }

}