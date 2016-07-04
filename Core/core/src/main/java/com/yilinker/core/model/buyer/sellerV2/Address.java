package com.yilinker.core.model.buyer.sellerV2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adur Urbano on 7/4/2016.
 */
public class Address {

    @SerializedName("title")
    private String title;
    @SerializedName("unitNumber")
    private String unitNumber;
    @SerializedName("buildingName")
    private String buildingName;
    @SerializedName("streetNumber")
    private String streetNumber;
    @SerializedName("streetName")
    private String streetName;
    @SerializedName("subdivision")
    private String subdivision;
    @SerializedName("zipCode")
    private String zipCode;
    @SerializedName("streetAddress")
    private String streetAddress;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("barangay")
    private String barangay;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("fullLocation")
    private String fullLocation;
    @SerializedName("landline")
    private String landLine;

    @SerializedName("userAddressId")
    private int userAddressId;
    @SerializedName("locationId")
    private int locationId;
    @SerializedName("provinceId")
    private int provinceId;
    @SerializedName("cityId")
    private int cityId;
    @SerializedName("barangayId")
    private int barangayId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getFullLocation() {
        return fullLocation;
    }

    public void setFullLocation(String fullLocation) {
        this.fullLocation = fullLocation;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public int getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(int userAddressId) {
        this.userAddressId = userAddressId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getBarangayId() {
        return barangayId;
    }

    public void setBarangayId(int barangayId) {
        this.barangayId = barangayId;
    }

}
