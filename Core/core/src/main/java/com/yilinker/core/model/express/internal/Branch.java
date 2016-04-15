package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 4/11/16.
 */
public class Branch {

    private String name;
    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class BranchInstance implements InstanceCreator<Branch> {

        @Override
        public Branch createInstance(Type type) {

            return new Branch();
        }
    }
}
