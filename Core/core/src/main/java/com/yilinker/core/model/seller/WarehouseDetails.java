package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 5/13/16.
 */
public class WarehouseDetails {

    private int id;
    private String name;
    private String address;
    private boolean isDelete;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public static class WarehouseDetailsInstance implements InstanceCreator<WarehouseDetails> {

        @Override
        public WarehouseDetails createInstance(Type type) {

            return new WarehouseDetails();
        }
    }
}
