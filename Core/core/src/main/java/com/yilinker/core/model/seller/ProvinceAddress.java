package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 8/19/2015.
 */
public class ProvinceAddress {

    private int provinceId;
    private String location;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
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

    public static class ProvinceAddressInstance implements InstanceCreator<ProvinceAddress> {

        @Override
        public ProvinceAddress createInstance(Type type) {

            return new ProvinceAddress();
        }
    }
}
