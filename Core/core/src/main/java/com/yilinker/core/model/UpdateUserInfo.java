package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.seller.Bank;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 8/17/2015.
 */
public class UpdateUserInfo {

    private int userId;
    private String profilePhoto;
    private String coverPhoto;
    private String storeName;
    private String storeDescription;
    private String contactNumber;
    private String email;
    private int productCount, transactionCount, messageCount;
    private String totalSales;
    private boolean isReseller;
    private String tin;
    private String fullName;
    private String firstName;
    private String lastName;

    private String referralCode;
    private String referrerCode;
    private String referrerName;

    private Bank bankAccount;
    private Address address;
    private CategoryList storeCategory;

    private boolean isEmailSubscribed, isSmsSubscribed;

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public String getTin() {
        return tin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Bank getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Bank bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public String getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
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
        this.isSmsSubscribed = isSmsSubscribed; }
    public boolean isReseller() {
        return isReseller;
    }

    public void setIsReseller(boolean isReseller) {
        this.isReseller = isReseller;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CategoryList getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(CategoryList storeCategory) {
        this.storeCategory = storeCategory;
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

    public static class UpdateUserInfoInstance implements InstanceCreator<UpdateUserInfo> {

        @Override
        public UpdateUserInfo createInstance(Type type) {

            return new UpdateUserInfo();
        }
    }
}
