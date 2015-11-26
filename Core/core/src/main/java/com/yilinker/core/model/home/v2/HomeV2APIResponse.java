package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 11/25/2015.
 */
public class HomeV2APIResponse<T> {

    @SerializedName(APIConstants.API_HOME_V2_LAYOUT_ID)
    private int layoutId;
    @SerializedName(APIConstants.API_HOME_V2_SECTION_TITLE)
    private String sectionTitle;
    @SerializedName(APIConstants.API_HOME_V2_VIEW_MORE_AVAILABLE)
    private boolean isViewMoreAvailable;
    @SerializedName(APIConstants.API_HOME_V2_VIEW_MORE_TARGET)
    private Target viewMoreTarget;
    @SerializedName(APIConstants.API_HOME_V2_DATA)
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

    public Target getViewMoreTarget() {
        return viewMoreTarget;
    }

    public void setViewMoreTarget(Target viewMoreTarget) {
        this.viewMoreTarget = viewMoreTarget;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class HomeV2APIResponseInstance<T> implements InstanceCreator<HomeV2APIResponse<T>> {

        @Override
        public HomeV2APIResponse<T> createInstance(Type type) {

            return new HomeV2APIResponse<>();
        }
    }
}