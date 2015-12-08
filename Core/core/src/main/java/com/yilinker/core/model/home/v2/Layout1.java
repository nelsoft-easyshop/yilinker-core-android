package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 11/27/2015.
 */
public class Layout1 {

    @SerializedName(APIConstants.API_HOME_V2_IMAGE)
    private String image;
    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public static class Layout1Instance implements InstanceCreator<Layout1> {

        @Override
        public Layout1 createInstance(Type type) {
            return new Layout1();
        }
    }
}
