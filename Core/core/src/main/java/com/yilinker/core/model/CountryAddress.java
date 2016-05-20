package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 5/13/16.
 */
public class CountryAddress {

    private int countryId;
    private String location;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return location;
    }

    public static class CountryAddressInstance implements InstanceCreator<CountryAddress> {

        @Override
        public CountryAddress createInstance(Type type) {

            return new CountryAddress();
        }
    }
}
