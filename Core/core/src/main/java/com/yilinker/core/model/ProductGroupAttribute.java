package com.yilinker.core.model;

/**
 * Created by J.Bautista
 */
public class ProductGroupAttribute {

    private static final String OBJ_NAME = "ProductGroupAttribute";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

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
