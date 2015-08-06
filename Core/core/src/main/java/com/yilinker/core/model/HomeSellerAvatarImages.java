package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/7/2015.
 */
public class HomeSellerAvatarImages {

    private static final String OBJ_NAME = "HomeSellerAvatarImages";
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_TARGET = "target";

    private String imageUrl;
    private String target;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGE_URL + imageUrl + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeSellerAvatarImagesInstance implements InstanceCreator<HomeSellerAvatarItems> {

        @Override
        public HomeSellerAvatarItems createInstance(Type type) {

            return new HomeSellerAvatarItems();
        }
    }

}