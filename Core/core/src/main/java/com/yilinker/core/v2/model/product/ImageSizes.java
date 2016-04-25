package com.yilinker.core.v2.model.product;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.v2.constants.SerializedNames;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 4/21/2016.
 */
public class ImageSizes {

    @SerializedName(SerializedNames.THUMBNAIL)
    private String thumbnail;
    @SerializedName(SerializedNames.SMALL)
    private String small;
    @SerializedName(SerializedNames.MEDIUM)
    private String medium;
    @SerializedName(SerializedNames.LARGE)
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

    public static class ImageSizesInstance implements InstanceCreator<ImageSizes> {
        @Override
        public ImageSizes createInstance(Type type) {
            return new ImageSizes();
        }
    }
}
