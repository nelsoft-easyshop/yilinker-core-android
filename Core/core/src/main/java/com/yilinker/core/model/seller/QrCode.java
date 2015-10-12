package com.yilinker.core.model.seller;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by Bryan on 10/12/2015.
 */
public class QrCode {

    private String qrcodeUrl;

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public static class QrCodeInstance implements InstanceCreator<QrCode> {

        @Override
        public QrCode createInstance(Type type) {
            return new QrCode();
        }

    }
}
