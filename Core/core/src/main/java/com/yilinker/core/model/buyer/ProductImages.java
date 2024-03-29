package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/15/15.
 */
public class ProductImages {

    private int id;
    private String imageLocation;
    private String fullImageLocation;
    private boolean isPrimary;
    private boolean isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setIsPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public static class ProductImagesInstance implements InstanceCreator<ProductImages> {

        @Override
        public ProductImages createInstance(Type type) {

            return new ProductImages();
        }
    }
}