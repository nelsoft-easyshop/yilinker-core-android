package com.yilinker.core.base;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private RequestQueue requestQueue;
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }
    public void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue(){

        return this.requestQueue;
    }

}
