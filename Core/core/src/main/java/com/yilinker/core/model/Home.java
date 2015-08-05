package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/5/2015.
 */
public class Home {

    private static final String OBJ_NAME = "Home";
    private static final String KEY_FEATURED = "featured";
    private static final String KEY_HOT_ITEMS = "hotItems";
    private static final String KEY_NEW_ITEMS = "newItems";
    private static final String KEY_SELLERS = "sellers";

    private List<HomeSectionFeatured> featured;
    private List<HomeSectionHotItems> hotItems;
    private List<HomeSectionNewItems> newItems;
    private List<HomeSectionSellers> sellers;

    public List<HomeSectionFeatured> getFeatured() {
        return featured;
    }

    public void setFeatured(List<HomeSectionFeatured> featured) {
        this.featured = featured;
    }

    public List<HomeSectionHotItems> getHotItems() {
        return hotItems;
    }

    public void setHotItems(List<HomeSectionHotItems> hotItems) {
        this.hotItems = hotItems;
    }

    public List<HomeSectionNewItems> getNewItems() {
        return newItems;
    }

    public void setNewItems(List<HomeSectionNewItems> newItems) {
        this.newItems = newItems;
    }

    public List<HomeSectionSellers> getSellers() {
        return sellers;
    }

    public void setSellers(List<HomeSectionSellers> sellers) {
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