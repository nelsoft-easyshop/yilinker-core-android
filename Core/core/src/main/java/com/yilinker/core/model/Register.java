package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class Register {

    public final String OBJ_NAME = "Register";
    public final String KEY_AUTHTOKEN = "authToken";
    public final String KEY_REFRESHTOKEN = "refreshToken";

    private String authToken, refreshToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String toString(){
        return OBJ_NAME + "[" + KEY_AUTHTOKEN + authToken + ", " + KEY_REFRESHTOKEN +  refreshToken + "]";
    }

    public static class RegisterInstance implements InstanceCreator<Register> {

        @Override
        public Register createInstance(Type type) {

            return new Register();
        }
    }

}
