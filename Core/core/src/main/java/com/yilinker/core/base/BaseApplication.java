package com.yilinker.core.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.helper.FileHelper;

/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private static final String ACCESS_TOKEN = "accessToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String USER_FULLNAME = "fullname";
    private static final String KEEP_LOGGED_IN = "keepLoggedIn";

    private RequestQueue requestQueue;
    private String domain;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    public void saveToken(String accessToken, String refreshToken) {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(ACCESS_TOKEN, accessToken);
        editor.putString(REFRESH_TOKEN, refreshToken);

        editor.commit();
    }

    public void saveAccessToken(String accessToken) {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(ACCESS_TOKEN, accessToken);

        editor.commit();
    }

    public String getAccessToken() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(ACCESS_TOKEN, null);
    }


    public void saveRefreshToken(String refreshToken) {
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(REFRESH_TOKEN, refreshToken);

    }

    public String getRefreshToken() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(REFRESH_TOKEN, null);
    }


    // Saves the user name in shared pref
    public void saveFullName(String fullname) {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(USER_FULLNAME, fullname);

        editor.commit();

    }

    // Saves the user name in shared pref
    public String getFullName() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(USER_FULLNAME, null);

    }

    public void deleteTokens() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        if (pref.contains(ACCESS_TOKEN)) {
            SharedPreferences.Editor editor = pref.edit();

            editor.remove(ACCESS_TOKEN);
            editor.remove(REFRESH_TOKEN);
            editor.remove(USER_FULLNAME);

            editor.commit();
        }
    }

    // Check if a user is logged in
    public boolean isLoggedIn() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.contains(ACCESS_TOKEN);

    }

    public void keepUserLoggedIn(boolean loggedIn) {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        if(loggedIn == true) {
            editor.putBoolean(KEEP_LOGGED_IN, true);
        } else {
            editor.remove(KEEP_LOGGED_IN);
        }

        editor.commit();

    }

    public boolean isKeepUserLoggedIn() {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.contains(KEEP_LOGGED_IN);
    }

}
