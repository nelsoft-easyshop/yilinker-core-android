package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSectionSellers {

    private static final String OBJ_NAME = "HomeSectionSellers";
    private static final String KEY_NEW_SELLERS = "newSellers";
    private static final String KEY_TOP_SELLERS = "topSellers";

    private List<HomeImageLinkItems> newSellers;
    private List<HomeSellerAvatarItems> topSellers;

    public List<HomeImageLinkItems> getNewSellers() {
        return newSellers;
    }

    public void setNewSellers(List<HomeImageLinkItems> newSellers) {
        this.newSellers = newSellers;
    }

    public List<HomeSellerAvatarItems> getTopSellers() {
        return topSellers;
    }

    public void setTopSellers(List<HomeSellerAvatarItems> topSellers) {
        this.topSellers = topSellers;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_NEW_SELLERS + newSellers + ", " + KEY_TOP_SELLERS + topSellers + "]";
    }

    public static class HomeSectionSellersInstance implements InstanceCreator<HomeSectionSellers> {

        @Override
        public HomeSectionSellers createInstance(Type type) {

            return new HomeSectionSellers();
        }
    }

}