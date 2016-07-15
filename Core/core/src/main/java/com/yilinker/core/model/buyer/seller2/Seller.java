package com.yilinker.core.model.buyer.seller2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import static com.yilinker.core.constants.SellerDetailsAPIConstants.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 7/4/2016.
 */
public class Seller {

    @SerializedName(KEY_FULL_NAME)
    private String fullName;
    @SerializedName(KEY_FIRST_NAME)
    private String firstName;
    @SerializedName(KEY_LAST_NAME)
    private String lastName;
    @SerializedName(KEY_EMAIL)
    private String email;
    @SerializedName(KEY_GENDER)
    private String gender;
    @SerializedName(KEY_NICKNAME)
    private String nickname;
    @SerializedName(KEY_CONTACT_NUMBER)
    private String contactNumber;
    @SerializedName(KEY_SPECIALTY)
    private String specialty;
    @SerializedName(KEY_BIRTH_DATE)
    private String birthDate;
    @SerializedName(KEY_STORE_NAME)
    private String storeName;
    @SerializedName(KEY_STORE_DESCRIPTION)
    private String storeDescription;
    @SerializedName(KEY_PROFILE_PHOTO)
    private String profilePhoto;
    @SerializedName(KEY_COVER_PHOTO)
    private String coverPhoto;
    @SerializedName(KEY_TIN)
    private String tin;
    @SerializedName(KEY_REFERRAL_CODE)
    private String referralCode;
    @SerializedName(KEY_REFERRER_CODE)
    private String referrerCode;
    @SerializedName(KEY_REFERRER_NAME)
    private String referrerName;

    @SerializedName(KEY_USER_ID)
    private int userId;

    @SerializedName(KEY_IS_FOLLOWED)
    private boolean isFollowed;
    @SerializedName(KEY_IS_AFFILIATE)
    private boolean isAffiliate;

    @SerializedName(KEY_STORE_ADDRESS)
    private Address storeAddress;

    @SerializedName(KEY_PRODUCTS)
    private List<Product> products;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public boolean isAffiliate() {
        return isAffiliate;
    }

    public void setAffiliate(boolean affiliate) {
        isAffiliate = affiliate;
    }

    public Address getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(Address storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public class Product {

        @SerializedName(KEY_PRODUCT_ID)
        private String productId;
        @SerializedName(KEY_PRODUCT_NAME)
        private String productName;
        @SerializedName(KEY_ORIGINAL_PRICE)
        private String originalPrice;
        @SerializedName(KEY_NEW_PRICE)
        private String newPrice;
        @SerializedName(KEY_IMAGE_URL)
        private String imageUrl;

        @SerializedName(KEY_DISCOUNT)
        private double discount;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(String newPrice) {
            this.newPrice = newPrice;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

    }

    public static class SellerInstance implements InstanceCreator<Seller> {

        @Override
        public Seller createInstance(Type type) {

            return new Seller();

        }

    }

}
