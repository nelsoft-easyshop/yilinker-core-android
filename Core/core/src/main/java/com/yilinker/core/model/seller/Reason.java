package com.yilinker.core.model.seller;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jaybr_000 on 9/10/2015.
 */
public class Reason {

    private static final String REASON_ID = "id";
    private static final String REASON = "reason";
    private static final String REASON_DESCRIPTION = "description";

    @SerializedName(REASON_ID)
    private int id;
    @SerializedName(REASON)
    private String reason;
    @SerializedName(REASON_DESCRIPTION)
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

    public static class ReasonInstance implements InstanceCreator<Reason> {

        @Override
        public Reason createInstance(Type type) {
            return new Reason();
        }

    }

}
