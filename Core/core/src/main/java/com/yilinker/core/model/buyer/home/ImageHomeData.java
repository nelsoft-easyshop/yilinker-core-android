package com.yilinker.core.model.buyer.home;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class ImageHomeData extends HomeData {

    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static class HomeData1Instance implements InstanceCreator<ImageHomeData> {

        @Override
        public ImageHomeData createInstance(Type type) {
            return new ImageHomeData();
        }
    }

}
