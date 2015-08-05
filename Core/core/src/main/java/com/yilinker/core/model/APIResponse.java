package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by wagnavu on 8/5/15.
 */
public class APIResponse {

    private static final String OBJ_NAME = "APIResponse";
    private static final String KEY_IS_SUCCESSFUL = "isSuccessful";
    private static final String KEY_DATA = "data";
    private static final String KEY_MESSAGE = "message";

    private boolean isSuccessful;
    private String data;
    private String message;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_IS_SUCCESSFUL + isSuccessful + KEY_DATA + data + KEY_MESSAGE + message + "]";
    }

    public static class APIResponseInstance implements InstanceCreator<APIResponse> {

        @Override
        public APIResponse createInstance(Type type) {

            return new APIResponse();
        }
    }
}
