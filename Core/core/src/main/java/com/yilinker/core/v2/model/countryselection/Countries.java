package com.yilinker.core.v2.model.countryselection;

import com.google.gson.InstanceCreator;
import com.yilinker.core.model.home.v2.Target;

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
    private boolean isActive;
    private Language defaultLanguage;
    private String flag;
    private Target target;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public static class CountriesInstance implements InstanceCreator<Countries> {

        @Override
        public Countries createInstance(Type type) {
            return new Countries();
        }
    }
}
