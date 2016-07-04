package com.yilinker.core.parsing;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;
import com.yilinker.core.model.home.v2.Target;

import java.util.List;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeLayout {
    /**
     * Usual response
     */

    @SerializedName(APIConstants.API_HOME_V2_LAYOUT_ID)
    private int layoutId;
    @SerializedName(APIConstants.API_HOME_V2_SECTION_TITLE)
    private String sectionTitle;
    @SerializedName(APIConstants.API_HOME_V2_VIEW_MORE_AVAILABLE)
    private boolean isViewMoreAvailable;
    @SerializedName(APIConstants.API_HOME_V2_VIEW_MORE_TARGET)
    private HomeTarget viewMoreTarget;
    @SerializedName(APIConstants.API_HOME_V2_DATA)
    private List<HomeData> data;

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


    public List<HomeData> getData() {
        return data;
    }

    public void setData(List<HomeData> data) {
        this.data = data;
    }


}
