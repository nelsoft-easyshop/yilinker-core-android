package com.yilinker.core.model;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by rlcoronado on 8/8/15.
 */
public class Login {

    public final String OBJ_NAME = "Login";
    public final String KEY_ACCESS_TOKEN = "access_token";
    public final String KEY_EXPIRES_IN = "expires_in";
    public final String KEY_TOKEN_TYPE = "token_type";
    public final String KEY_SCOPE = "scope";
    public final String KEY_REFRESH_TOKEN = "refresh_token";


    private String access_token, expires_in, token_type, scope, refresh_token;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;

    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return OBJ_NAME + "[" + KEY_ACCESS_TOKEN + access_token + ", " + KEY_EXPIRES_IN + expires_in + ", " + KEY_TOKEN_TYPE + token_type + ", " + KEY_SCOPE + scope + ", " + KEY_REFRESH_TOKEN + refresh_token + "]";
    }

    public static class LoginInstance implements InstanceCreator<Login> {

        @Override
        public Login createInstance(Type type) {

            return new Login();
        }
    }
}
