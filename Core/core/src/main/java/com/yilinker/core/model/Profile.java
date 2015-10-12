package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by Adur Urbano on 8/17/2015.
 */
public class Profile {

    private int userId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String profileImageUrl;
    private String coverPhoto;
    private String gender;
    private String birthDate;
    private int transactionCount;
    private int wishlistCount;
    private int cartCount;
    private int messageCount;
    private int followingCount;
    private boolean isEmailSubscribed;
    private boolean isSmsSubscribed;
    private boolean isEmailVerified;
    private boolean isMobileVerified;
    private Address address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public int getWishlistCount() {
        return wishlistCount;
    }

    public void setWishlistCount(int wishlistCount) {
        this.wishlistCount = wishlistCount;
    }

    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public boolean isEmailSubscribed() {
        return isEmailSubscribed;
    }

    public void setIsEmailSubscribed(boolean isEmailSubscribed) {
        this.isEmailSubscribed = isEmailSubscribed;
    }

    public boolean isSmsSubscribed() {
        return isSmsSubscribed;
    }

    public void setIsSmsSubscribed(boolean isSmsSubscribed) {
        this.isSmsSubscribed = isSmsSubscribed;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class ProfileInstance implements InstanceCreator<Profile> {
        @Override
        public Profile createInstance(Type type) {
            return new Profile();
        }
    }
}