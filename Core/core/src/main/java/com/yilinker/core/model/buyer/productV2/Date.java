package com.yilinker.core.model.buyer.productV2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Adur Urbano on 7/1/2016.
 */
public class Date {

    @SerializedName("date")
    private String date;
    @SerializedName("timezone")
    private String timezone;

    @SerializedName("timezone_type")
    private int timezone_type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

}
