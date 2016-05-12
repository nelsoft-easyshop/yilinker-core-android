package com.yilinker.core.model.seller;

import com.google.gson.annotations.SerializedName;

/**
 * Created by patVillanueva on 5/12/2016.
 */
public class InventoryFilterProductGroup {

    private final static String KEY_USER_PRODUT_GROUP_ID = "userProductGroupId";
    private final static String KEY_NAME = "name";

    @SerializedName(KEY_USER_PRODUT_GROUP_ID)
    private int groupId;
    @SerializedName(KEY_NAME)
    private String groupName;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
