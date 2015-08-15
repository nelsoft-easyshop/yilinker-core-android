package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class Register {

    public final String OBJ_NAME = "Register";
    public final String KEY_IS_SUCCESS = "isSuccessful";
    public final String KEY_MESSAGE = "message";

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private boolean isSuccessful;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String toString(){
        return OBJ_NAME + "[" + KEY_IS_SUCCESS + isSuccessful + ", " + KEY_MESSAGE + message + "]";
//          return OBJ_NAME + "[" + KEY_AUTHTOKEN + authToken + ", " + KEY_REFRESHTOKEN +  refreshToken + "]";
    }

    public static class RegisterInstance implements InstanceCreator<Register> {

        @Override
        public Register createInstance(Type type) {

            return new Register();
        }
    }

}
