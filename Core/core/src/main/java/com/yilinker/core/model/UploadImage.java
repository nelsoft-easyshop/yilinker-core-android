package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 2/19/2016.
 */
public class UploadImage {

    private static final String KEY_USER_IMAGE_ID = "userImageId";
    private static final String KEY_FILE_NAME = "fileName";
    private static final String KEY_RAW = "raw";
    private static final String KEY_THUMBNAIL = "thumbnail";
    private static final String KEY_SMALL = "small";
    private static final String KEY_MEDIUM = "medium";
    private static final String KEY_LARGE = "large";

    @SerializedName(KEY_USER_IMAGE_ID)
    private int userImageId;
    @SerializedName(KEY_FILE_NAME)
    private String fileName;
    @SerializedName(KEY_RAW)
    private String raw;
    @SerializedName(KEY_THUMBNAIL)
    private String thumbnail;
    @SerializedName(KEY_SMALL)
    private String small;
    @SerializedName(KEY_MEDIUM)
    private String medium;
    @SerializedName(KEY_LARGE)
    private String large;

    public int getUserImageId() {
        return userImageId;
    }

    public void setUserImageId(int userImageId) {
        this.userImageId = userImageId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

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

    public static class UploadImageInstance implements InstanceCreator<UploadImage> {

        @Override
        public UploadImage createInstance(Type type) {

            return new UploadImage();

        }

    }
}
