package com.yilinker.core.model.buyer;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeCategoryProductItems implements Parcelable {

    private static final String OBJ_NAME = "HomeCategoryProductItems";
    private static final String KEY_CATEGORY_ID = "categoryId";
    private static final String KEY_CATEGORY_NAME = "categoryName";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_TARGET = "target";

    private int categoryId;
    private String categoryName;
    private String image;
    private String target;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_CATEGORY_ID + categoryId + ", " + KEY_CATEGORY_NAME + categoryName + ", " + KEY_IMAGE + image + ", " + KEY_TARGET + target + "]";
    }

    public static class HomeCategoryProductItemsInstance implements InstanceCreator<HomeCategoryProductItems> {

        @Override
        public HomeCategoryProductItems createInstance(Type type) {

            return new HomeCategoryProductItems();
        }
    }

    public HomeCategoryProductItems() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.categoryId);
        dest.writeString(this.categoryName);
        dest.writeString(this.image);
        dest.writeString(this.target);
    }

    protected HomeCategoryProductItems(Parcel in) {
        this.categoryId = in.readInt();
        this.categoryName = in.readString();
        this.image = in.readString();
        this.target = in.readString();
    }

    public static final Creator<HomeCategoryProductItems> CREATOR = new Creator<HomeCategoryProductItems>() {
        public HomeCategoryProductItems createFromParcel(Parcel source) {
            return new HomeCategoryProductItems(source);
        }

        public HomeCategoryProductItems[] newArray(int size) {
            return new HomeCategoryProductItems[size];
        }
    };
}
