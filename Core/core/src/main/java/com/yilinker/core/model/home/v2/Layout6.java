package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 27/11/2015.
 */
public class Layout6<T> {

    private String image;
    private List<T> data;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class Layout6Instance implements InstanceCreator<Layout6>{

        @Override
        public Layout6 createInstance(Type type) {
            return new Layout6();
        }
    }
}
