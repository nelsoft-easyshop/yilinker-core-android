package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionFeatured {

    private static final String OBJ_NAME = "HomeSectionFeatured";
    private static final String KEY_MAIN_BANNER = "mainBanner";
    private static final String KEY_SUB_BANNER = "subBanners";
    private static final String KEY_PROMO = "promo";
    private static final String KEY_POPULAR_CATEGORIES = "popularCategories";
    private static final String KEY_TRENDING_ITEMS = "trendingItems";
    private static final String KEY_ITEMS_YOU_MAY_LIKE = "itemsYouMayLike";

    private List<HomeImageItems> mainBanner;
    private List<HomeImageItems> subBanners;
    private List<HomeProductItems> promo;
    private List<HomeCategoryImageItems> popularCategories;
    private List<HomeCategoryImageItems> trendingItems;
    private List<HomeProductItems> itemsYouMayLike;

    public List<HomeImageItems> getMainBanner() {
        return mainBanner;
    }

    public void setMainBanner(List<HomeImageItems> mainBanner) {
        this.mainBanner = mainBanner;
    }

    public List<HomeImageItems> getSubBanners() {
        return subBanners;
    }

    public void setSubBanners(List<HomeImageItems> subBanners) {
        this.subBanners = subBanners;
    }

    public List<HomeProductItems> getPromo() {
        return promo;
    }

    public void setPromo(List<HomeProductItems> promo) {
        this.promo = promo;
    }

    public List<HomeCategoryImageItems> getPopularCategories() {
        return popularCategories;
    }

    public void setPopularCategories(List<HomeCategoryImageItems> popularCategories) {
        this.popularCategories = popularCategories;
    }

    public List<HomeCategoryImageItems> getTrendingItems() {
        return trendingItems;
    }

    public void setTrendingItems(List<HomeCategoryImageItems> trendingItems) {
        this.trendingItems = trendingItems;
    }

    public List<HomeProductItems> getItemsYouMayLike() {
        return itemsYouMayLike;
    }

    public void setItemsYouMayLike(List<HomeProductItems> itemsYouMayLike) {
        this.itemsYouMayLike = itemsYouMayLike;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_MAIN_BANNER + mainBanner + ", " + KEY_SUB_BANNER + subBanners + ", " + KEY_PROMO + promo + ", " + KEY_POPULAR_CATEGORIES + popularCategories + ", " + KEY_TRENDING_ITEMS + trendingItems + ", " + KEY_ITEMS_YOU_MAY_LIKE + itemsYouMayLike + "]";
    }

    public static class HomeSectionFeaturedInstance implements InstanceCreator<HomeSectionFeatured> {

        @Override
        public HomeSectionFeatured createInstance(Type type) {

            return new HomeSectionFeatured();
        }
    }

}