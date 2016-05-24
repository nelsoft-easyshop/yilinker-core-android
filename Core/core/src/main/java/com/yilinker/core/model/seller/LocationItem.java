package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 5/12/16.
 */
public class LocationItem {

    @SerializedName("locationId")
    private int id;
    @SerializedName("location")
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

    public static class LocationItemInstance implements InstanceCreator<LocationItem> {

        @Override
        public LocationItem createInstance(Type type) {

            return new LocationItem();
        }
    }
}
