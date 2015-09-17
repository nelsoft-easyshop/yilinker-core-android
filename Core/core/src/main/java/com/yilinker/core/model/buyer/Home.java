package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class Home {

    private static final String OBJ_NAME = "Home";
    private static final String KEY_FEATURED = "featured";
    private static final String KEY_HOT_ITEMS = "hotItems";
    private static final String KEY_NEW_ITEMS = "newItems";
    private static final String KEY_SELLERS = "sellers";

    private HomeSectionFeatured featured;
    private HomeSectionHotItems hotItems;
    private HomeSectionNewItems newItems;
    private HomeSectionSellers sellers;

    public HomeSectionFeatured getFeatured() {
        return featured;
    }

    public void setFeatured(HomeSectionFeatured featured) {
        this.featured = featured;
    }

    public HomeSectionHotItems getHotItems() {
        return hotItems;
    }

    public void setHotItems(HomeSectionHotItems hotItems) {
        this.hotItems = hotItems;
    }

    public HomeSectionNewItems getNewItems() {
        return newItems;
    }

    public void setNewItems(HomeSectionNewItems newItems) {
        this.newItems = newItems;
    }

    public HomeSectionSellers getSellers() {
        return sellers;
    }

    public void setSellers(HomeSectionSellers sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_FEATURED + featured + ", " + KEY_HOT_ITEMS + hotItems + ", " + KEY_NEW_ITEMS + newItems + ", " + KEY_SELLERS + sellers + "]";
    }

    public static class HomeInstance implements InstanceCreator<Home> {

        @Override
        public Home createInstance(Type type) {

            return new Home();
        }
    }

}