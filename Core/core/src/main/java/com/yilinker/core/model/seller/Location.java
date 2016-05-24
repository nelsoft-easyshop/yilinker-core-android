package com.yilinker.core.model.seller;

import com.google.gson.annotations.SerializedName;

/**
 * Created by J.Bautista on 5/12/16.
 */
public class Location {

    private LocationItem country;
    private LocationItem province;
    private LocationItem city;
    private LocationItem barangay;
    @SerializedName("flag")
    private String flagImage;

    public LocationItem getCountry() {
        return country;
    }

    public void setCountry(LocationItem country) {
        this.country = country;
    }

    public LocationItem getProvince() {
        return province;
    }

    public void setProvince(LocationItem province) {
        this.province = province;
    }

    public LocationItem getCity() {
        return city;
    }

    public void setCity(LocationItem city) {
        this.city = city;
    }

    public LocationItem getBarangay() {
        return barangay;
    }

    public void setBarangay(LocationItem barangay) {
        this.barangay = barangay;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }
}
