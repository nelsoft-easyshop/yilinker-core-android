package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 8/26/2015.
 */
public class BaranggayAddress {

    private int barangayId;
    private String location;

    public int getBarangayId() {
        return barangayId;
    }

    public void setBarangayId(int barangayId) {
        this.barangayId = barangayId;
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

    public static class BaranggayAddressInstance implements InstanceCreator<BaranggayAddress> {

        @Override
        public BaranggayAddress createInstance(Type type) {

            return new BaranggayAddress();
        }
    }

}
