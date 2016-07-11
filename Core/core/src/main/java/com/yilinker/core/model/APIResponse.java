package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by J.Bautista
 */
public class APIResponse<T> {

    private static final String OBJ_NAME = "APIResponse";
    private static final String KEY_IS_SUCCESSFUL = "isSuccessful";
    private static final String KEY_DATA = "data";
    private static final String KEY_MESSAGE = "message";

    private boolean isSuccessful;
    private T data;
    private String message;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

    public static class APIResponseInstance<T> implements InstanceCreator<APIResponse<T>> {

        @Override
        public APIResponse<T> createInstance(Type type) {

            return new APIResponse<T>();
        }
    }


}
