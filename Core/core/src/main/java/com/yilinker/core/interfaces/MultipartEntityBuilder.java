package com.yilinker.core.interfaces;

import org.apache.http.HttpEntity;

/**
 * Created by J.Bautista
 */
public interface MultipartEntityBuilder<T> {

    public HttpEntity buildEntity(T objects);
}
