package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista on 3/18/16.
 */
public class AccreditationRequirementData {

    private int id;
    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static class AccreditationDataInstance implements InstanceCreator<AccreditationRequirementData> {

        @Override
        public AccreditationRequirementData createInstance(Type type) {

            return new AccreditationRequirementData();
        }
    }
}
