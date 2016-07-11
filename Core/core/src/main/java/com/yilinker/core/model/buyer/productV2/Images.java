package com.yilinker.core.model.buyer.productV2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Images {

    @SerializedName("id")
    private String id;
    @SerializedName("raw")
    private String raw;
    @SerializedName("imageLocation")
    private String imageLocation;
    @SerializedName("fullImageLocation")
    private String fullImageLocation;
    @SerializedName("defaultLocale")
    private String defaultLocale;

    @SerializedName("isPrimary")
    private boolean isPrimary;
    @SerializedName("isDeleted")
    private boolean isDeleted;

    @SerializedName("sizes")
    private Sizes sizes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
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

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
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

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

}
