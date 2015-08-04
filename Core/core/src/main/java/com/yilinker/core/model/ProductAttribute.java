package com.yilinker.core.model;

/**
 * Created by J.Bautista
 */
public class ProductAttribute {

    private static final String OBJ_NAME = "ProductAttribute";
    private static final String KEY_NAME = "name";
    private static final String KEY_ID = "id";

    private int id;
    private String name;

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

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_ID + id + ", " + KEY_NAME + name + "]";
    }
}
