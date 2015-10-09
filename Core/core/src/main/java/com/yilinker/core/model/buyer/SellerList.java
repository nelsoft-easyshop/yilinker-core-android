package com.yilinker.core.model.buyer;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.Category;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Patrick on 10/8/2015.
 */
public class SellerList {


    private String description;
    private String image;
    private List<Product> products;
    private int userId;
    private boolean isFollowed;
//    private Category specialty;
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

//    public Category getSpecialty() {
//        return specialty;
//    }
//
//    public void setSpecialty(Category specialty) {
//        this.specialty = specialty;
//    }

    public static class SellerListInstance implements InstanceCreator<SellerList> {

        @Override
        public SellerList createInstance(Type type) {

            return new SellerList();
        }
    }
}
