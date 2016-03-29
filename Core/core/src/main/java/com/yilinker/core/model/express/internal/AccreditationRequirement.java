package com.yilinker.core.model.express.internal;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by J.Bautista on 3/18/16.
 */
public class AccreditationRequirement {

    private String id;
    private String label;
    private int type;
    private String[] validation;
    private boolean isRequired;
    private List<AccreditationRequirementData> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getValidation() {
        return validation;
    }

    public void setValidation(String[] validation) {
        this.validation = validation;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public List<AccreditationRequirementData> getData() {
        return data;
    }

    public void setData(List<AccreditationRequirementData> data) {
        this.data = data;
    }

    public static class AccreditationRequirementInstance implements InstanceCreator<AccreditationRequirement> {

        @Override
        public AccreditationRequirement createInstance(Type type) {

            return new AccreditationRequirement();
        }
    }
}
