package com.yilinker.core.base;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.helper.HurlCookieStack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;


/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private static BaseApplication instance;

    private static final String ACCESS_TOKEN = "accessToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String USER_FULLNAME = "fullname";
    private static final String KEEP_LOGGED_IN = "keepLoggedIn";

    private RequestQueue requestQueue;
    private String domain, clientId, clientSecret;

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

    public static String getClientIdFromApplication(){

        BaseApplication application = getInstance();

        return application.getClientId();

    }

    public static String getClientSecretFromApplication(){

        BaseApplication application = getInstance();

        return application.getClientSecret();

    }

    public String getDomain() {
        return domain;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


    public RequestQueue getRequestQueue() {

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlCookieStack(getApplicationContext()) {
                @Override
                protected HttpURLConnection createConnection(URL url) throws IOException {

                    if (url.getProtocol().equals("http"))
                        return super.createConnection(url);

                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) super.createConnection(url);

                    try {
                        httpsURLConnection.setSSLSocketFactory(SSLContext.getDefault().getSocketFactory());
                        httpsURLConnection.setHostnameVerifier(getHostnameVerifier());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return httpsURLConnection;
                }
            });
        }

        return requestQueue;
    }

    private HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                //return true;
//                HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
//                return hv.verify("localhost", session);
                return true;
            }
        };
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

        editor.commit();

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

            editor.apply();
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

}
