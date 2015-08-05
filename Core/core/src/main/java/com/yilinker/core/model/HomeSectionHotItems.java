package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionHotItems {

    private static final String OBJ_NAME = "HomeSectionHotItems";
    private static final String KEY_TOP_BANNERS = "topBanners";
    private static final String KEY_TOP_PICKS = "topPicks";
    private static final String KEY_CATEGORIES = "categories";
    private static final String KEY_BOTTOM_BANNER = "bottomBanner";

    private List<HomeImageItems> topBanners;
    private List<HomeProductItems> topPicks;
    private List<HomeCategoryItems> categories;
    private List<HomeImageItems> bottomBanner;

    public List<HomeImageItems> getTopBanners() {
        return topBanners;
    }

    public void setTopBanners(List<HomeImageItems> topBanners) {
        this.topBanners = topBanners;
    }

    public List<HomeProductItems> getTopPicks() {
        return topPicks;
    }

    public void setTopPicks(List<HomeProductItems> topPicks) {
        this.topPicks = topPicks;
    }

    public List<HomeCategoryItems> getCategories() {
        return categories;
    }

    public void setCategories(List<HomeCategoryItems> categories) {
        this.categories = categories;
    }

    public List<HomeImageItems> getBottomBanner() {
        return bottomBanner;
    }

    public void setBottomBanner(List<HomeImageItems> bottomBanner) {
        this.bottomBanner = bottomBanner;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_TOP_BANNERS + topBanners + ", " + KEY_TOP_PICKS + topPicks + ", " + KEY_CATEGORIES + categories + ", " + KEY_BOTTOM_BANNER + bottomBanner + "]";
    }

    public static class HomeSectionHotItemsInstance implements InstanceCreator<HomeSectionHotItems> {

        @Override
        public HomeSectionHotItems createInstance(Type type) {

            return new HomeSectionHotItems();
        }
    }

}