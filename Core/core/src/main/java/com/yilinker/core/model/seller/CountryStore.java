package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by patVillanueva on 5/24/2016.
 */
public class CountryStore {

    private int countryId;
    private String name;
    private String code;
    private String domain;
    private String flag;
    private boolean isAvailable;
    private Currency currency;
    private Currency defaultLanguage;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return code;
    }

    public void setCountryCode(String countryCode) {
        this.code = countryCode;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(Currency defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public  static class CountryStoreInstance implements InstanceCreator<CountryStore> {

        @Override
        public CountryStore createInstance(Type type) {
            return new CountryStore();
        }
    }

}
