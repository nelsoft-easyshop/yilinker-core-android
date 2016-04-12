package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by patrick-villanueva on 4/7/2016.
 */
public class Bank {

    private int id;
    private String bankName;
    private String accountNumber;
    private String accountName;
    private String bankLogoURL;

    public static class BankInstance implements InstanceCreator<Bank> {

        @Override
        public Bank createInstance(Type type) {

            return new Bank();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAcountName() {
        return accountName;
    }

    public void setAcountName(String acountName) {
        this.accountName = acountName;
    }

    public String getLogoURL() {
        return bankLogoURL;
    }

    public void setLogoURL(String logoURL) {
        this.bankLogoURL = logoURL;
    }
}
