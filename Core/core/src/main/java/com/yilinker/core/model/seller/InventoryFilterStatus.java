package com.yilinker.core.model.seller;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patVillanueva on 5/12/2016.
 */
public class InventoryFilterStatus {

    private final static String KEY_STATUS_ID = "statusId";
    private final static String KEY_STATUS_NAME = "statusName";

    @SerializedName(KEY_STATUS_ID)
    private int id;
    @SerializedName(KEY_STATUS_NAME)
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
}
