package com.yilinker.core.parsing;

import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

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

}
