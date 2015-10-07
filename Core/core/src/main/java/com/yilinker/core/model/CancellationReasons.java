package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 9/17/15.
 */
public class CancellationReasons {

    private static final String KEY_CANCEL_ID = "id";
    private static final String KEY_CANCEL_REASON = "reason";
    private static final String KEY_DESCRIPTION = " description";

    @SerializedName(KEY_CANCEL_ID)
    private int id;
    @SerializedName(KEY_CANCEL_REASON)
    private String reason;
    @SerializedName(KEY_DESCRIPTION)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return reason;
    }


    public static class CancellationReasonsInstance implements InstanceCreator<CancellationReasons> {

        @Override
        public CancellationReasons createInstance(Type type) {

            return new CancellationReasons();
        }
    }
}
