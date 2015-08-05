package com.yilinker.core.interfaces;

/**
 * Created by J.Bautista
 */
public interface ResponseHandler {

    public void onSuccess(int requestCode, Object object);
    public void onFailed(int requestCode, String message);
}
