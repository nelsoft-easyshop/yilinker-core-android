package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Bryan on 9/1/2015.
 */
public class SubCategoryUpload implements Parcelable, Serializable {
    private int categoryId;
    private String categoryName;
    private List<CategoryProducts> products;
    private int parentId;
    /***for buyer app vendor page*/
    private String name;


    public SubCategoryUpload(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryProducts> getProducts() {
        return products;
    }

    public void setProducts(List<CategoryProducts> products) {
        this.products = products;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(categoryId);
        dest.writeString(categoryName);
    }

    protected SubCategoryUpload(Parcel in) {
        categoryId = in.readInt();
        categoryName = in.readString();
    }

    public static final Creator<SubCategoryUpload> CREATOR = new Creator<SubCategoryUpload>() {
        @Override
        public SubCategoryUpload createFromParcel(Parcel in) {
            return new SubCategoryUpload(in);
        }

        @Override
        public SubCategoryUpload[] newArray(int size) {
            return new SubCategoryUpload[size];
        }
    };

    public static class SubCategoryInstance implements InstanceCreator<SubCategoryUpload> {
        @Override
        public SubCategoryUpload createInstance(Type type) {
            return new SubCategoryUpload();
        }
    }
}
