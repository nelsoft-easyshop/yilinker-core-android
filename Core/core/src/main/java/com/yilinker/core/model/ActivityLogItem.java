package com.yilinker.core.model;

/**
 * Created by Adur Urbano on 9/7/2015.
 */
public class ActivityLogItem {

    private Date date;
    private String type;
    private String text;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}