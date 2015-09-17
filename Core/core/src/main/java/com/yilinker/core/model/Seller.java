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

    private String specialty;/***missing*/
    private String contactNumber;/***images*/
    private Address storeAddress;
    private int id;/***sellerId*/
    private String profilePhoto;
    private String coverPhoto;
    private boolean isFollowed;
    private String storeName;
    private String storeDescription;
    private String fullName;
    private String gender;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContactNo() {
        return contactNumber;
    }

    public void setContactNo(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Address getAddress() {
        return storeAddress;
    }

    public void setAddress(Address storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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