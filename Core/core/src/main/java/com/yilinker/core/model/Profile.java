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
    private String referralCode;
    private String referrerCode;
    private String referrerName;
    private String totalPoints;

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
    private UserDocuments userDocuments;

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

    public void setEmailSubscribed(boolean emailSubscribed) {
        isEmailSubscribed = emailSubscribed;
    }

    public boolean isSmsSubscribed() {
        return isSmsSubscribed;
    }

    public void setSmsSubscribed(boolean smsSubscribed) {
        isSmsSubscribed = smsSubscribed;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public boolean isMobileVerified() {
        return isMobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        isMobileVerified = mobileVerified;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getReferrerCode() {
        return referrerCode;
    }

    public void setReferrerCode(String referrerCode) {
        this.referrerCode = referrerCode;
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserDocuments getUserDocuments() {
        return userDocuments;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setUserDocuments(UserDocuments userDocuments) {
        this.userDocuments = userDocuments;
    }

    public static class ProfileInstance implements InstanceCreator<Profile> {
        @Override
        public Profile createInstance(Type type) {
            return new Profile();
        }
    }

    public class UserDocuments {
        private int id;
        private String file;
        private com.yilinker.core.model.Date date;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public com.yilinker.core.model.Date getDate() {
            return date;
        }

        public void setDate(com.yilinker.core.model.Date date) {
            this.date = date;
        }
    }
}