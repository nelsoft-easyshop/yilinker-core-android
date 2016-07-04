package com.yilinker.core.parsing;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeData1 extends HomeData {

    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static class HomeData1Instance implements InstanceCreator<HomeData1> {

        @Override
        public HomeData1 createInstance(Type type) {
            return new HomeData1();
        }
    }

}
