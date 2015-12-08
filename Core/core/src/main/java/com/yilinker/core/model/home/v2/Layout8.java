package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by jaybr_000 on 11/27/2015.
 */
public class Layout8 {

    @SerializedName(APIConstants.API_HOME_V2_TARGET)
    private Target target;
    @SerializedName(APIConstants.API_HOME_V2_CATEGORY)
    private Category category;

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public class Category {

        @SerializedName(APIConstants.API_HOME_V2_NAME)
        private String name;
        @SerializedName(APIConstants.API_HOME_V2_IMAGE)
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class Layout8Instance implements InstanceCreator<Layout8> {

        @Override
        public Layout8 createInstance(Type type) {
            return new Layout8();
        }
    }


}
