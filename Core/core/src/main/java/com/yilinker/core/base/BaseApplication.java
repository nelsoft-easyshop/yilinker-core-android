package com.yilinker.core.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yilinker.core.BuildConfig;
import com.yilinker.core.R;
import com.yilinker.core.helper.HurlCookieStack;
import com.yilinker.core.imageloader.ImageCacheManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyStore;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;


/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private static int DISK_IMAGECACHE_SIZE = 1024*1024*20;
    private static Bitmap.CompressFormat DISK_IMAGECACHE_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    private static int DISK_IMAGECACHE_QUALITY = 30;  //PNG is lossless so quality is ignored but must be provided

    private static BaseApplication instance;

    private static final String ACCESS_TOKEN = "accessToken";
    private static final String REFRESH_TOKEN = "refreshToken";
    private static final String USER_FULLNAME = "fullname";
    private static final String KEEP_LOGGED_IN = "keepLoggedIn";
    private static final String DOMAIN = "domain";

    private RequestQueue requestQueue;
    private String domain, clientId, clientSecret;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //initializes image cache manager
        ImageCacheManager.getInstance()
                .init(this,
                        getPackageCodePath(),
                        DISK_IMAGECACHE_SIZE,
                        DISK_IMAGECACHE_COMPRESS_FORMAT,
                        DISK_IMAGECACHE_QUALITY,
                        ImageCacheManager.CacheType.DISK);

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

        if(domain == null){

            SharedPreferences pref = PreferenceManager
                    .getDefaultSharedPreferences(getApplicationContext());

            domain = pref.getString(DOMAIN, null);
        }

        return domain;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setDomain(String domain) {

        saveDomain(domain);
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
                        httpsURLConnection.setSSLSocketFactory(newSslSocketFactory());
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

    private SSLSocketFactory newSslSocketFactory() {
        try {
            // Get an instance of the Bouncy Castle KeyStore format
            KeyStore trusted = KeyStore.getInstance("BKS");
            // Get the raw resource, which contains the keystore with
            // your trusted certificates (root and any intermediate certs)
            InputStream in = getResources().openRawResource(R.raw.yilinker); //name of your keystore file here
            try {
                // Initialize the keystore with the provided trusted certificates
                // Provide the password of the keystore
                trusted.load(in, "Passw0rd".toCharArray());
            } finally {
                in.close();
            }

            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(trusted);

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory sf = context.getSocketFactory();
            return sf;
        } catch (Exception e) {
            throw new AssertionError(e);
        }
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

    public void deleteSharedPrefs(Context context) {

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();

    }

    private void saveDomain(String domain){

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(DOMAIN, domain);

        editor.commit();
    }
}
