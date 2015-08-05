package com.yilinker.core.interfaces;

/**
 * Created by J.Bautista
 */
public interface ResponseHandler<T> {

    public void onSuccess(int requestCode, T object);
    public void onFailed(int requestCode, String message);
}
