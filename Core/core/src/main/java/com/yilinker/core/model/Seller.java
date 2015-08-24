package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista
 */
public class Seller {

    private static final String OBJ_NAME = "Seller";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SPECIALTY = "specialty";
    private static final String KEY_LOGO_URL = "logoURl";
    private static final String KEY_IMAGES = "images";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_CONTACT_NO = "contactNo";

    private int sellerId;
    private String fullName;
    private String storeName;
    private String profileImageUrl;
    private boolean isFollowed;
    private String dateFollowed;

    private String specialty;
    private List<String> images;
    private String description;
    private String contactNo;

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

    public String getDateFollowed() {
        return dateFollowed;
    }

    public void setDateFollowed(String dateFollowed) {
        this.dateFollowed = dateFollowed;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    //    @Override
//    public String toString() {
//        return OBJ_NAME + "[" + KEY_ID + id + ", " + KEY_NAME + name + ", " + KEY_SPECIALTY + specialty + ", " + KEY_LOGO_URL + logoUrl + ", " + KEY_IMAGES + images + ", " + KEY_DESCRIPTION + description + ", " + KEY_CONTACT_NO + contactNo + "]";
//    }

    public static class SellerInstance implements InstanceCreator<Seller> {

        @Override
        public Seller createInstance(Type type) {

            return new Seller();
        }
    }
}
