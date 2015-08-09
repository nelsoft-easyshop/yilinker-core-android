package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adur Urbano on 8/6/2015.
 */
public class HomeSellerAvatarItems {

    private static final String OBJ_NAME = "HomeSellerAvatarItems";
    private static final String KEY_SELLER_AVATAR = "sellerAvatar";
    private static final String KEY_SPECIALTY = "specialty";
    private static final String KEY_SELLER_NAME = "sellerName";
    private static final String KEY_TARGET = "target";
    private static final String KEY_IMAGES = "images";

    private String sellerAvatar;
    private String specialty;
    private String sellerName;
    private String target;
    private List<HomeImageLinkItems> images = new ArrayList<>();

    public String getSellerAvatar() {
        return sellerAvatar;
    }

    public void setSellerAvatar(String sellerAvatar) {
        this.sellerAvatar = sellerAvatar;
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

    public List<HomeImageLinkItems> getImages() {
        return images;
    }

    public void setImages(List<HomeImageLinkItems> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_SELLER_AVATAR + sellerAvatar + ", " + KEY_SPECIALTY + specialty + ", " + KEY_SELLER_NAME + sellerName + ", " + KEY_TARGET + target + ", " + KEY_IMAGES + images + "]";
    }

    public static class HomeSellerAvatarItemsInstance implements InstanceCreator<HomeSellerAvatarItems> {

        @Override
        public HomeSellerAvatarItems createInstance(Type type) {

            return new HomeSellerAvatarItems();
        }
    }

}