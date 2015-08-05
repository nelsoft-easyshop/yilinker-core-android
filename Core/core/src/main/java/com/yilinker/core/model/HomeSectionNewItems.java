package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionNewItems {

    private static final String OBJ_NAME = "HomeSectionNewItems";
    private static final String KEY_SHOP_BY_CATEGORIES = "shopByCategories";
    private static final String KEY_SHOP_BY_NEW_RELEASE = "shopByNewRelease";

    private List<HomeCategoryImageItems> shopByCategories;
    private List<HomeProductItems> shopByNewRealese;

    public List<HomeCategoryImageItems> getShopByCategories() {
        return shopByCategories;
    }

    public void setShopByCategories(List<HomeCategoryImageItems> shopByCategories) {
        this.shopByCategories = shopByCategories;
    }

    public List<HomeProductItems> getShopByNewRealese() {
        return shopByNewRealese;
    }

    public void setShopByNewRealese(List<HomeProductItems> shopByNewRealese) {
        this.shopByNewRealese = shopByNewRealese;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_SHOP_BY_CATEGORIES + shopByCategories + ", " + KEY_SHOP_BY_NEW_RELEASE + shopByNewRealese + "]";
    }

    public static class HomeSectionNewItemsInstance implements InstanceCreator<HomeSectionNewItems> {

        @Override
        public HomeSectionNewItems createInstance(Type type) {

            return new HomeSectionNewItems();
        }
    }

}