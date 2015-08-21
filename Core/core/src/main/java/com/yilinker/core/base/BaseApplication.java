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

    private static BaseApplication instance;

    private static final String ACCESS_TOKEN = "accessToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String USER_FULLNAME = "fullname";
    private static final String KEEP_LOGGED_IN = "keepLoggedIn";
    private static final String DELIVERY_ADDRESS = "deliveryAddress";
    private static final String DELIVERY_TITLE = "deliveryTitle";
    private static final String DEFAULT_PAYMENT_OPTION = "defaultPaymentOption";
    private static final String SAVE_PAYMENT_OPTION = "savePaymentOption";

    private RequestQueue requestQueue;
    private String domain;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }

    public static BaseApplication getInstance(){

        return instance;

    }

    public static String getDomainURL(){

        BaseApplication application = getInstance();

        return application.getDomain();

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

        return pref.getBoolean(KEEP_LOGGED_IN, false);
    }

    public void saveDeliveryAddress(String deliveryAddress, String deliveryTitle){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(DELIVERY_ADDRESS, deliveryAddress);
        editor.putString(DELIVERY_TITLE, deliveryTitle);

        editor.commit();
    }

    public String getDeliveryAddress(){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(DELIVERY_ADDRESS, null);
    }

    public String getDeliveryTitle(){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(DELIVERY_TITLE, null);

    }

    public void savePaymentOption(){
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(SAVE_PAYMENT_OPTION, true);

        editor.commit();
    }

    public void setDefaultPaymentOption(String defaultPaymentOption){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(DEFAULT_PAYMENT_OPTION, defaultPaymentOption);

        editor.commit();
    }

    public void deletePaymentOption(){
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.remove(DEFAULT_PAYMENT_OPTION);

        editor.commit();
    }

    public String getPaymentOption(){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.getString(DEFAULT_PAYMENT_OPTION, null);
    }

    public boolean isPaymentOptionSaved(){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        return pref.contains(SAVE_PAYMENT_OPTION);
    }

}
