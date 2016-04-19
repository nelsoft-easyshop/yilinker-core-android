package com.yilinker.core.v2.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 4/18/2016.
 */
public class Countries {

    private int countryId;
    private String name;
    private String code;
    private String domain;
    private String area_code;
    private Language defaultLanguage;
    private boolean isActive;
    private String flag;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static class CountriesInstance implements InstanceCreator<Countries> {

        @Override
        public Countries createInstance(Type type) {
            return new Countries();
        }
    }
}
