package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by rlcoronado on 27/11/2015.
 */
public class Layout6 {

    private String image;
    private Target target;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Target getData() {
        return target;
    }

    public void setData(Target target) {
        this.target = target;
    }

    public static class Layout6Instance implements InstanceCreator<Layout6>{

        @Override
        public Layout6 createInstance(Type type) {
            return new Layout6();
        }
    }
}
