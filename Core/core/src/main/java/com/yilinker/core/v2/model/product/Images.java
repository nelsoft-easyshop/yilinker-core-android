package com.yilinker.core.v2.model.product;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.v2.constants.SerializedNames;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 4/21/2016.
 */
public class Images {

    @SerializedName(SerializedNames.ID)
    private String id;
    @SerializedName(SerializedNames.IMAGE_LOCATION)
    private String imageLocation;
    @SerializedName(SerializedNames.FULL_IMAGE_LOCATION)
    private String fullImageLocation;
    @SerializedName(SerializedNames.IS_PRIMARY)
    private boolean isPrimary;
    @SerializedName(SerializedNames.IS_DELETED)
    private boolean isDeleted;
    @SerializedName(SerializedNames.SIZES)
    private ImageSizes sizes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getFullImageLocation() {
        return fullImageLocation;
    }

    public void setFullImageLocation(String fullImageLocation) {
        this.fullImageLocation = fullImageLocation;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ImageSizes getSizes() {
        return sizes;
    }

    public void setSizes(ImageSizes sizes) {
        this.sizes = sizes;
    }

    public static class ImagesInstance implements InstanceCreator<Images> {
        @Override
        public Images createInstance(Type type) {
            return new Images();
        }
    }
}
