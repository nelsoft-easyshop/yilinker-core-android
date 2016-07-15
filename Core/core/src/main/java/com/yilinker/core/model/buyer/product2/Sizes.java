package com.yilinker.core.model.buyer.product2;

import com.google.gson.annotations.SerializedName;

import static com.yilinker.core.constants.ProductAPIConstants.*;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Sizes {

    @SerializedName(KEY_THUMBNAIL)
    private String thumbnail;
    @SerializedName(KEY_SMALL)
    private String small;
    @SerializedName(KEY_MEDIUM)
    private String medium;
    @SerializedName(KEY_LARGE)
    private String large;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

}
