package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Adur Urbano on 9/7/2015.
 */
public class ActivityLog {

    private List<ActivityLogItem> activities;
    private String count;

    public List<ActivityLogItem> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityLogItem> activities) {
        this.activities = activities;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public static class ActivityLogInstance implements InstanceCreator<ActivityLog> {

        @Override
        public ActivityLog createInstance(Type type) {

            return new ActivityLog();
        }
    }
}