package com.yilinker.core.parsing;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by jaybryantc on 7/4/16.
 */
public class HomeTarget {

    @SerializedName(APIConstants.API_HOME_V2_TARGET_URL)
    private String targetUrl;
    @SerializedName(APIConstants.API_HOME_V2_TARGET_TYPE)
    private String targetType;
    @SerializedName(APIConstants.API_HOME_V2_TARGET_IS_AUTHENTICATED)
    private boolean isAuthenticated;

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public static class HomeTargetInstance implements InstanceCreator<HomeTarget> {

        @Override
        public HomeTarget createInstance(Type type) {
            return new HomeTarget();
        }
    }

}
