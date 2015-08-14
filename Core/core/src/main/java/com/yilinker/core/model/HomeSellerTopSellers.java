package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSellerTopSellers {

    private static final String OBJ_NAME = "HomeSellerTopSellers";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_SELLER_AVATAR = "image";
    private static final String KEY_SPECIALTY = "specialty";
    private static final String KEY_SELLER_NAME = "sellerName";
    private static final String KEY_TARGET = "target";
    private static final String KEY_PRODUCTS = "products";

    private int userId;
    private String image;
    private String specialty;
    private String sellerName;
    private String target;
    private List<HomeProductItems> products = new ArrayList<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<HomeProductItems> getProducts() {
        return products;
    }

    public void setProducts(List<HomeProductItems> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_USER_ID + userId + "," + KEY_SELLER_AVATAR + image + ", " + KEY_SPECIALTY + specialty + ", " + KEY_SELLER_NAME + sellerName + ", " + KEY_TARGET + target + ", " + KEY_PRODUCTS + products + "]";
    }

    public static class HomeSellerTopSellersInstance implements InstanceCreator<HomeSellerTopSellers> {

        @Override
        public HomeSellerTopSellers createInstance(Type type) {

            return new HomeSellerTopSellers();
        }
    }

}