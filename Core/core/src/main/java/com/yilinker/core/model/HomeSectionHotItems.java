package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionHotItems {

    private static final String OBJ_NAME = "HomeSectionHotItems";
    private static final String KEY_TOP_BANNERS = "topbanners";
    private static final String KEY_TOP_PICKS = "toppicks";
    private static final String KEY_CATEGORIES = "categories";
    private static final String KEY_BOTTOM_BANNER = "bottomBanners";

    private List<HomeImageItems> topbanners;
    private List<HomeProductItems> toppicks;
    private List<HomeCategoryItems> categories;
    private List<HomeImageItems> bottomBanners;

    public List<HomeImageItems> getTopBanners() {
        return topbanners;
    }

    public void setTopBanners(List<HomeImageItems> topBanners) {
        this.topbanners = topbanners;
    }

    public List<HomeProductItems> getTopPicks() {
        return toppicks;
    }

    public void setTopPicks(List<HomeProductItems> topPicks) {
        this.toppicks = toppicks;
    }

    public List<HomeCategoryItems> getCategories() {
        return categories;
    }

    public void setCategories(List<HomeCategoryItems> categories) {
        this.categories = categories;
    }

    public List<HomeImageItems> getBottomBanner() {
        return bottomBanners;
    }

    public void setBottomBanners(List<HomeImageItems> bottomBanners) {
        this.bottomBanners = bottomBanners;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_TOP_BANNERS + topbanners + ", " + KEY_TOP_PICKS + toppicks + ", " + KEY_CATEGORIES + categories + ", " + KEY_BOTTOM_BANNER + bottomBanners + "]";
    }

    public static class HomeSectionHotItemsInstance implements InstanceCreator<HomeSectionHotItems> {

        @Override
        public HomeSectionHotItems createInstance(Type type) {

            return new HomeSectionHotItems();
        }
    }

}