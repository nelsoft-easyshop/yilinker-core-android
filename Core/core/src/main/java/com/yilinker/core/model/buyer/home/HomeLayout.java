package com.yilinker.core.model.buyer.home;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.HomeAPIConstants;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeLayout<T> {

    /**
     * Usual response
     */
    @SerializedName(HomeAPIConstants.KEY_LAYOUT_ID)
    private int layoutId;
    @SerializedName(HomeAPIConstants.KEY_SECTION_TITLE)
    private String sectionTitle;
    @SerializedName(HomeAPIConstants.KEY_IS_VIEW_MORE_AVAILABLE)
    private boolean isViewMoreAvailable;
    @SerializedName(HomeAPIConstants.KEY_VIEW_MORE_TARGET)
    private HomeTarget viewMoreTarget;
    @SerializedName(HomeAPIConstants.KEY_DATA)
    private List<T> data;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public boolean isViewMoreAvailable() {
        return isViewMoreAvailable;
    }

    public void setIsViewMoreAvailable(boolean isViewMoreAvailable) {
        this.isViewMoreAvailable = isViewMoreAvailable;
    }

    public void setViewMoreAvailable(boolean viewMoreAvailable) {
        isViewMoreAvailable = viewMoreAvailable;
    }

    public HomeTarget getViewMoreTarget() {
        return viewMoreTarget;
    }

    public void setViewMoreTarget(HomeTarget viewMoreTarget) {
        this.viewMoreTarget = viewMoreTarget;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class HomeLayoutInstance implements InstanceCreator<HomeLayout<HomeData>> {

        @Override
        public HomeLayout<HomeData> createInstance(Type type) {
            return new HomeLayout<>();
        }

    }

    public static class PromoHomeLayoutInstance implements InstanceCreator<HomeLayout<HomeLayout<HomeData>>> {

        @Override
        public HomeLayout<HomeLayout<HomeData>> createInstance(Type type) {
            return new HomeLayout<>();
        }
    }

}
