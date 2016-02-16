package com.yilinker.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bryan on 2/4/2016.
 */
public class AreaCode {

    private static final String KEY_ID = "id";
    private static final String KEY_AREA_CODE = "areaCode";

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_AREA_CODE)
    private String areaCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return areaCode;
    }
}
