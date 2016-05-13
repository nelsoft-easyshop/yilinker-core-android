package com.yilinker.core.model.seller.request;

/**
 * Created by J.Bautista on 5/12/16.
 */
public class Warehouse {

    private int id;
    private String name;
    private String address;
    private int selectedLocation;
    private String zipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(int selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
