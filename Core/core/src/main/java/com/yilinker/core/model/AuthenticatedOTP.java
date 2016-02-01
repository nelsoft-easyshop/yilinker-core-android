package com.yilinker.core.model;

import com.google.gson.InstanceCreator;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;

/**
 * Created by Patrick on 2/1/2016.
 */
public class AuthenticatedOTP {

    private final static String KEY_SENT_TO = "sentTo";
    private final static String KEY_SENT_ON = "sentOn";
    private final static String KEY_PROVIDER = "provider";
    private final static String KEY_EXPIRATION = "expiration";

    @SerializedName(KEY_SENT_TO)
    private String sentTo;
    @SerializedName(KEY_SENT_ON)
    private String sentOn;
    @SerializedName(KEY_PROVIDER)
    private String provider;
    @SerializedName(KEY_EXPIRATION)
    private String expiration;

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public String getSentOn() {
        return sentOn;
    }

    public void setSentOn(String sentOn) {
        this.sentOn = sentOn;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public static class AuthenticatedOTPInstance implements InstanceCreator<AuthenticatedOTP> {

        @Override
        public AuthenticatedOTP createInstance(Type type) {
            return new AuthenticatedOTP();
        }

    }

}
