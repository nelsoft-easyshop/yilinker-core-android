package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 8/26/2015.
 */
public class CityAddress {

        private int cityId;
        private String location;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

        public static class CityAddressInstance implements InstanceCreator<CityAddress> {

            @Override
            public CityAddress createInstance(Type type) {

                return new CityAddress();
            }
        }

}
