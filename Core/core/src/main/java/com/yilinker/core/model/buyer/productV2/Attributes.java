package com.yilinker.core.model.buyer.productV2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Attributes {

    @SerializedName("id")
    private String id;
    @SerializedName("groupName")
    private String groupName;

    @SerializedName("items")
    private List<Items> items;
    @SerializedName("choices")
    private List<String> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public class Items {

        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}