package com.yilinker.core.model.buyer.product2;

import com.google.gson.annotations.SerializedName;

import static com.yilinker.core.constants.ProductAPIConstants.*;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Images {

    @SerializedName(KEY_ID)
    private String id;
    @SerializedName(KEY_RAW)
    private String raw;
    @SerializedName(KEY_IMAGE_LOCATION)
    private String imageLocation;
    @SerializedName(KEY_FULL_IMAGE_LOCATION)
    private String fullImageLocation;
    @SerializedName(KEY_DEFAULT_LOCALE)
    private String defaultLocale;

    @SerializedName(KEY_IS_PRIMARY)
    private boolean isPrimary;
    @SerializedName(KEY_IS_DELETED)
    private boolean isDeleted;

    @SerializedName(KEY_SIZES)
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
