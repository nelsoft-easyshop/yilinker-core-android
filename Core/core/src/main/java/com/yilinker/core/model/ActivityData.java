package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 9/5/2015.
 */
public class ActivityData {


    public static class ActivityDataInstance implements InstanceCreator<ActivityData> {

        @Override
        public ActivityData createInstance(Type type) {
            return new ActivityData();
        }

    }

}
