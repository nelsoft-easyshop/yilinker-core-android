package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionNewItems {

    private static final String OBJ_NAME = "HomeSectionNewItems";
    private static final String KEY_SHOP_BY_CATEGORIES = "shopByCategories";
    private static final String KEY_SHOP_BY_NEW_RELEASE = "shopByNewRelease";

    private List<HomeCategoryImageItems> shopByCategories = new ArrayList<>();
    private List<HomeProductItems> shopByNewRelease = new ArrayList<>();

    public List<HomeCategoryImageItems> getShopByCategories() {
        return shopByCategories;
    }

    public void setShopByCategories(List<HomeCategoryImageItems> shopByCategories) {
        this.shopByCategories = shopByCategories;
    }

    public List<HomeProductItems> getShopByNewRelease() {
        return shopByNewRelease;
    }

    public void setShopByNewRealese(List<HomeProductItems> shopByNewRealese) {
        this.shopByNewRelease = shopByNewRelease;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_SHOP_BY_CATEGORIES + shopByCategories + ", " + KEY_SHOP_BY_NEW_RELEASE + shopByNewRelease + "]";
    }

    public static class HomeSectionNewItemsInstance implements InstanceCreator<HomeSectionNewItems> {

        @Override
        public HomeSectionNewItems createInstance(Type type) {

            return new HomeSectionNewItems();
        }
    }

}