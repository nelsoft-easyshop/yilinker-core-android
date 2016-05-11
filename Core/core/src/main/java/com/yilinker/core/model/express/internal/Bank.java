package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by patrick-villanueva on 4/7/2016.
 */
public class Bank {

    private String bank_name;
    private String account_number;
    private String account_name;
    private String logo;

    public static class BankInstance implements InstanceCreator<Bank> {

        @Override
        public Bank createInstance(Type type) {

            return new Bank();
        }
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
