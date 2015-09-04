package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Bryan on 9/1/2015.
 */
public class SubCategory implements Parcelable {
    private int categoryId;
    private String categoryName;
    private List<String> products;

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

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public SubCategory(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(categoryId);
        dest.writeString(categoryName);
        dest.writeStringList(products);
    }

    protected SubCategory(Parcel in) {
        categoryId = in.readInt();
        categoryName = in.readString();
        products = in.createStringArrayList();
    }

    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };

    public static class SubCategoryInstance implements InstanceCreator<SubCategory> {
        @Override
        public SubCategory createInstance(Type type) {
            return new SubCategory();
        }
    }
}
