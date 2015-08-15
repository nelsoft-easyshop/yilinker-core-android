package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeImageLinkItems {

    private static final String OBJ_NAME = "HomeImageLinkItems";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_LINK = "link";

    private String image;
    private String link;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IMAGE + image + ", " + KEY_LINK + link + "]";
    }

    public static class HomeImageLinkItemsInstance implements InstanceCreator<HomeImageLinkItems> {

        @Override
        public HomeImageLinkItems createInstance(Type type) {

            return new HomeImageLinkItems();
        }
    }

}