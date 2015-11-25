package com.yilinker.core.model.home.v2;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;
import com.yilinker.core.constants.APIConstants;

import java.lang.reflect.Type;

/**
 * Created by Adur Urbano on 11/25/2015.
 */
public class Target {

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

    public static class TargetInstance implements InstanceCreator<Target> {

        @Override
        public Target createInstance(Type type) {
            return new Target();
        }
    }
}