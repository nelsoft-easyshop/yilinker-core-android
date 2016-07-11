package com.yilinker.core.model.buyer.home;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class FlashHomeLayout extends HomeLayout {

    /**
     * Some returned data on other layouts
     *
     */

    @SerializedName(APIConstants.API_HOME_V2_SALE_REMAINING_TIME)
    private String remainingTime;

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public static class FlashHomeLayoutInstance implements InstanceCreator<FlashHomeLayout> {

        @Override
        public FlashHomeLayout createInstance(Type type) {
            return new FlashHomeLayout();
        }

    }

}
