package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 27/11/2015.
 */
public class Layout5<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class Layout5Instance implements InstanceCreator<Layout5>{

        @Override
        public Layout5 createInstance(Type type) {
            return new Layout5();
        }
    }
}
