package com.yilinker.core.base;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by J.Bautista
 */
public class BaseApplication extends Application{

    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue(){

        return this.requestQueue;
    }

}
