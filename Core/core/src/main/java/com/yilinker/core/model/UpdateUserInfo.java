package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.seller.Bank;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 8/17/2015.
 */
public class UpdateUserInfo {

    private String profilePhoto;
    private String coverPhoto;
    private String storeName;
    private String storeDescription;
    private String contactNumber;
    private String email;

    private int productCount, transactionCount;
    private String totalSales;

    private Bank bankAccount;
    private Address address;

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

    public static class UpdateUserInfoInstance implements InstanceCreator<UpdateUserInfo> {

        @Override
        public UpdateUserInfo createInstance(Type type) {

            return new UpdateUserInfo();
        }
    }
}
